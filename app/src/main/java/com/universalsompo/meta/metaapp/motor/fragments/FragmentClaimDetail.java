package com.universalsompo.meta.metaapp.motor.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import java.util.Objects;

public class FragmentClaimDetail extends Fragment implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private String VehicleType, coveragedetails;
    private LinearLayout a1, b1, c1, d1, e1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_claim_detail, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).remove_elevation();
        MySharedPreference pref = MySharedPreference.getInstance(getActivity());
        assert getArguments() != null;
        pref.setContact(getArguments().getString("contact"));
        pref.setINSkey(getArguments().getString("key"));
        pref.addPID(getArguments().getString("policyIdFrDots"));
        VehicleType = getArguments().getString("vehicleType");
        coveragedetails = getArguments().getString("CoverageDetails");
        LogUtils.showLog("POID", pref.getPID());
        init(v);
        return v;
    }

    private void init(View v) {
        img1 = v.findViewById(R.id.img1);
        img2 = v.findViewById(R.id.img2);
        img3 = v.findViewById(R.id.img3);
        img4 = v.findViewById(R.id.img4);
        img5 = v.findViewById(R.id.img5);
        a1 = v.findViewById(R.id.a);
        b1 = v.findViewById(R.id.b);
        c1 = v.findViewById(R.id.c);
        d1 = v.findViewById(R.id.d);
        e1 = v.findViewById(R.id.e);
        new AppDataPushApi().callApi(getActivity(), "Claim", "Claim Detail", "Process Call Forms");
        startListener();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Bundle b = new Bundle();
        b.putString("v_type", VehicleType);
        b.putString("CoverageDetails", coveragedetails);
        switch (id) {
            case R.id.img1:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                ClaimPolicyFragmentDetail frag = new ClaimPolicyFragmentDetail();
                frag.setArguments(b);
                addFragment(frag);
                img5.setTag(null);
                break;
            case R.id.img2:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                FragmentClaimPolicyCall frag2 = new FragmentClaimPolicyCall();
                frag2.setArguments(b);
                addFragment(frag2);
                img5.setTag(null);
                break;
            case R.id.img3:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                if (NetworkUtils.isConnected(getActivity())) {
                    init();
                } else {
                    Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.img4:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                FragmentClaimPolicyCashless frag4 = new FragmentClaimPolicyCashless();
                frag4.setArguments(b);
                addFragment(frag4);
                img5.setTag(null);
                break;
            case R.id.img5:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
                if (img5.getTag() != null && img5.getTag().equals("abc")) {
                } else {
                    FragmentIntimation frag5 = new FragmentIntimation();
                    frag5.setArguments(b);
                    addFragment(frag5);
                    img5.setTag("abc");
                }
                break;
        }
    }

    private void startListener() {
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        Bundle b = new Bundle();
        b.putString("v_type", VehicleType);
        ClaimPolicyFragmentDetail frag = new ClaimPolicyFragmentDetail();
        frag.setArguments(b);
        addFragment(frag);
    }

    private void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.childContainer, frg);
        childFragTrans.addToBackStack(null);
        childFragTrans.commit();
    }

    private void init() {
        buildGoogleApiClient();
        mGoogleApiClient.connect();
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(Objects.requireNonNull(getActivity()))
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
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
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            gotoFragment();
        } else {
            checkResolutionAndProceed();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    private void checkResolutionAndProceed() {
        LocationRequest mLocationRequest = new LocationRequest().create();
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
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
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);
        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(result1 -> {
            Status status = result1.getStatus();
            switch (status.getStatusCode()) {
                case LocationSettingsStatusCodes.SUCCESS:
                    getLocation();
                    break;
                case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                    try {
                        startIntentSenderForResult(status.getResolution().getIntentSender(), 1000, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    getLocation();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(getActivity(), "Enabling GPS is mandatory", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
    }

    private void getLocation() {
        ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setCancelable(true);
        pd.setMessage("Loading");
        pd.setIndeterminate(false);
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pd.dismiss();
        if (mLastLocation != null) {
            gotoFragment();
        }
    }

    private void gotoFragment() {
        FragmentClaimPolicyMap frag3 = new FragmentClaimPolicyMap();
        Bundle b3 = new Bundle();
        assert getArguments() != null;
        b3.putString("key", getArguments().getString("key"));
        b3.putString("make", getArguments().getString("make"));
        b3.putString("veh_type",VehicleType);
        frag3.setArguments(b3);
        addFragment(frag3);
        img5.setTag(null);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    init();
                } else {
                    Toast.makeText(getActivity(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
