package com.universalsompo.meta.metaapp.health.fragment.watertracking.fragment;

import android.content.Context;
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
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;

public class WaterIntakeMainTab extends Fragment implements View.OnClickListener {
    private View v, view1, view2;
    private SelectorListener binder;
    private TextView water;
    private TextView stats;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_water_intake_main_tab, container,false);
        ((MainActivityHealth) getActivity()).remove_elevation();

        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        setHasOptionsMenu(true);
        water = v.findViewById(R.id.water);
        stats = v.findViewById(R.id.stats);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);

        initListener();
        return v;
    }

    void initListener() {
        water.setOnClickListener(this);
        stats.setOnClickListener(this);
        addFragment(new FragmentAddWater());
    }

    void selectWater() {
        water.setTextColor(getResources().getColor(R.color.tab_text));
        stats.setTextColor(getResources().getColor(R.color.lightblack));
        view2.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        addFragment(new FragmentAddWater());
    }

    void selectStats() {
        water.setTextColor(getResources().getColor(R.color.lightblack));
        stats.setTextColor(getResources().getColor(R.color.tab_text));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        addFragment(new FragmentWaterStats());
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.water:
                selectWater();
                break;
            case R.id.stats:
                // Toast.makeText(getActivity(), "Functionality disabled", Toast.LENGTH_SHORT).show();
                selectStats();
                break;
        }
    }

    void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.water_intake_container, frg);
        childFragTrans.commit();
    }
}
