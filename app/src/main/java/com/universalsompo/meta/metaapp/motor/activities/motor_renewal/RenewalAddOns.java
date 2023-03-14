package com.universalsompo.meta.metaapp.motor.activities.motor_renewal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;

public class RenewalAddOns extends AppCompatActivity {
     LinearLayout continue_button;
    String today,VehicleType,strPolicyPlan="",QuoteID="",FinalPremium="",RegistrationNo="",GST="",NewIDV="",ManufatureName="",VehicleModel="",ProductCode="",NetPremium="",NCB="",VehiclePolicyHolderName="",VehiclePolicyNumber="",strPACover="",strGPACover="",strDrivingLicence="",VehicleEndDate="",VehicleManufactureYear="",VehicleNoOFDateLeft="",strPolicyStartDate;
     TextView TxtViewVehicleType;
     ImageView AddOnsBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_add_ons);
        getWindow().setStatusBarColor(ContextCompat.getColor(RenewalAddOns.this, R.color.colorPrimaryDark));

        VehiclePolicyHolderName = getIntent().getStringExtra("VehiclePolicyHolderName");
        VehiclePolicyNumber = getIntent().getStringExtra("VehiclePolicyNumber");
        VehicleEndDate = getIntent().getStringExtra("VehicleEndDate");
        VehicleManufactureYear = getIntent().getStringExtra("VehicleManufactureYear");
        VehicleNoOFDateLeft = getIntent().getStringExtra("VehicleNoOFDateLeft");
        FinalPremium = getIntent().getStringExtra("FinalPremium");
        QuoteID = getIntent().getStringExtra("QuoteID");
        RegistrationNo = getIntent().getStringExtra("RegistrationNo");
        GST = getIntent().getStringExtra("GST");
        NewIDV = getIntent().getStringExtra("NewIDV");
        ManufatureName = getIntent().getStringExtra("ManufatureName");
        VehicleModel = getIntent().getStringExtra("VehicleModel");
        ProductCode = getIntent().getStringExtra("ProductCode");
        NetPremium = getIntent().getStringExtra("NetPremium");
        NCB = getIntent().getStringExtra("NCB");
        VehicleType = getIntent().getStringExtra("VehicleType");
        strPolicyPlan = getIntent().getStringExtra("strPolicyPlan");

        continue_button=findViewById(R.id.continue_button);
        TxtViewVehicleType=findViewById(R.id.TxtViewVehicleType);
        AddOnsBack=findViewById(R.id.AddOnsBack);

        if (VehicleType.equals("FW")){
            TxtViewVehicleType.setText("Four Wheeler Insurance");
        } else{
            TxtViewVehicleType.setText("Two Wheeler Insurance");
        }


        AddOnsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RenewalAddOns.this,RenewalFinalMotor.class);
                intent.putExtra("VehiclePolicyHolderName",VehiclePolicyHolderName);
                intent.putExtra("VehiclePolicyNumber",VehiclePolicyNumber);
                intent.putExtra("VehicleManufactureYear",VehicleManufactureYear);
                intent.putExtra("VehicleNoOFDateLeft",VehicleNoOFDateLeft);
                intent.putExtra("VehicleEndDate",VehicleEndDate);
                intent.putExtra("FinalPremium",FinalPremium);
                intent.putExtra("QuoteID",QuoteID);
                intent.putExtra("RegistrationNo",RegistrationNo);
                intent.putExtra("GST",GST);
                intent.putExtra("NewIDV",NewIDV);
                intent.putExtra("ManufatureName",ManufatureName);
                intent.putExtra("VehicleModel",VehicleModel);
                intent.putExtra("ProductCode",ProductCode);
                intent.putExtra("NetPremium",NetPremium);
                intent.putExtra("strPolicyPlan",strPolicyPlan);
                intent.putExtra("VehicleType",VehicleType);
                intent.putExtra("NCB",NCB);
                startActivity(intent);
                startActivity(intent);
            }
        });

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RenewalAddOns.this,RenewalVehicleDetails.class);
                intent.putExtra("VehiclePolicyHolderName",VehiclePolicyHolderName);
                intent.putExtra("VehiclePolicyNumber",VehiclePolicyNumber);
                intent.putExtra("VehicleManufactureYear",VehicleManufactureYear);
                intent.putExtra("VehicleNoOFDateLeft",VehicleNoOFDateLeft);
                intent.putExtra("VehicleEndDate",VehicleEndDate);
                intent.putExtra("FinalPremium",FinalPremium);
                intent.putExtra("QuoteID",QuoteID);
                intent.putExtra("RegistrationNo",RegistrationNo);
                intent.putExtra("GST",GST);
                intent.putExtra("NewIDV",NewIDV);
                intent.putExtra("ManufatureName",ManufatureName);
                intent.putExtra("VehicleModel",VehicleModel);
                intent.putExtra("ProductCode",ProductCode);
                intent.putExtra("NetPremium",NetPremium);
                intent.putExtra("strPolicyPlan",strPolicyPlan);
                intent.putExtra("VehicleType",VehicleType);
                intent.putExtra("NCB",NCB);
                startActivity(intent);
                startActivity(intent);
            }
        });
    }
}