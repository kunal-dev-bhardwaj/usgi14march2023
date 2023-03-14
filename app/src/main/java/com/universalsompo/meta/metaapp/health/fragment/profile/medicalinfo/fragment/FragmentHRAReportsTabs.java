package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
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

public class FragmentHRAReportsTabs extends Fragment implements View.OnClickListener {
    private View v, view1, view2;
    private SelectorListener binder;
    private TextView lifestyle_hra;
    private TextView symptom_hra;
    String value;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_hra_reports_tab, container, false);
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth)getActivity()).hidefooter();
        ((MainActivityHealth)getActivity()).remove_elevation();
        setHasOptionsMenu(true);
        value = getArguments().getString("value");
        lifestyle_hra = v.findViewById(R.id.lifestyle_hra);
        symptom_hra = v.findViewById(R.id.symptom_hra);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);

        lifestyle_hra.setOnClickListener(this);
        symptom_hra.setOnClickListener(this);
        if (value.equalsIgnoreCase("0")) {
            selectLifestyle();
        } else if (value.equalsIgnoreCase("1")) {
            selectLifestyle();
        } else {
            selectSymptom();
        }

        return v;
    }

    void selectLifestyle() {
        lifestyle_hra.setTextColor(getResources().getColor(R.color.tab_text));
        symptom_hra.setTextColor(getResources().getColor(R.color.lightblack));
        view2.setBackgroundResource(R.color.white);
        view1.setBackgroundResource(R.color.tab_text);
        addFragment(new FragmentLifestyleReports());
    }

    void selectSymptom() {
        lifestyle_hra.setTextColor(getResources().getColor(R.color.lightblack));
        symptom_hra.setTextColor(getResources().getColor(R.color.tab_text));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.white);
        addFragment(new FragmentSymptonReports());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.lifestyle_hra:
                selectLifestyle();
                break;
            case R.id.symptom_hra:
                selectSymptom();
                break;
        }
    }

    void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.health_records_container, frg);
        childFragTrans.commit();
    }
}
