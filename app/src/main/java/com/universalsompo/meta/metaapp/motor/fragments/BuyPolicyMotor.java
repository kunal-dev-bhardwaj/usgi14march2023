package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.android.material.tabs.TabLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.Commercial_browser;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.Policies_web_Browser;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.activities.Renewal_motor_policies;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_Car_Motor;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Commercial_vehicle;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Private_Car;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Two_vehicle;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_Private_car;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_passenger_vehicle;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Private_Two_wheeler;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.Dashboard_buy_policy_item;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuyPolicyMotor extends Fragment implements ResponseListener {
    private ArrayList<Dashboard_buy_policy_item> buy_policy_items = new ArrayList<>();
    private MySharedPreference pref;
    LinearLayout back;
    TextView btn_two_wheeler,btn_four_wheeler,btn_long_term_two_wheeler,btn_commercial,renewal_btn;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_buy_policy_motor, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        pref = MySharedPreference.getInstance(getActivity());

        tabLayout = view.findViewById(R.id.buy_tab);
        viewPager =view.findViewById(R.id.OrderItemsPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.getPaddingRight();
        tabLayout.getPaddingLeft();
        setupViewPager(viewPager);
         btn_two_wheeler = view.findViewById(R.id.btn_two_wheeler);
         btn_four_wheeler =view.findViewById(R.id.btn_four_wheeler);
        btn_long_term_two_wheeler =view.findViewById(R.id.btn_long_term_two_wheeler);
        btn_commercial =view.findViewById(R.id.btn_commercial);
        renewal_btn =view.findViewById(R.id.renewal_btn);
        back =view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });


        renewal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Policies_web_Browser.class);
                startActivity(intent);
            }
        });

        btn_long_term_two_wheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Policies_web_Browser.class);
                startActivity(intent);
            }
        });

        btn_commercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Commercial_browser.class);
                startActivity(intent);
            }
        });

        callBuyApi();
        return view;
    }
    private void callBuyApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("Mode", "MOTOR");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.BUY_POLICY_URL, this, RequestConstants.BUY_POLICY_URL);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.BUY_POLICY_URL) {
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("ProductMappingList");
                    buy_policy_items.clear();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject jsonObject = arr.getJSONObject(i);
                        buy_policy_items.add(new Dashboard_buy_policy_item(
                                        jsonObject.optString("Id"),
                                        jsonObject.optString("ProductName"),
                                        jsonObject.optString("ProductUrl"),
                                        jsonObject.optString("ThankPageUrl")
                                )
                        );
                    }
                    btn_four_wheeler.setText(buy_policy_items.get(0).getProductName());
                    btn_two_wheeler.setText(buy_policy_items.get(1).getProductName());
                    btn_four_wheeler.setOnClickListener(v1 -> {
                        Intent in = new Intent(getActivity(), Private_Car_Motor.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("ISFROMPDFFULL", "");
                        if (pref.getisUSGIUser().equals("1")) {
                            in.putExtra("Url", buy_policy_items.get(0).getProductUrl() + pref.getMOBILE() + "&CustId=" + pref.getCustID());
                        } else {
                            in.putExtra("Url", "https://www.universalsompo.com/Onlinemotor?Product=Privatecar" + pref.getMOBILE() + "&CustId=0");
//                            in.putExtra("Url", buy_policy_items.get(0).getProductUrl() + pref.getMOBILE() + "&CustId=0");

                        }
                        in.putExtra("fargmentTag", "Buy Policy");
                        in.putExtra("type", buy_policy_items.get(0).getProductName());
                        Objects.requireNonNull(getActivity()).startActivity(in);
                    });

                    btn_two_wheeler.setOnClickListener(v12 -> {
                        Intent in = new Intent(getActivity(), Private_Car_Motor.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("ISFROMPDFFULL", "");
                        if (pref.getisUSGIUser().equals("1")) {
                            in.putExtra("Url", buy_policy_items.get(1).getProductUrl() + pref.getMOBILE() + "&CustId=" + pref.getCustID());
                        } else {
                            in.putExtra("Url", buy_policy_items.get(1).getProductUrl() + pref.getMOBILE() + "&CustId=0");
                        }
                        in.putExtra("fargmentTag", "Buy Policy");
                        in.putExtra("type", buy_policy_items.get(1).getProductName());
                        Objects.requireNonNull(getActivity()).startActivity(in);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    private void setupViewPager(ViewPager viewPager) {
        BuyPolicyMotor.Adapter adapter = new BuyPolicyMotor.Adapter(getChildFragmentManager());
        adapter.addFragment(new Motor_Private_car(), "Motor Private Car");
//        adapter.addFragment(new Private_Two_wheeler(), "Two-Wheeler");
//        adapter.addFragment(new Motor_passenger_vehicle(), "Passenger Carrying Vehicle");
        viewPager.setAdapter(adapter);
    }
    public class Adapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
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
}