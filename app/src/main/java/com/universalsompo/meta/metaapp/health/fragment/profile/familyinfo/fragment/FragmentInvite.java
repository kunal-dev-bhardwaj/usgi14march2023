package com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.adapter.FamilyAdapter1;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.model.FamilyModel1;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentInvite extends Fragment implements ResponseListener {
    private View myView;
    private SelectorListener binder;
    private ListView list;
    private TextView no_data;
    private FamilyAdapter1 familyAdapter1;
    ArrayList<FamilyModel1> data1 = new ArrayList<>();
    private MySharedPreference prefrences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_family_info, container, false);
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return myView;
    }

    private void init(){
        list = myView.findViewById(R.id.list);
        no_data= myView.findViewById(R.id.no_data);

        getfamilydetails();
    }

    public void getfamilydetails() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("UserID", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_FAMILY_DETAILS, this, RequestHealthConstants.GET_FAMILY_DETAILS);
        req.execute();
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (object.optString("Message").equals("Success")){
            if (Tag == RequestHealthConstants.GET_FAMILY_DETAILS) {
                list.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("FamilyDetails");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data1.add(
                                new FamilyModel1(
                                        obj.optString("FamilyName"),
                                        obj.optString("MobileNo"),
                                        obj.optString("UserFamilyId")
                                )
                        );
                    }
                    familyAdapter1 = new FamilyAdapter1(getActivity(), data1);
                    list.setAdapter(familyAdapter1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            list.setVisibility(View.GONE);
            no_data.setText(object.optString("Message"));
            no_data.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
