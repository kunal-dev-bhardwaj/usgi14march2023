package com.universalsompo.meta.metaapp.motor.activities.motor_renewal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_summery;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.MotorPayemntWebURl;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class RenewalFinalMotor extends AppCompatActivity {
    String today,VehicleType,strPolicyPlan="",QuoteID="",FinalPremium="",RegistrationNo="",GST="",NewIDV="",ManufatureName="",VehicleModel="",ProductCode="",NetPremium="",NCB="",VehiclePolicyHolderName="",VehiclePolicyNumber="",strPACover="",strGPACover="",strDrivingLicence="",VehicleEndDate="",VehicleManufactureYear="",VehicleNoOFDateLeft="",strPolicyStartDate;
    TextView RenewalPolicyType,VehicleNumberText,VehicleModelNumber,RegistrationYear,IDVTxt,OwnerNameTxt,OwnerGmailId,OwnerMobileNumber,PinCodeTxt,PlanTypeTXT,ModelVehicleTxt,PolicyStartDate,PlanType,NetPremiumTxt,NCBTxt,GSTTxt,FinalPremiumTxt,TotalPremium;
    TextView continue_button,UpgradePlanTxt;
    CheckBox CheckBoxTerm;
    private MySharedPreference pref;
    Date date;
    ImageView imgeBike;
    Format formatter;
    ImageView RenewalSummaryBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal_final_motor);
        getWindow().setStatusBarColor(ContextCompat.getColor(RenewalFinalMotor.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(RenewalFinalMotor.this);
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
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        Log.e("Today",today);

        UpgradePlanTxt=findViewById(R.id.UpgradePlanTxt);
        VehicleNumberText=findViewById(R.id.VehicleNumberText);
        VehicleModelNumber=findViewById(R.id.VehicleModelNumber);
        RegistrationYear=findViewById(R.id.RegistrationYear);
        IDVTxt=findViewById(R.id.IDVTxt);
        OwnerNameTxt=findViewById(R.id.OwnerNameTxt);
        OwnerGmailId=findViewById(R.id.OwnerGmailId);
        OwnerMobileNumber=findViewById(R.id.OwnerMobileNumber);
        PinCodeTxt=findViewById(R.id.PinCodeTxt);
        PlanTypeTXT=findViewById(R.id.PlanTypeTXT);
        ModelVehicleTxt=findViewById(R.id.ModelVehicleTxt);
        PolicyStartDate=findViewById(R.id.PolicyStartDate);
        PlanType=findViewById(R.id.PlanType);
        NetPremiumTxt=findViewById(R.id.NetPremium);
        NCBTxt=findViewById(R.id.NCBTxt);
        GSTTxt=findViewById(R.id.GSTTxt);
        FinalPremiumTxt=findViewById(R.id.FinalPremium);
        TotalPremium=findViewById(R.id.TotalPremium);
        continue_button=findViewById(R.id.continue_button);
        CheckBoxTerm=findViewById(R.id.CheckBoxTerm);
        RenewalPolicyType=findViewById(R.id.RenewalPolicyType);
        imgeBike=findViewById(R.id.imgeBike);
        RenewalSummaryBack=findViewById(R.id.RenewalSummaryBack);


        if (VehicleType.equals("FW")){
            RenewalPolicyType.setText("Four Wheeler Insurance");
            imgeBike.setBackgroundResource(R.drawable.fourwheelerimg);
        }
        else{
            RenewalPolicyType.setText("Two Wheeler Insurance");
            imgeBike.setBackgroundResource(R.drawable.scooty_motor_img);
        }

        VehicleNumberText.setText(RegistrationNo);
        VehicleModelNumber.setText(VehicleModel);
        RegistrationYear.setText(VehicleManufactureYear);
        IDVTxt.setText(NewIDV);
        OwnerNameTxt.setText(VehiclePolicyHolderName);
        OwnerGmailId.setText(pref.getEmailId());
        OwnerMobileNumber.setText(pref.getMOBILE());
        PinCodeTxt.setText(pref.getpincode());
        PlanTypeTXT.setText(strPolicyPlan);
        ModelVehicleTxt.setText(VehicleModel+" "+ManufatureName);
        PolicyStartDate.setText(today);
        PlanType.setText(strPolicyPlan);
        NetPremiumTxt.setText(NetPremium);
        NCBTxt.setText(NCB+" %");
        GSTTxt.setText(GST);
        FinalPremiumTxt.setText("₹ "+FinalPremium);
        TotalPremium.setText("₹ "+FinalPremium);

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!CheckBoxTerm.isChecked()){
                    Toast.makeText(RenewalFinalMotor.this, "Please Select Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(RenewalFinalMotor.this, RenewalPayementWebPage.class);
                    intent.putExtra("WACode","20000001");
                    intent.putExtra("PosPolicyNo",QuoteID);
                    intent.putExtra("TotalValue",FinalPremium);
                    startActivity(intent);
                }

            }
        });

        RenewalSummaryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RenewalFinalMotor.this,Renewal_Motor.class);
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
                finish();
            }
        });

        UpgradePlanTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RenewalFinalMotor.this,RenewalAddOns.class);
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


            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(RenewalFinalMotor.this,Renewal_Motor.class);
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
        finish();
    }
}