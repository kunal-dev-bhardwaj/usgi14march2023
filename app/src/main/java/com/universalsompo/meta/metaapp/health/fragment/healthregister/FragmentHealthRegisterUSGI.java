package com.universalsompo.meta.metaapp.health.fragment.healthregister;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.fragment.FragmentBloodPressureChart;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.fragment.FragmentBloodSugarChart;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.Objects;

public class FragmentHealthRegisterUSGI extends Fragment implements View.OnClickListener {
    private View view1;
    private View view2;
    private LinearLayout btn_blood_pressure;
    private LinearLayout btn_blood_sugar;
    private ImageView bp;
    private ImageView bs;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_health_register_new_design, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).remove_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        setHasOptionsMenu(true);
        btn_blood_pressure = v.findViewById(R.id.btn_blood_pressure);
        btn_blood_sugar = v.findViewById(R.id.btn_blood_sugar);
        bp = v.findViewById(R.id.bp);
        bs = v.findViewById(R.id.bs);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        initListener();
        return v;
    }

    private void initListener() {
        Bundle bdl = getArguments();
        String str = "";
        try {
            assert bdl != null;
            str = bdl.getString("Page");
        }
        catch(final Exception e) {
            System.out.println("Error " + e);
        }

        assert str != null;
        if (str.equalsIgnoreCase("0")) {
            selectBloodPressure();
        } else {
            selectBloodSugar();
        }

        btn_blood_pressure.setOnClickListener(this);
        btn_blood_sugar.setOnClickListener(this);
    }

    private void selectBloodPressure() {
        ImageViewCompat.setImageTintList(bp, ColorStateList.valueOf(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.tab_text)));
        ImageViewCompat.setImageTintList(bs, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.lightblack)));
        view2.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        new AppDataPushApi().callApi(getActivity(),"Health Register","Health register tabs","User clicked on blood pressure diary");
        addFragment(new FragmentBloodPressureChart(), FragmentsHealthTags.REGISTER_BLOOD_PRESSURE_TAG);
    }

    private void selectBloodSugar() {
        ImageViewCompat.setImageTintList(bp, ColorStateList.valueOf(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack)));
        ImageViewCompat.setImageTintList(bs, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.tab_text)));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        new AppDataPushApi().callApi(getActivity(),"Health Register","Health register tabs","User clicked on blood sugar diary");
        addFragment(new FragmentBloodSugarChart(), FragmentsHealthTags.REGISTER_BLOOD_SUGAR_TAG);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_blood_pressure:
            selectBloodPressure();
            break;

            case R.id.btn_blood_sugar:
            selectBloodSugar();
            break;
        }
    }

    private void addFragment(Fragment frg, String name) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.health_register_container, frg);
        childFragTrans.commit();
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).detect(name);
    }
}
