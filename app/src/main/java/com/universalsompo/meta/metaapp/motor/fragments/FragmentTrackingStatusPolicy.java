package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.adapters.PolicyStatusAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.ClaimStatusPolicy;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentTrackingStatusPolicy extends Fragment implements ResponseListener {
    private RecyclerView rcv_bookedpolicy;
    private TextView no_data;
    final ArrayList<ClaimStatusPolicy> data1 = new ArrayList<>();
    List<ClaimStatusPolicy> claimstatusModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meta_own_policy_claim_status, container, false);
        rcv_bookedpolicy = v.findViewById(R.id.rv_booked_policy);
        no_data= v.findViewById(R.id.no_data);
        claimstatusModel = new ArrayList<>();
        init();
        return v;
    }

    void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.CLAIM_STATUS_POLICY, this, RequestConstants.CLAIM_STATUS_POLICY);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.CLAIM_STATUS_POLICY) {
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("PolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data1.add(
                                new ClaimStatusPolicy(
                                        obj.optString("ClaimNo"),
                                        obj.optString("ExpiryDate"),
                                        obj.optString("InsuredName"),
                                        obj.optString("InsurerName"),
                                        obj.optString("Make"),
                                        obj.optString("Model"),
                                        obj.optString("PolicyId"),
                                        obj.optString("PolicyNumber"),
                                        obj.optString("Variant"),
                                        obj.optString("VechileRegNo"),
                                        obj.optString("VechileType")
                                )
                        );
                    }
                    if (data1.size() == 0) {
                        AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                        addPolicy.showAlertDialogForPolicy(getActivity(),"No claim filed please add a policy.");
                    } else {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        rcv_bookedpolicy.setLayoutManager(layoutManager);
                        PolicyStatusAdapter ownPolicyAdapter1 = new PolicyStatusAdapter(getActivity(), data1);
                        rcv_bookedpolicy.setAdapter(ownPolicyAdapter1);
                        no_data.setVisibility(View.GONE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                addPolicy.showAlertDialogForPolicy(getActivity(),"No claim filed please add a policy.");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
