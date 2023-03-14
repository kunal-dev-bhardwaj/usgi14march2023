package com.universalsompo.meta.metaapp.health.fragment.weightlog.fragment;

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

public class WeightLogMainTab extends Fragment implements View.OnClickListener {
    private View v, view1, view2;
    private SelectorListener binder;
    private TextView weight;
    private TextView stats;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_weight_log_main_tab, container,false);
        ((MainActivityHealth) getActivity()).remove_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        setHasOptionsMenu(true);
        weight = v.findViewById(R.id.weight);
        stats = v.findViewById(R.id.stats);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);

        initListener();
        return v;
    }

    void initListener() {
        weight.setOnClickListener(this);
        stats.setOnClickListener(this);
        addFragment(new FragmentWeightLog());
    }

    void selectWeightLog() {
        weight.setTextColor(getResources().getColor(R.color.tab_text));
        stats.setTextColor(getResources().getColor(R.color.lightblack));
        view2.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        addFragment(new FragmentWeightLog());
    }

    void selectStats() {
        weight.setTextColor(getResources().getColor(R.color.lightblack));
        stats.setTextColor(getResources().getColor(R.color.tab_text));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        addFragment(new FragmentWeightStats());
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
            case R.id.weight:
                selectWeightLog();
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
        childFragTrans.replace(R.id.weight_log_container, frg);
        childFragTrans.commit();
    }
}
