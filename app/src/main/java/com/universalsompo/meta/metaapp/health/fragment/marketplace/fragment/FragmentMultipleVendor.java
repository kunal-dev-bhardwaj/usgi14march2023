package com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.Objects;

public class FragmentMultipleVendor extends Fragment implements View.OnClickListener {
    private View v;
    private LinearLayout grid_layout, list_layout;
    private String type, state, city, id;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_multiple_vendor, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).remove_elevation();
        assert getArguments() != null;
        type = getArguments().getString("type");
        state = getArguments().getString("state");
        city = getArguments().getString("city");
        id = getArguments().getString("id");
        new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors list of type " + type);
        init();
        return v;
    }

    private void init() {
        grid_layout = v.findViewById(R.id.grid_layout);
        list_layout = v.findViewById(R.id.list_layout);
        TextView loc_text = v.findViewById(R.id.loc_text);
        loc_text.setText(city);
        grid_layout.setVisibility(View.VISIBLE);
        list_layout.setVisibility(View.GONE);
        grid_layout.setOnClickListener(this);
        list_layout.setOnClickListener(this);
        addFragment(new FragmentMultipleVendorListView(), type, state, city, id);
    }

    @Override
    public void onClick(View v) {
        int id1 = v.getId();
        switch (id1) {
            case R.id.grid_layout:
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors grid page","List of multiple vendors gridview of type " + type);
                grid_layout.setVisibility(View.GONE);
                list_layout.setVisibility(View.VISIBLE);
                addFragment(new FragmentMultipleVendorGridView(), type, state, city, id);
                break;

            case R.id.list_layout:
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors listview of type " + type);
                grid_layout.setVisibility(View.VISIBLE);
                list_layout.setVisibility(View.GONE);
                addFragment(new FragmentMultipleVendorListView(), type, state, city, id);
                break;
        }
    }

    private void addFragment(Fragment frg, String type, String state, String city, String id) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        Bundle args = new Bundle();
        args.putString("type", type);
        args.putString("state", state);
        args.putString("city", city);
        args.putString("id", id);
        frg.setArguments(args);
        childFragTrans.replace(R.id.container_market, frg);
        childFragTrans.commit();
    }
}
