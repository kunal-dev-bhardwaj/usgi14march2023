package com.universalsompo.meta.metaapp.motor.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimPolicyCallModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class FragmentClaimPolicyCall extends Fragment implements ResponseListener {
    private TextView comp_title;
    private TextView helpLIne;
    private MySharedPreference pref;
    private String InsComp;
    private String contactNo;
    private String VehicleType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.claim_policy_call, container, false);
        TextView call = v.findViewById(R.id.call);
        pref = MySharedPreference.getInstance(getActivity());

        assert getArguments() != null;
        VehicleType=getArguments().getString("v_type");
        String coveragedetails = getArguments().getString("CoverageDetails");
        comp_title = v.findViewById(R.id.comp_title);
        helpLIne = v.findViewById(R.id.helpLIne);
        TextView test = v.findViewById(R.id.textt);
        InsComp = pref.getINSkey();
        call.setOnClickListener(v1 -> {
            contactNo=helpLIne.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + contactNo));
            startActivity(intent);
            hitApiCallClaimTrue();
        });
        hitApi();
        if (coveragedetails != null) {
            StringTokenizer tokenizer = new StringTokenizer(coveragedetails, ",");
            while (tokenizer.hasMoreTokens()) {
                test.append("\u25CF" + " " + tokenizer.nextToken());
                test.append("\n");
            }
        }
        return v;
    }

    private void hitApi() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("InsCompId", InsComp);
            object.put("VehicleType", VehicleType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_COVERAGE_DETAIL, this, RequestConstants.GET_COVERAGE_DETAIL);
        req.execute();
    }

    private void hitApiCallClaimTrue() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("policyId", pref.getPID());
            object.put("VehicleType", VehicleType);

        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.CALL_CLAIM_TRUE, this, RequestConstants.CALL_CLAIM_TRUE);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_COVERAGE_DETAIL ) {
            new AppDataPushApi().callApi(getActivity(),"Claim","Claim Call","Covergae details loaded");
            if(object.optString("Message").equals("Success")) {
                JSONArray arr;
                ArrayList<ClaimPolicyCallModel> data = new ArrayList<>();
                try {
                    arr = object.getJSONArray("CoverageDetails");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(new ClaimPolicyCallModel(obj.optString("InsCompNo"),
                                obj.optString("Title"),
                                obj.optString("Description"),
                                obj.optString("CoverageId"), obj.optString("InsCompName")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                comp_title.setText(data.get(0).getInsCompName());
                helpLIne.setText(data.get(0).getInsCompNo());
                // recyclerView.setAdapter(new ClaimPolicyCallAdapter(getActivity(), data));
            }
            else {
                // recyclerView.setVisibility(View.GONE);
                // no_data.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }

        if (Tag == RequestConstants.CALL_CLAIM_TRUE && object.optString("Message").equals("Success")) {
             LogUtils.showLog("CLAIM CALL DONE?", "SUCCESS");
            new AppDataPushApi().callApi(getActivity(),"Claim","Claim Call","Initiated claim on call");
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}