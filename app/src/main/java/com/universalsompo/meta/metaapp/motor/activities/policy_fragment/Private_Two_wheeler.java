package com.universalsompo.meta.metaapp.motor.activities.policy_fragment;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_car_vehicle_details;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Private_Two_wheeler#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Private_Two_wheeler extends Fragment {
    EditText edt_phone,edt_email,edt_registration_no,edt_city;
    Button btn_next;
    private MySharedPreference pref;
    private CheckBox chkCondition;
    CountryCodePicker ccp;
    LinearLayout term_condition;

    String str_edt_phone="",str_edt_email="",str_edt_registration_no="",str_edt_city="",selected_country_code;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Private_Two_wheeler() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Private_Two_wheeler.
     */
    // TODO: Rename and change types and number of parameters
    public static Private_Two_wheeler newInstance(String param1, String param2) {
        Private_Two_wheeler fragment = new Private_Two_wheeler();
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
        View view= inflater.inflate(R.layout.fragment_private__two_wheeler, container, false);
        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(getContext());
        edt_phone=view.findViewById(R.id.edt_phone);
        edt_email=view.findViewById(R.id.edt_email);
        btn_next=view.findViewById(R.id.btn_next);
        edt_city=view.findViewById(R.id.edt_city);
        chkCondition=view.findViewById(R.id.checkbox);
        term_condition = view.findViewById(R.id.term_condition);
        edt_registration_no=view.findViewById(R.id.edt_registration_no);
        ccp = view.findViewById(R.id.ccp);
        selected_country_code = ccp.getSelectedCountryCodeWithPlus();
        edt_phone.setText(pref.getMOBILE());
        edt_email.setText(pref.getEmailId());


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
                str_edt_phone=edt_phone.getText().toString();
                str_edt_email=edt_email.getText().toString();
                str_edt_registration_no=edt_registration_no.getText().toString();
                str_edt_city=edt_city.getText().toString();
                if (str_edt_registration_no.equals("")){
                    Toast.makeText(getContext(), "Enter Car Registration Number", Toast.LENGTH_SHORT).show();
                }else if (str_edt_city.equals("")){
                    Toast.makeText(getContext(), "Enter City", Toast.LENGTH_SHORT).show();
                }else if (str_edt_phone.equals("")){
                    Toast.makeText(getContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
                }else if (str_edt_email.equals("")){
                    Toast.makeText(getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                }else if (!chkCondition.isChecked()) {
                    Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(getContext(), Private_car_vehicle_details.class);
                    intent.putExtra("str_edt_registration_no",str_edt_registration_no);
                    intent.putExtra("str_edt_city",str_edt_city);
                    intent.putExtra("str_edt_phone",str_edt_phone);
                    intent.putExtra("str_edt_email",str_edt_email);
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