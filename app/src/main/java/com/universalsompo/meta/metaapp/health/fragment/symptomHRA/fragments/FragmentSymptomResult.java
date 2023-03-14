package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRA.adapter.ResultAdapter;
import com.universalsompo.meta.metaapp.health.HRA.models.Result_getter_setter;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentCouponCode;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentMultipleVendor;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ConditionsDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.Conditions;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.Triage;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.TriageDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.ResultTriage_getter_setter;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.DownloadFileFromURL;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FragmentSymptomResult extends Fragment implements ResponseListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    private BasicQuesDatabaseHelper db;
    private ConditionsDatabaseHelper db1;
    private TriageDatabaseHelper db2;
    private ResultDatabaseHelper db3;
    private String state, city;
    private GoogleApiClient mGoogleApiClient;
    private double Latitude;
    private double Longitude;
    private Location mLastLocation;
    private Dialog alert_dialog;
    private String wellness_name;
    private String wellness_id;
    private String wellness_url;
    private ListView result_list, result_list1, result_list2, result_list3, result_list4;
    private ResultAdapter mAdapter2;
    private List<Result_getter_setter> symptomList1;
    private List<ResultTriage_getter_setter> triageList1;
    private TextView triage_level,description;
    private JSONArray reportedsymptomjsonArray;
    private JSONArray triagesymptomjsonArray;
    private JSONArray conditionsymptomjsonArray;
    private CustomProgressDialog customprogress;
    private String triage_level1;
    private String PDFURL;
    private ImageView image;
    private boolean shouldHitApi;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_symptom_result_page, container,false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        prefrences = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        db1 = new ConditionsDatabaseHelper(getActivity());
        db2 = new TriageDatabaseHelper(getActivity());
        db3 = new ResultDatabaseHelper(getActivity());
        customprogress = new CustomProgressDialog(getActivity());
        init();
        return v;
    }

    private void init() {
        result_list = v.findViewById(R.id.result_list);
        result_list1 = v.findViewById(R.id.result_list1);
        result_list2 = v.findViewById(R.id.result_list2);
        result_list3 = v.findViewById(R.id.result_list3);
        result_list4 = v.findViewById(R.id.result_list4);
        LinearLayout book_consultation = v.findViewById(R.id.book_consultation);
        LinearLayout book_lab_test = v.findViewById(R.id.book_lab_test);
        LinearLayout book_wellness_package = v.findViewById(R.id.book_wellness_package);
        Button finish = v.findViewById(R.id.finish);
        Button getreport = v.findViewById(R.id.getreport);
        triage_level = v.findViewById(R.id.triage_level);
        description = v.findViewById(R.id.description);
        LinearLayout show_symptoms = v.findViewById(R.id.show_symptoms);
        image = v.findViewById(R.id.image);
        db3.insertbasicSymptomResult(prefrences.getUID(), prefrences.getSymptominterviewid(), "true");
        buildGoogleApiClient();
        mGoogleApiClient.connect();

        book_consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Result page","User clicked on online doctor consultation");
                callApi(RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST);
            }
        });

        book_lab_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Result page","User clicked on lab test");
                callApi(RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST);
            }
        });

        book_wellness_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Result page","User clicked on health packages");
                callApi(RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST);
            }
        });

        show_symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Result page","User seen his selected symptom");
                replaceFragment(new FragmentShowSelectedSymptom());
            }
        });

        getreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Result page","User downloaded his symptom HRA report");
                new DownloadFileFromURL(PDFURL, getContext(), "SymptomPDF.pdf").execute();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Result page","User completed his symptom HRA");
                Objects.requireNonNull(getActivity()).deleteDatabase("basic_symptom_added_db");
                getActivity().deleteDatabase("condition_added_db");
                getActivity().deleteDatabase("triage_added_db");
                ((MainActivityHealth)getActivity()).changeFragmnet();
            }
        });

        responsebuilder();
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
            shouldHitApi = false;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    public void responsebuilder(){
        List<BasicQuestion> symptomList = new ArrayList<>();
        symptomList.addAll(db.getAllBasicSymptom(prefrences.getSymptominterviewid()));
        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : symptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("choice_id", cn.getbasicChoiceid().toLowerCase());
                if(cn.getbasicInit().equalsIgnoreCase("true")){
                    symp.put("initial", cn.getbasicInit());
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("sex", prefrences.getgender().toLowerCase());
            sympObj.put("age", Integer.parseInt(prefrences.getAge()));
            sympObj.put("evidence", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = sympObj.toString();
        System.out.println("jsonString: " + jsonStr);
        getResult(jsonStr);
        getTriage(jsonStr);
        responsebuilderReported();
    }

    private void responsebuilderTriage() {
        List<Triage> reportedtriageList = new ArrayList<>();
        reportedtriageList.addAll(db2.getAllTriage(prefrences.getSymptominterviewid()));
        triagesymptomjsonArray = new JSONArray();
        for (Triage cn : reportedtriageList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("TriageSymptom", cn.getTriagename());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            triagesymptomjsonArray.put(symp);
            System.out.println("Triage array" + triagesymptomjsonArray);
        }
    }

    private void responsebuilderCondition() {
        List<Conditions> reportedconditionList = new ArrayList<>();
        reportedconditionList.addAll(db1.getAllConditions(prefrences.getSymptominterviewid()));
        conditionsymptomjsonArray = new JSONArray();
        for (Conditions cn : reportedconditionList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("Condition", cn.getConditioncommonname());
                symp.put("Likelihood", cn.getConditionprobability());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conditionsymptomjsonArray.put(symp);
            System.out.println("Condition array" + conditionsymptomjsonArray);
        }
    }

    private void responsebuilderReported() {
        List<BasicQuestion> reportedsymptomList = new ArrayList<>();
        reportedsymptomList.addAll(db.getAllBasicSymptom(prefrences.getSymptominterviewid()));
        reportedsymptomjsonArray = new JSONArray();
        for (BasicQuestion cn : reportedsymptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("SymptomName", cn.getbasicName());
                symp.put("SymptomChoice", cn.getbasicChoiceid().toLowerCase());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            reportedsymptomjsonArray.put(symp);
            System.out.println("Reported Symptom array" + reportedsymptomjsonArray);
        }
    }

    private void callApi(Integer id){
        if (id == RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
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
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
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
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST, this, RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.SAVE_SYMPTOM_DATA_PDF) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("UserID", prefrences.getUID());
                object.put("TriageLevel", triage_level1);
                object.put("PDFSymptomReportList", reportedsymptomjsonArray);
                object.put("PDFTriageSymptomList", triagesymptomjsonArray);
                object.put("PDFSymptomPossibleCausesList", conditionsymptomjsonArray);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_SYMPTOM_DATA_PDF, this, RequestHealthConstants.SAVE_SYMPTOM_DATA_PDF);
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
        } else if (Tag == RequestHealthConstants.SAVE_SYMPTOM_DATA_PDF) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                try {
                    PDFURL = object.getString("PDFURL");
                    shouldHitApi = true;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

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

    private void getTriage(String s4){
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, s4);
        Request request = new Request.Builder()
                .url("https://api.infermedica.com/v2/triage")
                .post(body)
                .addHeader("app-id", "4eb1d3a2")
                .addHeader("app-key", "0032394801c5c304ddc208f9761b46ff")
                .addHeader("content-type", "application/json")
                .addHeader("Model", "infermedica-en")
                .addHeader("Interview-Id", prefrences.getSymptominterviewid())
                .addHeader("User-Id", prefrences.getUID())
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "147a3cd6-506b-20d1-3a7e-38d7c65e1352")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                String mMessage = e.getMessage();
                Log.w("failure Response", mMessage);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String mMessage = Objects.requireNonNull(response.body()).string();
                Log.d("Response", mMessage);
                if (response.isSuccessful()) {
                    try {
                        JSONObject jobj = new JSONObject(mMessage);
                        triage_level1 = jobj.getString("triage_level");
                        triageList1 = new ArrayList<>();
                        JSONArray jobj1 = jobj.getJSONArray("serious");
                        for(int i=0; i < jobj1.length(); i++){
                            JSONObject c = jobj1.getJSONObject(i);
                            triageList1.add(
                                    new ResultTriage_getter_setter(c.getString("id"),c.getString("name"),c.getString("common_name"))
                            );
                            db2.insertTriage(prefrences.getUID(), prefrences.getUserName(), prefrences.getSymptominterviewid(), c.getString("id"), c.getString("name"), c.getString("common_name"));
                        }

                        Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void run() {
                                if(triage_level1.equalsIgnoreCase("emergency")){
                                    image.setImageResource(R.drawable.emergency_service);
                                    triage_level.setText("Immediate medical attention recommended");
                                    description.setText("Immediate contact with a medical professional or emergency services is advised.");
                                    triage_level.setTextColor(ContextCompat.getColor(getActivity(), R.color.red));
                                } else if(triage_level1.equalsIgnoreCase("consultation")){
                                    image.setImageResource(R.drawable.stethoscope_icon);
                                    triage_level.setText("Prompt medical attention recommended");
                                    description.setText("Consulting a medical professional soon is advised.");
                                    triage_level.setTextColor(ContextCompat.getColor(getActivity(), R.color.almondz_policy));
                                } else {
                                    image.setImageResource(R.drawable.person_resting_time);
                                    triage_level.setText("May Require Medical Attention");
                                    description.setText("Symptoms you have reported are rarely sign of a severe condition. However, if you are concerned about your health or your symptoms persist or worsen, we advise to contact a medical professional.");
                                    triage_level.setTextColor(ContextCompat.getColor(getActivity(), R.color.green));
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void getResult(String s3){
        customprogress.showProgressBar();
        final OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, s3);
        Request request = new Request.Builder()
                .url("https://api.infermedica.com/v2/diagnosis")
                .post(body)
                .addHeader("app-id", "4eb1d3a2")
                .addHeader("app-key", "0032394801c5c304ddc208f9761b46ff")
                .addHeader("content-type", "application/json")
                .addHeader("Model", "infermedica-en")
                .addHeader("Interview-Id", prefrences.getSymptominterviewid())
                .addHeader("User-Id", prefrences.getUID())
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "b81ebff0-e92d-f259-81d6-d090f6858158")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                String mMessage = e.getMessage();
                Log.w("failure Response", mMessage);
                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        customprogress.hideProgressBar();
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String mMessage = Objects.requireNonNull(response.body()).string();
                Log.d("Response" , mMessage);
                if (response.isSuccessful()){
                    symptomList1 = new ArrayList<>();
                    try {
                        JSONObject jobj = new JSONObject(mMessage);
                        JSONArray jobj1 = jobj.getJSONArray("conditions");
                        for(int i=0; i < jobj1.length(); i++){
                            JSONObject c = jobj1.getJSONObject(i);
                            symptomList1.add(
                                    new Result_getter_setter(c.getString("id"),c.getString("name"),c.getString("common_name"),c.getString("probability"))
                            );
                            db1.insertConditions(prefrences.getUID(), prefrences.getUserName(), prefrences.getSymptominterviewid(), c.getString("id"), c.getString("name"), c.getString("common_name"), c.getString("probability"));
                        }

                        Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                customprogress.hideProgressBar();
                                int list_size = symptomList1.size();
                                if(list_size == 1){
                                    result_list.setVisibility(View.VISIBLE);
                                    result_list1.setVisibility(View.GONE);
                                    result_list2.setVisibility(View.GONE);
                                    result_list3.setVisibility(View.GONE);
                                    result_list4.setVisibility(View.GONE);
                                    mAdapter2 = new ResultAdapter(getActivity(), symptomList1, result_list, prefrences.getUID(), prefrences.getSymptominterviewid());
                                    result_list.setAdapter(mAdapter2);
                                    mAdapter2.notifyDataSetChanged();
                                } else if(list_size == 2){
                                    result_list.setVisibility(View.GONE);
                                    result_list1.setVisibility(View.VISIBLE);
                                    result_list2.setVisibility(View.GONE);
                                    result_list3.setVisibility(View.GONE);
                                    result_list4.setVisibility(View.GONE);
                                    mAdapter2 = new ResultAdapter(getActivity(), symptomList1, result_list1, prefrences.getUID(), prefrences.getSymptominterviewid());
                                    result_list1.setAdapter(mAdapter2);
                                    mAdapter2.notifyDataSetChanged();
                                } else if(list_size == 3){
                                    result_list.setVisibility(View.GONE);
                                    result_list1.setVisibility(View.GONE);
                                    result_list2.setVisibility(View.VISIBLE);
                                    result_list3.setVisibility(View.GONE);
                                    result_list4.setVisibility(View.GONE);
                                    mAdapter2 = new ResultAdapter(getActivity(), symptomList1, result_list2, prefrences.getUID(), prefrences.getSymptominterviewid());
                                    result_list2.setAdapter(mAdapter2);
                                    mAdapter2.notifyDataSetChanged();
                                } else if(list_size == 4){
                                    result_list.setVisibility(View.GONE);
                                    result_list1.setVisibility(View.GONE);
                                    result_list2.setVisibility(View.GONE);
                                    result_list3.setVisibility(View.VISIBLE);
                                    result_list4.setVisibility(View.GONE);
                                    mAdapter2 = new ResultAdapter(getActivity(), symptomList1, result_list3, prefrences.getUID(), prefrences.getSymptominterviewid());
                                    result_list3.setAdapter(mAdapter2);
                                    mAdapter2.notifyDataSetChanged();
                                } else {
                                    result_list.setVisibility(View.GONE);
                                    result_list1.setVisibility(View.GONE);
                                    result_list2.setVisibility(View.GONE);
                                    result_list3.setVisibility(View.GONE);
                                    result_list4.setVisibility(View.VISIBLE);
                                    mAdapter2 = new ResultAdapter(getActivity(), symptomList1, result_list4, prefrences.getUID(), prefrences.getSymptominterviewid());
                                    result_list4.setAdapter(mAdapter2);
                                    mAdapter2.notifyDataSetChanged();
                                }
                                responsebuilderCondition();
                                responsebuilderTriage();

                                if (!shouldHitApi) {
                                    callApi(RequestHealthConstants.SAVE_SYMPTOM_DATA_PDF);
                                } else {
                                    Log.e("PDF generated :", "Success");
                                }
                            }
                        });
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void replaceFragment(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_YOUR_ANSWERS);
            binder.detect(FragmentsHealthTags.FRAGMENT_YOUR_ANSWERS);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
