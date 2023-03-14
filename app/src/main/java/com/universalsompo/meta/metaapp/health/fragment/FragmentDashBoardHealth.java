package com.universalsompo.meta.metaapp.health.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.Health_Insurance_Renewal;
import com.universalsompo.meta.metaapp.health.activities.Web_Loan;
import com.universalsompo.meta.metaapp.health.adapter.VideoAdapter;
import com.universalsompo.meta.metaapp.health.alarmservices.AlarmReceiverUpdateTargets;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.blogs.adapter.MyBlogAdapter;
import com.universalsompo.meta.metaapp.health.fragment.blogs.model.Blog;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.CalculatorPlanType;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.OfflineCalculator;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.fragment.FoodIntakeMainTab;
import com.universalsompo.meta.metaapp.health.fragment.homecare.TypesOfHomecare;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentCouponCode;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentMultipleVendor;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.BuyPolicyMenu;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.MyPolicyTab;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentSymptonReports;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentBasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.todayexercise.FragmentFitnessTrackerMenu;
import com.universalsompo.meta.metaapp.health.fragment.todayexercise.FragmentLogActivity;
import com.universalsompo.meta.metaapp.health.fragment.todayexercise.FragmentTodayExerciseTab;
import com.universalsompo.meta.metaapp.health.fragment.watertracking.fragment.WaterIntakeMainTab;
import com.universalsompo.meta.metaapp.health.fragment.weightlog.fragment.WeightLogMainTab;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment.FragmentWYHMenu;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.activities.GarageListActivity;
import com.universalsompo.meta.metaapp.motor.activities.GoogleMapPlacesActivity;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.activities.TravelInsurance;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.MotorPrivate;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.ContentModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class FragmentDashBoardHealth extends Fragment implements ResponseListener, LocationListener {
    private SelectorListener binder;
    private MySharedPreference pref;
    private LinearLayout rl_diet_chart;
    private LinearLayout rl_water_chart;
    private LinearLayout rl_activity_chart;
    private LinearLayout rl_weight_chart;
    private LinearLayout log_activity;
    private LinearLayout insurance_wallet, rl_hra, wellness_package, search_doctor, rl_medicine, r1_lab_test, homecare, health_packages, baby_caring_parenting, emotional_wellness, spiritual_wellness, healthy_living, ayush_medicine,loan_secure,renew_health;
    private String wellness_name;
    private String wellness_id;
    private String wellness_url;
    private ProgressBar simpleProgressBar, water_progress;
    private TextView water_goal, total_diet_consumed, total_diet, total_water_consumed, total_water, calorie_goal2, exercise_goal, weight_goal, loss_gain_value;
    private ProgressBar steps_progress;
    private TextView steps_taken, steps_goal;
    private ProgressBar weight_progress;
    private TextView weight_burn, weight_left;
    LinearLayout dismissBtn;
    private LinearLayout blog_section;
    private RecyclerView blog_list;
    private ArrayList<Blog> blog1 = new ArrayList<>();
    private ImageView tick_1, tick_2, tick_3, tick_4;
    private String selected_date, selected_date1;
    private double TargetCal, totalPreviousDayCal;
    private String state, city;
    private Dialog alert_dialog;
    private static String TAG = "previousdata";
    private float walking_calorie = 0, running_calorie = 0, biking_calorie = 0;
    private AlertDialog alertDialog;
    private String selected_date1_fitbit;
    private LinearLayout wyh_btn;
    FloatingActionButton openTravelInsurance;
    public double latitude;
    public double longitude;
    public LocationManager locationManager;
    public Criteria criteria;
    public String bestProvider="";

    private String interviewid;
    private BasicQuesDatabaseHelper db;
    private ResultDatabaseHelper db2;
     Boolean gps_button_tru;
    private LinearLayout buy_covid_kavach;
    private LinearLayout covid_assessment;
    private LinearLayout btn_covid_call;
    private LinearLayout btn_mind_therapist;
    private LinearLayout btn_teleconsultation;
    private LinearLayout btn_testing_labs;
    private LinearLayout btn_pharmacy;
    private LinearLayout btn_home_remedies;

    private LinearLayout rl_buy_policy_btn;
    private RecyclerView recyclerview_videos;
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_health_dashboard, container, false);

        ((InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        ((MainActivityHealth) getActivity()).shownav();
        ((MainActivityHealth) getActivity()).showfooter();
        ((MainActivityHealth) getActivity()).getSosDetails();
        setHasOptionsMenu(true);
//        getCurrentLocation();
        pref = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        db2 = new ResultDatabaseHelper(getActivity());
        getSliders();
        initViews(myView);
        callApi(RequestHealthConstants.GET_BLOG);
        hitblogs();
        initListeners();
        if (pref.getweight() != null && pref.getfeet() != null && pref.getinches() != null && pref.getDailyactivity() != null && pref.getEmergencyContactName() != null && pref.getEmergencyContactNumber() != null && pref.getweight().length() != 0 && pref.getfeet().length() != 0 && pref.getinches().length() != 0 && pref.getDailyactivity().length() != 0 && pref.getEmergencyContactName().length() != 0 && pref.getEmergencyContactNumber().length() != 0) {
            getcurrentdate();
        } else {
            callApi(RequestHealthConstants.GET_PROFILE_DETAIL);
        }
        SetAlarm();
        return myView;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        selected_date = df.format(c);
        selected_date1 = selected_date;
        selected_date1_fitbit = df1.format(c);
        callApi(RequestHealthConstants.GET_DASHBOARD_DATA);
    }

    private void initViews(View myView) {
        rl_activity_chart = myView.findViewById(R.id.rl_activity_chart);
        exercise_goal = myView.findViewById(R.id.exercise_goal);
        steps_goal = myView.findViewById(R.id.steps_goal);
        steps_progress = myView.findViewById(R.id.steps_progress);
        steps_taken = myView.findViewById(R.id.steps_taken);
        log_activity = myView.findViewById(R.id.log_activity);
        tick_1 = myView.findViewById(R.id.tick_1);
        simpleProgressBar = myView.findViewById(R.id.simpleProgressBar);
        rl_diet_chart = myView.findViewById(R.id.rl_diet_chart);
        calorie_goal2 = myView.findViewById(R.id.calorie_goal2);
        total_diet_consumed = myView.findViewById(R.id.total_diet_consumed);
        total_diet = myView.findViewById(R.id.total_diet);
        tick_2 = myView.findViewById(R.id.tick_2);
        rl_water_chart = myView.findViewById(R.id.rl_water_chart);
        water_goal = myView.findViewById(R.id.water_goal);
        water_progress = myView.findViewById(R.id.water_progress);
        total_water_consumed = myView.findViewById(R.id.total_water_consumed);
        total_water = myView.findViewById(R.id.total_water);
        tick_3 = myView.findViewById(R.id.tick_3);
        rl_weight_chart = myView.findViewById(R.id.rl_weight_chart);
        weight_goal = myView.findViewById(R.id.weight_goal);
        loss_gain_value = myView.findViewById(R.id.loss_gain_value);
        weight_progress = myView.findViewById(R.id.weight_progress);
        weight_burn = myView.findViewById(R.id.weight_burn);
        weight_left = myView.findViewById(R.id.weight_left);
        tick_4 = myView.findViewById(R.id.tick_4);
        wyh_btn = myView.findViewById(R.id.wyh_btn);
        rl_buy_policy_btn = myView.findViewById(R.id.rl_buy_policy_btn);
        insurance_wallet = myView.findViewById(R.id.insurance_wallet);
        rl_hra = myView.findViewById(R.id.rl_hra);
        wellness_package = myView.findViewById(R.id.wellness_package);
        search_doctor = myView.findViewById(R.id.search_doctor);
        rl_medicine = myView.findViewById(R.id.rl_medicine);
        r1_lab_test = myView.findViewById(R.id.r1_lab_test);
        homecare = myView.findViewById(R.id.homecare);
        health_packages = myView.findViewById(R.id.health_packages);
        emotional_wellness = myView.findViewById(R.id.emotional_wellness);
        spiritual_wellness = myView.findViewById(R.id.spiritual_wellness);
        healthy_living = myView.findViewById(R.id.healthy_living);
        ayush_medicine = myView.findViewById(R.id.ayush_medicine);
        baby_caring_parenting = myView.findViewById(R.id.baby_caring_parenting);
        blog_list = myView.findViewById(R.id.blog_list);
        openTravelInsurance = myView.findViewById(R.id.openTravelInsurance);
        blog_list.setNestedScrollingEnabled(false);
        blog_section = myView.findViewById(R.id.blog_section);
//        loan_secure = myView.findViewById(R.id.loan_secure);
        renew_health = myView.findViewById(R.id.renew_health);

        btn_covid_call = myView.findViewById(R.id.btn_covid_call);
        btn_mind_therapist = myView.findViewById(R.id.btn_mind_therapist);
        btn_teleconsultation = myView.findViewById(R.id.btn_teleconsultation);
        btn_testing_labs = myView.findViewById(R.id.btn_testing_labs);
        buy_covid_kavach = myView.findViewById(R.id.buy_covid_kavach);
        btn_pharmacy = myView.findViewById(R.id.btn_pharmacy);
        btn_home_remedies = myView.findViewById(R.id.btn_home_remedies);
        covid_assessment = myView.findViewById(R.id.covid_assessment);
        recyclerview_videos = myView.findViewById(R.id.recyclerview_videos);
        /*if (pref.getIsPolicyStatus().equalsIgnoreCase("false")) {
            wyh_btn.setVisibility(View.GONE);
        } else {
            wyh_btn.setVisibility(View.VISIBLE);
        }*/

        assert getArguments() != null;
        String hidevalue = getArguments().getString("hidevalue");
        assert hidevalue != null;
        if (hidevalue.equalsIgnoreCase("1")) {
            View targetView = myView.findViewById(R.id.services);
            targetView.getParent().requestChildFocus(targetView, targetView);
        } else {
            rl_diet_chart.setVisibility(View.GONE);
            rl_water_chart.setVisibility(View.VISIBLE);
            rl_activity_chart.setVisibility(View.VISIBLE);
            rl_weight_chart.setVisibility(View.GONE);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setcaloriegoal() {
        double bmr=0.0, height_cms2=0.0, tdee = 0;
      /*  double feet2 = Double.parseDouble(pref.getfeet());
        double inches2 = Double.parseDouble(pref.getinches());
        height_cms2 = (feet2 * 30.48) + (inches2 * 2.54);
        if (pref.getgender().equalsIgnoreCase("Male")) {
            bmr = (10 * Double.parseDouble(pref.getweight())) + (6.25 * height_cms2) - (5 * Double.parseDouble(pref.getAge())) + 5;
        } else {
            bmr = (10 * Double.parseDouble(pref.getweight())) + (6.25 * height_cms2) - (5 * Double.parseDouble(pref.getAge())) - 161;
        }
        if (pref.getDailyactivity().equalsIgnoreCase("No Exercise")) {
            tdee = bmr * 1.2;
        } else if (pref.getDailyactivity().equalsIgnoreCase("Light Exercise")) {
            tdee = bmr * 1.375;
        } else if (pref.getDailyactivity().equalsIgnoreCase("Moderate Exercise")) {
            tdee = bmr * 1.55;
        } else if (pref.getDailyactivity().equalsIgnoreCase("Heavy Exercise")) {
            tdee = bmr * 1.725;
        } else if (pref.getDailyactivity().equalsIgnoreCase("Very Heavy Exercise")) {
            tdee = bmr * 1.9;
        }
        pref.setcaloriegoal(String.valueOf((int) tdee));*/
        if (pref.getfeet().equals("")){
           Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
        }else if (pref.getinches().equals("")){
           Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
        }else {
            double feet2 = Double.parseDouble(pref.getfeet());
            double inches2 = Double.parseDouble(pref.getinches());
            height_cms2 = (feet2 * 30.48) + (inches2 * 2.54);

            Log.e("bmr1", String.valueOf(bmr));
            if (pref.getgender().equalsIgnoreCase("Male")) {
                if (!pref.getAge().equals("")){
                    bmr = (10 * Double.parseDouble(pref.getweight())) + (6.25 * height_cms2) - (5 * Double.parseDouble(pref.getAge())) + 5;
                    Log.e("bmr2", String.valueOf(bmr));
                }
            } else {
                if (!pref.getAge().equals("")){
                    bmr = (10 * Double.parseDouble(pref.getweight())) + (6.25 * height_cms2) - (5 * Double.parseDouble(pref.getAge())) - 161;
                    Log.e("bmr3", String.valueOf(bmr));
                }
            }
            if (pref.getDailyactivity().equalsIgnoreCase("No Exercise")) {
                tdee = bmr * 1.2;
            } else if (pref.getDailyactivity().equalsIgnoreCase("Light Exercise")) {
                tdee = bmr * 1.375;
            } else if (pref.getDailyactivity().equalsIgnoreCase("Moderate Exercise")) {
                tdee = bmr * 1.55;
            } else if (pref.getDailyactivity().equalsIgnoreCase("Heavy Exercise")) {
                tdee = bmr * 1.725;
            } else if (pref.getDailyactivity().equalsIgnoreCase("Very Heavy Exercise")) {
                tdee = bmr * 1.9;
            }

            pref.setcaloriegoal(String.valueOf((int) tdee));
        }

    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.GET_PROFILE_DETAIL) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_PROFILE_DETAIL, this, RequestHealthConstants.GET_PROFILE_DETAIL);
            req.execute();
        } else if (id == RequestHealthConstants.GET_DASHBOARD_DATA) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("Date", selected_date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_DASHBOARD_DATA, this, RequestHealthConstants.GET_DASHBOARD_DATA);
            req.execute();
        } else if (id == RequestHealthConstants.GET_BLOG) {
            JSONObject object = new JSONObject();
            try {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("Year", year);
                object.put("Month", month);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_BLOG, this, RequestHealthConstants.GET_BLOG);
            req.execute();
        } else if (id == RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST, this, RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST, this, RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_MEDICINE_VENDOR_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_MEDICINE_VENDOR_LIST, this, RequestHealthConstants.GET_MEDICINE_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_LAB_TEST_VENDOR_LIST, this, RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST, this, RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST);
            req.execute();
        }
    }
    private void hitblogs() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.GET_CONTENT, this, RequestConstants.GET_CONTENT);
        req.execute();
    }
    private void initListeners() {
        rl_activity_chart.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Activity tracker", "User clicked on view exercise activity stats");
            checkIfLoggedIn();
        });

        log_activity.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Activity tracker", "User clicked on log exercise activity tracker");
            replaceFragment(new FragmentLogActivity(), FragmentsHealthTags.FRAGMENT_LOG_ACTIVITY);
        });

        rl_diet_chart.setOnClickListener(view -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Activity tracker", "User clicked on log food activity tracker");
            replaceFragment(new FoodIntakeMainTab(), FragmentsHealthTags.FRAGMENT_FOOD_TRACKING);
        });

        rl_water_chart.setOnClickListener(view -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Activity tracker", "User clicked on log water activity tracker");
            replaceFragment(new WaterIntakeMainTab(), FragmentsHealthTags.FRAGMENT_WATER_TRACKING);
        });

        rl_weight_chart.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Activity tracker", "User clicked on log weight activity tracker");
            replaceFragment(new WeightLogMainTab(), FragmentsHealthTags.FRAGMENT_WEIGHT_LOG);
        });

        wyh_btn.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User clicked on WYH care programs tab");
            callWYHLoginApi();
        });
        openTravelInsurance.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TravelInsurance.class);
            startActivity(intent);
        });
        rl_buy_policy_btn.setOnClickListener(v -> {

//            Intent intent = new Intent(getActivity(), CalculatorPlanType.class);
//            intent.putExtra("strFor","0");
//            intent.putExtra("strNewFor","0");
//            intent.putExtra("CheckString","0");
//            startActivity(intent);

            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Buy Policy", "User clicked on buy policy button");
            replaceFragment(new BuyPolicyMenu(), FragmentsHealthTags.FRAGMENT_HEALTH_BUY_POLICY);
        });

        insurance_wallet.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User clicked on insurance vault tab");
            replaceFragment(new MyPolicyTab(), FragmentsHealthTags.FRAGMENT_HEALTH_POLICY);
        });

        rl_hra.setOnClickListener(view -> {
            // replaceFragment(new FragmentRiskProfile(), FragmentsHealthTags.FRAGMENT_RISK_PROFILE);
            new AppDataPushApi().callApi(getActivity(), "Risk Profile", "Risk profile page", "User clicked on symptom HRA");
            boolean result_true = db2.CheckIsInterviewIdDataAlreadyInDBorNot(pref.getUID(), pref.getSymptominterviewid());
            if (result_true) {
                String username = pref.getUserName();
                String[] arr = username.split(" ", 2);
                String userfirstname = arr[0];
                Random ran = new Random();
                String code = String.valueOf((100000 + ran.nextInt(900000)));
                interviewid = userfirstname + "_" + code;
                callApiSymptom();
            } else {
                int no_of_data = db.getBasicSymptomCount();
                if (no_of_data != 0) {
                    Fragment frag1 = new FragmentSymptonReports();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag1, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
                    binder.detect(FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
                } else {
                    String username = pref.getUserName();
                    String[] arr = username.split(" ", 2);
                    String userfirstname = arr[0];
                    Random ran = new Random();
                    String code = String.valueOf((100000 + ran.nextInt(900000)));
                    interviewid = userfirstname + "_" + code;
                    callApiSymptom();
                }
            }
        });
        statusCheck();

//        wellness_package.setOnClickListener(v ->callApi(RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST) );
        wellness_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 44);
                    getCurrentLocation();
                    callApi(RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST);
                } else {
                    statusCheck();
                }




//                if (bestProvider.equals("")){
//
//                }else {
//                    getCurrentLocation();
//                    callApi(RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST);
//                }


            }
        });

//        search_doctor.setOnClickListener(v -> callApi(RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST));
        search_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 44);
                    getCurrentLocation();
                    callApi(RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST);
                } else {
                    statusCheck();
                }
            }
        });

        rl_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 44);
                    getCurrentLocation();
                    callApi(RequestHealthConstants.GET_MEDICINE_VENDOR_LIST);
                } else {
                    statusCheck();
                }
            }
        });


//        rl_medicine.setOnClickListener(v -> callApi(RequestHealthConstants.GET_MEDICINE_VENDOR_LIST));

//        r1_lab_test.setOnClickListener(v -> callApi(RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST));

        r1_lab_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, 44);
                    getCurrentLocation();
                    callApi(RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST);

                } else {
                    statusCheck();
                }
            }
        });


        homecare.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User visited to check for homecare services");
            replaceFragment(new TypesOfHomecare(), FragmentsHealthTags.FRAGMENT_HOMECARE);
        });

        health_packages.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User checked for wellness packages of vhealth");
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("title", "Wellness Packages");
            intent.putExtra("URL", "https://vhealth.io/");
            intent.putExtra("domain", "vhealth.io");
            intent.putExtra("name", "Wellness Packages");
            intent.putExtra("VendorId", "1");
            intent.putExtra("VehicleType", "Wellness Packages");
            startActivity(intent);
        });

        emotional_wellness.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User checked for emotional wellness of juno clinic");
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("title", "Emotional Wellness");
            intent.putExtra("URL", "https://www.juno.clinic/");
            intent.putExtra("domain", "juno.clinic");
            intent.putExtra("name", "Juno Clinic");
            intent.putExtra("VendorId", "1");
            intent.putExtra("VehicleType", "Emotional Wellness");
            startActivity(intent);
        });

        spiritual_wellness.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User checked for spiritual wellness of speaking tree");
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("title", "Spiritual Wellness");
            intent.putExtra("URL", "https://www.speakingtree.in/masters");
            intent.putExtra("domain", "speakingtree.in");
            intent.putExtra("name", "Speaking Tree");
            intent.putExtra("VendorId", "1");
            intent.putExtra("VehicleType", "Spiritual Wellness");
            startActivity(intent);
        });

        healthy_living.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User checked for healthy living of webmd");
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("title", "Healthy Living");
            intent.putExtra("URL", "https://www.webmd.com/living-healthy");
            intent.putExtra("domain", "webmd.com");
            intent.putExtra("name", "Webmd");
            intent.putExtra("VendorId", "1");
            intent.putExtra("VehicleType", "Healthy Living");
            startActivity(intent);
        });

        ayush_medicine.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User checked ayush medicine of netmeds");
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("title", "Ayush Medicine");
            intent.putExtra("URL", "https://www.netmeds.com/non-prescriptions/ayush");
            intent.putExtra("domain", "netmeds.com");
            intent.putExtra("name", "Netmeds");
            intent.putExtra("VendorId", "1");
            intent.putExtra("VehicleType", "Ayush Medicine");
            startActivity(intent);
        });

        baby_caring_parenting.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User clicked on baby care of babychakra");
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("title", "Baby Care");
            intent.putExtra("URL", "https://www.babychakra.com/?utm_source=Zoi%20Technology&utm_medium=Zoi");
            intent.putExtra("domain", "babychakra.com");
            intent.putExtra("name", "Baby Care");
            intent.putExtra("VendorId", "1");
            intent.putExtra("VehicleType", "Baby Chakra");
            startActivity(intent);
        });

//        loan_secure.setOnClickListener(v -> {
//            Intent intent = new Intent(getActivity(), Web_Loan.class);
//            Objects.requireNonNull(getActivity()).startActivity(intent);
//        });
        renew_health.setOnClickListener(v -> {

            Intent intent=new Intent(getActivity(),Health_Insurance_Renewal.class);
            intent.putExtra("strFor","0");
            getActivity().startActivity(intent);

//            Intent intent = new Intent(getActivity(), Web_Loan.class);
//            intent.putExtra("policy_health_url", "https://www.universalsompo.com/health-renewal");
//            intent.putExtra("text_nm", "Health Insurance Renewal");
//            getActivity().startActivity(intent);
        });

        buy_covid_kavach.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("URL", "https://www.universalsompo.com/Complete-health/default?WACode=20000001&AppCode=30000007&IMDCode=11111111&MobileNo=" + pref.getMOBILE());
            intent.putExtra("name", "Universal Sompo");
            intent.putExtra("domain", "universalsompo.com");
            intent.putExtra("VendorId", "");
            intent.putExtra("VehicleType", "");
            intent.putExtra("ModuleType", "");
            intent.putExtra("title", "Arogya Sanjeevani");
            Objects.requireNonNull(getActivity()).startActivity(intent);
        });

        covid_assessment.setOnClickListener(v -> replaceFragment(new FragmentCovidAssessment(), FragmentsHealthTags.FRAGMENT_COVID_ASSESSMENT));

        btn_covid_call.setOnClickListener(v -> callUsDialog());

        btn_teleconsultation.setOnClickListener(v -> {
            callDialog();
        });

        btn_testing_labs.setOnClickListener(v -> {
//            LocatorIconActionPerform("covid+testing+labs", "Nearby Testing Labs");

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                LocatorIconActionPerform("covid+testing+labs", "Nearby Testing Labs");
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
            }
//
//            if (gps_button_tru.equals(false)){
//                statusCheck();
//            }else {
//            }

        });

        btn_mind_therapist.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("URL", "https://yourdost.com/coronavirus/emotionalwellness");
            intent.putExtra("name", "Mind Therapist");
            intent.putExtra("domain", "yourdost.com");
            intent.putExtra("VendorId", "");
            intent.putExtra("VehicleType", "");
            intent.putExtra("ModuleType", "");
            Objects.requireNonNull(getActivity()).startActivity(intent);
        });

        btn_pharmacy.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), BookDriver.class);
            intent.putExtra("URL", "https://www.netmeds.com/non-prescriptions/covid-essentials");
            intent.putExtra("name", "Pharmacies");
            intent.putExtra("domain", "netmeds.com");
            intent.putExtra("VendorId", "");
            intent.putExtra("VehicleType", "");
            intent.putExtra("ModuleType", "");
            Objects.requireNonNull(getActivity()).startActivity(intent);
        });

        btn_home_remedies.setOnClickListener(v -> replaceFragment(new FragmentHomeRemedies1(), FragmentsHealthTags.FRAGMENT_HOME_REMEDIES));
    }

    private void LocatorIconActionPerform(String Tag, String Title) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equals("Garage")) {
                Intent in = new Intent(getActivity(), GarageListActivity.class);
                startActivity(in);
            } else {
                System.gc();
                Intent in = new Intent(getActivity(), GoogleMapPlacesActivity.class);
                in.putExtra("key", Tag);
                in.putExtra("title", Title);
                in.putExtra("type", "");
                startActivity(in);
            }
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_LONG).show();
        }
    }

    void callUsDialog() {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.callus_dialog);

        TextView txt_no = dialog.findViewById(R.id.tvmobnumber);
        TextView dialog_heading = dialog.findViewById(R.id.dialog_heading);
        dialog_heading.setText(getResources().getString(R.string.covid_helpline));
        txt_no.setText(getResources().getString(R.string.covid_support_number));
        TextView call = dialog.findViewById(R.id.tvcall);
        TextView cancel = dialog.findViewById(R.id.tvcancel);
        cancel.setOnClickListener(v -> dialog.dismiss());

        call.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "011-23978046"));
            startActivity(intent);
            dialog.dismiss();
        });
        dialog.show();
    }

    private void callDialog() {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.callus_dialog);

        TextView txt_no = dialog.findViewById(R.id.tvmobnumber);
        TextView dialog_heading = dialog.findViewById(R.id.dialog_heading);
        dialog_heading.setText(getResources().getString(R.string.step_one_helpline));
        txt_no.setText(getResources().getString(R.string.step_one_number));
        TextView call = dialog.findViewById(R.id.tvcall);
        TextView cancel = dialog.findViewById(R.id.tvcancel);
        cancel.setOnClickListener(v -> dialog.dismiss());

        call.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "9745697456"));
            startActivity(intent);
            dialog.dismiss();
        });
        dialog.show();
    }

    private void callApiSymptom() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("InterviewID", interviewid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID, this, RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID);
        req.execute();
    }

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsHealthTags.FRAGMENT_HEALTH_POLICY)) {
                Bundle args = new Bundle();
                args.putInt("otherFrag", 1);
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void replaceFragment1(Fragment frag, String Tag, String type) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("type", type);
            args.putString("state", state);
            args.putString("city", city);
            args.putString("id", "0");
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void replaceFragment2(Fragment frag, String id) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("id", id);
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_COUPON_CODE);
            binder.detect(FragmentsHealthTags.FRAGMENT_COUPON_CODE);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success") || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User do not find any vendor for wellness center");
                    showAlertDialog("Wellness Center");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }
                        new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User visited " + wellness_name);
                        URL url = new URL(wellness_url);
                        String host = url.getHost();
                        Intent intent = new Intent(getActivity(), BookDriver.class);
                        intent.putExtra("title", "Wellness Center");
                        intent.putExtra("URL", wellness_url);
                        intent.putExtra("domain", host);
                        intent.putExtra("name", wellness_name);
                        intent.putExtra("VendorId", wellness_id);
                        intent.putExtra("VehicleType", "Wellness Center");
                        startActivity(intent);
                    } catch (JSONException | MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User navigates to list of vendors of wellness center");
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_WELLNESS_CENTER_HISTORY, "Wellness Center");
                }
            }
        } else if (Tag == RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success") || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User do not find any vendor for doctor consultation");
                    showAlertDialog("Doctor Consultation");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }
                        new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User visited " + wellness_name);
                        URL url = new URL(wellness_url);
                        String host = url.getHost();
                        Intent intent = new Intent(getActivity(), BookDriver.class);
                        intent.putExtra("title", "Doctor Consultation");
                        intent.putExtra("URL", wellness_url);
                        intent.putExtra("domain", host);
                        intent.putExtra("name", wellness_name);
                        intent.putExtra("VendorId", wellness_id);
                        intent.putExtra("VehicleType", "Doctor Consultation");
                        startActivity(intent);
                    } catch (JSONException | MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User navigates to list of vendors of doctor consultation");
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_DOCTOR_APPOINTMENT_HISTORY, "Doctor Consultation");
                }
            }
        } else if (Tag == RequestHealthConstants.GET_MEDICINE_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success") || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User do not find any vendor for medicines");
                    showAlertDialog("Medicines");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }
                        new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User visited " + wellness_name);
                        URL url = new URL(wellness_url);
                        String host = url.getHost();
                        Intent intent = new Intent(getActivity(), BookDriver.class);
                        intent.putExtra("title", "Medicines");
                        intent.putExtra("URL", wellness_url);
                        intent.putExtra("domain", host);
                        intent.putExtra("name", wellness_name);
                        intent.putExtra("VendorId", wellness_id);
                        intent.putExtra("VehicleType", "Medicine");
                        startActivity(intent);
                    } catch (JSONException | MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User navigates to list of vendors of medicine");
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_MEDICINE_ORDER_HISTORY, "Medicine");
                }
            }
        } else if (Tag == RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success") || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User do not find any vendor for lab test");
                    showAlertDialog("Lab Test");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }
                        if (wellness_name.equalsIgnoreCase("1mg")) {
                            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User navigates to coupon page for vendor " + wellness_name);
                            replaceFragment2(new FragmentCouponCode(), wellness_id);
                        } else {
                            try {
                                new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User visited " + wellness_name);
                                URL url = new URL(wellness_url);
                                String host = url.getHost();
                                Intent intent = new Intent(getActivity(), BookDriver.class);
                                intent.putExtra("title", "Lab Test");
                                intent.putExtra("URL", wellness_url);
                                intent.putExtra("domain", host);
                                intent.putExtra("name", wellness_name);
                                intent.putExtra("VendorId", wellness_id);
                                intent.putExtra("VehicleType", "Health Packages");
                                startActivity(intent);
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User navigates to list of vendors of lab test");
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_LAB_TESTS_HISTORY, "Lab Test");
                }
            }
        } else if (Tag == RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success") || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User do not find any vendor for health packages");
                    showAlertDialog("Wellness Packages");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }
                        new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User visited " + wellness_name);
                        URL url = new URL(wellness_url);
                        String host = url.getHost();
                        Intent intent = new Intent(getActivity(), BookDriver.class);
                        intent.putExtra("title", "Health Packages");
                        intent.putExtra("URL", wellness_url);
                        intent.putExtra("domain", host);
                        intent.putExtra("name", wellness_name);
                        intent.putExtra("VendorId", wellness_id);
                        intent.putExtra("VehicleType", "Health Packages");
                        startActivity(intent);
                    } catch (JSONException | MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User navigates to list of vendors of health packages");
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_HEALTH_PACKAGES_HISTORY, "Health Packages");
                }
            }
        } else if (Tag == RequestHealthConstants.GET_PROFILE_DETAIL) {
            if (object.optString("Message").equals("Success")) {
                if (object.optString("EmergencyContactNo").length() == 0 && object.optString("EmergencyContactPersonaName").length() == 0 && object.optString("Height").length() == 0 && object.optString("Weight").length() == 0) {
//                    showDialog();
                } else {
                    if (!object.optString("Height").equals("")) {
                        String height = object.optString("Height");
                        String[] parts = height.split("\\'");
                        String feet_txt = parts[0];
                        String inches_txt = parts[1];
                        pref.setfeet(feet_txt);
                        pref.setinches(inches_txt);
                    } else {
                        pref.setfeet(null);
                        pref.setinches(null);
                    }

                    if (!object.optString("Weight").equals("")) {
                        pref.setweight(object.optString("Weight"));
                    } else {
                        pref.setweight(null);
                    }

                    if (!object.optString("DailyActivity").equals("")) {
                        pref.setDailyactivity(object.optString("DailyActivity"));
                    } else {
                        pref.setDailyactivity(null);
                    }

                    if (!object.optString("EmergencyContactNo").equals("")) {
                        pref.setEmergencyContactNumber(object.optString("EmergencyContactNo"));
                    } else {
                        pref.setEmergencyContactNumber(null);
                    }

                    if (!object.optString("EmergencyContactPersonaName").equals("")) {
                        pref.setEmergencyContactName(object.optString("EmergencyContactPersonaName"));
                    } else {
                        pref.setEmergencyContactName(null);
                    }

                    setcaloriegoal();
                    pref.setWaterGlassTarget("8");
                    pref.setTargetweight(object.optString("Weight"));
                    pref.setlossgain_txt("");
                    pref.setlossgain("");
                    getcurrentdate();
                }
            }
        } else if (Tag == RequestHealthConstants.GET_BLOG) {
            if (object.optString("Message").equals("Success")) {
                new AppDataPushApi().callApi(getActivity(), "Blogs", "Blogs list", "Blogs loaded on dashboard");
                blog_section.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!blog1.isEmpty())
                    blog1.clear();
                try {
                    arr = object.getJSONArray("BlogMasterRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        String imgPath = obj.optString("ImagePath");
                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                        }*/
                        blog1.add(
                                new Blog(
                                        obj.optString("BlogHeading"),
                                        obj.optString("BlogID"),
                                        imgPath
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    blog_list.setLayoutManager(layoutManager);
                    MyBlogAdapter myblogAdapter = new MyBlogAdapter(getActivity(), blog1);
                    blog_list.setAdapter(myblogAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                new AppDataPushApi().callApi(getActivity(), "Dashboard", "Blogs list", "Blogs not loaded on dashboard");
                blog_section.setVisibility(View.GONE);
            }
        } else if (Tag == RequestHealthConstants.GET_DASHBOARD_DATA) {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Activity tracker", "Users activity tracker data filled in dashboard");
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                try {
                    /* Current Exercise Data */
                    String exercise_goal1 = object.optString("ExerciseGoal");
                    String[] part_exercise_goal = exercise_goal1.split(" ");
                    String exercise_goal_value = part_exercise_goal[0];
                    if (exercise_goal_value.equalsIgnoreCase("0")) {
                        exercise_goal.setText("Exercise Goal - Burn " + (int) (Double.parseDouble(pref.getcaloriegoal()) / 5) + " Calories");
                    } else {
                        exercise_goal.setText("Exeercise Goal " + (int) (Double.parseDouble(exercise_goal_value)) + " Calories");
                    }

                    FitnessOptions fitnessOptions = FitnessOptions.builder()
                            .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                            .build();
                    if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(Objects.requireNonNull(getActivity())), fitnessOptions)) {
                        readdata(object);
                    } else if (pref.getFibitUserId() != null) {
                        callFitBitData(object);
                    } else {
                        setProgressDataforExercise(object);
                    }

                    /* Current Diet */
                    String diet_goal = object.optString("DietGoal");
                    String[] part_diet_goal = diet_goal.split(" ");
                    String diet_goal_value = part_diet_goal[0];
                    if (diet_goal_value.equalsIgnoreCase("0")) {
                        calorie_goal2.setText("Diet Goal " + (int) (Double.parseDouble(pref.getcaloriegoal())) + " Calories");
                    } else {
                        calorie_goal2.setText("Diet Goal " + (int) (Double.parseDouble(diet_goal_value)) + " Calories");
                    }

                    String diet_left = object.optString("DietBurn");
                    String[] part_diet_taken = diet_left.split(" ");
                    String diet_taken_value = part_diet_taken[0];
                    if (diet_taken_value.equalsIgnoreCase("0")) {
                        total_diet_consumed.setText("Consumed 0");
                    } else {
                        total_diet_consumed.setText("Consumed " + (int) (Double.parseDouble(diet_taken_value)));
                    }

                    int diet_goal_pref = (int) Double.parseDouble(pref.getcaloriegoal());
                    String diet_taken = object.optString("DietBurn");
                    String[] part_diet_taken1 = diet_taken.split(" ");
                    String diet_taken_value1 = part_diet_taken1[0];
                    int diet_taken_value_int = (int) Double.parseDouble(diet_taken_value1);
                    if (diet_taken_value1.equalsIgnoreCase("0")) {
                        simpleProgressBar.setProgress(0);
                        tick_2.setVisibility(View.GONE);
                        total_diet.setText("Left " + (int) (Double.parseDouble(pref.getcaloriegoal())));
                    } else {
                        if (diet_taken_value_int < diet_goal_pref) {
                            int curr_diff = diet_goal_pref - diet_taken_value_int;
                            double curr_per = (diet_taken_value_int * 100) / diet_goal_pref;
                            simpleProgressBar.setProgress((int) curr_per);
                            tick_2.setVisibility(View.GONE);
                            total_diet.setText("Left " + (int) curr_diff);
                        } else {
                            simpleProgressBar.setProgress(100);
                            tick_2.setVisibility(View.VISIBLE);
                            total_diet.setText("Goal Achieved");
                        }
                    }

                    /* Current Water */
                    String water_goal_value = pref.getWaterGlassTarget();
                    if (water_goal_value != null) {
                        water_goal.setText("Water Goal " + water_goal_value + " Glasses");
                    } else {
                        String water_goal_value_server = object.optString("WaterGoal");
                        String[] part_water_goal = water_goal_value_server.split(" ");
                        String water_goal_value1 = part_water_goal[0];
                        water_goal.setText("Water Goal " + water_goal_value1 + " Glasses");
                    }

                    String water_taken = object.optString("WaterBurn");
                    String[] part_water_taken = water_taken.split(" ");
                    String water_taken_value = part_water_taken[0];
                    double water_taken_double = Double.parseDouble(water_taken_value) / 0.250;
                    int water_taken_int = (int) water_taken_double;
                    if (water_taken_value.equalsIgnoreCase("0")) {
                        total_water_consumed.setText("Taken 0");
                    } else {
                        total_water_consumed.setText("Taken " + water_taken_int);
                    }

                    int water_goal_pref = (int) Double.parseDouble(pref.getWaterGlassTarget());
                    String water_left = object.optString("WaterBurn");
                    String[] part_water_left = water_left.split(" ");
                    String water_left_value1 = part_water_left[0];
                    double water_left_value_double = Double.parseDouble(water_left_value1);
                    double no_of_glasses = water_left_value_double / 0.250;
                    int no_of_glasses_int = (int) no_of_glasses;
                    if (water_left_value1.equalsIgnoreCase("0")) {
                        water_progress.setProgress(0);
                        tick_3.setVisibility(View.GONE);
                        total_water.setText("Left 8");
                    } else {
                        if (no_of_glasses_int < water_goal_pref) {
                            int curr_diff = water_goal_pref - no_of_glasses_int;
                            double curr_per = (no_of_glasses_int * 100) / water_goal_pref;
                            water_progress.setProgress((int) curr_per);
                            tick_3.setVisibility(View.GONE);
                            total_water.setText("Left " + curr_diff);
                        } else {
                            water_progress.setProgress(100);
                            tick_3.setVisibility(View.VISIBLE);
                            total_water.setText("Goal Achieved");
                        }
                    }

                    /* Current Weight */
                    if (object.optString("WeightGoal").equalsIgnoreCase("0")) {
                        String weight_goal_pref = pref.getTargetweight();
                        if (weight_goal_pref != null) {
                            weight_goal.setText("Weight Goal " + weight_goal_pref + " kg");
                        } else {
                            weight_goal.setText("Weight Goal " + pref.getweight() + " kg");
                        }
                    } else {
                        weight_goal.setText("Weight Goal " + object.optString("WeightGoal") + " kg");
                    }

                    if (object.optString("WeightTargetLoseGain").equalsIgnoreCase("0") && object.optString("WeightTargetLoseGainBy").equalsIgnoreCase("0")) {
                        String loss_gain_txt = pref.getlossgain_txt();
                        String loss_gain_value1 = pref.getlossgain();

                        if (loss_gain_txt != null && loss_gain_value1 != null && !loss_gain_txt.equalsIgnoreCase("") && !loss_gain_value1.equalsIgnoreCase("")) {
                            if (loss_gain_txt.equalsIgnoreCase("Lose")) {
                                loss_gain_value.setText("Loose " + loss_gain_value1 + " Kg");
                            } else {
                                loss_gain_value.setText("Gain " + loss_gain_value1 + " Kg");
                            }
                        } else {
                            loss_gain_value.setVisibility(View.GONE);
                        }
                    } else {
                        if (object.optString("WeightTargetLoseGain").equalsIgnoreCase("Lose")) {
                            loss_gain_value.setText("Loose " + object.optString("WeightTargetLoseGainBy") + " Kg");
                        } else {
                            loss_gain_value.setText("Gain " + object.optString("WeightTargetLoseGainBy") + " Kg");
                        }
                    }

                    double curr_weight_burn1 = Double.parseDouble(object.optString("WeightBurn"));
                    double curr_weight_goal1 = Double.parseDouble(object.getString("WeightGoal"));
                    String curr_loss_gain_text = object.getString("WeightTargetLoseGain");
                    double curr_target_loss_gain = Double.parseDouble(object.optString("WeightTargetLoseGainBy"));
                    if (curr_weight_burn1 != 0) {
                        if (curr_loss_gain_text.equalsIgnoreCase("Lose")) {
                            if (curr_weight_burn1 < curr_weight_goal1) {
                                weight_progress.setProgress(100);
                                double curr_weight_diff = curr_weight_goal1 - curr_weight_burn1;
                                double curr_weight_add = curr_target_loss_gain + curr_weight_diff;
                                weight_burn.setText("Lost " + curr_weight_add + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            } else if (curr_weight_burn1 > curr_weight_goal1) {
                                double curr_weight_diff1 = curr_weight_burn1 - curr_weight_goal1;
                                if (curr_weight_diff1 > curr_target_loss_gain) {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Lost 0");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_weight_diff1 + " Kg");
                                } else if (curr_weight_diff1 < curr_target_loss_gain) {
                                    double curr_weight_diff2 = curr_target_loss_gain - curr_weight_diff1;
                                    double curr_weight_diff3 = curr_target_loss_gain - curr_weight_diff2;
                                    double curr_weight_per = (curr_weight_diff2 / curr_target_loss_gain) * 100;
                                    weight_progress.setProgress((int) curr_weight_per);
                                    tick_4.setVisibility(View.GONE);
                                    weight_burn.setText("Lost " + curr_weight_diff2 + " Kg");
                                    weight_left.setText("Left " + curr_weight_diff3 + " Kg");
                                } else {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Lost 0 Kg");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_weight_diff1 + " Kg");
                                }
                            } else {
                                weight_progress.setProgress(100);
                                weight_burn.setText("Lost " + curr_target_loss_gain + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            }
                        } else {
                            if (curr_weight_burn1 < curr_weight_goal1) {
                                double curr_gain_weight_diff1 = curr_weight_goal1 - curr_weight_burn1;
                                if (curr_gain_weight_diff1 < curr_target_loss_gain) {
                                    double curr_weight_diff4 = curr_target_loss_gain - curr_gain_weight_diff1;
                                    double curr_weight_diff5 = curr_target_loss_gain - curr_weight_diff4;
                                    double curr_gain_weight_per = (curr_weight_diff4 / curr_target_loss_gain) * 100;
                                    weight_progress.setProgress((int) curr_gain_weight_per);
                                    tick_4.setVisibility(View.GONE);
                                    weight_burn.setText("Gained " + curr_weight_diff4 + " Kg");
                                    weight_left.setText("Left " + curr_weight_diff5 + " Kg");
                                } else if (curr_gain_weight_diff1 > curr_target_loss_gain) {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Gained 0 Kg");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_gain_weight_diff1 + " Kg");
                                } else {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Gained 0 Kg");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_gain_weight_diff1 + " Kg");
                                }
                            } else if (curr_weight_burn1 > curr_weight_goal1) {
                                double curr_gain_weight_diff = curr_weight_burn1 - curr_weight_goal1;
                                double curr_gain_add_weight_diff = curr_target_loss_gain + curr_gain_weight_diff;
                                weight_progress.setProgress(100);
                                weight_burn.setText("Gained " + curr_gain_add_weight_diff + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            } else {
                                weight_progress.setProgress(100);
                                weight_burn.setText("Gained " + curr_target_loss_gain + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            }
                        }
                    } else {
                        double curr_weight_burn2 = Double.parseDouble(pref.getweight());
                        double curr_weight_goal2 = Double.parseDouble(pref.getTargetweight());
                        String curr_loss_gain_text1 = pref.getlossgain_txt();
                        double curr_target_loss_gain1 = Double.parseDouble(pref.getlossgain());
                        if (curr_loss_gain_text1.equalsIgnoreCase("Lose")) {
                            if (curr_weight_burn2 < curr_weight_goal2) {
                                weight_progress.setProgress(100);
                                double curr_weight_diff1 = curr_weight_goal2 - curr_weight_burn2;
                                double curr_weight_add1 = curr_target_loss_gain1 + curr_weight_diff1;
                                weight_burn.setText("Lost " + curr_weight_add1 + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            } else if (curr_weight_burn2 > curr_weight_goal2) {
                                double curr_weight_diff2 = curr_weight_burn2 - curr_weight_goal2;
                                if (curr_weight_diff2 > curr_target_loss_gain1) {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Lost 0");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_weight_diff2 + " Kg");
                                } else if (curr_weight_diff2 < curr_target_loss_gain1) {
                                    double curr_weight_diff3 = curr_target_loss_gain1 - curr_weight_diff2;
                                    double curr_weight_per1 = (curr_weight_diff3 / curr_target_loss_gain1) * 100;
                                    weight_progress.setProgress((int) curr_weight_per1);
                                    tick_4.setVisibility(View.GONE);
                                    weight_burn.setText("Lost " + curr_weight_diff3 + " Kg");
                                    weight_left.setText("Left " + curr_weight_diff2 + " Kg");
                                } else {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Lost 0 Kg");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_weight_diff2 + " Kg");
                                }
                            } else {
                                weight_progress.setProgress(100);
                                weight_burn.setText("Lost " + curr_target_loss_gain1 + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            }
                        } else {
                            if (curr_weight_burn2 < curr_weight_goal2) {
                                double curr_gain_weight_diff2 = curr_weight_goal2 - curr_weight_burn2;
                                if (curr_gain_weight_diff2 < curr_target_loss_gain1) {
                                    double curr_weight_diff5 = curr_target_loss_gain1 - curr_gain_weight_diff2;
                                    double curr_weight_diff6 = curr_target_loss_gain1 - curr_weight_diff5;
                                    double curr_gain_weight_per1 = (curr_weight_diff5 / curr_target_loss_gain1) * 100;
                                    weight_progress.setProgress((int) curr_gain_weight_per1);
                                    tick_4.setVisibility(View.GONE);
                                    weight_burn.setText("Gained " + curr_weight_diff5 + " Kg");
                                    weight_left.setText("Left " + curr_weight_diff6 + " Kg");
                                } else if (curr_gain_weight_diff2 > curr_target_loss_gain1) {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Gained 0 Kg");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_gain_weight_diff2 + " Kg");
                                } else {
                                    weight_progress.setProgress(0);
                                    weight_burn.setText("Gained 0 Kg");
                                    tick_4.setVisibility(View.GONE);
                                    weight_left.setText("Left " + curr_gain_weight_diff2 + " Kg");
                                }
                            } else if (curr_weight_burn2 > curr_weight_goal2) {
                                double curr_gain_weight_diff1 = curr_weight_burn2 - curr_weight_goal2;
                                double curr_gain_add_weight_diff1 = curr_target_loss_gain1 + curr_gain_weight_diff1;
                                weight_progress.setProgress(100);
                                weight_burn.setText("Gained " + curr_gain_add_weight_diff1 + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            } else {
                                weight_progress.setProgress(100);
                                weight_burn.setText("Gained " + curr_target_loss_gain1 + " Kg");
                                tick_4.setVisibility(View.VISIBLE);
                                weight_left.setText("Goal Achieved");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (Tag == RequestConstants.GET_SLIDER_IMAGE) {
            if (object.optString("Message").equals("Success")) {
                pref.setProfilePic(object.optString("UserImagePath"));
                Activity activity = getActivity();
                if (isAdded() && activity != null) {
                    ((MainActivityHealth) Objects.requireNonNull(getActivity())).setUserInFoInDrawer(object.optString("UserImagePath"));
                }
            }
        } else if (Tag == RequestHealthConstants.GET_WYH_LOGIN_API) {
            if (object.optString("StatusCode").equalsIgnoreCase("200") && object.optString("Message").equalsIgnoreCase("Authenticated")) {
                try {
                    pref.setWYHAuthToken(object.getString("AuthToken"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                replaceFragment(new FragmentWYHMenu(), FragmentsHealthTags.FRAGMENT_VALUE_ADD);
            } else {
                try {
                    showWYHDialog(object.getString("Message"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (Tag == RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                String date = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());
                pref.setSymptom_interview_id(interviewid);
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_7", "Are you overweight or obese?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_28", "Do you smoke cigarettes?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_10", "Do you have high cholesterol?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_9", "Do you have hypertension?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_8", "Do you have diabetes?", "true", "0", date, "FragmentBasicQuestion");
                replaceFragment(new FragmentBasicQuestion(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
            } else {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
        else if (Tag == RequestConstants.GET_CONTENT) {
            new AppDataPushApi().callApi(getActivity(),"Content","Video section","Checked for uploaded youtub videos");
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("VideoContentDetails");
                    LogUtils.showLog("content", "array size" + arr);
                    final ArrayList<ContentModel> data = new ArrayList<>();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);

                        String imgPath = obj.optString("ThumbnailPath");
                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in/AppCMS" + abc[1];
                        }*/

                        data.add(
                                new ContentModel(
                                        imgPath,
                                        obj.optString("Title"),
                                        obj.optString("UploadedDate"),
                                        obj.optString("Description"),
                                        obj.optString("URL")
                                )
                        );

                    }
                    VideoAdapter content_adapter_ = new VideoAdapter(data, this.getLifecycle());
                    recyclerview_videos.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
                    recyclerview_videos.setHasFixedSize(true);
                    recyclerview_videos.setAdapter(content_adapter_);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(getContext(),object.optString("Message"), Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onError(VolleyError error, int Tag) {
    }

    public void showDialog() {
        LayoutInflater li = LayoutInflater.from(getContext());
        @SuppressLint("InflateParams") View promptsView = li.inflate(R.layout.height_weight_dialog_layout, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder.setCancelable(false);
        final EditText heightfeet = promptsView.findViewById(R.id.et_heightfeet);
        final EditText heightinch = promptsView.findViewById(R.id.et_heightinch);
        final LinearLayout dismissBTN = promptsView.findViewById(R.id.dismiss);
        final EditText weight = promptsView.findViewById(R.id.et_weight);
        final Spinner spinDailyAct = promptsView.findViewById(R.id.spin_dailyact);
        final EditText et_emergency_contact_person_name = promptsView.findViewById(R.id.et_emergency_contact_person_name);
        final EditText et_emergency_contact_person_number = promptsView.findViewById(R.id.et_emergency_contact_person_number);
        Button btnSubmit = promptsView.findViewById(R.id.btn_submit);

        if (pref.getfeet() != null) {
            heightfeet.setText(pref.getfeet());
        } else {
            heightfeet.setText("");
        }

        if (pref.getinches() != null) {
            heightinch.setText(pref.getinches());
        } else {
            heightinch.setText("");
        }

        if (pref.getweight() != null) {
            weight.setText(pref.getweight());
        } else {
            weight.setText("");
        }

        if (pref.getEmergencyContactName() != null) {
            et_emergency_contact_person_name.setText(pref.getEmergencyContactName());
        } else {
            et_emergency_contact_person_name.setText("");
        }

        if (pref.getEmergencyContactNumber() != null) {
            et_emergency_contact_person_number.setText(pref.getEmergencyContactNumber());
        } else {
            et_emergency_contact_person_number.setText("");
        }
        dismissBTN.setOnClickListener(view -> {
            try {
                String Feet = heightfeet.getText().toString();
                String Inch = heightinch.getText().toString();
                String Weight = weight.getText().toString();
                String Exercise = spinDailyAct.getSelectedItem().toString();
                String EmergencyContactName = et_emergency_contact_person_name.getText().toString();
                String EmergencyContactNumber = et_emergency_contact_person_number.getText().toString();
                pref.setfeet(Feet);
                pref.setinches(Inch);
                pref.setweight(Weight);
                pref.setDailyactivity(Exercise);
                pref.setEmergencyContactName(EmergencyContactName);
                pref.setEmergencyContactNumber(EmergencyContactNumber);
                SaveData(Feet, Inch, Weight, Exercise, EmergencyContactName, EmergencyContactNumber);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });
        spinDailyAct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnSubmit.setOnClickListener(view -> {
            try {
//                if (heightfeet.getText().toString().trim().length() <= 0 || Integer.parseInt(heightfeet.getText().toString()) == 0) {
//                    Toast.makeText(getContext(), "Please enter height in feet", Toast.LENGTH_SHORT).show();
//                } else if (heightinch.getText().toString().trim().length() <= 0 || Integer.parseInt(heightinch.getText().toString()) == 0) {
//                    Toast.makeText(getContext(), "Please enter height in inches", Toast.LENGTH_SHORT).show();
//                } else if (weight.getText().toString().trim().length() <= 0) {
//                    Toast.makeText(getContext(), "Please enter weight in kg", Toast.LENGTH_SHORT).show();
//                } else if (spinDailyAct.getSelectedItemPosition() == 0) {
//                    Toast.makeText(getContext(), "Please select daily actvity", Toast.LENGTH_SHORT).show();
//                } else if (et_emergency_contact_person_name.getText().toString().length() <= 0) {
//                    Toast.makeText(getContext(), "Please enter emergency contact person name", Toast.LENGTH_SHORT).show();
//                } else if (et_emergency_contact_person_number.getText().toString().length() <= 0) {
//                    Toast.makeText(getContext(), "Please enter emergency contact person number", Toast.LENGTH_SHORT).show();
//                } else {

                    String Feet = heightfeet.getText().toString();
                    String Inch = heightinch.getText().toString();
                    String Weight = weight.getText().toString();
                    String Exercise = spinDailyAct.getSelectedItem().toString();
                    String EmergencyContactName = et_emergency_contact_person_name.getText().toString();
                    String EmergencyContactNumber = et_emergency_contact_person_number.getText().toString();
                    Feet="5";
                    Inch="5";
                    Weight="55";
                    Exercise="No Exercise";
                    EmergencyContactName="Brother";
                    EmergencyContactNumber="9999999999";
                    heightfeet.setText(Feet);
                    heightinch.setText(Inch);
                    weight.setText(Weight);
                    et_emergency_contact_person_name.setText(EmergencyContactName);
                    et_emergency_contact_person_number.setText(EmergencyContactNumber);
                    pref.setfeet(Feet);
                    pref.setinches(Inch);
                    pref.setweight(Weight);
                    pref.setDailyactivity(Exercise);
                    pref.setEmergencyContactName(EmergencyContactName);
                    pref.setEmergencyContactNumber(EmergencyContactNumber);
                    SaveData(Feet, Inch, Weight, Exercise, EmergencyContactName, EmergencyContactNumber);
//                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });
        alertDialog = alertDialogBuilder.create();
        Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        alertDialog.show();
    }

    private void SaveData(String heightFeet, String heightInch, final String weight, String Exercise, String EmergencyContactName, String EmergencyContactNumber) {
        JSONObject object = new JSONObject();
//        try {
//            object.put("TokenNo", pref.getToken_no());
//            object.put("UserID", pref.getUID());
//            object.put("BloodGroup", "");
//            object.put("HeightInInch", heightInch);
//            object.put("HeightInFeet", heightFeet);
//            object.put("Weight", weight);
//            object.put("DailyActivity", Exercise);
//            object.put("EmergencyContactPersonName", EmergencyContactName);
//            object.put("EmergencyContactNo", EmergencyContactNumber);
//        }

        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("BloodGroup", "");
            object.put("HeightInInch", "5");
            object.put("HeightInFeet", "5");
            object.put("Weight", "55");
            object.put("DailyActivity", "No Exercise");
            object.put("EmergencyContactPersonName", "Brother");
            object.put("EmergencyContactNo", "9999999999");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getContext(), object, UrlHealthConstants.PROFILE_UPDATE, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                new AppDataPushApi().callApi(getActivity(), "Dashboard", "Profile info dailog", "User filled his personal information using profile dialog which opens first time");
                if (alertDialog != null)
                    alertDialog.dismiss();
                setcaloriegoal();
                pref.setWaterGlassTarget("8");
                pref.setTargetweight(weight);
                pref.setlossgain_txt("");
                pref.setlossgain("");
                Fragment frag = new FragmentDashBoardHealth();
                Bundle args = new Bundle();
                args.putString("hidevalue", "0");
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
            }

            @Override
            public void onError(VolleyError error, int Tag) {
                LogUtils.showLog("SaveData", "" + error.toString());
            }
        }, 9001);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    private void showAlertDialog(String head) {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("No vendor found at your current location.");
        alert_heading.setText(head);
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
    }

    private void checkIfLoggedIn() {
        FitnessOptions fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .build();
        if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(Objects.requireNonNull(getActivity())), fitnessOptions)) {
            replaceFragment(new FragmentTodayExerciseTab(), FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE);
        } else if (pref.getFibitUserId() != null) {
            replaceFragment(new FragmentTodayExerciseTab(), FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE);
        } else {
            replaceFragment3(new FragmentFitnessTrackerMenu());
        }
    }

    private void replaceFragment3(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("from", "1");
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_FITNESS_TRACKER_MENU);
            binder.detect(FragmentsHealthTags.FRAGMENT_FITNESS_TRACKER_MENU);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void readdata(final JSONObject object) {
        DataReadRequest readRequest = queryDateFitnessData();
        Task<DataReadResponse> response = Fitness.getHistoryClient(Objects.requireNonNull(getActivity()), Objects.requireNonNull(GoogleSignIn.getLastSignedInAccount(getActivity()))).readData(readRequest);
        response.addOnSuccessListener(dataReadResponse -> {
            walking_calorie = 0.0f;
            running_calorie = 0.0f;
            biking_calorie = 0.0f;
            printData(dataReadResponse);
            double walk_cal = walking_calorie;
            double run_cal = running_calorie;
            double bike_cal = biking_calorie;
            totalPreviousDayCal = walk_cal + run_cal + bike_cal;
            TargetCal = Double.parseDouble(pref.getcaloriegoal()) / 5;
            setProgressDataforExercise(object);
        });
    }

    private DataReadRequest queryDateFitnessData() {
        Calendar startCalendar = Calendar.getInstance(Locale.getDefault());
        if (!selected_date.equals(selected_date1)) {
            StringTokenizer st = new StringTokenizer(selected_date, "/");
            String dd = st.nextToken();
            int DD = Integer.parseInt(dd);
            startCalendar.set(Calendar.DAY_OF_MONTH, DD);
        }
        startCalendar.set(Calendar.HOUR_OF_DAY, 23);
        startCalendar.set(Calendar.MINUTE, 59);
        startCalendar.set(Calendar.SECOND, 59);
        startCalendar.set(Calendar.MILLISECOND, 999);
        long endTime = startCalendar.getTimeInMillis();

        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        long startTime = startCalendar.getTimeInMillis();

        return new DataReadRequest.Builder()
                .aggregate(DataType.TYPE_CALORIES_EXPENDED, DataType.AGGREGATE_CALORIES_EXPENDED)
                .aggregate(DataType.TYPE_DISTANCE_DELTA, DataType.AGGREGATE_DISTANCE_DELTA)
                .aggregate(DataType.TYPE_STEP_COUNT_DELTA, DataType.AGGREGATE_STEP_COUNT_DELTA)
                .bucketByActivitySegment(1, TimeUnit.MILLISECONDS)
                .setTimeRange(startTime, endTime, TimeUnit.MILLISECONDS)
                .build();
    }

    private void printData(DataReadResponse dataReadResult) {

        for (Bucket bucket : dataReadResult.getBuckets()) {
            String bucketActivity = bucket.getActivity();
            if (bucketActivity.contains(FitnessActivities.WALKING)) {
                List<DataSet> dataSetx = bucket.getDataSets();
                for (DataSet dataSet : dataSetx) {
                    if (dataSet.getDataType().getName().equals("com.google.calories.expended")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            walking_calorie = walking_calorie + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat();
                            walking_calorie = Math.round(walking_calorie);
                        }
                    }
                }
            } else if (bucketActivity.contains(FitnessActivities.RUNNING)) {
                List<DataSet> dataSetx = bucket.getDataSets();
                for (DataSet dataSet : dataSetx) {
                    if (dataSet.getDataType().getName().equals("com.google.calories.expended")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Calories dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat());
                            running_calorie = running_calorie + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat();
                            running_calorie = Math.round(running_calorie);
                        }
                    }
                }
            } else if (bucketActivity.contains(FitnessActivities.BIKING)) {
                List<DataSet> dataSetx = bucket.getDataSets();
                for (DataSet dataSet : dataSetx) {
                    if (dataSet.getDataType().getName().equals("com.google.calories.expended")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Calories dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat());
                            Log.e(TAG, "datapoints -->" + dataSet.getDataPoints().get(0).getStartTime(TimeUnit.MILLISECONDS) + " -- " + dataSet.getDataPoints().get(0).getEndTime(TimeUnit.MILLISECONDS));
                            biking_calorie = biking_calorie + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat();
                            biking_calorie = Math.round(biking_calorie);
                        }
                    }
                }
            }
        }
    }

    private void SetAlarm() {
        setAlarm(Objects.requireNonNull(getContext()));
    }

    public void setAlarm(Context context) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent();
        intent.setClass(context, AlarmReceiverUpdateTargets.class);
        intent.setPackage("com.universalsompo.meta");
        intent.setAction("com.universalsompo.meta.UpdateTargets");
        ComponentName receiver = new ComponentName(context, AlarmReceiverUpdateTargets.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 4) {
            calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
        } else {
            Log.e(TAG, Objects.requireNonNull(getActivity()).getResources().getString(R.string.schedule_for_today));
        }
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 55);
        calendar.set(Calendar.SECOND, 10);
        RegisterUpdateTargets();
        context.startService(intent);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
    }

    private void RegisterUpdateTargets() {
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.UpdateTargets");
        AlarmReceiverUpdateTargets myReceiver = new AlarmReceiverUpdateTargets();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver, intent1);
    }

    private void callFitBitData(final JSONObject data) {
        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        String url = "https://api.fitbit.com/1/user/" + pref.getFibitUserId() + "/activities/date/" + selected_date1_fitbit + ".json";
        StringRequest postr = new StringRequest(Request.Method.GET, url, response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONObject object = jsonObject.getJSONObject("summary");
                String cal = object.getString("caloriesOut");
                walking_calorie = Float.parseFloat(cal);
                totalPreviousDayCal = walking_calorie;
                TargetCal = Double.parseDouble(pref.getcaloriegoal()) / 5;
                setProgressDataforExercise(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {

        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                params.put("Authorization", "Bearer " + pref.getFitbitAccessToken());
                return params;
            }
        };
        queue.add(postr);
    }

    @SuppressLint("SetTextI18n")
    private void setProgressDataforExercise(JSONObject object) {
        String curr_exercise_burn;
        try {
            curr_exercise_burn = object.getString("ExerciseBurn");
            String curr_exer_burn = curr_exercise_burn.substring(0, curr_exercise_burn.lastIndexOf(' '));
            double curr_burnt_exercise_cal = Double.parseDouble(curr_exer_burn);
            double total_cal_burn = totalPreviousDayCal + curr_burnt_exercise_cal;
            int e_goal = (int) (Double.parseDouble(pref.getcaloriegoal()) / 5);
            if (total_cal_burn >= e_goal) {
                steps_progress.setProgress(100);
                steps_taken.setText("Burnt " + (int) total_cal_burn);
                tick_1.setVisibility(View.VISIBLE);
                steps_goal.setText("Goal Achieved");
            } else if (total_cal_burn > 0 && total_cal_burn < e_goal) {
                double per = (total_cal_burn / e_goal) * 100;
                double diff = e_goal - total_cal_burn;
                steps_progress.setProgress((int) per);
                steps_taken.setText("Burnt " + (int) total_cal_burn);
                tick_1.setVisibility(View.GONE);
                steps_goal.setText("Left " + (int) diff);
            } else {
                steps_progress.setProgress(0);
                steps_taken.setText("Burnt 0");
                tick_1.setVisibility(View.GONE);
                steps_goal.setText("Left " + (int) (Double.parseDouble(pref.getcaloriegoal()) / 5));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getSliders() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put(RequestConstants.USER_ID, pref.getUID());
            object.put("NotificationType", "Motor");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_SLIDER_IMAGE, this, RequestConstants.GET_SLIDER_IMAGE);
        req.execute();
    }

    private void callWYHLoginApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("PolicyNo", "2841/61176505/00/000");
            object.put("MemberId", "101234939211");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_WYH_LOGIN_API, this, RequestHealthConstants.GET_WYH_LOGIN_API);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    private void showWYHDialog(String msg) {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_heading.setText("Alert");
        alert_msg.setText(msg);
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
        alert_dialog.show();
    }

    private void getCurrentLocation() {
        locationManager = (LocationManager) Objects.requireNonNull(getActivity()).getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true));

        //You can still do this if you like, you might get lucky:
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = getLastKnownLocation();
        if (location != null) {
            Log.e("TAG", "GPS is on");
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            if (getActivity() != null) {
                getActivity().runOnUiThread(() -> {
                    Geocoder geocoder;
                    List<Address> addresses = null;
                    geocoder = new Geocoder(getActivity(), Locale.getDefault());
                    try {
                        addresses = geocoder.getFromLocation(latitude, longitude, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (addresses != null) {
                        city = addresses.get(0).getLocality();
                        state = addresses.get(0).getAdminArea();
                    }
                });
            }
        } else {
            //This is what you need:
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            if (bestProvider.equals("null")){
                statusCheck();
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }else {
                locationManager.requestLocationUpdates(bestProvider, 1000, 0, this);
            }

        }
    }

    private Location getLastKnownLocation() {
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return bestLocation;
            }
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null
                    || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        if (bestLocation == null) {
            return null;
        }
        return bestLocation;
    }

    @Override
    public void onLocationChanged(Location location) {
        locationManager.removeUpdates(this);
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    public void statusCheck() {
        final LocationManager manager = (LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//
//        } else {
//            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
//        }

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }
    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Your Location seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
//                        gps_button_tru=true;
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

}
