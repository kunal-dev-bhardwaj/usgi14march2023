package com.universalsompo.meta.metaapp.motor.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.WindowManager;
//import com.crashlytics.android.Crashlytics;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.motor.constants.HnadlerDelayTime;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppAlertDialog;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

//import io.fabric.sdk.android.Fabric;

public class SplashActivity extends Activity {
    private static final int SPLASH_DISPLAY_TIME = 3000;
    public LocationManager locationManager;
    public double latitude;
    public double longitude;
    @SuppressLint("HardwareIds")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
//        statusCheck();

        getWindow().setBackgroundDrawableResource(R.drawable.splash_back_1);
        if (android.os.Build.VERSION.SDK_INT >= 23)
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        if (android.os.Build.VERSION.SDK_INT >= 23)
        if (!NetworkUtils.isConnected(this)) {
            AppAlertDialog.showDialogFinishWithActivity(this, getResources().getString(R.string.app_name), "You are not connected to internet");
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    isLogin();
                }
            }, SPLASH_DISPLAY_TIME);
        }
    }

    private void isLogin() {
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(MySharedPreference.getInstance(SplashActivity.this).getIsLoggedIn())
                    {
                        String p_t = MySharedPreference.getInstance(SplashActivity.this).getPolicyType();
                        if (p_t.equalsIgnoreCase("HEALTH")) {
                            Intent a=new Intent(SplashActivity.this, MainActivityHealth.class);
                            startActivity(a);
                            finish();
                        } else {
                            Intent a=new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(a);
                            finish();
                        }
                    }
                    else
                    {
                        Intent a=new Intent(SplashActivity.this,LoginActivity.class);
                        startActivity(a);
                        finish();
                    }
                }
            }, HnadlerDelayTime.SPLASH_TIME);
        }
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
}
