package com.universalsompo.meta.metaapp.motor.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AlertDialog;

import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.Task;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.adapters.AdapterFilter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.dialogs.ConfirmDialog;
import com.universalsompo.meta.metaapp.intefaces.LinkNewPolicyDailogCallback;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.DataParser;
import com.universalsompo.meta.metaapp.utilities.GooglePlacesReadTask;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.MyApplication;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
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

public class GoogleMapPlacesActivity extends FragmentActivity implements OnMapReadyCallback,
        ResponseListener, LinkNewPolicyDailogCallback {
    private GoogleMap mMap;
    private TextView map_title;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private String requestParams;
    private CustomProgressDialog customDialog;
    private LatLng destination;
    private final int STATE_TAG = 2001;
    private final int CITY_TAG = 2002;
    private ArrayList<ClaimFilterModel> cityList;
    private ArrayList<ClaimFilterModel> stateList;
    private TextView state_list;
    private TextView city_list;
    private ClaimFilterModel selectedStateId;
    private ClaimFilterModel selectedCityId;
    private RatingBar ratingbar;
    private TextView address;
    private TextView name;
    private LinearLayout place_info_layout;
    private LinearLayout draw_route;
    private boolean defaul = false;
    private LinearLayout connect;
    private TextView contact_text;
    private String title;
    private String vehicle_type;
    String key1;
    String action;
    LinearLayout uber_layout;
    private String pickupArea = "", dropoffArea = "";
    FusedLocationProviderClient mFusedLocationClient;

    static {
        System.loadLibrary("keys");
    }

    public native String getNativeKey1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_map_place_layout);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        if (android.os.Build.VERSION.SDK_INT >= 21)
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        key1 = getNativeKey1();
        map_title = findViewById(R.id.map_title);
        LinearLayout cross_icon = findViewById(R.id.cross_icon2);
        state_list = findViewById(R.id.state_list);
        city_list = findViewById(R.id.city_list);
        uber_layout = findViewById(R.id.uber_layout);
        customDialog = CustomProgressDialog.getInstance(GoogleMapPlacesActivity.this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            customDialog.showProgressBar();
            title = bundle.getString("title");
            action = bundle.getString("key");
            vehicle_type = bundle.getString("type");
            assert title != null;
            map_title.setText(getIntent().getStringExtra("title"));
            switch (title) {
                case "Mechanic":
                    customDialog.hideProgressBar();
                    selectApiWithDialog(title);
                    break;
                case "Mechanics":
                    customDialog.hideProgressBar();
                    if (vehicle_type.equalsIgnoreCase("car")) {
                        Negative();
                    } else {
                        positive();
                    }
                    break;
                case "Blood Bank":
                case "Hospitals":
                case "Pharmacies":
                case "Diagnostic Labs":
                case "Wellness Centers":
                case "Nearby Testing Labs":
                    uber_layout.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            customDialog.hideProgressBar();
                            checkOtherService();

                        }
                    }, 1000);
                    break;
                default:
                    uber_layout.setVisibility(View.GONE);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            customDialog.hideProgressBar();
                            checkOtherService();
                        }
                    }, 1000);
                    break;
            }
            new AppDataPushApi().callApi(this, "Nearby Services", title, "Checked for the " + action);
        }

        TextView back_button = findViewById(R.id.back_button);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);
        initLayoutInfoView();

        cross_icon.setOnClickListener(v -> onBackPressed());

        city_list.setOnClickListener(v -> {
            if (cityList != null && cityList.size() > 0) {
                place_info_layout.setVisibility(View.GONE);
                draw_route.setVisibility(View.GONE);
                popUpForCityList();
            } else {
                Toast.makeText(GoogleMapPlacesActivity.this, "Please Select State First", Toast.LENGTH_SHORT).show();
            }
        });

        state_list.setOnClickListener(v -> {
            if (stateList != null && stateList.size() > 0) {
                place_info_layout.setVisibility(View.GONE);
                draw_route.setVisibility(View.GONE);
                popUpForStateList();
            } else {
                Toast.makeText(GoogleMapPlacesActivity.this, "Please Restart app", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkOtherService() {
        requestParams = getIntent().getStringExtra("key");
        map_title.setText(getIntent().getStringExtra("title"));
        MySharedPreference pref = MySharedPreference.getInstance(this);
        pref.setNearby_Tag(requestParams);
        customDialog = CustomProgressDialog.getInstance(GoogleMapPlacesActivity.this);
//        checkLocationService();
        if (MyApplication.getInstance().isGooglePlayServicesAvailable(this)) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
            assert mapFragment != null;
            mapFragment.getMapAsync(this);
        }
        init();


    }


    private void selectApiWithDialog(String title) {
        new ConfirmDialog("Do you want to see " + title + " for ", "Bike", "Car", GoogleMapPlacesActivity.this, this).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setMapToolbarEnabled(false);

    }

    public void MarkerClick(HashMap<String, String> data) {
        String formattedAddress = data.get("formatted_address");
        String placeName = data.get("place_name");
        String vicinity = data.get("vicinity");
        String latitude = data.get("lat");
        String longitude = data.get("lng");
        String place_ref = data.get("place_reference");
        String Rating = data.get("rating");
        String OpenHours = data.get("open_hour");
        assert latitude != null;
        assert longitude != null;
        destination = new LatLng(Float.parseFloat(latitude), Float.parseFloat(longitude));
        assert formattedAddress != null;
        showDataInfo(placeName, formattedAddress, vicinity, Rating, OpenHours, place_ref);
    }

    void init() {
        customDialog.showProgressBar();
        checkLocationService();
    }

    void startProgressNow() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                mLastLocation = location;
                startServices();
            } else {
                init();
//                Toast.makeText(GoogleMapPlacesActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
        mFusedLocationClient.getLastLocation().addOnFailureListener(this, e -> Toast.makeText(GoogleMapPlacesActivity.this, "Something went wrong", Toast.LENGTH_LONG).show());
    }

    private void LastLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationCallback mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        mLastLocation = location;
                        startProgressNow();
                    }
                }
            }
        };

        LocationServices.getFusedLocationProviderClient(GoogleMapPlacesActivity.this).requestLocationUpdates(mLocationRequest, mLocationCallback, null);

    }
    private void checkLocationService(){
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(120000); // two minute interval
        mLocationRequest.setFastestInterval(120000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        LocationSettingsRequest.Builder settingsBuilder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        settingsBuilder.setAlwaysShow(true);
        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(this)
                .checkLocationSettings(settingsBuilder.build());
        result.addOnCompleteListener(task -> {
            try {
                customDialog.hideProgressBar();
                LocationSettingsResponse response = task.getResult(ApiException.class);
                startProgressNow();
            } catch (ApiException ex) {
                switch (ex.getStatusCode()) {
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            ResolvableApiException resolvableApiException =
                                    (ResolvableApiException) ex;
                            resolvableApiException
                                    .startResolutionForResult(GoogleMapPlacesActivity.this,
                                            2000);
                        } catch (IntentSender.SendIntentException e) {
                            e.printStackTrace();
                        }
                        break;
                    case LocationSettingsStatusCodes.SUCCESS:
                        startProgressNow();
//                        customDialog.hideProgressBar();
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        Toast.makeText(GoogleMapPlacesActivity.this, "Enabling GPS is mandatory", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2000) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    LastLocationUpdates();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(GoogleMapPlacesActivity.this, "Enabling GPS is mandatory", Toast.LENGTH_LONG).show();
                    finish();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    void startServices() {
        runOnUiThread(() -> {
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
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    void endPointsLocation(){
        runOnUiThread(() -> {
            Geocoder geocoder;
            List<Address> addresses = null;
            geocoder = new Geocoder(GoogleMapPlacesActivity.this, Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(destination.latitude,destination.longitude, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addresses != null) {
                dropoffArea = addresses.get(0).getAddressLine(0);
                defaul = false;
                getState();
                getCity(addresses.get(0).getAdminArea());
            }
        });
    }

    void startNearByPoint() {
        runOnUiThread(() -> {
            Geocoder geocoder;
            List<Address> addresses = null;
            geocoder = new Geocoder(GoogleMapPlacesActivity.this, Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addresses != null) {
                pickupArea = addresses.get(0).getAddressLine(0);
                city_list.setText(addresses.get(0).getLocality());
                state_list.setText(addresses.get(0).getAdminArea());
                defaul = false;
                getState();
                getCity(addresses.get(0).getAdminArea());
            }
        });

        switch (title) {
            case "Mechanic":
            case "Mechanics":
                startGetttingPlaces("" + mLastLocation.getLatitude(), "" + mLastLocation.getLongitude());
                break;
            case "Ambulance":
            case "Blood Bank":
            case "Hospitals":
            case "Pharmacies":
            case "Diagnostic Labs":
            case "Wellness Centers":
                startGetttingPlaces1("" + mLastLocation.getLatitude(), "" + mLastLocation.getLongitude());
                break;
            case "Nearby Testing Labs":
                startGetttingPlacesCovid("" + mLastLocation.getLatitude(), "" + mLastLocation.getLongitude());
                break;
            default:
                startGettingOtherservices("" + mLastLocation.getLatitude(), "" + mLastLocation.getLongitude());
                break;
        }
    }

    private void startGettingOtherservices(String lat, String Longi) {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=").append(lat).append(",").append(Longi);
        googlePlacesUrl.append("&radius=").append(5000);
        googlePlacesUrl.append("&types=").append(requestParams);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=").append(key1);
        Log.e("Complete ", googlePlacesUrl.toString());
        LatLng latlng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask(this);
        Object[] toPass = new Object[3];
        toPass[0] = mMap;
        toPass[1] = googlePlacesUrl.toString();
        toPass[2] = latlng;
        googlePlacesReadTask.execute(toPass);
    }

    void startGetttingPlacesCovid(String lat, String Longi) {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/textsearch/json?");
        googlePlacesUrl.append("location=").append(lat).append(",").append(Longi);
        googlePlacesUrl.append("&query=").append(requestParams);
        googlePlacesUrl.append("&radius=").append(5000);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=").append(key1);
        Log.e("Complete ", googlePlacesUrl.toString());
        LatLng latlng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask(this);
        Object[] toPass = new Object[3];
        toPass[0] = mMap;
        toPass[1] = googlePlacesUrl.toString();
        toPass[2] = latlng;
        googlePlacesReadTask.execute(toPass);
    }

    void startGetttingPlaces(String lat, String Longi) {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/textsearch/json?");
        googlePlacesUrl.append("location=").append(lat).append(",").append(Longi);
        googlePlacesUrl.append("&query=").append(requestParams);
        googlePlacesUrl.append("&radius=").append(5000);
        String type = "car_repair";
        googlePlacesUrl.append("&types=").append(type);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=").append(key1);
        Log.e("Complete ", googlePlacesUrl.toString());
        LatLng latlng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask(this);
        Object[] toPass = new Object[3];
        toPass[0] = mMap;
        toPass[1] = googlePlacesUrl.toString();
        toPass[2] = latlng;
        googlePlacesReadTask.execute(toPass);
    }

    void startGetttingPlaces1(String lat, String Longi) {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/textsearch/json?");
        googlePlacesUrl.append("location=").append(lat).append(",").append(Longi);
        googlePlacesUrl.append("&query=").append(requestParams);
        googlePlacesUrl.append("&radius=").append(5000);
        if(requestParams.equalsIgnoreCase("ambulance")) {
            googlePlacesUrl.append("&types=" + "ambulance");
        } else if (requestParams.equalsIgnoreCase("blood_bank")) {
            googlePlacesUrl.append("&types=" + "blood_bank");
        } else if (requestParams.equalsIgnoreCase("hospital")) {
            googlePlacesUrl.append("&types=" + "hospital");
        } else if (requestParams.equalsIgnoreCase("pharmacy")) {
            googlePlacesUrl.append("&types=" + "pharmacy");
        } else if (requestParams.equalsIgnoreCase("diagnostic_lab")) {
            googlePlacesUrl.append("&types=" + "diagnostic_lab");
        } else {
            googlePlacesUrl.append("&types=" + "gym");
        }
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=").append(key1);
        Log.e("Complete ", googlePlacesUrl.toString());
        LatLng latlng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask(this);
        Object[] toPass = new Object[3];
        toPass[0] = mMap;
        toPass[1] = googlePlacesUrl.toString();
        toPass[2] = latlng;
        googlePlacesReadTask.execute(toPass);
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == CITY_TAG) {
            initCity(object);
        } else if (Tag == STATE_TAG) {
            initState(object);
        }
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
        ProjectVolleyRequest2 request = new ProjectVolleyRequest2(GoogleMapPlacesActivity.this, object, UrlConstants.GET_STATE, this, STATE_TAG);
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
        ProjectVolleyRequest2 request = new ProjectVolleyRequest2(GoogleMapPlacesActivity.this, object, UrlConstants.GET_CITY_BASED_ON_NAME, this, CITY_TAG);
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

    void initCity(JSONObject object) {
        if (cityList != null) {
            cityList.clear();
        }
        if (defaul) {
            city_list.setText(getResources().getString(R.string.city_label));
        }
        if (object.optString("Message").equals("Success")) {
            if (defaul) {
                city_list.setTextColor(Color.RED);

            } else {
                city_list.setTextColor(Color.GRAY);
            }
            cityList = new ArrayList<>();
            JSONArray arr;
            try {
                arr = object.getJSONArray("CityDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    cityList.add(new ClaimFilterModel(obj.getString("CityId"), obj.getString("CityName")));
                }
            } catch (JSONException e) {
                LogUtils.showLog("@@@@@error", "ERROE");
                e.printStackTrace();
            }
        } else {
            city_list.setTextColor(Color.GRAY);
            Toast.makeText(this, getResources().getString(R.string.no_city), Toast.LENGTH_SHORT).show();
        }
    }

    void popUpForStateList() {
        final AdapterFilter adapter = new AdapterFilter(GoogleMapPlacesActivity.this, stateList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(GoogleMapPlacesActivity.this);
        LayoutInflater inflater = GoogleMapPlacesActivity.this.getLayoutInflater();
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
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(v -> alertDialog.dismiss());
        lv.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            tv.setText(adapter.getData(position).getName());
            selectedStateId = adapter.getData(position);
            if (selectedStateId != null) {
                state_list.setText(adapter.getData(position).getName());
                city_list.setTextColor(Color.RED);
                defaul = true;
                getCity(adapter.getData(position).getName());
            }
            alertDialog.dismiss();
        });
    }

    void popUpForCityList() {
        final AdapterFilter adapter = new AdapterFilter(GoogleMapPlacesActivity.this, cityList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(GoogleMapPlacesActivity.this);
        LayoutInflater inflater = GoogleMapPlacesActivity.this.getLayoutInflater();
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
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(v -> alertDialog.dismiss());
        lv.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            tv.setText(adapter.getData(position).getName());
            selectedCityId = adapter.getData(position);
            if (selectedCityId != null) {
                city_list.setText(adapter.getData(position).getName());
                city_list.setTextColor(Color.GRAY);
                customDialog = CustomProgressDialog.getInstance(GoogleMapPlacesActivity.this);
                customDialog.showProgressBar();
                new ClassForLatLong().execute(selectedCityId.getName());

            }
            alertDialog.dismiss();
        });
    }

    public static JSONObject getLocationInfo(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            address = address.replaceAll(" ", "%20");
            HttpPost httppost = new HttpPost("https://maps.google.com/maps/api/geocode/json?address=" + address + "&sensor=false" + "&key=AIzaSyAMiYAw5JRMFjD3H6erGvs-fXPo_WlZR4w");
            HttpClient client = new DefaultHttpClient();
            HttpResponse response;
            stringBuilder = new StringBuilder();
            response = client.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(stringBuilder.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public void positive() {
        getState();
        requestParams = "two_wheeler_mechanic";
        map_title.setText(getIntent().getStringExtra("title"));
        MySharedPreference pref = MySharedPreference.getInstance(this);
        pref.setNearby_Tag(requestParams);
        customDialog = CustomProgressDialog.getInstance(GoogleMapPlacesActivity.this);
        if (MyApplication.getInstance().isGooglePlayServicesAvailable(this)){
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
            mapFragment.getMapAsync(this);
            init();
        }
    }

    @Override
    public void Negative() {
        getState();
        requestParams = "car_mechanic";
        map_title.setText(getIntent().getStringExtra("title"));
        MySharedPreference pref = MySharedPreference.getInstance(this);
        pref.setNearby_Tag(requestParams);
        customDialog = CustomProgressDialog.getInstance(GoogleMapPlacesActivity.this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
        init();
    }

    @SuppressLint("StaticFieldLeak")
    class ClassForLatLong extends AsyncTask<String, Integer, JSONObject> {
        @Override
        protected JSONObject doInBackground(String... params) {
            return getLocationInfo(params[0]);
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            customDialog.hideProgressBar();
            try {
                double longitute = ((JSONArray) result.get("results")).getJSONObject(0)
                        .getJSONObject("geometry").getJSONObject("location")
                        .getDouble("lng");
                double latitude = ((JSONArray) result.get("results")).getJSONObject(0)
                        .getJSONObject("geometry").getJSONObject("location")
                        .getDouble("lat");
                switch (title) {
                    case "Mechanic":
                    case "Mechanics":
                        startGetttingPlaces("" + latitude, "" + longitute);
                        break;
                    case "Nearby Testing Labs":
                        startGetttingPlacesCovid("" + latitude, "" + longitute);
                        break;
                    case "Ambulance":
                    case "Blood Bank":
                    case "Hospitals":
                    case "Pharmacies":
                    case "Diagnostic Labs":
                    case "Wellness Centers":
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                startGetttingPlaces1("" + latitude, "" + longitute);
                            }
                        }, 5000);
                        break;
                    default:
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                startGettingOtherservices("" + latitude, "" + longitute);
                            }
                        }, 5000);
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    void showDataInfo(String nameData, String addressDat,
                      String foratAddress,String rateData, String OpenHours, String place_ref) {
        place_info_layout.setVisibility(View.VISIBLE);
        draw_route.setVisibility(View.VISIBLE);
        getMobileNo(place_ref);
        if(addressDat.equals("-NA-")){
            address.setText(foratAddress);
        }else{
            address.setText(addressDat);
        }
        String styledText;
        if (!OpenHours.equals("-NA-")) {
            if (OpenHours.equals("true")) {
                styledText = nameData + "<font color='#109d58'><small>" + "  Open" + "</small></font>";
                name.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else {
                styledText = nameData + "<font color='red'><small>" + "  Closed" + "</small></font>";
                name.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }else {
            styledText = nameData + "<font color='red'><small>" + "  " + "</small></font>";
            name.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
        }
        if (!rateData.equals("-NA-")) {
            float rate = Float.parseFloat(rateData);
            if (rate > 0) {
                ratingbar.setRating(rate);
            } else {
                ratingbar.setRating(0);
            }
        } else {
            ratingbar.setRating(0);
        }
    }

    void initLayoutInfoView() {
        ratingbar = findViewById(R.id.ratingbar);
        connect = findViewById(R.id.connect);
        contact_text =  findViewById(R.id.contact_text);
        address =  findViewById(R.id.address);
        name =  findViewById(R.id.name);
        draw_route = findViewById(R.id.draw_route);
        place_info_layout = findViewById(R.id.place_info_layout);
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(v -> {
            place_info_layout.setVisibility(View.GONE);
            draw_route.setVisibility(View.GONE);
        });
        draw_route.setOnClickListener(v -> drawRouteNow(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), destination));
        connect.setOnClickListener(v -> {
            LogUtils.showLog("@@@@", contact_text.getText().toString());
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + contact_text.getText().toString()));
            startActivity(intent);
        });
        uber_layout.setOnClickListener(v -> {
            endPointsLocation();
            BookUber(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), destination);
        });
    }

    private void BookUber(LatLng from, LatLng to){
        String uri = "https://m.uber.com/ul/?client_id=7k3ZFi4nfrJMpeNu_1Rf10vY0drSRg50&action=setPickup&pickup[latitude]=" +
                from.latitude + "&pickup[longitude]=" +
                from.longitude + "&pickup[formatted_address]="
                +pickupArea+"&dropoff[latitude]=" + to.latitude + "&dropoff[longitude]="
                + to.longitude+"&dropoff[formatted_address]="+dropoffArea;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        this.startActivity(intent);
        place_info_layout.setVisibility(View.GONE);
    }

    void drawRouteNow(LatLng from, LatLng to) {
        String uri = "http://maps.google.com/maps?saddr=" + from.latitude + "," + from.longitude + "&daddr=" + to.latitude + "," + to.longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        this.startActivity(intent);
        place_info_layout.setVisibility(View.GONE);
    }

    void getMobileNo(String refId) {
        connect.setVisibility(View.GONE);
        String URL = "https://maps.googleapis.com/maps/api/place/details/json?reference=" + refId + "&key=" + key1;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                response -> {
                    try {
                        JSONObject object = new JSONObject(response);
                        String mobile = object.getJSONObject("result").optString("international_phone_number");
                        if (mobile != null && mobile.trim().length() > 0) {
                            connect.setVisibility(View.VISIBLE);
                            contact_text.setText(mobile);
                        } else {
                            connect.setVisibility(View.GONE);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
        });
        MyApplication.getInstance().addToRequestQueue(stringRequest, "200000");
    }
}
