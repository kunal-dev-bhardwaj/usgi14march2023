package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.adapters.ClaimPolicyAdapter1;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentClaim extends Fragment implements ResponseListener {
    private RecyclerView claim_policy_renewal_policy_list;
    private View rootView;
    private List<MyPolicyModel> claimModel;
    private TextView no_data;
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_insuranceclaim, container,false);
        ((MainActivity) Objects.requireNonNull(getActivity())).show_elevation();
        initView();
        return rootView;
    }

    private void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("UserID", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.UNIVERSAL_POLICY, this, RequestConstants.UNIVERSAL_POLICY);
        req.execute();
    }

    private void initView() {
        claim_policy_renewal_policy_list = rootView.findViewById(R.id.claim_policy_renewal_policy_list2);
        no_data = rootView.findViewById(R.id.no_data);
        shimmerIncludeLayout = rootView.findViewById(R.id.shimmerIncludeLayout);
        mShimmerViewContainer = rootView.findViewById(R.id.parentShimmerLayout);
        init();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (object.optString("Message").equals("Success")) {
            if (Tag == RequestConstants.UNIVERSAL_POLICY) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("objPolicyList");
                    final ArrayList<MyPolicyModel> data = new ArrayList<>();
                    claimModel = new ArrayList<>();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new MyPolicyModel(
                                        obj.optString("ChasisNo"),
                                        obj.optString("ClientUserID"),
                                        obj.optString("CoverageDetails"),
                                        obj.optString("EngineNo"),
                                        obj.optString("IDV"),
                                        obj.optString("InsCompContactNo"),
                                        obj.optString("InsCompID"),
                                        obj.optString("InsCompName"),
                                        obj.optString("InsCompURL"),
                                        obj.optString("IsClaimInitiated"),
                                        obj.optString("Make"),
                                        obj.optString("ManufacturingYear"),
                                        obj.optString("Model"),
                                        obj.optString("NoOfDaysLeft"),
                                        obj.optString("PolicyDoc"),
                                        obj.optString("PolicyHolderName"),
                                        obj.optString("PolicyID"),
                                        obj.optString("PolicyNumber"),
                                        obj.optString("PolicyStartDate"),
                                        obj.optString("PolicyToDate"),
                                        obj.optString("PolicyType"),
                                        obj.optString("Premium"),
                                        obj.optString("RegistrationNumber"),
                                        obj.optString("Riders"),
                                        obj.optString("Variant"),
                                        obj.optString("VehicleClass"),
                                        obj.optString("VehicleType")
                                )
                        );
                        Activity activity = getActivity();
                        if (isAdded() && activity != null){
                            if (obj.getString("IsClaimInitiated").equals("True")){
                                getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer,shimmerIncludeLayout,true);
                            }else {
                                getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track,shimmerIncludeLayout,true);
                            }
                        }
                    }
                    for (int i = 0; i < data.size(); i++) {
                        if (Integer.parseInt(data.get(i).getNoOfDaysLeft()) >= 1)
                            claimModel.add(data.get(i));
                    }
                    System.out.println("No of policy " + claimModel.size());
                    if (claimModel.size() == 0) {
                        mShimmerViewContainer.setVisibility(View.GONE);
                        AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                        addPolicy.showAlertDialogForPolicy(getActivity(),"There is no policy for claim");
                    } else {
                        no_data.setVisibility(View.GONE);
                        mShimmerViewContainer.setVisibility(View.VISIBLE);
                        mShimmerViewContainer.startShimmer();
                        mShimmerViewContainer.postDelayed(() -> {
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            claim_policy_renewal_policy_list.setLayoutManager(layoutManager);
                            claim_policy_renewal_policy_list.setAdapter(new ClaimPolicyAdapter1(getActivity(), claimModel));
                            no_data.setVisibility(View.GONE);
                            mShimmerViewContainer.stopShimmer();
                            mShimmerViewContainer.setVisibility(View.GONE);
                        },3000);

                    }
                    new AppDataPushApi().callApi(getActivity(),"Claim","Claim","claim list");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
