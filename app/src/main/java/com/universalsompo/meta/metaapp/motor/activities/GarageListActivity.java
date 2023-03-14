package com.universalsompo.meta.metaapp.motor.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.adapters.AdapterFilter;
import com.universalsompo.meta.metaapp.motor.constants.Constants;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.dialogs.ConfirmDialog;
import com.universalsompo.meta.metaapp.intefaces.LinkNewPolicyDailogCallback;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.models.ClaimMapDataModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.DataParser;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.ui.IconGenerator;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class GarageListActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResponseListener, GoogleMap.OnMarkerClickListener,LinkNewPolicyDailogCallback {

    private GoogleMap mMap;
    private TextView map_title;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private CustomProgressDialog customDialog;
    private LinearLayout cross_icon;
    private LinearLayout marker_info_layout;
    private LinearLayout connect;
    private ImageView close;
    private TextView location_text;
    private ImageView direction_img;
    private TextView contact_text;
    private TextView name_of_workshop;
    private final int STATE_TAG = 2001;
    private final int CITY_TAG = 2002;
    private final int VEHICLE_TAG = 2003;
    private final int COMAPNY_LIST_TAG = 2004;
    private final int GARAGE_LIST_TAG = 2005;
    private ArrayList<ClaimFilterModel> cityList;
    private ArrayList<ClaimFilterModel> stateList;
    private ArrayList<ClaimFilterModel> companyList;
    private ArrayList<ClaimFilterModel> vehivleList;
    private ArrayList<ClaimMapDataModel> garageList = new ArrayList<ClaimMapDataModel>();
    private ArrayList<Marker> markerData = new ArrayList<>();
    private TextView state_list;
    private TextView city_list;
    private ClaimFilterModel selectedStateId;
    private ClaimFilterModel selectedCityId;
    private ClaimFilterModel selectedVehicleId;
    private ClaimFilterModel selectedCompanyId;
    private TextView company_list;
    private TextView vehicle_list;
    private Marker myMarker;
    private Polyline polyline;
    private LatLng latLng;
    private boolean defaul = false;
    private Marker Selectedmarker = null;
    private String initialCity;
    private ProgressDialog pd;
    private TextView back_button;
    private  String veh_type;
    private final Activity activity=this;
    private final LinkNewPolicyDailogCallback linkNewPolicyDailogCallback=this;
    private String insId="";
    private LinearLayout company_vehicle_liner;
    private String title,action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garage_list_layout);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/

        if (android.os.Build.VERSION.SDK_INT >= 21)
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        map_title = findViewById(R.id.map_title);
        cross_icon = findViewById(R.id.cross_icon2);
        state_list = findViewById(R.id.state_list);
        city_list = findViewById(R.id.city_list);
        company_list = findViewById(R.id.company_list);
        vehicle_list = findViewById(R.id.vehicle_list);
        marker_info_layout = findViewById(R.id.marker_info_layout);
        connect = findViewById(R.id.connect);
        close = findViewById(R.id.close);
        location_text = findViewById(R.id.location_text);
        direction_img = findViewById(R.id.direction_img);
        contact_text = findViewById(R.id.contact_text);
        name_of_workshop = findViewById(R.id.name_of_workshop);
        back_button = findViewById(R.id.back_button);
        company_vehicle_liner = findViewById(R.id.company_vehicle_liner);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);
        close.setOnClickListener(v -> marker_info_layout.setVisibility(View.GONE));
        cross_icon.setOnClickListener(v -> onBackPressed());

        city_list.setOnClickListener(v -> {
            if (cityList != null && cityList.size() > 0) {
                popUpForCityList();
            } else {
                Toast.makeText(GarageListActivity.this, "Please Select State First", Toast.LENGTH_SHORT).show();
            }
        });
        state_list.setOnClickListener(v -> {
            if (stateList != null && stateList.size() > 0) {
                popUpForStateList();
            } else {
                Toast.makeText(GarageListActivity.this, "Please Restart app", Toast.LENGTH_SHORT).show();
            }
        });

        company_list.setOnClickListener(v -> {
            if (companyList != null && companyList.size() > 0) {
                popUpForCompanyList();
            } else {
                Toast.makeText(GarageListActivity.this, "No company found ", Toast.LENGTH_SHORT).show();
            }
        });
        vehicle_list.setOnClickListener(v -> {
            if (vehivleList != null && vehivleList.size() > 0) {
                popUpForvehicleList();
            } else {
                Toast.makeText(GarageListActivity.this, "No vehicle found", Toast.LENGTH_SHORT).show();
            }
        });


        map_title.setText("Authorized Workshop");
        customDialog = CustomProgressDialog.getInstance(GarageListActivity.this);
        if (MyApplication.getInstance().isGooglePlayServicesAvailable(this)) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
            mapFragment.getMapAsync(this);
        }
        new ConfirmDialog("Authorized Workshop for","Car","Bike",activity,linkNewPolicyDailogCallback).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
    }

    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            mLastLocation = location;
            latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        }
    };

    void init() {
        buildGoogleApiClient();
    }

    protected synchronized void buildGoogleApiClient() {
        customDialog.showProgressBar();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest().create();
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, listener);
        checkResolutionAndProceed();
    }

    @Override
    public void onConnectionSuspended(int i) {
        customDialog.hideProgressBar();
        finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        customDialog.hideProgressBar();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2000) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    startProgressNow();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(GarageListActivity.this, "Enabling GPS is mandatory", Toast.LENGTH_LONG).show();
                    finish();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, listener);
            mGoogleApiClient.disconnect();
        }
    }

    private void checkResolutionAndProceed() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);
        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                customDialog.hideProgressBar();
                Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        startProgressNow();
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            status.startResolutionForResult(GarageListActivity.this, 2000);
                        } catch (IntentSender.SendIntentException e) {
                        }
                        break;
                }
            }
        });
    }

    void startProgressNow() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, listener);
        startServices();

    }

    void startNearByPoint() {
         LogUtils.showLog("@@@@@@@@@@@@@", "" + mLastLocation.getLatitude());
         LogUtils.showLog("@@@@@@@@@@@@@", "" + mLastLocation.getLongitude());
        latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Geocoder geocoder;
                List<Address> addresses = null;
                geocoder = new Geocoder(GarageListActivity.this, Locale.getDefault());
                try {
                    addresses = geocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (addresses != null) {
                    city_list.setText(addresses.get(0).getLocality());
                    state_list.setText(addresses.get(0).getAdminArea());
                    selectedCityId = new ClaimFilterModel("", addresses.get(0).getLocality());
                    selectedStateId = new ClaimFilterModel("", addresses.get(0).getAdminArea());
                    defaul = false;
                    initialCity = addresses.get(0).getLocality();
                    getCity(addresses.get(0).getAdminArea());
                    if(veh_type.equals(Constants.FOUR_WHEELER)) {
                        getCompanyList();
                        new Handler().postDelayed(() -> {
                            if(companyList.size()>0)
                                insId = companyList.get(0).getId();
                            initLocations();

                        }, 3000);
                    }else
                        initLocations();

                }
            }
        });
    }

    void startServices() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLastLocation != null) {
                    customDialog.hideProgressBar();
                    startNearByPoint();
                } else {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    init();
                }
            }
        });
    }

    @Override
    public void onSuccess(final JSONObject object, final int Tag) {
        runOnUiThread(() -> {
            if (Tag == CITY_TAG) {
                initCity(object);
            } else if (Tag == STATE_TAG) {
                getCompanyList();
                initState(object);
            } else if (Tag == VEHICLE_TAG) {
                initVehicle(object);
            } else if (Tag == COMAPNY_LIST_TAG) {
                getVehicle();
                initCompanyList(object);
            } else if (Tag == GARAGE_LIST_TAG) {
                initGarageList(object);
            }
        });
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    void getState() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getApplicationContext()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getApplicationContext()).getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest request = new ProjectVolleyRequest(GarageListActivity.this, object, UrlConstants.GET_STATE, this, STATE_TAG);
        request.execute();
    }

    void getCity(String stateId) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getApplicationContext()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getApplicationContext()).getUID());
            object.put("StateName", stateId);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest request = new ProjectVolleyRequest(GarageListActivity.this, object, UrlConstants.GET_CITY_BASED_ON_NAME, this, CITY_TAG);
        request.execute();
    }

    void getCompanyList() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getApplicationContext()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getApplicationContext()).getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest request = new ProjectVolleyRequest(GarageListActivity.this, object, UrlConstants.GET_COMAPANY_LIST, this, COMAPNY_LIST_TAG);
        request.execute();
    }

    void getVehicle() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getApplicationContext()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getApplicationContext()).getUID());
            object.put("VehicleType", veh_type);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest request = new ProjectVolleyRequest(GarageListActivity.this, object, UrlConstants.GET_VEHICLE, this, VEHICLE_TAG);
        request.execute();
    }

    void initState(JSONObject object) {

        stateList = new ArrayList<>();
        if (cityList != null) {
            cityList.clear();
        }
        if (object.optString("Message").equals("Success")) {
            JSONArray arr;
            try {
                arr = object.getJSONArray("StateDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    stateList.add(new ClaimFilterModel(obj.getString("StateId"), obj.getString("StateName")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "No State Found", Toast.LENGTH_SHORT).show();
        }
    }

    void initVehicle(JSONObject object) {
        vehivleList = new ArrayList<>();
        if (object.optString("Message").equals("Success")) {
            JSONArray arr;
            try {
                arr = object.getJSONArray("VehicleDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    vehivleList.add(new ClaimFilterModel(obj.getString("VehicleId"), obj.getString("VehicleName")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "No Vehicle Found", Toast.LENGTH_SHORT).show();
        }
    }

    void initCompanyList(JSONObject object) {
        companyList = new ArrayList<>();
        if (object.optString("Message").equals("Success")) {
            JSONArray arr;
            try {
                arr = object.getJSONArray("InsCompanyDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    companyList.add(new ClaimFilterModel(obj.getString("InsCompanyId"), obj.getString("InsCompanyName")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "No Company Found", Toast.LENGTH_SHORT).show();
        }
    }

    void initCity(JSONObject object) {
        if (cityList != null) {
            cityList.clear();
        }
        if (defaul) {
            city_list.setText("-City-");
        }
        if (object.optString("Message").equals("Success")) {
            if (defaul) {
                city_list.setTextColor(Color.RED);
            } else {
                city_list.setTextColor(Color.GRAY);
            }
            cityList = new ArrayList<ClaimFilterModel>();
            JSONArray arr;
            try {
                arr = object.getJSONArray("CityDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    cityList.add(new ClaimFilterModel(obj.getString("CityId"), obj.getString("CityName")));
                }
                if (defaul == false) {
                    for (int i = 0; i < cityList.size(); i++) {
                        if (cityList.get(i).getName().equals(initialCity)) ;
                        {
                            selectedCityId = new ClaimFilterModel(cityList.get(i).getId(), initialCity);
                            break;
                        }
                    }
                } else {
                    selectedCityId = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            city_list.setTextColor(Color.GRAY);
            Toast.makeText(this, "No city associated with this state", Toast.LENGTH_SHORT).show();
        }
    }

    void popUpForStateList() {
        final AdapterFilter adapter = new AdapterFilter(GarageListActivity.this, stateList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(GarageListActivity.this);
        LayoutInflater inflater = GarageListActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.claim_map_filter_screen, null);
        final EditText tv = dialogView.findViewById(R.id.inputSearch);
        ListView lv = dialogView.findViewById(R.id.list_view_filter);
        lv.setAdapter(adapter);
        tv.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                adapter.getFilter().filter(cs.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
        tv.setHint("State");
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Cancel", null);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Selectedmarker = null;
                alertDialog.dismiss();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                tv.setText(adapter.getData(position).getName());
                selectedStateId = adapter.getData(position);
                if (selectedStateId != null) {
                    state_list.setText(adapter.getData(position).getName());
                    city_list.setTextColor(Color.RED);
                    defaul = true;
                    getCity(adapter.getData(position).getName());
                }
                Selectedmarker = null;
                alertDialog.dismiss();
            }
        });
    }

    void popUpForCityList() {
        final AdapterFilter adapter = new AdapterFilter(GarageListActivity.this, cityList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(GarageListActivity.this);
        LayoutInflater inflater = GarageListActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.claim_map_filter_screen, null);
        final EditText tv = dialogView.findViewById(R.id.inputSearch);
        ListView lv = dialogView.findViewById(R.id.list_view_filter);
        lv.setAdapter(adapter);
        tv.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                adapter.getFilter().filter(cs.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });

        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Cancel", null);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Selectedmarker = null;
                alertDialog.dismiss();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                tv.setText(adapter.getData(position).getName());
                selectedCityId = adapter.getData(position);
                if (selectedCityId != null) {
                    city_list.setText(adapter.getData(position).getName());
                    city_list.setTextColor(Color.GRAY);
                    initLocations();
                }
                Selectedmarker = null;
                alertDialog.dismiss();
            }
        });
    }

    void popUpForvehicleList() {

        final AdapterFilter adapter = new AdapterFilter(GarageListActivity.this, vehivleList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(GarageListActivity.this);
        LayoutInflater inflater = GarageListActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.claim_map_filter_screen, null);
        final EditText tv = dialogView.findViewById(R.id.inputSearch);
        ListView lv = dialogView.findViewById(R.id.list_view_filter);
        lv.setAdapter(adapter);
        tv.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                adapter.getFilter().filter(cs.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Cancel", null);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Selectedmarker = null;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                tv.setText(adapter.getData(position).getName());
                selectedVehicleId = adapter.getData(position);
                if (selectedVehicleId != null) {
                    vehicle_list.setText(selectedVehicleId.getName());
                    vehicle_list.setTextColor(Color.GRAY);
                    initLocations();
                }
                alertDialog.dismiss();
                Selectedmarker = null;
            }
        });

    }

    void popUpForCompanyList() {
        final AdapterFilter adapter = new AdapterFilter(GarageListActivity.this, companyList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(GarageListActivity.this);
        LayoutInflater inflater = GarageListActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.claim_map_filter_screen, null);
        final EditText tv = dialogView.findViewById(R.id.inputSearch);
        ListView lv = dialogView.findViewById(R.id.list_view_filter);
        lv.setAdapter(adapter);
        tv.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                adapter.getFilter().filter(cs.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Cancel", null);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Selectedmarker = null;
                alertDialog.dismiss();

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                tv.setText(adapter.getData(position).getName());
                selectedCompanyId = adapter.getData(position);
                if (selectedCompanyId != null) {
                    company_list.setText(adapter.getData(position).getName());
                    company_list.setTextColor(Color.GRAY);
                    initLocations();
                }
                Selectedmarker = null;
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
            if (polyline != null) {
                polyline.remove();
                polyline.getPoints().clear();
            }
            if (marker.equals(myMarker)) {
                marker_info_layout.setVisibility(View.GONE);
                mMap.getUiSettings().setMapToolbarEnabled(true);
                return false;
            } else if (markerData.contains(marker)) {
                int position = markerData.indexOf(marker);
                final ClaimMapDataModel data = garageList.get(position);
                 LogUtils.showLog("@@@@@@@@@@@", data.getAddress());
                marker_info_layout.setVisibility(View.VISIBLE);
                location_text.setText(data.getAddress());
                contact_text.setText(data.getLandlineNo());
                name_of_workshop.setText(data.getNameOfWorkshop());
                setMarker(marker);

                if(data.getContactNo().equals(""))
                    connect.setVisibility(View.GONE);
                else
                    connect.setVisibility(View.VISIBLE);

                connect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callUsDialog(data.getContactNo(), data.getNameOfWorkshop());
                    }
                });

                direction_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LatLng latLng=new LatLng(Double.parseDouble(data.getLatitude()),Double.parseDouble(data.getLongitude()));
                        drawRouteNow(latLng,new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()));
                    }
                });
                return false;
            }
            return false;
    }

    private String getUrl(LatLng origin, LatLng dest) {
        String sensor = "sensor=false";
        String url = "https://maps.googleapis.com/maps/api/directions/json?" + "origin=" + origin.latitude + "," + origin.longitude + "&" + "destination=" + dest.latitude + "," + dest.longitude + "&" + sensor;
        Log.e("righthere",url);
        return url;
    }

    void initLocations() {

        if (selectedCityId == null) {
            Toast.makeText(this, "Please Select the City", Toast.LENGTH_SHORT).show();
            return;
        }
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getApplicationContext()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getApplicationContext()).getUID());
            object.put("VehicleType", veh_type);

            if (selectedCompanyId != null)
                object.put("InsCompId", selectedCompanyId.getId());
            else
                object.put("InsCompId", insId);

            if (selectedVehicleId != null)
                object.put("VehicleMake", selectedVehicleId.getName());
            else
                object.put("VehicleMake", "");

            if (selectedStateId != null)
                object.put("State", selectedStateId.getName());
                else
                object.put("State", "");

            if (selectedCityId != null) {
                object.put("City", selectedCityId.getName());
            }else
                object.put("City", "");

             LogUtils.showLog("@@@@@@@@", object.toString());
        } catch (Exception e) {
                        e.printStackTrace();
                    }

        getCompanyList(object);

    }

    void getCompanyList(JSONObject object) {
        ProjectVolleyRequest request = new ProjectVolleyRequest(GarageListActivity.this, object, UrlConstants.GET_ALL_GARAGE, this, GARAGE_LIST_TAG);
        request.execute();
    }

    void initGarageList(JSONObject object) {
        garageList.clear();
        markerData.clear();
        mMap.clear();
        LatLng latlng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        myMarker = mMap.addMarker(new MarkerOptions().position(latlng).title("Current Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 12.0f));

        if (object.optString("Message").equals("Success")) {
            IconGenerator generator = new IconGenerator(GarageListActivity.this);
            generator.setBackground(null);
            String uri = "@drawable/new_pinpoint_icon";  // where myresource (without the extension) is the file
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            ImageView iv = new ImageView(GarageListActivity.this);
            Drawable res = getResources().getDrawable(imageResource);
            iv.setImageDrawable(res);
            generator.setContentView(iv);
            Bitmap icon = generator.makeIcon();
            JSONArray arr = null;
            try {
                arr = object.getJSONArray("ALGarageDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    garageList.add(new ClaimMapDataModel(
                            obj.optString("Address"),
                            obj.optString("City"),
                            obj.optString("ContactEmail"),
                            obj.optString("ContactNo"),
                            obj.optString("ContactPerson"),
                            obj.optString("Country"),
                            obj.optString("LandlineNo"),
                            obj.optString("Latitude"),
                            obj.optString("Longitude"),
                            obj.optString("NameOfWorkshop"),
                            obj.optString("PinCode"),
                            obj.optString("State"),
                            obj.optString("VehicleMake"),
                            obj.optString("distance")));
                    Marker mar = mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(obj.optString("Latitude")), Double.parseDouble(obj.optString("Longitude")))).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(icon)));
                    markerData.add(mar);

                }
                if (myMarker != null) {
                    markerData.add(myMarker);
                }

                int width = 0;
                int height = 0;
                int padding = 0;
                CameraUpdate cu = null;
                LatLngBounds.Builder builder = null;
                builder = new LatLngBounds.Builder();
                for (Marker marker : markerData) {
                    builder.include(marker.getPosition());
                }
                LatLngBounds bounds = builder.build();
                width = getResources().getDisplayMetrics().widthPixels;
                height = getResources().getDisplayMetrics().heightPixels;
                padding = (int) (width * 0.15);
                cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
                mMap.animateCamera(cu);

            } catch (Exception e) {
                        e.printStackTrace();
                    }
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    void callUsDialog(final String no, String Title) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final Dialog dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.callus_dialog_motor);
        TextView linroot = dialog.findViewById(R.id.tvcall);
        TextView tvmobnumber = dialog.findViewById(R.id.tvmobnumber);
        TextView tvcancel = dialog.findViewById(R.id.tvcancel);
        TextView tvheader = dialog.findViewById(R.id.dialog_heading);
        tvmobnumber.setText(no);

        tvheader.setText(Title);
        linroot.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + no));
            startActivity(intent);
            dialog.dismiss();
        });
        tvcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        marker_info_layout.setVisibility(View.GONE);
        dialog.show();
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
            br.close();
        } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    @Override
    public void positive() {
        veh_type= Constants.FOUR_WHEELER;
        init();
        getState();
    }

    @Override
    public void Negative() {
        veh_type= Constants.TWO_WHEELER;
        init();
        getState();
    }

    @SuppressLint("NewApi")
    private class FetchUrl extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                data = downloadUrl(url[0]);
                Log.e("Background Task data", data);
            } catch (Exception e) {
                Log.e("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ParserTask parserTask = new ParserTask();
            parserTask.execute(result);
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                DataParser parser = new DataParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = result.get(i);
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
                    points.add(position);
                }
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.parseColor("#0bbcb0"));
            }
            if (lineOptions != null) {
                polyline = mMap.addPolyline(lineOptions);
            } else {
            }
        }
    }

    void setMarker(Marker marker) {
        if (Selectedmarker != null) {
            Selectedmarker.setIcon(BitmapDescriptorFactory.fromBitmap(normalIcon()));
        }
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(ActiveIcon()));
        Selectedmarker = marker;
    }

    Bitmap ActiveIcon() {
        String Select_uri = "@drawable/new_pinpoint_icon";
        IconGenerator generator = new IconGenerator(this);
        generator.setBackground(null);
        int imageResource = getResources().getIdentifier(Select_uri, null, getPackageName());
        ImageView iv = new ImageView(this);
        Drawable res = getResources().getDrawable(imageResource);
        iv.setImageDrawable(res);
        generator.setContentView(iv);
        return generator.makeIcon();
    }

    Bitmap normalIcon() {
        String normal_uri = "@drawable/new_pinpoint_icon";
        IconGenerator generator = new IconGenerator(this);
        generator.setBackground(null);
        int imageResource = getResources().getIdentifier(normal_uri, null, getPackageName());
        ImageView iv = new ImageView(this);
        Drawable res = getResources().getDrawable(imageResource);
        iv.setImageDrawable(res);
        generator.setContentView(iv);
        return generator.makeIcon();
    }

    void drawRouteNow(LatLng from, LatLng to) {
        String uri = "http://maps.google.com/maps?saddr=" + to.latitude + "," + to.longitude + "&daddr=" + from.latitude + "," + from.longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        this.startActivity(intent);
        marker_info_layout.setVisibility(View.GONE);
    }
}
