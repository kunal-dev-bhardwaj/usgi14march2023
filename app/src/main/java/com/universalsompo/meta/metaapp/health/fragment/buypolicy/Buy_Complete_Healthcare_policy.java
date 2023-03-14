package com.universalsompo.meta.metaapp.health.fragment.buypolicy;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.hbb20.CountryCodePicker;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.BuyPolicySumInsured;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.ThankYouPageCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.CKYCWebPage;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.ChiSummery;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.SuperAddressDetails;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Member_Self;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.RegisterActivity;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Previous_Private_Policy_Details;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Add_Details_Old_Vehicle;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Buy_Complete_Healthcare_policy extends Fragment {
    EditText edt_name,edt_phone,edt_email,reference_no,EditDob,IDNumberEdit;
    MySharedPreference mySharedPreference;
    Button btn_next;
    Spinner age_spinner,GenderSpinner,IDTypeSpinner;
    String[] age;
    String[] IDType;
    String[] gender;
    String manualKYCurl_intent,permAndCorresAddSame,address1,address2,address3,corresAddress1,corresAddress2,corresAddress3,middleName,lastName,strDob,strCityEdit,strStateEdit,strPinCodeEdit,strEmailIDEditSelf,strSelfAgeEditText,strIDTypeName,manualKYCurl,strUID,
            uniqueTransactionNumber,strIDNumberEdit,strIDType,strEditdobString,streditdob,strProposerEdtName="",str_edt_name="",str_edt_phone="",str_email="",str_age="",strGenderSpinner="",str_reference_no="",selected_country_code,str_for;
    Switch switchbtn;
    private CheckBox chkCondition;
    CountryCodePicker ccp;
    LinearLayout term_condition;
     ImageView calendarIconSelf;
    private SimpleDateFormat dateFormatter;
    Date date,CurrentDate,SelectDate;
    int selectYearAdult,SelectMonthDOB,SelectDaysDOB,selectYearProposer;
    String PanExpression="[A-Z]{5}[0-9]{4}[A-Z]{1}";
    String VoterIDExpression="^[A-Z]{3}[0-9]{7}$";
    String AadharExpression="^[2-9][0-9]{11}$";
    String PassportExpression="^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$";
//    String DrivingExpression="^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$";
    String DrivingExpression="^([A-Z]{2})(\\d{2}|\\d{3})[a-zA-Z]{0,1}(\\d{4})(\\d{7})$";
    public Period period;
    CustomProgressDialog customprogress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_buy__complete__healthcare_policy, container, false);
        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));

        mySharedPreference= MySharedPreference.getInstance(getActivity());
        customprogress = new CustomProgressDialog(getContext());
        btn_next=view.findViewById(R.id.btn_next);
        EditDob=view.findViewById(R.id.EditDob);
        IDNumberEdit=view.findViewById(R.id.IDNumberEdit);
        calendarIconSelf=view.findViewById(R.id.calendarIconSelf);
        edt_name=view.findViewById(R.id.edt_name);
        edt_phone=view.findViewById(R.id.edt_phone);
        edt_email=view.findViewById(R.id.edt_email);
        age_spinner=view.findViewById(R.id.age_spinner);
        IDTypeSpinner=view.findViewById(R.id.IDTypeSpinner);
        GenderSpinner=view.findViewById(R.id.GenderSpinner);
        switchbtn=view.findViewById(R.id.switchbtn);
        reference_no=view.findViewById(R.id.reference_no);
        chkCondition = view.findViewById(R.id.checkbox);
        term_condition = view.findViewById(R.id.term_condition);
        ccp = view.findViewById(R.id.ccp);
        selected_country_code = ccp.getSelectedCountryCodeWithPlus();

        streditdob="Select Dob";
        EditDob.setText(streditdob);

        strUID=mySharedPreference.getUID();
        str_edt_name=mySharedPreference.getUserName();
        strProposerEdtName=str_edt_name;
        edt_name.setText(str_edt_name);
        edt_phone.setText(mySharedPreference.getMOBILE());
        str_email=mySharedPreference.getEmailId();
        edt_email.setText(str_email);
        getActivity().onBackPressed();

        age=getResources().getStringArray(R.array.ChiAge);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), R.layout.spinner_item_text,age);
        age_spinner.setAdapter(adapter);

        IDType=getResources().getStringArray(R.array.ChiID);
        final ArrayAdapter<String> adapterID=new ArrayAdapter<String>(getContext(), R.layout.spinner_item_text,IDType);
        IDTypeSpinner.setAdapter(adapterID);


        gender=getResources().getStringArray(R.array.ChiGender);
        final ArrayAdapter<String> GenderAdapter=new ArrayAdapter<String>(getContext(), R.layout.spinner_item_text,gender);
        GenderSpinner.setAdapter(GenderAdapter);

        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                selected_country_code = ccp.getSelectedCountryCodeWithPlus();
               edt_phone.setText("");

            }
        });

        reference_no.setFocusableInTouchMode(false);
        reference_no.setFocusable(false);
        reference_no.setClickable(false);
        reference_no.setFocusable(false);
        reference_no.setText("");
        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    reference_no.setFocusableInTouchMode(true);
                    reference_no.setClickable(true);
                    reference_no.setFocusable(true);
                    reference_no.setFocusable(true);
                }else{
                    reference_no.setFocusableInTouchMode(false);
                    reference_no.setFocusable(false);
                    reference_no.setClickable(false);
                    reference_no.setFocusable(false);
                    reference_no.setText("");
                }
            }
        });

        calendarIconSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalender();
            }
        });
        age_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_age = String.valueOf(age[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        IDTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strIDTypeName= String.valueOf(IDType[i]);
                if (strIDTypeName.equals("PAN Card")){
                    strIDType="PAN";
                    strIDNumberEdit="";
                    IDNumberEdit.setText(strIDNumberEdit);
                }else if (strIDTypeName.equals("Voter ID")){
                    strIDType="VOTER_ID";
                    strIDNumberEdit="";
                    IDNumberEdit.setText(strIDNumberEdit);
                }
//                else if (strIDTypeName.equals("Aadhar Card")){
//                    strIDType="AADHAAR";
//                    strIDNumberEdit="";
//                    Toast.makeText(getContext(), "Enter last 4 digits of your Aadhar Card", Toast.LENGTH_SHORT).show();
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }
                else if (strIDTypeName.equals("Passport")){
                    strIDType="PASSPORT";
                    strIDNumberEdit="";
                    IDNumberEdit.setText(strIDNumberEdit);
                }else if (strIDTypeName.equals("Driving Licence")){
                    strIDType="DRIVING_LICENCE";
                    strIDNumberEdit="";
                    IDNumberEdit.setText(strIDNumberEdit);
                }else if (strIDTypeName.equals("Existing CKYC Number")){
                    strIDType="CKYC_NO";
                    strIDNumberEdit="";
                    IDNumberEdit.setText(strIDNumberEdit);
                }else if (strIDTypeName.equals("Reference Number")){
                    strIDType="CKYC_NO";
                    strIDNumberEdit="";
                    IDNumberEdit.setText(strIDNumberEdit);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        GenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strGenderSpinner = String.valueOf(gender[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_edt_name=edt_name.getText().toString();
                str_edt_phone=edt_phone.getText().toString();
                str_email=edt_email.getText().toString();
                str_reference_no=reference_no.getText().toString();
//                int count = 000;
//                DecimalFormat decimalFormat = null;
//                for(count = 0 ; count <=0; count++){
//                     decimalFormat = new DecimalFormat("000");
//                     Log.e("khjugfdx", decimalFormat.format(count));
//                }
                strIDNumberEdit= IDNumberEdit.getText().toString();
                if (strGenderSpinner.equals("Select Gender")){
                    Toast.makeText(getContext(), "Select Gender", Toast.LENGTH_SHORT).show();
                }else if (streditdob.equals("Select Dob")){
                    Toast.makeText(getContext(), "Enter DOB", Toast.LENGTH_SHORT).show();
                }else if (str_email.equals("")){
                    Toast.makeText(getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
                    Toast.makeText(getContext(), "Email address is not valid.", Toast.LENGTH_SHORT).show();
                }else if (selectYearAdult < 18 || selectYearAdult > 75) {
                    Toast.makeText(getContext(), "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                }
                else if (strIDTypeName.equals("Select ID Type")){
                    Toast.makeText(getContext(), "Select ID Type", Toast.LENGTH_SHORT).show();
                }else if (strIDNumberEdit.equals("")){
                    Toast.makeText(getContext(), "Enter ID Number", Toast.LENGTH_SHORT).show();
                }else if (strIDTypeName.equals("PAN Card")){
                    if (!strIDNumberEdit.matches(PanExpression)){
                        Toast.makeText(getContext(), "Enter Valid PAN Card Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }else if (strIDTypeName.equals("Voter ID")){
                    if (!strIDNumberEdit.matches(VoterIDExpression)){
                        Toast.makeText(getContext(), "Enter Valid Voter ID Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }
//                else if (strIDTypeName.equals("Aadhar Card")){
////                    if (!strIDNumberEdit.matches(AadharExpression)){
////                        Toast.makeText(getContext(), "Enter Valid Aadhar Number", Toast.LENGTH_SHORT).show();
////                    }else
//
//                    if (!chkCondition.isChecked()) {
//                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                    }else{
//                        CKYURL();
//                    }
//                }
                else if (strIDTypeName.equals("Passport")){
                    if (!strIDNumberEdit.matches(PassportExpression)){
                        Toast.makeText(getContext(), "Enter Valid Passport Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }else if (strIDTypeName.equals("Driving Licence")){
                    if (!strIDNumberEdit.matches(DrivingExpression)){
                        Toast.makeText(getContext(), "Enter Valid Driving Licence Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }else if (strIDTypeName.equals("Reference Number")){
                    if (!strIDNumberEdit.contains("/")){
                        Toast.makeText(getContext(), "Reference Number should be (xxxx/xxxx/xxxx)", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else {
                        ResultStatusURL();
//                        customprogress.showProgressBar();
                    }
                }
                else if (!chkCondition.isChecked()) {
                  Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    CKYURL();
                    customprogress.showProgressBar();
                }
//                 else if (str_age.equals("Select Age")){
//                    Toast.makeText(getContext(), "Select Age", Toast.LENGTH_SHORT).show();
//                }
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
    private void ResultStatusURL() {
        JSONObject object = new JSONObject();
        try {
            object.put("source", "ONLINE");
            object.put("uniqueTransactionNumber",strIDNumberEdit);
            object.put("extraField1","");
            object.put("extraField2","");
            object.put("extraField3","");
            object.put("extraField4","");
            object.put("extraField5","");

        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getContext(), object, UrlHealthConstants.ResultStatusAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult = object.getJSONObject("result");
                        String idNo = objectResult.getString("idNo");
                        String ckycNo = objectResult.getString("ckycNo");
                        String firstName = objectResult.getString("name");
                        String dob = objectResult.getString("dob");
                        address1 = objectResult.getString("address");
                        String pincode = objectResult.getString("pincode");
                        String maskedAadhaarNumber = objectResult.getString("maskedAadhaarNumber");
                        String pan = objectResult.getString("pan");
                        String email = objectResult.getString("email");
                        String mobileNumber = objectResult.getString("mobileNumber");
                        String uploadedDocument = objectResult.getString("uploadedDocument");
                        String capturedLiveFace = objectResult.getString("capturedLiveFace");
                        String kycVerifiedStatus = objectResult.getString("kycVerifiedStatus");
                        String kycVerifiedDate = objectResult.getString("kycVerifiedDate");
                        try {
                            Date date = dateFormatter.parse(streditdob);
                            Date date1 = dateFormatter.parse(dob);
                            dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                            strSelfAgeEditText= dateFormatter.format(date);
                            strDob= dateFormatter.format(date1);
                            Log.e("strSelfAgeEditText", strSelfAgeEditText);
                            Log.e("strDob", strDob);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        try {
                            Calendar calendar = Calendar.getInstance();
                            date = calendar.getTime();
                            String today1 = dateFormatter.format(date);
                            SelectDate = dateFormatter.parse(strDob);
                            CurrentDate = dateFormatter.parse(today1);
                            long selectNewDate = SelectDate.getTime();
                            long TodayendDate = CurrentDate.getTime();
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                selectYearProposer = period.getYears();
                                int SelectMonth = period.getMonths();
                                int SelectDays = period.getDays();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (kycVerifiedStatus.equals("True")){
                            Intent intent=new Intent(getContext(), PolicyTypeCHI.class);
                            intent.putExtra("str_edt_name",str_edt_name);
                            intent.putExtra("idNo",idNo);
//                        intent.putExtra("strEdtNameSelf",str_edt_name);
                            intent.putExtra("strProposerEdtName",strProposerEdtName);
                            intent.putExtra("str_edt_phone",str_edt_phone);
                            intent.putExtra("str_email",str_email);
                            intent.putExtra("streditdob",streditdob);
                            intent.putExtra("strDob",strDob);
                            intent.putExtra("str_age",str_age);
                            intent.putExtra("str_reference_no",str_reference_no);
                            intent.putExtra("strGenderSpinner",strGenderSpinner);
                            intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
                            intent.putExtra("selectYearAdult",selectYearAdult);
                            intent.putExtra("strEmailIDEditSelf",strEmailIDEditSelf);
                            intent.putExtra("strPinCodeEdit",strPinCodeEdit);
                            intent.putExtra("strCityEdit",strCityEdit);
                            intent.putExtra("strStateEdit",strStateEdit);
                            intent.putExtra("address1",address1);
                            intent.putExtra("address2",address2);
                            intent.putExtra("address3",address3);
                            intent.putExtra("corresAddress1",corresAddress1);
                            intent.putExtra("corresAddress2",corresAddress2);
                            intent.putExtra("corresAddress3",corresAddress3);
                            intent.putExtra("str_edt_phone",mobileNumber);
                            intent.putExtra("firstName",firstName);
                            intent.putExtra("middleName",middleName);
                            intent.putExtra("lastName",lastName);
                            intent.putExtra("ckycNo",ckycNo);
                            intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                            intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
                            intent.putExtra("selectYearProposer",selectYearProposer);
                            intent.putExtra("strIDTypeName",strIDTypeName);
                            intent.putExtra("strFor","0");
                            startActivity(intent);
                        }else{
                            Toast.makeText(getContext(), "You KYC Verification not completed yet Please wait...", Toast.LENGTH_SHORT).show();
                        }



//                        str_edt_name=firstName+" "+middleName+" "+lastName;


                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    try {
                        JSONObject objectResult = object.getJSONObject("error");
                        String message =objectResult.getString("message");
                        Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedResultStatusAPI);
        req.execute();
    }
    private void CKYURL() {
        uniqueTransactionNumber="ONLINE/261122/"+strIDTypeName+strIDNumberEdit+strEditdobString;
        JSONObject object = new JSONObject();
        try {
            object.put("source", "ONLINE");
            object.put("customerType","I");
            object.put("uniqueTransactionNumber",uniqueTransactionNumber);
            object.put("idNo",strIDNumberEdit);
            object.put("idType",strIDType);
            object.put("dob",streditdob);
            object.put("mobileNo","");
            object.put("pincode","");
            object.put("cKYCNo","");
            object.put("extraField1","");
            object.put("extraField2","");
            object.put("extraField3","");
            object.put("extraField4","");
            object.put("extraField5","");
        } catch (Exception e) {
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, UrlHealthConstants.CKYC_URL, object,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("onResponse", response.toString());
                customprogress.hideProgressBar();
                if (response.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult=response.getJSONObject("result");
                        uniqueTransactionNumber =response.optString("uniqueTransactionNumber");
                        String ckycNo = objectResult.getString("ckycNo");
                        String firstName = objectResult.getString("firstName");
                        String middleName = objectResult.getString("middleName");
                        String lastName = objectResult.getString("lastName");
                        String dob = objectResult.getString("dob");
                        String address1 = objectResult.getString("address1");
                        String address2 = objectResult.getString("address2");
                        String address3 = objectResult.getString("address3");
                        strCityEdit = objectResult.getString("city");
                        String district = objectResult.getString("district");
                        strStateEdit = objectResult.getString("state");
                        String country= objectResult.getString("country");
                        strPinCodeEdit = objectResult.getString("pincode");
                        String corresAddress1 = objectResult.getString("corresAddress1");
                        String corresAddress2 = objectResult.getString("corresAddress2");
                        String corresAddress3 = objectResult.getString("corresAddress3");
                        String corresCity = objectResult.getString("corresCity");
                        String corresDist = objectResult.getString("corresDist");
                        String corresState = objectResult.getString("corresState");
                        String corresCountry = objectResult.getString("corresCountry");
                        String corresPin = objectResult.getString("corresPin");
                        String aadhaar = objectResult.getString("aadhaar");
                        String pan = objectResult.getString("pan");
                        strEmailIDEditSelf = objectResult.getString("email");
                        String mobileNumber = objectResult.getString("mobileNumber");
                        String permAndCorresAddSame = objectResult.getString("permAndCorresAddSame");
                        //Format change dd-mm-yyy to dd/mm/yyyy
                        try {
                            Date date = dateFormatter.parse(streditdob);
                            Date date1 = dateFormatter.parse(dob);
                            dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                            strSelfAgeEditText= dateFormatter.format(date);
                            strDob= dateFormatter.format(date1);
                            Log.e("strSelfAgeEditText", strSelfAgeEditText);
                            Log.e("strDob", strDob);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        try {
                            Calendar calendar = Calendar.getInstance();
                            date = calendar.getTime();
                            String today1 = dateFormatter.format(date);
                            SelectDate = dateFormatter.parse(strDob);
                            CurrentDate = dateFormatter.parse(today1);
                            long selectNewDate = SelectDate.getTime();
                            long TodayendDate = CurrentDate.getTime();
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                selectYearProposer = period.getYears();
                                int SelectMonth = period.getMonths();
                                int SelectDays = period.getDays();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

//                        str_edt_name=firstName+" "+middleName+" "+lastName;
                        Intent intent=new Intent(getContext(), PolicyTypeCHI.class);
                        intent.putExtra("str_edt_name",str_edt_name);
//                        intent.putExtra("strEdtNameSelf",str_edt_name);
                        intent.putExtra("strProposerEdtName",strProposerEdtName);
                        intent.putExtra("str_edt_phone",str_edt_phone);
                        intent.putExtra("str_email",str_email);
                        intent.putExtra("streditdob",streditdob);
                        intent.putExtra("strDob",strDob);
                        intent.putExtra("str_age",str_age);
                        intent.putExtra("str_reference_no",str_reference_no);
                        intent.putExtra("strGenderSpinner",strGenderSpinner);
                        intent.putExtra("strSelfAgeEditText",strSelfAgeEditText);
                        intent.putExtra("selectYearAdult",selectYearAdult);
                        intent.putExtra("strEmailIDEditSelf",strEmailIDEditSelf);
                        intent.putExtra("strPinCodeEdit",strPinCodeEdit);
                        intent.putExtra("strCityEdit",strCityEdit);
                        intent.putExtra("strStateEdit",strStateEdit);
                        intent.putExtra("address1",address1);
                        intent.putExtra("address2",address2);
                        intent.putExtra("address3",address3);
                        intent.putExtra("corresAddress1",corresAddress1);
                        intent.putExtra("corresAddress2",corresAddress2);
                        intent.putExtra("corresAddress3",corresAddress3);
                        intent.putExtra("str_edt_phone",mobileNumber);
                        intent.putExtra("firstName",firstName);
                        intent.putExtra("middleName",middleName);
                        intent.putExtra("lastName",lastName);
                        intent.putExtra("ckycNo",ckycNo);
                        intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                        intent.putExtra("permAndCorresAddSame",permAndCorresAddSame);
                        intent.putExtra("selectYearProposer",selectYearProposer);
                        intent.putExtra("strIDTypeName",strIDTypeName);
                        intent.putExtra("strFor","0");
                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    try {
                        JSONObject error1=response.getJSONObject("error");
                        String message = error1.getString("message");
                        if (message.equals("source is not configured in system so please connect with system administrator")){
                            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                        }else{
                            JSONObject object1=response.getJSONObject("result");
                            manualKYCurl_intent = object1.getString("manualKYCurl");
                            Log.e("manualKYCurl1",manualKYCurl_intent);
                            EmailConsumeAPI();
                            SMSConsumeAPI();
                            final Dialog alert_dialog1 = new Dialog(getContext());
                            alert_dialog1.setCanceledOnTouchOutside(false);
                            alert_dialog1.setCancelable(false);
                            alert_dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            Objects.requireNonNull(alert_dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                            alert_dialog1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                            alert_dialog1.setContentView(R.layout.ckycpopup);
                            ImageView cutImg;
                            TextView TextViewLink;
                            cutImg = alert_dialog1.findViewById(R.id.cutImg);
                            TextViewLink = alert_dialog1.findViewById(R.id.TextViewLink);
                            alert_dialog1.show();
                            cutImg.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    alert_dialog1.dismiss();
                                }
                            });

                            TextViewLink.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(manualKYCurl_intent));
                                    startActivity(browserIntent);
                                    alert_dialog1.dismiss();
//                                    Intent intent=new Intent(getContext(), CKYCWebPage.class);
//                                    intent.putExtra("manualKYCurl",manualKYCurl_intent);
//                                    Log.e("manualKYCurl_intent",manualKYCurl_intent);
//                                    startActivity(intent);
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
                }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("onErrorResponse", error.toString());
                customprogress.hideProgressBar();
                Toast.makeText(getContext(), "" +error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
//                headers.put("userid", "usgi_ckyc_user_prod");
//                headers.put("password", "VXNnIVBAJCFAMjAyMw==");
                headers.put("userid", "usgi_ckyc_user");
                headers.put("password", "Usgi!@2022");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(requireContext());
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
    private void EmailConsumeAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("subject", "Kindly Complete Your KYC");
            object.put("toEmail",str_email);
            object.put("toName",str_edt_name);
            object.put("contentValue","<p style='font-family:calibri;color:black;'>Hi "+ str_edt_name +",</p> <p style='font-family:calibri;color:black;'> Thank you for choosing Universal Sompo General Insurance as your Insurance Partner.  Please complete your KYC by clicking " +manualKYCurl_intent+" . <p style='font-family:calibri;color:black;'>We promise to be there for you 24x7, whenever you need us. In case you have any queries, feel free to reach us at 1800 200 4030 or mail at contactus@universalsompo.com .</p> <p style='font-family:calibri;color:black;'>Don’t forget to download PULZ App on which you can manage your policy easily and explore a host of value-added services.</p> <p style='font-family:calibri;color:black;'>Explore the app: Download LINK: https://play.google.com/store/apps/details?id=com.universalsompo.meta </p>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getContext(), object, UrlHealthConstants.EmailConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("true")) {
                   String message =object.optString("message");
                    Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("message");
                    Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedCHIEmail);
        req.execute();
    }
    private void SMSConsumeAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("MobileNo", str_edt_phone);
            object.put("SMS","Dear "+str_edt_name+ " ,Greetings from Universal Sompo General Insurance!  Click here https://www.usgi.co.in/p?q=ed3ASVwPRK to complete your KYC. Please ignore if you have completed the KYC.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getContext(), object, UrlHealthConstants.SMSConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    String message =object.optString("Message");
                    Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("Message");
                    Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedCHISMS);
        req.execute();
    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(getContext(), R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            streditdob=dateFormatter.format(newDate.getTime());
            String[] strdDate=  streditdob.split("-");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strEditdobString = strdDate[2];
            EditDob.setText(streditdob);
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
           String today1 = formatter.format(date);
           try {
                SelectDate = dateFormatter.parse(streditdob);
                CurrentDate = dateFormatter.parse(today1);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                  Period period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearAdult = period.getYears();
                    SelectMonthDOB = period.getMonths();
                    SelectDaysDOB = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearAdult < 18 || (selectYearAdult > 75)) {
                Toast.makeText(getContext(), "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                streditdob="Select Dob";
                EditDob.setText(streditdob);
            }
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                str_age="18yrs-25yrs";
            }else if (selectYearAdult >= 26 && selectYearAdult <= 30) {
                str_age="26yrs-30yrs";
            }else if (selectYearAdult >= 31 && selectYearAdult <= 35) {
                str_age="31yrs-35yrs";
            }else if (selectYearAdult >= 36 && selectYearAdult <= 40) {
                str_age="36yrs-40yrs";
            }else if (selectYearAdult >= 41 && selectYearAdult <= 45) {
                str_age="41yrs-45yrs";
            }else if (selectYearAdult >= 46 && selectYearAdult <= 50) {
                str_age="46yrs-50yrs";
            }else if (selectYearAdult >= 51 && selectYearAdult <= 55) {
                str_age="51yrs-55yrs";
            }else if (selectYearAdult >= 56 && selectYearAdult <= 60) {
                str_age="56yrs-60yrs";
            }else if (selectYearAdult >= 61 && selectYearAdult <= 65) {
                str_age="61yrs-65yrs";
            }else if (selectYearAdult >= 66 && selectYearAdult <= 70) {
                str_age="66yrs-70yrs";
            } else if (selectYearAdult >= 71 && selectYearAdult <= 75){
                str_age="71yrs-75yrs";
            }

           }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }


}