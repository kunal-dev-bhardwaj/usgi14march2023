package com.universalsompo.meta.metaapp.motor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.Web_Loan;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.Buy_Aarogya_Sanjeevani_policy;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.Buy_Complete_Healthcare_policy;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.Buy_Super_Healthcare_policy;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_Policy_Type;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.privatetype.Private_Liability_type;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.privatetype.Private_package_type;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Commercial_vehicle;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Private_Car;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Two_vehicle;

import java.util.ArrayList;
import java.util.List;

public class Renewal_motor_policies extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    LinearLayout linerTwo,linerPrivate,linerCommercial;
    TextView txtTwo,txtPrivate,txtCommercial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_motor_policies);

        getWindow().setStatusBarColor(ContextCompat.getColor(Renewal_motor_policies.this, R.color.colorPrimaryDark));
        tabLayout = findViewById(R.id.OrderItemsLayout);
        viewPager = findViewById(R.id.OrderItemsPager);
        linerTwo = findViewById(R.id.linerTwo);
        linerPrivate = findViewById(R.id.linerPrivate);
        linerCommercial = findViewById(R.id.linerCommercial);
        txtTwo = findViewById(R.id.txtTwo);
        txtPrivate = findViewById(R.id.txtPrivate);
        txtCommercial = findViewById(R.id.txtCommercial);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.getPaddingRight();
        tabLayout.getPaddingLeft();
//        setupViewPager(viewPager);

//        Intent intent = new Intent(getApplicationContext(), Renewal_Private_Car.class);
//        startActivity(intent);
        linerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerTwo.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.new_tab_back));
                txtTwo.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.new_red));
                linerCommercial.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grey_tab_bg));
                linerPrivate.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grey_tab_bg));
                txtCommercial.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightblack));
                txtPrivate.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightblack));

                Intent intent = new Intent(Renewal_motor_policies.this, Renewal_Two_vehicle.class);
                startActivity(intent);
                finish();

            }
        });
        linerPrivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerTwo.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grey_tab_bg));
                txtTwo.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightblack));
                linerCommercial.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grey_tab_bg));
                linerPrivate.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.new_tab_back));
                txtCommercial.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightblack));
                txtPrivate.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.new_red));
                Intent intent = new Intent(Renewal_motor_policies.this, Renewal_Private_Car.class);
                startActivity(intent);
                finish();
            }
        });
        linerCommercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerTwo.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grey_tab_bg));
                txtTwo.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightblack));
                linerCommercial.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.new_tab_back));
                linerPrivate.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grey_tab_bg));
                txtCommercial.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.new_red));
                txtPrivate.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.new_red));
                Intent intent = new Intent(Renewal_motor_policies.this, Renewal_Commercial_vehicle.class);
                startActivity(intent);
                finish();
            }
        });



    }
    private void setupViewPager(ViewPager viewPager) {
        Renewal_motor_policies.Adapter adapter = new Renewal_motor_policies.Adapter(getSupportFragmentManager());
        adapter.addFragment(new Renewal_Two_vehicle(), "Two Wheeler");
        adapter.addFragment(new Renewal_Private_Car(), "Private Car");
        adapter.addFragment(new Renewal_Commercial_vehicle(), "Commercial vehicle");
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