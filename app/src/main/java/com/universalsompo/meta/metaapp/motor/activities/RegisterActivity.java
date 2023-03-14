package com.universalsompo.meta.metaapp.motor.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AESUtils;
import org.json.JSONObject;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;



public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private final Executor backgroundExecutor = Executors.newSingleThreadExecutor();
    private String deviceName;
    private static String deviceId;
    TelephonyManager tm;
    private MySharedPreference mySharedPreference;
    private EditText register_name;
    private EditText register_email;
    private EditText register_phone;
    private EditText register_dob;
    private SimpleDateFormat dateFormatter;
    private String gender;
    String policy_type,user_id="",encrypted="";
    LinearLayout login_liner;
    LinearLayout date_picker_liner;
    private CheckBox chkCondition;
    private final String prefKey = "checkedInstallReferrer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        getWindow().setBackgroundDrawableResource(R.drawable.splash_back_1);
        getWindow().setStatusBarColor(ContextCompat.getColor(RegisterActivity.this, R.color.colorPrimaryDark));
//        checkInstallReferrer();

        tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        mySharedPreference = MySharedPreference.getInstance(RegisterActivity.this);
        deviceName = getDeviceName();
        deviceId = getDeviceId();



        initView();
    }
   /* void checkInstallReferrer() {
        if (getPreferences(MODE_PRIVATE).getBoolean(prefKey, false)) {
            return;
        }

        InstallReferrerClient referrerClient = InstallReferrerClient.newBuilder(this).build();
        backgroundExecutor.execute(() -> getInstallReferrerFromClient(referrerClient));
    }
    void getInstallReferrerFromClient(InstallReferrerClient referrerClient) {

        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                switch (responseCode) {
                    case InstallReferrerClient.InstallReferrerResponse.OK:
                        ReferrerDetails response = null;
                        try {
                            response = referrerClient.getInstallReferrer();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        final String referrerUrl = response.getInstallReferrer();


                        // TODO: If you're using GTM, call trackInstallReferrerforGTM instead.
                        trackInstallReferrer(referrerUrl);


                        // Only check this once.
                        getPreferences(MODE_PRIVATE).edit().putBoolean(prefKey, true).commit();

                        // End the connection
                        referrerClient.endConnection();

                        break;
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                        // API not available on the current Play Store app.
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                        // Connection couldn't be established.
                        break;
                }
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {

            }
        });
    }

    // Tracker for Classic GA (call this if you are using Classic GA only)
    private void trackInstallReferrer(final String referrerUrl) {
        new Handler(getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                CampaignTrackingReceiver receiver = new CampaignTrackingReceiver();
                Intent intent = new Intent("com.android.vending.INSTALL_REFERRER");
                intent.putExtra("referrer", referrerUrl);
                receiver.onReceive(getApplicationContext(), intent);
            }
        });
    }

    // Tracker for GTM + Classic GA (call this if you are using GTM + Classic GA only)
    private void trackInstallReferrerforGTM(final String referrerUrl) {
        new Handler(getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                InstallReferrerReceiver receiver = new InstallReferrerReceiver();
                Intent intent = new Intent("com.android.vending.INSTALL_REFERRER");
                intent.putExtra("referrer", referrerUrl);
                receiver.onReceive(getApplicationContext(), intent);
            }
        });
    }*/


    private String getDeviceId() {
        return Settings.Secure.getString(RegisterActivity.this.getContentResolver(),Settings.Secure.ANDROID_ID);
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
        Intent a=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(a);
        finish();
    }

    private void initView() {




        chkCondition = findViewById(R.id.checkbox);
        register_name = findViewById(R.id.register_name);
        register_email = findViewById(R.id.register_email);
        register_phone = findViewById(R.id.register_phone);
        register_dob = findViewById(R.id.register_dob);
        login_liner = findViewById(R.id.login_liner);
        date_picker_liner = findViewById(R.id.date_picker_liner);
        RadioGroup gender_btn_view = findViewById(R.id.gender_btn_view);
        Button btn_register = findViewById(R.id.btn_register);
        register_dob.setOnClickListener(this);
        date_picker_liner.setOnClickListener(this);
        gender = "Male";

        gender_btn_view.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = group.findViewById(checkedId);
            if (null != rb && checkedId > -1) {
                String choice = (String) rb.getText();
                if (choice.equalsIgnoreCase("Male")) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
            }
        });
        login_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.register_dob:
            case R.id.date_picker_liner:
                showCalender();
                break;
            case R.id.btn_register:
                if (register_name.getText().toString().length() == 0) {
                    register_name.setFocusableInTouchMode(true);
                    register_name.setCursorVisible(true);
                    register_name.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                } else if (register_email.getText().toString().length() == 0) {
                    register_email.setFocusableInTouchMode(true);
                    register_email.setCursorVisible(true);
                    register_email.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Email is mandatory.", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(register_email.getText().toString()).matches()) {
                    register_email.setFocusableInTouchMode(true);
                    register_email.setCursorVisible(true);
                    register_email.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Email address is not valid.", Toast.LENGTH_SHORT).show();
                } else if (register_phone.getText().toString().length() == 0) {
                    register_phone.setFocusableInTouchMode(true);
                    register_phone.setCursorVisible(true);
                    register_phone.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Phone no is mandatory", Toast.LENGTH_SHORT).show();
                } else if (register_phone.getText().toString().length() < 10) {
                    register_phone.setFocusableInTouchMode(true);
                    register_phone.setCursorVisible(true);
                    register_phone.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Phone no must be 10 digits long", Toast.LENGTH_SHORT).show();
                }else if(!register_phone.getText().toString().matches("^[6-9]\\d{9}$")){
                    register_phone.setFocusableInTouchMode(true);
                    register_phone.setCursorVisible(true);
                    register_phone.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Phone number is not valid.", Toast.LENGTH_SHORT).show();
                }else if (!chkCondition.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Please accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }
//                else if (register_dob.getText().toString().length() == 0) {
//                    register_dob.setFocusableInTouchMode(true);
//                    register_dob.setCursorVisible(true);
//                    register_dob.requestFocus();
//                    Toast.makeText(RegisterActivity.this, "Please select your date of birth.", Toast.LENGTH_SHORT).show();
//                }
                else {
                    callApiRegistration();
                }
                break;
        }
    }

    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(RegisterActivity.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            register_dob.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
//object.put("DOB", parseDateToddMMyyyy(register_dob.getText().toString()));
    private void callApiRegistration() {
        JSONObject object = new JSONObject();
        try {
//            object.put("TokenNo", RequestConstants.TOKEN_NO_VALUE);
            object.put("Name", register_name.getText().toString());
            object.put("MobileNo", register_phone.getText().toString());
            object.put("EmailID", register_email.getText().toString());
            object.put("DOB", "");
            object.put("Gender", gender);
            object.put("IMEINo", deviceId);
            object.put("DeviceName", deviceName);
            object.put("DeviceType", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(RegisterActivity.this, object, UrlConstants.URL_REGISTER_NO_USER, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (Tag == RequestConstants.URL_REGISTER_NO_USER) {
                    String message = object.optString("Message");
                    if (object.optString("Message").equals("Success")) {
                        mySharedPreference.addIsLoggedIn(true);
                        mySharedPreference.setUserName(object.optString("Name"));
                        mySharedPreference.setMobile(object.optString("Mobile"));
                        mySharedPreference.setProfilePic(object.optString("UserImagePath"));
                        mySharedPreference.setEmailId(object.optString("Email"));
                        mySharedPreference.setCorporateId(object.optString("CorporateID"));
                        mySharedPreference.setgender(object.optString("Gender"));
                        mySharedPreference.setIsPolicyStatus(object.optString("IsPolicyStatus"));
                        String dob = object.optString("DOB");
                        String dobb = parseDateToddMMyyyy1(dob);
                        mySharedPreference.setDOB(dobb);
                        policy_type = object.optString("PolicyType");
                        mySharedPreference.setAge(object.optString("Age"));
                        mySharedPreference.addPolicyType(object.optString("PolicyType"));
                        mySharedPreference.setisUSGIUser(object.optString("Usgi_User"));
                        mySharedPreference.setCustID(object.optString("CustomerID"));
                        mySharedPreference.addUID(object.optString("UID"));
                        mySharedPreference.addToken_no(object.optString("Token_NO"));
                        if (policy_type.equalsIgnoreCase("MOTOR")) {
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(RegisterActivity.this);
                            if (!sharedPreferences.getBoolean("IntroPages", false)) {
                               /* Intent i = new Intent(RegisterActivity.this, TutorialActivityMotor.class);
                                startActivity(i);
                                onFinishIntroPages();
                                finish();*/
                                Intent in = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(in);
                                finish();

                            } else {
                                Intent in = new Intent(RegisterActivity.this, MainActivity.class);
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
                              /*  Intent i = new Intent(RegisterActivity.this, TutorialActivity.class);
                                startActivity(i);*/

                                Intent in = new Intent(RegisterActivity.this, MainActivityHealth.class);
                                startActivity(in);
                            } else {
                                Intent in = new Intent(RegisterActivity.this, MainActivityHealth.class);
                                startActivity(in);
                            }
                            finish();
                        }
                    } else {
                        final Dialog alert_dialog = new Dialog(RegisterActivity.this);
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
                        alert_msg.setText(message);
                        alert_heading.setText("Alert");
                        alert_dialog.show();
                        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
                    }
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) { }
        }, RequestConstants.URL_REGISTER_NO_USER);
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

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd-MMM-yyyy";
        String outputPattern = "MM-dd-yyyy";
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

    public String parseDateToddMMyyyy1(String time) {
        String inputPattern;

        if(time.contains("/"))
            inputPattern = "MM/dd/yyyy hh:mm:ss aa";
        else
            inputPattern = "MMM-dd-yyyy hh:mm:ss aa";

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

    private void onFinishIntroPages(){
        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(this).edit();
        sharedPreferencesEditor.putBoolean(
                "IntroPages", true);
        sharedPreferencesEditor.apply();
    }
}
