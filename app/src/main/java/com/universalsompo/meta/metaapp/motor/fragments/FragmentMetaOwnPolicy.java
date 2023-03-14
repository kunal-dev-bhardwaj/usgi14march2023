package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.tabs.TabLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.Hospital_active_nonactive;
import com.universalsompo.meta.metaapp.health.activities.hospital.Active_hospital;
import com.universalsompo.meta.metaapp.health.activities.hospital.BlackList_hospital;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.adapters.MyPolicyAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.Interface3;
import com.universalsompo.meta.metaapp.intefaces.PolicyBackPressCallback;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.fragments.mypolicytab.ExpiredPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.mypolicytab.NonExpired;
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

import static com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy.filtericonVisibility;

public class FragmentMetaOwnPolicy extends Fragment implements  View.OnClickListener,ResponseListener, PolicyBackPressCallback  {
    private View view1;
//        implements  View.OnClickListener,ResponseListener, PolicyBackPressCallback  {
    private View view2;
//    ViewPager viewPager;
//    TabLayout tabLayout;
    private RecyclerView rcv_bookedpolicy;
    private MySharedPreference prefrences;
    private Interface3 mCallback;
    private PolicyBackPressCallback policyBackPressCallback;
    private TextView no_data;
    private MyPolicyAdapter ownPolicyAdapter1;
    private final ArrayList<MyPolicyModel> data1 = new ArrayList<>();
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;
    private TextView btn_active;
    private TextView btn_expired;
    NonExpired fragmentNonExpired;
//    public void onAttachFragment(@NonNull Fragment fragment) {
//        try {
//            mCallback = (Interface3) fragment;
//            policyBackPressCallback = (PolicyBackPressCallback) fragment;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(
//                    fragment.toString() + " must implement OnPlayerSelectionSetListener");
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meta_own_policy, container, false);

//        tabLayout =v.findViewById(R.id.buy_tab);
//        viewPager =v.findViewById(R.id.OrderItemsPager);
//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.getPaddingRight();
//        tabLayout.getPaddingLeft();
//        setupViewPager(viewPager);
        rcv_bookedpolicy = v.findViewById(R.id.rv_booked_policy);
        shimmerIncludeLayout = v.findViewById(R.id.shimmerIncludeLayout);
        no_data= v.findViewById(R.id.no_data);
        mShimmerViewContainer = v.findViewById(R.id.parentShimmerLayout);
        btn_active = v.findViewById(R.id.btn_active);
        btn_expired = v.findViewById(R.id.btn_expired);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        prefrences = MySharedPreference.getInstance(getActivity());
        assert getParentFragment() != null;
        onAttachFragment(getParentFragment());
        filtericonVisibility(false);
        initListener();
        init();
        return v;
    }
    private void initListener() {
//        selectOwn();
    }

    private void selectOwn() {
        btn_active.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.tab_text));
        btn_expired.setTextColor(ContextCompat.getColor(getActivity(), R.color.lightblack));
        view2.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        fragmentNonExpired = new NonExpired();
        filtericonVisibility(false);
        Objects.requireNonNull(getActivity()).setFinishOnTouchOutside(true);
        btn_active.setOnClickListener(this);
        btn_expired.setOnClickListener(this);
        addFragment(fragmentNonExpired);
        filtericonVisibility(true);
        getActivity().setFinishOnTouchOutside(true);
        addFragment(fragmentNonExpired);
    }
    private void selectOther() {
        btn_active.setOnClickListener(this);
        btn_expired.setOnClickListener(this);
        btn_active.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        btn_expired.setTextColor(ContextCompat.getColor(getActivity(), R.color.tab_text));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        addFragment(new ExpiredPolicy());
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
                                JSONObject obj = arr.getJSONObject(i);
                                data1.add(
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
                                if (isAdded() && activity != null) {
                                    getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track, shimmerIncludeLayout, true);
                                }
                            }

                            if (data1.size() != 0) {
                                mShimmerViewContainer.startShimmer();
                                mShimmerViewContainer.postDelayed(() -> {
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    rcv_bookedpolicy.setLayoutManager(layoutManager);
//                                            ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), FragmentMetaOwnPolicy.this, data1, prefrences, mCallback, policyBackPressCallback);
                                    ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), FragmentMetaOwnPolicy.this, data1, prefrences);
                                    rcv_bookedpolicy.setAdapter(ownPolicyAdapter1);
                                    no_data.setVisibility(View.GONE);
                                    mShimmerViewContainer.stopShimmer();
                                    mShimmerViewContainer.setVisibility(View.GONE);
                                    FragmentPolicy otherFragment = new FragmentPolicy();
                                    otherFragment.show_filter();
                                }, 3000);

                                } else {
                        /*no_data.setText("No Data");
                        no_data.setVisibility(View.VISIBLE);*/
                                    mShimmerViewContainer.setVisibility(View.GONE);
                                    AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                                    addPolicy.showAlertDialogForPolicy(getActivity(), "There is no policy added");
                                }


//                                String NoOfDaysLeft = arr.optJSONObject(i).getString("NoOfDaysLeft");
//                                int day_left_to_expire = Integer.parseInt(NoOfDaysLeft);
//                                if (day_left_to_expire < 1) {
//                                } else if (day_left_to_expire == 1) {
//                                } else if (day_left_to_expire < 31) {
//                                } else {
//                                    data1.add(
//                                            new MyPolicyModel(
//                                                    arr.optJSONObject(i).optString("ChasisNo"),
//                                                    arr.optJSONObject(i).optString("ClientUserID"),
//                                                    arr.optJSONObject(i).optString("CoverageDetails"),
//                                                    arr.optJSONObject(i).optString("EngineNo"),
//                                                    arr.optJSONObject(i).optString("IDV"),
//                                                    arr.optJSONObject(i).optString("InsCompContactNo"),
//                                                    arr.optJSONObject(i).optString("InsCompID"),
//                                                    arr.optJSONObject(i).optString("InsCompName"),
//                                                    arr.optJSONObject(i).optString("InsCompURL"),
//                                                    arr.optJSONObject(i).optString("IsClaimInitiated"),
//                                                    arr.optJSONObject(i).optString("Make"),
//                                                    arr.optJSONObject(i).optString("ManufacturingYear"),
//                                                    arr.optJSONObject(i).optString("Model"),
//                                                    arr.optJSONObject(i).optString("NoOfDaysLeft"),
//                                                    arr.optJSONObject(i).optString("PolicyDoc"),
//                                                    arr.optJSONObject(i).optString("PolicyHolderName"),
//                                                    arr.optJSONObject(i).optString("PolicyID"),
//                                                    arr.optJSONObject(i).optString("PolicyNumber"),
//                                                    arr.optJSONObject(i).optString("PolicyStartDate"),
//                                                    arr.optJSONObject(i).optString("PolicyToDate"),
//                                                    arr.optJSONObject(i).optString("PolicyType"),
//                                                    arr.optJSONObject(i).optString("Premium"),
//                                                    arr.optJSONObject(i).optString("RegistrationNumber"),
//                                                    arr.optJSONObject(i).optString("Riders"),
//                                                    arr.optJSONObject(i).optString("Variant"),
//                                                    arr.optJSONObject(i).optString("VehicleClass"),
//                                                    arr.optJSONObject(i).optString("VehicleType")
//                                            )
//                                    );
//                                    Activity activity = getActivity();
//                                    if (isAdded() && activity != null) {
//                                        getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track, shimmerIncludeLayout, true);
//                                    }
//                                }
//
//                                if (data1.size() != 0) {
//                                    if (day_left_to_expire < 1) {
//                                    } else if (day_left_to_expire == 1) {
//                                    } else if (day_left_to_expire < 31) {
//                                    } else {
//                                        mShimmerViewContainer.startShimmer();
//                                        mShimmerViewContainer.postDelayed(() -> {
//                                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                                            rcv_bookedpolicy.setLayoutManager(layoutManager);
////                                            ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), FragmentMetaOwnPolicy.this, data1, prefrences, mCallback, policyBackPressCallback);
//                                            ownPolicyAdapter1 = new MyPolicyAdapter(getActivity(), FragmentMetaOwnPolicy.this, data1, prefrences);
//                                            rcv_bookedpolicy.setAdapter(ownPolicyAdapter1);
//                                            no_data.setVisibility(View.GONE);
//                                            mShimmerViewContainer.stopShimmer();
//                                            mShimmerViewContainer.setVisibility(View.GONE);
//                                            FragmentPolicy otherFragment = new FragmentPolicy();
//                                            otherFragment.show_filter();
//                                        }, 3000);
//                                    }
//                                } else {
//                        /*no_data.setText("No Data");
//                        no_data.setVisibility(View.VISIBLE);*/
//                                    mShimmerViewContainer.setVisibility(View.GONE);
//                                    AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
//                                    addPolicy.showAlertDialogForPolicy(getActivity(), "There is no policy added");
//                                }
//                            }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                no_data.setText("No Policy Found");
                no_data.setVisibility(View.VISIBLE);
                mShimmerViewContainer.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

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

//    private void setupViewPager(ViewPager viewPager) {
//        FragmentMetaOwnPolicy.Adapter adapter = new FragmentMetaOwnPolicy.Adapter(getFragmentManager());
//        adapter.addFragment(new NonExpired(), "Non Expired ");
//        adapter.addFragment(new ExpiredPolicy(), "Expired ");
//
//        viewPager.setAdapter(adapter);
//    }
//
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_active:
//                selectOwn();
                break;

            case R.id.btn_expired:
//                selectOther();
                break;
        }
    }
//
//
    @Override
    public void changeFragment(String tag) {
        if (tag.equalsIgnoreCase("Non Expired Policy"))
            selectOwn();
    }
//    public class Adapter extends FragmentPagerAdapter {
//        private List<Fragment> mFragments = new ArrayList<>();
//        private List<String> mFragmentTitles = new ArrayList<>();
//
//        public Adapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            mFragments.add(fragment);
//            mFragmentTitles.add(title);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragments.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitles.get(position);
//        }
//    }
    private void addFragment(Fragment frg1) {
        FragmentManager childFragMan1 = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan1.beginTransaction();
        childFragTrans.replace(R.id.policy_container, frg1);
        childFragTrans.commit();
    }

}
