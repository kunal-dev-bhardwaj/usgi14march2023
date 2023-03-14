package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
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
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyHealthPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.adapters.MyPolicyAdapter;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMetaOwnPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy1;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentMetaOwnPolicyHealth extends Fragment implements ResponseListener {
    private RecyclerView rcv_healthpolicy;
    private MySharedPreference prefrences;
    private TextView no_data;
    private MyHealthPolicyAdapter ownPolicyAdapter1;
    private final ArrayList<MyHealthPolicyModel> data1 = new ArrayList<>();
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;
    private CustomProgressDialog customprogress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meta_health_own_policy, container, false);
        customprogress = new CustomProgressDialog(getActivity());
        rcv_healthpolicy = v.findViewById(R.id.rv_healthpolicy);
        shimmerIncludeLayout = v.findViewById(R.id.shimmerIncludeLayout);
        no_data= v.findViewById(R.id.no_data);
        mShimmerViewContainer = v.findViewById(R.id.parentShimmerLayout);
        prefrences = MySharedPreference.getInstance(getActivity());
        customprogress.showProgressBar();
        init();
        return v;
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
                    arr = object.getJSONArray("UnivSompoHealthPolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        String RemainingDay = arr.optJSONObject(i).getString("RemainingDay");
                        int day_left_to_expire = Integer.parseInt(RemainingDay);
                        if (day_left_to_expire < 1) {
                        } else if (day_left_to_expire == 1) {
                        } else if (day_left_to_expire < 31) {
                        } else {
                            data1.add(
                                    new MyHealthPolicyModel(
                                            arr.optJSONObject(i).optString("ClaimContactNumber"),
                                            arr.optJSONObject(i).optString("ClaimEmailID"),
                                            arr.optJSONObject(i).optString("Composition"),
                                            arr.optJSONObject(i).optString("ExpiryDate"),
                                            arr.optJSONObject(i).optString("InsCompLogoPath"),
                                            arr.optJSONObject(i).optString("InsCompName"),
                                            arr.optJSONObject(i).optString("IsClaimInitiated"),
                                            arr.optJSONObject(i).optString("PolicyID"),
                                            arr.optJSONObject(i).optString("Policy_Category"),
                                            arr.optJSONObject(i).optString("Policy_Holder_Name"),
                                            arr.optJSONObject(i).optString("Policy_Number"),
                                            arr.optJSONObject(i).optString("Premium"),
                                            arr.optJSONObject(i).optString("Product_Name"),
                                            arr.optJSONObject(i).optString("RemainingDay"),
                                            arr.optJSONObject(i).optString("SumInsured")
                                    )
                            );
                            Activity activity = getActivity();
                            if (isAdded() && activity != null) {
                                getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track, shimmerIncludeLayout, true);
                            }
                        }
//                        JSONObject obj = arr.getJSONObject(i);

                        if (data1.size() != 0) {
                            if (day_left_to_expire < 1) {
                            } else if (day_left_to_expire == 1) {
                            } else if (day_left_to_expire < 31) {
                            } else {
                                customprogress.hideProgressBar();
                                mShimmerViewContainer.startShimmer();
                                mShimmerViewContainer.postDelayed(() -> {
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    rcv_healthpolicy.setLayoutManager(layoutManager);
                                    ownPolicyAdapter1 = new MyHealthPolicyAdapter(getActivity(), data1);
                                    rcv_healthpolicy.setAdapter(ownPolicyAdapter1);
                                    no_data.setVisibility(View.GONE);
                                    mShimmerViewContainer.stopShimmer();
                                    mShimmerViewContainer.setVisibility(View.GONE);
                                }, 3000);
                            }
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            /*no_data.setText("No Policy Found");
            no_data.setVisibility(View.VISIBLE);*/
            customprogress.hideProgressBar();
            mShimmerViewContainer.setVisibility(View.GONE);
            AlertDialogAddPolicy1 addPolicy = new AlertDialogAddPolicy1();
            addPolicy.showAlertDialogForPolicy(getActivity(),"There is no policy added");
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
