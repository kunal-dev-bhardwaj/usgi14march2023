package com.universalsompo.meta.metaapp.health.activities.renewalpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.renewal_model.RenewalModel;

import java.util.ArrayList;

public class UpgreadeRrenewalPlan extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String str_member_count,str_policy_number_health,strMember_spinner_renewal;
    ArrayList<String> sumInsuredList= new ArrayList<>();
    ArrayList<String> memberList= new ArrayList<>();
    ArrayList<RenewalModel> PremiumDetails_items=new ArrayList<>();
    Spinner member_spinner_renewal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgreade_rrenewal_plan);
        sumInsuredList = (ArrayList<String>) getIntent().getSerializableExtra("sumInsuredList");
        memberList = (ArrayList<String>) getIntent().getSerializableExtra("memberList");
        str_member_count = getIntent().getStringExtra("str_member_count");
        str_policy_number_health = getIntent().getStringExtra("str_policy_number_health");
        PremiumDetails_items =  (ArrayList<RenewalModel>)getIntent().getSerializableExtra("PremiumDetails_items");
        member_spinner_renewal=findViewById(R.id.member_spinner_renewal);
        member_spinner_renewal.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.member_spinner_renewal:
                strMember_spinner_renewal=member_spinner_renewal.getSelectedItem().toString();
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}