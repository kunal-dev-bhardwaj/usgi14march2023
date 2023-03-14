package com.universalsompo.meta.metaapp.health.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.renewal_model.RenewalModel;
import com.universalsompo.meta.metaapp.health.activities.renewalpayment.RenewalHealthPayment;
import com.universalsompo.meta.metaapp.health.activities.renewalpayment.UpgreadeRrenewalPlan;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.ArrayList;
import java.util.Objects;

public class RenewalHealthStandard extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    MySharedPreference pref;
    String str_dob,strSelectedSumInsured,strPremiumDetails,QuotationHealthRenewal,QuotationHealthTenure,str_memberItem,str_member_count,str_policy_number_health;
    Spinner SumInsured_spinner_renewal,member_spinner_renewal;
    ArrayList<String> sumInsuredList= new ArrayList<>();
    ArrayList<String> memberList= new ArrayList<>();
    ArrayList<RenewalModel> PremiumDetails_items=new ArrayList<>();
    TextView premiumAmount,member_count;
    Button pay_now_renewal,UpgradePlanBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_health_standard);

        getWindow().setStatusBarColor(ContextCompat.getColor(RenewalHealthStandard.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(RenewalHealthStandard.this);
        str_dob=pref.getDOB();
        sumInsuredList = (ArrayList<String>) getIntent().getSerializableExtra("sumInsuredList");
        memberList = (ArrayList<String>) getIntent().getSerializableExtra("memberList");
        str_member_count = getIntent().getStringExtra("str_member_count");
        str_policy_number_health = getIntent().getStringExtra("str_policy_number_health");
        PremiumDetails_items =  (ArrayList<RenewalModel>)getIntent().getSerializableExtra("PremiumDetails_items");

        pay_now_renewal = findViewById(R.id.pay_now_renewal);
        TextView back_button = findViewById(R.id.back_button);
        LinearLayout cross_icon = findViewById(R.id.cross_icon);
        SumInsured_spinner_renewal = findViewById(R.id.SumInsured_spinner_renewal);
        UpgradePlanBtn = findViewById(R.id.UpgradePlanBtn);
        premiumAmount = findViewById(R.id.premiumAmount);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);

        TextView policy_no_text = findViewById(R.id.policy_no_text);
        policy_no_text.setText("Health Insurance Renewal");
        member_count = findViewById(R.id.member_count);
//        edit_dob.setText(str_dob);

        cross_icon.setOnClickListener(v -> onBackPressed());
        SumInsured_spinner_renewal.setOnItemSelectedListener(this);
        member_count.setText(str_member_count);

        SumInsured_spinner_renewal.setAdapter(new ArrayAdapter<>(Objects.requireNonNull(getApplicationContext()), android.R.layout.simple_list_item_1, sumInsuredList));
        pay_now_renewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strSelectedSumInsured.equals("")){
                    Toast.makeText(RenewalHealthStandard.this, "Standard SumInsured Value needed", Toast.LENGTH_SHORT).show();
                }else if (str_member_count.equals("")){
                    Toast.makeText(RenewalHealthStandard.this, "Standard SumInsured Value needed", Toast.LENGTH_SHORT).show();
                }else if (strPremiumDetails.equals("")){
                    Toast.makeText(RenewalHealthStandard.this, "Standard Premium Value needed", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(RenewalHealthStandard.this, RenewalHealthPayment.class);
                    intent.putExtra("QuotationHealthRenewal",QuotationHealthRenewal);
                    intent.putExtra("strPremiumDetails",strPremiumDetails);
                    intent.putExtra("str_policy_number_health",str_policy_number_health);
                    startActivity(intent);

                }
            }
        });

        UpgradePlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RenewalHealthStandard.this, UpgreadeRrenewalPlan.class);
                intent.putExtra("sumInsuredList", sumInsuredList);
                intent.putExtra("memberList", memberList);
                intent.putExtra("str_member_count",str_member_count);
                intent.putExtra("str_policy_number_health",str_policy_number_health);
                intent.putExtra("PremiumDetails_items", PremiumDetails_items);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.SumInsured_spinner_renewal:
                strSelectedSumInsured=SumInsured_spinner_renewal.getSelectedItem().toString();
                if (strSelectedSumInsured.equals( PremiumDetails_items.get(position).getSumInsured())) {
                    strPremiumDetails=PremiumDetails_items.get(position).getFinalpremium();
                    premiumAmount.setText(strPremiumDetails);
                    QuotationHealthRenewal=PremiumDetails_items.get(position).getQuoteid();
                    QuotationHealthTenure=PremiumDetails_items.get(position).getTenure();
//                    tenure_edit.setText(QuotationHealthTenure);
                }


                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}