package com.universalsompo.meta.metaapp.motor.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.VolleyError;
import com.suke.widget.SwitchButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.activities.TutorialActivity;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    private Context mContext;
    private EditText edit_phone;
    private EditText edit_email;
    private EditText policy_no;
    private EditText id;
    private EditText sign_up_dob;
    private Button btn_signUp;
    private Button btn_signUp1;
    private Button btn_resend_otp;
    private Button btn_resend_otp1;
    String intentPhone,intentEmail;
    private TextView otp_timer, otp_timer1;
    private MySharedPreference mySharedPreference;
    private EditText txt_otp, txt_otp1;
    TelephonyManager tm;
    long timerDuration = 60000;
    private String deviceName;
    private static String deviceId;
    String phone_no, email, policyno, memberId, date_of_birth;
    private SwitchButton switch_insurance;
    private int curYear;
    private int curMonth;
    private int curDay;
    String policy_type;
    private LinearLayout motor_otp, health_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        getWindow().setBackgroundDrawableResource(R.drawable.splash_back_1);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        intentPhone = bundle.getString("phone");
        intentEmail = bundle.getString("email");
        mContext = this;
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        mySharedPreference = MySharedPreference.getInstance(mContext);
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        deviceName = getDeviceName();
        deviceId = getDeviceId();
        initView();
    }

    private String getDeviceId() {
        return Settings.Secure.getString(SignUpActivity.this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    private static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a=new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(a);
        finish();
    }

    void initView() {
        switch_insurance = findViewById(R.id.switch_insurance);
        motor_otp = findViewById(R.id.motor_otp);
        health_otp = findViewById(R.id.health_otp);
        edit_phone = findViewById(R.id.sign_up_phone);
        edit_email = findViewById(R.id.sign_up_email);
        policy_no = findViewById(R.id.sign_up_policyNo);
        id = findViewById(R.id.sign_up_id);
        sign_up_dob = findViewById(R.id.sign_up_dob);

        otp_timer = findViewById(R.id.otp_timer);
        otp_timer1 = findViewById(R.id.otp_timer1);
        txt_otp = findViewById(R.id.txt_otp);
        txt_otp1 = findViewById(R.id.txt_otp1);
        btn_signUp = findViewById(R.id.btn_sign_up);
        btn_signUp1 = findViewById(R.id.btn_sign_up1);
        Button btn_verify = findViewById(R.id.btn_verify);
        Button btn_verify1 = findViewById(R.id.btn_verify1);
        btn_resend_otp = findViewById(R.id.btn_resend_otp);
        btn_resend_otp1 = findViewById(R.id.btn_resend_otp1);

        edit_phone.setText(intentPhone);
        edit_email.setText(intentEmail);

        switch_insurance.setOnCheckedChangeListener((view, isChecked) -> {
            if (switch_insurance.isChecked()) {
                id.setVisibility(View.GONE);
                sign_up_dob.setVisibility(View.VISIBLE);
                btn_signUp.setVisibility(View.GONE);
                btn_signUp1.setVisibility(View.VISIBLE);
                motor_otp.setVisibility(View.GONE);
                health_otp.setVisibility(View.GONE);
                btn_signUp1.setEnabled(true);

                btn_signUp1.setOnClickListener(v -> {
                    phone_no = edit_phone.getText().toString().trim();
                    email = edit_email.getText().toString().trim();
                    policyno = policy_no.getText().toString().trim();
                    date_of_birth = sign_up_dob.getText().toString().trim();
                    if (phone_no.isEmpty()) {
                        edit_phone.setFocusableInTouchMode(true);
                        edit_phone.setCursorVisible(true);
                        edit_phone.requestFocus();
                        Toast.makeText(mContext, "Phone no is mandatory", Toast.LENGTH_SHORT).show();
                    } else if (phone_no.length() < 10) {
                        edit_phone.setFocusableInTouchMode(true);
                        edit_phone.setCursorVisible(true);
                        edit_phone.requestFocus();
                        Toast.makeText(mContext, "Phone no must be 10 digits long", Toast.LENGTH_SHORT).show();
                    } else if (email.isEmpty()) {
                        edit_email.setFocusableInTouchMode(true);
                        edit_email.setCursorVisible(true);
                        edit_email.requestFocus();
                        Toast.makeText(mContext, "Email is mandatory", Toast.LENGTH_SHORT).show();
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        edit_email.setFocusableInTouchMode(true);
                        edit_email.setCursorVisible(true);
                        edit_email.requestFocus();
                        Toast.makeText(mContext, "Email address is not valid", Toast.LENGTH_SHORT).show();
                    } else if (policyno.isEmpty()) {
                        policy_no.setFocusableInTouchMode(true);
                        policy_no.setCursorVisible(true);
                        policy_no.requestFocus();
                        Toast.makeText(mContext, "Policy number is mandatory", Toast.LENGTH_SHORT).show();
                    } else if (sign_up_dob.getText().toString().trim().length() <= 0) {
                        sign_up_dob.requestFocus();
                        Toast.makeText(mContext, "Please select date of birth", Toast.LENGTH_SHORT).show();
                    } else {
                        hitRegistrationWebservice(policyno, sign_up_dob.getText().toString(), "2");
                    }
                });
            } else {
                id.setVisibility(View.VISIBLE);
                sign_up_dob.setVisibility(View.GONE);
                btn_signUp.setVisibility(View.VISIBLE);
                btn_signUp1.setVisibility(View.GONE);
                motor_otp.setVisibility(View.GONE);
                health_otp.setVisibility(View.GONE);
                btn_signUp.setEnabled(true);

                btn_signUp.setOnClickListener(v -> {
                    phone_no = edit_phone.getText().toString().trim();
                    email = edit_email.getText().toString().trim();
                    policyno = policy_no.getText().toString().trim();
                    memberId = id.getText().toString().trim();
                    if (phone_no.isEmpty()) {
                        edit_phone.setFocusableInTouchMode(true);
                        edit_phone.setCursorVisible(true);
                        edit_phone.requestFocus();
                        Toast.makeText(mContext, "Phone no is mandatory", Toast.LENGTH_SHORT).show();
                    } else if (phone_no.length() < 10) {
                        edit_phone.setFocusableInTouchMode(true);
                        edit_phone.setCursorVisible(true);
                        edit_phone.requestFocus();
                        Toast.makeText(mContext, "Phone no must be 10 digits long", Toast.LENGTH_SHORT).show();
                    } else if (email.isEmpty()) {
                        edit_email.setFocusableInTouchMode(true);
                        edit_email.setCursorVisible(true);
                        edit_email.requestFocus();
                        Toast.makeText(mContext, "Email is mandatory", Toast.LENGTH_SHORT).show();
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        edit_email.setFocusableInTouchMode(true);
                        edit_email.setCursorVisible(true);
                        edit_email.requestFocus();
                        Toast.makeText(mContext, "Email address is not valid", Toast.LENGTH_SHORT).show();
                    } else if (policyno.isEmpty()) {
                        policy_no.setFocusableInTouchMode(true);
                        policy_no.setCursorVisible(true);
                        policy_no.requestFocus();
                        Toast.makeText(mContext, "Policy number is mandatory", Toast.LENGTH_SHORT).show();
                    } else if (memberId.isEmpty()) {
                        id.setFocusableInTouchMode(true);
                        id.setCursorVisible(true);
                        id.requestFocus();
                        Toast.makeText(mContext, "Engine number or chasis number is mandatory", Toast.LENGTH_SHORT).show();
                    } else {
                        hitRegistrationWebservice(policyno, memberId, "1");
                    }
                });
            }
        });

        btn_signUp.setOnClickListener(v -> {

            phone_no = edit_phone.getText().toString().trim();
            email = edit_email.getText().toString().trim();
            policyno = policy_no.getText().toString().trim();
            memberId = id.getText().toString().trim();

            if (phone_no.isEmpty()) {
                edit_phone.setFocusableInTouchMode(true);
                edit_phone.setCursorVisible(true);
                edit_phone.requestFocus();
                Toast.makeText(mContext, "Phone no is mandatory", Toast.LENGTH_SHORT).show();
            } else if (phone_no.length() < 10) {
                edit_phone.setFocusableInTouchMode(true);
                edit_phone.setCursorVisible(true);
                edit_phone.requestFocus();
                Toast.makeText(mContext, "Phone no must be 10 digits long", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                edit_email.setFocusableInTouchMode(true);
                edit_email.setCursorVisible(true);
                edit_email.requestFocus();
                Toast.makeText(mContext, "Email is mandatory", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edit_email.setFocusableInTouchMode(true);
                edit_email.setCursorVisible(true);
                edit_email.requestFocus();
                Toast.makeText(mContext, "Email address is not valid", Toast.LENGTH_SHORT).show();
            } else if (policyno.isEmpty()) {
                policy_no.setFocusableInTouchMode(true);
                policy_no.setCursorVisible(true);
                policy_no.requestFocus();
                Toast.makeText(mContext, "Policy number is mandatory", Toast.LENGTH_SHORT).show();
            } else if (memberId.isEmpty()) {
                id.setFocusableInTouchMode(true);
                id.setCursorVisible(true);
                id.requestFocus();
                Toast.makeText(mContext, "Engine number or chasis number is mandatory", Toast.LENGTH_SHORT).show();
            } else {
                hitRegistrationWebservice(policyno, memberId, "1");
            }
        });

        edit_phone.setSelection(edit_phone.getText().length());

        edit_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LogUtils.showLog("@@@S LENGTH", "" + s.toString().length());
                if (s.toString().length() < 10) {
                    if(switch_insurance.isChecked()){
                        health_otp.setVisibility(View.GONE);
                        btn_signUp1.setEnabled(true);
                    } else {
                        motor_otp.setVisibility(View.GONE);
                        btn_signUp.setEnabled(true);
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // TODO Auto-generated method stub
            }
        });

        edit_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(switch_insurance.isChecked()){
                    health_otp.setVisibility(View.GONE);
                    btn_signUp1.setEnabled(true);
                }else {
                    motor_otp.setVisibility(View.GONE);
                    btn_signUp.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        policy_no.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(switch_insurance.isChecked()){
                    health_otp.setVisibility(View.GONE);
                    btn_signUp1.setEnabled(true);
                }else {
                    motor_otp.setVisibility(View.GONE);
                    btn_signUp.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(switch_insurance.isChecked()){
                    health_otp.setVisibility(View.GONE);
                    btn_signUp1.setEnabled(true);
                }else {
                    motor_otp.setVisibility(View.GONE);
                    btn_signUp.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        sign_up_dob.setOnClickListener(v -> {
            if(switch_insurance.isChecked()){
                health_otp.setVisibility(View.GONE);
                btn_signUp1.setEnabled(true);
                datePickerTillToday(sign_up_dob);
            }else {
                motor_otp.setVisibility(View.GONE);
                btn_signUp.setEnabled(true);
            }
        });

        btn_verify.setOnClickListener(v -> {
            if (txt_otp.getText().toString().trim().length() > 0) {
                hitVerifyOTPService("motor");
            } else {
                Toast.makeText(SignUpActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
            }
        });

        btn_verify1.setOnClickListener(v -> {
            if (txt_otp1.getText().toString().trim().length() > 0) {
                hitVerifyOTPService("health");
            } else {
                Toast.makeText(SignUpActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
            }
        });

        btn_resend_otp.setOnClickListener(v -> hitResendOTPService("motor"));

        btn_resend_otp1.setOnClickListener(v -> hitResendOTPService("health"));
    }

    void datePickerTillToday(final TextView tv) {
        initDate();
        @SuppressLint("SetTextI18n") DatePickerDialog expdatePickerDialog = new DatePickerDialog(this,R.style.DialogTheme, (view, year, month, dayOfMonth) -> tv.setText(initday(dayOfMonth) + "/" + initday(month + 1) + "/" + year), curYear, curMonth, curDay);
        expdatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        expdatePickerDialog.show();
    }

    String initday(int a) {
        String ab;
        if (a == 1) {
            ab = "01";
        } else if (a == 2) {
            ab = "02";
        } else if (a == 3) {
            ab = "03";
        } else if (a == 4) {
            ab = "04";
        } else if (a == 5) {
            ab = "05";
        } else if (a == 6) {
            ab = "06";
        } else if (a == 7) {
            ab = "07";
        } else if (a == 8) {
            ab = "08";
        } else if (a == 9) {
            ab = "09";
        } else {
            ab = String.valueOf(a);
        }
        return ab;
    }

    void initDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        curYear = c.get(Calendar.YEAR);
        curMonth = c.get(Calendar.MONTH);
        curDay = c.get(Calendar.DAY_OF_MONTH);
    }

    void hitRegistrationWebservice(final String policyno, final String memberId, final String policy_type) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", mySharedPreference.getToken_no());
            object.put("PolicyNo", policyno);
            object.put("Value", memberId);
            object.put("MobileNo", edit_phone.getText().toString().trim());
            object.put("EmailID", edit_email.getText().toString().trim());
            object.put("PolicyType", policy_type);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(mContext, object, UrlConstants.URL_REGISTRATION, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                Log.d("Response", String.valueOf(object));
                if (Tag == RequestConstants.URL_REGISTRATION) {
                    if (object.optString("Message").equals("Successfully get details from USGI DB and store in Meta DB.") || object.optString("Message").equalsIgnoreCase("Users already exists.")) {
                        if (switch_insurance.isChecked()){
                            health_otp.setVisibility(View.VISIBLE);
                            motor_otp.setVisibility(View.GONE);
                            startCountDown1();
                        }else {
                            motor_otp.setVisibility(View.VISIBLE);
                            health_otp.setVisibility(View.GONE);
                            startCountDown();
                        }
                        mySharedPreference.addUID(object.optString("UID"));
                        mySharedPreference.setClientUserID(object.optString("ClientUserID"));
                    } else if (object.optString("Message").equalsIgnoreCase("Already policy linked in some other account")) {
                        showOnErrorDialog4("Policy already linked in some other account.");
                    } else {
                        showOnErrorDialog4("No policy from USGI found. This app is for USGI customers only. Thank you!");
                    }
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_REGISTRATION);
        req.execute();
    }

    void hitVerifyOTPService(String s) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", mySharedPreference.getToken_no());
            object.put("userId", mySharedPreference.getUID());
            if (s.equalsIgnoreCase("motor")) {
                object.put("OTP", txt_otp.getText().toString());
            } else {
                object.put("OTP", txt_otp1.getText().toString());
            }
            object.put("MobileNo", edit_phone.getText().toString().trim());
            object.put("EmailID", edit_email.getText().toString().trim());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(mContext, object, UrlConstants.OTP_AUTHENTICATE_SIGN_UP, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (Tag == RequestConstants.URL_VERIFY_OTP) {
                    if (object.optString("Message").equals("Success")) {
                        mySharedPreference.addIsLoggedIn(true);
                        mySharedPreference.setUserName(object.optString("Name"));
                        mySharedPreference.setMobile(object.optString("Mobile"));
                        mySharedPreference.setProfilePic(object.optString("UserImagePath"));
                        mySharedPreference.setEmailId(object.optString("Email"));
                        mySharedPreference.setCorporateId(object.optString("CorporateID"));
                        mySharedPreference.setAge(object.optString("Age"));
                        mySharedPreference.setgender(object.optString("Gender"));
                        mySharedPreference.setIsPolicyStatus(object.optString("IsPolicyStatus"));
                        mySharedPreference.setisUSGIUser(object.optString("Usgi_User"));
                        mySharedPreference.setCustID(object.optString("CustomerID"));
                        String dobb = parseDateToddMMyyyy(object.optString("DateOfBirth"));
                        mySharedPreference.setDOB(dobb);
                        policy_type = object.optString("PolicyType");
                        if (policy_type.equalsIgnoreCase("MOTOR")) {
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SignUpActivity.this);
                            if (!sharedPreferences.getBoolean("IntroPages", false)) {
                                Intent i = new Intent(SignUpActivity.this, TutorialActivityMotor.class);
                                startActivity(i);
                                onFinishIntroPages();
                                finish();
                            } else {
                                Intent in = new Intent(mContext, MainActivity.class);
                                startActivity(in);
                                finish();
                            }
                        } else {
                            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                            boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
                            if(!previouslyStarted) {
                                SharedPreferences.Editor edit = prefs.edit();
                                edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
                                edit.commit();
                                Intent i = new Intent(SignUpActivity.this, TutorialActivity.class);
                                startActivity(i);
                            } else {
                                Intent in = new Intent(mContext, MainActivityHealth.class);
                                startActivity(in);
                            }
                            finish();
                        }
                    } else if (object.optString("Message").equalsIgnoreCase("Already policy linked in some other account")) {
                        showOnErrorDialog4("Policy already linked in some other account.");
                    } else if (object.optString("Message").equalsIgnoreCase("User OTP does not exists.")) {
                        showOnErrorDialog4("The OTP entered by you is not correct. Please enter correct OTP.");
                    } else {
                        showOnErrorDialog4("No policy from USGI found. This app is for USGI customers only. Thank you!");
                    }
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) { }
        }, RequestConstants.URL_VERIFY_OTP);
        req.execute();
    }

    private void onFinishIntroPages(){
        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(this).edit();
        sharedPreferencesEditor.putBoolean(
                "IntroPages", true);
        sharedPreferencesEditor.apply();
    }

    void hitResendOTPService(String s) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", mySharedPreference.getToken_no());
            object.put("userId", mySharedPreference.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(mContext, object, UrlConstants.URL_RESEND_OTP, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {

                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.URL_RESEND_OTP) {
                        if (switch_insurance.isChecked()) {
                            txt_otp1.setText("");
                            startCountDown1();
                        } else {
                            txt_otp.setText("");
                            startCountDown();
                        }
                    }
                } else {
                    Toast.makeText(mContext, object.optString("Message"), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_RESEND_OTP);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    public void showOnErrorDialog4(String mesg) {
        final Dialog alert_dialog = new Dialog(this);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor_signup);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_heading.setText("Alert");
        alert_msg.setText(mesg);

        alert_dialog.show();
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern;

        if (time.contains("/"))
            inputPattern = "dd/MM/yyyy";
        else
            inputPattern = "dd-MMM-yyyy";

        String outputPattern = "dd-MMM-yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date;
        String str = null;
        try {
            date = inputFormat.parse(time);
            assert date != null;
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    void startCountDown() {
        btn_signUp.setEnabled(false);
        btn_resend_otp.setEnabled(false);
        btn_resend_otp.setTextColor(Color.parseColor("#656565"));
        btn_resend_otp.setBackground(getResources().getDrawable(R.drawable.btn_bg2_new));

        new CountDownTimer(timerDuration, 1000) {

            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                long sec = (l / 1000);
                if (sec >= 10) {
                    otp_timer.setText("00:" + sec);
                } else {
                    otp_timer.setText("00:0" + sec);
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                otp_timer.setText("00:00");
            }
        }.start();

        new Handler().postDelayed(() -> {
            btn_signUp.setEnabled(true);
            btn_resend_otp.setEnabled(true);
            btn_resend_otp.setTextColor(ContextCompat.getColor(mContext, R.color.white));
            btn_resend_otp.setBackground(getResources().getDrawable(R.drawable.btn_bg1));
        }, timerDuration);
    }

    void startCountDown1() {
        btn_signUp1.setEnabled(false);
        btn_resend_otp1.setEnabled(false);
        btn_resend_otp1.setTextColor(Color.parseColor("#656565"));
        btn_resend_otp1.setBackground(getResources().getDrawable(R.drawable.btn_bg2_new));

        new CountDownTimer(timerDuration, 1000) {

            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                long sec = (l / 1000);
                if (sec >= 10) {
                    otp_timer1.setText("00:" + sec);
                } else {
                    otp_timer1.setText("00:0" + sec);
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                otp_timer1.setText("00:00");
            }
        }.start();

        new Handler().postDelayed(() -> {
            btn_signUp1.setEnabled(true);
            btn_resend_otp1.setEnabled(true);
            btn_resend_otp1.setTextColor(ContextCompat.getColor(mContext, R.color.white));
            btn_resend_otp1.setBackground(getResources().getDrawable(R.drawable.btn_bg1));
        }, timerDuration);
    }

    public void UpdateUserID(){

        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", mySharedPreference.getToken_no());
            object.put("UserId",  mySharedPreference.getUID());
            object.put("DeviceId",deviceId );
            object.put("DeviceType", "Android");
            object.put("DeviceName", deviceName);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(SignUpActivity.this, object, UrlConstants.UPDATE_USER_DEVICE_ID, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                Log.d("Response" , String.valueOf(object));

                try {
                    String message = object.getString("Message");
                    if (message.equals("Success")){
                        mySharedPreference.setAndroidId(deviceId);
                        if (policy_type.equalsIgnoreCase("MOTOR")) {
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SignUpActivity.this);
                            if (!sharedPreferences.getBoolean("IntroPages", false)) {
                                Intent i = new Intent(SignUpActivity.this, TutorialActivityMotor.class);
                                startActivity(i);
                                onFinishIntroPages();
                                finish();
                            } else {
                                Intent in = new Intent(mContext, MainActivity.class);
                                startActivity(in);
                                finish();
                            }
                        } else {
                            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                            boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
                            if (!previouslyStarted) {
                                SharedPreferences.Editor edit = prefs.edit();
                                edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
                                edit.commit();
                                Intent i = new Intent(SignUpActivity.this, TutorialActivity.class);
                                startActivity(i);
                            } else {
                                Intent in = new Intent(mContext, MainActivityHealth.class);
                                startActivity(in);
                            }
                            finish();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_APP_DATA_LOG);
        req.execute();
    }
}
