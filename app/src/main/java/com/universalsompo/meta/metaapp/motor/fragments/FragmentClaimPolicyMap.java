package com.universalsompo.meta.metaapp.motor.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.adapters.AdapterFilter;
import com.universalsompo.meta.metaapp.motor.adapters.ClaimMapListViewAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.Interface3;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.models.ClaimMapDataModel;
import com.universalsompo.meta.metaapp.motor.models.GarageRequestModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.DataParser;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
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
import java.util.Objects;

public class FragmentClaimPolicyMap extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener, GoogleMap.OnMarkerClickListener, Interface3 {
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private double Latitude;
    private double Longitude;
    private Location mLastLocation;
    private ArrayList<ClaimMapDataModel> garageList;
    private ArrayList<Marker> markerData = new ArrayList<>();
    private LinearLayout marker_info_layout;
    private TextView location_text;
    private TextView contact_text;
    private TextView name_of_workshop;
    private ListView garage_list_info;
    private TextView text_state;
    private Polyline polyline;
    private TextView no_data_found;
    private TextView text_city;
    private TextView text_compny;
    private ArrayList<ClaimFilterModel> stateList;
    private ArrayList<ClaimFilterModel> cityList;
    private ArrayList<ClaimFilterModel> vehicleMakeLiat;
    private FrameLayout fram_map;
    private int Counter = 0;
    private ImageView switch_image;
    private ClaimFilterModel selectedStateId;
    private ClaimFilterModel selectedCityId;
    private ClaimFilterModel selectedVehicleMakeId;
    private ImageView direction_img;
    private GarageRequestModel model;
    private Marker mMarker;
    private LinearLayout connect;
    private Interface3 inter;
    private ClaimMapListViewAdapter adapter;
    private LatLng latLng;
    private Marker markerLocation;
    private boolean defaul = false;
    private String veh_type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewMain = inflater.inflate(R.layout.claim_map, container, false);
        model = new GarageRequestModel();
        assert getArguments() != null;
        String insComp = getArguments().getString("key");
        veh_type = getArguments().getString("veh_type");
        model.setInsCompId(insComp);
        String[] splited = Objects.requireNonNull(getArguments().getString("make")).split(" ");
        String vehicleMake = splited[0];
        inter = this;
        model.setVehicleMake(vehicleMake);
        marker_info_layout = viewMain.findViewById(R.id.marker_info_layout);
        location_text = viewMain.findViewById(R.id.location_text);
        contact_text = viewMain.findViewById(R.id.contact_text);
        name_of_workshop = viewMain.findViewById(R.id.name_of_workshop);
        text_state = viewMain.findViewById(R.id.text_state);
        text_city = viewMain.findViewById(R.id.text_city);
        text_compny = viewMain.findViewById(R.id.text_compny);
        no_data_found = viewMain.findViewById(R.id.no_data_found);
        LinearLayout switchView = viewMain.findViewById(R.id.switchView);
        connect = viewMain.findViewById(R.id.connect);
        garage_list_info = viewMain.findViewById(R.id.garage_list_info);
        fram_map = viewMain.findViewById(R.id.fram_map);
        switch_image = viewMain.findViewById(R.id.switch_image);
        direction_img = viewMain.findViewById(R.id.direction_img);
        ImageView close = viewMain.findViewById(R.id.close);
        text_compny.setText(vehicleMake);
        text_city.setOnClickListener(v -> {
            if (cityList != null && cityList.size() > 0) {
                popUpForCityList();
            } else {
                Toast.makeText(getActivity(), "No city found", Toast.LENGTH_SHORT).show();
            }
        });

        text_compny.setOnClickListener(v -> {
            if (vehicleMakeLiat != null) {
                popUpForVehicleMakeList();
            }
        });

        text_state.setOnClickListener(v -> {
            if (stateList != null) {
                popUpForStateList();
            }
        });

        switchView.setOnClickListener(v -> {
            if (Counter == 0) {
                Counter = 1;
                switch_image.setImageResource(R.drawable.locator);
                switch_image.setColorFilter(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
                fram_map.setVisibility(View.GONE);
                if (garageList != null && garageList.size() > 0) {
                    garage_list_info.setVisibility(View.VISIBLE);
                    no_data_found.setVisibility(View.GONE);
                } else {
                    garage_list_info.setVisibility(View.GONE);
                    no_data_found.setVisibility(View.VISIBLE);
                }
            } else if (Counter == 1) {
                Counter = 0;
                switch_image.setImageResource(R.drawable.grid);
                switch_image.setColorFilter(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
                fram_map.setVisibility(View.VISIBLE);
                garage_list_info.setVisibility(View.GONE);
                no_data_found.setVisibility(View.GONE);
                if (latLng != null && mMap != null) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
                }
            }
            marker_info_layout.setVisibility(View.GONE);
        });

        close.setOnClickListener(v -> marker_info_layout.setVisibility(View.GONE));

        init();
        return viewMain;
    }

    private void init() {
        if (MyApplication.getInstance().isGooglePlayServicesAvailable(getActivity())) {
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            assert mapFragment != null;
            mapFragment.getMapAsync(this);
        }
    }

    private void drawRouteNow(LatLng from, LatLng to) {
        if (polyline != null) {
            polyline.remove();
            polyline.getPoints().clear();
        }
        FetchUrl fetchUrl = new FetchUrl();
        fetchUrl.execute(getUrl(from, to));
        marker_info_layout.setVisibility(View.GONE);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        buildGoogleApiClient();
        mGoogleApiClient.connect();
        mMap.setOnMarkerClickListener(this);
        mMap.getUiSettings().setMapToolbarEnabled(false);
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(Objects.requireNonNull(getActivity()))
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
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
            Latitude = mLastLocation.getLatitude();
            Longitude = mLastLocation.getLongitude();
            model.setLatitude("" + Latitude);
            model.setLongitude("" + Longitude);
            latLng = new LatLng(Latitude, Longitude);
            markerLocation = mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));

            Objects.requireNonNull(getActivity()).runOnUiThread(() -> {
                Geocoder geocoder;
                List<Address> addresses = null;
                geocoder = new Geocoder(getActivity(), Locale.getDefault());
                try {
                    addresses = geocoder.getFromLocation(Latitude, Longitude, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (addresses != null) {
                    text_city.setText(addresses.get(0).getLocality());
                    text_state.setText(addresses.get(0).getAdminArea());
                    defaul = false;
                    model.setCity(addresses.get(0).getLocality());
                    model.setState(addresses.get(0).getAdminArea());
                    getState();
                    getCity(addresses.get(0).getAdminArea());
                }
            });
        } else {
            Toast.makeText(getActivity(), "Please wait we are getting your location", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) { }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) { }

    @Override
    public void onResume() {
        super.onResume();
        if (mGoogleApiClient != null && !mGoogleApiClient.isConnected())
            mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected())
            mGoogleApiClient.disconnect();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (polyline != null) {
            polyline.remove();
            polyline.getPoints().clear();
        }
        if (marker.equals(markerLocation)) {
            mMap.getUiSettings().setMapToolbarEnabled(true);
            return false;
        }
        if (markerData.contains(marker))
            if (mMarker != null) {
                IconGenerator generator = new IconGenerator(getActivity());
                generator.setBackground(null);
                String uri = "@drawable/new_pinpoint_icon";
                int imageResource = getResources().getIdentifier(uri, null, Objects.requireNonNull(getActivity()).getPackageName());
                ImageView iv = new ImageView(getActivity());
                Drawable res = getResources().getDrawable(imageResource);
                iv.setImageDrawable(res);
                generator.setContentView(iv);
                Bitmap icon = generator.makeIcon();
                try {
                    mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(icon));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        IconGenerator generator = new IconGenerator(getActivity());
        generator.setBackground(null);
        String uri = "@drawable/new_pinpoint_icon";
        int imageResource = getResources().getIdentifier(uri, null, Objects.requireNonNull(getActivity()).getPackageName());
        ImageView iv = new ImageView(getActivity());
        Drawable res = getResources().getDrawable(imageResource);
        iv.setImageDrawable(res);
        generator.setContentView(iv);
        Bitmap icon = generator.makeIcon();
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(icon));
        int position = markerData.indexOf(marker);
        final ClaimMapDataModel data = garageList.get(position);
        marker_info_layout.setVisibility(View.VISIBLE);
        location_text.setText(data.getAddress());
        contact_text.setText(data.getLandlineNo());
        name_of_workshop.setText(data.getNameOfWorkshop());
        mMarker = marker;

        direction_img.setOnClickListener(v -> {
            LatLng latLng=new LatLng(Double.parseDouble(data.getLatitude()),Double.parseDouble(data.getLongitude()));
            drawRouteNow(latLng,new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
        });

        if (data.getContactNo().equals(""))
            connect.setVisibility(View.GONE);
            connect.setOnClickListener(v -> callUsDialog(data.getContactNo(), data.getNameOfWorkshop()));

        return false;
    }

    private void hitApi() {
        JSONObject object = new JSONObject();
        try {
            object.put("InsCompId", model.getInsCompId());
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getActivity()).getUID());
            object.put("Latitude", mLastLocation.getLatitude());
            object.put("Longitude", mLastLocation.getLongitude());
            object.put("VehicleMake", model.getVehicleMake());
            object.put("VehicleType", veh_type);
            String city = "";
            String state = "";
            if (model.getState() != null) {
                state = model.getState();
            }
            if (model.getCity() != null) {
                city = model.getCity();
            }
            object.put("State", state);
            object.put("City", city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_GARAGE_LIST, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                new AppDataPushApi().callApi(getActivity(),"Claim","Claim Garage List","Searched for network garages in claim section");
                mMap.clear();
                if (garageList != null)
                    garageList.clear();
                if (object.optString("Message").equals("Success")) {
                    if (garageList != null) {
                        garageList.clear();
                    }
                    if (markerData != null) {
                        markerData.clear();
                    }
                    marker_info_layout.setVisibility(View.GONE);
                    IconGenerator generator = new IconGenerator(getActivity());
                    generator.setBackground(null);
                    String uri = "@drawable/new_pinpoint_icon";
                    int imageResource = getResources().getIdentifier(uri, null, Objects.requireNonNull(getActivity()).getPackageName());
                    ImageView iv = new ImageView(getActivity());
                    Drawable res = getResources().getDrawable(imageResource);
                    iv.setImageDrawable(res);
                    generator.setContentView(iv);
                    Bitmap icon = generator.makeIcon();

                    JSONArray arr;
                    try {
                        garageList = new ArrayList<>();
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

                        int width;
                        int height;
                        int padding;
                        CameraUpdate cu;
                        LatLngBounds.Builder builder;
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

                        if (Counter == 1) {
                            garage_list_info.setVisibility(View.VISIBLE);
                            switch_image.setBackgroundResource(R.drawable.locator);
                            no_data_found.setVisibility(View.GONE);
                        }
                        adapter = new ClaimMapListViewAdapter(getActivity(), garageList, inter);
                        garage_list_info.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (garageList != null)
                        garageList.clear();
                    if (adapter != null)
                        adapter.notifyDataSetChanged();
                    Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
                    if (Counter == 1) {
                        garage_list_info.setVisibility(View.GONE);
                        no_data_found.setVisibility(View.VISIBLE);
                    }
                }
                markerLocation = mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
            }

            @Override
            public void onError(VolleyError error, int Tag) {
                markerLocation = mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
            }
        }, 6767).execute();
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
    }

    private void getState() {
        marker_info_layout.setVisibility(View.GONE);
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_STATE, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    mMap.clear();
                    if (garageList != null)
                        garageList.clear();
                    stateList = new ArrayList<>();
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
                    getVehicleMake();
                } else {
                    Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) { }

        }, 78).execute();
    }

    private void getCity(String data) {
        marker_info_layout.setVisibility(View.GONE);
        mMap.clear();
        if (garageList != null)
            garageList.clear();
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getActivity()).getUID());
            object.put("StateName", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_CITY_BASED_ON_NAME, new ResponseListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    cityList = new ArrayList<>();
                    JSONArray arr;
                    try {
                        arr = object.getJSONArray("CityDetails");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            cityList.add(new ClaimFilterModel(obj.getString("CityId"), obj.getString("CityName")));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (defaul) {
                        text_city.setText("City");
                        text_city.setTextColor(Color.RED);
                        model.setCity(null);
                    }
                } else {
                    if (cityList != null)
                        cityList.clear();
                    text_city.setText("");
                    text_city.setHintTextColor(Color.RED);
                    model.setCity(null);
                    Toast.makeText(getActivity(), "No city associated with this state", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) { }
        }, 78).execute();
    }

    private void getVehicleMake() {
        marker_info_layout.setVisibility(View.GONE);
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getActivity()).getUID());
            object.put("VehicleType", veh_type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_VEHICLE, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    vehicleMakeLiat = new ArrayList<>();
                    JSONArray arr;
                    try {
                        arr = object.getJSONArray("VehicleDetails");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            vehicleMakeLiat.add(new ClaimFilterModel(obj.getString("VehicleId"), obj.getString("VehicleName")));
                        }
                        hitApi();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) { }
        }, 89).execute();
    }

    private void popUpForStateList() {
        final AdapterFilter adapter = new AdapterFilter(getActivity(), stateList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
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
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(v -> alertDialog.dismiss());
        lv.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            tv.setText(adapter.getData(position).getName());
            selectedStateId = adapter.getData(position);
            if (selectedStateId != null) {
                text_state.setText(adapter.getData(position).getName());
                defaul = true;

                model.setState(adapter.getData(position).getName());
                getCity(adapter.getData(position).getName());
            }
            alertDialog.dismiss();

        });
    }

    private void popUpForCityList() {
        final AdapterFilter adapter = new AdapterFilter(getActivity(), cityList);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
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
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(v -> alertDialog.dismiss());
        lv.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            tv.setText(adapter.getData(position).getName());
            selectedCityId = adapter.getData(position);
            if (selectedCityId != null) {
                text_city.setText(adapter.getData(position).getName());
                text_city.setTextColor(Color.GRAY);
                model.setCity(adapter.getData(position).getName());
                hitApi();
            }
            alertDialog.dismiss();
        });
    }

    private void popUpForVehicleMakeList() {
        final AdapterFilter adapter = new AdapterFilter(getActivity(), vehicleMakeLiat);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
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

        tv.setHint("Vehicle Make");
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Cancel", null);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(v -> alertDialog.dismiss());
        lv.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            tv.setText("");
            tv.setText(adapter.getData(position).getName());
            selectedVehicleMakeId = adapter.getData(position);
            if (selectedVehicleMakeId != null) {
                text_compny.setText(selectedVehicleMakeId.getName());
                model.setVehicleMake(selectedVehicleMakeId.getName());
                if (cityList != null) {
                    if (cityList.size() > 0) {
                        if (model.getCity() != null) {
                            hitApi();
                        } else {
                            Toast.makeText(getActivity(), "Please Select City", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        hitApi();
                    }
                } else {
                    hitApi();
                }
            }
            alertDialog.dismiss();
        });
    }


    private void callUsDialog(final String no, String Title) {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.dialog_call_us_claim);
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
        tvcancel.setOnClickListener(v -> dialog.dismiss());

        marker_info_layout.setVisibility(View.GONE);

        dialog.show();

    }


    @Override
    public void getSelect(int position) {
        ClaimMapDataModel model = garageList.get(position);
        fram_map.setVisibility(View.VISIBLE);
        garage_list_info.setVisibility(View.GONE);
        switch_image.setImageResource(R.drawable.grid);

        Counter = 0;
        LatLng lng = new LatLng(Float.parseFloat(model.getLatitude()), Float.parseFloat(model.getLongitude()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lng, 14.0f));
    }

    private String getUrl(LatLng origin, LatLng dest) {
        String sensor = "sensor=false";
        return "https://maps.googleapis.com/maps/api/directions/json?" + "origin=" + origin.latitude + "," + origin.longitude + "&" + "destination=" + dest.latitude + "," + dest.longitude + "&" + sensor;
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
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
            Log.d("downloadUrl", data);
            br.close();
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class FetchUrl extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                data = downloadUrl(url[0]);
                Log.d("Background Task data", data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
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
                Log.d("ParserTask", jsonData[0]);
                DataParser parser = new DataParser();
                Log.d("ParserTask", parser.toString());
                routes = parser.parse(jObject);
                Log.d("ParserTask", "Executing routes");
                Log.d("ParserTask", routes.toString());

            } catch (Exception e) {
                Log.d("ParserTask", e.toString());
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

                Log.d("onPostExecute", "onPostExecute lineoptions decoded");

            }

            if (lineOptions != null) {
                polyline = mMap.addPolyline(lineOptions);
            } else {
                Log.d("onPostExecute", "without Polylines drawn");
            }
        }
    }
}
