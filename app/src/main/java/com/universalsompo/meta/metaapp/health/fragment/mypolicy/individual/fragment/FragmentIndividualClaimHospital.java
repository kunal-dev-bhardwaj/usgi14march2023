package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.fragment;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
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

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
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
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.adapter.AdapterHospitalFilter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.adapter.AdapterStateFilter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.adapter.ClaimMapHospitalListViewAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model.CityFilterModel;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model.ClaimMapHospitalDataModel;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model.HospitalRequestModel;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model.StateFilterModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.DataParser;
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

public class FragmentIndividualClaimHospital extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener, GoogleMap.OnMarkerClickListener {
    View v;
    private SelectorListener binder;
    String policyID/*, insuranceID*/, insuranceName;
    MySharedPreference pref;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private ProgressDialog pd;
    private double Latitude;
    private double Longitude;
    private Location mLastLocation;
    private ArrayList<ClaimMapHospitalDataModel> hospitalList;
    private ArrayList<Marker> markerData = new ArrayList<>();
    private LinearLayout marker_info_layout;
    private TextView location_text;
    private TextView contact_text;
    private TextView name_of_workshop;
    private LinearLayout switchView;
    private ListView garage_list_info;
    private TextView text_state;
    private TextView no_data_found;
    private TextView text_city;
    private ArrayList<StateFilterModel> stateList;
    private ArrayList<CityFilterModel> cityList;
    private FrameLayout fram_map;
    private int Counter = 0;
    private ImageView switch_image;
    private StateFilterModel selectedStateId;
    private CityFilterModel selectedCityId;
    private ImageView close;
    private ImageView direction_img;
    private HospitalRequestModel model;
    private Marker mMarker;
    private LinearLayout connect;
    private LatLng latLng;
    private Marker markerLocation;
    private boolean defaul = false;
    private Polyline polyline;
    String stateid, cityid;
    private ClaimMapHospitalListViewAdapter adapter;
    List<Address> addresses = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_individual_claim_hospital, container, false);
        model = new HospitalRequestModel();
        policyID = getArguments().getString("policyID");
        // insuranceID = getArguments().getString("insuranceID");
        insuranceName = getArguments().getString("insuranceName");
        pref = MySharedPreference.getInstance(getActivity());
        //model.setInsCompId(insuranceID);
        marker_info_layout = v.findViewById(R.id.marker_info_layout);
        location_text = v.findViewById(R.id.location_text);
        contact_text = v.findViewById(R.id.contact_text);
        name_of_workshop = v.findViewById(R.id.name_of_workshop);
        text_state = v.findViewById(R.id.text_state);
        text_city = v.findViewById(R.id.text_city);
        no_data_found = v.findViewById(R.id.no_data_found);
        switchView = v.findViewById(R.id.switchView);
        connect = v.findViewById(R.id.connect);
        garage_list_info = v.findViewById(R.id.garage_list_info);
        fram_map = v.findViewById(R.id.fram_map);
        switch_image = v.findViewById(R.id.switch_image);
        direction_img = v.findViewById(R.id.direction_img);
        close = v.findViewById(R.id.close);

        text_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stateList != null) {
                    popUpForStateList();
                }
            }
        });

        text_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cityList != null && cityList.size() > 0) {
                    popUpForCityList();
                } else {
                    Toast.makeText(getActivity(), "No city found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        switchView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Counter == 0) {
                    Counter = 1;
                    switch_image.setBackgroundResource(R.drawable.locator);
                    fram_map.setVisibility(View.GONE);
                    if (hospitalList != null && hospitalList.size() > 0) {
                        garage_list_info.setVisibility(View.VISIBLE);
                        no_data_found.setVisibility(View.GONE);
                    } else {
                        garage_list_info.setVisibility(View.GONE);
                        no_data_found.setVisibility(View.VISIBLE);
                    }
                } else if (Counter == 1) {
                    Counter = 0;
                    switch_image.setBackgroundResource(R.drawable.grid);
                    fram_map.setVisibility(View.VISIBLE);
                    garage_list_info.setVisibility(View.GONE);
                    no_data_found.setVisibility(View.GONE);
                    if (latLng != null && mMap != null) {
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
                    }
                }
                marker_info_layout.setVisibility(View.GONE);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marker_info_layout.setVisibility(View.GONE);
            }
        });

        init();
        return v;
    }

    void init() {
        if (MyApplication.getInstance().isGooglePlayServicesAvailable(getActivity())) {
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }
    }

    void drawRouteNow(LatLng from, LatLng to) {
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
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Geocoder geocoder;
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
                        getState();
                        getCity(addresses.get(0).getAdminArea());
                    }
                }
            });
        } else {
            Toast.makeText(getActivity(), "Please wait we are getting your location", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) { }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) { }

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
                int imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
                ImageView iv = new ImageView(getActivity());
                Drawable res = getResources().getDrawable(imageResource);
                iv.setImageDrawable(res);
                generator.setContentView(iv);
                Bitmap icon = generator.makeIcon();
                try {
                    mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(icon));
                } catch (Exception e) { }
            }

        IconGenerator generator = new IconGenerator(getActivity());
        generator.setBackground(null);
        String uri = "@drawable/new_pinpoint_icon";
        int imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        ImageView iv = new ImageView(getActivity());
        Drawable res = getResources().getDrawable(imageResource);
        iv.setImageDrawable(res);
        generator.setContentView(iv);
        Bitmap icon = generator.makeIcon();
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(icon));
        int position = markerData.indexOf(marker);
        final ClaimMapHospitalDataModel data = hospitalList.get(position);
        marker_info_layout.setVisibility(View.VISIBLE);
        location_text.setText(data.getAddress());
        contact_text.setText(data.getContactNo());
        name_of_workshop.setText(data.getHospitalName());
        mMarker = marker;

        direction_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng latLng=new LatLng(Double.parseDouble(data.getLatitude()),Double.parseDouble(data.getLongitude()));
                drawRouteNow(latLng,new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
            }
        });

        if (data.getContactNo().equals(""))
            connect.setVisibility(View.GONE);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callUsDialog(data.getContactNo(), data.getHospitalName());
            }
        });
        return false;
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
    }

    void getState() {
        marker_info_layout.setVisibility(View.GONE);
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_STATE, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    mMap.clear();
                    if (hospitalList != null)
                        hospitalList.clear();
                    stateList = new ArrayList<StateFilterModel>();
                    JSONArray arr;
                    try {
                        arr = object.getJSONArray("StateDetails");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            String state_name = obj.getString("StateName");
                            if (state_name.equalsIgnoreCase(addresses.get(0).getAdminArea())) {
                                stateid=obj.getString("StateId");
                                model.setStateId(stateid);
                            }
                            stateList.add(new StateFilterModel(obj.getString("StateId"), obj.getString("StateName")));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) { }
        }, 78).execute();
    }

    void getCity(String data) {
        marker_info_layout.setVisibility(View.GONE);
        mMap.clear();
        if (hospitalList != null)
            hospitalList.clear();
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
            object.put("StateName", data);
        } catch (Exception e) { }

        new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_CITY_BASED_ON_NAME, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    cityList = new ArrayList<CityFilterModel>();
                    JSONArray arr;
                    try {
                        arr = object.getJSONArray("CityDetails");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            String city_name = obj.getString("CityName");
                            if (city_name.equalsIgnoreCase(addresses.get(0).getLocality())) {
                                cityid=obj.getString("CityId");
                                model.setCityId(cityid);
                            }
                            cityList.add(new CityFilterModel(obj.getString("CityId"), obj.getString("CityName")));
                        }
                        hitApi();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (defaul) {
                        text_city.setText("City");
                        text_city.setTextColor(Color.RED);
                        model.setCityId(null);
                    }
                } else {
                    if (cityList != null)
                        cityList.clear();
                    text_city.setText("");
                    text_city.setHintTextColor(Color.RED);
                    model.setCityId(null);
                    Toast.makeText(getActivity(), "No city associated with this state", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) { }
        }, 78).execute();
    }

    void popUpForStateList() {
        final AdapterStateFilter adapter = new AdapterStateFilter(getActivity(), stateList);
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
                alertDialog.dismiss();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                tv.setText(adapter.getData(position).getName());
                selectedStateId = adapter.getData(position);
                if (selectedStateId != null) {
                    text_state.setText(adapter.getData(position).getName());
                    defaul = true;
                    model.setStateId(adapter.getData(position).getId());
                    getCity(adapter.getData(position).getName());
                }
                alertDialog.dismiss();
            }
        });
    }

    void popUpForCityList() {
        final AdapterHospitalFilter adapter = new AdapterHospitalFilter(getActivity(), cityList);
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
                alertDialog.dismiss();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                tv.setText(adapter.getData(position).getName());
                selectedCityId = adapter.getData(position);
                if (selectedCityId != null) {
                    text_city.setText(adapter.getData(position).getName());
                    text_city.setTextColor(Color.GRAY);
                    model.setCityId(adapter.getData(position).getId());
                    hitApi();
                }
                alertDialog.dismiss();
            }
        });
    }

    void callUsDialog(final String no, String Title) {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.callus_dialog);
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

    private String getUrl(LatLng origin, LatLng dest) {
        String sensor = "sensor=false";
        String url = "https://maps.googleapis.com/maps/api/directions/json?" + "origin=" + origin.latitude + "," + origin.longitude + "&" + "destination=" + dest.latitude + "," + dest.longitude + "&" + sensor;
        return url;
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

    private class FetchUrl extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                e.printStackTrace();
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
                Log.d("onPostExecute", "without Polylines drawn");
            }
        }
    }

    void hitApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("InsuranceCompID", pref.getIns_comp_ID_health());
            String city = "";
            String state = "";
            if (model.getStateId() != null) {
                state = model.getStateId();
            }
            if (model.getCityId() != null) {
                city = model.getCityId();
            }
            object.put("StateID", state);
            object.put("CityID", city);
            object.put("Latitude", mLastLocation.getLatitude());
            object.put("Longitude", mLastLocation.getLongitude());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_HOSPITAL_LIST, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                mMap.clear();
                if (hospitalList != null)
                    hospitalList.clear();
                if (object.optString("Message").equals("Success")) {
                    if (hospitalList != null) {
                        hospitalList.clear();
                    }
                    if (markerData != null) {
                        markerData.clear();
                    }

                    marker_info_layout.setVisibility(View.GONE);
                    IconGenerator generator = new IconGenerator(getActivity());
                    generator.setBackground(null);
                    String uri = "@drawable/new_pinpoint_icon";  // where myresource (without the extension) is the file
                    int imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
                    ImageView iv = new ImageView(getActivity());
                    Drawable res = getResources().getDrawable(imageResource);
                    iv.setImageDrawable(res);
                    generator.setContentView(iv);
                    Bitmap icon = generator.makeIcon();

                    JSONArray arr = null;
                    try {
                        hospitalList = new ArrayList<ClaimMapHospitalDataModel>();
                        arr = object.getJSONArray("GetOwnNetworkHospitalRes");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            hospitalList.add(new ClaimMapHospitalDataModel(
                                    obj.optString("Address"),
                                    obj.optString("ContactNo"),
                                    obj.optString("EmailID"),
                                    obj.optString("HospitalID"),
                                    obj.optString("HospitalName"),
                                    obj.optString("Latitude"),
                                    obj.optString("Longitude"),
                                    obj.optString("PinCode")));
                            Marker mar = mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(obj.optString("Latitude")), Double.parseDouble(obj.optString("Longitude")))).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(icon)));
                            markerData.add(mar);
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

                        if (Counter == 1) {
                            garage_list_info.setVisibility(View.VISIBLE);
                            switch_image.setBackgroundResource(R.drawable.locator);
                            no_data_found.setVisibility(View.GONE);
                        }
                        /* Adapter set */
                        adapter = new ClaimMapHospitalListViewAdapter(getActivity(), hospitalList);
                        garage_list_info.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    if (hospitalList != null)
                        hospitalList.clear();
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
}
