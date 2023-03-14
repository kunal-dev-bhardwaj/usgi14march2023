package com.universalsompo.meta.metaapp.health.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.hospital.Active_hospital;
import com.universalsompo.meta.metaapp.health.activities.hospital.BlackList_hospital;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_Private_car;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_passenger_vehicle;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Private_Two_wheeler;
import com.universalsompo.meta.metaapp.motor.fragments.BuyPolicyMotor;

import java.util.ArrayList;
import java.util.List;

public class Hospital_active_nonactive extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    private LinearLayout cross_icon;
    private TextView back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_active_nonactive);
        back_button = findViewById(R.id.back_button);
        tabLayout = findViewById(R.id.buy_tab);
        cross_icon = findViewById(R.id.cross_icon2);
        viewPager =findViewById(R.id.OrderItemsPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.getPaddingRight();
        tabLayout.getPaddingLeft();
        setupViewPager(viewPager);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);
        cross_icon.setOnClickListener(v -> onBackPressed());
    }
    private void setupViewPager(ViewPager viewPager) {
        Hospital_active_nonactive.Adapter adapter = new Hospital_active_nonactive.Adapter(getSupportFragmentManager());
        adapter.addFragment(new Active_hospital(), "Active Hospital");
        adapter.addFragment(new BlackList_hospital(), "Black Listed Hospital");

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