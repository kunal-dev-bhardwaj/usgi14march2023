package com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Objects;

public class OfflineCalculator extends AppCompatActivity {
    EditText edt_name,edt_phone,edt_email,reference_no;
    MySharedPreference mySharedPreference;
    Button btn_next;
    Spinner age_spinner,GenderSpinner;
    String[] age;
    String[] gender;
    ImageView SummeryBack;
    String str_edt_name="",str_edt_phone="",str_email="",str_age="",strGenderSpinner="",str_reference_no="",selected_country_code,str_for;
    Switch switchbtn;
    private CheckBox chkCondition;
    CountryCodePicker ccp;
    LinearLayout term_condition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_calculator);
        getWindow().setStatusBarColor(ContextCompat.getColor(OfflineCalculator.this, R.color.colorPrimaryDark));

        mySharedPreference= MySharedPreference.getInstance(OfflineCalculator.this);
        btn_next=findViewById(R.id.btn_next);
        edt_name=findViewById(R.id.edt_name);
        edt_phone=findViewById(R.id.edt_phone);
        edt_email=findViewById(R.id.edt_email);
        age_spinner=findViewById(R.id.age_spinner);
        GenderSpinner=findViewById(R.id.GenderSpinner);
        switchbtn=findViewById(R.id.switchbtn);
        reference_no=findViewById(R.id.reference_no);
        chkCondition = findViewById(R.id.checkbox);
        term_condition = findViewById(R.id.term_condition);
        SummeryBack = findViewById(R.id.SummeryBack);
        ccp = findViewById(R.id.ccp);
        selected_country_code = ccp.getSelectedCountryCodeWithPlus();
        edt_name.setText(mySharedPreference.getUserName());
        edt_phone.setText(mySharedPreference.getMOBILE());
        edt_email.setText(mySharedPreference.getEmailId());

        age=getResources().getStringArray(R.array.age);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(OfflineCalculator.this, R.layout.spinner_item_text,age);
        age_spinner.setAdapter(adapter);
        gender=getResources().getStringArray(R.array.gender);
        final ArrayAdapter<String> GenderAdapter=new ArrayAdapter<String>(OfflineCalculator.this, R.layout.spinner_item_text,gender);
        GenderSpinner.setAdapter(GenderAdapter);


        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                selected_country_code = ccp.getSelectedCountryCodeWithPlus();
                edt_phone.setText("");

            }
        });
        SummeryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OfflineCalculator.this, MainActivityHealth.class);

                startActivity(intent);
                finish();
            }
        });

        reference_no.setFocusableInTouchMode(false);
        reference_no.setFocusable(false);
        reference_no.setClickable(false);
        reference_no.setFocusable(false);
        reference_no.setText("");
        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    reference_no.setFocusableInTouchMode(true);
                    reference_no.setClickable(true);
                    reference_no.setFocusable(true);
                    reference_no.setFocusable(true);
                }else{
                    reference_no.setFocusableInTouchMode(false);
                    reference_no.setFocusable(false);
                    reference_no.setClickable(false);
                    reference_no.setFocusable(false);
                    reference_no.setText("");
                }
            }
        });

        age_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_age = String.valueOf(age[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        GenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strGenderSpinner = String.valueOf(gender[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_edt_name=edt_name.getText().toString();
                str_edt_phone=edt_phone.getText().toString();
                str_email=edt_email.getText().toString();
                str_reference_no=reference_no.getText().toString();
//                if (str_age.equals("Select Age")){
//                    Toast.makeText(OfflineCalculator(), "Select Age", Toast.LENGTH_SHORT).show();
//                }
                if (strGenderSpinner.equals("Select Gender")){
                    Toast.makeText(OfflineCalculator.this, "Select Gender", Toast.LENGTH_SHORT).show();
                }else if (!chkCondition.isChecked()) {
                    Toast.makeText(OfflineCalculator.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(OfflineCalculator.this, CalculatorPlanType.class);
                    intent.putExtra("str_edt_name",str_edt_name);
                    intent.putExtra("str_edt_phone",str_edt_phone);
                    intent.putExtra("str_email",str_email);
                    intent.putExtra("str_age",str_age);
                    intent.putExtra("str_reference_no",str_reference_no);
                    intent.putExtra("strGenderSpinner",strGenderSpinner);
                    intent.putExtra("strFor","0");
                    startActivity(intent);

                }
            }
        });
        term_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(OfflineCalculator.this);
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


    }
}