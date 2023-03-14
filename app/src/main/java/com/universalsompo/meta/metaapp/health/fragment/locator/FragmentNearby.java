package com.universalsompo.meta.metaapp.health.fragment.locator;

import android.Manifest;
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
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.HospitalListActivity;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.motor.activities.GarageListActivity;
import com.universalsompo.meta.metaapp.motor.activities.GoogleMapPlacesActivity;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class FragmentNearby extends Fragment implements View.OnClickListener,LocationListener {
    private View v;
    public LocationManager locationManager;
    public Criteria criteria;
    public String bestProvider;
    public double latitude;
    public double longitude;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_nearby, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        init();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        statusCheck();
        LinearLayout ambulance = v.findViewById(R.id.ambulance);
        LinearLayout blood_banks = v.findViewById(R.id.blood_banks);
        LinearLayout hospital = v.findViewById(R.id.hospital);
        LinearLayout pharmacies = v.findViewById(R.id.pharmacies);
        LinearLayout diagnostic_labs = v.findViewById(R.id.diagnostic_labs);
        LinearLayout wellness_centers = v.findViewById(R.id.wellness_centers);

        ambulance.setOnClickListener(this);
        blood_banks.setOnClickListener(this);
        hospital.setOnClickListener(this);
        pharmacies.setOnClickListener(this);
        diagnostic_labs.setOnClickListener(this);
        wellness_centers.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.ambulance:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby list","User clicked to check nearby ambulance service");
                LocatorIconActionPerform("ambulance", "Ambulance");
                break;

            case R.id.blood_banks:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby list","User clicked to check nearby blood bank service");
                LocatorIconActionPerform("blood_bank", "Blood Bank");
                break;

            case R.id.hospital:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby list","User clicked to check nearby hospital list");
                LocatorIconActionPerform("hospital", "Hospitals");
                break;

            case R.id.pharmacies:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby list","User clicked to check nearby pharmacies list");
                LocatorIconActionPerform("pharmacy", "Pharmacies");
                break;

            case R.id.diagnostic_labs:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby list","User clicked to check nearby diagnostic labs service");
                LocatorIconActionPerform("diagnostic_lab", "Diagnostic Labs");
                break;

            case R.id.wellness_centers:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby list","User clicked to check nearby wellness centers");
                LocatorIconActionPerform("gym", "Wellness Centers");
                break;
        }
    }

    private void LocatorIconActionPerform(String Tag, String Title) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equals("hospital")) {
                Intent in = new Intent(getActivity(), HospitalListActivity.class);
                in.putExtra("key", Tag);
                in.putExtra("title", Title);
                startActivity(in);
            } else {
            System.gc();
            Intent in = new Intent(getActivity(), GoogleMapPlacesActivity.class);
            in.putExtra("key", Tag);
            in.putExtra("title", Title);
            startActivity(in);
         }
        }else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_LONG).show();
        }
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
                       String city = addresses.get(0).getLocality();
                        String state = addresses.get(0).getAdminArea();
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
            locationManager.requestLocationUpdates(bestProvider, 1000, 0, this);
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


    public void statusCheck() {
        final LocationManager manager = (LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);
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
