package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.adapters.RenewalPolicyAdapter1;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.RecyclerViewItemClickLisner;
import com.universalsompo.meta.metaapp.intefaces.RenewalDialogCallback;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Objects;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.RENEWAL_POLICY_DETAIL_URL;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.UNIVERSAL_POLICY;

public class FragmentRenewals extends Fragment implements ResponseListener ,RenewalDialogCallback{
    private View rootview;
    private RecyclerView renewal_policy_list;
    private MySharedPreference pref;
    private String policy_id;
    private String policy_no;
    private String veh_type;
    private ArrayList<MyPolicyModel> data;
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_renewals, container, false);
        initView();
        return rootview;
    }

    private void initView() {
        pref = MySharedPreference.getInstance(getActivity());
        renewal_policy_list = rootview.findViewById(R.id.renewal_policy_list);
        data = new ArrayList<>();
        shimmerIncludeLayout = rootview.findViewById(R.id.shimmerIncludeLayout);
        mShimmerViewContainer = rootview.findViewById(R.id.parentShimmerLayout);
        init(UNIVERSAL_POLICY);
        renewal_policy_list.addOnItemTouchListener(new RecyclerViewItemClickLisner(getActivity(), (view, position) -> {
            policy_id = data.get(position).getPolicyID();
            policy_no = data.get(position).getPolicyNumber();
            veh_type = data.get(position).getVehicleType();
            init(RENEWAL_POLICY_DETAIL_URL);
        }));
    }

    private void init(int url_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            if (url_id == UNIVERSAL_POLICY) {
                object.put("UserID", pref.getUID());
                ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.UNIVERSAL_POLICY, this, UNIVERSAL_POLICY);
                req.execute();
            } else if (url_id == RequestConstants.GET_RENEWAL_POLICY_URL) {
                object.put("PolicyId", policy_id);
                ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.GET_RENEWAL_POLICY_URL, this, RequestConstants.GET_RENEWAL_POLICY_URL);
                req.execute();
            } else if (url_id == RENEWAL_POLICY_DETAIL_URL) {
                object.put("PolicyID", policy_id);
                object.put("UserID", pref.getUID());
                object.put("VehicleType", veh_type);
                object.put("IsOwnershipChange", "");
                object.put("IsClaimMade", "");
                object.put("NCB","0" );
                ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.RENEWAL_POLICY_DETAIL_URL, this, RENEWAL_POLICY_DETAIL_URL);
                req.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == UNIVERSAL_POLICY) {
            new AppDataPushApi().callApi(getActivity(),"Renewals","Renewal page","User visited renewal section");
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("objPolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        if (Integer.parseInt(obj.getString("NoOfDaysLeft")) <= 30) {
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
                        }

                        Activity activity = getActivity();
                        if (isAdded() && activity != null){
                            getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track,shimmerIncludeLayout,true);
                        }
                    }
                    if (data.size() == 0) {
                        AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                        addPolicy.showAlertDialogForPolicy(getActivity(), "There is no policy for Renewal");
                        mShimmerViewContainer.setVisibility(View.GONE);
                    } else {
                        mShimmerViewContainer.startShimmer();
                        mShimmerViewContainer.postDelayed(() -> {
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            renewal_policy_list.setLayoutManager(layoutManager);
                            renewal_policy_list.setAdapter(new RenewalPolicyAdapter1(getActivity(), data));
                            mShimmerViewContainer.stopShimmer();
                            mShimmerViewContainer.setVisibility(View.GONE);
                        },3000);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                addPolicy.showAlertDialogForPolicy(getActivity(), "There is no policy for Renewal");
                mShimmerViewContainer.setVisibility(View.GONE);
            }
        } else if (Tag == RequestConstants.GET_RENEWAL_POLICY_URL) {
            new AppDataPushApi().callApi(getActivity(),"Renewals","Renewal page","User got renewal url for policy id " + policy_id);
            try {
                if (object.getString("Status").equals("true")) {
                    mShimmerViewContainer.setVisibility(View.GONE);
                    Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                    in.putExtra("PolicyNo", policy_no);
                    in.putExtra("Url", object.getString("RenewURL"));
                    in.putExtra("fargmentTag", "Renew Policy");
                    in.putExtra("ISFROMPDFFULL", "");
                    in.putExtra("VehicleType", "");
                    in.putExtra("vendor_id", "");
                    in.putExtra("type", "Renew Policy");
                    Objects.requireNonNull(getActivity()).startActivity(in);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Tag == RENEWAL_POLICY_DETAIL_URL) {
            getRenewalUpdateData(object);
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    @Override
    public void getRenewalUpdateData(JSONObject jsonObject) {
        new AppDataPushApi().callApi(getActivity(),"Renewals","Renewal page","User got renewal url for policy id " + policy_id);
        try {
            if (jsonObject.getString("Status").equals("true")) {

                Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                in.putExtra("PolicyNo", policy_no);
                in.putExtra("Url", jsonObject.getString("RenewalLink"));
                in.putExtra("fargmentTag", "Renew Policy");
                in.putExtra("ISFROMPDFFULL", "");
                in.putExtra("VehicleType", "");
                in.putExtra("vendor_id", "");
                in.putExtra("type", "Renew Policy");
                Objects.requireNonNull(getActivity()).startActivity(in);
                mShimmerViewContainer.setVisibility(View.GONE);
            }
            else
                Toast.makeText(getActivity(),jsonObject.optString("Message"),Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
