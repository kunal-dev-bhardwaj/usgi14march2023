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
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_product;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.SuperBuyPolicySuminsured;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Health_Payment;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Medicle_details;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Member_Self;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Plan_details;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Buy_Super_Healthcare_policy#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Buy_Super_Healthcare_policy extends Fragment {
    EditText edt_name,edt_phone,edt_email,reference_no;
    MySharedPreference mySharedPreference;
    Button btn_quote;
    Spinner age_spinner;
    String[] age;
    Switch switchbtn;
    LinearLayout term_condition;
    private CheckBox chkCondition;
    CountryCodePicker ccp;
    String str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",selected_country_code;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Buy_Super_Healthcare_policy() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Buy_Super_Healthcare_policy.
     */
    // TODO: Rename and change types and number of parameters
    public static Buy_Super_Healthcare_policy newInstance(String param1, String param2) {
        Buy_Super_Healthcare_policy fragment = new Buy_Super_Healthcare_policy();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_buy__super__healthcare_policy, container, false);
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

        age=getResources().getStringArray(R.array.shiAge);
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
                    Intent intent=new Intent(getContext(), SuperBuyPolicySuminsured.class);
//                    Intent intent=new Intent(getContext(), Super_Health_Payment.class);
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
        return view;
    }


}