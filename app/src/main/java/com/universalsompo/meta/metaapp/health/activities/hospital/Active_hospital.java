package com.universalsompo.meta.metaapp.health.activities.hospital;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.ui.IconGenerator;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.hospital.adapter.Hospital_adapter;
import com.universalsompo.meta.metaapp.health.activities.hospital.model.HospitalModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.adapters.AdapterFilter;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Active_hospital extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResponseListener {
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
    private ArrayList<HospitalModel> hospitalList = new ArrayList<HospitalModel>();
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
    RecyclerView active_hospital_rey;
    Hospital_adapter hospital_adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_active_hospital, container, false);

        if (android.os.Build.VERSION.SDK_INT >= 21)
           getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        cross_icon = view.findViewById(R.id.cross_icon2);
        state_list = view.findViewById(R.id.state_list);
        city_list = view.findViewById(R.id.city_list);
        company_list = view.findViewById(R.id.company_list);
        vehicle_list =view.findViewById(R.id.vehicle_list);
        marker_info_layout = view.findViewById(R.id.marker_info_layout);
        connect = view.findViewById(R.id.connect);
        close =view. findViewById(R.id.close);
        location_text =view.findViewById(R.id.location_text);
        direction_img = view.findViewById(R.id.direction_img);
        contact_text =view. findViewById(R.id.contact_text);
        name_of_workshop =view. findViewById(R.id.name_of_workshop);
        back_button = view.findViewById(R.id.back_button);
        active_hospital_rey = view.findViewById(R.id.active_hospital_rey);


        city_list.setOnClickListener(v -> {
            if (cityList != null && cityList.size() > 0) {
                popUpForCityList();
            } else {
                Toast.makeText(getContext(), "Please Select State First", Toast.LENGTH_SHORT).show();
            }
        });
        state_list.setOnClickListener(v -> {
            if (stateList != null && stateList.size() > 0) {
                popUpForStateList();
            } else {
                Toast.makeText(getContext(), "Please Restart app", Toast.LENGTH_SHORT).show();
            }
        });

        customDialog = CustomProgressDialog.getInstance(getContext());
        init();
        return view;
    }
    void init() {
        buildGoogleApiClient();
    }

    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            mLastLocation = location;
            latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        }
    };
    protected synchronized void buildGoogleApiClient() {
        customDialog.showProgressBar();

        mGoogleApiClient = new GoogleApiClient.Builder(getContext())
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
        getActivity().finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        customDialog.hideProgressBar();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2000) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    startProgressNow();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(getContext(), "Enabling GPS is mandatory", Toast.LENGTH_LONG).show();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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
                            status.startResolutionForResult(getActivity(), 2000);
                        } catch (IntentSender.SendIntentException e) {
                        }
                        break;
                }
            }
        });
    }

    void startProgressNow() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, listener);
        startServices();

    }

    void startNearByPoint() {
        LogUtils.showLog("@@@@@@@@@@@@@", "" + mLastLocation.getLatitude());
        LogUtils.showLog("@@@@@@@@@@@@@", "" + mLastLocation.getLongitude());
        latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Geocoder geocoder;
                List<Address> addresses = null;
                geocoder = new Geocoder(getContext(), Locale.getDefault());
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
                    initLocations();
                    getState();

                }
            }
        });
    }

    void startServices() {
        getActivity().runOnUiThread(new Runnable() {
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
        getActivity().runOnUiThread(() -> {
            if (Tag == CITY_TAG) {
                initCity(object);
            } else if (Tag == STATE_TAG) {

                init_State(object);
            }
//            else if (Tag == VEHICLE_TAG) {
//                initVehicle(object);
//            } else if (Tag == COMAPNY_LIST_TAG) {
//                getVehicle();
//                initCompanyList(object);
//            }
            else if (Tag == GARAGE_LIST_TAG) {
                initGarageList(object);
            }
        });
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
            Toast.makeText(getContext(), "No city associated with this state", Toast.LENGTH_SHORT).show();
        }
    }

    void init_State(JSONObject object) {

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
            Toast.makeText(getContext(), "No State Found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    void getState() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getContext()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getContext()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest request = new ProjectVolleyRequest(getContext(), object, UrlConstants.GET_STATE, this, STATE_TAG);
        request.execute();
    }

    void getCity(String stateId) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getContext()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getContext()).getUID());
            object.put("StateName", stateId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest request = new ProjectVolleyRequest(getContext(), object, UrlConstants.GET_CITY_BASED_ON_NAME, this, CITY_TAG);
        request.execute();
    }

    void popUpForStateList() {
        final AdapterFilter adapter = new AdapterFilter(getActivity(), stateList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
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
        final AdapterFilter adapter = new AdapterFilter(getActivity(), cityList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
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


    void initLocations() {

        if (selectedCityId == null) {
            Toast.makeText(getContext(), "Please Select the City", Toast.LENGTH_SHORT).show();
            return;
        }
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getContext()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getContext()).getUID());
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
        ProjectVolleyRequest request = new ProjectVolleyRequest(getContext(), object, UrlConstants.GET_ALL_Hospital, this, GARAGE_LIST_TAG);
        request.execute();
    }
    void initGarageList(JSONObject object) {
        hospitalList.clear();
        LatLng latlng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        if (object.optString("Message").equals("Success")) {
            IconGenerator generator = new IconGenerator(getContext());
            generator.setBackground(null);
            String uri = "@drawable/new_pinpoint_icon";  // where myresource (without the extension) is the file
            int imageResource = getResources().getIdentifier(uri, null,getActivity().getPackageName());
            ImageView iv = new ImageView(getActivity());
            Drawable res = getResources().getDrawable(imageResource);
            iv.setImageDrawable(res);
            generator.setContentView(iv);
            Bitmap icon = generator.makeIcon();
            JSONArray arr = null;
            try {
                active_hospital_rey.setVisibility(View.VISIBLE);
                arr = object.getJSONArray("ALHospitalDetails");

                for (int i = 0; i <arr.length(); i++) {
                    String status = arr.optJSONObject(i).getString("Status");
                    if (status.equals("Active")){
                        hospitalList.add(new HospitalModel(
                                arr.optJSONObject(i).optString("Address"),
                                arr.optJSONObject(i).optString("FullAddress"),
                                arr.optJSONObject(i).optString("City"),
                                arr.optJSONObject(i).optString("ContactEmail"),
                                arr.optJSONObject(i).optString("ContactNo"),
                                arr.optJSONObject(i).optString("ContactPerson"),
                                arr.optJSONObject(i).optString("Country"),
                                arr.optJSONObject(i).optString("LandlineNo"),
                                arr.optJSONObject(i).optString("Latitude"),
                                arr.optJSONObject(i).optString("Longitude"),
                                arr.optJSONObject(i).optString("NameOfWorkshop"),
                                arr.optJSONObject(i).optString("PinCode"),
                                arr.optJSONObject(i).optString("State"),
                                arr.optJSONObject(i).optString("VehicleMake"),
                                arr.optJSONObject(i).optString("Status"),
                                arr.optJSONObject(i).optString("distance")));
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    active_hospital_rey.setLayoutManager(layoutManager);
                    hospital_adapter = new Hospital_adapter(getActivity(), hospitalList);
                    active_hospital_rey.setAdapter(hospital_adapter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            active_hospital_rey.setVisibility(View.GONE);
            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
        }
    }


}