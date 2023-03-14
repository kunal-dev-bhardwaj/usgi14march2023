package com.universalsompo.meta.metaapp.health.fragment.calculators;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.Objects;

public class FragmentCalculatorMenu extends Fragment implements View.OnClickListener {
    private View v;
    private MySharedPreference pref;
    private LinearLayout ll_bmi, ll_whr, ll_bmr, ll_bfp, ll_cr, ll_hypr, ll_dr, ll_bac, ll_sr, ll_hw, ll_pc;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_calculator_new_design, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    private void init() {
        String gender = pref.getgender();
        ll_bmi = v.findViewById(R.id.ll_bmi);
        ll_whr = v.findViewById(R.id.ll_whr);
        ll_bmr = v.findViewById(R.id.ll_bmr);
        ll_bfp = v.findViewById(R.id.ll_bfp);
        ll_cr = v.findViewById(R.id.ll_cr);
        ll_hypr = v.findViewById(R.id.ll_hypr);
        ll_dr = v.findViewById(R.id.ll_dr);
        ll_bac = v.findViewById(R.id.ll_bac);
        ll_sr = v.findViewById(R.id.ll_sr);
        ll_hw = v.findViewById(R.id.ll_hw);
        ll_pc = v.findViewById(R.id.ll_pc);
        View preg_view = v.findViewById(R.id.preg_view);

        if (gender.equalsIgnoreCase("Male")) {
            ll_pc.setVisibility(View.GONE);
            preg_view.setVisibility(View.GONE);
        } else {
            ll_pc.setVisibility(View.GONE);
            preg_view.setVisibility(View.GONE);
          /*  ll_pc.setVisibility(View.VISIBLE);
            preg_view.setVisibility(View.VISIBLE);*/
        }

        ll_bmi.setOnClickListener(this);
        ll_whr.setOnClickListener(this);
        ll_bmr.setOnClickListener(this);
        ll_bfp.setOnClickListener(this);
        ll_cr.setOnClickListener(this);
        ll_hypr.setOnClickListener(this);
        ll_dr.setOnClickListener(this);
        ll_bac.setOnClickListener(this);
        ll_sr.setOnClickListener(this);
        ll_hw.setOnClickListener(this);
        ll_pc.setOnClickListener(this);
        new AppDataPushApi().callApi(getActivity(),"Calculators","BMI","User clicked on BMI calculator");
        addFragment(new BMICalcFragment(), FragmentsHealthTags.FRAGMENT_BMI_CALC);
    }

    private void selectBMI() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","BMI","User clicked on BMI calculator");
        addFragment(new BMICalcFragment(), FragmentsHealthTags.FRAGMENT_BMI_CALC);
    }

    private void selectWHR() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","WHR","User clicked on WHR calculator");
        addFragment(new WHRCalculator(), FragmentsHealthTags.FRAGMENT_WHR_CALC);
    }

    private void selectBMR() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        // ll_hr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","BMR","User clicked on BMR calculator");
        addFragment(new BMRCalcFragment(), FragmentsHealthTags.FRAGMENT_BMR_CALC);
    }

    private void selectBFP() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","Body fat","User clicked on body fat calculator");
        addFragment(new BodyFatFragment(), FragmentsHealthTags.FRAGMENT_BODY_FAT_CALC);
    }

    private void selectCR() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","Cholestrol risk","User clicked on cholestrol risk calculator");
        addFragment(new CholestrolCalcFragment(), FragmentsHealthTags.FRAGMENT_CHOLESTROL_RISK_CALC);
    }

    private void selectHYPR() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","Hypertension risk","User clicked on hypertension risk calculator");
        addFragment(new BloodPressureFragment(), FragmentsHealthTags.FRAGMENT_BLOOD_PRESSURE_CALC);
    }

    private void selectDR() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","Diabetes risk","User clicked on diabetes risk calculator");
        addFragment(new BloodSugarCalcFragment(), FragmentsHealthTags.FRAGMENT_BLOOD_SUGAR_CALC);
    }

    private void selectBAC() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","BAC","User clicked on BAC calculator");
        addFragment(new BACCalcFragment(), FragmentsHealthTags.FRAGMENT_BAC_CALC);
    }

    private void selectSR() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","Smoking risk","User clicked on smoking risk calculator");
        addFragment(new SmokeCalcFragment(), FragmentsHealthTags.FRAGMENT_SMOKE_CALC);
    }

    private void selectHW() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","Healthy weight","User clicked on healthy weight calculator");
        addFragment(new HealthyweightCalcFragment(), FragmentsHealthTags.FRAGMENT_HEALTHY_WEIGHT_CALC);
    }

    private void selectPC() {
        ll_bmi.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_whr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bmr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bfp.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_cr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hypr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_dr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_bac.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_sr.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_hw.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_unselected));
        ll_pc.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.diary_nav_selected));
        new AppDataPushApi().callApi(getActivity(),"Calculators","Pregnancy","User clicked on pregnancy calculator");
        addFragment(new PregnancyCalculator(), FragmentsHealthTags.FRAGMENT_PREGNANCY_CALC);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.ll_bmi:
                selectBMI();
                break;

            case R.id.ll_pc:
                selectPC();
                break;

            case R.id.ll_bmr:
                selectBMR();
                break;

            case R.id.ll_hw:
                selectHW();
                break;

            case R.id.ll_bfp:
                selectBFP();
                break;

            case R.id.ll_cr:
                selectCR();
                break;

            case R.id.ll_sr:
                selectSR();
                break;

            case R.id.ll_bac:
                selectBAC();
                break;

            case R.id.ll_dr:
                selectDR();
                break;

            case R.id.ll_hypr:
                selectHYPR();
                break;

            case R.id.ll_whr:
                selectWHR();
                break;
        }
    }

    private void addFragment(Fragment frg, String tag_name) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.calculator_container, frg);
        childFragTrans.commit();
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).detect(tag_name);
    }
}
