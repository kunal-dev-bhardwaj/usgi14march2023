package com.universalsompo.meta.metaapp.motor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.Health_Insurance_Renewal;
import com.universalsompo.meta.metaapp.motor.activities.adapter.TravelAdapter;

public class TravelInsurance extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageView BackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_insurance);
        getWindow().setStatusBarColor(ContextCompat.getColor(TravelInsurance.this, R.color.colorPrimaryDark));
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        BackImg = findViewById(R.id.BackImg);
        tabLayout.addTab(tabLayout.newTab().setText("Annual MultiTrip"));
        tabLayout.addTab(tabLayout.newTab().setText("Travel Worldwide"));
        tabLayout.addTab(tabLayout.newTab().setText("Student Travel"));
        tabLayout.addTab(tabLayout.newTab().setText("Travel Asia"));
        tabLayout.addTab(tabLayout.newTab().setText("Domestic Travel Insurance"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final TravelAdapter adapter = new TravelAdapter(TravelInsurance.this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        BackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TravelInsurance.super.onBackPressed();
            }
        });

    }
}