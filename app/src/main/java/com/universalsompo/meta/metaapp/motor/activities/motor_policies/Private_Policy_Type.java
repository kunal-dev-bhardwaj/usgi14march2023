package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.privatetype.Private_Liability_type;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.privatetype.Private_package_type;

import java.util.ArrayList;
import java.util.List;

public class Private_Policy_Type extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private__policy__type);
        getWindow().setStatusBarColor(ContextCompat.getColor(Private_Policy_Type.this, R.color.colorPrimaryDark));
        tabLayout = findViewById(R.id.OrderItemsLayout);
        viewPager = findViewById(R.id.OrderItemsPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.getPaddingRight();
        tabLayout.getPaddingLeft();
        setupViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        Private_Policy_Type.Adapter adapter = new Private_Policy_Type.Adapter(getSupportFragmentManager());
        adapter.addFragment(new Private_package_type(), "Package");
        adapter.addFragment(new Private_Liability_type(), "Liability");
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