package com.universalsompo.meta.metaapp.motor.activities.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.universalsompo.meta.metaapp.motor.activities.travel.AnnualMultiTripTravel;
import com.universalsompo.meta.metaapp.motor.activities.travel.DomesticTravelInsurance;
import com.universalsompo.meta.metaapp.motor.activities.travel.StudentTravel;
import com.universalsompo.meta.metaapp.motor.activities.travel.TravelAsia;
import com.universalsompo.meta.metaapp.motor.activities.travel.TravelWorldwide;

public class TravelAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public TravelAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AnnualMultiTripTravel AnnualMultiTripTravel = new AnnualMultiTripTravel();
                return AnnualMultiTripTravel;
            case 1:
                TravelWorldwide travelWorldwide = new TravelWorldwide();
                return travelWorldwide;
            case 2:
                StudentTravel studentTravel = new StudentTravel();
                return studentTravel;
            case 3:
                TravelAsia travelAsia = new TravelAsia();
                return travelAsia;
            case 4:
                DomesticTravelInsurance domesticTravelInsurance = new DomesticTravelInsurance();
                return domesticTravelInsurance;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
