package com.universalsompo.meta.metaapp.health.fragment.buypolicy;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_Member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_product;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.BuyPolicySuminsuredArogya;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Objects;

public class Buy_Aarogya_Sanjeevani_policy extends Fragment {
        EditText edt_name,edt_phone,edt_email,reference_no;
    MySharedPreference mySharedPreference;
    Button btn_quote;
    Spinner age_spinner;
    String[] age;
    Switch switchbtn;
    private CheckBox chkCondition;
    CountryCodePicker ccp;
    boolean isChecked =false;
    LinearLayout term_condition;
    String str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",selected_country_code;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_buy__aarogya__sanjeevani_policy, container, false);
        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));


        mySharedPreference= MySharedPreference.getInstance(getActivity());

        edt_name=view.findViewById(R.id.edt_name);
        edt_phone=view.findViewById(R.id.edt_phone);
        edt_email=view.findViewById(R.id.edt_email);
        btn_quote=view.findViewById(R.id.btn_quote);
        age_spinner=view.findViewById(R.id.age_spinner);
        switchbtn=view.findViewById(R.id.switchbtn);
        reference_no=view.findViewById(R.id.reference_no);
        chkCondition = view.findViewById(R.id.checkbox);
        term_condition = view.findViewById(R.id.term_condition);
        ccp = view.findViewById(R.id.ccp);
        selected_country_code = ccp.getSelectedCountryCodeWithPlus();
        edt_name.setText(mySharedPreference.getUserName());
        edt_phone.setText(mySharedPreference.getMOBILE());
        edt_email.setText(mySharedPreference.getEmailId());

        age=getResources().getStringArray(R.array.age);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), R.layout.spinner_item_text,age);
        age_spinner.setAdapter(adapter);


        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                selected_country_code = ccp.getSelectedCountryCodeWithPlus();
                edt_phone.setText("");

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

        btn_quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_edt_name=edt_name.getText().toString();
                str_edt_phone=edt_phone.getText().toString();
                str_email=edt_email.getText().toString();
                str_reference_no=reference_no.getText().toString();

                if (str_age.equals("Select Age")){
                    Toast.makeText(getContext(), "Select Age", Toast.LENGTH_SHORT).show();
                }else if (!chkCondition.isChecked()) {
                    Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
//                    Intent intent=new Intent(getContext(), Arogya_product.class);
                    Intent intent=new Intent(getContext(), BuyPolicySuminsuredArogya.class);
                    intent.putExtra("str_edt_name",str_edt_name);
                    intent.putExtra("str_edt_phone",str_edt_phone);
                    intent.putExtra("str_email",str_email);
                    intent.putExtra("str_age",str_age);
                    intent.putExtra("str_reference_no",str_reference_no);
                    intent.putExtra("for","0");
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