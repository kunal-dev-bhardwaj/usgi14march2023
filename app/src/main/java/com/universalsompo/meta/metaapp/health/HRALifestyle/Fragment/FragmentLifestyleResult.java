package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.Model.LifestyleHRAModel;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.NetworkUtility;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Utility.OKHTTPService;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentCouponCode;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentMultipleVendor;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MYSharePrefLifestyleHRA;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.DownloadFileFromURL;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;

import at.grabner.circleprogress.CircleProgressView;

public class FragmentLifestyleResult extends Fragment implements ResponseListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference pref;
    private MYSharePrefLifestyleHRA pref1;
    private LifestyleHRADatabaseHelper db;
    private LifestyleResultDatabaseHelper db1;
    private List<LifestyleHRAModel> reporteduserList;
    private String familyhis = "";
    private String genhis = "";
    private String state, city;
    private GoogleApiClient mGoogleApiClient;
    private double Latitude;
    private double Longitude;
    private Location mLastLocation;
    private Dialog alert_dialog;
    private String wellness_name;
    private String wellness_id;
    private String wellness_url;
    private String PDFURL;
    private CircleProgressView mCircleView;
    private BarChart chart;
    private float random1, random2, random3, random4, random5;
    private String Risk_Summary_Response, Recommended_Lab_test_Response;
    private ProgressDialog mProgressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lifestyle_result, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        pref1 = MYSharePrefLifestyleHRA.getInstance(getActivity());
        db = new LifestyleHRADatabaseHelper(getActivity());
        db1 = new LifestyleResultDatabaseHelper(getActivity());
        init();
        return v;
    }

    private void init() {
        mCircleView = v.findViewById(R.id.circleViewlsresult);
        chart = v.findViewById(R.id.chart);
        LinearLayout book_consultation = v.findViewById(R.id.book_consultation);
        LinearLayout book_lab_test = v.findViewById(R.id.book_lab_test);
        LinearLayout book_wellness_package = v.findViewById(R.id.book_wellness_package);
        LinearLayout finish = v.findViewById(R.id.finish);
        LinearLayout getreport = v.findViewById(R.id.getreport);
        db1.insertbasicSymptomResult(pref.getUID(), pref.getsessionid(), "true");
        buildGoogleApiClient();
        mGoogleApiClient.connect();
        String Score = pref.getWellnessscore();
        StringTokenizer st = new StringTokenizer(Score, ".");
        String first = st.nextToken();
        int wellness = Integer.parseInt(first);
        CustomProgressBar(wellness);

        String random1_st = pref.getLiferandom1();
        String random2_st = pref.getLiferandom2();
        String random3_st = pref.getLiferandom3();
        String random4_st = pref.getLiferandom4();
        String random5_st = pref.getLiferandom5();

        random1 = Float.parseFloat(random1_st);
        random2 = Float.parseFloat(random2_st);
        random3 = Float.parseFloat(random3_st);
        random4 = Float.parseFloat(random4_st);
        random5 = Float.parseFloat(random5_st);
        GraphView();

        book_consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Result page","User clicked on online doctor consultation");
                callApi(RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST);
            }
        });

        book_lab_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Result page","User clicked on lab test");
                callApi(RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST);
            }
        });

        book_wellness_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Result page","User clicked on health packages");
                callApi(RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST);
            }
        });

        getreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Result page","User downloaded his lifestyle HRA report");
                new DownloadFileFromURL(PDFURL, getContext(), "LifestylePDF.pdf").execute();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Result page","User completed his lifestyle HRA");
                pref1.setHitLifestyleAPI("false");
                Objects.requireNonNull(getActivity()).deleteDatabase("lifestyle_hra_db");
                ((MainActivityHealth)getActivity()).changeFragmnet();
            }
        });

        String hit_api = pref1.getHitLifestyleAPI();
        if (hit_api != null) {
            if (hit_api.equalsIgnoreCase("false")) {
                HRASaveRequest();
                new LabTestAsync(getActivity()).execute("");
                new RiskSummaryAsync(getActivity()).execute("");
                pref1.setHitLifestyleAPI("true");
            } else {
                Log.e("API ", "Will not hit");
            }
        } else {
            HRASaveRequest();
            new LabTestAsync(getActivity()).execute("");
            new RiskSummaryAsync(getActivity()).execute("");
            pref1.setHitLifestyleAPI("true");
        }
    }

    private void HRA_SaveUsersHRA() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("InterviewID", pref.getsessionid());
            object.put("IsComplete", true);
            object.put("LastQuestionID", "17");
            object.put("AccountID", pref.getaccid());
            String well_score = pref.getWellnessscore();
            double well_scr = Double.parseDouble(well_score);
            int well_scr1 = (int) well_scr;
            object.put("WellnessScore", well_scr1);
            object.put("HeartRisk", pref.getLifeheartrisk());
            object.put("DiabetesRisk", pref.getLifediabetesrisk());
            object.put("StrokeRisk", pref.getLifestrokerisk());
            object.put("JobStress", pref.getLifejobstress());
            object.put("EmotionalHealth", pref.getLifeemotionalhealth());
            object.put("LabTest", Recommended_Lab_test_Response);
            object.put("RiskSummary", Risk_Summary_Response);
            JSONArray json_data1 = responsebuilder1();
            object.put("HRASaveItem", json_data1);
            int maxLogSize = 1000;
            for(int i = 0; i <= object.toString().length() / maxLogSize; i++) {
                int start = i * maxLogSize;
                int end = (i+1) * maxLogSize;
                end = Math.min(end, object.toString().length());
                Log.v("Request Log : ", object.toString().substring(start, end));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.HRA_SAVE_USERS_HRA, this, RequestHealthConstants.HRA_SAVE_USERS_HRA);
        req.execute();
    }

    private void HRASaveRequest() {
        JSONObject object = new JSONObject();

        try {
            Random ran = new Random();
            String code= String.valueOf((100000 + ran.nextInt(900000)));
            long date = System.currentTimeMillis();
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            String dateString = sdf.format(date);
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("RequestID", code);
            object.put("DateTime", dateString);
            object.put("APIAccessToken", "pYu5y07a6eQ=");
            object.put("AuthTicket", pref.getsessionid());
            object.put("PartnerCode", "ZOIK");
            object.put("ApplicationCode", "AIH_HRA_PORTAL");
            String json_data = responsebuilder();
            object.put("JSONData", json_data);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.HRA_SAVE_RESQUEST, this, RequestHealthConstants.HRA_SAVE_RESQUEST);
        req.execute();
    }

    private void CustomProgressBar(int Value) {
        mCircleView.setMaxValue(100);
        mCircleView.setValue(0);
        mCircleView.setValueAnimated(Value);
        mCircleView.setBarColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red), ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.yellow)
                , ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.green));
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void callApi(Integer id){
        if (id == RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST, this, RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_LAB_TEST_VENDOR_LIST, this, RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST, this, RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST);
            req.execute();
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(Objects.requireNonNull(getActivity()))
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            Latitude = mLastLocation.getLatitude();
            Longitude = mLastLocation.getLongitude();

            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Geocoder geocoder;
                        List<Address> addresses = null;
                        geocoder = new Geocoder(getActivity(), Locale.getDefault());
                        try {
                            addresses = geocoder.getFromLocation(Latitude, Longitude, 1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (addresses != null) {
                            city = addresses.get(0).getLocality();
                            state = addresses.get(0).getAdminArea();
                        }
                    }
                });
            }

        } else {
            Toast.makeText(getActivity(), "Please wait we are getting your location", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


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
    public void onLocationChanged(Location location) {
        mLastLocation = location;
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if(Tag == RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")  || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    showAlertDialog("Doctor Consultation");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }

                        URL url = new URL(wellness_url);
                        String host = url.getHost();
                        Intent intent = new Intent(getActivity(), BookDriver.class);
                        intent.putExtra("title", wellness_name);
                        intent.putExtra("URL", wellness_url);
                        intent.putExtra("domain", host);
                        intent.putExtra("name", wellness_name);
                        intent.putExtra("VendorId", wellness_id);
                        intent.putExtra("VehicleType", "Doctor Consultation");
                        startActivity(intent);
                    } catch (JSONException | MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_DOCTOR_APPOINTMENT_HISTORY, "Doctor Consultation");
                }
            }
        } else if(Tag == RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")  || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    showAlertDialog("Lab Test");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }

                        if (wellness_name.equalsIgnoreCase("1mg")) {
                            replaceFragment2(new FragmentCouponCode(), wellness_id);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_LAB_TESTS_HISTORY, "Lab Test");
                }
            }
        } else if(Tag == RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")  || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    showAlertDialog("Wellness Packages");
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }

                        URL url = new URL(wellness_url);
                        String host = url.getHost();
                        Intent intent = new Intent(getActivity(), BookDriver.class);
                        intent.putExtra("title", wellness_name);
                        intent.putExtra("URL", wellness_url);
                        intent.putExtra("domain", host);
                        intent.putExtra("name", wellness_name);
                        intent.putExtra("VendorId", wellness_id);
                        intent.putExtra("VehicleType", "Health Packages");
                        startActivity(intent);
                    } catch (JSONException | MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    replaceFragment1(new FragmentMultipleVendor(), FragmentsHealthTags.FRAGMENT_HEALTH_PACKAGES_HISTORY, "Health Packages");
                }
            }
        } else if (Tag == RequestHealthConstants.HRA_SAVE_RESQUEST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                System.out.println("Saved request successfully");
            } else {
                System.out.println("Not saved");
            }
        } else if (Tag == RequestHealthConstants.HRA_SAVE_USERS_HRA) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                try {
                    PDFURL = object.getString("PDFURL");
                    Objects.requireNonNull(getActivity()).deleteDatabase("lifestyle_hra_db");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Not saved");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    @SuppressLint("SetTextI18n")
    private void showAlertDialog(String head) {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("No vendor found at your current location.");
        alert_heading.setText(head);

        alert_dialog.show();
        ok_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog.dismiss();
            }
        });
    }

    private void replaceFragment1(Fragment frag, String Tag, String type) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("type", type);
            args.putString("state", state);
            args.putString("city", city);
            args.putString("id", "0");
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void replaceFragment2(Fragment frag, String id) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("id", id);
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_COUPON_CODE);
            binder.detect(FragmentsHealthTags.FRAGMENT_COUPON_CODE);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void GraphView() {
        BarDataSet set1 = new BarDataSet(getDataSet(), "The year 2017");
        set1.setColors(Color.parseColor("#F78B5D"), Color.parseColor("#FCB232"), Color.parseColor("#FDD930"), Color.parseColor("#ADD137"), Color.parseColor("#A0C25A"));
        set1.setDrawValues(false);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        // hide Y-axis
        YAxis right = chart.getAxisRight();
        YAxis left = chart.getAxisLeft();
        left.setDrawLabels(false);
        right.setDrawLabels(false);
        left.setDrawGridLines(false);
        right.setDrawGridLines(false);
        XAxis xright = chart.getXAxis();
        xright.setDrawLabels(false);
        xright.setDrawGridLines(false);
        chart.getAxisRight().setEnabled(false);
        xright.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.setData(data);
        chart.setTouchEnabled(false);
        Description description = new Description();
        description.setText("");
        chart.setDescription(description);
        chart.getLegend().setEnabled(false);
        chart.animateY(1000);
        chart.invalidate();
    }

    private ArrayList<BarEntry> getDataSet() {
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e2 = new BarEntry(1, random1);
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(2, random2);
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(3, random3);
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(4, random4);
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(5, random5);
        valueSet1.add(v1e6);
        return valueSet1;
    }

    private String responsebuilder() {
        double height = Double.parseDouble(db.getLifestyleCol3Value(pref.getUID(), "FragmentBMI"));
        @SuppressLint("DefaultLocale") String height_d = String.format("%.2f", height);
        String weight = db.getLifestyleCol4Value(pref.getUID(), "FragmentBMI");
        double bmi = Double.parseDouble(db.getLifestyleCol5Value(pref.getUID(), "FragmentBMI"));
        @SuppressLint("DefaultLocale") String bmi_d = String.format("%.2f", bmi);
        String waist = db.getLifestyleCol1Value(pref.getUID(), "FragmentWHR");
        String hip = db.getLifestyleCol2Value(pref.getUID(), "FragmentWHR");
        boolean savewhr = !waist.equalsIgnoreCase("0") || !hip.equalsIgnoreCase("0");
        String sys = db.getLifestyleCol1Value(pref.getUID(), "FragmentBP");
        String dia = db.getLifestyleCol2Value(pref.getUID(), "FragmentBP");
        String save_sys;
        if (sys.equalsIgnoreCase("0")) {
            save_sys = "";
        } else {
            save_sys = sys;
        }

        String save_dia;
        if (dia.equalsIgnoreCase("0")) {
            save_dia = "";
        } else {
            save_dia = dia;
        }

        boolean savebp = !sys.equalsIgnoreCase("0") || !dia.equalsIgnoreCase("0");

        JSONObject vitals_Obj = new JSONObject();
        try {
            vitals_Obj.put("R", "SETVITALS");
            vitals_Obj.put("Height", height_d);
            vitals_Obj.put("Weight", weight);
            vitals_Obj.put("BMI", bmi_d);
            vitals_Obj.put("SystolicBP", save_sys);
            vitals_Obj.put("DiastolicBP", save_dia);
            vitals_Obj.put("SaveBMI", true);
            vitals_Obj.put("SaveWHR", savewhr);
            vitals_Obj.put("SaveBP", savebp);
            vitals_Obj.put("Mode", "SAVE");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /* Blood Pressure */
        String bp_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentBP");
        String bp_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentBP");
        String bp_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentBP");

        String user_bp = bp_ans_code + "," + bp_ques_code + "," + "0" + "," + bp_cat + "|";

        /* Alcohol */
        String alc_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentAlcohol");
        String alc_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentAlcohol");
        String alc_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentAlcohol");

        String user_alcohol = alc_ans_code + "," + alc_ques_code + "," + "0" + "," + alc_cat + "|";

        /* Cigarettes */
        String cig_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentCigarettes");
        String cig_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentCigarettes");
        String cig_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentCigarettes");

        String user_cig = cig_ans_code + "," + cig_ques_code + "," + "0" + "," + cig_cat + "|";

        /* Family Health */
        List<LifestyleHRAModel> reportedfamilyList = new ArrayList<>();
        reportedfamilyList.addAll(db.getAllFamilyHist(pref.getUID(), pref.getsessionid(), "FragmentFamilyHealth"));
        for (LifestyleHRAModel cn : reportedfamilyList) {
            if (cn.getYesno().equalsIgnoreCase("yes") && !cn.getCol1().equalsIgnoreCase("Other")) {
                familyhis = familyhis + cn.getAnswercode() + "," + cn.getQuestioncode() + "," + "0" + "," + cn.getCategory() + "|";
            }
        }

        /* User Disease */
        reporteduserList = new ArrayList<>();
        reporteduserList.addAll(db.getAllUserHist(pref.getUID(), pref.getsessionid(), "FragmentGeneralHealth"));
        for (LifestyleHRAModel cn : reporteduserList) {
            if (cn.getYesno().equalsIgnoreCase("yes")) {
                genhis = genhis + cn.getAnswercode() + "," + cn.getQuestioncode() + "," + "0" + "," + cn.getCategory() + "|";
                System.out.println("Forward array" + familyhis);
            }
        }


        /* Fruits */
        String fruit_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentFruitServing");
        String fruit_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentFruitServing");
        String fruit_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentFruitServing");

        String user_fruits = fruit_ans_code + "," + fruit_ques_code + "," + "0" + "," + fruit_cat + "|";

        /* Fried */
        String fried_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentFriedFood");
        String fried_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentFriedFood");
        String fried_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentFriedFood");

        String user_fried = fried_ans_code + "," + fried_ques_code + "," + "0" + "," + fried_cat + "|";

        /* Work Balance */
        String work_bal_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentWorkBalance");
        String work_bal_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorkBalance");
        String work_bal_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorkBalance");

        String user_work_bal = work_bal_ans_code + "," + work_bal_ques_code + "," + "0" + "," + work_bal_cat + "|";

        /* Job Offering */
        String job_offer_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentWorking");
        String job_offer_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorking");
        String job_offer_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorking");

        String user_job_offer = job_offer_ans_code + "," + job_offer_ques_code + "," + "0" + "," + job_offer_cat + "|";

        /* Laptop */
        String lap_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentLaptopWorking");
        String lap_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentLaptopWorking");
        String lap_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentLaptopWorking");

        String user_laptop = lap_ans_code + "," + lap_ques_code + "," + "0" + "," + lap_cat + "|";

        /* Work Shifts */
        String work_shift_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentWorkShift");
        String work_shift_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorkShift");
        String work_shift_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorkShift");

        String user_work_shift = work_shift_ans_code + "," + work_shift_ques_code + "," + "0" + "," + work_shift_cat + "|";

        /* Exercise */
        String exe_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentExercise");
        String exe_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentExercise");
        String exe_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentExercise");

        String user_exercise = exe_ans_code + "," + exe_ques_code + "," + "0" + "," + exe_cat + "|";

        /* Sound Sleep */
        String sleep_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentSleep");
        String sleep_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentSleep");
        String sleep_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSleep");

        String user_sleep = sleep_ans_code + "," + sleep_ques_code + "," + "0" + "," + sleep_cat + "|";

        /* User Life */
        String life_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentUserLife");
        String life_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentUserLife");
        String life_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentUserLife");

        String user_life = life_ans_code + "," + life_ques_code + "," + "0" + "," + life_cat + "|";

        /* Stress */
        String stress_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentStress");
        String stress_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentStress");
        String stress_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentStress");

        String user_stress = stress_ans_code + "," + stress_ques_code + "," + "0" + "," + stress_cat + "|";

        /* Social Ties */
        String social_cat = db.getLifestyleCategoryValue(pref.getUID(), "FragmentSocialLife");
        String social_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentSocialLife");
        String social_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSocialLife");

        String user_social = social_ans_code + "," + social_ques_code + "," + "0" + "," + social_cat + "|";

        String gen_health = user_bp + user_alcohol + user_cig + genhis + user_fruits + user_fried + user_work_bal + user_job_offer + user_laptop + user_work_shift + user_exercise + user_sleep + user_life + user_stress + user_social;


        JSONObject hra_resp_Obj = new JSONObject();
        try {
            hra_resp_Obj.put("VITALS", vitals_Obj);
            hra_resp_Obj.put("SETGENHEALTH", gen_health);
            hra_resp_Obj.put("SETFAMILYHIST", familyhis);
            hra_resp_Obj.put("PERSONID", pref.getpersonid());
            hra_resp_Obj.put("TEMPLATEID", pref.gettempid());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject hra_resp_main_Obj = new JSONObject();
        try {
            hra_resp_main_Obj.put("HRARESPONSE", hra_resp_Obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /* Lab Records */
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String fullDate = sdf.format(cal.getTime());

        JSONObject chol_total_json = null, chol_hdl_json = null, chol_ldl_json = null, chol_trig_json = null, diab_fast_json = null, diab_pp_json = null;

        String chol_total = db.getLifestyleCol4Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_total.equalsIgnoreCase("0")) {
            chol_total_json = new JSONObject();
            try {
                chol_total_json.put("ParameterCode", "CHOL_TOTAL");
                chol_total_json.put("RecordDate", fullDate);
                chol_total_json.put("Value", chol_total);
                chol_total_json.put("PersonID", pref.getpersonid());
                chol_total_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String chol_hdl = db.getLifestyleCol2Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_hdl.equalsIgnoreCase("0")) {
            chol_hdl_json = new JSONObject();
            try {
                chol_hdl_json.put("ParameterCode", "CHOL_HDL");
                chol_hdl_json.put("RecordDate", fullDate);
                chol_hdl_json.put("Value", chol_hdl);
                chol_hdl_json.put("PersonID", pref.getpersonid());
                chol_hdl_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String chol_ldl = db.getLifestyleCol1Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_ldl.equalsIgnoreCase("0")) {
            chol_ldl_json = new JSONObject();
            try {
                chol_ldl_json.put("ParameterCode", "CHOL_LDL");
                chol_ldl_json.put("RecordDate", fullDate);
                chol_ldl_json.put("Value", chol_ldl);
                chol_ldl_json.put("PersonID", pref.getpersonid());
                chol_ldl_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String chol_trig = db.getLifestyleCol3Value(pref.getUID(), "FragmentCholestrol");
        if (!chol_trig.equalsIgnoreCase("0")) {
            chol_trig_json = new JSONObject();
            try {
                chol_trig_json.put("ParameterCode", "CHOL_TRY");
                chol_trig_json.put("RecordDate", fullDate);
                chol_trig_json.put("Value", chol_trig);
                chol_trig_json.put("PersonID", pref.getpersonid());
                chol_trig_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String diab_fast = db.getLifestyleCol1Value(pref.getUID(), "FragmentBloodSugar");
        if (!diab_fast.equalsIgnoreCase("0")) {
            diab_fast_json = new JSONObject();
            try {
                diab_fast_json.put("ParameterCode", "DIAB_FS");
                diab_fast_json.put("RecordDate", fullDate);
                diab_fast_json.put("Value", diab_fast);
                diab_fast_json.put("PersonID", pref.getpersonid());
                diab_fast_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String diab_pp = db.getLifestyleCol2Value(pref.getUID(), "FragmentBloodSugar");
        if (!diab_pp.equalsIgnoreCase("0")) {
            diab_pp_json = new JSONObject();
            try {
                diab_pp_json.put("ParameterCode", "DIAB_PM");
                diab_pp_json.put("RecordDate", fullDate);
                diab_pp_json.put("Value", diab_pp);
                diab_pp_json.put("PersonID", pref.getpersonid());
                diab_pp_json.put("Unit", "mg/dL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        JSONArray jsonArraylab = new JSONArray();
        if (!chol_total.equalsIgnoreCase("0") && !diab_fast.equalsIgnoreCase("0")) {
            jsonArraylab.put(chol_total_json);
            jsonArraylab.put(chol_hdl_json);
            jsonArraylab.put(chol_ldl_json);
            jsonArraylab.put(chol_trig_json);
            jsonArraylab.put(diab_fast_json);
            jsonArraylab.put(diab_pp_json);
        } else if (chol_total.equalsIgnoreCase("0") && !diab_fast.equalsIgnoreCase("0")) {
            jsonArraylab.put(diab_fast_json);
            jsonArraylab.put(diab_pp_json);
        } else if (!chol_total.equalsIgnoreCase("0") && diab_fast.equalsIgnoreCase("0")) {
            jsonArraylab.put(chol_total_json);
            jsonArraylab.put(chol_hdl_json);
            jsonArraylab.put(chol_ldl_json);
            jsonArraylab.put(chol_trig_json);
        }

        JSONObject hra_resp_main1_Obj = new JSONObject();
        try {
            hra_resp_main1_Obj.put("HraResponse", hra_resp_main_Obj);
            hra_resp_main1_Obj.put("LabRecords", jsonArraylab); // LabRecords array
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return hra_resp_main1_Obj.toString();
    }

    private JSONArray responsebuilder1() {
        JSONObject bp_json, alc_json, cig_json, fruit_json, fried_json, work_bal_json, job_offer_json, lap_json, work_shift_json, exe_json, sleep_json, life_json, stress_json, social_json, other_json;
        JSONArray jsonArraydata = new JSONArray();

        /* Blood Pressure */
        String bp_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentBP");
        String bp_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentBP");
        String bp_ques_id = db.getLifestyleQuestionIDValue(pref.getUID(), "FragmentBP");
        bp_json = new JSONObject();
        try {
            bp_json.put("QuestionCode", bp_ques_code);
            bp_json.put("QuestionID", bp_ques_id);
            bp_json.put("OptionCode", bp_ans_code);
            bp_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(bp_json);

        /* Alcohol */
        String alc_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentAlcohol");
        String alc_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentAlcohol");

        alc_json = new JSONObject();
        try {
            alc_json.put("QuestionCode", alc_ques_code);
            alc_json.put("QuestionID", "3");
            alc_json.put("OptionCode", alc_ans_code);
            alc_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(alc_json);

        /* Cigarettes */
        String cig_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentCigarettes");
        String cig_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentCigarettes");

        cig_json = new JSONObject();
        try {
            cig_json.put("QuestionCode", cig_ques_code);
            cig_json.put("QuestionID", "6");
            cig_json.put("OptionCode", cig_ans_code);
            cig_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(cig_json);

        /* Family Health */
        List<LifestyleHRAModel> reportedfamilyList1 = new ArrayList<>();
        reportedfamilyList1.addAll(db.getAllFamilyHist(pref.getUID(), pref.getsessionid(), "FragmentFamilyHealth"));
        for (LifestyleHRAModel cn : reportedfamilyList1) {
            JSONObject famhis = new JSONObject();
            if (cn.getYesno().equalsIgnoreCase("yes") && !cn.getCol1().equalsIgnoreCase("Other")) {
                try {
                    famhis.put("QuestionCode", cn.getQuestioncode());
                    famhis.put("QuestionID", "9");
                    famhis.put("OptionCode", cn.getAnswercode());
                    famhis.put("OtherOptionText", cn.getAnswerother());
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                jsonArraydata.put(famhis);
            }
        }

        String yes_no_other = db.getLifestyleYesNoValue(pref.getUID(), "Other", "FragmentFamilyHealth");
        if (yes_no_other != null && yes_no_other.equalsIgnoreCase("yes")) {
            String ans_other = db.getLifestyleAnsOtherValue(pref.getUID(), "FragmentFamilyHealth");

            other_json = new JSONObject();
            try {
                other_json.put("QuestionCode", "FHIST");
                other_json.put("QuestionID", "9");
                other_json.put("OptionCode", "1_FAMOTHER");
                other_json.put("OtherOptionText", ans_other);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArraydata.put(other_json);
        }

        /* General Health */
        List<LifestyleHRAModel> reporteduserList1 = new ArrayList<>();
        reporteduserList1.addAll(db.getAllUserHist(pref.getUID(), pref.getsessionid(), "FragmentGeneralHealth"));
        for (LifestyleHRAModel cn : reporteduserList) {
            JSONObject userhis = new JSONObject();
            if (cn.getYesno().equalsIgnoreCase("yes")) {
                try {
                    userhis.put("QuestionCode", cn.getQuestioncode());
                    userhis.put("QuestionID", "10");
                    userhis.put("OptionCode", cn.getAnswercode());
                    if (cn.getAnswerother() != null) {
                        userhis.put("OtherOptionText", cn.getAnswerother());
                    } else {
                        userhis.put("OtherOptionText", "");
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                jsonArraydata.put(userhis);
            }
        }

        /* Fruits */
        String fruit_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentFruitServing");
        String fruit_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentFruitServing");

        fruit_json = new JSONObject();
        try {
            fruit_json.put("QuestionCode", fruit_ques_code);
            fruit_json.put("QuestionID", "28");
            fruit_json.put("OptionCode", fruit_ans_code);
            fruit_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(fruit_json);

        /* Fried */
        String fried_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentFriedFood");
        String fried_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentFriedFood");

        fried_json = new JSONObject();
        try {
            fried_json.put("QuestionCode", fried_ques_code);
            fried_json.put("QuestionID", "29");
            fried_json.put("OptionCode", fried_ans_code);
            fried_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(fried_json);

        /* Work Balance */
        String work_bal_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorkBalance");
        String work_bal_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorkBalance");

        work_bal_json = new JSONObject();
        try {
            work_bal_json.put("QuestionCode", work_bal_ques_code);
            work_bal_json.put("QuestionID", "30");
            work_bal_json.put("OptionCode", work_bal_ans_code);
            work_bal_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(work_bal_json);

        /* Job Offering */
        String job_offer_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorking");
        String job_offer_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorking");

        job_offer_json = new JSONObject();
        try {
            job_offer_json.put("QuestionCode", job_offer_ques_code);
            job_offer_json.put("QuestionID", "31");
            job_offer_json.put("OptionCode", job_offer_ans_code);
            job_offer_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(job_offer_json);

        /* Laptop */
        String lap_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentLaptopWorking");
        String lap_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentLaptopWorking");

        lap_json = new JSONObject();
        try {
            lap_json.put("QuestionCode", lap_ques_code);
            lap_json.put("QuestionID", "33");
            lap_json.put("OptionCode", lap_ans_code);
            lap_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(lap_json);

        /* Work Shifts */
        String work_shift_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentWorkShift");
        String work_shift_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentWorkShift");

        work_shift_json = new JSONObject();
        try {
            work_shift_json.put("QuestionCode", work_shift_ques_code);
            work_shift_json.put("QuestionID", "34");
            work_shift_json.put("OptionCode", work_shift_ans_code);
            work_shift_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(work_shift_json);

        /* Exercise */
        String exe_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentExercise");
        String exe_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentExercise");

        exe_json = new JSONObject();
        try {
            exe_json.put("QuestionCode", exe_ques_code);
            exe_json.put("QuestionID", "37");
            exe_json.put("OptionCode", exe_ans_code);
            exe_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(exe_json);

        /* Sound Sleep */
        String sleep_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentSleep");
        String sleep_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSleep");

        sleep_json = new JSONObject();
        try {
            sleep_json.put("QuestionCode", sleep_ques_code);
            sleep_json.put("QuestionID", "38");
            sleep_json.put("OptionCode", sleep_ans_code);
            sleep_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(sleep_json);

        /* User Life */
        String life_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentUserLife");
        String life_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentUserLife");

        life_json = new JSONObject();
        try {
            life_json.put("QuestionCode", life_ques_code);
            life_json.put("QuestionID", "40");
            life_json.put("OptionCode", life_ans_code);
            life_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(life_json);

        /* Stress */
        String stress_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentStress");
        String stress_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentStress");

        stress_json = new JSONObject();
        try {
            stress_json.put("QuestionCode", stress_ques_code);
            stress_json.put("QuestionID", "42");
            stress_json.put("OptionCode", stress_ans_code);
            stress_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(stress_json);

        /* Social Ties */
        String social_ques_code = db.getLifestyleQuestionCodeValue(pref.getUID(), "FragmentSocialLife");
        String social_ans_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSocialLife");

        social_json = new JSONObject();
        try {
            social_json.put("QuestionCode", social_ques_code);
            social_json.put("QuestionID", "43");
            social_json.put("OptionCode", social_ans_code);
            social_json.put("OtherOptionText", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArraydata.put(social_json);

        return jsonArraydata;
    }

    class RiskSummaryAsync extends AsyncTask<String, String, HashMap<String, String>> {
        Activity mContext;

        public RiskSummaryAsync(Activity contex) {
            this.mContext = contex;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (NetworkUtility.isOnline(mContext)) {
                mProgressDialog = new ProgressDialog(mContext);
                mProgressDialog.setMessage("Loading...");
                mProgressDialog.setCancelable(false);
                mProgressDialog.setCanceledOnTouchOutside(false);
                mProgressDialog.show();
            } else {
                Toast.makeText(mContext, "Not connected to Internet", Toast.LENGTH_SHORT).show();
                cancel(true);
            }
        }

        @Override
        protected HashMap<String, String> doInBackground(String... params) {
            HashMap<String, String> hashMap=null;
            if (!isCancelled()) {
                try {
                    pref = MySharedPreference.getInstance(mContext);
                    String strUrl ="https://core.allizhealthtest.in/PHR/api/MedicalProfile/ListRiskSummary";
                    JSONObject header = new JSONObject();
                    try{
                        Random ran = new Random();
                        String code= String.valueOf((100000 + ran.nextInt(900000)));
                        long date = System.currentTimeMillis();
                        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                        String dateString = sdf.format(date);
                        header.put("RequestID", code);
                        header.put("DateTime", dateString);
                        header.put("APIAccessToken", "pYu5y07a6eQ=");
                        header.put("AuthTicket", pref.getsessionid());
                        header.put("ApplicationCode", "AIH_HRA_PORTAL");
                        header.put("PartnerCode", "ZOIK");
                        header.put("EntityType", "P");
                    } catch (JSONException e){
                        e.printStackTrace();
                    }

                    JSONObject JSONData = new JSONObject();
                    try{
                        JSONData.put("PersonID", pref.getpersonid());
                    } catch (JSONException e){
                        e.printStackTrace();
                    }

                    JSONObject request = new JSONObject();
                    try {
                        request.put("Header", header);
                        request.put("JSONData", JSONData.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    final String requestStr = request.toString();
                    hashMap = OKHTTPService.requestACallToServer(strUrl,requestStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }

        protected void onPostExecute(HashMap<String, String> resultMap) {
            super.onPostExecute(resultMap);
            try {
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                if(resultMap!=null && resultMap.size()>0){
                    JSONObject json_response = new JSONObject(resultMap.get(OKHTTPService.mStrResponseJson));
                    System.out.println(json_response);
                    String json_str = json_response.getString("JSONData");
                    json_str = json_str.replaceAll("\\r\\n", "");
                    Risk_Summary_Response = json_str;

                    HRA_SaveUsersHRA();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class LabTestAsync extends AsyncTask<String, String, HashMap<String, String>> {
        Activity mContext;

        public LabTestAsync(Activity contex) {
            this.mContext = contex;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (NetworkUtility.isOnline(mContext)) {
            } else {
                Toast.makeText(mContext, "Not connected to Internet", Toast.LENGTH_SHORT).show();
                cancel(true);
            }
        }

        @Override
        protected HashMap<String, String> doInBackground(String... params) {
            HashMap<String, String> hashMap=null;
            if (!isCancelled()) {
                try {
                    pref = MySharedPreference.getInstance(mContext);
                    String strUrl ="https://core.allizhealthtest.in/PHR/api/MedicalProfile/ListRecommendedTests";
                    JSONObject header = new JSONObject();
                    try{
                        Random ran = new Random();
                        String code= String.valueOf((100000 + ran.nextInt(900000)));
                        long date = System.currentTimeMillis();
                        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                        String dateString = sdf.format(date);
                        header.put("RequestID", code);
                        header.put("DateTime", dateString);
                        header.put("APIAccessToken", "pYu5y07a6eQ=");
                        header.put("AuthTicket", pref.getsessionid());
                        header.put("ApplicationCode", "AIH_HRA_PORTAL");
                        header.put("PartnerCode", "ZOIK");
                        header.put("EntityType", "P");
                    } catch (JSONException e){
                        e.printStackTrace();
                    }

                    JSONObject JSONData = new JSONObject();
                    try{
                        JSONData.put("PersonID", pref.getpersonid());
                    } catch (JSONException e){
                        e.printStackTrace();
                    }

                    JSONObject request = new JSONObject();
                    try {
                        request.put("Header", header);
                        request.put("JSONData", JSONData.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    final String requestStr = request.toString();
                    hashMap = OKHTTPService.requestACallToServer(strUrl,requestStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }

        @Override
        protected void onPostExecute(HashMap<String, String> resultMap) {
            super.onPostExecute(resultMap);
            try {
                if(resultMap!=null && resultMap.size()>0){
                    JSONObject json_response = new JSONObject(resultMap.get(OKHTTPService.mStrResponseJson));
                    System.out.println(json_response);
                    String json_str = json_response.getString("JSONData");
                    json_str = json_str.replaceAll("\\r\\n", "");
                    Recommended_Lab_test_Response = json_str;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
