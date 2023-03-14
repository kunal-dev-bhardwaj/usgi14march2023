package com.universalsompo.meta.metaapp.motor.activities.motor_policies.privatetype;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Previous_Private_Policy_Details;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_tell_us_vehicle;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Private_Liability_type#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Private_Liability_type extends Fragment {
    Button btn_next,btn_previous;
    String str_edt_phone="",str_edt_email="",str_edt_registration_no="",str_edt_city="",str_rto_location="",str_manufacture_year="",str_edt_registration_date="",str_previous_start_date="",str_manufacture_name="",str_vehicle_model="",str_previousPolicy="",str_claim_policy,str_no_pa_owner,str_legal;
     RadioButton yes_pa_owner,no_pa_owner,yes_legal,no_legal;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Private_Liability_type() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Private_Liability_type.
     */
    // TODO: Rename and change types and number of parameters
    public static Private_Liability_type newInstance(String param1, String param2) {
        Private_Liability_type fragment = new Private_Liability_type();
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
        View view= inflater.inflate(R.layout.fragment_private__liability_type, container, false);
        str_edt_registration_no =getActivity(). getIntent().getStringExtra("str_edt_registration_no");
        str_edt_city =getActivity(). getIntent().getStringExtra("str_edt_city");
        str_edt_phone =getActivity(). getIntent().getStringExtra("str_edt_phone");
        str_edt_email =getActivity(). getIntent().getStringExtra("str_edt_email");
        str_rto_location = getActivity().getIntent().getStringExtra("str_rto_location");
        str_manufacture_year =getActivity(). getIntent().getStringExtra("str_manufacture_year");
        str_edt_registration_date = getActivity().getIntent().getStringExtra("str_edt_registration_date");
        str_manufacture_name = getActivity().getIntent().getStringExtra("str_manufacture_name");
        str_vehicle_model = getActivity().getIntent().getStringExtra("str_vehicle_model");
        str_previousPolicy = getActivity().getIntent().getStringExtra("str_previousPolicy");
        str_claim_policy = getActivity().getIntent().getStringExtra("str_claim_policy");
        str_previous_start_date = getActivity().getIntent().getStringExtra("str_previous_start_date");


        btn_next=view.findViewById(R.id.btn_next);
        btn_previous=view.findViewById(R.id.btn_previous);
        yes_pa_owner=view.findViewById(R.id.yes_pa_owner);
        no_pa_owner=view.findViewById(R.id.no_pa_owner);
        yes_legal=view.findViewById(R.id.yes_legal);
        no_legal=view.findViewById(R.id.no_legal);



        yes_pa_owner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_pa_owner.isChecked())
                    str_no_pa_owner="Yes";
                    no_pa_owner.setChecked(false);
            }
        });

        no_pa_owner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_pa_owner.isChecked())
                    str_no_pa_owner="No";
                    yes_pa_owner.setChecked(false);
            }
        });

        yes_legal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_legal.isChecked())
                    str_legal="Yes";
                   no_pa_owner.setChecked(false);
            }
        });
        no_legal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_legal.isChecked())
                    str_legal="No";
                    yes_legal.setChecked(false);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Private_tell_us_vehicle.class);
                intent.putExtra("str_edt_registration_no",str_edt_registration_no);
                intent.putExtra("str_edt_city",str_edt_city);
                intent.putExtra("str_edt_phone",str_edt_phone);
                intent.putExtra("str_edt_email",str_edt_email);
                intent.putExtra("str_rto_location",str_rto_location);
                intent.putExtra("str_manufacture_year",str_manufacture_year);
                intent.putExtra("str_edt_registration_date",str_edt_registration_date);
                intent.putExtra("str_manufacture_name",str_manufacture_name);
                intent.putExtra("str_vehicle_model",str_vehicle_model);
                intent.putExtra("str_previousPolicy",str_previousPolicy);
                intent.putExtra("str_claim_policy",str_claim_policy);
                intent.putExtra("str_previous_start_date",str_previous_start_date);
                intent.putExtra("str_no_pa_owner",str_no_pa_owner);
                intent.putExtra("str_legal",str_legal);
                startActivity(intent);
            }
        });


        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Previous_Private_Policy_Details.class);
                startActivity(intent);
            }
        });
        return view;
    }
}