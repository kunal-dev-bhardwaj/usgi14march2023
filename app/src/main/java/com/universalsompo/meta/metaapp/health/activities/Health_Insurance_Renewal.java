package com.universalsompo.meta.metaapp.health.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
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
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.renewal_model.RenewalMember;
import com.universalsompo.meta.metaapp.health.activities.renewal_model.RenewalModel;
import com.universalsompo.meta.metaapp.health.activities.renewal_model.TenureModel;
import com.universalsompo.meta.metaapp.health.activities.renewalpayment.HealthRenewalSummary;
import com.universalsompo.meta.metaapp.health.activities.renewalpayment.RenewalAdapter;
import com.universalsompo.meta.metaapp.health.activities.renewalpayment.RenewalHealthPayment;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Health_Insurance_Renewal extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
      EditText edt_phone,edit_dob,edt_email,IDTypeEdit,IDNumberEdit;
    private SimpleDateFormat dateFormatter;
    EditText policy_number_health,tenure_edit;
    RadioButton yes_existing,no_existing;
    ImageView calendarIconSelf;
    String str_edt_phone,firstNameCKYC,dobCKYC,strRelation,strSelfName,strSelfDob1,strSelfDob,strSelfEmailId,strSelfMobileNumber,strMobile,manualKYCurl_intent,ckycNo,strFor,strSelfAgeEditText,strDob,str_edt_name,strUID,uniqueTransactionNumber,strIDNumberEdit,strIDType,strIDTypeName,strIDTypeEdit,strEditdobString,streditdob,str_email,strThirdDString,str_new_dob,today,str_edit_dob3String,sumInsured,str_existing,str_policy_number_health,str_dob,strSelectedSumInsured,str_memberItem,QuotationHealthRenewal,str_member_count,strPremiumDetails,QuotationHealthTenure;
     MySharedPreference pref;
     Button btn_register,pay_now_renewal;
    Date date,CurrentDate,SelectDate;
    Format formatter;
    CheckBox chkCondition;
    int selectYearAdult,SelectMonthDOB,SelectDaysDOB;
    ArrayList<RenewalMember> member_items = new ArrayList<>();
    ArrayList<String> memberList= new ArrayList<>();
     ArrayList<RenewalModel> PremiumDetails_items = new ArrayList<RenewalModel>();
     ArrayList<String> sumInsuredList= new ArrayList<>();
     TextView member_count,premiumAmount;
     Spinner SumInsured_spinner_renewal,member_spinner_renewal;
     LinearLayout IDTypeSpinner,term_condition;
    String PanExpression="[A-Z]{5}[0-9]{4}[A-Z]{1}";
    String VoterIDExpression="^[A-Z]{3}[0-9]{7}$";
    String AadharExpression="^[2-9][0-9]{11}$";
    String PassportExpression="^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$";
    //    String DrivingExpression="^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$";
    String DrivingExpression="^([A-Z]{2})(\\d{2}|\\d{3})[a-zA-Z]{0,1}(\\d{4})(\\d{7})$";
    public Period period;
    CustomProgressDialog customprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health__insurance__renewal);
        getWindow().setStatusBarColor(ContextCompat.getColor(Health_Insurance_Renewal.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Health_Insurance_Renewal.this);
        customprogress = new CustomProgressDialog(Health_Insurance_Renewal.this);
        strFor = getIntent().getStringExtra("strFor");
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_email = getIntent().getStringExtra("str_email");
        streditdob = getIntent().getStringExtra("streditdob");
        strIDTypeEdit = getIntent().getStringExtra("strIDTypeEdit");
        strIDNumberEdit = getIntent().getStringExtra("strIDNumberEdit");
        str_policy_number_health = getIntent().getStringExtra("str_policy_number_health");
        strIDType = getIntent().getStringExtra("strIDType");
        strEditdobString = getIntent().getStringExtra("strEditdobString");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");

        edt_phone=findViewById(R.id.edt_phone);
        term_condition=findViewById(R.id.term_condition);
        calendarIconSelf=findViewById(R.id.calendarIconSelf);
        edit_dob=findViewById(R.id.edit_dob);
        edt_email=findViewById(R.id.edt_email);
        IDTypeEdit=findViewById(R.id.IDTypeEdit);
        IDNumberEdit=findViewById(R.id.IDNumberEdit);
        IDTypeSpinner=findViewById(R.id.IDTypeSpinner);
        chkCondition = findViewById(R.id.checkbox);
        TextView back_button = findViewById(R.id.back_button);
        LinearLayout cross_icon = findViewById(R.id.cross_icon);
         policy_number_health = findViewById(R.id.policy_number_health);
        yes_existing = findViewById(R.id.yes_existing);
        no_existing = findViewById(R.id.no_existing);
        btn_register = findViewById(R.id.btn_register);
        member_count = findViewById(R.id.member_count);
        pay_now_renewal = findViewById(R.id.pay_now_renewal);
        SumInsured_spinner_renewal = findViewById(R.id.SumInsured_spinner_renewal);
        member_spinner_renewal = findViewById(R.id.member_spinner_renewal);
        tenure_edit = findViewById(R.id.tenure_edit);
        premiumAmount = findViewById(R.id.premiumAmount);
        member_spinner_renewal.setOnItemSelectedListener(this);
        SumInsured_spinner_renewal.setOnItemSelectedListener(this);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);

        TextView policy_no_text = findViewById(R.id.policy_no_text);
        policy_no_text.setText("Health Insurance Renewal");
        strUID=pref.getUID();
        strMobile=pref.getMOBILE();
        edt_phone.setText(strMobile);

        if (strFor.equals("0")){
            streditdob="Select Dob";
            strIDTypeEdit="Select ID Type";
            strIDNumberEdit="";
            str_policy_number_health="";
            str_email=pref.getEmailId();
            str_edt_name=pref.getUserName();
            edt_email.setText(str_email);
            edit_dob.setText(streditdob);
            IDTypeEdit.setText(strIDTypeEdit);
        }else{
            edt_email.setText(str_email);
            edit_dob.setText(streditdob);
            IDTypeEdit.setText(strIDTypeEdit);
            IDNumberEdit.setText(strIDNumberEdit);
            policy_number_health.setText(str_policy_number_health);
        }


        cross_icon.setOnClickListener(v -> onBackPressed());


        calendarIconSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalender();
            }
        });

        term_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Health_Insurance_Renewal.this);
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

        str_existing="No";
        yes_existing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_existing.isChecked()){
                    str_existing="Yes";
                    no_existing.setChecked(false);
                }
            }
        });

        no_existing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_existing.isChecked()){
                    str_existing="No";
                    yes_existing.setChecked(false);
                }
            }
        });


        IDTypeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Health_Insurance_Renewal.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select ID Type");
                items1.add("PAN Card");
                items1.add("Voter ID");
                items1.add("Passport");
                items1.add("Driving Licence");
                items1.add("Existing CKYC Number");
                items1.add("Reference Number");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strIDTypeEdit=items1.get(options1);
                        IDTypeEdit.setText(strIDTypeEdit);
                       if (strIDTypeEdit.equals("PAN Card")){
                            strIDType="PAN";
                            strIDTypeName="PAN";
                            strIDNumberEdit="";
                            IDNumberEdit.setText(strIDNumberEdit);
                        }else if (strIDTypeEdit.equals("Voter ID")){
                            strIDType="VOTER_ID";
                            strIDTypeName="VOTER";
                            strIDNumberEdit="";
                            IDNumberEdit.setText(strIDNumberEdit);
                        }else if (strIDTypeEdit.equals("Passport")){
                            strIDType="PASSPORT";
                           strIDTypeName="PASSPORT";
                            strIDNumberEdit="";
                            IDNumberEdit.setText(strIDNumberEdit);
                        }else if (strIDTypeEdit.equals("Driving Licence")){
                            strIDType="DRIVING_LICENCE";
                            strIDTypeName="DRIVING";
                            strIDNumberEdit="";
                            IDNumberEdit.setText(strIDNumberEdit);
                        }else if (strIDTypeEdit.equals("Existing CKYC Number")){
                            strIDType="CKYC_NO";
                            strIDTypeName="EXISTING";
                            strIDNumberEdit="";
                            IDNumberEdit.setText(strIDNumberEdit);
                        }else if (strIDTypeEdit.equals("Reference Number")){
                            strIDType="CKYC_NO";
                            strIDTypeName="REFERENCE";
                            strIDNumberEdit="";
                            IDNumberEdit.setText(strIDNumberEdit);
                        }
                    }
                });
                singlePicker.show();
            }
        });
        
        
        
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_policy_number_health=policy_number_health.getText().toString();
                str_dob=edit_dob.getText().toString();
                str_email=edt_email.getText().toString();
                str_edt_phone=edt_phone.getText().toString();
                strIDNumberEdit= IDNumberEdit.getText().toString();
                if (str_policy_number_health.equals("")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Enter Policy Number", Toast.LENGTH_SHORT).show();
                }else if (!str_policy_number_health.contains("/")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Enter Valid Policy Number", Toast.LENGTH_SHORT).show();
                }else if (str_edt_phone.equals("")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Enter Phone number", Toast.LENGTH_SHORT).show();
                }else if(!str_edt_phone.matches("^[6-9]\\d{9}$")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Phone number is not valid.", Toast.LENGTH_SHORT).show();
                }else if (str_email.equals("")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
                    Toast.makeText(Health_Insurance_Renewal.this, "Email address is not valid.", Toast.LENGTH_SHORT).show();
                }else if (streditdob.equals("Select Dob")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Enter DOB", Toast.LENGTH_SHORT).show();
                }else if (strIDTypeEdit.equals("Select ID Type")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Select ID Type", Toast.LENGTH_SHORT).show();
                }else if (strIDNumberEdit.equals("")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Enter ID Number", Toast.LENGTH_SHORT).show();
                }else if (strIDTypeEdit.equals("PAN Card")){
                    if (!strIDNumberEdit.matches(PanExpression)){
                        Toast.makeText(Health_Insurance_Renewal.this, "Enter Valid PAN Card Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(Health_Insurance_Renewal.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }else if (strIDTypeEdit.equals("Voter ID")){
                    if (!strIDNumberEdit.matches(VoterIDExpression)){
                        Toast.makeText(Health_Insurance_Renewal.this, "Enter Valid Voter ID Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(Health_Insurance_Renewal.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }else if (strIDTypeEdit.equals("Passport")){
                    if (!strIDNumberEdit.matches(PassportExpression)){
                        Toast.makeText(Health_Insurance_Renewal.this, "Enter Valid Passport Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(Health_Insurance_Renewal.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }else if (strIDTypeEdit.equals("Driving Licence")){
                    if (!strIDNumberEdit.matches(DrivingExpression)){
                        Toast.makeText(Health_Insurance_Renewal.this, "Enter Valid Driving Licence Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(Health_Insurance_Renewal.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }else if (strIDTypeEdit.equals("Reference Number")){
                    if (!strIDNumberEdit.contains("/")){
                        Toast.makeText(Health_Insurance_Renewal.this, "Reference Number should be (xxxx/xxxx/xxxx)", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(Health_Insurance_Renewal.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else {
                        ResultStatusURL();
                    }
                }
                else if (!chkCondition.isChecked()) {
                    Toast.makeText(Health_Insurance_Renewal.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    CKYURL();
                    customprogress.showProgressBar();
                }
                
            }
        });
        pay_now_renewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strSelectedSumInsured.equals("")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Standard SumInsured Value needed", Toast.LENGTH_SHORT).show();
                }else if (str_member_count.equals("")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Standard SumInsured Value needed", Toast.LENGTH_SHORT).show();
                }else if (strPremiumDetails.equals("")){
                    Toast.makeText(Health_Insurance_Renewal.this, "Standard Premium Value needed", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(Health_Insurance_Renewal.this, RenewalHealthPayment.class);
                    intent.putExtra("QuotationHealthRenewal",QuotationHealthRenewal);
                    intent.putExtra("strPremiumDetails",strPremiumDetails);
                    intent.putExtra("str_policy_number_health",str_policy_number_health);
                    startActivity(intent);

                }
            }
        });
    }

    private void renewal_health() {
        JSONObject object = new JSONObject();
        try {
            object.put("WACode","20000001");
            object.put("WAAppCode","30000011");
            object.put("ProductCode","2825");
            object.put("PreviousPolicyNo",str_policy_number_health);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Health_Insurance_Renewal.this, object, UrlHealthConstants.RENEWAL_HEALTH, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                PremiumDetails_items.clear();
                sumInsuredList.clear();
                if (object.optString("ErrorCode").equals("3001")) {
                    if (Tag == RequestHealthConstants.RENEWAL_HEALTH_URL) {
                        try {
                            JSONObject jsonObject = object.getJSONObject("Authentication");
                            JSONArray CHI_Renewal_Members_arr = object.getJSONArray("CHI_Renewal_Members");
                            JSONArray PremiumDetails_arr = object.getJSONArray("PremiumDetails");

                            for (int i = 0; i < CHI_Renewal_Members_arr.length(); i++) {
                                JSONObject CHI_Renewal_Members_Object = CHI_Renewal_Members_arr.getJSONObject(i);
                                RenewalMember RenewalMemberModel = new RenewalMember(CHI_Renewal_Members_Object.getString("Name"),
                                        CHI_Renewal_Members_Object.getString("DOB"));
                                        member_items.add(RenewalMemberModel);
                                memberList.add(CHI_Renewal_Members_Object.getString("Name"));
                            }
                            member_spinner_renewal.setAdapter(new ArrayAdapter<>(Objects.requireNonNull(getApplicationContext()), android.R.layout.simple_list_item_1, memberList));

                            str_member_count= String.valueOf(CHI_Renewal_Members_arr.length());
                            Log.e("str_member_count",str_member_count);
                                member_count.setText(str_member_count);

                                for (int i = 0; i < PremiumDetails_arr.length(); i++) {
                                JSONObject PremiumDetails_arr_Object = PremiumDetails_arr.getJSONObject(i);

                                RenewalModel RenewalModel = new RenewalModel(PremiumDetails_arr_Object.getString("Quoteid"),
                                        PremiumDetails_arr_Object.getString("Tenure"),
                                        PremiumDetails_arr_Object.getString("SumInsured"),
                                        PremiumDetails_arr_Object.getString("BasicCoverPremium"),
                                        PremiumDetails_arr_Object.getString("Netpremium"),
                                        PremiumDetails_arr_Object.getString("Finalpremium"));
                                     PremiumDetails_items.add(RenewalModel);
                                sumInsuredList.add(PremiumDetails_arr_Object.getString("SumInsured"));
                                 Log.e("sumInsuredList", String.valueOf(sumInsuredList));
                                  sumInsured=PremiumDetails_items.get(i).getSumInsured();
                            }

                            Intent intent=new Intent(Health_Insurance_Renewal.this, RenewalHealthStandard.class);
                            intent.putExtra("sumInsuredList", sumInsuredList);
                            intent.putExtra("memberList", memberList);
                            intent.putExtra("str_member_count",str_member_count);
                            intent.putExtra("str_policy_number_health",str_policy_number_health);
                            intent.putExtra("PremiumDetails_items", PremiumDetails_items);
                            startActivity(intent);
                        }
                        catch (JSONException e) {
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
        }, RequestHealthConstants.RENEWAL_HEALTH_URL);
        req.execute();
    }

    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Health_Insurance_Renewal.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            streditdob=dateFormatter.format(newDate.getTime());
            String[] strdDate=  streditdob.split("-");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strEditdobString = strdDate[2];
            edit_dob.setText(streditdob);
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
            

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
                case R.id.SumInsured_spinner_renewal:
                    strSelectedSumInsured=SumInsured_spinner_renewal.getSelectedItem().toString();
                    if (strSelectedSumInsured.equals( PremiumDetails_items.get(position).getSumInsured())) {
                      strPremiumDetails=PremiumDetails_items.get(position).getFinalpremium();
                       premiumAmount.setText(strPremiumDetails);
                      QuotationHealthRenewal=PremiumDetails_items.get(position).getQuoteid();
                      QuotationHealthTenure=PremiumDetails_items.get(position).getTenure();
                        tenure_edit.setText(QuotationHealthTenure);
                }
            case R.id.member_spinner_renewal:
                str_memberItem=member_spinner_renewal.getSelectedItem().toString();
//                if (strSelectedSumInsured.equals( PremiumDetails_items.get(position).getSumInsured())) {
//                    strPremiumDetails=PremiumDetails_items.get(position).getFinalpremium();
//                    premiumAmount.setText(strPremiumDetails);
//                    QuotationHealthRenewal=PremiumDetails_items.get(position).getQuoteid();
//                    QuotationHealthTenure=PremiumDetails_items.get(position).getTenure();
//                    tenure_edit.setText(QuotationHealthTenure);
//                }

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Health_Insurance_Renewal.this, object, UrlHealthConstants.ResultStatusAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult = object.getJSONObject("result");
                        String idNo = objectResult.getString("idNo");
                        String ckycNo = objectResult.getString("ckycNo");
                        firstNameCKYC = objectResult.getString("name");
                        dobCKYC= objectResult.getString("dob");
//                        address1 = objectResult.getString("address");
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
                            Date date1 = dateFormatter.parse(dobCKYC);
                            dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                            strSelfAgeEditText= dateFormatter.format(date);
                            strDob= dateFormatter.format(date1);
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
                                selectYearAdult = period.getYears();
                                int SelectMonth = period.getMonths();
                                int SelectDays = period.getDays();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (kycVerifiedStatus.equals("True")){
                            ChiRenewal();
                        }else{
                            Toast.makeText(Health_Insurance_Renewal.this, "You KYC Verification not completed yet Please wait...", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    try {
                        JSONObject objectResult = object.getJSONObject("error");
                        String message =objectResult.getString("message");
                        Toast.makeText(Health_Insurance_Renewal.this, ""+message, Toast.LENGTH_SHORT).show();
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
        Log.e("uniqueTransactionNumber_new",uniqueTransactionNumber);
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
                        JSONObject objectResult = response.getJSONObject("result");
                        uniqueTransactionNumber =response.optString("uniqueTransactionNumber");
                        ckycNo = objectResult.getString("ckycNo");
                        firstNameCKYC = objectResult.getString("firstName");
                        String middleName = objectResult.getString("middleName");
                        String lastName = objectResult.getString("lastName");
                        dobCKYC = objectResult.getString("dob");
                        Log.e("dobCKYC",dobCKYC);

                        Dialog KYCDialog = new Dialog(Health_Insurance_Renewal.this);
                        KYCDialog.setCanceledOnTouchOutside(false);
                        KYCDialog.setCancelable(false);
                        KYCDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        Objects.requireNonNull(KYCDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        KYCDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                        KYCDialog.setContentView(R.layout.ckyc_done_alert);
                        ImageView cutImg;
                        TextView TextViewLink;
                        LinearLayout continueButtonPopup;
                        cutImg = KYCDialog.findViewById(R.id.cutImg);
                        TextViewLink = KYCDialog.findViewById(R.id.TextViewLink);
                        continueButtonPopup = KYCDialog.findViewById(R.id.continueButtonPopup);
                        KYCDialog.show();
                        cutImg.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                KYCDialog.dismiss();
                            }
                        });

                        continueButtonPopup.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ChiRenewal();
                                KYCDialog.dismiss();
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        JSONObject error1=response.getJSONObject("error");
                        String message = error1.getString("message");
                        if (message.equals("source is not configured in system so please connect with system administrator")){
                            Toast.makeText(Health_Insurance_Renewal.this, message, Toast.LENGTH_SHORT).show();
                        }else{
                            JSONObject object1=response.getJSONObject("result");
                             manualKYCurl_intent = object1.getString("manualKYCurl");
                            Log.e("manualKYCurl1",manualKYCurl_intent);
                            EmailConsumeAPI();
                            SMSConsumeAPI();
                            final Dialog alert_dialog1 = new Dialog(Health_Insurance_Renewal.this);
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
                Toast.makeText(Health_Insurance_Renewal.this, "" +error, Toast.LENGTH_SHORT).show();
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
        RequestQueue queue = Volley.newRequestQueue(Health_Insurance_Renewal.this);
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Health_Insurance_Renewal.this, object, UrlHealthConstants.EmailConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("true")) {
                    String message =object.optString("message");
                    Toast.makeText(Health_Insurance_Renewal.this, ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("message");
                    Toast.makeText(Health_Insurance_Renewal.this, ""+message, Toast.LENGTH_SHORT).show();
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
            object.put("MobileNo", strMobile);
            object.put("SMS","Dear "+str_edt_name+ " ,Greetings from Universal Sompo General Insurance!  Click here " +manualKYCurl_intent+" to complete your KYC. Please ignore if you have completed the KYC.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Health_Insurance_Renewal.this, object, UrlHealthConstants.SMSConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    String message =object.optString("Message");
                    Toast.makeText(Health_Insurance_Renewal.this, ""+message, Toast.LENGTH_SHORT).show();
                }
                else {
                    String message =object.optString("Message");
                    Toast.makeText(Health_Insurance_Renewal.this, ""+message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedCHISMS);
        req.execute();
    }
    private void ChiRenewal() {
        JSONObject object = new JSONObject();
        try {
            object.put("WACode", "20000001");
            object.put("WAAppCode","30000011");
            object.put("ProductCode","2825");
            object.put("PreviousPolicyNo",str_policy_number_health);
            object.put("CKYCNo",ckycNo);
            object.put("Ref_No_Unique_KYC",uniqueTransactionNumber);
        } catch (Exception e) {
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Health_Insurance_Renewal.this, object, UrlHealthConstants.Renewal_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("ErrorDesc").equals("Premium Calculated.")) {
                    JSONArray arrMember = null;
                    try {
                        arrMember = object.getJSONArray("CHI_Renewal_Members");
                        for (int i = 0; i < arrMember.length(); i++) {
                            strRelation = arrMember.optJSONObject(i).getString("Relation");
                            if (strRelation.equals("Self")) {
                                strSelfName= arrMember.optJSONObject(i).getString("Name");
                                strSelfDob1 = arrMember.optJSONObject(i).getString("DOB");

                                String parts[] = strSelfName.split(" ");
                                strSelfName= parts[0];
                                Log.e("strSelfName",strSelfName);

                                String partsDob[] = strSelfDob1.split(" ");
                                String strSelfDob12= partsDob[0];
                                String strSelfDob21= partsDob[1];

                                String[] strdDate=  strSelfDob12.split("/");
                                String strDobMonth = strdDate[0];
                                String strDobDay = strdDate[1];
                                String strDobYear = strdDate[2];
                                strSelfDob=strDobDay+"-"+strDobMonth+"-"+strDobYear;
                                 Log.e("strSelfDob",strSelfDob);
//                                strSelfDob = strSelfDob12.replace("/", "-");
                                if (firstNameCKYC.equalsIgnoreCase(strSelfName)||dobCKYC.equals(strSelfDob)){
                                    Intent intent=new Intent(Health_Insurance_Renewal.this, HealthRenewalSummary.class);
                                    intent.putExtra("str_edt_name",str_edt_name);
                                    intent.putExtra("str_email",str_email);
                                    intent.putExtra("streditdob",streditdob);
                                    intent.putExtra("strIDTypeEdit",strIDTypeEdit);
                                    intent.putExtra("strIDNumberEdit",strIDNumberEdit);
                                    intent.putExtra("str_policy_number_health",str_policy_number_health);
                                    intent.putExtra("ckycNo",ckycNo);
                                    intent.putExtra("uniqueTransactionNumber",uniqueTransactionNumber);
                                    intent.putExtra("strIDType",strIDType);
                                    intent.putExtra("strEditdobString",strEditdobString);
                                    intent.putExtra("strIDTypeName",strIDTypeName);
                                    intent.putExtra("strFor","0");
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(Health_Insurance_Renewal.this, "Your CKYC Details are not matching with Policy Holder Details", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    String Msg=object.optString("ErrorDesc");
                    Toast.makeText(Health_Insurance_Renewal.this, ""+Msg, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RenewalCHIAPI);
        req.execute();
    }

}