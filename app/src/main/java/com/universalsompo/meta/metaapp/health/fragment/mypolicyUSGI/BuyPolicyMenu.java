package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.VolleyError;
import com.denzcoskun.imageslider.adapters.ViewPagerAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.tabs.TabLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.activities.Web_Loan;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.FragmentDashBoardHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.Buy_Aarogya_Sanjeevani_policy;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.Buy_Complete_Healthcare_policy;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.Buy_Super_Healthcare_policy;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.aplusbuyjourney.BuyAPlusHealthCarePolicy;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.BuyPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.BuyPolicyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_Private_car;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_passenger_vehicle;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Private_Two_wheeler;
import com.universalsompo.meta.metaapp.motor.fragments.BuyPolicyMotor;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuyPolicyMenu extends Fragment implements ResponseListener {
    private View v;
    private BuyPolicyAdapter adapter;
    private ListView listView;
    private TextView no_data,renewal_btn;
    public BuyPolicyModel model;
    private List<BuyPolicyModel> modelList;
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;
     Button btn_complete_health;
     LinearLayout loan_liner;
     ImageView healthIcon,backImage;
    LinearLayout linerHealthCare,linerSuperHealth,linerArogya,linerAPlusHealth;
    TextView txtHealthCare,txtSuperHealth,txtArogya,txtAPlusHealth;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_buy_policy_menu, container,false);
        ((MainActivityHealth) requireActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).remove_elevation1();

        init();
        callApi();
        return v;
    }

    private void init() {

        tabLayout = v.findViewById(R.id.buy_tab);
        backImage = v.findViewById(R.id.backImage);
        viewPager =v.findViewById(R.id.OrderItemsPager);
        tabLayout.setupWithViewPager(viewPager);
        txtHealthCare=v.findViewById(R.id.txtHealthCare);
        linerHealthCare=v.findViewById(R.id.linerHealthCare);
        linerSuperHealth=v.findViewById(R.id.linerSuperHealth);
        linerAPlusHealth=v.findViewById(R.id.linerAPlusHealth);
        linerArogya=v.findViewById(R.id.linerArogya);
        txtSuperHealth=v.findViewById(R.id.txtSuperHealth);
        txtAPlusHealth=v.findViewById(R.id.txtAPlusHealth);
        txtArogya=v.findViewById(R.id.txtArogya);
        healthIcon=v.findViewById(R.id.healthIcon);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.getPaddingRight();
        tabLayout.getPaddingLeft();
//        setupViewPager(viewPager);
//        setupTabIcons();

        listView = v.findViewById(R.id.buy_policy_list);
        no_data = v.findViewById(R.id.no_data);
        shimmerIncludeLayout = v.findViewById(R.id.shimmerIncludeLayout);
        mShimmerViewContainer = v.findViewById(R.id.parentShimmerLayout);
        btn_complete_health = v.findViewById(R.id.btn_complete_health);
        renewal_btn = v.findViewById(R.id.renewal_btn);
        loan_liner = v.findViewById(R.id.loan_liner);

        Fragment healthFragment = new Buy_Complete_Healthcare_policy();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.policy_container, healthFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
        getActivity().setFinishOnTouchOutside(true);
//        Objects.requireNonNull(getActivity()).onBackPressed();

        linerHealthCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerHealthCare.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.new_tab_back));
                txtHealthCare.setTextColor(ContextCompat.getColor(getContext(), R.color.new_red));
                linerSuperHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                linerArogya.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtSuperHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                txtArogya.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                linerAPlusHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtAPlusHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                Fragment healthFragment = new Buy_Complete_Healthcare_policy();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.policy_container, healthFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                getActivity().setFinishOnTouchOutside(true);
//                getActivity().onBackPressed();
            }
        });
        linerAPlusHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerAPlusHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.new_tab_back));
                txtAPlusHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.new_red));
                linerSuperHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                linerArogya.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtSuperHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                txtArogya.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                linerHealthCare.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtHealthCare.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                Fragment BuyHealthFragment = new BuyAPlusHealthCarePolicy();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.policy_container, BuyHealthFragment );
                transaction.addToBackStack(null);
                transaction.commit();
                getActivity().setFinishOnTouchOutside(true);
            }
        });


        linerSuperHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerHealthCare.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtHealthCare.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                linerSuperHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.new_tab_back));
                txtSuperHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.new_red));
                linerArogya.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtArogya.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                linerAPlusHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtAPlusHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));

                Fragment someFragment = new Buy_Super_Healthcare_policy();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.policy_container, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
                getActivity().setFinishOnTouchOutside(true);
//                getActivity().onBackPressed();

//                Intent intent = new Intent(getActivity(), Buy_Super_Healthcare_policy.class);
//                getActivity().startActivity(intent);
            }
        });
        linerArogya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerHealthCare.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtHealthCare.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                linerSuperHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtSuperHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
                linerArogya.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.new_tab_back));
                txtArogya.setTextColor(ContextCompat.getColor(getContext(), R.color.new_red));
                linerAPlusHealth.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.grey_tab_bg));
                txtAPlusHealth.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));

                Fragment ArogyaFragment = new Buy_Aarogya_Sanjeevani_policy();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.policy_container, ArogyaFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
//                getActivity().onBackPressed();
                getActivity().setFinishOnTouchOutside(true);
            }
        });

        btn_complete_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Web_Loan.class);
                intent.putExtra("policy_health_url", "https://www.universalsompo.com/LoanSecure/");
                intent.putExtra("text_nm", "Loan secure insurance");
               getActivity().startActivity(intent);
            }
        });
        renewal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Web_Loan.class);
                intent.putExtra("policy_health_url", "https://www.universalsompo.com/health-renewal");
                intent.putExtra("text_nm", "Health Insurance Renewal");
                getActivity().startActivity(intent);
            }
        });
        modelList = new ArrayList<>();
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentManager fm = getFragmentManager();
//                if (fm.getBackStackEntryCount() > 0) {
//                    fm.popBackStack();
//                } else {
//                    requireActivity().onBackPressed();
//                }
//                getFragmentManager().popBackStack();
                Intent intent = new Intent(getActivity(), MainActivityHealth.class);
                startActivity(intent);
                requireActivity().finish();

            }
        });
    }

//    private void setupTabIcons() {
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
//    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new Buy_Complete_Healthcare_policy(), "Complete Healthcare Insurance");
        adapter.addFrag(new Buy_Super_Healthcare_policy(), "Super Healthcare Insurance");
        adapter.addFrag(new Buy_Aarogya_Sanjeevani_policy(), "Arogya Sanjeevani Insurance");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




    /*private void setupViewPager(ViewPager viewPager) {
        BuyPolicyMenu.Adapter adapter = new BuyPolicyMenu.Adapter(getChildFragmentManager());
        adapter.addFragment(new Buy_Complete_Healthcare_policy() ,"Complete ");
        adapter.addFragment(new Buy_Super_Healthcare_policy(), "Super ");
        adapter.addFragment(new Buy_Aarogya_Sanjeevani_policy(), "Arogya ");
        viewPager.setAdapter(adapter);
    }
    public class Adapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment,String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

     */


    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
            object.put("Mode", "HEALTH");
            ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlHealthConstants.BUY_POLICY_URL, this, RequestHealthConstants.BUY_POLICY_URL);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.BUY_POLICY_URL) {
            if (object.optString("Message").equals("Success")) {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                if (!modelList.isEmpty()) {
                    modelList.clear();
                }
                JSONArray arr;
                try {
                    arr = object.getJSONArray("ProductMappingList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject jsonObject = arr.getJSONObject(i);
                        model = new BuyPolicyModel(jsonObject.optString("Id"),
                                jsonObject.optString("ProductName"),
                                jsonObject.optString("ProductUrl"),
                                jsonObject.optString("ThankPageUrl"),
                                jsonObject.optString("ProductDesc"));
                        modelList.add(model);
                        Activity activity = getActivity();
                        if (isAdded() && activity != null){
                            getLayoutInflater().inflate(R.layout.fragment_buy_policy_shimmer,shimmerIncludeLayout,true);
                        }
                    }
                    mShimmerViewContainer.startShimmer();
                    mShimmerViewContainer.postDelayed(() -> {
                        adapter = new BuyPolicyAdapter(getActivity(), modelList);
                        listView.setAdapter(adapter);
                        mShimmerViewContainer.stopShimmer();
                        mShimmerViewContainer.setVisibility(View.GONE);
//                        loan_liner.setVisibility(View.VISIBLE);
                    },3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                no_data.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                loan_liner.setVisibility(View.GONE);

            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    Intent intent = new Intent(getActivity(), MainActivityHealth.class);
                    startActivity(intent);
                    requireActivity().finish();
                    return true;

                }

                return false;
            }
        });
    }

}