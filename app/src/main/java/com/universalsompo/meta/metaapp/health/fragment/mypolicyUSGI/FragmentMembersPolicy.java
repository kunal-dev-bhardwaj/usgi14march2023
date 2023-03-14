package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyMemberListAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyMemberListModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentMembersPolicy extends Fragment implements ResponseListener {
    private View v;
    private MySharedPreference prefrences;
    private RecyclerView rcv_memberlist;
    private TextView no_data;
    private final ArrayList<MyMemberListModel> data1 = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_health_member_tab, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        initView();
        return v;
    }

    private void initView() {
        rcv_memberlist = v.findViewById(R.id.rcv_memberlist);
        no_data= v.findViewById(R.id.no_data);
        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("Uid", prefrences.getUID());
            object.put("PolicyID", prefrences.getPolicy_id_health());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlHealthConstants.UNIVERSAL_GET_MEMBER_LIST, this, RequestHealthConstants.UNIVERSAL_GET_MEMBER_LIST);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (object.optString("Message").equals("Success")) {
            if (Tag == RequestHealthConstants.UNIVERSAL_GET_MEMBER_LIST) {
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("UnivSompoHealthPolicyMemberList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data1.add(
                                new MyMemberListModel(
                                        obj.optString("Age"),
                                        obj.optString("CoverageDetails"),
                                        obj.optString("Date_Of_Birth"),
                                        obj.optString("E_Card_URL"),
                                        obj.optString("Exclusions"),
                                        obj.optString("Name"),
                                        obj.optString("PolicyURL"),
                                        obj.optString("RelationShip")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    rcv_memberlist.setLayoutManager(layoutManager);
                    MyMemberListAdapter ownMemberListAdapter1 = new MyMemberListAdapter(getActivity(), data1, prefrences);
                    rcv_memberlist.setAdapter(ownMemberListAdapter1);
                    no_data.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            no_data.setText("No Members Included");
            no_data.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
