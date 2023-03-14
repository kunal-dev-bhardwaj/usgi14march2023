package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PlanCompleteHealthCare extends AppCompatActivity {
      TextView txtNetPremiumValue;
    String str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,str_oneWeightEdit,TotalValue,NetPremiumValue,GST,PosPolicyNo,str_policyType_spinner,str_IndividualTypeEdit,str_SumInsured,str_policyTenure,strFirstTString,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_edit_dob3String,str_spouse_edit_dob_dob,str_OneEditName,str_edit_dob3StringSpouse,strOneChild,strChildOne,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,strtwoDob,strChildTwo,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,
            strthreeDob,strChildThree,str_thirdWeightEdit,strFourWeightEdit,str_for,today,strfourDob,strChildFour,strThirdDString,str_new_dob,tomorrowDate,nextYear;
    Date date;
    Format formatter;
    LinearLayout linerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_complete_health_care);
        getWindow().setStatusBarColor(ContextCompat.getColor(PlanCompleteHealthCare.this, R.color.colorPrimaryDark));


        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_reference_no = getIntent().getStringExtra("str_reference_no");
        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
        str_gender = getIntent().getStringExtra("str_gender");
        str_occupation = getIntent().getStringExtra("str_occupation");
        str_ft = getIntent().getStringExtra("str_ft");
        str_inches = getIntent().getStringExtra("str_inches");
        str_weight_edit = getIntent().getStringExtra("str_weight_edit");
        str_edt_Spouse_name = getIntent().getStringExtra("str_edt_Spouse_name");
        str_spouse_edit_dob_dob = getIntent().getStringExtra("str_spouse_edit_dob_dob");
        str_spouse_gender = getIntent().getStringExtra("str_spouse_gender");
        str_spouse_occupation_spinner = getIntent().getStringExtra("str_spouse_occupation_spinner");
        str_spouse_ft_spinner = getIntent().getStringExtra("str_spouse_ft_spinner");
        str_spouse_inches_spinner = getIntent().getStringExtra("str_spouse_inches_spinner");
        str_spouse_weight_edit = getIntent().getStringExtra("str_spouse_weight_edit");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        str_SumInsured = getIntent().getStringExtra("str_SumInsured");
        str_IndividualTypeEdit = getIntent().getStringExtra("str_IndividualTypeEdit");
        str_OneEditName = getIntent().getStringExtra("str_OneEditName");
        str_twoChildEditName = getIntent().getStringExtra("str_twoChildEditName");
        str_thirdNameEdit = getIntent().getStringExtra("str_thirdNameEdit");
        str_fourNameEdit = getIntent().getStringExtra("str_fourNameEdit");
        TotalValue = getIntent().getStringExtra("TotalValue");
        strFirstTString = getIntent().getStringExtra("strFirstTString");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strChildOne = getIntent().getStringExtra("strChildOne");
        strChildTwo = getIntent().getStringExtra("strChildTwo");
        strChildThree = getIntent().getStringExtra("strChildThree");
        strChildFour = getIntent().getStringExtra("strChildFour");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        strOneChild = getIntent().getStringExtra("strOneChild");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strtwoDob = getIntent().getStringExtra("strtwoDob");
        strthreeDob = getIntent().getStringExtra("strthreeDob");
        strfourDob = getIntent().getStringExtra("strfourDob");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        GST = getIntent().getStringExtra("GST");
        str_for = getIntent().getStringExtra("for");


        String[] strParts =  str_age.split("yrs");
        String strFirstString = strParts[0];
        String strSecondString = strParts[1];
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        String[] strTDate=  today.split("/");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        Log.e("strThirdDString", strThirdDString);
        Log.e("Today",today);
        int new_dob= Integer.parseInt(strThirdDString)- Integer.parseInt(strFirstString);
        Log.e("new_dob", String.valueOf(new_dob));
        str_new_dob=strFirstDString+"/"+ strSecondDString + "/"+String.valueOf(new_dob);
        Log.e("str_new_dob", str_new_dob);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate",tomorrowDate);
        calendar.add(Calendar.DATE, 364);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        nextYear = formatter.format(date);
        Log.e("nextYear",nextYear);


        linerBtn=findViewById(R.id.linerBtn);
        txtNetPremiumValue=findViewById(R.id.txtNetPremiumValue);
        txtNetPremiumValue.setText(NetPremiumValue);

        linerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlanCompleteHealthCare.this,Complete_health_member_info.class);
                intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                intent.putExtra("str_SumInsured",str_SumInsured);
                intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                intent.putExtra("NetPremiumValue",NetPremiumValue);
                intent.putExtra("GST",GST);
                intent.putExtra("TotalValue",TotalValue);
                intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                intent.putExtra("PosPolicyNo",PosPolicyNo);
                intent.putExtra("str_edt_name",str_edt_name);
                intent.putExtra("str_edt_phone",str_edt_phone);
                intent.putExtra("str_email",str_email);
                intent.putExtra("str_age",str_age);
                intent.putExtra("str_reference_no",str_reference_no);
                intent.putExtra("str_reference_no",str_reference_no);
                intent.putExtra("for","0");
                startActivity(intent);
                finish();
            }
        });

    }
}