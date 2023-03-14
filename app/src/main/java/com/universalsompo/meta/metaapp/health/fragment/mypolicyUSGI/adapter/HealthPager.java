package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentContactPolicy;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentMembersPolicy;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentTabHealthPolicy;

public class HealthPager extends FragmentStatePagerAdapter {
    private int tabCount;

    public HealthPager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentTabHealthPolicy();
            case 1:
                return new FragmentMembersPolicy();
            case 2:
                return new FragmentContactPolicy();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
