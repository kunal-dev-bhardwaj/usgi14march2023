package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyHealthClaimStatusPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthClaimStatusModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentClaimStatusTracking extends Fragment implements ResponseListener {
    private RecyclerView rcv_healthpolicy;
    private MySharedPreference prefrences;
    private TextView no_data;
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;
    private MyHealthClaimStatusPolicyAdapter ownPolicyAdapter1;
    private final ArrayList<MyHealthClaimStatusModel> data1 = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meta_health_own_policy_claim_status, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        rcv_healthpolicy = v.findViewById(R.id.rcv_healthpolicy);
        shimmerIncludeLayout = v.findViewById(R.id.shimmerIncludeLayout);
        no_data= v.findViewById(R.id.no_data);
        mShimmerViewContainer = v.findViewById(R.id.parentShimmerLayout);
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    private void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("Uid", prefrences.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlHealthConstants.UNIVERSAL_HEALTH__CLAIM_STATUS_POLICY, this, RequestHealthConstants.UNIVERSAL_HEALTH__CLAIM_STATUS_POLICY);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.UNIVERSAL_HEALTH__CLAIM_STATUS_POLICY) {
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("PolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data1.add(
                                new MyHealthClaimStatusModel(
                                        obj.optString("ClaimNo"),
                                        obj.optString("ExpiryDate"),
                                        obj.optString("InsuredName"),
                                        obj.optString("InsurerName"),
                                        obj.optString("PolicyId"),
                                        obj.optString("PolicyNumber"),
                                        obj.optString("Product_Name"),
                                        obj.optString("SumInsured")
                                )
                        );
                        Activity activity = getActivity();
                        if (isAdded() && activity != null){
                            getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track,shimmerIncludeLayout,true);
                        }
                    }
                    if (data1.size() == 0) {
                        /*no_data.setText("No Policy Found");
                        no_data.setVisibility(View.VISIBLE);*/
                        mShimmerViewContainer.setVisibility(View.GONE);
                        AlertDialogAddPolicy1 addPolicy = new AlertDialogAddPolicy1();
                        addPolicy.showAlertDialogForPolicy(getActivity(),"No claim filed please add a policy.");
                    } else {
                        mShimmerViewContainer.startShimmer();
                        mShimmerViewContainer.postDelayed(() -> {
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            rcv_healthpolicy.setLayoutManager(layoutManager);
                            ownPolicyAdapter1 = new MyHealthClaimStatusPolicyAdapter(getActivity(), data1);
                            rcv_healthpolicy.setAdapter(ownPolicyAdapter1);
                            no_data.setVisibility(View.GONE);
                            mShimmerViewContainer.stopShimmer();
                            mShimmerViewContainer.setVisibility(View.GONE);
                        },3000);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                /*no_data.setText("No Policy Found");
                no_data.setVisibility(View.VISIBLE);*/
                mShimmerViewContainer.setVisibility(View.GONE);
                AlertDialogAddPolicy1 addPolicy = new AlertDialogAddPolicy1();
                addPolicy.showAlertDialogForPolicy(getActivity(),"No claim filed please add a policy.");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
