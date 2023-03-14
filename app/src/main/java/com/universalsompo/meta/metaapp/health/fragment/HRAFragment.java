package com.universalsompo.meta.metaapp.health.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.activities.WebViewActivity;
import com.universalsompo.meta.metaapp.health.adapter.Select_policy_adpter;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyHealthPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy1;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HRAFragment extends Fragment implements ResponseListener {
    private final ArrayList<MyHealthPolicyModel> data1 = new ArrayList<>();
    private CustomProgressDialog customprogress;
    private MySharedPreference prefrences;
    Spinner select_policy_spinner;
    List<String> list_policy = new ArrayList<>();
    Select_policy_adpter selectPolicyAdpter;
    String poilicy_nm="",policynumber="";
      TextView no_policy;
      LinearLayout policy_layout;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_h_r_a, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();

        customprogress = new CustomProgressDialog(getActivity());
        prefrences = MySharedPreference.getInstance(getActivity());
        select_policy_spinner=v.findViewById(R.id.select_policy_spinner);
        policy_layout=v.findViewById(R.id.policy_layout);
        no_policy=v.findViewById(R.id.no_policy);
        customprogress.showProgressBar();
        init();


        select_policy_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectPolicyAdpter = (Select_policy_adpter) adapterView.getAdapter();
                poilicy_nm =selectPolicyAdpter.getItem(i);
                if (poilicy_nm.equals("Select Your Policy number")){
                    Toast.makeText(getContext(), "Select Your Policy number", Toast.LENGTH_SHORT).show();
                }else if (!poilicy_nm.equals("")){
                    web_url();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;

    }

    private void web_url() {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("policy_number", poilicy_nm);
        startActivity(intent);
    }

    private void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("UserID", prefrences.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlHealthConstants.UNIVERSAL_HEALTH_POLICY, this, RequestHealthConstants.UNIVERSAL_HEALTH_POLICY);
        req.execute();
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (object.optString("Message").equals("Success")) {
            if (Tag == RequestHealthConstants.UNIVERSAL_HEALTH_POLICY) {
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    policy_layout.setVisibility(View.VISIBLE);
                    no_policy.setVisibility(View.GONE);
                    arr = object.getJSONArray("UnivSompoHealthPolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data1.add(
                                new MyHealthPolicyModel(
                                        obj.optString("ClaimContactNumber"),
                                        obj.optString("ClaimEmailID"),
                                        obj.optString("Composition"),
                                        obj.optString("ExpiryDate"),
                                        obj.optString("InsCompLogoPath"),
                                        obj.optString("InsCompName"),
                                        obj.optString("IsClaimInitiated"),
                                        obj.optString("PolicyID"),
                                        obj.optString("Policy_Category"),
                                        obj.optString("Policy_Holder_Name"),
                                        obj.optString("Policy_Number"),
                                        obj.optString("Premium"),
                                        obj.optString("Product_Name"),
                                        obj.optString("RemainingDay"),
                                        obj.optString("SumInsured")
                                )
                        );
                    }
                    list_policy.clear();
                    for(int k=0;k<data1.size();k++){
                        int day_left_to_expire = Integer.parseInt(data1.get(k).getRemainingDay());
                        if (day_left_to_expire < 1) {
//                            Toast.makeText(getContext(), "Your policy has been expired", Toast.LENGTH_SHORT).show();
                        } else if (day_left_to_expire == 1) {
//                            Toast.makeText(getContext(), "Your policy has been expired", Toast.LENGTH_SHORT).show();
                        } else if (day_left_to_expire < 31) {
//                            Toast.makeText(getContext(), "Your policy has been expired", Toast.LENGTH_SHORT).show();
                        } else {
                            customprogress.hideProgressBar();

                            list_policy.add(data1.get(k).getPolicy_Number());

                            select_policy_spinner.setSelection(k);
                            selectPolicyAdpter = new Select_policy_adpter(getActivity(),list_policy,0);
                            select_policy_spinner.setAdapter(selectPolicyAdpter);
                        }

                    }
                    list_policy.add(0,"Select Your Policy number");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            no_policy.setVisibility(View.VISIBLE);
            policy_layout.setVisibility(View.GONE);
            /*no_data.setText("No Policy Found");
            no_data.setVisibility(View.VISIBLE);*/
            customprogress.hideProgressBar();
            Toast.makeText(getContext(), "No Policy available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

}