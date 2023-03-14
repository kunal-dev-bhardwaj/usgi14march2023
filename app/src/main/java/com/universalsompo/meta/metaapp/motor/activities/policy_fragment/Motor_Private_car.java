package com.universalsompo.meta.metaapp.motor.activities.policy_fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.hbb20.CountryCodePicker;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.HospitalListActivity;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.RegisterActivity;
import com.universalsompo.meta.metaapp.motor.activities.adapter.MotorRenewalAdapter;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_vehicle_details;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_Car_Motor;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_car_vehicle_details;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Add_Details_Old_Vehicle;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Motor;
import com.universalsompo.meta.metaapp.motor.adapters.MyPolicyAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMetaOwnPolicy;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


public class Motor_Private_car extends Fragment {
    RecyclerView RcyRenewMotor;
    EditText edt_phone,edt_email,VehicleNo,edt_city,edt_name;
    Button btn_next;
    private MySharedPreference pref;
    private CheckBox chkCondition;
    CountryCodePicker ccp;
    TextView textViewNoPolicy;
    LinearLayout term_condition;
    CustomProgressDialog customDialog;
    String VehicleNumberRegex="^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$";
    RadioButton New_Policy_Radio,Renewal_Radio,TwoWheelerRadio,FourWheelerRadio,NewVehicleRadio,OldVehicleRadio;
    String selected_country_code,vehicleManufacturerType="",strModelType="",strCompanyName="",FuleType="",rc_cubic_cap="",rc_fuel_desc="",strVehicleChasisNumber="",strVehicleEngineNumber="",VEHICLECLASSCODE="",strClaimBonus="",StrPreviousPolicyRadio="",strEndDateEdit="",strName="",strVehicleNo="",str_edt_city="",str_edt_phone="",str_edt_email="",strPolicyRadio="",strVehicleTypeRadio="",strVehicleRadio="",strFor="",strRTOCode="",strRTOName="",str_vehicleManufacturerNm="",strVehicleManufacturerCode="",strStateName="",strStateCode="",str_edt_registration_date="",yearOfManufacture="",str_manufacture_year="",strVehicleModel="",strVehicleModelCode="",strVehicleCubicCapicity="",strVehicleImage="",strPolicyNumberEdit="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_motor__private_car, container, false);
        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(getContext());
        customDialog = CustomProgressDialog.getInstance(getContext());
        Bundle bundle = getArguments();
        if (bundle !=null&& bundle.containsKey("otherFrag")){
            int fragNo = bundle.getInt("otherFrag");
            strFor = bundle.getString("strFor");
            strVehicleNo = bundle.getString("strVehicleNo");
            strName = bundle.getString("strName");
            str_edt_city = bundle.getString("str_edt_city");
            str_edt_phone = bundle.getString("str_edt_phone");
            str_edt_email = bundle.getString("str_edt_email");
            strFor = bundle.getString("strFor");
            strPolicyRadio = bundle.getString("strPolicyRadio");
            strVehicleTypeRadio = bundle.getString("strVehicleTypeRadio");
            strVehicleRadio =bundle.getString("strVehicleRadio");
            strPolicyNumberEdit =bundle.getString("strPolicyNumberEdit");
            strVehicleManufacturerCode = bundle.getString("strVehicleManufacturerCode");
            strRTOCode = bundle.getString("strRTOCode");
            yearOfManufacture = bundle.getString("yearOfManufacture");
            strVehicleModelCode = bundle.getString("strVehicleModelCode");
            str_vehicleManufacturerNm =bundle.getString("str_vehicleManufacturerNm");
            strVehicleModel =bundle.getString("strVehicleModel");
            strStateName = bundle.getString("strStateName");
            strRTOName = bundle.getString("strRTOName");
            str_edt_registration_date =bundle.getString("str_edt_registration_date");
            strClaimBonus =bundle.getString("strClaimBonus");
            strEndDateEdit =bundle.getString("strEndDateEdit");
            StrPreviousPolicyRadio =bundle.getString("StrPreviousPolicyRadio");
            VEHICLECLASSCODE =bundle.getString("VEHICLECLASSCODE");
            strVehicleChasisNumber = bundle.getString("strVehicleChasisNumber");
            strVehicleEngineNumber =bundle.getString("strVehicleEngineNumber");
            rc_fuel_desc =bundle.getString("rc_fuel_desc");
            rc_cubic_cap =bundle.getString("rc_cubic_cap");
            FuleType = bundle.getString("FuleType");
            strCompanyName = bundle.getString("strCompanyName");
            vehicleManufacturerType = bundle.getString("vehicleManufacturerType");
            strModelType =bundle.getString("strModelType");
            strStateCode = bundle.getString("strStateCode");
        }

        edt_phone=view.findViewById(R.id.edt_phone);
        edt_email=view.findViewById(R.id.edt_email);
        btn_next=view.findViewById(R.id.btn_next);
        edt_city=view.findViewById(R.id.edt_city);
        edt_name=view.findViewById(R.id.edt_name);
        term_condition = view.findViewById(R.id.term_condition);
        chkCondition=view.findViewById(R.id.checkbox);
        New_Policy_Radio=view.findViewById(R.id.New_Policy_Radio);
        Renewal_Radio=view.findViewById(R.id.Renewal_Radio);
        TwoWheelerRadio=view.findViewById(R.id.TwoWheelerRadio);
        FourWheelerRadio=view.findViewById(R.id.FourWheelerRadio);
        NewVehicleRadio=view.findViewById(R.id.NewVehicleRadio);
        OldVehicleRadio=view.findViewById(R.id.OldVehicleRadio);



        VehicleNo=view.findViewById(R.id.VehicleNo);
        ccp = view.findViewById(R.id.ccp);
        selected_country_code = ccp.getSelectedCountryCodeWithPlus();
        str_edt_phone=pref.getMOBILE();
        str_edt_email=pref.getEmailId();
        strName=pref.getUserName();

        edt_phone.setText(str_edt_phone);
        edt_email.setText(str_edt_email);
        edt_name.setText(strName);
//        strVehicleNo="MH04HQ8035";
//        VehicleNo.setText(strVehicleNo);

        strPolicyRadio="New";

        New_Policy_Radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (New_Policy_Radio.isChecked()){
                    New_Policy_Radio.setChecked(true);
                    Renewal_Radio.setChecked(false);
                    strPolicyRadio="New";

                }
            }
        });
        Renewal_Radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Renewal_Radio.isChecked()){
                    strPolicyRadio="Renew Policy";
                    Renewal_Radio.setChecked(true);
                    New_Policy_Radio.setChecked(false);
                    FourWheelerRadio.setChecked(false);
                    TwoWheelerRadio.setChecked(false);
                    OldVehicleRadio.setChecked(false);
                    NewVehicleRadio.setChecked(false);
                    BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(getContext(),R.style.BottomSheetTheme);
                    View view= LayoutInflater.from(getContext()).inflate(R.layout.bottom_navigation_motor_renewal,null);
                    bottomSheetDialog.setContentView(view);
                    ImageView bottomCancel=view.findViewById(R.id.bottomCancel);
                    RcyRenewMotor=view.findViewById(R.id.RcyRenewMotor);
                    textViewNoPolicy=view.findViewById(R.id.textViewNoPolicy);
//                    init();
                    customDialog.showProgressBar();
                    bottomCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bottomSheetDialog.dismiss();
                            New_Policy_Radio.setChecked(true);
                        }
                    });

                    bottomSheetDialog.show();
                }
            }
        });

        TwoWheelerRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (TwoWheelerRadio.isChecked()){
                    TwoWheelerRadio.setChecked(true);
                    FourWheelerRadio.setChecked(false);
                    strVehicleTypeRadio="Two Wheeler";
                }
            }
        });

        FourWheelerRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (FourWheelerRadio.isChecked()){
                    FourWheelerRadio.setChecked(true);
                    TwoWheelerRadio.setChecked(false);
                    strVehicleTypeRadio="Four Wheeler";
                }
            }
        });

        NewVehicleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (NewVehicleRadio.isChecked()){
                    NewVehicleRadio.setChecked(true);
                    OldVehicleRadio.setChecked(false);
                    strVehicleRadio="New";
                    VehicleNo.setText("");
                }
            }
        });

        OldVehicleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (OldVehicleRadio.isChecked()){
                    OldVehicleRadio.setChecked(true);
                    NewVehicleRadio.setChecked(false);
                    strVehicleRadio="Old";
                }
            }
        });

        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                selected_country_code = ccp.getSelectedCountryCodeWithPlus();
                edt_phone.setText("");

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                strVehicleNo="MH05CF5008";
//                strVehicleNo="MH04HQ8035";
//                VehicleNo.setText(strVehicleNo);
                str_edt_phone=edt_phone.getText().toString();
                str_edt_email=edt_email.getText().toString();
                strName=edt_name.getText().toString();
                strVehicleNo=VehicleNo.getText().toString();
                if (str_edt_phone.equals("")){
                    Toast.makeText(getContext(), "Enter Phone No. ", Toast.LENGTH_SHORT).show();
                }else if (str_edt_phone.length()!=10){
                    Toast.makeText(getContext(), "Enter 10 digit Phone No. ", Toast.LENGTH_SHORT).show();
                }else if (str_edt_email.equals("")){
                    Toast.makeText(getContext(), "Enter Email id", Toast.LENGTH_SHORT).show();
                }else if (edt_email.getText().toString().length() == 0) {
                    edt_email.setFocusableInTouchMode(true);
                    edt_email.setCursorVisible(true);
                    edt_email.requestFocus();
                    Toast.makeText(getContext(), "Email is mandatory.", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(edt_email.getText().toString()).matches()) {
                    edt_email.setFocusableInTouchMode(true);
                    edt_email.setCursorVisible(true);
                    edt_email.requestFocus();
                    Toast.makeText(getContext(), "Email address is not valid.", Toast.LENGTH_SHORT).show();
                }else if (strName.equals("")){
                    Toast.makeText(getContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                }else if (strVehicleRadio.equals("")){
                   Toast.makeText(getContext(), "Select One New Vehicle & Old Vehicle ", Toast.LENGTH_SHORT).show();
               }else if (strVehicleTypeRadio.equals("")){
                   Toast.makeText(getContext(), "Select Vehicle Type ", Toast.LENGTH_SHORT).show();
               }else if (strPolicyRadio.equals("New")&& strVehicleRadio.equals("Old")) {
                    if (strVehicleNo.equals("")){
                        Toast.makeText(getContext(), "Enter Vehicle Number ", Toast.LENGTH_SHORT).show();
                    }else if (strVehicleNo.length()!=9){
                        Toast.makeText(getContext(), "Enter at-least 9 digit Vehicle No. ", Toast.LENGTH_SHORT).show();
                    }else if (!strVehicleNo.matches(VehicleNumberRegex)){
                            Toast.makeText(getContext(), "Enter Valid Vehicle Number ", Toast.LENGTH_SHORT).show();
                    }else {
                            Intent intent=new Intent(getContext(), Add_Details_Old_Vehicle.class);
                            intent.putExtra("strVehicleNo",strVehicleNo);
                            intent.putExtra("str_edt_city",str_edt_city);
                            intent.putExtra("str_edt_phone",str_edt_phone);
                            intent.putExtra("str_edt_email",str_edt_email);
                            intent.putExtra("strPolicyRadio",strPolicyRadio);
                            intent.putExtra("strVehicleTypeRadio",strVehicleTypeRadio);
                            intent.putExtra("strVehicleRadio",strVehicleRadio);
                            intent.putExtra("strPolicyNumberEdit",strPolicyNumberEdit);
                            intent.putExtra("strName",strName);
                            intent.putExtra("strCompanyName",strCompanyName);
                            intent.putExtra("strFor","1");
                            startActivity(intent);
                        }
                      }else if (!chkCondition.isChecked()){
                      Toast.makeText(getContext(), "Please agree the conditions", Toast.LENGTH_SHORT).show();
                    }
                else {
                    Intent intent=new Intent(getContext(), Private_car_vehicle_details.class);
                    intent.putExtra("strVehicleNo",strVehicleNo);
                    intent.putExtra("str_edt_city",str_edt_city);
                    intent.putExtra("str_edt_phone",str_edt_phone);
                    intent.putExtra("str_edt_email",str_edt_email);
                    intent.putExtra("strPolicyRadio",strPolicyRadio);
                    intent.putExtra("strVehicleTypeRadio",strVehicleTypeRadio);
                    intent.putExtra("strVehicleRadio",strVehicleRadio);
                    intent.putExtra("str_vehicleManufacturerNm",str_vehicleManufacturerNm);
                    intent.putExtra("strVehicleModel",strVehicleModel);
                    intent.putExtra("str_edt_registration_date",str_edt_registration_date);
                    intent.putExtra("strStateName",strStateName);
                    intent.putExtra("strRTOName",strRTOName);
                    intent.putExtra("strPolicyNumberEdit",strPolicyNumberEdit);
                    intent.putExtra("strName",strName);
                    intent.putExtra("strVehicleManufacturerCode",strVehicleManufacturerCode);
                    intent.putExtra("strRTOCode",strRTOCode);
                    intent.putExtra("yearOfManufacture",yearOfManufacture);
                    intent.putExtra("strVehicleModelCode",strVehicleModelCode);
                    intent.putExtra("strClaimBonus",strClaimBonus);
                    intent.putExtra("strEndDateEdit",strEndDateEdit);
                    intent.putExtra("StrPreviousPolicyRadio",StrPreviousPolicyRadio);
                    intent.putExtra("VEHICLECLASSCODE",VEHICLECLASSCODE);
                    intent.putExtra("strVehicleChasisNumber",strVehicleChasisNumber);
                    intent.putExtra("strVehicleEngineNumber",strVehicleEngineNumber);
                    intent.putExtra("rc_fuel_desc",rc_fuel_desc);
                    intent.putExtra("rc_cubic_cap",rc_cubic_cap);
                    intent.putExtra("FuleType",FuleType);
                    intent.putExtra("strCompanyName",strCompanyName);
                    intent.putExtra("vehicleManufacturerType",vehicleManufacturerType);
                    intent.putExtra("strModelType",strModelType);
                    intent.putExtra("strStateCode",strStateCode);
                    intent.putExtra("strFor","1");
                       startActivity(intent);
                   }
               }

        });

        term_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(getContext());
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.dialog_term_condition);
                ImageView crossImg;
                crossImg = alert_dialog.findViewById(R.id.crossImg);
                alert_dialog.show();
                crossImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
            }
        });
        return view;

    }

}