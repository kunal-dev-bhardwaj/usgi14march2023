package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.PolicyDetailModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.google.gson.Gson;

public class FragmentVehiclePolicy extends Fragment {
    private View v;
    private MySharedPreference prefrences;
    private TextView edt_booked_reg_no;
    private TextView edt_booked_make;
    private TextView edt_booked_model;
    private TextView edt_booked_engine_no;
    private TextView edt_booked_chassis_no;
    private TextView edt_manufacturing_year;
    private LinearLayout manufacturing_year;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_vehicle_tab, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        initView();
        return v;
    }

    private void initView() {
        edt_booked_reg_no = v.findViewById(R.id.edt_booked_reg_no);
        edt_booked_make = v.findViewById(R.id.edt_booked_make);
        edt_booked_model = v.findViewById(R.id.edt_booked_model);
        edt_booked_engine_no = v.findViewById(R.id.edt_booked_engine_no);
        edt_booked_chassis_no = v.findViewById(R.id.edt_booked_chassis_no);
        edt_manufacturing_year = v.findViewById(R.id.edt_manufacturing_year);
        manufacturing_year = v.findViewById(R.id.manufacturing_year);
        initializeData();
    }

    @SuppressLint("SetTextI18n")
    private void initializeData() {
        PolicyDetailModel data = new Gson().fromJson(prefrences.getRenewalPolicyDetail(), PolicyDetailModel.class);
        if (data.getRegistrationNumber() != null) {
            edt_booked_reg_no.setText(data.getRegistrationNumber());
        } else {
            edt_booked_reg_no.setText("");
        }

        if (data.getMake() != null) {
            edt_booked_make.setText("" + data.getMake());
        } else {
            edt_booked_make.setText("");
        }

        if (data.getModel() != null) {
            edt_booked_model.setText("" + data.getModel());
        } else {
            edt_booked_model.setText("");
        }

        if (data.getEngineNo() != null) {
            edt_booked_engine_no.setText("" + data.getEngineNo());
        } else {
            edt_booked_engine_no.setText("");
        }

        if (data.getChassisNo() != null) {
            edt_booked_chassis_no.setText("" + data.getChassisNo());
        } else {
            edt_booked_chassis_no.setText("");
        }

        if (data.getMfgYear() != null) {
            manufacturing_year.setVisibility(View.VISIBLE);
            edt_manufacturing_year.setText("" + data.getMfgYear());
        } else {
            manufacturing_year.setVisibility(View.GONE);
        }
    }
}

