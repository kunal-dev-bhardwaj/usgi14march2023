package com.universalsompo.meta.metaapp.health.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
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
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentAlcohol;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentBMI;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentBP;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentBloodSugar;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentCholestrol;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentCigarettes;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentExercise;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentFamilyHealth;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentFriedFood;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentFruitServing;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentGeneralHealth;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentLaptopWorking;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentLifestyleResult;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentSleep;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentSocialLife;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentStress;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentUserLife;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWHR;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWorkBalance;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWorkShift;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWorking;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.database.DatabaseActivityID;
import com.universalsompo.meta.metaapp.health.fragment.HRAFragment;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.CalculatorPlanType;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.OfflineCalculator;
import com.universalsompo.meta.metaapp.health.fragment.calculator.CalculatorFragment;
import com.universalsompo.meta.metaapp.health.fragment.calculators.FragmentCalculatorMenu;
import com.universalsompo.meta.metaapp.health.fragment.diary.FragmentDietDiary;
import com.universalsompo.meta.metaapp.health.fragment.FragmentDashBoardHealth;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.FragmentHealthRegisterUSGI;
import com.universalsompo.meta.metaapp.health.fragment.help.fragment.FragmentHelp;
import com.universalsompo.meta.metaapp.health.fragment.locator.FragmentNearby;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.BuyPolicyMenu;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentClaimStatusTracking;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.MyPolicyTab;
import com.universalsompo.meta.metaapp.health.fragment.profile.FragmentHealthProfile;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentMedicalRecords;
import com.universalsompo.meta.metaapp.health.fragment.profile.myriskprofile.fragment.FragmentRiskProfile;
import com.universalsompo.meta.metaapp.health.fragment.myissues.fragment.MyIssueList;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.ConsultationReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodTypeDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.LabTestReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.MedicineReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WaterReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WeightReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentConsultationReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentFoodReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentLabTestReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentMedicineReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentWaterReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentWeightReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.TypesOfReminders;
import com.universalsompo.meta.metaapp.health.fragment.settings.FragmentSettings;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ConditionsDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.SelectedSympDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.TriageDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentBasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomQuestions;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomResult;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomSearch;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomSuggestions;
import com.universalsompo.meta.metaapp.health.fragment.todayexercise.FragmentFitnessTrackerMenu;
import com.universalsompo.meta.metaapp.health.notificationReminder.ReminderForNotification;
import com.universalsompo.meta.metaapp.intefaces.AddFragmentCallback;
import com.universalsompo.meta.metaapp.intefaces.ChangeOptionIconInterface;
import com.universalsompo.meta.metaapp.intefaces.DocumentCallback;
import com.universalsompo.meta.metaapp.intefaces.ImageListenerInterface;
import com.universalsompo.meta.metaapp.intefaces.KeyboardVisibilityListener;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.LoginActivity;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.TutorialActivityMotor;
import com.universalsompo.meta.metaapp.motor.constants.Config;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentDocuments;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MYSharePrefLifestyleHRA;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.BaseActivity;
import com.universalsompo.meta.metaapp.utilities.CacheUtils;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.GPSTracker;
import com.universalsompo.meta.metaapp.utilities.KeyboardUtil;
import com.universalsompo.meta.metaapp.utilities.MyApplication;
import com.universalsompo.meta.metaapp.utilities.MyCheckPermission;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import com.universalsompo.meta.metaapp.utilities.NotificationUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;
import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;

import static android.provider.Settings.Secure.ANDROID_ID;


public class MainActivityHealth extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, SelectorListener, View.OnClickListener, ChangeOptionIconInterface, KeyboardVisibilityListener, ImageListenerInterface, AddFragmentCallback, ResponseListener, DocumentCallback, LocationListener {

    public static LinearLayout dashboard_home;
    private NavigationView navigationView;
    private View headerView;
    private TextView txt_userName;
    private TextView txt_userPhn;
    private CircleImageView img_user;
    private DrawerLayout drawer;
    private TextView mTitle,mTitle1;
    private MySharedPreference pref;
    private MYSharePrefLifestyleHRA pref1;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private boolean keyboardFlag = false;
    public static  LinearLayout fitness;
    private LinearLayout home_bottom;
    public static LinearLayout market;
    public LinearLayout tips_dialog;
    public static TextView iconhome,tvhome,tvmarket,iconmarket,ambulance_text,bottom_center_button,tvlocator,iconlocator,fitness_icon,fitness_text,version_display;         // Anirudh
    private int exitFlag = 0;
    private long backTime;
    private static LinearLayout dashboard_ambulance1;
    public static LinearLayout dashboard_fitness;
    public static LinearLayout dashboard_location;
    public static LinearLayout locator;
    public LinearLayout dashboard_market;
    Toolbar toolbar, toolbar1;
    String AmbulanceNo, EmergencyContactNo, EmergencyContactPersonName;
    private BasicQuesDatabaseHelper db;
    private GuideView mGuideView;
    private GuideView.Builder builder;
    FoodReminderDatabaseHelper dbtypeofreminder;
    FoodTypeDatabaseHelper dbfood_reminder;
    LabTestReminderDatabaseHelper dblabtest_reminder;
    ConsultationReminderDatabaseHelper dbconsultation_reminder;
    WeightReminderDatabaseHelper dbweight_reminder;
    LifestyleHRADatabaseHelper dblifestylehra;
    private String deviceVersion;
    private String deviceId;
    MedicineReminderDatabaseHelper dbmed_reminder;
    WaterReminderDatabaseHelper dbwater_reminder;
    DatabaseActivityID databaseActivityID;
    private String reminderDate;
    private static final String PACKAGE_NAME = "com.universalsompo.meta";
    LinearLayout drawer_head1;
    //shivani
    private TriageDatabaseHelper tr_db;
    private SelectedSympDatabaseHelper db1;
    private ResultDatabaseHelper db2;
    private ConditionsDatabaseHelper db3;
    private BasicQuesDatabaseHelper db4;
    private LifestyleHRADatabaseHelper db5;
    private LifestyleResultDatabaseHelper db6;

    public LocationManager locationManager;
    public Criteria criteria;
    public String bestProvider;
    GPSTracker gps;
    double latitude ,longitude;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_health);

//        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
//        statusCheck();
//        getCurrentLocation();

        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/


        if (android.os.Build.VERSION.SDK_INT >= 23) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
        pref = MySharedPreference.getInstance(MainActivityHealth.this);
        pref1 = MYSharePrefLifestyleHRA.getInstance(MainActivityHealth.this);
        deviceId = Settings.Secure.getString(MainActivityHealth.this.getContentResolver(),ANDROID_ID);
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            deviceVersion = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

//shivani
        tr_db = new TriageDatabaseHelper(MainActivityHealth.this);
        db1 = new SelectedSympDatabaseHelper(MainActivityHealth.this);
        db2 = new ResultDatabaseHelper(MainActivityHealth.this);
        db3 = new ConditionsDatabaseHelper(MainActivityHealth.this);
        db4 = new BasicQuesDatabaseHelper(MainActivityHealth.this);
        db5 = new LifestyleHRADatabaseHelper(MainActivityHealth.this);
        db6 = new LifestyleResultDatabaseHelper(MainActivityHealth.this);
        //
        callApi_profile();
        db = new BasicQuesDatabaseHelper(MainActivityHealth.this);
        dbtypeofreminder = new FoodReminderDatabaseHelper(MainActivityHealth.this);
        dbfood_reminder = new FoodTypeDatabaseHelper(MainActivityHealth.this);
        dblabtest_reminder = new LabTestReminderDatabaseHelper(MainActivityHealth.this);
        dbconsultation_reminder = new ConsultationReminderDatabaseHelper(MainActivityHealth.this);
        dbweight_reminder = new WeightReminderDatabaseHelper(MainActivityHealth.this);
        dblifestylehra = new LifestyleHRADatabaseHelper(MainActivityHealth.this);
        dbmed_reminder = new MedicineReminderDatabaseHelper(MainActivityHealth.this);
        dbwater_reminder = new WaterReminderDatabaseHelper(MainActivityHealth.this);
        databaseActivityID = new DatabaseActivityID(MainActivityHealth.this);
        toolbar = findViewById(R.id.toolbar);
        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSosDetails();
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        drawer = findViewById(R.id.drawer_layout1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view1);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        intView();
        mTitle.setText(Html.fromHtml("<b>Health</b>"));
        FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
        startFCM();
//        checkAppPermission();
        init();

        final View activityRootView = findViewById(R.id.content_main1);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(MainActivityHealth.this, 200)) { // if more than 200 dp, it's probably a keyboard...
                    home_bottom.setVisibility(View.GONE);
                }
            }
        });
        sendTokenToServer();
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    public void hidenav(){
        setSupportActionBar(toolbar1);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setVisibility(View.GONE);
        toolbar1.setVisibility(View.VISIBLE);
    }

    public void shownav(){
        toolbar.setVisibility(View.VISIBLE);
        toolbar1.setVisibility(View.GONE);
    }

    public void showfooter(){
        home_bottom.setVisibility(View.VISIBLE);
    }

    public void hidefooter(){
        home_bottom.setVisibility(View.GONE);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void remove_elevation() {
        toolbar1.setElevation(0.0f);
    }
    public void remove_elevation1() {
        toolbar1.setVisibility(View.GONE);
//        toolbar1.setElevation(0.0f);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void show_elevation() {
        toolbar1.setElevation(5.0f);
    }

    @Override
    public void onBackPressed() {
        invalidateOptionsMenu();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_frame1);
        if (locator.getVisibility() == View.VISIBLE || market.getVisibility() == View.VISIBLE || fitness.getVisibility() == View.VISIBLE || tips_dialog.getVisibility() == View.VISIBLE || drawer.isDrawerOpen(GravityCompat.START)) { // Anirudh
            popUpLayoutGone();
            removeSelectorOnBottom();
            drawer.closeDrawer(GravityCompat.START);
            tvhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
            iconhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
        } else if (currentFragment instanceof FragmentNearby) {
            popUpLayoutGone();
            tvhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
            iconhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));

            tvlocator.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
            iconlocator.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            tvmarket.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
            iconmarket.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            fitness_icon.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
            fitness_text.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            ambulance_text.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            Fragment frag = new FragmentDashBoardHealth();
            Bundle args = new Bundle();
            args.putString("hidevalue", "0");
            frag.setArguments(args);
            FragmentsTransactionsUtils.addFragmentAgain(MainActivityHealth.this, frag, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
            changeTitle(FragmentsHealthTags.META_HEALTH);
            invalidateOptionsMenu();
        } else if (currentFragment instanceof FragmentMedicalRecords) {
            popUpLayoutGone();
            tvhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
            iconhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));

            tvlocator.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
            iconlocator.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            tvmarket.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
            iconmarket.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            fitness_icon.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
            fitness_text.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            ambulance_text.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

            try {
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (fragmentManager.getBackStackEntryCount() == 1) {
                    invalidateOptionsMenu();
                    Fragment frag = new FragmentDashBoardHealth();
                    Bundle args = new Bundle();
                    args.putString("hidevalue", "0");
                    frag.setArguments(args);
                    FragmentsTransactionsUtils.addFragmentAgain(MainActivityHealth.this, frag, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
                    changeTitle(FragmentsHealthTags.META_HEALTH);
                } else {
                    String fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 2).getName();
                    assert fragmentTag != null;
                    detect(fragmentTag);
                    invalidateOptionsMenu();
                    super.onBackPressed();
                }
            } catch (Exception e) {
                        e.printStackTrace();
                    }
        } else if(currentFragment instanceof FragmentRiskProfile) {
            SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            if(prefs2.getBoolean(getString(R.string.pref_previously_started1), true)) {
                boolean previouslyStarted2 = prefs2.getBoolean(getString(R.string.pref_previously_started2), false);
                if (!previouslyStarted2) {
                    SharedPreferences.Editor edit = prefs2.edit();
                    edit.putBoolean(getString(R.string.pref_previously_started2), Boolean.TRUE);
                    edit.commit();
                    popUpLayoutGone();
                    tvhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
                    iconhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));

                    tvlocator.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
                    iconlocator.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

                    tvmarket.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
                    iconmarket.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

                    fitness_icon.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));
                    fitness_text.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

                    ambulance_text.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.lightblack));

                    Fragment frag = new FragmentDashBoardHealth();
                    Bundle args = new Bundle();
                    args.putString("hidevalue", "0");
                    frag.setArguments(args);
                    FragmentsTransactionsUtils.addFragmentAgain(MainActivityHealth.this, frag, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
                    changeTitle(FragmentsHealthTags.META_HEALTH);
                    invalidateOptionsMenu();
                } else {
                    getCurrentFragment();
                }
            }
        } else if (currentFragment instanceof FragmentBasicQuestion) {
            getbasicquestions();
        } else if (currentFragment instanceof FragmentSymptomSearch) {
            show();
        } else if (currentFragment instanceof FragmentSymptomSuggestions) {
            show1();
        } else if (currentFragment instanceof FragmentSymptomQuestions) {
            int total_row = db.getBasicSymptomCountAsPerFragment(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
            if (total_row > 0) {
                show();
            } else {
                show1();
            }
        } else if (currentFragment instanceof FragmentSymptomResult) {
            MainActivityHealth.this.deleteDatabase("basic_symptom_added_db");
            MainActivityHealth.this.deleteDatabase("condition_added_db");
            MainActivityHealth.this.deleteDatabase("triage_added_db");
            removeAllFragemntPutOnlyDashboardFragment();
        } else if (currentFragment instanceof FragmentFoodReminder) {
            int status_count = dbfood_reminder.getActiveStatus(pref.getUID(), "Food reminder", "active");
            if (status_count == 0) {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Food reminder", "deactive");
                dbfood_reminder.updateStatusofReminder(pref.getUID(), "Food reminder", "Early Morning", "",  "deactive");
                dbfood_reminder.updateStatusofReminder(pref.getUID(), "Food reminder", "Breakfast", "",  "deactive");
                dbfood_reminder.updateStatusofReminder(pref.getUID(), "Food reminder", "Lunch", "",  "deactive");
                dbfood_reminder.updateStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks", "",  "deactive");
                dbfood_reminder.updateStatusofReminder(pref.getUID(), "Food reminder", "Dinner", "",  "deactive");
            } else {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Food reminder", "active");
            }
            getCurrentFragment();
        } else if (currentFragment instanceof FragmentLabTestReminder) {
            int lab_test_count = dblabtest_reminder.getCount(pref.getUID());
            int deactive_count = dblabtest_reminder.getdeactiveCount(pref.getUID(), "deactive");
            if (lab_test_count == 0 || lab_test_count == deactive_count) {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Lab test reminder", "deactive");
            } else {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Lab test reminder", "active");
            }
            getCurrentFragment();
        } else if (currentFragment instanceof FragmentConsultationReminder) {
            int consultation_count = dbconsultation_reminder.getCount(pref.getUID());
            int deactive_count = dbconsultation_reminder.getdeactiveCount(pref.getUID(), "deactive");
            if (consultation_count == 0 || consultation_count == deactive_count) {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Consultation reminder", "deactive");
            } else {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Consultation reminder", "active");
            }
            getCurrentFragment();
        } else if (currentFragment instanceof FragmentWeightReminder) {
            int active_count = dbweight_reminder.getActiveCount(pref.getUID(), "active");
            if (active_count == 0) {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Weight reminder", "deactive");
            } else {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Weight reminder", "active");
            }
            getCurrentFragment();
        } else if (currentFragment instanceof FragmentMedicineReminder) {
            int active_count = dbmed_reminder.getActiveCount(pref.getUID(), "active");
            if (active_count == 0) {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Med reminder", "deactive");
            } else {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Med reminder", "active");
            }
            getCurrentFragment();
        }else if (currentFragment instanceof FragmentWaterReminder) {
            int active_count = dbwater_reminder.getActiveCount(pref.getUID(), "active");
            if (active_count == 0) {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Water reminder", "deactive");
            } else {
                dbtypeofreminder.updateStatusofReminder(pref.getUID(), "Water reminder", "active");
            }
            getCurrentFragment();
        } else if (currentFragment instanceof FragmentBMI) {
            int val = dblifestylehra.getLifeStyleCount();
            if (val > 0) {
                show();
            } else {
                getCurrentFragment();
            }
        } else if (currentFragment instanceof FragmentWHR) {
            show();
        } else if (currentFragment instanceof FragmentBP) {
            show();
        } else if (currentFragment instanceof FragmentBloodSugar) {
            show();
        } else if (currentFragment instanceof FragmentCholestrol) {
            show();
        } else if (currentFragment instanceof FragmentAlcohol) {
            show();
        } else if (currentFragment instanceof FragmentCigarettes) {
            show();
        } else if (currentFragment instanceof FragmentFamilyHealth) {
            show();
        } else if (currentFragment instanceof FragmentGeneralHealth) {
            show();
        } else if (currentFragment instanceof FragmentFruitServing) {
            show();
        } else if (currentFragment instanceof FragmentFriedFood) {
            show();
        } else if (currentFragment instanceof FragmentWorkBalance) {
            show();
        } else if (currentFragment instanceof FragmentWorking) {
            show();
        } else if (currentFragment instanceof FragmentLaptopWorking) {
            show();
        } else if (currentFragment instanceof FragmentWorkShift) {
            show();
        } else if (currentFragment instanceof FragmentExercise) {
            show();
        } else if (currentFragment instanceof FragmentSleep) {
            show();
        } else if (currentFragment instanceof FragmentUserLife) {
            show();
        } else if (currentFragment instanceof FragmentStress) {
            show();
        } else if (currentFragment instanceof FragmentSocialLife) {
            show();
        } else if (currentFragment instanceof FragmentLifestyleResult) {
            pref1.setHitLifestyleAPI("false");
            MainActivityHealth.this.deleteDatabase("lifestyle_hra_db");
            removeAllFragemntPutOnlyDashboardFragment();
        } else {
            getCurrentFragment();
        }
    }

    @SuppressLint("SetTextI18n")
    void show() {
        final Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.warning_dialog);
        TextView txt_no = dialog.findViewById(R.id.tvmobnumber);
        txt_no.setText("Do you want to quit HRA?");
        TextView call = dialog.findViewById(R.id.tvyes);
        TextView cancel = dialog.findViewById(R.id.tvno);
        cancel.setOnClickListener(v -> dialog.dismiss());

        call.setOnClickListener(v -> {
            new AppDataPushApi().callApi(MainActivityHealth.this,"Health risk assessment","Health risk assessment quit dailog","User quits his present lifestyle health risk assessment");
            changeFragmnet();
            dialog.dismiss();
        });

        dialog.show();
    }
    @SuppressLint("SetTextI18n")
    void show1() {
        final Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.warning_dialog);

        TextView txt_no = dialog.findViewById(R.id.tvmobnumber);
        txt_no.setText("Do you want to quit HRA?");
        TextView call = dialog.findViewById(R.id.tvyes);
        TextView cancel = dialog.findViewById(R.id.tvno);
        cancel.setOnClickListener(v -> dialog.dismiss());

        call.setOnClickListener(v -> {
            new AppDataPushApi().callApi(MainActivityHealth.this,"Health risk assessment","Health risk assessment quit dailog","User quits his present symptom health risk assessment");
            changeFragmnet();
            db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
            dialog.dismiss();
        });

        dialog.show();
    }

    @SuppressLint("SetTextI18n")
    void intView() {
        home_bottom = findViewById(R.id.home_bottom1);
        dashboard_home = findViewById(R.id.dashboard_home1);
        dashboard_ambulance1 = findViewById(R.id.dashboard_ambulance1);
        dashboard_fitness = findViewById(R.id.dashboard_fitness);
        dashboard_location = findViewById(R.id.dashboard_location);
        tips_dialog = findViewById(R.id.tips_dialog);
        dashboard_market = findViewById(R.id.dashboard_market);
        fitness = findViewById(R.id.fitness);
        market = findViewById(R.id.market);
        iconlocator = findViewById(R.id.iconlocator);
        tvlocator = findViewById(R.id.tvlocator);
        mTitle = findViewById(R.id.toolbar_title);
        mTitle1 = findViewById(R.id.toolbar_title1);
        version_display = findViewById(R.id.version_display);
        version_display.setText("Version : " + deviceVersion);

        iconhome = findViewById(R.id.iconhome1);
        tvhome = findViewById(R.id.tvhome1);
        tvmarket = findViewById(R.id.tvmarket);
        iconmarket = findViewById(R.id.iconmarket);
        ambulance_text = findViewById(R.id.ambulance_text);
        bottom_center_button = findViewById(R.id.bottom_center_button);
        fitness_icon = findViewById(R.id.fitness_icon);
        fitness_text = findViewById(R.id.fitness_text);
        locator = findViewById(R.id.locator);

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        iconhome.setTypeface(fontAwesomeFont);
        bottom_center_button.setTypeface(fontAwesomeFont);
        iconlocator.setTypeface(fontAwesomeFont);
        fitness_icon.setTypeface(fontAwesomeFont);
        iconmarket.setTypeface(fontAwesomeFont);

        headerView = navigationView.getHeaderView(0);
        txt_userName =headerView.findViewById(R.id.txt_nav_username1);
        txt_userPhn = headerView.findViewById(R.id.txt_nav_phn1);
        img_user = headerView.findViewById(R.id.nav_user_img1);
        drawer_head1 = headerView.findViewById(R.id.drawer_head1);

        new KeyboardUtil().setKeyboardVisibilityListener(MainActivityHealth.this, this);
        getCurrentDate();
        dashboard_home.setOnClickListener(this);
        dashboard_ambulance1.setOnClickListener(this);
        dashboard_fitness.setOnClickListener(this);
        dashboard_location.setOnClickListener(this);
        dashboard_market.setOnClickListener(this);
        drawer_head1.setOnClickListener(this);

    }

    public void setUserInFoInDrawer(String image) {
        headerView = navigationView.getHeaderView(0);
        txt_userName =  headerView.findViewById(R.id.txt_nav_username1);
        txt_userPhn =  headerView.findViewById(R.id.txt_nav_phn1);
        img_user =  headerView.findViewById(R.id.nav_user_img1);
        txt_userName.setText(pref.getUserName());
        txt_userPhn.setText(pref.getMOBILE());
        assert image != null;
        if (image != null || image.length() != 0) {
            Picasso.get().load(image).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.loading).error(R.drawable.dummy).into(img_user);
        } else {
            Picasso.get().load(R.drawable.dummy).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.dummy).error(R.drawable.dummy).into(img_user);
        }
    }

    String compressNow(final String file) {
        File compressedImage = new Compressor.Builder(MainActivityHealth.this)
                .setMaxWidth(350)
                .setMaxHeight(350)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .build()
                .compressToFile(new File(file));
        return compressedImage.getAbsolutePath();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        String frag_title = mTitle.getText().toString();
        String frag_title1 = mTitle1.getText().toString();
        if(toolbar.getVisibility() == View.VISIBLE){
            if (FragmentsHealthTags.META_HEALTH.equals(frag_title)) {
                inflater.inflate(R.menu.policy_menu1, menu);
                View motor_menu_changer = menu.findItem(R.id.motor_menu_changer).getActionView();
                getStatus();
                motor_menu_changer.setOnClickListener(v -> {
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started3), false);
                    if (!previouslyStarted) {
                        SharedPreferences.Editor edit = prefs.edit();
                        edit.putBoolean(getString(R.string.pref_previously_started3), Boolean.TRUE);
                        edit.commit();
                        /*Intent i = new Intent(MainActivityHealth.this, TutorialActivityMotor.class);
                        startActivity(i);*/
                        Intent i = new Intent(MainActivityHealth.this, MainActivity.class);
                        startActivity(i);

                    } else {
                        Intent i = new Intent(MainActivityHealth.this, MainActivity.class);
                        startActivity(i);
                    }
                    overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
                    finish();
                });
                return true;
            }
        } else {
            switch (frag_title1) {
                case FragmentsHealthTags.BASIC_PROFILE:
                    inflater.inflate(R.menu.profile_menu, menu);
                    return true;
                case FragmentsHealthTags.FAMILY_INFO:
                    inflater.inflate(R.menu.menu_family, menu);
                    return true;
                case FragmentsTags.NOTIFICATION:
                    inflater.inflate(R.menu.clear_notification, menu);
                    return true;
                default:
                    return true;
            }
        }
        return true;
    }


    private void getStatus(){

        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",  pref.getToken_no());
            object.put("Uid", pref.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(MainActivityHealth.this, object, UrlConstants.URL_STATUS_USER, new ResponseListener() {

            @Override
            public void onSuccess(JSONObject object, int Tag) {
                Log.d("Response" , String.valueOf(object));
                if (object.optString("UserActiveStatus").equals("Active")) {
                }else {
                    MySharedPreference.getInstance(MainActivityHealth.this).clearAll();
                    Intent in = new Intent(MainActivityHealth.this, LoginActivity.class);
                    startActivity(in);
                    finish();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_LOGIN);
        req.execute();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (!NetworkUtils.isConnected(this)) {
            Toast.makeText(this, "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return false;
        }
        switch (item.getItemId()) {

            case R.id.motor_menu_changer:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started3), false);
                if (!previouslyStarted) {
                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putBoolean(getString(R.string.pref_previously_started3), Boolean.TRUE);
                    edit.commit();
                        /*Intent i = new Intent(MainActivityHealth.this, TutorialActivityMotor.class);
                        startActivity(i);*/
                    Intent i = new Intent(MainActivityHealth.this, MainActivity.class);
                    startActivity(i);

                } else {
                    Intent i = new Intent(MainActivityHealth.this, MainActivity.class);
                    startActivity(i);
                }
                overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
                finish();
                break;

            case R.id.nav_profile:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.HEALTH_PROFILE);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentHealthProfile(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_PROFILE);
                break;

            case R.id.claim_status:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.CLAIM_STATUS);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentClaimStatusTracking(), R.id.main_frame1, FragmentsHealthTags.CLAIM_STATUS_TAG);
                break;

            case R.id.nav_diary:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.DIARY);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentDietDiary(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_DIARY);
                break;
            case R.id.offlineCalculation:
                 Intent intent=new Intent(MainActivityHealth.this, CalculatorPlanType.class);
                 intent.putExtra("strFor","0");
                 startActivity(intent);
                 break;
            case R.id.nav_health_register:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.HEALTH_REGISTER);
                FragmentHealthRegisterUSGI frag_register = new FragmentHealthRegisterUSGI();
                Bundle bdl = new Bundle();
                bdl.putString("Page", "0");
                frag_register.setArguments(bdl);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, frag_register, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_REGISTER);
                break;

            case R.id.nav_calculators:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.HEALTH_CALCULATOR);
                CalculatorFragment frag = new CalculatorFragment();
                Bundle args = new Bundle();
                args.putInt("otherFrag", 1);
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_REGISTER);
//               FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentCalculatorMenu(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_CALCULATOR);
                break;

            case R.id.nav_reminder:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.HEALTH_REMINDER);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new TypesOfReminders(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_REMINDER);
                break;

            case R.id.nav_connected_device:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.FITNESS_TRACKER_MENU);
                Fragment frag1 = new FragmentFitnessTrackerMenu();
                Bundle args1 = new Bundle();
                args1.putString("from", "0");
                frag1.setArguments(args1);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, frag1, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_FITNESS_TRACKER_MENU);
                break;

            case R.id.nav_help:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.HELP);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentHelp(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HELP);
                break;

            case R.id.nav_my_issues:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.MY_ISSUE);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new MyIssueList(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_MY_ISSUE);
                break;
            case R.id.nav_hra:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.HRA);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new HRAFragment(), R.id.main_frame1, FragmentsHealthTags.HRA);
                break;

            case R.id.rate_us:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                }
                catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }
                break;

            case R.id.nav_settings:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.SETTINGS);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentSettings(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_SETTINGS);
                break;

            case R.id.logout:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.SETTINGS);
                new AppDataPushApi().callApi(getApplicationContext(),"Settings","Settings page","User logged out from the app");
                logout();

                break;

        }
        closeLayoutOndrwerClick();
        invalidateOptionsMenu();
        removeSelectorOnBottom();
        DrawerLayout drawer = findViewById(R.id.drawer_layout1);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void init() {
        callApi();
        Fragment frag = new FragmentDashBoardHealth();
        Bundle args = new Bundle();
        args.putString("hidevalue", "0");
        frag.setArguments(args);
        FragmentsTransactionsUtils.addFragment(MainActivityHealth.this, frag, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
        tvhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
        iconhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
//        promotionalpopup();
        checkForFirstTime();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("Uid",pref.getUID());
            ProjectVolleyRequest req = new ProjectVolleyRequest(MainActivityHealth.this, object, UrlConstants.GET_CALL_US_NO, this, RequestConstants.GET_CALL_US_NO);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void checkForFirstTime(){
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this); // harit dahiya
        if (!sharedPreferences.getBoolean(
                "DemoPagesHealth", false)) {
            showDemoPages();
            setAlarms();
        } else {
            checkUser();
        }
    }

    private void showDemoPages(){
        builder = new GuideView.Builder(this)
                .setGravity(Gravity.center)
                .setTitle("Take a tour")
                .setContentText("Dashboard")
                .setDismissType(DismissType.outside)
                .setTargetView(dashboard_home)
                .setGuideListener(view -> {
                    switch (view.getId()) {
                        case R.id.dashboard_home1:
                            builder.setTitle("Take a tour")
                                    .setContentText("Nearby searches");
                            builder.setTargetView(dashboard_location).build();
                            break;
                        case R.id.dashboard_location:
                            builder.setTitle("Take a tour")
                                    .setContentText("for all the records");
                            builder.setTargetView(dashboard_fitness).build();
                            break;
                        case R.id.dashboard_fitness:
                            builder.setTitle("Take a tour")
                                    .setContentText("Call an ambulance");
                            builder.setTargetView(dashboard_ambulance1).build();
                            break;
                        case R.id.dashboard_ambulance1:
                            return;
                    }
                    mGuideView = builder.build();
                    mGuideView.show();
                });

        mGuideView = builder.build();
        mGuideView.show();
        onFinishDemoPages();
    }

    private void onFinishDemoPages(){
        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(this).edit();
        sharedPreferencesEditor.putBoolean(
                "DemoPagesHealth", true);
        sharedPreferencesEditor.apply();
        checkUser();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {

        if (Tag == RequestConstants.GET_CALL_US_NO) {
            if (object.optString("Status").equals("true")) {
                String sustomerCareNo_str = object.optString("CustomerCareNo");
            }
        } else if (Tag == RequestHealthConstants.GET_SOS_DETAILS) {
            if (object.optString("Status").equals("true")) {
                AmbulanceNo = object.optString("AmbulanceNo");
                EmergencyContactNo = object.optString("EmergencyContactNo");
                EmergencyContactPersonName = object.optString("EmergencyContactPersonName");
            }
        } else if (Tag == RequestHealthConstants.ACTIVITY_ID_MASTER) {
            if (object.optString("Message").equals("Success")) {
                try {
                    JSONArray array = object.getJSONArray("DboardActivityList");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        String activityID = obj.getString("ActivityId");
                        String name = obj.optString("ActivityName");
                        String uni_name = obj.optString("ActivityUnqiueName");
                        databaseActivityID.insertData(pref.getUID(), name, activityID, uni_name);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (Tag == RequestHealthConstants.GET_PROFILE_DETAIL) {
            if (object.optString("Message").equals("Success")) {
                pref.setgender(object.optString("Gender"));
                pref.setAge(object.optString("Age"));
                String dob = object.optString("DateOfBirth");
                String dobb = parseDateToddMMyyyy(dob);
                pref.setDOB(dobb);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        Toast.makeText(MainActivityHealth.this, error.toString(), Toast.LENGTH_LONG).show();
    }

    void checkAppPermission() {
        if (MyCheckPermission.checkAppPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            if (MyCheckPermission.checkAppPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if (MyCheckPermission.checkAppPermission(this, Manifest.permission.CAMERA)) {
                    if (MyCheckPermission.checkAppPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        if (MyCheckPermission.checkAppPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        } else {
                            MyCheckPermission.requestPermissionNow(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                            }, RequestConstants.INITIAL_PERMISSION);
                        }
                    } else {
                        MyCheckPermission.requestPermissionNow(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                        }, RequestConstants.INITIAL_PERMISSION);
                    }
                } else {
                    MyCheckPermission.requestPermissionNow(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                    }, RequestConstants.INITIAL_PERMISSION);
                }
            } else {
                MyCheckPermission.requestPermissionNow(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                }, RequestConstants.INITIAL_PERMISSION);
            }
        } else {
            MyCheckPermission.requestPermissionNow(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, RequestConstants.INITIAL_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RequestConstants.INITIAL_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    if (grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                        if (grantResults[3] == PackageManager.PERMISSION_GRANTED) {
                            if (grantResults[4] == PackageManager.PERMISSION_GRANTED) {
                            } else {
                                Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void detect(String Tag) {
        removeSelectorOnBottom();
        switch (Tag) {
            case FragmentsHealthTags.POLICY_FRAGMENT1:
                changeTitle(FragmentsHealthTags.MY_POLICY1);
                break;
            case FragmentsHealthTags.CLAIM_FRAGMENT1:
                changeTitle(FragmentsHealthTags.CLAIM1);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_CLAIM_INTIMATION:
                changeTitle(FragmentsHealthTags.HEALTH_CLAIM_INTIMATION);
                break;
            case FragmentsHealthTags.DASH_BOARD_FRAGMENT1:
                mTitle.setText(Html.fromHtml("<b>Health</b>"));
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_POLICY:
                changeTitle(FragmentsHealthTags.HEALTH_POLICY);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_CALCULATOR:
                changeTitle(FragmentsHealthTags.HEALTH_CALCULATOR);
                break;
            case FragmentsHealthTags.FRAGMENT_HOMECARE:
                changeTitle(FragmentsHealthTags.HOMECARE);
                break;
            case FragmentsHealthTags.FRAGMENT_BMI_CALC:
                changeTitle(FragmentsHealthTags.BMI_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_WHR_CALC:
                changeTitle(FragmentsHealthTags.WHR_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_PREGNANCY_CALC:
                changeTitle(FragmentsHealthTags.PREGNANCY_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_BMR_CALC:
                changeTitle(FragmentsHealthTags.BMR_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTHY_WEIGHT_CALC:
                changeTitle(FragmentsHealthTags.HEALTHY_WEIGHT_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_HEART_RISK_CALC:
                changeTitle(FragmentsHealthTags.HEART_RISK_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_BODY_FAT_CALC:
                changeTitle(FragmentsHealthTags.BODY_FAT_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_HEART_RATE_CALC:
                changeTitle(FragmentsHealthTags.HEART_RATE_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_CHOLESTROL_RISK_CALC:
                changeTitle(FragmentsHealthTags.CHOLESTROL_RISK_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_SMOKE_CALC:
                changeTitle(FragmentsHealthTags.SMOKE_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_BAC_CALC:
                changeTitle(FragmentsHealthTags.BAC_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_BLOOD_SUGAR_CALC:
                changeTitle(FragmentsHealthTags.BLOOD_SUGAR_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_BLOOD_PRESSURE_CALC:
                changeTitle(FragmentsHealthTags.BLOOD_PRESSURE_CALC);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_TIPS:
                changeTitle(FragmentsHealthTags.TIPS_HEALTH);
                break;
            case FragmentsHealthTags.FRAGMENT_DIETCHART:
                changeTitle(FragmentsHealthTags.DIETCHART);
                break;
            case FragmentsHealthTags.FRAGMENT_ADD_WATER_INTAKE:
                changeTitle(FragmentsHealthTags.ADD_WATER_INTAKE);
                break;
            case FragmentsHealthTags.FRAGMENT_ADD_CALORIE_INTAKE:
                changeTitle(FragmentsHealthTags.ADD_CALORIE_INTAKE);
                break;
            case FragmentsHealthTags.FRAGMENT_ADD_FOOD_INTAKE:
                changeTitle(FragmentsHealthTags.FOOD_INTAKE);
                break;
            case FragmentsHealthTags.FRAGMENT_TRACKER:
                changeTitle(FragmentsHealthTags.TRACKER);
                break;
            case FragmentsHealthTags.FRAGMENT_DOCUMENTS:
                changeTitle(FragmentsHealthTags.DOCUMENTS);
                break;
            case FragmentsHealthTags.FRAGMENT_HRA:
                changeTitle(FragmentsHealthTags.HRA);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_PROFILE:
                changeTitle(FragmentsHealthTags.HEALTH_PROFILE);
                break;
            case FragmentsHealthTags.FRAGMENT_BASIC_PROFILE:
                changeTitle(FragmentsHealthTags.BASIC_PROFILE);
                break;
            case FragmentsHealthTags.FRAGMENT_RISK_PROFILE:
                changeTitle(FragmentsHealthTags.RISK_PROFILE);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_REMINDER:
                changeTitle(FragmentsHealthTags.HEALTH_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_FOOD_REMINDER:
                changeTitle(FragmentsHealthTags.FOOD_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_WATER_REMINDER:
                changeTitle(FragmentsHealthTags.WATER_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_WALK_REMINDER:
                changeTitle(FragmentsHealthTags.WALK_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_WORKOUT_REMINDER:
                changeTitle(FragmentsHealthTags.WORKOUT_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_WEIGHT_REMINDER:
                changeTitle(FragmentsHealthTags.WEIGHT_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_MEDICINE_REMINDER:
                changeTitle(FragmentsHealthTags.MEDICINE_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_CONSULTATION_REMINDER:
                changeTitle(FragmentsHealthTags.CONSULTATION_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_LAB_TEST_REMINDER:
                changeTitle(FragmentsHealthTags.LAB_TEST_REMINDER);
                break;
            case FragmentsHealthTags.FRAGMENT_FAMILY_INFO:
                changeTitle(FragmentsHealthTags.FAMILY_INFO);
                break;
            case FragmentsHealthTags.FRAGMENT_MEDICAL_INFO:
                changeTitle(FragmentsHealthTags.MEDICAL_INFO);
                break;
            case FragmentsHealthTags.FRAGMENT_STATS:
                changeTitle(FragmentsHealthTags.STATS);
                break;
            case FragmentsHealthTags.FRAGMENT_MEDICAL_HISTORY:
                changeTitle(FragmentsHealthTags.MEDICAL_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_MEDICAL_RECORDS:
                changeTitle(FragmentsHealthTags.MEDICAL_RECORDS);
                break;
            case FragmentsHealthTags.FRAGMENT_FAMILY_HISTORY:
                changeTitle(FragmentsHealthTags.FAMILY_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_CORPORATE_MY_POLICY:
                changeTitle(FragmentsHealthTags.CORPORATE_MY_POLICY);
                break;
            case FragmentsHealthTags.FRAGMENT_CORPORATE_CLAIM:
                changeTitle(FragmentsHealthTags.CORPORATE_CLAIM);
                break;
            case FragmentsHealthTags.FRAGMENT_CORPORATE_ECARD:
                changeTitle(FragmentsHealthTags.CORPORATE_ECARD);
                break;
            case FragmentsHealthTags.FRAGMENT_CORPORATE_GMP:
                changeTitle(FragmentsHealthTags.CORPORATE_GMP);
                break;
            case FragmentsHealthTags.FRAGMENT_CORPORATE_GPA:
                changeTitle(FragmentsHealthTags.CORPORATE_GPA);
                break;
            case FragmentsHealthTags.FRAGMENT_CORPORATE_GTL:
                changeTitle(FragmentsHealthTags.CORPORATE_GTL);
                break;
            case FragmentsHealthTags.FRAGMENT_INDIVIDUAL_MY_POLICY:
                changeTitle(FragmentsHealthTags.INDIVIDUAL_MY_POLICY);
                break;
            case FragmentsHealthTags.FRAGMENT_LINK_NEW_POLICY:
                changeTitle(FragmentsHealthTags.LINK_NEW_POLICY);
                break;
            case FragmentsHealthTags.FRAGMENT_NEARBY:
                changeTitle(FragmentsHealthTags.NEARBY);
                break;
            case FragmentsHealthTags.FRAGMENT_SETTINGS:
                changeTitle(FragmentsHealthTags.SETTINGS);
                break;
            case FragmentsHealthTags.FRAGMENT_ABOUT_US:
                changeTitle(FragmentsHealthTags.ABOUT_US);
                break;
            case FragmentsHealthTags.FRAGMENT_TERMS_CONDITION:
                changeTitle(FragmentsHealthTags.TERMS_CONDITION);
                break;
            case FragmentsHealthTags.FRAGMENT_PRIVACY_POLICY:
                changeTitle(FragmentsHealthTags.PRIVACY_POLICY);
                break;
            case FragmentsHealthTags.FRAGMENT_NOTIFICATION:
                changeTitle(FragmentsHealthTags.NOTIFICATION);
                break;
            case FragmentsHealthTags.FRAGMENT_HELP:
                changeTitle(FragmentsHealthTags.HELP);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_REGISTER:
                changeTitle(FragmentsHealthTags.HEALTH_REGISTER);
                break;
            case FragmentsHealthTags.FRAGMENT_BLOOD_PRESSURE:
                changeTitle(FragmentsHealthTags.BLOOD_PRESSURE);
                break;
            case FragmentsHealthTags.FRAGMENT_BLOOD_SUGAR:
                changeTitle(FragmentsHealthTags.BLOOD_SUGAR);
                break;
            case FragmentsHealthTags.FRAGMENT_BLOGS:
                changeTitle(FragmentsHealthTags.BLOGS);
                break;
            case FragmentsHealthTags.FRAGMENT_BLOG_DETAIL:
                changeTitle(FragmentsHealthTags.BLOG_DETAIL);
                break;
            case FragmentsHealthTags.FRAGMENT_PRESCRIPTION:
                changeTitle(FragmentsHealthTags.PRESCRIPTION);
                break;
            case FragmentsHealthTags.FRAGMENT_OTHER:
                changeTitle(FragmentsHealthTags.OTHER);
                break;
            case FragmentsHealthTags.FRAGMENT_REPORT:
                changeTitle(FragmentsHealthTags.REPORT);
                break;
            case FragmentsHealthTags.FRAGMENT_FOOD_TRACKING:
                changeTitle(FragmentsHealthTags.FOOD_TRACKING);
                break;
            case FragmentsHealthTags.FRAGMENT_WATER_TRACKING:
                changeTitle(FragmentsHealthTags.WATER_TRACKING);
                break;
            case FragmentsHealthTags.FRAGMENT_MY_CHALLENGES:
                changeTitle(FragmentsHealthTags.MY_CHALLENGES);
                break;
            case FragmentsHealthTags.FRAGMENT_WEIGHT_LOG:
                changeTitle(FragmentsHealthTags.WEIGHT_LOG);
                break;
            case FragmentsHealthTags.FRAGMENT_INVITE:
                changeTitle(FragmentsHealthTags.INVITE);
                break;
            case FragmentsHealthTags.FRAGMENT_SWEAT_IT_OUT:
                changeTitle(FragmentsHealthTags.SWEAT_IT_OUT);
                break;
            case FragmentsHealthTags.FRAGMENT_DIARY:
                changeTitle(FragmentsHealthTags.DIARY);
                break;
            case FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE:
                changeTitle(FragmentsHealthTags.TODAY_EXERCISE);
                break;
            case FragmentsHealthTags.FRAGMENT_SET_YOUR_TARGET:
                changeTitle(FragmentsHealthTags.SET_YOUR_TARGET);
                break;
            case FragmentsHealthTags.FRAGMENT_FITNESS_TRACKER_MENU:
                changeTitle(FragmentsHealthTags.FITNESS_TRACKER_MENU);
                break;
            case FragmentsHealthTags.FRAGMENT_DOCTOR_APPOINTMENT_HISTORY:
                changeTitle(FragmentsHealthTags.DOCTOR_APPOINTMENT_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_ONLINE_CONSULTATION_HISTORY:
                changeTitle(FragmentsHealthTags.ONLINE_CONSULTATION_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_LAB_TESTS_HISTORY:
                changeTitle(FragmentsHealthTags.LAB_TESTS_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_MEDICINE_ORDER_HISTORY:
                changeTitle(FragmentsHealthTags.MEDICINE_ORDER_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_HOMECARE_HISTORY:
                changeTitle(FragmentsHealthTags.HOMECARE_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_PACKAGES_HISTORY:
                changeTitle(FragmentsHealthTags.HEALTH_PACKAGES_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_WELLNESS_CENTER_HISTORY:
                changeTitle(FragmentsHealthTags.WELLNESS_CENTER_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_REDEEM_POINTS:
                changeTitle(FragmentsHealthTags.REDEEM_POINTS);
                break;
            case FragmentsHealthTags.FRAGMENT_COUPON_CODE:
                changeTitle(FragmentsHealthTags.COUPON_CODE);
                break;
            case FragmentsHealthTags.FRAGMENT_BOOKING_HISTORY:
                changeTitle(FragmentsHealthTags.BOOKING_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_LOG_ACTIVITY:
                changeTitle(FragmentsHealthTags.LOG_ACTIVITY);
                break;
            case FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB:
                changeTitle(FragmentsHealthTags.HRA_REPORTS_TAB);
                break;
            case FragmentsHealthTags.FRAGMENT_APPOINTMENT_PAGE:
                changeTitle(FragmentsHealthTags.APPOINTMENT_PAGE);
                break;
            case FragmentsHealthTags.FRAGMENT_LOYALTY:
                changeTitle(FragmentsHealthTags.LOYALTY);
                break;
            case FragmentsHealthTags.FRAGMENT_BADGES:
                changeTitle(FragmentsHealthTags.BADGES);
                break;
            case FragmentsHealthTags.FRAGMENT_POINTS_SUMMARY:
                changeTitle(FragmentsHealthTags.POINTS_SUMMARY);
                break;
            case FragmentsHealthTags.FRAGMENT_PURCHASE_HISTORY:
                changeTitle(FragmentsHealthTags.PURCHASE_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_BASIC_QUESTION:
                changeTitle(FragmentsHealthTags.BASIC_QUESTION);
                break;
            case FragmentsHealthTags.FRAGMENT_YOUR_ANSWERS:
                changeTitle(FragmentsHealthTags.YOUR_ANSWERS);
                break;
            case FragmentsHealthTags.REGISTER_BLOOD_PRESSURE_TAG:
                changeTitle(FragmentsHealthTags.REGISTER_BLOOD_PRESSURE);
                break;
            case FragmentsHealthTags.REGISTER_BLOOD_SUGAR_TAG:
                changeTitle(FragmentsHealthTags.REGISTER_BLOOD_SUGAR);
                break;
            case FragmentsHealthTags.DIARY_DIET_TAG:
                changeTitle(FragmentsHealthTags.DIARY_DIET);
                break;
            case FragmentsHealthTags.DIARY_EXERCISE_TAG:
                changeTitle(FragmentsHealthTags.DIARY_EXERCISE);
                break;
            case FragmentsHealthTags.DIARY_WATER_TAG:
                changeTitle(FragmentsHealthTags.DIARY_WATER);
                break;
            case FragmentsHealthTags.FRAGMENT_WYH_HRA:
                changeTitle(FragmentsHealthTags.WYH_HRA);
                break;
            case FragmentsHealthTags.FRAGMENT_UPLOAD_DOC:
                changeTitle(FragmentsHealthTags.UPLOAD_DOC);
                break;
            case FragmentsHealthTags.FRAGMENT_VALUE_ADD:
                changeTitle(FragmentsHealthTags.VALUE_ADD);
                break;
            case FragmentsHealthTags.FRAGMENT_MY_ISSUE:
                changeTitle(FragmentsHealthTags.MY_ISSUE);
                break;
            case FragmentsHealthTags.FRAGMENT_TRANSACTION_HISTORY:
                changeTitle(FragmentsHealthTags.TRANSACTION_HISTORY);
                break;
            case FragmentsHealthTags.FRAGMENT_COVID_ASSESSMENT:
                changeTitle(FragmentsHealthTags.COVID_ASSESSMENT);
                break;
            case FragmentsHealthTags.FRAGMENT_HOME_REMEDIES:
                changeTitle(FragmentsHealthTags.HOME_REMEDIES);
                break;
            case FragmentsHealthTags.FRAGMENT_HEALTH_BUY_POLICY:
                changeTitle(FragmentsHealthTags.HEALTH_BUY_POLICY);
                break;
            default:
                break;
        }
    }

    public void changeTitle(String Title) {
        mTitle1.setText(Title);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void getCurrentFragment() {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager.getBackStackEntryCount() == 1) {
                if (exitFlag == 0) {
                    exitFlag = 1;
                    backTime = System.currentTimeMillis();
                    Toast.makeText(this, "Press again to close Pulz App", Toast.LENGTH_SHORT).show();
                } else {
                    if (System.currentTimeMillis() <= backTime + 3000) {
                        finish();
                    } else {
                        Toast.makeText(this, "Press again to close Pulz App", Toast.LENGTH_SHORT).show();
                        exitFlag = 1;
                        backTime = System.currentTimeMillis();
                    }
                }
            } else {
                String fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 2).getName();
                assert fragmentTag != null;
                detect(fragmentTag);
                invalidateOptionsMenu();
                if (fragmentTag.equals(FragmentsHealthTags.DASH_BOARD_FRAGMENT1)) {
                    tvhome.setTextColor(ContextCompat.getColor(this, R.color.black));
                    iconhome.setTextColor(ContextCompat.getColor(this, R.color.black));
                }
                super.onBackPressed();
            }
        } catch (Exception e) {
                        e.printStackTrace();
                    }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.dashboard_home1:
                popUpLayoutGone();
                getCurrentLocation();
                tvhome.setTextColor(ContextCompat.getColor(this, R.color.black));
                iconhome.setTextColor(ContextCompat.getColor(this, R.color.black));

                tvlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                fitness_icon.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                fitness_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                ambulance_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                Fragment frag = new FragmentDashBoardHealth();
                Bundle args = new Bundle();
                args.putString("hidevalue", "0");
                frag.setArguments(args);
                FragmentsTransactionsUtils.addFragmentAgain(MainActivityHealth.this, frag, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
                changeTitle(FragmentsHealthTags.META_HEALTH);
                invalidateOptionsMenu();
                break;
            case R.id.dashboard_location:
                popUpLayoutGone();
                getCurrentLocation();
                tvhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvlocator.setTextColor(ContextCompat.getColor(this, R.color.black));
                iconlocator.setTextColor(ContextCompat.getColor(this, R.color.black));

                tvmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                fitness_icon.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                fitness_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                ambulance_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                removeAllFragemntPutOnlyDashboardFragment();
                Fragment frag_nearby = new FragmentNearby();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(MainActivityHealth.this, frag_nearby, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_NEARBY);
                changeTitle(FragmentsHealthTags.NEARBY);
                break;

            case R.id.dashboard_market:
                popUpLayoutGone();
                getCurrentLocation();
                tvhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvmarket.setTextColor(ContextCompat.getColor(this, R.color.black));
                iconmarket.setTextColor(ContextCompat.getColor(this, R.color.black));

                fitness_icon.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                fitness_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                ambulance_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

//                removeAllFragemntPutOnlyDashboardFragment();
//                Fragment frag1 = new FragmentDashBoardHealth();
//                Bundle args1 = new Bundle();
//                args1.putString("hidevalue", "1");
//                frag1.setArguments(args1);
//                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(MainActivityHealth.this, frag1, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
//                changeTitle(FragmentsHealthTags.META_HEALTH);
                removeAllFragemntPutOnlyDashboardFragment();
                Fragment BuyPolicyFrag = new BuyPolicyMenu();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(MainActivityHealth.this, BuyPolicyFrag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_BUY_POLICY);
                changeTitle(FragmentsHealthTags.FRAGMENT_HEALTH_BUY_POLICY);

                break;
            case R.id.drawer_head1:
                popUpLayoutGone();
                getCurrentLocation();
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsHealthTags.HEALTH_PROFILE);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentHealthProfile(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_PROFILE);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.dashboard_fitness:
                popUpLayoutGone();
                getCurrentLocation();
                tvhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                fitness_icon.setTextColor(ContextCompat.getColor(this, R.color.black));
                fitness_text.setTextColor(ContextCompat.getColor(this, R.color.black));

                ambulance_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                removeAllFragemntPutOnlyDashboardFragment();
                Fragment frag_medical_record = new FragmentMedicalRecords();
//                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(MainActivityHealth.this, frag_medical_record, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_MEDICAL_RECORDS);
//                changeTitle(FragmentsHealthTags.MEDICAL_RECORDS);
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(MainActivityHealth.this, frag_medical_record, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_MEDICAL_REWARDS);
                changeTitle(FragmentsHealthTags.REWORDS);
                break;

            case R.id.dashboard_ambulance1:
                popUpLayoutGone();
                getCurrentLocation();
                removeAllFragemntPutOnlyDashboardFragment();
                tvhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                tvmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                iconmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                fitness_icon.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                fitness_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

                ambulance_text.setTextColor(ContextCompat.getColor(this, R.color.black));

                ambulanceDialog();
                break;
        }
    }

    void removeSelectorOnBottom() {
        tvhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
        iconhome.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

        tvlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
        iconlocator.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

        tvmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
        iconmarket.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

        fitness_icon.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
        fitness_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));

        ambulance_text.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
    }

    public void removeAllFragemntPutOnlyDashboardFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(1).getId(), getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkForFirstTime();
        checkLog();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver, new IntentFilter(Config.PUSH_NOTIFICATION));
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void changeIcon(String readFlag) {
        invalidateOptionsMenu();
    }

    @Override
    public void changeFragmnet() {
        removeAllFragemntPutOnlyDashboardFragment();
        mTitle.setText(Html.fromHtml("<b>Health</b>"));
    }

    void startFCM() {
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (Objects.equals(intent.getAction(), Config.PUSH_NOTIFICATION)) {
                    String message = intent.getStringExtra("message");
                    Log.e("Push notification: ", message);
                }
            }
        };
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    @Override
    public void onKeyboardVisibilityChanged(boolean keyboardVisible) {
        if (!keyboardVisible) {
            home_bottom.setVisibility(View.VISIBLE);
        } else {
            home_bottom.setVisibility(View.GONE);
        }
    }

    void closeLayoutOndrwerClick() {
        if (locator.getVisibility() == View.VISIBLE || fitness.getVisibility() == View.VISIBLE || market.getVisibility() == View.VISIBLE || tips_dialog.getVisibility() == View.VISIBLE) {
            popUpLayoutGone();
            removeSelectorOnBottom();
        }
    }

    @Override
    public void getImageBitmap(Bitmap bitmap, int Tag) {
        if (Tag == 1) {
            String compressFile = saveImageToFile(bitmap, getFileName());
            Bitmap bitmap1 = BitmapFactory.decodeFile(compressFile);
            img_user.setImageBitmap(bitmap1);
        }
    }

    @Override
    public void getImageBitmapError(VolleyError error, int Tag) { }

    String saveImageToFile(Bitmap bmp, String filename) {
        FileOutputStream out = null;
        String filePath = null;
        try {
            out = new FileOutputStream(filename);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            filePath = compressNow(filename);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }

    String getFileName() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "profile.png");
        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file.getAbsolutePath();
    }

    @Override
    public void changeFragment(Fragment fragment, String fragmentTag) {
        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(MainActivityHealth.this, fragment, R.id.main_frame1, fragmentTag);
        changeTitle(fragmentTag);
    }

    void sendTokenToServer() {
        MySharedPreference pref = MySharedPreference.getInstance(this);
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("UserId", pref.getUID());
            object.put("DeviceId", pref.getDeviecToken());
            object.put("DeviceType","Andriod");
            object.put("DeviceName","");
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                UrlConstants.SEND_DEVICE_DETAIL, object,
                response -> {
                }, error -> { }
        );
        MyApplication.getInstance().addToRequestQueue(jsonObjReq, "" + "12");
    }

    @Override
    public void fragemntTransfer(Fragment f, String tag, String img_url) {
        if (tag.equalsIgnoreCase(FragmentsTags.DOCUMENTS_FRAGMENT))
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(this, new FragmentDocuments(), R.id.main_frame1, FragmentsTags.DOCUMENTS_FRAGMENT);
        if (tag.equalsIgnoreCase(FragmentsHealthTags.DASH_BOARD_FRAGMENT1))
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(this, f, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
    }

    void ambulanceDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.ambulance_popup_1);
        TextView sos_name = dialog.findViewById(R.id.sos_name);
        TextView sos_number = dialog.findViewById(R.id.sos_number);
        TextView ambulance_sos = dialog.findViewById(R.id.ambulance_sos);
        LinearLayout ambulance_number = dialog.findViewById(R.id.ambulance_number);
        LinearLayout emergency_contact_number = dialog.findViewById(R.id.emergency_contact_number);
        TextView cancel = dialog.findViewById(R.id.cancel);

        sos_name.setText(EmergencyContactPersonName);
        sos_number.setText(EmergencyContactNo);
        ambulance_sos.setText(AmbulanceNo);

        cancel.setOnClickListener(v -> {
            removeSelectorOnBottom();
            dialog.dismiss();
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                tvhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
                iconhome.setTextColor(ContextCompat.getColor(MainActivityHealth.this, R.color.black));
                removeAllFragemntPutOnlyDashboardFragment();
                Fragment frag1 = new FragmentDashBoardHealth();
                Bundle args1 = new Bundle();
                args1.putString("hidevalue", "0");
                frag1.setArguments(args1);
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(MainActivityHealth.this, frag1, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
                changeTitle(FragmentsHealthTags.META_HEALTH);
            }
        });

        emergency_contact_number.setOnClickListener(v -> {
            new AppDataPushApi().callApi(MainActivityHealth.this,"SOS Dialog","SOS - Emergency conatct call button","User called to his emergency contact person " + EmergencyContactPersonName + " & number " + EmergencyContactNo);
            removeSelectorOnBottom();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + EmergencyContactNo));
            startActivity(intent);
            dialog.dismiss();
        });

        ambulance_number.setOnClickListener(v -> {
            new AppDataPushApi().callApi(MainActivityHealth.this,"SOS Dialog","SOS - Ambulance service call button","User called for ambulance service");
            removeSelectorOnBottom();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + AmbulanceNo));
            startActivity(intent);
            dialog.dismiss();
        });

        dialog.show();
    }

    void popUpLayoutGone() {
        fitness.setVisibility(View.GONE);
        market.setVisibility(View.GONE);
        locator.setVisibility(View.GONE);
        tips_dialog.setVisibility(View.GONE);
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(activity.getCurrentFocus()).getWindowToken(), 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getSosDetails() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO,pref.getToken_no());
            object.put("UserID", pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(this, object, UrlHealthConstants.GET_SOS_DETAILS, this, RequestHealthConstants.GET_SOS_DETAILS);
        req.execute();
    }

    private void getbasicquestions(){
        int number = db.getAllBasicSymptomWithChoiceID0(pref.getUID(), pref.getSymptominterviewid());
        if (number >= 0 && number < 5) {
            show();
        } else {
            db.deleteBasicInterviewId(pref.getSymptominterviewid());
            changeFragmnet();
        }
    }



    public void checkLog(){
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("AppType", "0");

        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(MainActivityHealth.this, object, UrlConstants.LAST_ACTIVITY_LOG, new ResponseListener() {

            @Override
            public void onSuccess(JSONObject object, int Tag) {
                Log.d("Response" , String.valueOf(object));
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_LOGIN);
        req.execute();
    }

    public void checkUser(){

        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",pref.getToken_no());
            object.put("userId", pref.getUID());
            object.put("DeviceId",deviceId);
            object.put("DeviceType", "0");
            object.put("DeviceVersion", deviceVersion);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(MainActivityHealth.this, object, UrlConstants.URL_CHECK_DEVICE_STATUS, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                Log.d("Response" , String.valueOf(object));

                try {
                    String messageType = object.getString("MessageType");
                    String message = object.getString("Message");
                    switch (messageType) {
                        case "5":
                        case "3":
                        case "0":
                            break;
                        case "4":
                            showOnErrorDialog2(message);
                            break;
                        case "1":
                            showMessageToUser(message, messageType);
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
        }, RequestConstants.URL_LOGIN);
        req.execute();
    }

    void showMessageToUser(final String message, final String messageType) {
        final Dialog dialog = new Dialog(this, R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.version_check_dialog);
        TextView Ok = dialog.findViewById(R.id.version_check_ok);
        TextView messageText = dialog.findViewById(R.id.version_check_message);
        if (messageType.equalsIgnoreCase("4")){
            messageText.setText(message);
        }else {
            messageText.setText("You have recently logged in another device.\n To continue please login again");
        }

        Ok.setOnClickListener(v -> {
            dialog.dismiss();
            dialog.dismiss();
            switch (messageType) {
                case "1":
                case "2": {
                    dialog.dismiss();
                    MySharedPreference.getInstance(MainActivityHealth.this).clearAll();
                    Intent in = new Intent(MainActivityHealth.this, LoginActivity.class);
                    startActivity(in);
                    finish();
                    break;
                }
                case "4": {
                    MySharedPreference.getInstance(MainActivityHealth.this).clearAll();
                    Intent in = new Intent(MainActivityHealth.this, LoginActivity.class);
                    startActivity(in);
                    finish();
                    break;
                }
            }
        });

        dialog.show();
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
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
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

    private void callApi_profile() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(this, object, UrlHealthConstants.GET_PROFILE_DETAIL, this, RequestHealthConstants.GET_PROFILE_DETAIL);
        req.execute();
    }

    private void getCurrentDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        int curYear = c.get(Calendar.YEAR);
        int curMonth = c.get(Calendar.MONTH);
        int curDay = c.get(Calendar.DAY_OF_MONTH);
        reminderDate = initDay(curDay) + "/" + (curMonth + 2) + "/" + curYear;
    }
    private String initDay(int day) {
        String days;
        if (day <= 9) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        return days;
    }

    private void setAlarms(){
        ReminderForNotification reminder = new ReminderForNotification();
        reminder.insertValues(MainActivityHealth.this,"BloodPressure","12080",reminderDate,"08:30","first","active");
        reminder.insertValues(MainActivityHealth.this,"BloodSugar","80120",reminderDate,"09:30","first","active");
        reminder.insertValues(MainActivityHealth.this,"HbA","1114",reminderDate,"10:30","first","active");
        reminder.insertValues(MainActivityHealth.this,"LipidProfile","0200",reminderDate,"11:30","first","active");
        reminder.insertValues(MainActivityHealth.this,"Thyroid","0220",reminderDate,"07:30","first","active");
        reminder.insertValues(MainActivityHealth.this,"Allergies","123450",reminderDate,"7:00","first","active");
        reminder.insertValues(MainActivityHealth.this,"MedicalHistory","0600",reminderDate,"08:00","first","active");
        reminder.insertValues(MainActivityHealth.this,"FamilyHistory","2410",reminderDate,"09:00","first","active");
        reminder.insertValues(MainActivityHealth.this,"FitnessDevices","0600",reminderDate,"06:45","first","active");
        reminder.insertValues(MainActivityHealth.this,"MedicalRecords","2250",reminderDate,"10:00","first","active");
        reminder.insertValues(MainActivityHealth.this,"WaterData","0600",reminderDate,"11:00","first","active");
        reminder.insertValues(MainActivityHealth.this,"WeightData","0600",reminderDate,"12:00","first","active");
        reminder.insertValues(MainActivityHealth.this,"FoodData","0600",reminderDate,"12:30","first","active");
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

    private void promotionalpopup() {
        final Dialog promo_dialog = new Dialog(this);
        promo_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        promo_dialog.setCanceledOnTouchOutside(true);
        promo_dialog.setCancelable(true);
        Objects.requireNonNull(promo_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        promo_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        promo_dialog.setContentView(R.layout.dialog_promo);
        RelativeLayout layout_close;
        layout_close = promo_dialog.findViewById(R.id.layout_close);

        layout_close.setOnClickListener(v -> promo_dialog.dismiss());

        promo_dialog.show();
    }
    public void statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Location seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
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

    private void getCurrentLocation() {
        locationManager = (LocationManager) Objects.requireNonNull(MainActivityHealth.this).getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true));

        //You can still do this if you like, you might get lucky:
        if (ActivityCompat.checkSelfPermission(MainActivityHealth.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivityHealth.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
            if (MainActivityHealth.this != null) {
                MainActivityHealth.this.runOnUiThread(() -> {
                    Geocoder geocoder;
                    List<Address> addresses = null;
                    geocoder = new Geocoder(MainActivityHealth.this, Locale.getDefault());
                    try {
                        addresses = geocoder.getFromLocation(latitude, longitude, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (addresses != null) {
                        String  city = addresses.get(0).getLocality();
                        String   state = addresses.get(0).getAdminArea();
                    }
                });
            }
        } else {
            //This is what you need:
            if (ActivityCompat.checkSelfPermission(MainActivityHealth.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivityHealth.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
//            locationManager.requestLocationUpdates(bestProvider, 1000, 0, this);
        }
    }

    private Location getLastKnownLocation() {
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(MainActivityHealth.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivityHealth.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
    public void onLocationChanged(@NonNull Location location) {
        locationManager.removeUpdates(this);
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }


    //shivani

    private void logout(){
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",pref.getToken_no());
            object.put("userId", pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getApplicationContext(), object, UrlConstants.URL_LOGOUT_USER, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Logout")) {
                    Toast.makeText(getApplicationContext(),"Logged Out Successfully",Toast.LENGTH_SHORT).show();
                    tr_db.deleteTriage(pref.getUID());
                    db1.deleteSelectedSymp(pref.getUID());
                    db2.deleteResult(pref.getUID());
                    db3.deleteCondition(pref.getUID());
                    db4.deleteBasicQuestion(pref.getUID());
                    db5.deleteLifestyleHRA(pref.getUID());
                    db6.deleteResultLifestyle(pref.getUID());
                    Objects.requireNonNull(getApplicationContext()).deleteDatabase("consultation_reminder_db");
                    getApplicationContext().deleteDatabase("food_reminder_db");
                    getApplicationContext().deleteDatabase("food_type_reminder_db");
                    getApplicationContext().deleteDatabase("lab_test_reminder_db");
                    getApplicationContext().deleteDatabase("medicine_reminder_db");
                    getApplicationContext().deleteDatabase("walk_type_reminder_db");
                    getApplicationContext().deleteDatabase("water_type_reminder_db");
                    getApplicationContext().deleteDatabase("weight_reminder_db");
                    getApplicationContext().deleteDatabase("workout_type_reminder_db");
                    MySharedPreference.getInstance(getApplicationContext()).clearAll();
                    Intent in = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(in);
                    MainActivityHealth.this.finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_LOGOUT_USER);
        req.execute();
    }


}
