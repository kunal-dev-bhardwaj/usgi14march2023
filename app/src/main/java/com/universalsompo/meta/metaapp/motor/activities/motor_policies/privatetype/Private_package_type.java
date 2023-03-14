package com.universalsompo.meta.metaapp.motor.activities.motor_policies.privatetype;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Previous_Private_Policy_Details;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Private_tell_us_vehicle;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Private_package_type#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Private_package_type extends Fragment {
    Button btn_next,btn_previous;
    RadioButton yes_pa_owner,no_pa_owner,yes_legal,no_legal,yes_key_replacement,no_key_replacement,yes_return_invoice,no_return_invoice,yes_accidental,no_accidental;
    TextView text_pa_owner,text_legal,text_key_replacement,text_return_invoice;
    LinearLayout engine_liner,liner_engine_protector,non_electrical_liner,accessory_electrical_liner,text_accidental;
    String str_edt_phone="",str_edt_email="",str_edt_registration_no="",str_edt_city="",str_rto_location="",str_manufacture_year="",str_edt_registration_date="",str_previous_start_date="",str_manufacture_name="",str_vehicle_model="",str_previousPolicy="",str_claim_policy="",str_edt_ex_showroom_price="",
            str_declared_Value,str_no_pa_owner="",str_legal="",str_key_replacement="",str_accidental="",str_return_invoice="",str_electrical_accessories,str_non_electrical,str_engine_protector;
    EditText edt_ex_showroom_price,declared_Value,electrical_accessories,non_electrical;
    Spinner engine_protector_spinner;
    String[] EngineProtector;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Private_package_type() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Private_package_type.
     */
    // TODO: Rename and change types and number of parameters
    public static Private_package_type newInstance(String param1, String param2) {
        Private_package_type fragment = new Private_package_type();
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
        View view= inflater.inflate(R.layout.fragment_private_package_type, container, false);
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


        yes_pa_owner=view.findViewById(R.id.yes_pa_owner);
        no_pa_owner=view.findViewById(R.id.no_pa_owner);
        edt_ex_showroom_price=view.findViewById(R.id.edt_ex_showroom_price);
        declared_Value=view.findViewById(R.id.declared_Value);
        engine_protector_spinner=view.findViewById(R.id.engine_protector_spinner);

        text_pa_owner=view.findViewById(R.id.text_pa_owner);
        yes_legal=view.findViewById(R.id.yes_legal);
        no_legal=view.findViewById(R.id.no_legal);
        text_legal=view.findViewById(R.id.text_legal);
        yes_key_replacement=view.findViewById(R.id.yes_key_replacement);
        no_key_replacement=view.findViewById(R.id.no_key_replacement);
        text_key_replacement=view.findViewById(R.id.text_key_replacement);
        engine_liner=view.findViewById(R.id.engine_liner);
        liner_engine_protector=view.findViewById(R.id.liner_engine_protector);
        non_electrical_liner=view.findViewById(R.id.non_electrical_liner);
        accessory_electrical_liner=view.findViewById(R.id.accessory_electrical_liner);
        yes_return_invoice=view.findViewById(R.id.yes_return_invoice);
        no_return_invoice=view.findViewById(R.id.no_return_invoice);
        text_return_invoice=view.findViewById(R.id.text_return_invoice);
        yes_accidental=view.findViewById(R.id.yes_accidental);
        no_accidental=view.findViewById(R.id.no_accidental);
        text_accidental=view.findViewById(R.id.text_accidental);
        electrical_accessories=view.findViewById(R.id.electrical_accessories);
        non_electrical=view.findViewById(R.id.non_electrical);
        btn_next=view.findViewById(R.id.btn_next);
        btn_previous=view.findViewById(R.id.btn_previous);

        EngineProtector=getResources().getStringArray(R.array.EngineProtector);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), R.layout.spinner_item_text,EngineProtector);
        engine_protector_spinner.setAdapter(adapter);


        engine_protector_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_engine_protector = String.valueOf(EngineProtector[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Previous_Private_Policy_Details.class);
                startActivity(intent);
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_edt_ex_showroom_price=edt_ex_showroom_price.getText().toString();
                str_declared_Value=declared_Value.getText().toString();
                str_electrical_accessories=electrical_accessories.getText().toString();
                str_non_electrical=non_electrical.getText().toString();

                if (str_edt_ex_showroom_price.equals("")){
                    Toast.makeText(getContext(), "Enter Ex-ShowRoom Price", Toast.LENGTH_SHORT).show();
                }else if (str_declared_Value.equals("")){
                    Toast.makeText(getContext(), "Enter Declared Value", Toast.LENGTH_SHORT).show();
                }else{
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
                    intent.putExtra("str_edt_ex_showroom_price",str_edt_ex_showroom_price);
                    intent.putExtra("str_declared_Value",str_declared_Value);
                    intent.putExtra("str_electrical_accessories",str_electrical_accessories);
                    intent.putExtra("str_non_electrical",str_non_electrical);
                    intent.putExtra("str_no_pa_owner",str_no_pa_owner);
                    intent.putExtra("str_legal",str_legal);
                    intent.putExtra("str_accidental",str_accidental);
                    intent.putExtra("str_key_replacement",str_key_replacement);
                    intent.putExtra("str_return_invoice",str_return_invoice);
                    intent.putExtra("str_engine_protector",str_engine_protector);
                    startActivity(intent);
                }
            }
        });

        yes_pa_owner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_pa_owner.isChecked()){
                    str_no_pa_owner="Yes";
                    text_pa_owner.setVisibility(View.VISIBLE);
                    no_pa_owner.setChecked(false);
                }
            }
        });
        no_pa_owner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_pa_owner.isChecked()){
                    str_no_pa_owner="No";
                    text_pa_owner.setVisibility(View.GONE);
                    yes_pa_owner.setChecked(false);
                }
            }
        });


        yes_legal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_legal.isChecked()){
                    text_legal.setVisibility(View.VISIBLE);
                    str_legal="Yes";
                    no_legal.setChecked(false);
                }
            }
        });


        no_legal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_legal.isChecked()){
                    str_legal="No";
                    text_legal.setVisibility(View.GONE);
                    yes_legal.setChecked(false);
                }
            }
        });

        yes_accidental.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_accidental.isChecked()){
                    str_accidental="Yes";
                    text_accidental.setVisibility(View.VISIBLE);
                    no_accidental.setChecked(false);
                }
            }
        });
        no_accidental.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_accidental.isChecked()){
                    str_accidental="No";
                    text_accidental.setVisibility(View.GONE);
                    yes_accidental.setChecked(false);
                }
            }
        });



        yes_key_replacement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_key_replacement.isChecked()){
                    str_key_replacement="Yes";
                    text_key_replacement.setVisibility(View.VISIBLE);
                    no_key_replacement.setChecked(false);
                }
            }
        });



        no_key_replacement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_key_replacement.isChecked()){
                    str_key_replacement="No";
                    text_key_replacement.setVisibility(View.GONE);
                    yes_key_replacement.setChecked(false);
                }
            }
        });
        yes_return_invoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_return_invoice.isChecked()){
                    str_return_invoice="Yes";
                    text_return_invoice.setVisibility(View.VISIBLE);
                    no_return_invoice.setChecked(false);
                }
            }
        });
        no_return_invoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_return_invoice.isChecked()){
                    str_return_invoice="No";
                    text_return_invoice.setVisibility(View.GONE);
                    yes_return_invoice.setChecked(false);
                }
            }
        });


        non_electrical_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessory_electrical_liner.setVisibility(View.VISIBLE);
            }
        });

        engine_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liner_engine_protector.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

}