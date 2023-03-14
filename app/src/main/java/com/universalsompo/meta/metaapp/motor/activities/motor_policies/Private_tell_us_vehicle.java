package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Payment_Complete_healthCare;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Private_tell_us_vehicle extends AppCompatActivity {
     Button btn_previous,btn_pay;
    String str_edt_phone="",str_edt_email="",str_edt_registration_no="",str_edt_city="",str_rto_location="",str_manufacture_year="",str_edt_registration_date="",str_previous_start_date="",str_manufacture_name="",str_vehicle_model="",str_previousPolicy="",str_claim_policy="",str_edt_ex_showroom_price="",
            str_declared_Value,str_no_pa_owner="",str_legal="",str_key_replacement="",str_accidental="",str_return_invoice="",str_electrical_accessories,str_non_electrical,str_engine_protector,str_ownerDetails,str_properName,
            str_addressLine1,str_addressLine2,str_city_edit,str_area_edit,str_pincode_edit,str_vehicleDetails,str_ChassisNumber,str_engineNumber,str_RtoName,str_previousPrice,str_ChassisNumberPrevious,str_PreviousPolicyNumberPrevious,str_insuranceCompanyName;
      EditText ownerDetails,properName,addressLine1,addressLine2,city_edit,area_edit,pincode_edit,vehicleDetails,ChassisNumber,engineNumber,RtoName,previousPrice,ChassisNumberPrevious,PreviousPolicyNumberPrevious,insuranceCompanyName;
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    Date date;
    String Proposal_today_date,From_tomorrowDate,nextYear;
    Format formatter;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_tell_us_vehicle);
        getWindow().setStatusBarColor(ContextCompat.getColor(Private_tell_us_vehicle.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Private_tell_us_vehicle.this);
        customprogress = new CustomProgressDialog(Private_tell_us_vehicle.this);
        str_edt_registration_no = getIntent().getStringExtra("str_edt_registration_no");
        str_edt_city = getIntent().getStringExtra("str_edt_city");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_edt_email = getIntent().getStringExtra("str_edt_email");
        str_rto_location =getIntent().getStringExtra("str_rto_location");
        str_manufacture_year =getIntent().getStringExtra("str_manufacture_year");
        str_edt_registration_date = getIntent().getStringExtra("str_edt_registration_date");
        str_manufacture_name = getIntent().getStringExtra("str_manufacture_name");
        str_vehicle_model = getIntent().getStringExtra("str_vehicle_model");
        str_previousPolicy = getIntent().getStringExtra("str_previousPolicy");
        str_claim_policy = getIntent().getStringExtra("str_claim_policy");
        str_previous_start_date = getIntent().getStringExtra("str_previous_start_date");
        str_edt_ex_showroom_price = getIntent().getStringExtra("str_edt_ex_showroom_price");
        str_declared_Value = getIntent().getStringExtra("str_declared_Value");
        str_electrical_accessories = getIntent().getStringExtra("str_electrical_accessories");
        str_non_electrical = getIntent().getStringExtra("str_non_electrical");
        str_no_pa_owner = getIntent().getStringExtra("str_no_pa_owner");
        str_legal = getIntent().getStringExtra("str_legal");
        str_accidental = getIntent().getStringExtra("str_accidental");
        str_key_replacement = getIntent().getStringExtra("str_key_replacement");
        str_return_invoice = getIntent().getStringExtra("str_return_invoice");
        str_engine_protector = getIntent().getStringExtra("str_engine_protector");


          Calendar calendar = Calendar.getInstance();
          date = calendar.getTime();
          formatter = new SimpleDateFormat("dd/MM/yyyy");
          Proposal_today_date = formatter.format(date);
          Log.e("Today",Proposal_today_date);

          calendar.add(Calendar.DATE, 1);
          date = calendar.getTime();
          formatter = new SimpleDateFormat("dd/MM/yyyy");
          From_tomorrowDate = formatter.format(date);
          Log.e("tomorrowDate",From_tomorrowDate);

          calendar.add(Calendar.DATE, 364);
          date = calendar.getTime();
          formatter = new SimpleDateFormat("dd/MM/yyyy");
          nextYear = formatter.format(date);
          Log.e("nextYear",nextYear);

          initview();
    }

    private void initview() {
        btn_previous=findViewById(R.id.btn_previous);
        ownerDetails=findViewById(R.id.ownerDetails);
        properName=findViewById(R.id.properName);
        addressLine1=findViewById(R.id.addressLine1);
        addressLine2=findViewById(R.id.addressLine2);
        city_edit=findViewById(R.id.city_edit);
        area_edit=findViewById(R.id.area_edit);
        pincode_edit=findViewById(R.id.pincode_edit);
        vehicleDetails=findViewById(R.id.vehicleDetails);
        ChassisNumber=findViewById(R.id.ChassisNumber);
        engineNumber=findViewById(R.id.engineNumber);
        RtoName=findViewById(R.id.RtoName);
        PreviousPolicyNumberPrevious=findViewById(R.id.PreviousPolicyNumberPrevious);
        previousPrice=findViewById(R.id.previousPrice);
        ChassisNumberPrevious=findViewById(R.id.ChassisNumberPrevious);
        insuranceCompanyName=findViewById(R.id.insuranceCompanyName);
        btn_pay=findViewById(R.id.btn_pay);


        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_ownerDetails=ownerDetails.getText().toString();
                str_properName=properName.getText().toString();
                str_addressLine1=addressLine1.getText().toString();
                str_addressLine2=addressLine2.getText().toString();
                str_city_edit=city_edit.getText().toString();
                str_area_edit=area_edit.getText().toString();
                str_pincode_edit=pincode_edit.getText().toString();
                str_vehicleDetails=vehicleDetails.getText().toString();
                str_ChassisNumber=ChassisNumber.getText().toString();
                str_engineNumber=engineNumber.getText().toString();
                str_RtoName=RtoName.getText().toString();
                str_previousPrice=previousPrice.getText().toString();
                str_PreviousPolicyNumberPrevious=PreviousPolicyNumberPrevious.getText().toString();
                str_ChassisNumberPrevious=ChassisNumberPrevious.getText().toString();
                str_insuranceCompanyName=insuranceCompanyName.getText().toString();

                if (str_properName.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Proposer Name", Toast.LENGTH_SHORT).show();
                }else if (str_addressLine1.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Address Line1", Toast.LENGTH_SHORT).show();
                }else if (str_addressLine2.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Address Line2", Toast.LENGTH_SHORT).show();
                }else if (str_city_edit.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter City", Toast.LENGTH_SHORT).show();
                }else if (str_area_edit.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Area/Village", Toast.LENGTH_SHORT).show();
                }else if (str_pincode_edit.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Pincode", Toast.LENGTH_SHORT).show();
                }else if (str_ChassisNumber.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Chassis Number", Toast.LENGTH_SHORT).show();
                }else if (str_engineNumber.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Engine Number", Toast.LENGTH_SHORT).show();
                }else if (str_RtoName.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter RTO Name", Toast.LENGTH_SHORT).show();
                }else if (str_ChassisNumberPrevious.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Previous policy Chassis Number", Toast.LENGTH_SHORT).show();
                }else if (str_PreviousPolicyNumberPrevious.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Previous Policy Number", Toast.LENGTH_SHORT).show();
                }else if (str_insuranceCompanyName.equals("")){
                    Toast.makeText(Private_tell_us_vehicle.this, "Enter Previous Insurance Company Name", Toast.LENGTH_SHORT).show();
                }else{
                 payNow();
                }

            }
        });

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Private_tell_us_vehicle.super.onBackPressed();
            }
        });
    }

    private void payNow() {
          JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("CustomerName",pref.getUID());
            object.put("DOB",pref.getDOB());
            object.put("gender",pref.getgender());
            object.put("ContactTelephoneSTD",pref.getlandline());
            object.put("PhoneNo",str_edt_phone);
            object.put("emailid",str_edt_email);
            object.put("PresentAddressLine1",str_addressLine1);
            object.put("PresentAddressLine2",str_addressLine2);
            object.put("PresentStateCode","");
            object.put("PresentCityDistCode",str_city_edit);
            object.put("PresentPinCode",str_pincode_edit);
            object.put("PermanentAddressLine1",str_addressLine1);
            object.put("PermanentAddressLine2",str_addressLine2);
            object.put("PermanentStateCode","");
            object.put("PermanentCityDistCode",str_city_edit);
            object.put("PermanentPinCode",str_city_edit);
            object.put("NomineeName","");
            object.put("NomineeRelation","");
            object.put("PANNo","");
            object.put("AadhaarNo","");
            object.put("Total_Premium","20000");
            object.put("Proposal_Date",Proposal_today_date);
            object.put("From_Date",From_tomorrowDate);
            object.put("To_Date",nextYear);
            object.put("reg_no",str_edt_registration_no);
            object.put("RTO_LOC_Code",str_rto_location);
            object.put("reg_Date",str_edt_registration_date);
            object.put("Manufacurer_Year",str_manufacture_year);
            object.put("Vehicle_model",str_vehicle_model);
            object.put("Ex_Showroom_price",str_edt_ex_showroom_price);
            object.put("Engine_Num",str_engineNumber);
            object.put("Chasis_Num",str_ChassisNumber);
            object.put("RTO_Name",str_RtoName);
            object.put("IDV",str_declared_Value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Private_tell_us_vehicle.this, object, UrlHealthConstants.BUY_MOTOR_POLICY_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestHealthConstants.BUY_POLICY_PRIVATE_CAR_URL) {
                        try {
                            JSONObject jsonObject = object.getJSONObject("Authentication");
                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
                            JSONObject ProductJsonObject = object.getJSONObject("Product");
                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                            Log.e("gg", String.valueOf(PremiumCalculationJsonObject));
                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
                            Log.e("TotalPremium", String.valueOf(TotalPremiumJsonObject));
                            String WACode = jsonObject.getString("WACode");
                            Log.e("WACode", WACode);
                            String PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                            Log.e("PosPolicyNo", PosPolicyNo);
                            String TotalValue = TotalPremiumJsonObject.getString("Value");
                            Log.e("TotalValue", TotalValue);

                            Intent intent=new Intent(Private_tell_us_vehicle.this, PaymentWebUrl.class);
                            intent.putExtra("WACode",WACode);
                            intent.putExtra("PosPolicyNo",PosPolicyNo);
                            intent.putExtra("TotalValue",TotalValue);
                            startActivity(intent);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(getApplication(), "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.BUY_POLICY_PRIVATE_CAR_URL);
        req.execute();

    }
}