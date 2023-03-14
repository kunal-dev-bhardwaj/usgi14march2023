package com.universalsompo.meta.metaapp.motor.fragments.mypolicytab;

import static com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy.filtericonVisibility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.Interface3;
import com.universalsompo.meta.metaapp.intefaces.PolicyBackPressCallback;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.adapters.MyPolicyAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMetaOwnPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ExpiredPolicy extends Fragment implements ResponseListener {
    private RecyclerView rcv_bookedpolicy;
    private MySharedPreference prefrences;
    private Interface3 mCallback;
    private PolicyBackPressCallback policyBackPressCallback;
    private TextView no_data;
    private MyPolicyAdapter ownPolicyAdapter1;
    private final ArrayList<MyPolicyModel> data1 = new ArrayList<>();
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;
//    public void onAttachFragment(@NonNull Fragment fragment) {
//        try {
//            mCallback = (Interface3) fragment;
//            policyBackPressCallback = (PolicyBackPressCallback) fragment;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(
//                    fragment.toString() + " must implement OnPlayerSelectionSetListener");
//        }
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_expired_policy, container, false);
        rcv_bookedpolicy = v.findViewById(R.id.rv_booked_policy);
        shimmerIncludeLayout = v.findViewById(R.id.shimmerIncludeLayout);
        no_data= v.findViewById(R.id.no_data);
        mShimmerViewContainer = v.findViewById(R.id.parentShimmerLayout);
        prefrences = MySharedPreference.getInstance(getActivity());
        assert getParentFragment() != null;
        onAttachFragment(getParentFragment());
        filtericonVisibility(false);
        init();
        return v;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.UNIVERSAL_POLICY) {
            new AppDataPushApi().callApi(getActivity(),"Policy Vault","Policy vault page","User checked his list of policies in vault");
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("objPolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        String NoOfDaysLeft = arr.optJSONObject(i).getString("NoOfDaysLeft");
                        int day_left_to_expire = Integer.parseInt(NoOfDaysLeft);
                        if (day_left_to_expire < 1) {
                            data1.add(
                                    new MyPolicyModel(
                                            arr.optJSONObject(i).optString("ChasisNo"),
                                            arr.optJSONObject(i).optString("ClientUserID"),
                                            arr.optJSONObject(i).optString("CoverageDetails"),
                                            arr.optJSONObject(i).optString("EngineNo"),
                                            arr.optJSONObject(i).optString("IDV"),
                                            arr.optJSONObject(i).optString("InsCompContactNo"),
                                            arr.optJSONObject(i).optString("InsCompID"),
                                            arr.optJSONObject(i).optString("InsCompName"),
                                            arr.optJSONObject(i).optString("InsCompURL"),
                                            arr.optJSONObject(i).optString("IsClaimInitiated"),
                                            arr.optJSONObject(i).optString("Make"),
                                            arr.optJSONObject(i).optString("ManufacturingYear"),
                                            arr.optJSONObject(i).optString("Model"),
                                            arr.optJSONObject(i).optString("NoOfDaysLeft"),
                                            arr.optJSONObject(i).optString("PolicyDoc"),
                                            arr.optJSONObject(i).optString("PolicyHolderName"),
                                            arr.optJSONObject(i).optString("PolicyID"),
                                            arr.optJSONObject(i).optString("PolicyNumber"),
                                            arr.optJSONObject(i).optString("PolicyStartDate"),
                                            arr.optJSONObject(i).optString("PolicyToDate"),
                                            arr.optJSONObject(i).optString("PolicyType"),
                                            arr.optJSONObject(i).optString("Premium"),
                                            arr.optJSONObject(i).optString("RegistrationNumber"),
                                            arr.optJSONObject(i).optString("Riders"),
                                            arr.optJSONObject(i).optString("Variant"),
                                            arr.optJSONObject(i).optString("VehicleClass"),
                                            arr.optJSONObject(i).optString("VehicleType")
                                    )
                            );
                            Activity activity = getActivity();
                            if (isAdded() && activity != null) {
                                getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track, shimmerIncludeLayout, true);
                            }
                        } else if (day_left_to_expire == 1) {
                            data1.add(
                                    new MyPolicyModel(
                                            arr.optJSONObject(i).optString("ChasisNo"),
                                            arr.optJSONObject(i).optString("ClientUserID"),
                                            arr.optJSONObject(i).optString("CoverageDetails"),
                                            arr.optJSONObject(i).optString("EngineNo"),
                                            arr.optJSONObject(i).optString("IDV"),
                                            arr.optJSONObject(i).optString("InsCompContactNo"),
                                            arr.optJSONObject(i).optString("InsCompID"),
                                            arr.optJSONObject(i).optString("InsCompName"),
                                            arr.optJSONObject(i).optString("InsCompURL"),
                                            arr.optJSONObject(i).optString("IsClaimInitiated"),
                                            arr.optJSONObject(i).optString("Make"),
                                            arr.optJSONObject(i).optString("ManufacturingYear"),
                                            arr.optJSONObject(i).optString("Model"),
                                            arr.optJSONObject(i).optString("NoOfDaysLeft"),
                                            arr.optJSONObject(i).optString("PolicyDoc"),
                                            arr.optJSONObject(i).optString("PolicyHolderName"),
                                            arr.optJSONObject(i).optString("PolicyID"),
                                            arr.optJSONObject(i).optString("PolicyNumber"),
                                            arr.optJSONObject(i).optString("PolicyStartDate"),
                                            arr.optJSONObject(i).optString("PolicyToDate"),
                                            arr.optJSONObject(i).optString("PolicyType"),
                                            arr.optJSONObject(i).optString("Premium"),
                                            arr.optJSONObject(i).optString("RegistrationNumber"),
                                            arr.optJSONObject(i).optString("Riders"),
                                            arr.optJSONObject(i).optString("Variant"),
                                            arr.optJSONObject(i).optString("VehicleClass"),
                                            arr.optJSONObject(i).optString("VehicleType")
                                    )
                            );
                            Activity activity = getActivity();
                            if (isAdded() && activity != null) {
                                getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track, shimmerIncludeLayout, true);
                            }

                        } else if (day_left_to_expire < 31) {
                            data1.add(
                                    new MyPolicyModel(
                                            arr.optJSONObject(i).optString("ChasisNo"),
                                            arr.optJSONObject(i).optString("ClientUserID"),
                                            arr.optJSONObject(i).optString("CoverageDetails"),
                                            arr.optJSONObject(i).optString("EngineNo"),
                                            arr.optJSONObject(i).optString("IDV"),
                                            arr.optJSONObject(i).optString("InsCompContactNo"),
                                            arr.optJSONObject(i).optString("InsCompID"),
                                            arr.optJSONObject(i).optString("InsCompName"),
                                            arr.optJSONObject(i).optString("InsCompURL"),
                                            arr.optJSONObject(i).optString("IsClaimInitiated"),
                                            arr.optJSONObject(i).optString("Make"),
                                            arr.optJSONObject(i).optString("ManufacturingYear"),
                                            arr.optJSONObject(i).optString("Model"),
                                            arr.optJSONObject(i).optString("NoOfDaysLeft"),
                                            arr.optJSONObject(i).optString("PolicyDoc"),
                                            arr.optJSONObject(i).optString("PolicyHolderName"),
                                            arr.optJSONObject(i).optString("PolicyID"),
                                            arr.optJSONObject(i).optString("PolicyNumber"),
                                            arr.optJSONObject(i).optString("PolicyStartDate"),
                                            arr.optJSONObject(i).optString("PolicyToDate"),
                                            arr.optJSONObject(i).optString("PolicyType"),
                                            arr.optJSONObject(i).optString("Premium"),
                                            arr.optJSONObject(i).optString("RegistrationNumber"),
                                            arr.optJSONObject(i).optString("Riders"),
                                            arr.optJSONObject(i).optString("Variant"),
                                            arr.optJSONObject(i).optString("VehicleClass"),
                                            arr.optJSONObject(i).optString("VehicleType")
                                    )
                            );
                            Activity activity = getActivity();
                            if (isAdded() && activity != null) {
                                getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track, shimmerIncludeLayout, true);
                            }

                        }


                        if (data1.size() != 0) {
                            if (day_left_to_expire < 1) {
                                mShimmerViewContainer.startShimmer();
                                mShimmerViewContainer.postDelayed(() -> {
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    rcv_bookedpolicy.setLayoutManager(layoutManager);
                                    ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), ExpiredPolicy.this, data1, prefrences);
                                    rcv_bookedpolicy.setAdapter(ownPolicyAdapter1);
//                                    no_data.setVisibility(View.GONE);
                                    mShimmerViewContainer.stopShimmer();
                                    mShimmerViewContainer.setVisibility(View.GONE);
                                    FragmentPolicy otherFragment = new FragmentPolicy();
                                    otherFragment.show_filter();
                                }, 3000);
                            } else if (day_left_to_expire == 1) {
                                mShimmerViewContainer.startShimmer();
                                mShimmerViewContainer.postDelayed(() -> {
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    rcv_bookedpolicy.setLayoutManager(layoutManager);
                                    ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), ExpiredPolicy.this, data1, prefrences);
                                    rcv_bookedpolicy.setAdapter(ownPolicyAdapter1);
//                                    no_data.setVisibility(View.GONE);
                                    mShimmerViewContainer.stopShimmer();
                                    mShimmerViewContainer.setVisibility(View.GONE);
                                    FragmentPolicy otherFragment = new FragmentPolicy();
                                    otherFragment.show_filter();
                                }, 3000);
                            } else if (day_left_to_expire < 31) {
                                mShimmerViewContainer.startShimmer();
                                mShimmerViewContainer.postDelayed(() -> {
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    rcv_bookedpolicy.setLayoutManager(layoutManager);
                                    ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), ExpiredPolicy.this, data1, prefrences);
                                    rcv_bookedpolicy.setAdapter(ownPolicyAdapter1);
//                                    no_data.setVisibility(View.GONE);
                                    mShimmerViewContainer.stopShimmer();
                                    mShimmerViewContainer.setVisibility(View.GONE);
                                    FragmentPolicy otherFragment = new FragmentPolicy();
                                    otherFragment.show_filter();
                                }, 3000);
                            }
                        } else {
                        /*no_data.setText("No Data");
                        no_data.setVisibility(View.VISIBLE);*/
                            mShimmerViewContainer.setVisibility(View.GONE);
                            AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                            addPolicy.showAlertDialogForPolicy(getActivity(), "There is no policy added");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                no_data.setText("No Policy Found");
                no_data.setVisibility(View.VISIBLE);
                mShimmerViewContainer.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("UserID", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.UNIVERSAL_POLICY, this, RequestConstants.UNIVERSAL_POLICY);
        req.execute();
    }

    void filteration(String s) {
        if (s.equals("All")) {
            ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), this, data1, prefrences, mCallback, policyBackPressCallback);
            rcv_bookedpolicy.setAdapter(ownPolicyAdapter1);
            ownPolicyAdapter1.notifyDataSetChanged();
        } else {
            ownPolicyAdapter1.getFilter().filter(s);
        }
    }
}