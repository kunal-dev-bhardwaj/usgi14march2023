package com.universalsompo.meta.metaapp.motor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.adapters.MotorHelp3Adapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.MotorHelp;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentMotorHelp3 extends Fragment implements ResponseListener {
    private View v;
    private ListView select_issue1;
    private TextView no_data;
    private final ArrayList<MotorHelp> data = new ArrayList<>();
    private String name, id_help1, id_help2, id_help3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_motor_help1, container, false);
        assert getArguments() != null;
        name = getArguments().getString("name");
        id_help1 = getArguments().getString("id_help1");
        id_help2 = getArguments().getString("id_help2");
        id_help3 = getArguments().getString("id_help3");
        init();
        return v;
    }

    private void init() {
        TextView category_name = v.findViewById(R.id.category_name);
        select_issue1 = v.findViewById(R.id.select_issue1);
        no_data = v.findViewById(R.id.no_data);

        category_name.setText(name);
        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
            object.put("CategoryID", id_help3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_HELP3, this, RequestConstants.GET_HELP3);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_HELP3){
            new AppDataPushApi().callApi(getActivity(),"Help","Help page","User facing problem in " + id_help1 + " -> " + id_help2 + " -> " + id_help3);
            if (object.optString("Message").equals("Success")){
                select_issue1.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("HelpCategoryRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new MotorHelp(
                                        obj.optString("CategoryName"),
                                        obj.optString("ID")
                                )
                        );
                    }

                    MotorHelp3Adapter helpAdapter = new MotorHelp3Adapter(getActivity(), data, id_help1, id_help2, id_help3);
                    select_issue1.setAdapter(helpAdapter);
                    no_data.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                select_issue1.setVisibility(View.GONE);
                no_data.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
