package com.universalsompo.meta.metaapp.health.fragment.buypolicy.aplusbuyjourney;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.gson.Gson;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.City;
import com.universalsompo.meta.metaapp.health.State;
import com.universalsompo.meta.metaapp.health.activities.Health_Insurance_Renewal;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.CalculatorPlanType;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class BuyAPlusHealthCarePolicy extends Fragment {
    MySharedPreference mySharedPreference;
    CustomProgressDialog customProgress;
    Date date,CurrentDate,SelectDate;
    int selectYearAdult,SelectMonthDOB,SelectDaysDOB;
    String[] gender,IDType;
    Button btn_next;
    Handler handler = new Handler();
    Spinner GenderSpinner,IDTypeSpinner;
    String strGenderEditSpinner,strAge,strGenderSpinner,strEdtName,strEdtPhone,strEdtEmail,strEditDob,strEditDobString,strReferenceNo,strIDTypeName,strIDType,strIDNumberEdit,uniqueTransactionNumber,manualKYCurlIntent;
    EditText EdtName,EdtPhone,EdtEmail,IDNumberEdit,EditDob,referenceNo,edt_gender,edt_pincode,edt_state,edt_city;
    CheckBox chkCondition;
    String strPincode,str_state_spinner,str_city_spinner,strCity,strState;
    ArrayList<State> listState = new ArrayList<>();
    ArrayList<City> listCity = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> state = new ArrayList<>();
    ArrayList pincodelist = new ArrayList<Integer>();
    String PanExpression="[A-Z]{5}[0-9]{4}[A-Z]{1}";
    String VoterIDExpression="^[A-Z]{3}[0-9]{7}$";
    String AadharExpression="^[2-9][0-9]{11}$";
    String PassportExpression="^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$";
    String DrivingExpression="^([A-Z]{2})(\\d{2}|\\d{3})[a-zA-Z]{0,1}(\\d{4})(\\d{7})$";
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    ImageView calendarIconSelf;
    LinearLayout term_condition,linear_gender,linear_state,linear_city;
    long last_text_edit = 0;
    long delay = 1000; // 1 seconds after user stops typing
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_buy_a_plus_health_care_policy, container, false);
        mySharedPreference= MySharedPreference.getInstance(getActivity());
        customProgress = new CustomProgressDialog(getContext());
        btn_next=view.findViewById(R.id.btn_next);
        GenderSpinner=view.findViewById(R.id.GenderSpinner);
      //  IDTypeSpinner=view.findViewById(R.id.IDTypeSpinner);
       // IDNumberEdit=view.findViewById(R.id.IDNumberEdit);
        chkCondition = view.findViewById(R.id.checkbox);
       // EditDob=view.findViewById(R.id.EditDob);
       // calendarIconSelf=view.findViewById(R.id.calendarIconSelf);
        term_condition = view.findViewById(R.id.term_condition);
        referenceNo=view.findViewById(R.id.reference_no);

      //Linear Layout
        linear_state=view.findViewById(R.id.linear_state);
        linear_gender=view.findViewById(R.id.linear_gender);
        linear_city=view.findViewById(R.id.linear_city);

        //Edit Text
        EdtName=view.findViewById(R.id.edtName);
        EdtPhone=view.findViewById(R.id.EdtPhone);
        EdtEmail=view.findViewById(R.id.EdtEmail);
        edt_gender=view.findViewById(R.id.edt_gender);
        edt_pincode=view.findViewById(R.id.edt_pincode);
        edt_state=view.findViewById(R.id.edt_state);
        edt_city=view.findViewById(R.id.edt_city);


//        IDType=getResources().getStringArray(R.array.ChiID);
//        final ArrayAdapter<String> adapterID=new ArrayAdapter<String>(getContext(), R.layout.spinner_item_text,IDType);
//        IDTypeSpinner.setAdapter(adapterID);

        strEdtName=mySharedPreference.getUserName();
        strEdtPhone=mySharedPreference.getMOBILE();
        strEdtEmail=mySharedPreference.getEmailId();
        strEditDob=mySharedPreference.getDOB();
        EdtName.setText(strEdtName);
        EdtPhone.setText(strEdtPhone);
        EdtEmail.setText(strEdtEmail);
       // EditDob.setText(strEditDob);
        strGenderEditSpinner = "Select Gender";


        linear_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(getContext());
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGenderEditSpinner=items1.get(options1);
                        edt_gender.setText(strGenderEditSpinner);
                    }
                });
                singlePicker.show();
            }
        });

        try {
            JSONObject jsonObject = new JSONObject(loadJson());
            JSONArray jsonArray = jsonObject.getJSONArray("pinCodeList");
            strPincode = edt_pincode.getText().toString();
            for(int i=0;i<jsonArray.length()-1;i++){
              // zone11.add(jsonArray.get(i));
               pincodelist.add(jsonArray.get(i));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(loadJson_zone2());
            JSONArray jsonArray = jsonObject.getJSONArray("pinCodeList");
            for(int i=0;i<jsonArray.length()-1;i++){
               // zone22.add(jsonArray.get(i));
              pincodelist.add(jsonArray.get(i));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(loadJson_withDetails());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("PinCodeDetails");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                State details = new State();
                //  details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                details.setZone(jsonObj.getString("Zone"));
                listState.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Zone2 City First

        try {
            JSONObject jsonObject = new JSONObject(loadJson_zone2_cityFirst());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("StateCityList_Zone2_First");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                City details = new City();
                //  details.setCity(jsonObj.getString("City"));
                details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                listCity.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Zone2 PinCOde Second

        try {
            JSONObject jsonObject = new JSONObject(loadJson_withDetails_Zone2());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("PinCodeDetails");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                State details = new State();
                //  details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                details.setZone(jsonObj.getString("Zone"));
                listState.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Zone2 City Second
        try {
            JSONObject jsonObject = new JSONObject(loadJson_Zone2_CitySecond());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("StateCityList_Zone2_Second");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                City details = new City();
                //  details.setCity(jsonObj.getString("City"));
                details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                listCity.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Zone3 PinCode Third

        try {
            JSONObject jsonObject = new JSONObject(loadJson_withDetails_Zone2_Second());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("PinCodeDetails");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                State details = new State();
                // details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                details.setZone(jsonObj.getString("Zone"));
                listState.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Zone2 City Third
        try {
            JSONObject jsonObject = new JSONObject(loadJson_zone2_Third());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("StateCityList_Zone2_Third");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                City details = new City();
                // details.setCity(jsonObj.getString("City"));
                details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                listCity.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Zone2 PinCode Fourth

        try {
            JSONObject jsonObject = new JSONObject(loadJson_withDetails_Zone2_Third());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("PinCodeDetails");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                State details = new State();
                //  details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                details.setZone(jsonObj.getString("Zone"));
                listState.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Zone2 City Fourth

        try {
            JSONObject jsonObject = new JSONObject(loadJson_Zone2_CityFourth());

            JSONArray jsonArray = jsonObject.getJSONArray("StateCityList_Zone2_Fourth");
            for(int i=0;i<jsonArray.length()-1;i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                City details = new City();
                //  details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setCity(jsonObj.getString("City"));
                details.setPinCode(jsonObj.getString("PinCode"));
                listCity.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Zone 1

        try {
            JSONObject jsonObject = new JSONObject(loadJson_CityDemo());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("Zone1_StateCityList");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                City details = new City();
                details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                //   details.setZone(jsonObj.getString("Zone"));
                listCity.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        } try {
            JSONObject jsonObject = new JSONObject(loadJson_StateDemo());
            Log.d("asdfgh", "onCreate: "+new Gson().toJson(jsonObject));

            JSONArray jsonArray = jsonObject.getJSONArray("PinCodeDetails");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                State details = new State();
                //  details.setCity(jsonObj.getString("City"));
                details.setState(jsonObj.getString("State"));
                details.setPinCode(jsonObj.getString("PinCode"));
                details.setZone(jsonObj.getString("Zone"));
                listState.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        edt_pincode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 6) {
                    last_text_edit = System.currentTimeMillis();
                    handler.postDelayed(input_finish_checker, delay);
                    DownKeyboardSix_Digits();
                }

            }
        });

        linear_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker =  new MyOptionsPickerView(getContext());


                HashSet<String> hashSet = new HashSet<String>();
                hashSet.addAll(state);
                state.clear();
                state.addAll(hashSet);

                edt_city.setText("");


                singlePicker.setPicker(state);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_state_spinner=state.get(options1);
                        city.clear();
                        edt_state.setText(str_state_spinner);
                        for (int i = 0; i<listCity.size();i++){
                            if (str_state_spinner.equals(listCity.get(i).getState())&&edt_pincode.getText().toString().equals(listCity.get(i).getPinCode())){

                                city.add(listCity.get(i).getCity());


                            }
                        }


                    }
                });

                singlePicker.show();

            }
        });

        linear_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker =  new MyOptionsPickerView(getContext());


                HashSet<String> hashSet = new HashSet<String>();
                hashSet.addAll(city);
                city.clear();
                city.addAll(hashSet);



                singlePicker.setPicker(city);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_city_spinner=city.get(options1);
                        edt_city.setText(str_city_spinner);

                    }
                });

                singlePicker.show();
            }
        });




//        GenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                strGenderSpinner = String.valueOf(gender[i]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });

//        IDTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                strIDTypeName= String.valueOf(IDType[i]);
//                if (strIDTypeName.equals("PAN Card")){
//                    strIDType="PAN";
//                    strIDNumberEdit="";
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }else if (strIDTypeName.equals("Voter ID")){
//                    strIDType="VOTER_ID";
//                    strIDNumberEdit="";
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }else if (strIDTypeName.equals("Passport")){
//                    strIDType="PASSPORT";
//                    strIDNumberEdit="";
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }else if (strIDTypeName.equals("Driving Licence")){
//                    strIDType="DRIVING_LICENCE";
//                    strIDNumberEdit="";
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }else if (strIDTypeName.equals("Existing CKYC Number")){
//                    strIDType="CKYC_NO";
//                    strIDNumberEdit="";
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }else if (strIDTypeName.equals("Reference Number")){
//                    strIDType="CKYC_NO";
//                    strIDNumberEdit="";
//                    IDNumberEdit.setText(strIDNumberEdit);
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });

//        calendarIconSelf.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showCalender();
//            }
//        });
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
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strEdtName=EdtName.getText().toString();
                strEdtPhone=EdtPhone.getText().toString();
                strEdtEmail=EdtEmail.getText().toString();
                strReferenceNo=referenceNo.getText().toString();
                strPincode=edt_pincode.getText().toString();
                strState=edt_state.getText().toString();
                strCity=edt_city.getText().toString();
                boolean pinlist = pincodelist.contains(edt_pincode.getText().toString());
               // strIDNumberEdit= IDNumberEdit.getText().toString();
                if (strGenderEditSpinner.equals("Select Gender")){
                    Toast.makeText(getContext(), "Select Gender", Toast.LENGTH_SHORT).show();
                }else if (strEditDob.equals("Select Dob")){
                    Toast.makeText(getContext(), "Enter DOB", Toast.LENGTH_SHORT).show();
                }else if (strEdtEmail.equals("")){
                    Toast.makeText(getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(strEdtEmail).matches()) {
                    Toast.makeText(getContext(), "Email address is not valid.", Toast.LENGTH_SHORT).show();
                }else if (strPincode.equals("")){
                    Toast.makeText(getContext(), "Please Enter PinCode", Toast.LENGTH_SHORT).show();
                }else if (edt_pincode.getText().toString().length()<6){
                    Toast.makeText(getContext(), "Please Enter minimum six digit pincode", Toast.LENGTH_SHORT).show();
                }else if(!pinlist){
                    Toast.makeText(getContext(), "PinCode Does not match", Toast.LENGTH_SHORT).show();
                }else if (edt_state.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Please Select State", Toast.LENGTH_SHORT).show();
                }else if (edt_city.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Please Select City", Toast.LENGTH_SHORT).show();
                }else {
                    NextMethod();
                }
                /*else if (selectYearAdult < 18 || selectYearAdult > 75) {
                    Toast.makeText(getContext(), "Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                }else if (strIDTypeName.equals("Select ID Type")){
                    Toast.makeText(getContext(), "Select ID Type", Toast.LENGTH_SHORT).show();
                }*/
                /*else if (strIDNumberEdit.equals("")){
                    Toast.makeText(getContext(), "Enter ID Number", Toast.LENGTH_SHORT).show();
                }else if (strIDTypeName.equals("PAN Card")){
                    if (!strIDNumberEdit.matches(PanExpression)){
                        Toast.makeText(getContext(), "Enter Valid PAN Card Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customProgress.showProgressBar();
                    }
                }else if (strIDTypeName.equals("Voter ID")){
                    if (!strIDNumberEdit.matches(VoterIDExpression)){
                        Toast.makeText(getContext(), "Enter Valid Voter ID Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customProgress.showProgressBar();
                    }
                }else if (strIDTypeName.equals("Passport")){
                    if (!strIDNumberEdit.matches(PassportExpression)){
                        Toast.makeText(getContext(), "Enter Valid Passport Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customProgress.showProgressBar();
                    }
                }else if (strIDTypeName.equals("Driving Licence")){
                    if (!strIDNumberEdit.matches(DrivingExpression)){
                        Toast.makeText(getContext(), "Enter Valid Driving Licence Number", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else{
                        CKYURL();
                        customProgress.showProgressBar();
                    }
                }else if (strIDTypeName.equals("Reference Number")){
                    if (!strIDNumberEdit.contains("/")){
                        Toast.makeText(getContext(), "Reference Number should be (xxxx/xxxx/xxxx)", Toast.LENGTH_SHORT).show();
                    }else if (!chkCondition.isChecked()) {
                        Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                    }else {
                        ResultStatusURL();
                    }
                }
                else if (!chkCondition.isChecked()) {
                    Toast.makeText(getContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else {
                    CKYURL();
                    customProgress.showProgressBar();
                }*/
            }
        });
            return view;
    }

    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(getContext(), R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strEditDob=dateFormatter.format(newDate.getTime());
            String[] strdDate=strEditDob.split("-");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            strEditDobString = strdDate[2];
          //  EditDob.setText(strEditDob);
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today1 = formatter.format(date);
            try {
                SelectDate = dateFormatter.parse(strEditDob);
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
                strEditDob="Select Dob";
              //  EditDob.setText(strEditDob);
            }
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                strAge="18yrs-25yrs";
            }else if (selectYearAdult >= 26 && selectYearAdult <= 30) {
                strAge="26yrs-30yrs";
            }else if (selectYearAdult >= 31 && selectYearAdult <= 35) {
                strAge="31yrs-35yrs";
            }else if (selectYearAdult >= 36 && selectYearAdult <= 40) {
                strAge="36yrs-40yrs";
            }else if (selectYearAdult >= 41 && selectYearAdult <= 45) {
                strAge="41yrs-45yrs";
            }else if (selectYearAdult >= 46 && selectYearAdult <= 50) {
                strAge="46yrs-50yrs";
            }else if (selectYearAdult >= 51 && selectYearAdult <= 55) {
                strAge="51yrs-55yrs";
            }else if (selectYearAdult >= 56 && selectYearAdult <= 60) {
                strAge="56yrs-60yrs";
            }else if (selectYearAdult >= 61 && selectYearAdult <= 65) {
                strAge="61yrs-65yrs";
            }else if (selectYearAdult >= 66 && selectYearAdult <= 70) {
                strAge="66yrs-70yrs";
            } else if (selectYearAdult >= 71 && selectYearAdult <= 75){
                strAge="71yrs-75yrs";
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
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
                        String kycVerifiedStatus = objectResult.getString("kycVerifiedStatus");

                        if (kycVerifiedStatus.equals("True")){
                            Dialog KYCDialog = new Dialog(getContext());
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
                                    NextMethod();
                                    KYCDialog.dismiss();
                                }
                            });
                        }else{
                            Toast.makeText(getContext(), "You KYC Verification not completed yet Please wait...", Toast.LENGTH_SHORT).show();
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
        uniqueTransactionNumber="ONLINE/261122/"+strIDTypeName+strIDNumberEdit+strEditDobString;
        JSONObject object = new JSONObject();
        try {
            object.put("source", "ONLINE");
            object.put("customerType","I");
            object.put("uniqueTransactionNumber",uniqueTransactionNumber);
            object.put("idNo",strIDNumberEdit);
            object.put("idType",strIDType);
            object.put("dob",strEditDob);
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
                customProgress.hideProgressBar();
                if (response.optString("status").equals("success")) {
                    try {
                        JSONObject objectResult=response.getJSONObject("result");
                        uniqueTransactionNumber =response.optString("uniqueTransactionNumber");
                        String ckycNo = objectResult.getString("ckycNo");

                        Dialog KYCDialog = new Dialog(getContext());
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
                                NextMethod();
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
                            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                        }else{
                            JSONObject object1=response.getJSONObject("result");
                            manualKYCurlIntent = object1.getString("manualKYCurl");
                            Log.e("manualKYCurlIntent",manualKYCurlIntent);
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
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(manualKYCurlIntent));
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
                customProgress.hideProgressBar();
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
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    private void EmailConsumeAPI() {
        JSONObject object = new JSONObject();
        try {
            object.put("subject", "Kindly Complete Your KYC");
            object.put("toEmail",strEdtEmail);
            object.put("toName",strEdtName);
            object.put("contentValue","<p style='font-family:calibri;color:black;'>Hi "+ strEdtName +",</p> <p style='font-family:calibri;color:black;'> Thank you for choosing Universal Sompo General Insurance as your Insurance Partner.  Please complete your KYC by clicking " +manualKYCurlIntent+" . <p style='font-family:calibri;color:black;'>We promise to be there for you 24x7, whenever you need us. In case you have any queries, feel free to reach us at 1800 200 4030 or mail at contactus@universalsompo.com .</p> <p style='font-family:calibri;color:black;'>Don’t forget to download PULZ App on which you can manage your policy easily and explore a host of value-added services.</p> <p style='font-family:calibri;color:black;'>Explore the app: Download LINK: https://play.google.com/store/apps/details?id=com.universalsompo.meta </p>");
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
            object.put("MobileNo", strEdtPhone);
            object.put("SMS","Dear "+strEdtName+ " ,Greetings from Universal Sompo General Insurance!  Click here " + manualKYCurlIntent+ " to complete your KYC. Please ignore if you have completed the KYC.");
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
    private void NextMethod() {
        Intent intent=new Intent(getContext(),APlusPlanType.class);
        intent.putExtra("strFor","0");
        intent.putExtra("strEdtName",strEdtName);
        intent.putExtra("strEdtPhone",strEdtPhone);
        intent.putExtra("strEdtEmail",strEdtEmail);
        intent.putExtra("strGenderSpinner",strGenderEditSpinner);
        intent.putExtra("strPincode",strPincode);
        intent.putExtra("strState",strState);
        intent.putExtra("strCity",strCity);
        startActivity(intent);
    }

    private Runnable input_finish_checker = new Runnable() {
        public void run() {
            if (System.currentTimeMillis() > (last_text_edit + delay - 500)) {
                String data = edt_pincode.getText().toString();
                city.clear();
                state.clear();
                edt_city.getText().clear();
                edt_state.getText().clear();

                Log.d("asdfg", "run: "+listState.size());
                for (int i = 0; i<listState.size();i++){
                    if ( data.equals(listState.get(i).getPinCode())){

                        state.add(listState.get(i).getState());

                    }

                }
            }
        }
    };

    private String loadJson(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_zone1.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    //Zone2 PinCode First

    private String loadJson_withDetails(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_statecity_zone2.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    // zone2 City First
    private String loadJson_zone2_cityFirst(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("statecity_zone2_First.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }


    private String loadJson_withDetails_Zone2(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_statecity_zone2_Second.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private String loadJson_Zone2_CitySecond(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("zone2_StateCity_Second.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    //Zone2 PinCode Third

    private String loadJson_withDetails_Zone2_Second(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_statecity_zone2_Third.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    //zone2 City Third

    private String loadJson_zone2_Third(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("zone2_StateCity_Third.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    //Zone2 PinCode Fourth

    private String loadJson_withDetails_Zone2_Third(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_statecity_zone2_Fourth.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    //Zone2 City Fourth

    private String loadJson_Zone2_CityFourth(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("zone2_StateCity_Fourth.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }


    private String loadJson_zone2(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_zone2.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private String loadJson_StateDemo(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_statecity_zone1.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private String loadJson_CityDemo(){
        String json = null;
        try {

            InputStream in = getActivity().getAssets().open("pincode_zone1_StateCity.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private void DownKeyboardSix_Digits(){
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }

}