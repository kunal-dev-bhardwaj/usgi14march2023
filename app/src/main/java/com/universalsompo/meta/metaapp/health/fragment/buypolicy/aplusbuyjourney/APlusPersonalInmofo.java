package com.universalsompo.meta.metaapp.health.fragment.buypolicy.aplusbuyjourney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class APlusPersonalInmofo extends AppCompatActivity {
    private MySharedPreference mySharedPreference;
    private LinearLayout continueButton, selfLiner, MemberLiner, ckycHidden,linearLayoutNominee;
    private RelativeLayout verifyButton;
    ImageView selfDownArrowImg, selfUpArrowImg, down_arroy_ckyc, up_arroy_ckyc, calendarIconCykc,arrow_up_nominee,arrow_down_nominee;
    private String str_policyType_spinner, streditdob, strEditdobString, str_age = "", manualKYCurl_intent, permAndCorresAddSame, address1, address2, address3, corresAddress1, corresAddress2, corresAddress3, strDob, strCityEdit, strStateEdit, strPinCodeEdit, strEmailIDEditSelf, strSelfAgeEditText, strIDTypeName, strIdnumber, manualKYCurl, strUID,
            uniqueTransactionNumber, strIDNumberEdit, strIDType, strProposerEdtName = "", str_edt_name = "", str_edt_phone = "", str_email = "", strGenderSpinner = "", str_reference_no = "", selected_country_code, str_mobile;
    private SimpleDateFormat dateFormatter;
    private EditText editDobCkyc, IDNumberEdit, edt_phone,EditDobSelf,EdtNameSelf,EmailIDEditSelf,PhoneNumberEdit,permanentAddressEdit,PermanentAddressEdit2,city_edit_personal,state_edit_personal,pin_code_edit_personal;
    private Date date, CurrentDate, SelectDate;
    private int selectYearAdult, SelectMonthDOB, SelectDaysDOB, selectYearProposer;
    private Spinner IDTypeSpinner;
    private String[] IDType;
    String PanExpression = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
    String VoterIDExpression = "^[A-Z]{3}[0-9]{7}$";
    String AadharExpression = "^[2-9][0-9]{11}$";
    String PassportExpression = "^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$";
    String DrivingExpression = "^([A-Z]{2})(\\d{2}|\\d{3})[a-zA-Z]{0,1}(\\d{4})(\\d{7})$";
    private CustomProgressDialog customprogress;
    public Period period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplus_personal_inmofo);
        customprogress = new CustomProgressDialog(APlusPersonalInmofo.this);
        getWindow().setStatusBarColor(ContextCompat.getColor(APlusPersonalInmofo.this, R.color.colorPrimaryDark));
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        initView();
        IDType = getResources().getStringArray(R.array.ChiID);
        final ArrayAdapter<String> adapterID = new ArrayAdapter<String>(APlusPersonalInmofo.this, R.layout.spinner_item_text, IDType);
        IDTypeSpinner.setAdapter(adapterID);


        IDTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strIDTypeName = String.valueOf(IDType[i]);
                if (strIDTypeName.equals("PAN Card")) {
                    strIDType = "PAN";
                    strIDNumberEdit = "";
                    IDNumberEdit.setText(strIDNumberEdit);
                } else if (strIDTypeName.equals("Voter ID")) {
                    strIDType = "VOTER_ID";
                    strIDNumberEdit = "";
                    IDNumberEdit.setText(strIDNumberEdit);
                }
//                else if (strIDTypeName.equals("Aadhar Card")){
//                    strIDType="AADHAAR";
//                    strIDNumberEdit="";
//                    Toast.makeText(APlusPersonalInmofo.this, "Enter last 4 digits of your Aadhar Card", Toast.LENGTH_SHORT).show();
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }
                else if (strIDTypeName.equals("Passport")) {
                    strIDType = "PASSPORT";
                    strIDNumberEdit = "";
                    IDNumberEdit.setText(strIDNumberEdit);
                } else if (strIDTypeName.equals("Driving Licence")) {
                    strIDType = "DRIVING_LICENCE";
                    strIDNumberEdit = "";
                    IDNumberEdit.setText(strIDNumberEdit);
                } else if (strIDTypeName.equals("Existing CKYC Number")) {
                    strIDType = "CKYC_NO";
                    strIDNumberEdit = "";
                    IDNumberEdit.setText(strIDNumberEdit);
                } else if (strIDTypeName.equals("Reference Number")) {
                    strIDType = "CKYC_NO";
                    strIDNumberEdit = "";
                    IDNumberEdit.setText(strIDNumberEdit);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    private void initView() {

        continueButton = findViewById(R.id.continueButton);
        MemberLiner = findViewById(R.id.MemberLiner);
        selfLiner = findViewById(R.id.selfLiner);
        selfDownArrowImg = findViewById(R.id.selfDownArrowImg);
        selfUpArrowImg = findViewById(R.id.selfUpArrowImg);
        ckycHidden = findViewById(R.id.ckycHidden);
        down_arroy_ckyc = findViewById(R.id.down_arroy_ckyc);
        up_arroy_ckyc = findViewById(R.id.up_arroy_ckyc);
        calendarIconCykc = findViewById(R.id.calendarIconCykc);
        IDTypeSpinner = findViewById(R.id.IDTypeSpinner);
        IDNumberEdit = findViewById(R.id.IDNumberEdit);
        edt_phone = findViewById(R.id.edt_phone_ckyc);
        editDobCkyc = findViewById(R.id.edit_dob_ckyc);
        verifyButton = findViewById(R.id.verify_button);
        linearLayoutNominee = findViewById(R.id.layout_nominee_aplus);
        arrow_up_nominee = findViewById(R.id.arrow_up_nominee);
        arrow_down_nominee = findViewById(R.id.arrow_down_nominee);
        EdtNameSelf = findViewById(R.id.edit_text_personal_name);
        EditDobSelf = findViewById(R.id.edit_text_dob);
        EmailIDEditSelf = findViewById(R.id.email_edit_personal);
        PhoneNumberEdit = findViewById(R.id.phone_number_edit_personal);
        permanentAddressEdit = findViewById(R.id.permanent_address_Edit);
        PermanentAddressEdit2 = findViewById(R.id.permanent_address_edit2);
        city_edit_personal = findViewById(R.id.city_edit_personal);
        state_edit_personal = findViewById(R.id.state_edit_personal);
        pin_code_edit_personal = findViewById(R.id.pin_code_edit_personal);


        //shared preference
        mySharedPreference= MySharedPreference.getInstance(APlusPersonalInmofo.this);
        streditdob=mySharedPreference.getDOB();
        str_edt_name=mySharedPreference.getUserName();
        str_mobile=mySharedPreference.getMOBILE();

        edt_phone.setText(str_mobile);
        editDobCkyc.setText(streditdob);




        Log.d("asdasdf"," "+streditdob+" "+str_edt_name+" "+" "+str_mobile);
        arrow_up_nominee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutNominee.setVisibility(View.VISIBLE);
                arrow_up_nominee.setVisibility(View.INVISIBLE);
                arrow_down_nominee.setVisibility(View.VISIBLE);

            }
        });
        arrow_down_nominee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutNominee.setVisibility(View.GONE);
                arrow_up_nominee.setVisibility(View.VISIBLE);
                arrow_down_nominee.setVisibility(View.INVISIBLE);
            }
        });



        down_arroy_ckyc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ckycHidden.setVisibility(View.VISIBLE);
                up_arroy_ckyc.setVisibility(View.VISIBLE);
                down_arroy_ckyc.setVisibility(View.GONE);
            }
        });
        up_arroy_ckyc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ckycHidden.setVisibility(View.GONE);
                up_arroy_ckyc.setVisibility(View.GONE);
                down_arroy_ckyc.setVisibility(View.VISIBLE);

            }
        });
        calendarIconCykc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalender();
            }
        });






        selfDownArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfLiner.setVisibility(View.VISIBLE);
                selfUpArrowImg.setVisibility(View.VISIBLE);
                selfDownArrowImg.setVisibility(View.GONE);
            }
        });
        if (str_policyType_spinner.equals("Multi-individual") || str_policyType_spinner.equals("Family Floater")) {
            MemberLiner.setVisibility(View.VISIBLE);
        } else {
            MemberLiner.setVisibility(View.GONE);

        }

        selfUpArrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfLiner.setVisibility(View.GONE);
                selfUpArrowImg.setVisibility(View.GONE);
                selfDownArrowImg.setVisibility(View.VISIBLE);
            }
        });
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_edt_phone = edt_phone.getText().toString();
                strDob = editDobCkyc.getText().toString();
                strIDNumberEdit = IDNumberEdit.getText().toString();

                if (strDob.equals("Select Dob")) {
                    Toast.makeText(APlusPersonalInmofo.this, "Enter DOB", Toast.LENGTH_SHORT).show();
                } else if (str_edt_phone.equals(" ")) {
                    Toast.makeText(APlusPersonalInmofo.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();

                } else if (strIDNumberEdit.equals(" ")) {
                    Toast.makeText(APlusPersonalInmofo.this, "Enter ID Number", Toast.LENGTH_SHORT).show();

                }

//                else if (str_email.equals("")) {
//                    Toast.makeText(APlusPersonalInmofo.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                }
//                else if (!Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
//                    Toast.makeText(APlusPersonalInmofo.this, "Email address is not valid.", Toast.LENGTH_SHORT).show();
//                }
                else if (selectYearAdult < 18 || selectYearAdult > 75) {
                    Toast.makeText(APlusPersonalInmofo.this, "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                } else if (strIDTypeName.equals("Select ID Type")) {
                    Toast.makeText(APlusPersonalInmofo.this, "Select ID Type", Toast.LENGTH_SHORT).show();
                } else if (strIDNumberEdit.equals("")) {
                    Toast.makeText(APlusPersonalInmofo.this, "Enter ID Number", Toast.LENGTH_SHORT).show();
                } else if (strIDTypeName.equals("PAN Card")) {
                    if (!strIDNumberEdit.matches(PanExpression)) {
                        Toast.makeText(APlusPersonalInmofo.this, "Enter Valid PAN Card Number", Toast.LENGTH_SHORT).show();
                    }
//                            else if (!chkCondition.isChecked()) {
//                                Toast.makeText(APlusPersonalInmofo.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                            }

                    else {
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                } else if (strIDTypeName.equals("Voter ID")) {
                    if (!strIDNumberEdit.matches(VoterIDExpression)) {
                        Toast.makeText(APlusPersonalInmofo.this, "Enter Valid Voter ID Number", Toast.LENGTH_SHORT).show();
                    }
//                            else if (!chkCondition.isChecked()) {
//                                Toast.makeText(APlusPersonalInmofo.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                            }

                    else {
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                } else if (strIDTypeName.equals("Passport")) {
                    if (!strIDNumberEdit.matches(PassportExpression)) {
                        Toast.makeText(APlusPersonalInmofo.this, "Enter Valid Passport Number", Toast.LENGTH_SHORT).show();
                    }
//                            else if (!chkCondition.isChecked()) {
//                                Toast.makeText(APlusPersonalInmofo.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                            }

                    else {
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                }
                else if (strIDTypeName.equals("Driving Licence")) {
                    if (!strIDNumberEdit.matches(DrivingExpression)) {
                        Toast.makeText(APlusPersonalInmofo.this, "Enter Valid Driving Licence Number", Toast.LENGTH_SHORT).show();
                    }

//                            else if (!chkCondition.isChecked()) {
//                                Toast.makeText(APlusPersonalInmofo.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                            }

                    else {
                        CKYURL();
                        customprogress.showProgressBar();
                    }
                } else if (strIDTypeName.equals("Reference Number")) {
                    if (!strIDNumberEdit.contains("/")) {
                        Toast.makeText(APlusPersonalInmofo.this, "Reference Number should be (xxxx/xxxx/xxxx)", Toast.LENGTH_SHORT).show();
                    }

//                            else if (!chkCondition.isChecked()) {
//                                Toast.makeText(APlusPersonalInmofo.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                            }

//                            else {
//                                ResultStatusURL();
////                        customprogress.showProgressBar();
//                            }
                }
//                        else if (!chkCondition.isChecked()) {
//                            Toast.makeText(APlusPersonalInmofo.this, "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
//                        }
                else {
                    CKYURL();
                    customprogress.showProgressBar();
                }
            }
        });
//        Intent intent = new Intent(APlusPersonalInmofo.this, APlusMedicalDetails.class);
//        startActivity(intent);


    }

    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(APlusPersonalInmofo.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            streditdob = dateFormatter.format(newDate.getTime());
            String[] strdDate = streditdob.split("-");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strEditdobString = strdDate[2];
            editDobCkyc.setText(streditdob);
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
                Toast.makeText(APlusPersonalInmofo.this, "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                streditdob = "Select Dob";
                editDobCkyc.setText(streditdob);
            }
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                str_age = "18yrs-25yrs";
            } else if (selectYearAdult >= 26 && selectYearAdult <= 30) {
                str_age = "26yrs-30yrs";
            } else if (selectYearAdult >= 31 && selectYearAdult <= 35) {
                str_age = "31yrs-35yrs";
            } else if (selectYearAdult >= 36 && selectYearAdult <= 40) {
                str_age = "36yrs-40yrs";
            } else if (selectYearAdult >= 41 && selectYearAdult <= 45) {
                str_age = "41yrs-45yrs";
            } else if (selectYearAdult >= 46 && selectYearAdult <= 50) {
                str_age = "46yrs-50yrs";
            } else if (selectYearAdult >= 51 && selectYearAdult <= 55) {
                str_age = "51yrs-55yrs";
            } else if (selectYearAdult >= 56 && selectYearAdult <= 60) {
                str_age = "56yrs-60yrs";
            } else if (selectYearAdult >= 61 && selectYearAdult <= 65) {
                str_age = "61yrs-65yrs";
            } else if (selectYearAdult >= 66 && selectYearAdult <= 70) {
                str_age = "66yrs-70yrs";
            } else if (selectYearAdult >= 71 && selectYearAdult <= 75) {
                str_age = "71yrs-75yrs";
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void CKYURL() {
        uniqueTransactionNumber = "ONLINE/261122/" + strIDTypeName + strIDNumberEdit + strEditdobString;
        Log.d("sadgfd", uniqueTransactionNumber);


        JSONObject object = new JSONObject();
        try {
            object.put("source", "ONLINE");
            object.put("customerType", "I");
            object.put("uniqueTransactionNumber", uniqueTransactionNumber);
            object.put("idNo", strIDNumberEdit);
            object.put("idType", strIDType);
            object.put("dob", streditdob);
            Log.d("sadgfd", strIDNumberEdit+"  "+strIDType+"  "+streditdob);
            object.put("mobileNo", "");
            object.put("pincode", "");
            object.put("cKYCNo", "");
            object.put("extraField1", "");
            object.put("extraField2", "");
            object.put("extraField3", "");
            object.put("extraField4", "");
            object.put("extraField5", "");
        }
        catch (Exception e) {
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, UrlHealthConstants.CKYC_URL, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("onResponse", response.toString());
                customprogress.hideProgressBar();
                Toast.makeText(APlusPersonalInmofo.this, "CKYC done", Toast.LENGTH_SHORT).show();
                if (response.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult = response.getJSONObject("result");
                        uniqueTransactionNumber = response.optString("uniqueTransactionNumber");
                        String ckycNo = objectResult.getString("ckycNo");
                        String firstName = objectResult.getString("firstName");
                        EdtNameSelf.setText(firstName);
                        String middleName = objectResult.getString("middleName");
                        String lastName = objectResult.getString("lastName");
                        String dob = objectResult.getString("dob");
                        EditDobSelf.setText(dob);
                        String address1 = objectResult.getString("address1");
                        permanentAddressEdit.setText(address1);
                        String address2 = objectResult.getString("address2");
                        PermanentAddressEdit2.setText(address2);
                        String address3 = objectResult.getString("address3");
                        strCityEdit = objectResult.getString("city");
                        city_edit_personal.setText(strCityEdit);
                        String district = objectResult.getString("district");
                        strStateEdit = objectResult.getString("state");
                        state_edit_personal.setText(strStateEdit);
                        String country = objectResult.getString("country");
                        strPinCodeEdit = objectResult.getString("pincode");
                        pin_code_edit_personal.setText(strPinCodeEdit);

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
                        EmailIDEditSelf.setText(strEmailIDEditSelf);
                        String mobileNumber = objectResult.getString("mobileNumber");
                        PhoneNumberEdit.setText(mobileNumber);
                        String permAndCorresAddSame = objectResult.getString("permAndCorresAddSame");
                        //Format change dd-mm-yyy to dd/mm/yyyy
                        try {
                            Date date = dateFormatter.parse(streditdob);
                            Date date1 = dateFormatter.parse(dob);
                            dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                            strSelfAgeEditText = dateFormatter.format(date);
                            strDob = dateFormatter.format(date1);
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
//                        Intent intent = new Intent(APlusPersonalInmofo.this, PolicyTypeCHI.class);
//                        intent.putExtra("str_edt_name", str_edt_name);
////                        intent.putExtra("strEdtNameSelf",str_edt_name);
//                        intent.putExtra("strProposerEdtName", strProposerEdtName);
//                        intent.putExtra("str_edt_phone", str_edt_phone);
//                        intent.putExtra("str_email", str_email);
//                        intent.putExtra("streditdob", streditdob);
//                        intent.putExtra("strDob", strDob);
//                        intent.putExtra("str_age", str_age);
//                        intent.putExtra("str_reference_no", str_reference_no);
//                        intent.putExtra("strGenderSpinner", strGenderSpinner);
//                        intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
//                        intent.putExtra("selectYearAdult", selectYearAdult);
//                        intent.putExtra("strEmailIDEditSelf", strEmailIDEditSelf);
//                        intent.putExtra("strPinCodeEdit", strPinCodeEdit);
//                        intent.putExtra("strCityEdit", strCityEdit);
//                        intent.putExtra("strStateEdit", strStateEdit);
//                        intent.putExtra("address1", address1);
//                        intent.putExtra("address2", address2);
//                        intent.putExtra("address3", address3);
//                        intent.putExtra("corresAddress1", corresAddress1);
//                        intent.putExtra("corresAddress2", corresAddress2);
//                        intent.putExtra("corresAddress3", corresAddress3);
//                        intent.putExtra("str_edt_phone", mobileNumber);
//                        intent.putExtra("firstName", firstName);
//                        intent.putExtra("middleName", middleName);
//                        intent.putExtra("lastName", lastName);
//                        intent.putExtra("ckycNo", ckycNo);
//                        intent.putExtra("uniqueTransactionNumber", uniqueTransactionNumber);
//                        intent.putExtra("permAndCorresAddSame", permAndCorresAddSame);
//                        intent.putExtra("selectYearProposer", selectYearProposer);
//                        intent.putExtra("strIDTypeName", strIDTypeName);
//                        intent.putExtra("strFor", "0");
//                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        JSONObject error1 = response.getJSONObject("error");
                        String message = error1.getString("message");
                        if (message.equals("source is not configured in system so please connect with system administrator")) {
                            Toast.makeText(APlusPersonalInmofo.this, message, Toast.LENGTH_SHORT).show();
                        } else {
                            JSONObject object1 = response.getJSONObject("result");
                            manualKYCurl_intent = object1.getString("manualKYCurl");
                            Log.e("manualKYCurl1", manualKYCurl_intent);
                            EmailConsumeAPI();
                            SMSConsumeAPI();
                            final Dialog alert_dialog1 = new Dialog(APlusPersonalInmofo.this);
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
//                                    Intent intent=new Intent(APlusPersonalInmofo.this, CKYCWebPage.class);
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
                Toast.makeText(APlusPersonalInmofo.this, "" + error, Toast.LENGTH_SHORT).show();
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
        RequestQueue queue = Volley.newRequestQueue(APlusPersonalInmofo.this);
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    private void EmailConsumeAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("subject", "Kindly Complete Your KYC");
            object.put("toEmail", str_email);
            object.put("toName", str_edt_name);
            object.put("contentValue", "<p style='font-family:calibri;color:black;'>Hi " + str_edt_name + ",</p> <p style='font-family:calibri;color:black;'> Thank you for choosing Universal Sompo General Insurance as your Insurance Partner.  Please complete your KYC by clicking " + manualKYCurl_intent + " . <p style='font-family:calibri;color:black;'>We promise to be there for you 24x7, whenever you need us. In case you have any queries, feel free to reach us at 1800 200 4030 or mail at contactus@universalsompo.com .</p> <p style='font-family:calibri;color:black;'>Don’t forget to download PULZ App on which you can manage your policy easily and explore a host of value-added services.</p> <p style='font-family:calibri;color:black;'>Explore the app: Download LINK: https://play.google.com/store/apps/details?id=com.universalsompo.meta </p>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(APlusPersonalInmofo.this, object, UrlHealthConstants.EmailConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("status").equals("true")) {
                    String message = object.optString("message");
                    Toast.makeText(APlusPersonalInmofo.this, "" + message, Toast.LENGTH_SHORT).show();
                } else {
                    String message = object.optString("message");
                    Toast.makeText(APlusPersonalInmofo.this, "" + message, Toast.LENGTH_SHORT).show();
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
            object.put("SMS", "Dear " + str_edt_name + " ,Greetings from Universal Sompo General Insurance!  Click here https://www.usgi.co.in/p?q=ed3ASVwPRK to complete your KYC. Please ignore if you have completed the KYC.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(APlusPersonalInmofo.this, object, UrlHealthConstants.SMSConsumeAPI, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    String message = object.optString("Message");
                    Toast.makeText(APlusPersonalInmofo.this, "" + message, Toast.LENGTH_SHORT).show();
                } else {
                    String message = object.optString("Message");
                    Toast.makeText(APlusPersonalInmofo.this, "" + message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RevisedCHISMS);
        req.execute();
    }


}