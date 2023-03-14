package com.universalsompo.meta.metaapp.motor.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.universalsompo.meta.metaapp.motor.fragments.FragmentDocumentPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentTabPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentVehiclePolicy;
import com.universalsompo.meta.metaapp.intefaces.PolicyBackPressCallback;

public class Pager extends FragmentStatePagerAdapter {
    private int tabCount;
    private PolicyBackPressCallback policyBackPressCallback;

    public Pager(FragmentManager fm, int tabCount, PolicyBackPressCallback policyBackPressCallback) {
        super(fm);
        this.tabCount = tabCount;
        this.policyBackPressCallback = policyBackPressCallback;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentTabPolicy();
            case 1:
                return new FragmentVehiclePolicy();
            case 2:
                FragmentDocumentPolicy tab3 = new FragmentDocumentPolicy();
                tab3.setFragmnet(policyBackPressCallback);
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}