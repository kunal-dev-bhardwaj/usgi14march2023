package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.uncopt.android.widget.text.justify.JustifiedTextView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentIndividualClaimContact extends Fragment implements ResponseListener {
    View v;
    private SelectorListener binder;
    private MySharedPreference prefrences;
    String policyID/*, insuranceID*/, insuranceName;
    JustifiedTextView coverage_details;
    private TextView insurance_name, policy_name, policy_number, tpa_number;
    private RelativeLayout coverage_detail_layout, coverage_text;
    private LinearLayout contact_claim_button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_individual_claim_contact, container, false);
        policyID = getArguments().getString("policyID");
        // insuranceID = getArguments().getString("insuranceID");
        insuranceName = getArguments().getString("insuranceName");
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    void init() {
        coverage_detail_layout = v.findViewById(R.id.coverage_detail_layout);
        coverage_text = v.findViewById(R.id.coverage_text);
        contact_claim_button = v.findViewById(R.id.contact_claim_button);
        coverage_details = v.findViewById(R.id.coverage_details);
        insurance_name = v.findViewById(R.id.insurance_name);
        policy_name = v.findViewById(R.id.policy_name);
        policy_number = v.findViewById(R.id.policy_number);
        tpa_number = v.findViewById(R.id.tpa_number);

        //callApi(RequestHealthConstants.GET_INDIVIDUAL_MY_POLICY_DETAILS);
        callApi(RequestHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL);

        contact_claim_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefrences.getHealthClaimNumber() != null) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + prefrences.getHealthClaimNumber()));
                    startActivity(intent);
                }
            }
        });
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

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
                object.put("PolicyID", policyID);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL, this, RequestHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL) {
            if (object.optString("Message").equals("Success")) {
                try {
                    contact_claim_button.setVisibility(View.VISIBLE);
                    insurance_name.setText("Universal Sompo General Insurance Pvt. Ltd.");
                    policy_name.setText("Product Name : " + object.getString("Product_Name"));
                    policy_number.setText("Policy No. : " + object.getString("Policy_Number"));
                    tpa_number.setText(prefrences.getHealthClaimNumber());

                    String coverages = "";
                    JSONArray arr = object.getJSONArray("UnivSompoHealthPolicyMemberList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        coverages = obj.getString("CoverageDetails");
                    }
                    if(coverages.equalsIgnoreCase("") || coverages.equalsIgnoreCase(null)) {
                        coverage_details.setVisibility(View.GONE);
                        coverage_text.setVisibility(View.GONE);
                        coverage_detail_layout.setVisibility(View.GONE);
                    } else {
                        coverage_detail_layout.setVisibility(View.VISIBLE);
                        coverage_details.setVisibility(View.VISIBLE);
                        coverage_text.setVisibility(View.VISIBLE);
                        coverage_details.setText(Html.fromHtml(coverages));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
