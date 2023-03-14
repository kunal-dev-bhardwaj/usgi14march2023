package com.universalsompo.meta.metaapp.motor.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.google.android.material.navigation.NavigationView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.activities.TutorialActivity;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ConditionsDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.SelectedSympDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.TriageDatabaseHelper;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.constants.Config;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.BuyPolicyMotor;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentClaim;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentContent;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentDashBoard;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentDocuments;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMaintenanceSchedule;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMotorHelp;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMotorNearby;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentNotification;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentProfile;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentRSS;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentRenewals;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentServiceItem;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentTermsCondition;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentTips;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentTrackingStatusPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.FragmnetServiceAppointment;
import com.universalsompo.meta.metaapp.motor.fragments.FratgmentPrivacyPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.MyIssueMotorList;
import com.universalsompo.meta.metaapp.motor.fragments.ServiceFragment;
import com.universalsompo.meta.metaapp.intefaces.AddFragmentCallback;
import com.universalsompo.meta.metaapp.intefaces.ChangeOptionIconInterface;
import com.universalsompo.meta.metaapp.intefaces.DocumentCallback;
import com.universalsompo.meta.metaapp.intefaces.ImageListenerInterface;
import com.universalsompo.meta.metaapp.intefaces.KeyboardVisibilityListener;
import com.universalsompo.meta.metaapp.intefaces.NnvigationUpdater;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy2;
import com.universalsompo.meta.metaapp.utilities.BaseActivity;
import com.universalsompo.meta.metaapp.utilities.CacheUtils;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.GPSTracker;
import com.universalsompo.meta.metaapp.utilities.KeyboardUtil;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.MyApplication;
import com.universalsompo.meta.metaapp.utilities.MyCheckPermission;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;
import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;

public class MainActivity extends BaseActivity implements NnvigationUpdater,
        NavigationView.OnNavigationItemSelectedListener, SelectorListener,
        View.OnClickListener, DocumentCallback, ChangeOptionIconInterface, KeyboardVisibilityListener, ImageListenerInterface, AddFragmentCallback, ResponseListener , LocationListener {

    public static LinearLayout dashboard_home;
    public static LinearLayout dashboard_location;
    public static LinearLayout dashboard_menu;
    public static LinearLayout dashboard_menu_cut;
    public static LinearLayout dashboard_benifit;
    public static LinearLayout dashboard_callus;
    private static LinearLayout dashboard_ambulance;
    private NavigationView navigationView;
    private View headerView;
    private TextView txt_userName;
    private TextView txt_userPhn;
    private TextView version_display;
    public static CircleImageView img_user;
    private LinearLayout drawer_head_layout;
    private DrawerLayout drawer;
    public static LinearLayout menu;
    public static LinearLayout locator;
    public static LinearLayout bebefits, tips_dialog;
    private TextView mTitle;
    private MySharedPreference pref;
    private String tipReadStatus = "true";
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private boolean keyboardFlag = false;
    private LinearLayout home_bottom;
    public static TextView icongift, iconlocator, iconhome, tvcall, tvgift, tvlocator, tvhome, dashboard_menu1, dashboard_menu_cut1;
    private int exitFlag = 0;
    private long backTime;

    View health_menu_changer;
    public  static  final int main_frame_id=R.id.main_frame;
    private final int  REQUEST_CODE_FOR_INTRO = 100;

    Toolbar toolbar;

    private GuideView mGuideView;
    private GuideView.Builder builder;
    View tips_view;
    private String deviceVersion;
    private String deviceId;

    TriageDatabaseHelper db;
    SelectedSympDatabaseHelper db1;
    ResultDatabaseHelper db2;
    ConditionsDatabaseHelper db3;
    BasicQuesDatabaseHelper db4;
    LifestyleHRADatabaseHelper db5;
    LifestyleResultDatabaseHelper db6;
    private int FLAG_TIPS = 0;

    private static final String PACKAGE_NAME = "com.universalsompo.meta";
    public LocationManager locationManager;
    public Criteria criteria;
    public String bestProvider;
    GPSTracker gps;
    double latitude ,longitude;

    @SuppressLint("HardwareIds")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
//        statusCheck();


//        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//            buildAlertMessageNoGps();
//
//        }else {
//            getCurrentLocation();
//        }

        pref = MySharedPreference.getInstance(MainActivity.this);
        db = new TriageDatabaseHelper(this);
        db1 = new SelectedSympDatabaseHelper(this);
        db2 = new ResultDatabaseHelper(this);
        db3 = new ConditionsDatabaseHelper(this);
        db4 = new BasicQuesDatabaseHelper(this);
        db5 = new LifestyleHRADatabaseHelper(this);
        db6 = new LifestyleResultDatabaseHelper(this);

        deviceId =  Settings.Secure.getString(MainActivity.this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            deviceVersion = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        checkUser();

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        intView();

        mTitle.setText(Html.fromHtml("<b>Motor</b>"));
        FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
        startFCM();
//        checkAppPermission();
        init();

        final View activityRootView = findViewById(R.id.content_main);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
            if (heightDiff > dpToPx(MainActivity.this, 200)) { // if more than 200 dp, it's probably a keyboard...
                home_bottom.setVisibility(View.GONE);
            } else {
                home_bottom.setVisibility(View.VISIBLE);
            }
        });
        sendTokenToServer();
        checkLog();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void remove_elevation() {
        toolbar.setElevation(0.0f);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void show_elevation() {
        toolbar.setElevation(5.0f);
    }


    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    @Override
    public void onBackPressed() {
        invalidateOptionsMenu();

        if (menu.getVisibility() == View.VISIBLE || locator.getVisibility() == View.VISIBLE || bebefits.getVisibility() == View.VISIBLE || tips_dialog.getVisibility() == View.VISIBLE || drawer.isDrawerOpen(GravityCompat.START)) {
            popUpLayoutGone();
            removeSelectorOnBottom();
            removeCrossIcon2();
            drawer.closeDrawer(GravityCompat.START);
        } else {
            getCurrentFragment();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
            iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        }
    }

    @SuppressLint("SetTextI18n")
    void intView() {
        home_bottom = findViewById(R.id.home_bottom);
        dashboard_home = findViewById(R.id.dashboard_home);
        dashboard_location = findViewById(R.id.dashboard_location);
        dashboard_menu = findViewById(R.id.dashboard_menu);
        dashboard_menu_cut = findViewById(R.id.dashboard_menu_cut);
        dashboard_benifit = findViewById(R.id.dashboard_benifit);
        dashboard_ambulance = findViewById(R.id.dashboard_ambulance);
        mTitle = findViewById(R.id.toolbar_title);
        iconhome = findViewById(R.id.iconhome);
        icongift = findViewById(R.id.icongift);
        iconlocator = findViewById(R.id.iconlocator);
        tvcall = findViewById(R.id.tvcall);
        tvhome = findViewById(R.id.tvhome);
        tvgift = findViewById(R.id.tvgift);
        tvlocator = findViewById(R.id.tvlocator);
        dashboard_menu1 = findViewById(R.id.dashboard_menu1);
        dashboard_menu_cut1 = findViewById(R.id.dashboard_menu_cut1);
        version_display = findViewById(R.id.version_display);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        Typeface fontStyle = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-SemiBold.ttf");
        tvcall.setTypeface(fontStyle);
        tvhome.setTypeface(fontStyle);
        tvgift.setTypeface(fontStyle);
        tvlocator.setTypeface(fontStyle);
        iconhome.setTypeface(fontAwesomeFont);
        icongift.setTypeface(fontAwesomeFont);
        iconlocator.setTypeface(fontAwesomeFont);
        dashboard_menu1.setTypeface(fontAwesomeFont);
        dashboard_menu_cut1.setTypeface(fontAwesomeFont);

        headerView = navigationView.getHeaderView(0);
        txt_userName = headerView.findViewById(R.id.txt_nav_username);
        txt_userPhn = headerView.findViewById(R.id.txt_nav_phn);
        img_user = headerView.findViewById(R.id.nav_user_img);
        drawer_head_layout = headerView.findViewById(R.id.drawer_head);

        version_display.setText("Version : " + deviceVersion);

        menu = findViewById(R.id.menu);
        locator = findViewById(R.id.locator);
        bebefits = findViewById(R.id.bebefits);
        tips_dialog = findViewById(R.id.tips_dialog);
        new KeyboardUtil().setKeyboardVisibilityListener(MainActivity.this, this);

        dashboard_home.setOnClickListener(this);
        dashboard_location.setOnClickListener(this);
        dashboard_benifit.setOnClickListener(this);
        dashboard_ambulance.setOnClickListener(this);
        dashboard_menu.setOnClickListener(this);
        drawer_head_layout.setOnClickListener(this);
        dashboard_menu_cut.setOnClickListener(this);

        performActionForMenuBtnLayout();
        performActionForLocatorLayout();
        performActionForBenefitsLayout();
    }

    void setUserInFoInDrawer() {
        headerView = navigationView.getHeaderView(0);
        txt_userName = headerView.findViewById(R.id.txt_nav_username);
        txt_userPhn = headerView.findViewById(R.id.txt_nav_phn);
        img_user = headerView.findViewById(R.id.nav_user_img);
        txt_userName.setText(pref.getUserName());
        txt_userPhn.setText(pref.getMOBILE());

//        if (pref.getProfilePic() != null) {
//            Picasso.get().load(pref.getProfilePic()).fit().placeholder(R.drawable.dummy).into(img_user);
//        }
    }

    String compressNow(final String file) {
        File compressedImage = new Compressor.Builder(MainActivity.this)
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
        switch (frag_title) {
            case FragmentsTags.PROFILE:
                inflater.inflate(R.menu.profile_menu, menu);
                return true;
            case FragmentsTags.NOTIFICATION:
                inflater.inflate(R.menu.clear_notification, menu);
                if (pref.getTotalNotificationCount() != null && pref.getTotalNotificationCount().equals("0")) {
                    menu.removeItem(R.id.clean_notification);
                }
                return true;
            default:
                inflater.inflate(R.menu.policy_menu, menu);
                health_menu_changer = menu.findItem(R.id.health_menu_changer).getActionView();
                health_menu_changer.setOnClickListener(v -> {
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
                    if(!previouslyStarted) {
                        SharedPreferences.Editor edit = prefs.edit();
                        edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
                        edit.commit();
                       /* Intent i = new Intent(MainActivity.this, TutorialActivity.class);
                        startActivity(i);*/
                        Intent i = new Intent(MainActivity.this, MainActivityHealth.class);
                        startActivity(i);

                    } else {
//                        statusCheck();
                        Intent i = new Intent(MainActivity.this, MainActivityHealth.class);
                        startActivity(i);
//                        turnGPSOn();
//                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));


                    }
                    overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
                    finish();

                    //
                });
                View notify_view = menu.findItem(R.id.noitify_menu).getActionView();
                TextView tv_notify_couner = notify_view.findViewById(R.id.tv_notification_couner);
                if (pref.getNotifyUnreadCount() != null)
                    tv_notify_couner.setText(pref.getNotifyUnreadCount());
                notify_view.setOnClickListener(v -> {
                    changeTitle(FragmentsTags.NOTIFICATION);
                    invalidateOptionsMenu();
                    closeLayoutOndrwerClick();
                    removeSelectorOnBottom();
                    FragmentsTransactionsUtils.addNotificationsFragment2(MainActivity.this, new FragmentNotification(), R.id.main_frame, FragmentsTags.NOTIFICATION_FRAGMENT, FragmentsTags.FRAGMENT_TIPS, FragmentsTags.FRAGMENT_MAINTENANCE_SCHEDULE, FragmentsTags.RSS_FEEDS, FragmentsTags.FRAGMENT_CONTENT);
                });


                tips_view = menu.findItem(R.id.tips_menu).getActionView();
                ImageView bulb_icon = tips_view.findViewById(R.id.ppolicy_bulb);

                bulb_icon.setImageDrawable(getResources().getDrawable(R.drawable.bulb_icon));

                tips_view.setOnClickListener(v -> {
                    removeCrossIcon2();
                    closeLayoutOndrwerClick();
                    removeSelectorOnBottom();
                    if (FLAG_TIPS==0){
                        callPopupTips();
                    }else if (FLAG_TIPS==1){
                        popUpLayoutGone();
                        FLAG_TIPS=0;
                    }
                });
                return true;
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (!NetworkUtils.isConnected(this)) {
            Toast.makeText(this, "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return false;
        }
        switch (item.getItemId()) {
            case R.id.health_menu_changer:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
                if(!previouslyStarted) {
                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
                    edit.commit();
                       /* Intent i = new Intent(MainActivity.this, TutorialActivity.class);
                        startActivity(i);*/
                    Intent i = new Intent(MainActivity.this, MainActivityHealth.class);
                    startActivity(i);

                } else {
//                        statusCheck();
                    Intent i = new Intent(MainActivity.this, MainActivityHealth.class);
                    startActivity(i);
//                        turnGPSOn();
//                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));


                }
                overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
                finish();
                break;
            case R.id.nav_policy:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.MY_POLICY);
                Fragment frag = new FragmentPolicy();
                Bundle args = new Bundle();
                args.putInt("otherFrag", 1);
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this,frag, R.id.main_frame, FragmentsTags.POLICY_FRAGMENT);
                break;

            case R.id.nav_document:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.DOCUMENTS);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentDocuments(), R.id.main_frame, FragmentsTags.DOCUMENTS_FRAGMENT);
                break;

            case R.id.nav_claim:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.CLAIM);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentClaim(), R.id.main_frame, FragmentsTags.CLAIM_FRAGMENT);
                break;

            case R.id.nav_renawal:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.RENEWAL);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentRenewals(), R.id.main_frame, FragmentsTags.RENEWALS_FRAGMENT);
                break;

            case R.id.nav_customer_support:
                removeSelectorOnBottom();
                callUsDialog();
                break;

            /*case R.id.nav_about_us:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.ABOUT_US);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentAboutUs(), R.id.main_frame, FragmentsTags.ABOUT_US);
                break;*/

            case R.id.nav_terms_condition:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.TERMS_CONDITION);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmentTermsCondition(), R.id.main_frame, FragmentsTags.TERMS_CONDITION);
                break;

            case R.id.nav_private_policy:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.PRIVACY_POLICY);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FratgmentPrivacyPolicy(), R.id.main_frame, FragmentsTags.FRAGMENT_PRIVACY_POLICY);
                break;

            case R.id.rate_us:
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                }
                catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }
                break;

            case R.id.nav_logout:
                logout();
                break;

            case R.id.nav_tracking_status:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.TRACKING_STATUS);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(MainActivity.this, new FragmentTrackingStatusPolicy(), R.id.main_frame, FragmentsTags.FRAGMENT_TRACKING_STATUS);
                break;

            case R.id.nav_rsa:
                if (pref.getisUSGIUser().equals("1")) {
                    rsaDialog();
                } else {
                    AlertDialogAddPolicy2 addPolicy = new AlertDialogAddPolicy2();
                    addPolicy.showAlertDialogForPolicy(MainActivity.this,"There is no policy added");
                }
                break;

            case R.id.spare_car:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                bottomBenefitsFragmnet(new FragmentServiceItem(), "SpareCars", FragmentsTags.SPARES_CAR);
                break;

            case R.id.service_appoint:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.SERVICE_APPOINTMENT);
                pref.setFragment_Tag(FragmentsTags.SERVICE_APPOINTMENT);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new FragmnetServiceAppointment(), R.id.main_frame, FragmentsTags.FRAGMENT_SERVICE_APPOINTMENT);
                break;

            case R.id.extend_warranty:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                bottomBenefitsFragmnet(new FragmentServiceItem(), "ExtendedWarraty", FragmentsTags.TAG_WARRANTY_NAME);
                break;

            case R.id.spare_parts:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                bottomBenefitsFragmnet(new FragmentServiceItem(), "SpareParts", FragmentsTags.SPARE_PARTS_NAME);
                break;

            case R.id.accessories:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                bottomBenefitsFragmnet(new FragmentServiceItem(), "Acceriess", FragmentsTags.PARTS_ACCESSORIES_NAME);
                break;

            case R.id.preowned:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                bottomBenefitsFragmnet(new FragmentServiceItem(), "Preowned", FragmentsTags.TAG_OWNED_CARS);
                break;

            case R.id.nav_motor_help:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.MOTOR_HELP);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(MainActivity.this, new FragmentMotorHelp(), R.id.main_frame, FragmentsTags.FRAGMENT_MOTOR_HELP);
                break;

            case R.id.nav_motor_my_issues:
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.MY_ISSUE);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, new MyIssueMotorList(), R.id.main_frame, FragmentsTags.FRAGMENT_MY_ISSUE);
                break;
        }
        closeLayoutOndrwerClick();
        invalidateOptionsMenu();
        removeSelectorOnBottom();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout(){
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",pref.getToken_no());
            object.put("userId", pref.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(MainActivity.this, object, UrlConstants.URL_LOGOUT_USER, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                Log.d("Response" , String.valueOf(object));
                if (object.optString("Message").equals("Logout")) {
                    Toast.makeText(MainActivity.this,"Logged Out Successfully",Toast.LENGTH_SHORT).show();
                    db.deleteTriage(pref.getUID());
                    db1.deleteSelectedSymp(pref.getUID());
                    db2.deleteResult(pref.getUID());
                    db3.deleteCondition(pref.getUID());
                    db4.deleteBasicQuestion(pref.getUID());
                    db5.deleteLifestyleHRA(pref.getUID());
                    db6.deleteResultLifestyle(pref.getUID());
                    MySharedPreference.getInstance(MainActivity.this).clearAll();
                    MainActivity.this.deleteDatabase("consultation_reminder_db");
                    MainActivity.this.deleteDatabase("food_reminder_db");
                    MainActivity.this.deleteDatabase("food_type_reminder_db");
                    MainActivity.this.deleteDatabase("lab_test_reminder_db");
                    MainActivity.this.deleteDatabase("medicine_reminder_db");
                    MainActivity.this.deleteDatabase("walk_type_reminder_db");
                    MainActivity.this.deleteDatabase("water_type_reminder_db");
                    MainActivity.this.deleteDatabase("weight_reminder_db");
                    MainActivity.this.deleteDatabase("workout_type_reminder_db");
                    Intent in = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(in);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_LOGOUT_USER);
        req.execute();
    }



    private void bottomBenefitsFragmnet(Fragment fragment, String vendorTypeValue, String Tag) {
        Bundle bundle = new Bundle();
        bundle.putString("item", vendorTypeValue);
        bundle.putString("frag_tag",Tag);
        fragment.setArguments(bundle);
        pref.setFragment_Tag(Tag);
        changeTitle(Tag);
        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, fragment, R.id.main_frame, Tag);
    }

    void init() {
        callApi();
        FragmentsTransactionsUtils.addFragment(this, new FragmentDashBoard(), R.id.main_frame, FragmentsTags.DASH_BOARD_FRAGMENT);
        tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
//        promotionalpopup();
        checkForFirstTime();
    }

    private void checkForFirstTime(){
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        if (!sharedPreferences.getBoolean(
               "DemoPages", false)) {
                showDemoPages();
            }
     }

    private void showDemoPages(){
        builder = new GuideView.Builder(this)
                .setGravity(Gravity.center)
                .setTitle("Menu Button")
                .setContentText("Shortcut for various services")
                .setDismissType(DismissType.anywhere)
                .setTargetView(home_bottom)
                .setGuideListener(view -> {
                    switch (view.getId()) {
                        case R.id.home_bottom:
                            builder.setTitle("Regular Updates")
                            .setContentText("Maintenance tips, News and updates");
                            builder.setTargetView(tips_view).build();
                            break;
                        case R.id.tips_menu:
                            builder.setTitle("Insurance Wallet")
                                    .setContentText("Your insurance policies, policy documents");
                            LinearLayout c = findViewById(R.id.rl_policy_btn);
                            builder.setTargetView(c);
                            break;
                        case R.id.rl_policy_btn:
                            builder.setTitle("Claims")
                                    .setContentText("Initiate and track claim status");
                            LinearLayout c1 = findViewById(R.id.rl_claim_btn);
                            builder.setTargetView(c1);
                            break;
                        case R.id.rl_claim_btn:
//                            builder.setTitle("RoadSide Assistance")
//                                    .setContentText("Your RSA policy here");
                            LinearLayout c3 = findViewById(R.id.rl_rsa_btn);
//                            builder.setTargetView(c3);
                            return;
//                        case R.id.rl_rsa_btn:
//                            return;
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
                "DemoPages", true);
        sharedPreferencesEditor.apply();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO,pref.getToken_no());
            object.put("Uid",pref.getUID());
            ProjectVolleyRequest req = new ProjectVolleyRequest(MainActivity.this, object, UrlConstants.GET_CALL_US_NO, this, RequestConstants.GET_CALL_US_NO);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_CALL_US_NO) {
            if (object.optString("Status").equals("true")) {
                String sustomerCareNo_str = object.optString("CustomerCareNo");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
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
                                finish();
                            }
                        } else {
                            Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } else {
                        Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {
                Toast.makeText(this, "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void detect(String Tag) {
        removeSelectorOnBottom();
        switch (Tag) {
            case FragmentsTags.POLICY_FRAGMENT:
                changeTitle(FragmentsTags.MY_POLICY);
                break;
            case FragmentsTags.Buy_POLICY_FRAGMENT:
                changeTitle(FragmentsTags.Buy_POLICY);
                break;
            case FragmentsTags.CLAIM_FRAGMENT:
                changeTitle(FragmentsTags.CLAIM);
                break;
            case FragmentsTags.DOCUMENTS_FRAGMENT:
                changeTitle(FragmentsTags.DOCUMENTS);
                break;
            case FragmentsTags.RENEWALS_FRAGMENT:
                changeTitle(FragmentsTags.RENEWAL);
                break;
            case FragmentsTags.FRAGMENT_RSA:
                changeTitle(FragmentsTags.RSA);
                break;
            case FragmentsTags.DASH_BOARD_FRAGMENT:
                mTitle.setText(Html.fromHtml("<b>Motor</b>"));
                break;
            case FragmentsTags.FRAGMENT_CLAIM_DETAIL:
                changeTitle(FragmentsTags.CLAIM_DETAIL);
                break;
            case FragmentsTags.NOTIFICATION_FRAGMENT:
                mTitle.setText(FragmentsTags.NOTIFICATION);
                break;
            case FragmentsTags.FRAGMENT_TIPS:
                changeTitle(FragmentsTags.TIPS);
                break;
            case FragmentsTags.FRAGMENT_MENU:
                changeTitle(FragmentsTags.MENU);
                break;
            case FragmentsTags.FRAGMENT_MAINTENANCE_SCHEDULE:
                changeTitle(FragmentsTags.MAINTENANCE_SCHEDULE);
                break;
            case FragmentsTags.FRAGMENT_TRACKING_STATUS:
                changeTitle(FragmentsTags.TRACKING_STATUS);
                break;
            case FragmentsTags.TAG_OWNED_CARS:
                changeTitle(FragmentsTags.TAG_OWNED_CARS_NAME);
                pref.setFragment_Tag(FragmentsTags.TAG_OWNED_CARS);
                break;
            case FragmentsTags.FRAGMENT_SERVICE_APPOINTMENT:
                changeTitle(FragmentsTags.SERVICE_APPOINTMENT);
                break;
            case FragmentsTags.TAG_WARRANTY:
                changeTitle(FragmentsTags.TAG_WARRANTY_NAME);
                pref.setFragment_Tag(FragmentsTags.TAG_WARRANTY);
                break;
            case FragmentsTags.PARTS_ACCESSORIES:
                changeTitle(FragmentsTags.PARTS_ACCESSORIES_NAME);
                pref.setFragment_Tag(FragmentsTags.PARTS_ACCESSORIES);
                break;
            case FragmentsTags.SERVICE_FRAGMENT:
                changeTitle(FragmentsTags.SERVICE);
                break;
            case FragmentsTags.FRAGMENT_EXPIRED_POLICY:
                changeTitle(FragmentsTags.EXPIRED_POLICY);
                break;
            case FragmentsTags.FRAGMENT_EXPENSE:
                changeTitle(FragmentsTags.FRAGMENT_EXPENSE);
                break;
            case FragmentsTags.BOOK_DRIVER:
                changeTitle(FragmentsTags.BOOK_DRIVER);
                break;
            case FragmentsTags.SPARE_PARTS_NAME:
                changeTitle(FragmentsTags.SPARE_PARTS_NAME);
                break;
            case FragmentsTags.SPARES_CAR:
                changeTitle(FragmentsTags.SPARES_CAR);
                break;
            case FragmentsTags.FRAGMENT_FUEL:
                changeTitle(FragmentsTags.FUEL_PRICE);
                break;
            case FragmentsTags.ABOUT_US:
                changeTitle(FragmentsTags.ABOUT_US);
                break;
            case FragmentsTags.TERMS_CONDITION:
                changeTitle(FragmentsTags.TERMS_CONDITION);
                break;
            case FragmentsTags.PRIVACY_POLICY:
                changeTitle(FragmentsTags.PRIVACY_POLICY);
                break;
            case FragmentsTags.FRAGMENT_MOTOR_HELP:
                changeTitle(FragmentsTags.MOTOR_HELP);
                break;
            case FragmentsTags.FRAGMENT_NEARBY:
                changeTitle(FragmentsTags.NEARBY);
                break;
            case FragmentsTags.FRAGMENT_MY_ISSUE:
                changeTitle(FragmentsTags.MY_ISSUE);
                break;
            case FragmentsTags.video_article_fragment:
                changeTitle(FragmentsTags.video_article_fragment);
                break;
            default:
                break;
        }
    }

    void changeTitle(String Title) {
        mTitle.setText(Title);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void getCurrentFragment() {
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
                detect(fragmentTag);
                invalidateOptionsMenu();
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
            case R.id.dashboard_home:
                popUpLayoutGone();
                removeCrossIcon2();
                tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));

                tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvcall.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                FragmentsTransactionsUtils.addFragmentAgain(this, new FragmentDashBoard(), R.id.main_frame, FragmentsTags.DASH_BOARD_FRAGMENT);
                changeTitle(FragmentsTags.META_CAR);
                invalidateOptionsMenu();
                break;
            case R.id.dashboard_location:
                popUpLayoutGone();
                removeCrossIcon2();
//                getCurrentLocation();
                tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));

                tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvcall.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                removeAllFragemntPutOnlyDashboardFragment();
                Fragment frag_nearby = new FragmentMotorNearby();
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(MainActivity.this, frag_nearby, R.id.main_frame, FragmentsTags.FRAGMENT_NEARBY);
                changeTitle(FragmentsTags.NEARBY);
                break;
            case R.id.dashboard_menu:
                callMenuBtn();
                break;
            case R.id.dashboard_benifit:
                removeCrossIcon2();

                tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));

                tvcall.setTextColor(ContextCompat.getColor(this, R.color.lightblack));
                callPopupBenifit();
                break;

            case R.id.dashboard_ambulance:
                removeCrossIcon2();
                popUpLayoutGone();

                tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

                tvcall.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                ambulanceDialog();
                break;
            case R.id.drawer_head:
                removeCrossIcon2();
                popUpLayoutGone();
                removeSelectorOnBottom();
                removeAllFragemntPutOnlyDashboardFragment();
                changeTitle(FragmentsTags.PROFILE);
                FragmentsTransactionsUtils.notInStack(this, new FragmentProfile(), R.id.main_frame, FragmentsTags.FRAGMENT_PROFILE);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.dashboard_menu_cut:
                removeSelectorOnBottom();
                removeCrossIcon();
                break;
        }
    }

    void removeCrossIcon2() {
        dashboard_menu.setVisibility(View.VISIBLE);
        dashboard_menu_cut.setVisibility(View.GONE);
    }

    void removeSelectorOnBottom() {

        tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));

        tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
        iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

        tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
        icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));

        tvcall.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
    }

    void removeCrossIcon() {
        popUpLayoutGone();
        removeSelectorOnBottom();
        removeCrossIcon2();
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
            iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
            tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
            iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
            tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
            icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
            tvcall.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
        }
    }

    void popUpLayoutGone() {
        menu.setVisibility(View.GONE);
        locator.setVisibility(View.GONE);
        bebefits.setVisibility(View.GONE);
        tips_dialog.setVisibility(View.GONE);
    }

    @Override
    public void fragemntTransfer(Fragment f, String tag, String img_url) {
        if (tag.equalsIgnoreCase(FragmentsTags.DOCUMENTS_FRAGMENT))
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(this, new FragmentDocuments(), R.id.main_frame, FragmentsTags.DOCUMENTS_FRAGMENT);
        if (tag.equalsIgnoreCase(FragmentsTags.DASH_BOARD_FRAGMENT))
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(this, f, R.id.main_frame, FragmentsTags.DASH_BOARD_FRAGMENT);
    }

    void callPopupBenifit() {
        menu.setVisibility(View.GONE);
        locator.setVisibility(View.GONE);
        bebefits.setVisibility(View.VISIBLE);
        tips_dialog.setVisibility(View.GONE);
    }

    void callPopupTips() {
        menu.setVisibility(View.GONE);
        locator.setVisibility(View.GONE);
        bebefits.setVisibility(View.GONE);
        tips_dialog.setVisibility(View.VISIBLE);
        FLAG_TIPS = 1;
        performActionForTipsLayout();
    }

    void callMenuBtn() {
        removeSelectorOnBottom();
        dashboard_menu.setVisibility(View.GONE);
        dashboard_menu_cut.setVisibility(View.VISIBLE);
        menu.setVisibility(View.VISIBLE);
        locator.setVisibility(View.GONE);
        bebefits.setVisibility(View.GONE);
        tips_dialog.setVisibility(View.GONE);
    }

    void callUsDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.callus_dialog_motor_1);
        TextView sos_number = dialog.findViewById(R.id.sos_number);
        TextView sos_number1 = dialog.findViewById(R.id.sos_number1);
        TextView sos_number2 = dialog.findViewById(R.id.sos_number2);
        LinearLayout emergency_contact_number = dialog.findViewById(R.id.emergency_contact_number);
        LinearLayout emergency_contact_number_1 = dialog.findViewById(R.id.emergency_contact_number1);
        LinearLayout emergency_contact_number_2 = dialog.findViewById(R.id.emergency_contact_number2);
        TextView cancel = dialog.findViewById(R.id.cancel);
        final String no1 = sos_number.getText().toString();
        final String no2 = sos_number1.getText().toString();
        final String no3 = sos_number2.getText().toString();

        cancel.setOnClickListener(v -> {
            removeSelectorOnBottom();
            dialog.dismiss();
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                dialog.dismiss();
            }
        });

        emergency_contact_number.setOnClickListener(v -> {
            removeSelectorOnBottom();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + no1));
            startActivity(intent);
            dialog.dismiss();
        });

        emergency_contact_number_1.setOnClickListener(v -> {
            removeSelectorOnBottom();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + no2));
            startActivity(intent);
            dialog.dismiss();
        });

        emergency_contact_number_2.setOnClickListener(v -> {
            removeSelectorOnBottom();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + no3));
            startActivity(intent);
            dialog.dismiss();
        });

        dialog.show();
    }

    void ambulanceDialog() {
        final Dialog dialog = new Dialog(this, R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.ambulance_popup);
        TextView call = dialog.findViewById(R.id.tvcallambulance);
        TextView cancel = dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(v -> {
            removeSelectorOnBottom();
            dialog.dismiss();
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                tvcall.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
            }
        });

        call.setOnClickListener(v -> {
            removeSelectorOnBottom();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "112"));
            startActivity(intent);
            dialog.dismiss();
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                tvhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                iconhome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                tvlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                iconlocator.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                tvgift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                icongift.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
                tvcall.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.lightblack));
            }
        });

        dialog.show();
    }

    void removeAllFragemntPutOnlyDashboardFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(1).getId(), getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
        }
    }
    void performActionForLocatorLayout() {
        LinearLayout bottom11 = findViewById(R.id.bottom11);
        LinearLayout bottom21 = findViewById(R.id.bottom21);
        LinearLayout bottom31 = findViewById(R.id.bottom31);
        LinearLayout bottom41 = findViewById(R.id.bottom41);
        LinearLayout bottom51 = findViewById(R.id.bottom51);
        bottom11.setOnClickListener(v -> LocatorIconActionPerform("Garage", "Cashless Garage"));
        bottom21.setOnClickListener(v -> LocatorIconActionPerform("parking", "Parking"));
        bottom31.setOnClickListener(v -> LocatorIconActionPerform("car_repair", "Mechanic"));
        bottom41.setOnClickListener(v -> LocatorIconActionPerform("gas_station", "Pollution Center"));
        bottom51.setOnClickListener(v -> LocatorIconActionPerform("gas_station", "Petrol Pump"));
    }

    void performActionForBenefitsLayout() {
        LinearLayout bottom12 = findViewById(R.id.bottom12);
        LinearLayout bottom22 = findViewById(R.id.bottom22);
        LinearLayout bottom32 = findViewById(R.id.bottom32);
        LinearLayout bottom42 = findViewById(R.id.bottom42);
        LinearLayout bottom52 = findViewById(R.id.bottom52);

        bottom12.setOnClickListener(v -> {
            popUpLayoutGone();
            if (pref.getisUSGIUser().equals("1")) {
                rsaDialog();
            } else {
                AlertDialogAddPolicy2 addPolicy = new AlertDialogAddPolicy2();
                addPolicy.showAlertDialogForPolicy(MainActivity.this,"There is no policy added");
            }
        });

        bottom22.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            bottomBenefitsFragmnet(new FragmentServiceItem(), "Preowned", FragmentsTags.TAG_OWNED_CARS);
        });

        bottom32.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            bottomBenefitsFragmnet(new FragmentServiceItem(), "Acceriess", FragmentsTags.PARTS_ACCESSORIES_NAME);
        });

        bottom42.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            bottomBenefitsFragmnet(new FragmentServiceItem(), "ExtendedWarraty", FragmentsTags.TAG_WARRANTY_NAME);
        });

        bottom52.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            pref.setFragment_Tag(FragmentsTags.SERVICE_APPOINTMENT);
            replaceFragmentOnDialogLayouts(new FragmnetServiceAppointment(), FragmentsTags.FRAGMENT_SERVICE_APPOINTMENT);
            changeTitle(FragmentsTags.SERVICE_APPOINTMENT);
        });
    }

    void performActionForTipsLayout() {
        LinearLayout bottom13 = findViewById(R.id.bottom13);
        LinearLayout bottom23 = findViewById(R.id.bottom23);
        LinearLayout bottom33 = findViewById(R.id.bottom33);
        LinearLayout bottom43 = findViewById(R.id.bottom43);

        if (pref.getisUSGIUser().equals("1")) {
            bottom23.setVisibility(View.VISIBLE);
        } else {
            bottom23.setVisibility(View.GONE);
        }

        bottom13.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            changeTitle(FragmentsTags.TIPS);
            replaceFragmentOnDialogLayouts(new FragmentTips(), FragmentsTags.FRAGMENT_TIPS);
        });

        bottom23.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            changeTitle(FragmentsTags.MAINTENANCE_SCHEDULE);
            replaceFragmentOnDialogLayouts(new FragmentMaintenanceSchedule(), FragmentsTags.FRAGMENT_MAINTENANCE_SCHEDULE);
        });

        bottom33.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            changeTitle(FragmentsTags.RSS_FEEDS);
            replaceFragmentOnDialogLayouts(new FragmentRSS(), FragmentsTags.RSS_FEEDS);
        });

        bottom43.setOnClickListener(v -> {
            popUpLayoutGone();
            removeSelectorOnBottom();
            changeTitle(FragmentsTags.CONTENT);
            replaceFragmentOnDialogLayouts(new FragmentContent(), FragmentsTags.FRAGMENT_CONTENT);
        });
    }

    void performActionForMenuBtnLayout() {
        LinearLayout a1 = findViewById(R.id.a1);
        LinearLayout a2 = findViewById(R.id.a2);
        LinearLayout a3 = findViewById(R.id.a3);
        LinearLayout a4 = findViewById(R.id.a4);
        LinearLayout bottom1 = findViewById(R.id.bottom1);
        a1.setOnClickListener(v -> {
            Fragment fragment = new FragmentPolicy();
            Bundle args = new Bundle();
            args.putInt("otherFrag", 1);
            fragment.setArguments(args);
            replaceFragmentOnDialogLayouts(fragment, FragmentsTags.POLICY_FRAGMENT);
        });

        a2.setOnClickListener(v -> { replaceFragmentOnDialogLayouts(new BuyPolicyMotor(), FragmentsTags.Buy_POLICY_FRAGMENT);
        });

//         a2.setOnClickListener(v -> replaceFragmentOnDialogLayouts(new FragmentClaim(), FragmentsTags.CLAIM_FRAGMENT));

        a3.setOnClickListener(v -> replaceFragmentOnDialogLayouts(new FragmentDocuments(), FragmentsTags.DOCUMENTS_FRAGMENT));

        a4.setOnClickListener(v -> replaceFragmentOnDialogLayouts(new FragmentRenewals(), FragmentsTags.RENEWALS_FRAGMENT));

        bottom1.setOnClickListener(v -> replaceFragmentOnDialogLayouts(new ServiceFragment(), FragmentsTags.SERVICE_FRAGMENT));
    }

    void replaceFragmentOnDialogLayouts(Fragment fragment, String Tag) {
        popUpLayoutGone();
        removeSelectorOnBottom();
        removeCrossIcon2();
        removeAllFragemntPutOnlyDashboardFragment();
        detect(Tag);
        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(this, fragment, R.id.main_frame, Tag);
    }


    void LocatorIconActionPerform(String Tag, String Title) {
        if (NetworkUtils.isConnected(MainActivity.this)) {
            if (Tag.equals("Garage")) {
                Intent in = new Intent(this, GarageListActivity.class);
                startActivity(in);
            } else {
                System.gc();
                Intent in = new Intent(this, GoogleMapPlacesActivity.class);
                in.putExtra("key", Tag);
                in.putExtra("title", Title);
                startActivity(in);
            }

        } else {
            Toast.makeText(MainActivity.this, "You are not connected to internet", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkUser();
        checkLog();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver, new IntentFilter(Config.PUSH_NOTIFICATION));
    }

    @Override
    public void updateNavigationNow() {
        setUserInFoInDrawer();
    }


    @Override
    public void changeIcon(String readFlag) {
        tipReadStatus = readFlag;
        invalidateOptionsMenu();
    }

    @Override
    public void changeFragmnet() {
        removeAllFragemntPutOnlyDashboardFragment();
        mTitle.setText(Html.fromHtml("<b>Motor</b>"));
    }

    void startFCM() {
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    String message = intent.getStringExtra("message");
                     LogUtils.showLog("Push notification: ", message);
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
    }

    void closeLayoutOndrwerClick() {
        if (menu.getVisibility() == View.VISIBLE || locator.getVisibility() == View.VISIBLE || bebefits.getVisibility() == View.VISIBLE || tips_dialog.getVisibility() == View.VISIBLE) {
            popUpLayoutGone();
            removeSelectorOnBottom();
            removeCrossIcon2();
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
    public void getImageBitmapError(VolleyError error, int Tag) {

    }

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
        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(MainActivity.this, fragment, R.id.main_frame, fragmentTag);
        changeTitle(fragmentTag);
    }

    void sendTokenToServer() {
        MySharedPreference pref = MySharedPreference.getInstance(this);
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",pref.getToken_no());
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
                }, error -> {
                    if (error instanceof NetworkError) {
                        Toast.makeText(MainActivity.this, "No connection, please check your network", Toast.LENGTH_LONG).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(MainActivity.this, "No connection, please check your network", Toast.LENGTH_LONG).show();

                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(MainActivity.this, "No connection, please check your network", Toast.LENGTH_LONG).show();

                    } else if (error instanceof ParseError) {
                        Toast.makeText(MainActivity.this, "No connection, please check your network", Toast.LENGTH_LONG).show();

                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(MainActivity.this, "No connection, please check your network", Toast.LENGTH_LONG).show();

                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(MainActivity.this, "No connection, please check your network", Toast.LENGTH_LONG).show();

                    }
                }
        );
        MyApplication.getInstance().addToRequestQueue(jsonObjReq, "" + "12");
    }


    public void getPreviousFragmnet() {
         LogUtils.showLog("Back stack Count @@ :", "" + getSupportFragmentManager().getBackStackEntryCount());

        String tag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 2).getName();
            detect(tag);

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
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(MainActivity.this, object, UrlConstants.URL_CHECK_DEVICE_STATUS, new ResponseListener() {
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
        }, RequestConstants.URL_APP_DATA_LOG);
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
        } else {
            messageText.setText("You have recently logged in another device.\n To continue please login again");
        }

        Ok.setOnClickListener(v -> {
            dialog.dismiss();
            switch (messageType) {
                case "1":
                case "2": {
                    dialog.dismiss();
                    MySharedPreference.getInstance(MainActivity.this).clearAll();
                    Intent in = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(in);
                    finish();
                    break;
                }
                case "4": {
                    MySharedPreference.getInstance(MainActivity.this).clearAll();
                    Intent in = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(in);
                    finish();
                    break;
                }
            }
        });
        dialog.show();
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
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(MainActivity.this, object, UrlConstants.LAST_ACTIVITY_LOG, new ResponseListener() {

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

    void rsaDialog() {
        final Dialog dialog = new Dialog(this, R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.rsa_popup);
        TextView callrsa = dialog.findViewById(R.id.tvcallrsa);
        TextView cancel_rsa = dialog.findViewById(R.id.cancel_rsa);

        cancel_rsa.setOnClickListener(v -> dialog.dismiss());

        callrsa.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "1800 209 6678"));
            startActivity(intent);
            dialog.dismiss();
        });
        dialog.show();
    }

    @SuppressLint("SetTextI18n")
    public void showOnErrorDialog1() {
       /* final Dialog alert_dialog = new Dialog(this);
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

*/
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
        locationManager = (LocationManager) Objects.requireNonNull(MainActivity.this).getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true));

        //You can still do this if you like, you might get lucky:
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
            if (MainActivity.this != null) {
                MainActivity.this.runOnUiThread(() -> {
                    Geocoder geocoder;
                    List<Address> addresses = null;
                    geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
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
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(bestProvider, 1000, 0, this);
        }
    }

    private Location getLastKnownLocation() {
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

}


