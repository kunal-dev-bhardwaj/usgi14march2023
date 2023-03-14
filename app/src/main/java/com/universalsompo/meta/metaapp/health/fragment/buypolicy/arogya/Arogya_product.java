package com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Health_Payment;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Medicle_details;

public class Arogya_product extends AppCompatActivity {
   Button buy_now_arogya;
   Spinner family_floater_spinner,no_of_child_spinner,no_of_parents_spinner,deductible_spinner,sum_insured_spinner;
    String[] familyFloater,no_child,no_parent,deductible,sum_insured;
    String str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_family_individual="",str_edit_adult="",str_no_parent="",str_no_child="",str_deductible="",str_sum_insured,str_premium_amount="";
    LinearLayout liner_no_child,liner_no_parents;
    EditText edt_adult;
    TextView premium_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arogya_product);
        getWindow().setStatusBarColor(ContextCompat.getColor(Arogya_product.this, R.color.colorPrimaryDark));

        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_reference_no = getIntent().getStringExtra("str_reference_no");


        init();

    }

    private void init() {
        buy_now_arogya=findViewById(R.id.buy_now_arogya);
        family_floater_spinner=findViewById(R.id.family_floater_spinner);
        edt_adult=findViewById(R.id.edt_adult);
        no_of_child_spinner=findViewById(R.id.no_of_child_spinner);
        no_of_parents_spinner=findViewById(R.id.no_of_parents_spinner);
        deductible_spinner=findViewById(R.id.deductible_spinner);
        sum_insured_spinner=findViewById(R.id.sum_insured_spinner);
        liner_no_child=findViewById(R.id.liner_no_child);
        liner_no_parents=findViewById(R.id.liner_no_parents);
        premium_amount=findViewById(R.id.premium_amount);

        familyFloater=getResources().getStringArray(R.array.family_floater);
        no_child=getResources().getStringArray(R.array.no_child);
        no_parent=getResources().getStringArray(R.array.no_parents);
        deductible=getResources().getStringArray(R.array.deductible);
        sum_insured=getResources().getStringArray(R.array.sum_insured);

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,familyFloater);
        family_floater_spinner.setAdapter(adapter);

        final ArrayAdapter<String> no_child_adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,no_child);
        no_of_child_spinner.setAdapter(no_child_adapter);

        final ArrayAdapter<String> no_parent_adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,no_parent);
        no_of_parents_spinner.setAdapter(no_parent_adapter);

        final ArrayAdapter<String> deductible_adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,deductible);
        deductible_spinner.setAdapter(deductible_adapter);

        final ArrayAdapter<String> sum_insured_adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,sum_insured);
        sum_insured_spinner.setAdapter(sum_insured_adapter);


        family_floater_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_family_individual = String.valueOf(familyFloater[i]);
                if (str_family_individual.equals("Individual")){
                    liner_no_child.setVisibility(View.GONE);
                    liner_no_parents.setVisibility(View.GONE);

                    str_edit_adult="1 Adult";

                    edt_adult.setText(str_edit_adult);

                }else {
                    liner_no_child.setVisibility(View.VISIBLE);
                    liner_no_parents.setVisibility(View.VISIBLE);
                    str_edit_adult="2 Adult";
                    edt_adult.setText(str_edit_adult);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        no_of_child_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_no_child = String.valueOf(no_child[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        no_of_parents_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_no_parent = String.valueOf(no_parent[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        deductible_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_deductible = String.valueOf(deductible[i]);
                if (str_deductible.equals("100000")){
                    str_premium_amount="170.26";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("150000") ){
                    str_premium_amount="205.89";
                    premium_amount.setText("205.89");
                } else if (str_deductible.equals("200000")){
                    str_premium_amount="241.6";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("250000")){
                    str_premium_amount="287.97";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("300000")){
                    str_premium_amount="333.92";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("350000") ){
                    str_premium_amount="359.2";
                    premium_amount.setText(str_premium_amount);
                } else if (str_deductible.equals("400000")){
                    str_premium_amount="386.26";
                    premium_amount.setText(str_premium_amount);
                } else if (str_deductible.equals("450000")){
                    str_premium_amount="408.15";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("500000") ){
                    str_premium_amount="429.93";
                    premium_amount.setText(str_premium_amount);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        sum_insured_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_sum_insured = String.valueOf(sum_insured[i]);
                if (str_deductible.equals("100000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="170.26";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("100000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="505.91";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("100000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="992.37";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("100000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="1945.82";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("150000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="205.89";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("150000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="611.76";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("150000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="1199.99";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("150000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="2352.92";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("200000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="241.6";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("200000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="717.91";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("200000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="1408.21";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("200000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="2761.2";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("250000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="287.97";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("250000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="855.67";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("250000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="1678.42";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("250000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="13291.02";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("300000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="333.92";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("300000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="992.19";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("300000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="1946.22";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("300000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="3816.12";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("350000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="359.2";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("350000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="1067.36";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("350000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="2093.66";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("350000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="4105.22";
                    premium_amount.setText(str_premium_amount);
                } else if (str_deductible.equals("400000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="386.26";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("400000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="1147.74";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("400000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="2251.33";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("400000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="4414.38";
                    premium_amount.setText(str_premium_amount);
                } else if (str_deductible.equals("450000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="408.15";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("450000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="1212.78";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("450000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="2378.92";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("450000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="4664.54";
                    premium_amount.setText(str_premium_amount);
                } else if (str_deductible.equals("500000") && str_sum_insured.equals("Monthly")){
                    str_premium_amount="429.93";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("500000") && str_sum_insured.equals("Quarterly")){
                    str_premium_amount="1212.78";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("500000") && str_sum_insured.equals("Half Yearly")){
                    str_premium_amount="2378.92";
                    premium_amount.setText(str_premium_amount);
                }else if (str_deductible.equals("500000") && str_sum_insured.equals("Annualy")){
                    str_premium_amount="4664.54";
                    premium_amount.setText(str_premium_amount);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        buy_now_arogya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_sum_insured.equals("Select")){
                    Toast.makeText(Arogya_product.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent=new Intent(Arogya_product.this, Arogya_Member_info.class);
                    intent.putExtra("str_edt_name",str_edt_name);
                    intent.putExtra("str_edt_phone",str_edt_phone);
                    intent.putExtra("str_email",str_email);
                    intent.putExtra("str_age",str_age);
                    intent.putExtra("str_reference_no",str_reference_no);
                    intent.putExtra("str_family_individual",str_family_individual);
                    intent.putExtra("str_edit_adult",str_edit_adult);
                    intent.putExtra("str_no_child",str_no_child);
                    intent.putExtra("str_no_parent",str_no_parent);
                    intent.putExtra("str_deductible",str_deductible);
                    intent.putExtra("str_sum_insured",str_sum_insured);
                    intent.putExtra("str_premium_amount",str_premium_amount);
                    startActivity(intent);
                    Arogya_product.this.finish();
                }


            }
        });
    }
}