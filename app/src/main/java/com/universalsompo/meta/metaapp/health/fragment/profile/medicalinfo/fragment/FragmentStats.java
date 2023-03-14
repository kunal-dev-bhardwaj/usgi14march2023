package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.GetAllergiesAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.AllergicToModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.Allergy;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.AllergyTypeModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.ReactionModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.DecimalDigitsInputFilter;
import com.universalsompo.meta.metaapp.utilities.DecimalDigitsInputFilter1;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NestedListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentStats extends Fragment implements View.OnClickListener, ResponseListener, AdapterView.OnItemSelectedListener {
    private View v;
    private MySharedPreference mySharedPreference;

    private LinearLayout blood_pressure_layout1;
    private ImageView down_arrow, up_arrow;
    private EditText systolic_value, diastolic_value;

    private LinearLayout blood_sugar_layout1;
    private ImageView down_arrow1, up_arrow1;
    private EditText sugar_fasting, sugar_pp;

    private LinearLayout hba1c_layout1;
    private ImageView down_arrow2, up_arrow2;
    private EditText hba1c_edt;

    private LinearLayout lipid_profile_layout1;
    private ImageView down_arrow3, up_arrow3;
    private EditText ldl, hdl, trig, cholestrol;

    private LinearLayout thyroid_layout1;
    private ImageView down_arrow4, up_arrow4;
    private EditText t3, t4, tsh;

    private LinearLayout allergies_layout_1;
    private LinearLayout add_allergy;
    private LinearLayout submit_clear_layout;
    private LinearLayout add_new_allergy;
    private ImageView down_arrow5, up_arrow5;
    private NestedListView get_allergy_list;
    private Spinner spn_allergy_type, spn_allergic_to, spn_reaction;
    private final ArrayList<Allergy> data = new ArrayList<>();
    private List<String> allergytypeList;
    private List<String> allergictoList;
    private List<String> reactionList;
    private List<AllergyTypeModel> allergytypeModelList;
    private List<AllergicToModel> allergictoModelList;
    private List<ReactionModel> reactionModelList;
    private String selectedAllergyTypeId = "";
    private String selectedAllergicToId = "";
    private String selectedReactionId = "";
    private ScrollView stats_scroll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_stats, container,false);
        mySharedPreference = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        callApi(RequestHealthConstants.GET_STATS_DATA);
        return v;
    }

    private void init() {
        stats_scroll = v.findViewById(R.id.stats_scroll);
        /* Blood Pressure */
        LinearLayout blood_pressure_layout = v.findViewById(R.id.blood_pressure_layout);
        blood_pressure_layout1 = v.findViewById(R.id.blood_pressure_layout1);
        down_arrow = v.findViewById(R.id.down_arrow);
        up_arrow = v.findViewById(R.id.up_arrow);
        systolic_value = v.findViewById(R.id.systolic_value);
        diastolic_value = v.findViewById(R.id.diastolic_value);
        LinearLayout tick_ok = v.findViewById(R.id.tick_ok);
        LinearLayout tick_cancel = v.findViewById(R.id.tick_cancel);
        /* Blood Sugar */
        LinearLayout blood_sugar_layout = v.findViewById(R.id.blood_sugar_layout);
        blood_sugar_layout1 = v.findViewById(R.id.blood_sugar_layout1);
        down_arrow1 = v.findViewById(R.id.down_arrow1);
        up_arrow1 = v.findViewById(R.id.up_arrow1);
        sugar_fasting = v.findViewById(R.id.sugar_fasting);
        sugar_pp = v.findViewById(R.id.sugar_pp);
        LinearLayout tick_ok1 = v.findViewById(R.id.tick_ok1);
        LinearLayout tick_cancel1 = v.findViewById(R.id.tick_cancel1);
        /* HbA1c */
        LinearLayout hba1c_layout = v.findViewById(R.id.hba1c_layout);
        hba1c_layout1 = v.findViewById(R.id.hba1c_layout1);
        down_arrow2 = v.findViewById(R.id.down_arrow2);
        up_arrow2 = v.findViewById(R.id.up_arrow2);
        hba1c_edt = v.findViewById(R.id.hba1c_edt);
        hba1c_edt.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        LinearLayout tick_ok2 = v.findViewById(R.id.tick_ok2);
        LinearLayout tick_cancel2 = v.findViewById(R.id.tick_cancel2);
        /* Lipid Profile */
        LinearLayout lipid_profile_layout = v.findViewById(R.id.lipid_profile_layout);
        lipid_profile_layout1 = v.findViewById(R.id.lipid_profile_layout1);
        down_arrow3 = v.findViewById(R.id.down_arrow3);
        up_arrow3 = v.findViewById(R.id.up_arrow3);
        ldl = v.findViewById(R.id.ldl);
        hdl = v.findViewById(R.id.hdl);
        trig = v.findViewById(R.id.trig);
        cholestrol = v.findViewById(R.id.cholestrol);
        LinearLayout tick_ok3 = v.findViewById(R.id.tick_ok3);
        LinearLayout tick_cancel3 = v.findViewById(R.id.tick_cancel3);
        /* Thyroid */
        LinearLayout thyroid_layout = v.findViewById(R.id.thyroid_layout);
        thyroid_layout1 = v.findViewById(R.id.thyroid_layout1);
        down_arrow4 = v.findViewById(R.id.down_arrow4);
        up_arrow4 = v.findViewById(R.id.up_arrow4);
        t3 = v.findViewById(R.id.t3);
        t4 = v.findViewById(R.id.t4);
        t4.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(3,1)});
        tsh = v.findViewById(R.id.tsh);
        tsh.setFilters(new InputFilter[] {new DecimalDigitsInputFilter1(2,1)});
        LinearLayout tick_ok4 = v.findViewById(R.id.tick_ok4);
        LinearLayout tick_cancel4 = v.findViewById(R.id.tick_cancel4);
        /* Allergies */
        LinearLayout allergies_layout = v.findViewById(R.id.allergies_layout);
        allergies_layout_1 = v.findViewById(R.id.allergies_layout_1);
        add_allergy = v.findViewById(R.id.add_allergy);
        submit_clear_layout = v.findViewById(R.id.submit_clear_layout);
        down_arrow5 = v.findViewById(R.id.down_arrow5);
        up_arrow5 = v.findViewById(R.id.up_arrow5);
        get_allergy_list = v.findViewById(R.id.get_allergy_list);
        spn_allergy_type = v.findViewById(R.id.spn_allergy_type);
        spn_allergic_to = v.findViewById(R.id.spn_allergic_to);
        spn_reaction = v.findViewById(R.id.spn_reaction);
        LinearLayout tick_ok5 = v.findViewById(R.id.tick_ok5);
        LinearLayout tick_cancel5 = v.findViewById(R.id.tick_cancel5);
        add_new_allergy = v.findViewById(R.id.add_new_allergy);

        assert getArguments() != null;
        String open_lipid_profile = getArguments().getString("open_lipid_profile");
        assert open_lipid_profile != null;
        if (open_lipid_profile.equalsIgnoreCase("1")) {
            lipid_profile_layout1.setVisibility(View.VISIBLE);
            down_arrow3.setVisibility(View.GONE);
            up_arrow3.setVisibility(View.VISIBLE);
        } else {
            lipid_profile_layout1.setVisibility(View.GONE);
            down_arrow3.setVisibility(View.VISIBLE);
            up_arrow3.setVisibility(View.GONE);
        }

        /* Blood Pressure */
        blood_pressure_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blood_pressure_layout1.getVisibility() == View.VISIBLE){
                    blood_pressure_layout1.setVisibility(View.GONE);
                    down_arrow.setVisibility(View.VISIBLE);
                    up_arrow.setVisibility(View.GONE);
                } else {
                    blood_pressure_layout1.setVisibility(View.VISIBLE);
                    down_arrow.setVisibility(View.GONE);
                    up_arrow.setVisibility(View.VISIBLE);
                }
                // blood_pressure_layout1.setVisibility(View.VISIBLE);
                blood_sugar_layout1.setVisibility(View.GONE);
                hba1c_layout1.setVisibility(View.GONE);
                lipid_profile_layout1.setVisibility(View.GONE);
                thyroid_layout1.setVisibility(View.GONE);
                allergies_layout_1.setVisibility(View.GONE);
                add_new_allergy.setVisibility(View.GONE);
                // down_arrow.setVisibility(View.GONE);
                // up_arrow.setVisibility(View.VISIBLE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                down_arrow4.setVisibility(View.VISIBLE);
                up_arrow4.setVisibility(View.GONE);
                down_arrow5.setVisibility(View.VISIBLE);
                up_arrow5.setVisibility(View.GONE);
            }
        });

        /* Blood Sugar */
        blood_sugar_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blood_sugar_layout1.getVisibility() == View.VISIBLE){
                    blood_sugar_layout1.setVisibility(View.GONE);
                    down_arrow1.setVisibility(View.VISIBLE);
                    up_arrow1.setVisibility(View.GONE);
                } else {
                    blood_sugar_layout1.setVisibility(View.VISIBLE);
                    down_arrow1.setVisibility(View.GONE);
                    up_arrow1.setVisibility(View.VISIBLE);
                }
                blood_pressure_layout1.setVisibility(View.GONE);
                // blood_sugar_layout1.setVisibility(View.VISIBLE);
                hba1c_layout1.setVisibility(View.GONE);
                lipid_profile_layout1.setVisibility(View.GONE);
                thyroid_layout1.setVisibility(View.GONE);
                allergies_layout_1.setVisibility(View.GONE);
                add_new_allergy.setVisibility(View.GONE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                // down_arrow1.setVisibility(View.GONE);
                // up_arrow1.setVisibility(View.VISIBLE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                down_arrow4.setVisibility(View.VISIBLE);
                up_arrow4.setVisibility(View.GONE);
                down_arrow5.setVisibility(View.VISIBLE);
                up_arrow5.setVisibility(View.GONE);
            }
        });

        /* HbA1c */
        hba1c_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hba1c_layout1.getVisibility() == View.VISIBLE){
                    hba1c_layout1.setVisibility(View.GONE);
                    down_arrow2.setVisibility(View.VISIBLE);
                    up_arrow2.setVisibility(View.GONE);
                } else {
                    hba1c_layout1.setVisibility(View.VISIBLE);
                    down_arrow2.setVisibility(View.GONE);
                    up_arrow2.setVisibility(View.VISIBLE);
                }
                blood_pressure_layout1.setVisibility(View.GONE);
                blood_sugar_layout1.setVisibility(View.GONE);
                // hba1c_layout1.setVisibility(View.VISIBLE);
                lipid_profile_layout1.setVisibility(View.GONE);
                thyroid_layout1.setVisibility(View.GONE);
                allergies_layout_1.setVisibility(View.GONE);
                add_new_allergy.setVisibility(View.GONE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                // down_arrow2.setVisibility(View.GONE);
                // up_arrow2.setVisibility(View.VISIBLE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                down_arrow4.setVisibility(View.VISIBLE);
                up_arrow4.setVisibility(View.GONE);
                down_arrow5.setVisibility(View.VISIBLE);
                up_arrow5.setVisibility(View.GONE);
            }
        });

        /* Lipid Profile */
        lipid_profile_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lipid_profile_layout1.getVisibility() == View.VISIBLE){
                    lipid_profile_layout1.setVisibility(View.GONE);
                    down_arrow3.setVisibility(View.VISIBLE);
                    up_arrow3.setVisibility(View.GONE);
                } else {
                    lipid_profile_layout1.setVisibility(View.VISIBLE);
                    down_arrow3.setVisibility(View.GONE);
                    up_arrow3.setVisibility(View.VISIBLE);
                }
                blood_pressure_layout1.setVisibility(View.GONE);
                blood_sugar_layout1.setVisibility(View.GONE);
                hba1c_layout1.setVisibility(View.GONE);
                // lipid_profile_layout1.setVisibility(View.VISIBLE);
                thyroid_layout1.setVisibility(View.GONE);
                allergies_layout_1.setVisibility(View.GONE);
                add_new_allergy.setVisibility(View.GONE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                // down_arrow3.setVisibility(View.GONE);
                // up_arrow3.setVisibility(View.VISIBLE);
                down_arrow4.setVisibility(View.VISIBLE);
                up_arrow4.setVisibility(View.GONE);
                down_arrow5.setVisibility(View.VISIBLE);
                up_arrow5.setVisibility(View.GONE);
            }
        });

        /* Thyroid */
        thyroid_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thyroid_layout1.getVisibility() == View.VISIBLE){
                    thyroid_layout1.setVisibility(View.GONE);
                    down_arrow4.setVisibility(View.VISIBLE);
                    up_arrow4.setVisibility(View.GONE);
                } else {
                    thyroid_layout1.setVisibility(View.VISIBLE);
                    down_arrow4.setVisibility(View.GONE);
                    up_arrow4.setVisibility(View.VISIBLE);
                }
                blood_pressure_layout1.setVisibility(View.GONE);
                blood_sugar_layout1.setVisibility(View.GONE);
                hba1c_layout1.setVisibility(View.GONE);
                lipid_profile_layout1.setVisibility(View.GONE);
                // thyroid_layout1.setVisibility(View.VISIBLE);
                allergies_layout_1.setVisibility(View.GONE);
                add_new_allergy.setVisibility(View.GONE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                // down_arrow4.setVisibility(View.GONE);
                // up_arrow4.setVisibility(View.VISIBLE);
                down_arrow5.setVisibility(View.VISIBLE);
                up_arrow5.setVisibility(View.GONE);
            }
        });

        /* Allergies */
        allergies_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergies_layout_1.getVisibility() == View.VISIBLE){
                    allergies_layout_1.setVisibility(View.GONE);
                    down_arrow5.setVisibility(View.VISIBLE);
                    up_arrow5.setVisibility(View.GONE);
                    add_new_allergy.setVisibility(View.GONE);
                } else {
                    allergies_layout_1.setVisibility(View.VISIBLE);
                    down_arrow5.setVisibility(View.GONE);
                    up_arrow5.setVisibility(View.VISIBLE);
                    add_new_allergy.setVisibility(View.VISIBLE);
                }
                callApi(RequestHealthConstants.GET_USER_HEALTH_DATA);
                blood_pressure_layout1.setVisibility(View.GONE);
                blood_sugar_layout1.setVisibility(View.GONE);
                hba1c_layout1.setVisibility(View.GONE);
                lipid_profile_layout1.setVisibility(View.GONE);
                thyroid_layout1.setVisibility(View.GONE);
                // allergies_layout_1.setVisibility(View.VISIBLE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                down_arrow4.setVisibility(View.VISIBLE);
                up_arrow4.setVisibility(View.GONE);
                // down_arrow5.setVisibility(View.GONE);
                // up_arrow5.setVisibility(View.VISIBLE);
            }
        });

        tick_ok.setOnClickListener(this);
        tick_cancel.setOnClickListener(this);
        tick_ok1.setOnClickListener(this);
        tick_cancel1.setOnClickListener(this);
        tick_ok2.setOnClickListener(this);
        tick_cancel2.setOnClickListener(this);
        tick_ok3.setOnClickListener(this);
        tick_cancel3.setOnClickListener(this);
        tick_ok4.setOnClickListener(this);
        tick_cancel4.setOnClickListener(this);
        spn_allergy_type.setOnItemSelectedListener(this);
        spn_allergic_to.setOnItemSelectedListener(this);
        spn_reaction.setOnItemSelectedListener(this);
        tick_ok5.setOnClickListener(this);
        tick_cancel5.setOnClickListener(this);
        add_new_allergy.setOnClickListener(this);

        allergytypeList = new ArrayList<>();
        allergictoList = new ArrayList<>();
        reactionList = new ArrayList<>();
        allergytypeModelList = new ArrayList<>();
        allergictoModelList = new ArrayList<>();
        reactionModelList = new ArrayList<>();
    }

    public void getallergydetails(){
        callApi(RequestHealthConstants.GET_USER_HEALTH_DATA);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spn_allergy_type:
                if (allergytypeModelList.size() > 0) {
                    selectedAllergyTypeId = allergytypeModelList.get(position).getTypeId();
                }
                if (!selectedAllergyTypeId.equals("")) {
                    spn_allergic_to.setEnabled(true);
                    LogUtils.showLog("ALLERGY TYPE ID", selectedAllergyTypeId);
                    callApi(RequestHealthConstants.GET_ALLERGIC_TO);
                }
                break;

            case R.id.spn_allergic_to:
                if (allergictoModelList.size() > 0) {
                    selectedAllergicToId = allergictoModelList.get(position).getTypeId();
                }
                if (!selectedAllergicToId.equals("")) {
                    spn_reaction.setEnabled(true);
                    LogUtils.showLog("ALLERGIC TO ID", selectedAllergicToId);
                }
                break;

            case R.id.spn_reaction:
                if (reactionModelList.size() > 0) {
                    LogUtils.showLog("REACTION ID", selectedReactionId);
                    selectedReactionId = reactionModelList.get(position).getTypeId();
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.tick_ok:

                int sys_value = Integer.parseInt(systolic_value.getText().toString().trim());
                int dia_value = Integer.parseInt(diastolic_value.getText().toString().trim());
                if(systolic_value.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your systolic value", Toast.LENGTH_SHORT).show();
                } else if (diastolic_value.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your diastolic value", Toast.LENGTH_SHORT).show();
                } else if (sys_value>179&&sys_value<201){
                    if (dia_value>109&&dia_value<121){
                        Toast.makeText(getActivity(), "Immediately seek medical attention.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                    } else if (dia_value>120){
                        Toast.makeText(getActivity(), "Diastolic value should not be greater than 120.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                    } else if (dia_value>49&& dia_value<61){
                        Toast.makeText(getActivity(), "Immediately seek medical attention.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                    } else if (dia_value<50){
                        Toast.makeText(getActivity(), "Diastolic value should not be less than 50.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Systolic value should not be greater than 180.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                    }
                } else if (sys_value>200){
                    Toast.makeText(getActivity(), "Please enter a valid value", Toast.LENGTH_SHORT).show();
                } else if (sys_value<91&&sys_value>79){
                    if (dia_value>109&&dia_value<121){
                        Toast.makeText(getActivity(), "Diastolic value should not be greater than 110.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                    } else if (dia_value>120){
                        Toast.makeText(getActivity(), "Diastolic value should not be greater than 120.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                    } else if (dia_value>49&& dia_value<61){
                        Toast.makeText(getActivity(), "Diastolic value should not be less than 60.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                    }else if (dia_value<50){
                        Toast.makeText(getActivity(), "Diastolic value should not be less than 50.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Systolic value should not be less than 90.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                    }
                } else if (sys_value<80){
                    Toast.makeText(getActivity(), "Systolic value should not be less than 80.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                }
                /*int sys_value = Integer.parseInt(systolic_value.getText().toString());
                int dia_value = Integer.parseInt(diastolic_value.getText().toString());
                if(systolic_value.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your systolic value", Toast.LENGTH_SHORT).show();
                } else if (sys_value>180){
                    Toast.makeText(getActivity(), "Systolic value should not be greater than 180.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                } else if (sys_value<90){
                    Toast.makeText(getActivity(), "Systolic value should not be less than 90.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                } else if (diastolic_value.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your diastolic value", Toast.LENGTH_SHORT).show();
                } else if (dia_value>110){
                    Toast.makeText(getActivity(), "diastolic value should not be greater than 110.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                } else if (dia_value<60){
                    Toast.makeText(getActivity(), "Systolic value should not be less than 60.\nImmediately seek medical attention.", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
                }*/
                break;

            case R.id.tick_cancel:
                blood_pressure_layout1.setVisibility(View.GONE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                break;

            case R.id.tick_ok1:
                if(sugar_fasting.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your sugar fasting value", Toast.LENGTH_SHORT).show();
                } else if (sugar_pp.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your sugar-pp value", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(sugar_fasting.getText().toString())<70){
                    Toast.makeText(getActivity(), "The values indicate very low blood sugar levels.\nConsult a doctor immediately.", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(sugar_fasting.getText().toString())>109&&Integer.parseInt(sugar_fasting.getText().toString())<127){
                    if (Integer.parseInt(sugar_pp.getText().toString())>139&&Integer.parseInt(sugar_pp.getText().toString())<201){
                        Toast.makeText(getActivity(), "Control your sugar intake\nas the value places you in pre-diabetic category.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                    } else if (Integer.parseInt(sugar_pp.getText().toString())>200&&Integer.parseInt(sugar_pp.getText().toString())<251){
                        Toast.makeText(getActivity(), "The value entered by you indicates you have diabetes.\nEat a healthy diet and exercise regularly to manage your sugar levels", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                    } else if (Integer.parseInt(sugar_pp.getText().toString())>250){
                        Toast.makeText(getActivity(), "The values indicate very high blood sugar levels.\nConsult a doctor immediately.", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(sugar_pp.getText().toString())<100){
                        Toast.makeText(getActivity(), "The values indicate very high blood sugar levels.\nConsult a doctor immediately.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Control your sugar intake\nas the value places you in pre-diabetic category.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                    }
                } else if (Integer.parseInt(sugar_fasting.getText().toString())>126&&Integer.parseInt(sugar_fasting.getText().toString())<151){
                    if (Integer.parseInt(sugar_pp.getText().toString())>139&&Integer.parseInt(sugar_pp.getText().toString())<201){
                        Toast.makeText(getActivity(), "Control your sugar intake\nas the value places you in pre-diabetic category.", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                    } else if (Integer.parseInt(sugar_pp.getText().toString())>200&&Integer.parseInt(sugar_pp.getText().toString())<251){
                        Toast.makeText(getActivity(), "The value entered by you indicates you have diabetes.\nEat a healthy diet and exercise regularly to manage your sugar levels", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                    } else if (Integer.parseInt(sugar_pp.getText().toString())>250){
                        Toast.makeText(getActivity(), "The values indicate very high blood sugar levels.\nConsult a doctor immediately.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "The value entered by you indicates you have diabetes.\nEat a healthy diet and exercise regularly to manage your sugar levels", Toast.LENGTH_SHORT).show();
                        callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                    }
                } else if (Integer.parseInt(sugar_pp.getText().toString())>139&&Integer.parseInt(sugar_pp.getText().toString())<201){
                    Toast.makeText(getActivity(), "Control your sugar intake\nas the value places you in pre-diabetic category.", Toast.LENGTH_SHORT).show();
                    callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                } else if (Integer.parseInt(sugar_pp.getText().toString())>200&&Integer.parseInt(sugar_pp.getText().toString())<251){
                    Toast.makeText(getActivity(), "The value entered by you indicates you have diabetes.\nEat a healthy diet and exercise regularly to manage your sugar levels", Toast.LENGTH_SHORT).show();
                    callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                } else if (Integer.parseInt(sugar_pp.getText().toString())>250){
                    Toast.makeText(getActivity(), "The values indicate very high blood sugar levels.\nConsult a doctor immediately.", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(sugar_fasting.getText().toString())>150){
                    Toast.makeText(getActivity(), "The values indicate very high blood sugar levels.\nConsult a doctor immediately.", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                }
                /*if(sugar_fasting.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your sugar fasting value", Toast.LENGTH_SHORT).show();
                } else if (sugar_pp.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your sugar-pp value", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_BLOOD_SUGAR);
                }*/
                break;

            case R.id.tick_cancel1:
                blood_sugar_layout1.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                break;

            case R.id.tick_ok2:
                if(hba1c_edt.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your HbA1c value", Toast.LENGTH_SHORT).show();
                } else if (Float.parseFloat(hba1c_edt.getText().toString())>=5.7&&Float.parseFloat(hba1c_edt.getText().toString())<=6.5){
                    Toast.makeText(getActivity(), "Control your sugar intake \nas the value places you in pre-diabetic category.", Toast.LENGTH_SHORT).show();
                    callApi(RequestHealthConstants.UPDATE_HBA1C);
                } else if (Float.parseFloat(hba1c_edt.getText().toString())>=6.6&&Float.parseFloat(hba1c_edt.getText().toString())<=7.5){
                    Toast.makeText(getActivity(), "The value entered by you indicates you have diabetes. \nEat a healthy diet and exercise regularly to manage your sugar levels", Toast.LENGTH_SHORT).show();
                    callApi(RequestHealthConstants.UPDATE_HBA1C);
                } else if (Float.parseFloat(hba1c_edt.getText().toString())>7.5){
                    Toast.makeText(getActivity(), "The values indicate very high blood sugar levels. Consult a doctor immediately.", Toast.LENGTH_SHORT).show();
                } else if (Float.parseFloat(hba1c_edt.getText().toString())<4.0){
                    Toast.makeText(getActivity(), "The values indicate very low blood sugar levels. Consult a doctor immediately.", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_HBA1C);
                }
                /*if(hba1c_edt.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your HbA1c value", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_HBA1C);
                }*/
                break;

            case R.id.tick_cancel2:
                hba1c_layout1.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                break;

            case R.id.tick_ok3:
                if(ldl.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your LDL value", Toast.LENGTH_SHORT).show();
                } else if(hdl.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your HDL value", Toast.LENGTH_SHORT).show();
                } else if(trig.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your triglyceride value", Toast.LENGTH_SHORT).show();
                } else if(cholestrol.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your total cholestrol value", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_LIPID_PROFILE);
                }
                break;

            case R.id.tick_cancel3:
                lipid_profile_layout1.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                break;

            case R.id.tick_ok4:
                if(t3.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your T3 value", Toast.LENGTH_SHORT).show();
                } else if(t4.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your T4 value", Toast.LENGTH_SHORT).show();
                } else if(tsh.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getActivity(), "Please enter your TSH value", Toast.LENGTH_SHORT).show();
                } else {
                    callApi(RequestHealthConstants.UPDATE_THYROID);
                }
                break;

            case R.id.tick_cancel4:
                thyroid_layout1.setVisibility(View.GONE);
                down_arrow4.setVisibility(View.VISIBLE);
                up_arrow4.setVisibility(View.GONE);
                break;

            case R.id.tick_ok5:
                callApi(RequestHealthConstants.SAVE_ALLERGY_DATA);
                break;

            case R.id.tick_cancel5:
                allergies_layout_1.setVisibility(View.VISIBLE);
                add_allergy.setVisibility(View.GONE);
                submit_clear_layout.setVisibility(View.GONE);
                down_arrow5.setVisibility(View.GONE);
                up_arrow5.setVisibility(View.VISIBLE);
                add_new_allergy.setVisibility(View.VISIBLE);
                break;

            case R.id.add_new_allergy:
                if(add_allergy.getVisibility() != View.VISIBLE && submit_clear_layout.getVisibility() != View.VISIBLE){
                    add_allergy.setVisibility(View.VISIBLE);
                    submit_clear_layout.setVisibility(View.VISIBLE);
                    add_new_allergy.setVisibility(View.GONE);
                }
                stats_scroll.scrollTo(0, stats_scroll.getMaxScrollAmount());
                callApi(RequestHealthConstants.GET_ALLERGY_TYPE);
                callApi(RequestHealthConstants.GET_REACTION);
                break;
        }
    }

    private void callApi(Integer id) {
        /* Get user health data */
        if (id == RequestHealthConstants.GET_USER_HEALTH_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_USER_HEALTH_DATA, this, RequestHealthConstants.GET_USER_HEALTH_DATA);
            req.execute();
        }

        /* Get user stats data */
        else if (id == RequestHealthConstants.GET_STATS_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_STATS_DATA, this, RequestHealthConstants.GET_STATS_DATA);
            req.execute();
        }

        /* Update blood pressure */
        else if (id == RequestHealthConstants.UPDATE_BLOOD_PRESSURE) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
                object.put("Systolic", systolic_value.getText().toString().trim());
                object.put("Diastolic", diastolic_value.getText().toString().trim());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.UPDATE_BLOOD_PRESSURE, this, RequestHealthConstants.UPDATE_BLOOD_PRESSURE);
            req.execute();
        }

        /* Update blood sugar */
        else if (id == RequestHealthConstants.UPDATE_BLOOD_SUGAR) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
                object.put("Random", "");
                object.put("Fasting", sugar_fasting.getText().toString());
                object.put("PP", sugar_pp.getText().toString());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.UPDATE_BLOOD_SUGAR, this, RequestHealthConstants.UPDATE_BLOOD_SUGAR);
            req.execute();
        }

        /* Update hba1c */
        else if (id == RequestHealthConstants.UPDATE_HBA1C) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
                object.put("Hb1Ac", hba1c_edt.getText().toString());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.UPDATE_HBA1C, this, RequestHealthConstants.UPDATE_HBA1C);
            req.execute();
        }

        /* Update Lipid Profile */
        else if (id == RequestHealthConstants.UPDATE_LIPID_PROFILE) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
                object.put("LDL", ldl.getText().toString());
                object.put("HDL", hdl.getText().toString());
                object.put("Triglyceride", trig.getText().toString());
                object.put("Total_Cholesterol", cholestrol.getText().toString());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.UPDATE_LIPID_PROFILE, this, RequestHealthConstants.UPDATE_LIPID_PROFILE);
            req.execute();
        }

        /* Update Thyroid */
        else if (id == RequestHealthConstants.UPDATE_THYROID) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
                object.put("T3", t3.getText().toString());
                object.put("T4", t4.getText().toString());
                object.put("TSH", tsh.getText().toString());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.UPDATE_THYROID, this, RequestHealthConstants.UPDATE_THYROID);
            req.execute();
        }

        /* Get Allergy Type */
        else if (id == RequestHealthConstants.GET_ALLERGY_TYPE) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_ALLERGY_TYPE, this, RequestHealthConstants.GET_ALLERGY_TYPE);
            req.execute();
        }

        /* Get Allergy To */
        else if (id == RequestHealthConstants.GET_ALLERGIC_TO) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
                object.put("TypeID", selectedAllergyTypeId);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_ALLERGIC_TO, this, RequestHealthConstants.GET_ALLERGIC_TO);
            req.execute();
        }

        /* Get Allergy Type */
        else if (id == RequestHealthConstants.GET_REACTION) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_REACTION, this, RequestHealthConstants.GET_REACTION);
            req.execute();
        }

        /* Save allergy data */
        else if (id == RequestHealthConstants.SAVE_ALLERGY_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("ID", "0");
                object.put("UserID", mySharedPreference.getUID());
                object.put("AllergiesTypeID", selectedAllergyTypeId);
                object.put("AllergiesID", selectedAllergicToId);
                object.put("ReactionID", selectedReactionId);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_ALLERGY_DATA, this, RequestHealthConstants.SAVE_ALLERGY_DATA);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {

        /* User stats data */
        if (Tag == RequestHealthConstants.GET_STATS_DATA){
            if (object.optString("Message").equals("Success")){
                if (object.isNull("Systolic") || object.optString("Systolic").equalsIgnoreCase("0") || object.optString("Systolic").isEmpty()) {
                    systolic_value.setText("00");
                } else {
                    systolic_value.setText(object.optString("Systolic"));
                }

                if (object.isNull("Diastolic") || object.optString("Diastolic").equalsIgnoreCase("0") || object.optString("Diastolic").isEmpty()) {
                    diastolic_value.setText("00");
                } else {
                    diastolic_value.setText(object.optString("Diastolic"));
                }

                if (object.isNull("BloodSugerFasting") || object.optString("BloodSugerFasting").equalsIgnoreCase("0") || object.optString("BloodSugerFasting").isEmpty()) {
                    sugar_fasting.setText("00");
                } else {
                    sugar_fasting.setText(object.optString("BloodSugerFasting"));
                }

                if (object.isNull("BloodSugerPP") || object.optString("BloodSugerPP").equalsIgnoreCase("0") || object.optString("BloodSugerPP").isEmpty()) {
                    sugar_pp.setText("00");
                } else {
                    sugar_pp.setText(object.optString("BloodSugerPP"));
                }

                if (object.isNull("Hb1Ac") || object.optString("Hb1Ac").equalsIgnoreCase("0") || object.optString("Hb1Ac").isEmpty()) {
                    hba1c_edt.setText("00");
                } else {
                    hba1c_edt.setText(object.optString("Hb1Ac"));
                }

                if (object.isNull("LDL") || object.optString("LDL").equalsIgnoreCase("0") || object.optString("LDL").isEmpty()) {
                    ldl.setText("00");
                } else {
                    ldl.setText(object.optString("LDL"));
                }

                if (object.isNull("HDL") || object.optString("HDL").equalsIgnoreCase("0") || object.optString("HDL").isEmpty()) {
                    hdl.setText("00");
                } else {
                    hdl.setText(object.optString("HDL"));
                }

                if (object.isNull("Triglyceride") || object.optString("Triglyceride").equalsIgnoreCase("0") || object.optString("Triglyceride").isEmpty()) {
                    trig.setText("00");
                } else {
                    trig.setText(object.optString("Triglyceride"));
                }

                if (object.isNull("TotalCholesterol") || object.optString("TotalCholesterol").equalsIgnoreCase("0") || object.optString("TotalCholesterol").isEmpty()) {
                    cholestrol.setText("00");
                } else {
                    cholestrol.setText(object.optString("TotalCholesterol"));
                }

                if (object.isNull("T3") || object.optString("T3").equalsIgnoreCase("0") || object.optString("T3").isEmpty()) {
                    t3.setText("00");
                } else {
                    t3.setText(object.optString("T3"));
                }

                if (object.isNull("T4") || object.optString("T4").equalsIgnoreCase("0") || object.optString("T4").isEmpty()) {
                    t4.setText("00");
                } else {
                    t4.setText(object.optString("T4"));
                }

                if (object.isNull("TSH") || object.optString("TSH").equalsIgnoreCase("0") || object.optString("TSH").isEmpty()) {
                    tsh.setText("00");
                } else {
                    tsh.setText(object.optString("TSH"));
                }

            } else {
                systolic_value.setText("00");
                diastolic_value.setText("00");
                sugar_fasting.setText("00");
                sugar_pp.setText("00");
                hba1c_edt.setText("00");
                ldl.setText("00");
                hdl.setText("00");
                trig.setText("00");
                cholestrol.setText("00");
                t3.setText("00");
                t4.setText("00");
                tsh.setText("00");
            }
        }

        /* Blood Pressure Update */
        else if (Tag == RequestHealthConstants.UPDATE_BLOOD_PRESSURE){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                blood_pressure_layout1.setVisibility(View.GONE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                systolic_value.clearFocus();
                diastolic_value.clearFocus();
            } else {
                Toast.makeText(getActivity(), "Unable to update your blood pressure values", Toast.LENGTH_SHORT).show();
            }
        }

        /* Blood Sugar Update */
        else if (Tag == RequestHealthConstants.UPDATE_BLOOD_SUGAR){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                blood_sugar_layout1.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                sugar_fasting.clearFocus();
                sugar_pp.clearFocus();
            } else {
                Toast.makeText(getActivity(), "Unable to update your blood sugar values", Toast.LENGTH_SHORT).show();
            }
        }

        /* HbA1c Update */
        else if (Tag == RequestHealthConstants.UPDATE_HBA1C){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                hba1c_layout1.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                hba1c_edt.clearFocus();
            } else {
                Toast.makeText(getActivity(), "Unable to update your HbA1c value", Toast.LENGTH_SHORT).show();
            }
        }

        /* Lipid Profile Update */
        else if (Tag == RequestHealthConstants.UPDATE_LIPID_PROFILE){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                lipid_profile_layout1.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                ldl.clearFocus();
                hdl.clearFocus();
                trig.clearFocus();
                cholestrol.clearFocus();
            } else {
                Toast.makeText(getActivity(), "Unable to update your lipid profile values", Toast.LENGTH_SHORT).show();
            }
        }

        /* Thyroid Update */
        else if (Tag == RequestHealthConstants.UPDATE_THYROID){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                thyroid_layout1.setVisibility(View.GONE);
                down_arrow4.setVisibility(View.VISIBLE);
                up_arrow4.setVisibility(View.GONE);
                t3.clearFocus();
                t4.clearFocus();
                tsh.clearFocus();
            } else {
                Toast.makeText(getActivity(), "Unable to update your thyroid values", Toast.LENGTH_SHORT).show();
            }
        }

        /* Allergy list */
        else if (Tag == RequestHealthConstants.GET_USER_HEALTH_DATA){
            if (object.optString("Message").equals("Success")){
                get_allergy_list.setVisibility(View.VISIBLE);
                add_allergy.setVisibility(View.GONE);
                submit_clear_layout.setVisibility(View.GONE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("UsersAllergiesRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new Allergy(
                                        obj.optString("Allergies"),
                                        obj.optString("AllergiesID"),
                                        obj.optString("AllergiesType"),
                                        obj.optString("AllergiesTypeID"),
                                        obj.optString("ID"),
                                        obj.optString("Reaction"),
                                        obj.optString("ReactionID")
                                )
                        );
                    }

                    GetAllergiesAdapter getAllergiesAdapter = new GetAllergiesAdapter(getActivity(), data, allergies_layout_1, down_arrow5, up_arrow5);
                    get_allergy_list.setAdapter(getAllergiesAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                add_allergy.setVisibility(View.VISIBLE);
                submit_clear_layout.setVisibility(View.VISIBLE);
                get_allergy_list.setVisibility(View.GONE);
                stats_scroll.scrollTo(0, stats_scroll.getMaxScrollAmount());
                callApi(RequestHealthConstants.GET_ALLERGY_TYPE);
                callApi(RequestHealthConstants.GET_REACTION);
            }
        }

        else if(Tag == RequestHealthConstants.GET_ALLERGY_TYPE){
            try {
                allergytypeList.clear();
                JSONArray arr = object.getJSONArray("objMasterTypeRes");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    allergytypeModelList.add(new AllergyTypeModel(obj.getString("TypeId"), obj.getString("TypeName")));
                    allergytypeList.add(obj.optString("TypeName"));
                }
                ArrayAdapter<String> allergytypeArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, allergytypeList);

                spn_allergy_type.setAdapter(allergytypeArrayAdapter);

                ArrayAdapter myAdap = (ArrayAdapter) spn_allergy_type.getAdapter();
                String selectedAllergyType = "";
                int spinnerPosition = myAdap.getPosition(selectedAllergyType);
                spn_allergy_type.setSelection(spinnerPosition);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        else if(Tag == RequestHealthConstants.GET_ALLERGIC_TO){
            try {
                allergictoModelList.clear();
                allergictoList.clear();
                JSONArray arr = object.getJSONArray("objMasterAllergiesRes");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    allergictoModelList.add(new AllergicToModel(obj.getString("AllergiesId"), obj.getString("AllergiesName")));
                    allergictoList.add(obj.optString("AllergiesName"));
                }
                ArrayAdapter<String> allergictoArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, allergictoList);

                spn_allergic_to.setAdapter(allergictoArrayAdapter);

                ArrayAdapter myAdap1 = (ArrayAdapter) spn_allergic_to.getAdapter();
                String selectedAllergicTo = "";
                int spinnerPosition1 = myAdap1.getPosition(selectedAllergicTo);
                spn_allergic_to.setSelection(spinnerPosition1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        else if(Tag == RequestHealthConstants.GET_REACTION){
            try {
                reactionList.clear();
                JSONArray arr = object.getJSONArray("objMasterReactionRes");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    reactionModelList.add(new ReactionModel(obj.getString("ReactionId"), obj.getString("ReactionName")));
                    reactionList.add(obj.optString("ReactionName"));
                }
                ArrayAdapter<String> reactionArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, reactionList);

                spn_reaction.setAdapter(reactionArrayAdapter);

                ArrayAdapter myAdap2 = (ArrayAdapter) spn_reaction.getAdapter();
                String selectedReaction = "";
                int spinnerPosition2 = myAdap2.getPosition(selectedReaction);
                spn_reaction.setSelection(spinnerPosition2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        /* Save allergy data */
        else if (Tag == RequestHealthConstants.SAVE_ALLERGY_DATA){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Added Successfully", Toast.LENGTH_SHORT).show();
                allergies_layout_1.setVisibility(View.VISIBLE);
                add_allergy.setVisibility(View.GONE);
                submit_clear_layout.setVisibility(View.GONE);
                down_arrow5.setVisibility(View.GONE);
                up_arrow5.setVisibility(View.VISIBLE);
                add_new_allergy.setVisibility(View.VISIBLE);
                callApi(RequestHealthConstants.GET_USER_HEALTH_DATA);
            } else {
                Toast.makeText(getActivity(), "Unable to add values", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
