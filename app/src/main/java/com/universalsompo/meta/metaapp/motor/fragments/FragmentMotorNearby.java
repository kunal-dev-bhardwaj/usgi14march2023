package com.universalsompo.meta.metaapp.motor.fragments;

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
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.motor.activities.GarageListActivity;
import com.universalsompo.meta.metaapp.motor.activities.GoogleMapPlacesActivity;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class FragmentMotorNearby extends Fragment implements View.OnClickListener,LocationListener {
    private View v;
    static public final int REQUEST_LOCATION = 1;
    public LocationManager locationManager;
    public Criteria criteria;
    public String bestProvider;
    public double latitude;
    public double longitude;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_motor_nearby, container, false);
        new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby page","User came on nearby page");
        init();
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        return v;
    }

    private void init() {
        statusCheck();
        LinearLayout petrol_pump = v.findViewById(R.id.petrol_pump);
        LinearLayout pollution_center = v.findViewById(R.id.pollution_center);
        LinearLayout mechanic = v.findViewById(R.id.mechanic);
        LinearLayout parking = v.findViewById(R.id.parking);
        LinearLayout network_garages = v.findViewById(R.id.network_garages);
        LinearLayout charging_station = v.findViewById(R.id.charging_station);
        petrol_pump.setOnClickListener(this);
        pollution_center.setOnClickListener(this);
        mechanic.setOnClickListener(this);
        parking.setOnClickListener(this);
        network_garages.setOnClickListener(this);
        charging_station.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.petrol_pump:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby page","User clicked on petrol pump");
                /*if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getActivity()), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
                } else {
                    LocatorIconActionPerform("gas_station", "Petrol Pump");
                }*/

                LocatorIconActionPerform("gas_station", "Petrol Pump");
                break;

            case R.id.pollution_center:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby page","User clicked on pollution center");
                LocatorIconActionPerform("gas_station", "Pollution Center");
                break;

            case R.id.mechanic:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby page","User clicked on mechanic");
                LocatorIconActionPerform("car_repair", "Mechanic");
                break;

            case R.id.parking:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby page","User clicked on parking");
                LocatorIconActionPerform("parking", "Parking");
                break;

            case R.id.network_garages:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby page","User clicked on network garages");
                LocatorIconActionPerform("Garage", "Cashless Garage");
                break;

            case R.id.charging_station:
                getCurrentLocation();
                new AppDataPushApi().callApi(getActivity(),"Nearby","Nearby page","User clicked on charging station");
                LocatorIconActionPerform("charging_station", "Charging Station");
                break;
        }
    }

    private void LocatorIconActionPerform(String Tag, String Title) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equals("Garage")) {
                Intent in = new Intent(getActivity(), GarageListActivity.class);
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

        } else {
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
