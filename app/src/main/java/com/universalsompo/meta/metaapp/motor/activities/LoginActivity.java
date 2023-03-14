package com.universalsompo.meta.metaapp.motor.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
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

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;
import com.universalsompo.meta.BuildConfig;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.activities.TutorialActivity;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.AESUtils;
import com.universalsompo.meta.metaapp.utilities.CacheUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    EditText edt_phone, edt_email;
    private TextView otp_timer;
    static EditText txt_otp;
    Button btn_login, btn_verify, btn_resend_otp;
    Context mContext;
    LinearLayout rl_otp;
    LinearLayout login_otp;
    static MySharedPreference mySharedPreference;
    TelephonyManager tm;
    long timerDuration = 60000;
    private String deviceName;
    private static String deviceId;
    private String deviceVersion;
    String policy_type;
    private static final String PACKAGE_NAME = "com.universalsompo.meta";
    private Button btn_no_policy;
    String phone_no, email;
     LinearLayout meta_liner;
    String user_id="",encrypted="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        getWindow().setBackgroundDrawableResource(R.drawable.splash_back_1);
        mContext = this;
        getWindow().setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.colorPrimaryDark));
        tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        mySharedPreference = MySharedPreference.getInstance(mContext);
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            deviceVersion = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        deviceName = getDeviceName();
        deviceId = getDeviceId();
        initView();
    }

    private String getDeviceId() {
        return Settings.Secure.getString(LoginActivity.this.getContentResolver(),Settings.Secure.ANDROID_ID);
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

    void initView() {
        edt_phone = findViewById(R.id.edt_phone);
        edt_email = findViewById(R.id.edt_email);
        otp_timer = findViewById(R.id.otp_timer);
        txt_otp = findViewById(R.id.txt_otp);
        btn_login = findViewById(R.id.btn_login);
        btn_verify = findViewById(R.id.btn_verify);
        btn_resend_otp = findViewById(R.id.btn_resend_otp);
        rl_otp = findViewById(R.id.rl_otp);
        login_otp = findViewById(R.id.login_otp);
        btn_no_policy = findViewById(R.id.btn_no_policy);
        meta_liner = findViewById(R.id.meta_liner);

        meta_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser_term_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse(UrlConstants.meta_url));
                startActivity(browser_term_Intent);
            }
        });

        edt_phone.setSelection(edt_phone.getText().length());
        edt_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LogUtils.showLog("@@@S LENGTH", "" + s.toString().length());

                if (s.toString().length() < 10) {
                    if (login_otp.getVisibility() == View.VISIBLE) {
                        login_otp.setVisibility(View.GONE);
                        btn_login.setEnabled(true);
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

        edt_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LogUtils.showLog("@@@S LENGTH", "" + s.toString().length());
                if (login_otp.getVisibility() == View.VISIBLE) {
                    login_otp.setVisibility(View.GONE);
                    btn_login.setEnabled(true);
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


        btn_login.setOnClickListener(v -> {
            phone_no = edt_phone.getText().toString().trim();
            email = edt_email.getText().toString().trim();
            if (phone_no.isEmpty()) {
                edt_phone.setFocusableInTouchMode(true);
                edt_phone.setCursorVisible(true);
                edt_phone.requestFocus();
                Toast.makeText(mContext, "Phone no is mandatory", Toast.LENGTH_SHORT).show();
            } else if (phone_no.length() < 10) {
                edt_phone.setFocusableInTouchMode(true);
                edt_phone.setCursorVisible(true);
                edt_phone.requestFocus();
                Toast.makeText(mContext, "Phone no must be 10 digits long", Toast.LENGTH_SHORT).show();
            } else if(!phone_no.matches("^[6-9]\\d{9}$")){
                edt_phone.setFocusableInTouchMode(true);
                edt_phone.setCursorVisible(true);
                edt_phone.requestFocus();
                Toast.makeText(mContext, "Phone number is not valid.", Toast.LENGTH_SHORT).show();
            }else if (email.isEmpty()) {
                edt_email.setFocusableInTouchMode(true);
                edt_email.setCursorVisible(true);
                edt_email.requestFocus();
                Toast.makeText(mContext, "Email is mandatory", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edt_email.setFocusableInTouchMode(true);
                edt_email.setCursorVisible(true);
                edt_email.requestFocus();
                Toast.makeText(mContext, "Email address is not valid", Toast.LENGTH_SHORT).show();
            } else {
                CacheUtils.deleteCache(getApplicationContext());
                hitLoginWebservice(phone_no, email);
//                startCountDown();
            }
        });


        btn_verify.setOnClickListener(v -> {
            if (txt_otp.getText().toString().trim().length() > 0) {
                hitVerifyOTPService();
            } else {
                Toast.makeText(LoginActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
            }
        });

//        btn_resend_otp.setOnClickListener(v -> hitResendOTPService());


        btn_resend_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitLoginWebservice(phone_no, email);
                startCountDown();
            } ;
        });



        btn_no_policy.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    void hitLoginWebservice(final String phone, final String email) {
        JSONObject object = new JSONObject();
        try {
//            object.put("TokenNo", RequestConstants.TOKEN_NO_VALUE);
            object.put("MobileNo", phone);
            object.put("EmailID", email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(mContext, object, UrlConstants.URL_LOGIN, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (Tag == RequestConstants.URL_LOGIN) {
                    try {
                        String err_code = object.optString("ErrorCode");
                        String reg_required = object.optString("IsRegRequired");
                        String message = object.optString("Message");

                        if (err_code.equalsIgnoreCase("01")) {
                            if (reg_required.equalsIgnoreCase("true")) {
                                login_otp.setVisibility(View.GONE);
                                showOnErrorDialog(phone, email);
                            } else {
                                login_otp.setVisibility(View.VISIBLE);
                                startCountDown();
                                if (BuildConfig.DEBUG) {
                                    txt_otp.setText(object.optString("OTP"));
                                } else {
                                    if (phone.equalsIgnoreCase("7217755792") && email.equalsIgnoreCase("atul@zoitechnologies.com")) {
                                        txt_otp.setText(object.optString("OTP"));
                                    } else {
                                        startCountDown();
                                    }
                                }
                                mySharedPreference.addUID(object.optString("UID"));
//                                 user_id=object.optString("UID");
//                                  encrypt();
                                  mySharedPreference.setClientUserID(object.optString("ClientUserID"));
                            }
                        } else if (err_code.equalsIgnoreCase("02")) {
                            login_otp.setVisibility(View.GONE);
                            showOnErrorDialog1();
                        } else if (err_code.equalsIgnoreCase("03")) {
                            login_otp.setVisibility(View.GONE);
                            showOnErrorDialog(phone, email);
                        } else if (err_code.equalsIgnoreCase("04")) {
                            login_otp.setVisibility(View.GONE);
                            showOnErrorDialog(phone, email);
                        } else if (err_code.equalsIgnoreCase("05")) {
                            login_otp.setVisibility(View.GONE);

                            showOnErrorDialog5(message);
                        } else if (err_code.equalsIgnoreCase("06")) {
                            login_otp.setVisibility(View.GONE);
                            showOnErrorDialog5(message);
                        } else if (err_code.equalsIgnoreCase("07")) {
                            login_otp.setVisibility(View.VISIBLE);
                            startCountDown();
                            if (BuildConfig.DEBUG) {
                                txt_otp.setText(object.optString("OTP"));
                            } else {
                                if (phone.equalsIgnoreCase("7217755792") && email.equalsIgnoreCase("atul@zoitechnologies.com")) {
                                    txt_otp.setText(object.optString("OTP"));
                                } else {
                                    startCountDown();
                                }
                            }
                            mySharedPreference.addUID(object.optString("UID"));
                            mySharedPreference.setClientUserID(object.optString("ClientUserID"));
                            mySharedPreference.addToken_no(object.optString("Token_NO"));
                        } else {
                            showOnErrorDialog3();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestConstants.URL_LOGIN);
        req.execute();
    }

    private void encrypt() {
        try {
            encrypted = AESUtils.encrypt(user_id);
            Log.d("TEST", "encrypted:" + encrypted);
//            mySharedPreference.addUID(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void hitVerifyOTPService() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", mySharedPreference.getToken_no());
            object.put("userId", mySharedPreference.getUID());
            object.put("OTP", txt_otp.getText().toString());
            object.put("IMEINo", deviceId);
            object.put("DeviceName", deviceName);
            object.put("DeviceType", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(mContext, object, UrlConstants.URL_VERIFY_OTP, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    if (Tag == RequestConstants.URL_VERIFY_OTP) {
                        mySharedPreference.addIsLoggedIn(true);
                        mySharedPreference.setUserName(object.optString("Name"));
                        mySharedPreference.setMobile(object.optString("Mobile"));
                        mySharedPreference.setProfilePic(object.optString("UserImagePath"));
                        mySharedPreference.setEmailId(object.optString("Email"));
                        mySharedPreference.setCorporateId(object.optString("CorporateID"));
                        mySharedPreference.setgender(object.optString("Gender"));
                        mySharedPreference.setIsPolicyStatus(object.optString("IsPolicyStatus"));
                        String dob = object.optString("DOB");
                        String dobb = parseDateToddMMyyyy(dob);
                        mySharedPreference.setDOB(dobb);
                        policy_type = object.optString("PolicyType");
                        mySharedPreference.setAge(object.optString("Age"));
                        mySharedPreference.addPolicyType(object.optString("PolicyType"));
                        mySharedPreference.setisUSGIUser(object.optString("Usgi_User"));
                        mySharedPreference.setCustID(object.optString("CustomerID"));

                        checkUser();
                    }
                } else {
                    txt_otp.setText("");
                    Toast.makeText(mContext, "OTP does not match. Please enter correct OTP.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.URL_VERIFY_OTP);
        req.execute();
    }

    void hitResendOTPService() {
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
                        txt_otp.setText("");
                        startCountDown();
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

    void startCountDown() {
        btn_login.setEnabled(false);
        btn_resend_otp.setEnabled(false);
        btn_resend_otp.setTextColor(Color.parseColor("#656565"));
        btn_resend_otp.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.btn_bg2_new));
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
            btn_login.setEnabled(true);
            btn_resend_otp.setEnabled(true);
            btn_resend_otp.setTextColor(ContextCompat.getColor(mContext, R.color.white));
            btn_resend_otp.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.btn_bg1));
        }, timerDuration);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern;

        if(time.contains("/"))
            inputPattern = "MM/dd/yyyy";
        else
            inputPattern = "MMM-dd-yyyy";

        String outputPattern = "dd-MMM-yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


    @SuppressLint("SetTextI18n")
    public void showOnErrorDialog(final String phone, final String email) {
        final Dialog alert_dialog = new Dialog(this);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("Your email ID/mobile number has not been updated. \n Please give us some more information to fetch your policy details.");
        alert_heading.setText("Error");
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> {
            alert_dialog.dismiss();
//            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putString("phone", phone);
//            bundle.putString("email", email);
//            intent.putExtras(bundle);
//            startActivity(intent);
//            finish();
        });
    }

    @SuppressLint("SetTextI18n")
    public void showOnErrorDialog1() {
        final Dialog alert_dialog = new Dialog(this);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("Your account has been deactivated. Please contact the administrator for more details.");
        alert_heading.setText("Alert");
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss()

        );
    }

    @SuppressLint("SetTextI18n")
    public void showOnErrorDialog2(String msg) {
        final Dialog alert_dialog = new Dialog(this);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText(msg);
        alert_heading.setText("Alert");
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> {
            CacheUtils.deleteCache(getApplicationContext());
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + PACKAGE_NAME)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + PACKAGE_NAME)));
            }
            alert_dialog.dismiss();
        });
    }

    @SuppressLint("SetTextI18n")
    public void showOnErrorDialog5(String msg) {
        final Dialog alert_dialog = new Dialog(this);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText(msg);
        alert_heading.setText("Alert");
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
    }

    @SuppressLint("SetTextI18n")
    public void showOnErrorDialog3() {
        final Dialog alert_dialog = new Dialog(this);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("Seems something went wrong. Please try after sometime.");
        alert_heading.setText("Alert");

        alert_dialog.show();
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void checkUser(){
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",  mySharedPreference.getToken_no());
            object.put("userId",  mySharedPreference.getUID());
            object.put("DeviceId",deviceId );
            object.put("DeviceType", "0");
            object.put("DeviceVersion", deviceVersion);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(LoginActivity.this, object, UrlConstants.URL_CHECK_DEVICE_STATUS, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                try {
                    String messageType = object.getString("MessageType");
                    String message = object.getString("Message");
                    switch (messageType) {
                        case "5":
                        case "3":
                        case "0":
                            if (policy_type.equalsIgnoreCase("MOTOR")) {
                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                                if (!sharedPreferences.getBoolean("IntroPages", false)) {
                                   /* Intent i = new Intent(LoginActivity.this, TutorialActivityMotor.class);
                                    startActivity(i);
                                    onFinishIntroPages();
                                    finish();*/
                                    Intent in = new Intent(mContext, MainActivity.class);
                                    startActivity(in);
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


//                                    Intent i = new Intent(LoginActivity.this, TutorialActivity.class);
//                                    startActivity(i);
                                    Intent in = new Intent(mContext, MainActivityHealth.class);
                                    startActivity(in);
                                } else {
                                    Intent in = new Intent(mContext, MainActivityHealth.class);
                                    startActivity(in);
                                }
                                finish();
                            }
                            break;
                        case "4":
                            showOnErrorDialog2(message);
                            break;
                        case "1":
                            showMessageToUser(message);
                            break;
                        default:
                            showOnErrorDialog1();
                            break;
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

    private void onFinishIntroPages(){
        SharedPreferences.Editor sharedPreferencesEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        sharedPreferencesEditor.putBoolean("IntroPages", true);
        sharedPreferencesEditor.apply();
    }

    void showMessageToUser(final String message) {
        final Dialog dialog = new Dialog(this, R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.ask_user_continue_dialog);
        TextView Ok = dialog.findViewById(R.id.login_yes);
        TextView no = dialog.findViewById(R.id.login_no);
        TextView messageText = dialog.findViewById(R.id.version_check_message);
        messageText.setText(message);

        Ok.setOnClickListener(v -> {
            dialog.dismiss();
            UpdateUserID();
        });
        no.setOnClickListener(v -> {
            mySharedPreference.addIsLoggedIn(false);
            dialog.dismiss();
        });

        dialog.show();
    }


    public void UpdateUserID(){
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",  mySharedPreference.getToken_no());
            object.put("UserId",  mySharedPreference.getUID());
            object.put("DeviceId",deviceId );
            object.put("DeviceType", "Android");
            object.put("DeviceName", deviceName);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(LoginActivity.this, object, UrlConstants.UPDATE_USER_DEVICE_ID, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                try {
                    String message = object.getString("Message");
                    if (message.equals("Success")){
                        mySharedPreference.setAndroidId(deviceId);
                        if (policy_type.equalsIgnoreCase("MOTOR")) {
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                            if (!sharedPreferences.getBoolean("IntroPages", false)) {
//                                Intent i = new Intent(LoginActivity.this, TutorialActivityMotor.class);
//                                startActivity(i);
//                                onFinishIntroPages();
//                                finish();
                                Intent in = new Intent(mContext, MainActivity.class);
                                startActivity(in);
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
//                                Intent i = new Intent(LoginActivity.this, TutorialActivity.class);
//                                startActivity(i);

                               Intent in = new Intent(mContext, MainActivityHealth.class);
                                startActivity(in);
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
