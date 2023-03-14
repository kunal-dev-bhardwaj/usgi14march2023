package com.universalsompo.meta.metaapp.health.fragment.help.fragment;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.help.adapter.HelpAdapter;
import com.universalsompo.meta.metaapp.health.fragment.help.model.Help;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Objects;

public class FragmentHelp extends Fragment implements ResponseListener {
    private View v;
    private ListView select_issue;
    private TextView no_data;
    private final ArrayList<Help> data = new ArrayList<>();
    private MySharedPreference pref;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_help, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        init();
        callApi();
        return v;
    }

    private void init() {
        select_issue =  v.findViewById(R.id.select_issue);
        no_data=  v.findViewById(R.id.no_data);
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("Uid",pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_HELP, this, RequestHealthConstants.GET_HELP);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_HELP){
            new AppDataPushApi().callApi(getActivity(),"Help","Help page","User visited to help page");
            if (object.optString("Message").equals("Success")){
                select_issue.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("HelpCategoryRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new Help(
                                        obj.optString("CategoryName"),
                                        obj.optString("ID")
                                )
                        );
                    }
                    HelpAdapter helpAdapter = new HelpAdapter(getActivity(), data);
                    select_issue.setAdapter(helpAdapter);
                    no_data.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                select_issue.setVisibility(View.GONE);
                no_data.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}