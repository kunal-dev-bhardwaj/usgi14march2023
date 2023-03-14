package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;

import static com.universalsompo.meta.metaapp.health.activities.MainActivityHealth.fitness_icon;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.database.DatabaseActivityID;
import com.universalsompo.meta.metaapp.health.fragment.earnburn.EarnBurnWebView;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyHealthPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.MyHealthRewardPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.OthersAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.PrescriptionAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.ReportsAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.OthersModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.PrescriptionModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.ReportsModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_summery;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.OldMotorAddOns;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Add_Details_Old_Vehicle;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.MotorPayemntWebURl;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.PaymentMotorWeb;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy1;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.FilePath;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NestedListView;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import id.zelory.compressor.Compressor;

public class  FragmentMedicalRecords extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference mySharedPreference;
    private LinearLayout add_prescription,list_prescription;
    private ImageView down_arrow, up_arrow, down_arrow1, up_arrow1, down_arrow2, up_arrow2, down_arrow3, up_arrow3;
    private LinearLayout add_reports,list_reports;
    private LinearLayout add_others,list_others;
    private EditText edt_patient_name;
    private LinearLayout tick_ok, tick_cancel;
    private NestedListView get_prescription_list;
    private LinearLayout add_new_prescription;
    private TextView upload, uploaded;
    CustomProgressDialog customerProgress;
    private PrescriptionAdapter prescriptionAdapter;
    ArrayList<PrescriptionModel> data = new ArrayList<>();
    String TokenNo,FunctionalityType;
    /* Lab Test */
    private EditText edt_patient_name1;
    private LinearLayout upload_reports;
    private LinearLayout tick_ok1, tick_cancel1;
    private NestedListView get_test_list;
    private LinearLayout add_new_reports;
    private TextView upload1, uploaded1;
    MyHealthRewardPolicyAdapter myHealthRewardPolicyAdapter;
    private ReportsAdapter reportsAdapter;
    ArrayList<ReportsModel> data1 = new ArrayList<>();
    private final ArrayList<MyHealthPolicyModel> myHealthPolicyData = new ArrayList<>();
    int day_left_to_expire;
    /* Others */
    private EditText edt_patient_name2;
    private LinearLayout upload_others;
    private LinearLayout tick_ok2, tick_cancel2;
    private NestedListView get_others_list;
    private LinearLayout add_new_others;
    private TextView upload2, uploaded2;

    private OthersAdapter othersAdapter;
    ArrayList<OthersModel> data2 = new ArrayList<>();

    private Dialog profilePicDialog;
    private final int CAMERA_REQUEST = 200;
    private final int GALLERY_REQUEST = 201;
    private final int PIC_CROP = 202;
    private File mImageFile;
    private String base64imageextension = "";
    private String base64string = "";
    private String Tag_Camera = "camera";
    private String Tag_Gallery = "galary";

    private String Tag = null;
    private String File_Name = null, new_file_name = "";
    private Bitmap myBitmap;
    final int ACTIVITY_CHOOSE_FILE = 7;
    private Bitmap bitmap;
    private String encodedResume, extension;
    DatabaseActivityID activityID;
    private MySharedPreference prefrences;
    private TextView no_data;
    RecyclerView rcv_healthpolicy;
    private LinearLayout shimmerIncludeLayout ;
    private LinearLayout liner ;
    private ShimmerFrameLayout mShimmerViewContainer;
    TextView rewardPointText;
    String rewardPoint;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_medical_records, container,false);
        prefrences = MySharedPreference.getInstance(getActivity());
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth)getActivity()).show_elevation();
        ((MainActivityHealth) getActivity()).hidefooter();
        activityID = new DatabaseActivityID(getActivity());
        init();
        customerProgress = new CustomProgressDialog(getContext());

        setHasOptionsMenu(true);
        initPolicy();
        customerProgress.showProgressBar();
        return v;
    }



    private void init() {
        mySharedPreference = MySharedPreference.getInstance(getActivity());
        shimmerIncludeLayout = v.findViewById(R.id.shimmerIncludeLayout);
        no_data= v.findViewById(R.id.no_data);
        liner = v.findViewById(R.id.liner);
        mShimmerViewContainer = v.findViewById(R.id.parentShimmerLayout);
        rcv_healthpolicy= v.findViewById(R.id.rv_booked_policy);
        LinearLayout prescription = v.findViewById(R.id.prescription);
        LinearLayout reports = v.findViewById(R.id.reports);
        LinearLayout others = v.findViewById(R.id.others);
        LinearLayout hra_reports = v.findViewById(R.id.hra_reports);
        add_prescription = v.findViewById(R.id.add_prescription);
        list_prescription = v.findViewById(R.id.list_prescription);
        add_reports = v.findViewById(R.id.add_reports);
        list_reports = v.findViewById(R.id.list_reports);
        add_others = v.findViewById(R.id.add_others);
        list_others = v.findViewById(R.id.list_others);
        down_arrow = v.findViewById(R.id.down_arrow);
        up_arrow = v.findViewById(R.id.up_arrow);
        down_arrow1 = v.findViewById(R.id.down_arrow1);
        up_arrow1 = v.findViewById(R.id.up_arrow1);
        down_arrow2 = v.findViewById(R.id.down_arrow2);
        up_arrow2 = v.findViewById(R.id.up_arrow2);
        down_arrow3 = v.findViewById(R.id.down_arrow3);
        up_arrow3 = v.findViewById(R.id.up_arrow3);
        rewardPointText = v.findViewById(R.id.rewardPointText);

        add_new_prescription = v.findViewById(R.id.add_new_prescription);
        add_new_reports = v.findViewById(R.id.add_new_reports);
        add_new_others = v.findViewById(R.id.add_new_others);

        tick_cancel = v.findViewById(R.id.tick_cancel);
        tick_cancel1 = v.findViewById(R.id.tick_cancel1);
        tick_cancel2 = v.findViewById(R.id.tick_cancel2);

        get_prescription_list = v.findViewById(R.id.get_prescription_list);
        get_test_list = v.findViewById(R.id.get_test_list);
        get_others_list = v.findViewById(R.id.get_others_list);

        edt_patient_name = v.findViewById(R.id.edt_patient_name);
        edt_patient_name1 = v.findViewById(R.id.edt_patient_name_1);
        edt_patient_name2 = v.findViewById(R.id.edt_patient_name_2);

        LinearLayout upload_prescription = v.findViewById(R.id.upload_prescription);
        upload_reports = v.findViewById(R.id.upload_reports);
        upload_others = v.findViewById(R.id.upload_others);

        upload = v.findViewById(R.id.upload);
        upload1 = v.findViewById(R.id.upload1);
        upload2 = v.findViewById(R.id.upload2);

        uploaded = v.findViewById(R.id.uploaded);
        uploaded1 = v.findViewById(R.id.uploaded1);
        uploaded2 = v.findViewById(R.id.uploaded2);

        tick_ok = v.findViewById(R.id.tick_ok);
        tick_ok1 = v.findViewById(R.id.tick_ok1);
        tick_ok2 = v.findViewById(R.id.tick_ok2);

        hra_reports.setOnClickListener(v -> {
            Fragment frag = new FragmentSymptonReports();
            /*Bundle args = new Bundle();
            args.putString("value", "0");
            frag.setArguments(args);*/
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
            binder.detect(FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
            //replaceFragment(new FragmentHRAReportsTabs(), FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
        });

        prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // list_prescription.setVisibility(View.VISIBLE);
                if(list_prescription.getVisibility() == View.VISIBLE){
                    list_prescription.setVisibility(View.GONE);
                    down_arrow.setVisibility(View.VISIBLE);
                    up_arrow.setVisibility(View.GONE);
                } else {
                    list_prescription.setVisibility(View.VISIBLE);
                    down_arrow.setVisibility(View.GONE);
                    up_arrow.setVisibility(View.VISIBLE);
                }
                if(add_prescription.getVisibility() == View.VISIBLE){
                    add_prescription.setVisibility(View.GONE);
                }
                if(add_reports.getVisibility() == View.VISIBLE || list_reports.getVisibility() == View.VISIBLE){
                    add_reports.setVisibility(View.GONE);
                    list_reports.setVisibility(View.GONE);
                }
                if(add_others.getVisibility() == View.VISIBLE || list_others.getVisibility() == View.VISIBLE){
                    add_others.setVisibility(View.GONE);
                    list_others.setVisibility(View.GONE);
                }
                // down_arrow.setVisibility(View.GONE);
                // up_arrow.setVisibility(View.VISIBLE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                getprescription();
            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list_reports.getVisibility() == View.VISIBLE){
                    list_reports.setVisibility(View.GONE);
                    down_arrow1.setVisibility(View.VISIBLE);
                    up_arrow1.setVisibility(View.GONE);
                } else {
                    list_reports.setVisibility(View.VISIBLE);
                    down_arrow1.setVisibility(View.GONE);
                    up_arrow1.setVisibility(View.VISIBLE);
                }
                if(add_prescription.getVisibility() == View.VISIBLE || list_prescription.getVisibility() == View.VISIBLE){
                    add_prescription.setVisibility(View.GONE);
                    list_prescription.setVisibility(View.GONE);
                }
                // list_reports.setVisibility(View.VISIBLE);
                if(add_reports.getVisibility() == View.VISIBLE){
                    add_reports.setVisibility(View.GONE);
                }
                if(add_others.getVisibility() == View.VISIBLE || list_others.getVisibility() == View.VISIBLE){
                    add_others.setVisibility(View.GONE);
                    list_others.setVisibility(View.GONE);
                }
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                getreports();
            }
        });

        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list_others.getVisibility() == View.VISIBLE){
                    list_others.setVisibility(View.GONE);
                    down_arrow2.setVisibility(View.VISIBLE);
                    up_arrow2.setVisibility(View.GONE);
                } else {
                    list_others.setVisibility(View.VISIBLE);
                    down_arrow2.setVisibility(View.GONE);
                    up_arrow2.setVisibility(View.VISIBLE);
                }
                if(add_prescription.getVisibility() == View.VISIBLE || list_prescription.getVisibility() == View.VISIBLE){
                    add_prescription.setVisibility(View.GONE);
                    list_prescription.setVisibility(View.GONE);
                }
                if(add_reports.getVisibility() == View.VISIBLE || list_reports.getVisibility() == View.VISIBLE){
                    add_reports.setVisibility(View.GONE);
                    list_reports.setVisibility(View.GONE);
                }
                // list_others.setVisibility(View.VISIBLE);
                if(add_others.getVisibility() == View.VISIBLE){
                    add_others.setVisibility(View.GONE);
                }
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
                down_arrow3.setVisibility(View.VISIBLE);
                up_arrow3.setVisibility(View.GONE);
                getothers();
            }
        });

        add_new_prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_prescription.setVisibility(View.GONE);
                add_prescription.setVisibility(View.VISIBLE);
                edt_patient_name.setText("");
                upload.setVisibility(View.VISIBLE);
                uploaded.setVisibility(View.GONE);
            }
        });

        add_new_reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_reports.setVisibility(View.GONE);
                add_reports.setVisibility(View.VISIBLE);
                edt_patient_name1.setText("");
                upload1.setVisibility(View.VISIBLE);
                uploaded1.setVisibility(View.GONE);
            }
        });

        add_new_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_others.setVisibility(View.GONE);
                add_others.setVisibility(View.VISIBLE);
                edt_patient_name2.setText("");
                upload2.setVisibility(View.VISIBLE);
                uploaded2.setVisibility(View.GONE);
            }
        });

        tick_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_prescription.setVisibility(View.GONE);
                down_arrow.setVisibility(View.VISIBLE);
                up_arrow.setVisibility(View.GONE);
            }
        });

        tick_cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_reports.setVisibility(View.GONE);
                down_arrow1.setVisibility(View.VISIBLE);
                up_arrow1.setVisibility(View.GONE);
            }
        });

        tick_cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_others.setVisibility(View.GONE);
                down_arrow2.setVisibility(View.VISIBLE);
                up_arrow2.setVisibility(View.GONE);
            }
        });

        upload_prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");
                startActivityForResult(intent, ACTIVITY_CHOOSE_FILE);
            }
        });

        upload_reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");
                startActivityForResult(intent, ACTIVITY_CHOOSE_FILE);
            }
        });

        upload_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");
                startActivityForResult(intent, ACTIVITY_CHOOSE_FILE);
            }
        });

        tick_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_patient_name.getText().toString().equalsIgnoreCase("") || edt_patient_name.getText().toString().equalsIgnoreCase(null)){
                    Toast.makeText(getActivity(), "Please enter patient name.", Toast.LENGTH_SHORT).show();
                }else if(encodedResume == null){
                    Toast.makeText(getActivity(), "Please upload Prescription .", Toast.LENGTH_SHORT).show();
                }else{
                    callApi(RequestHealthConstants.SAVE_PRESCRIPTION);
                }
            }
        });

        tick_ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_patient_name1.getText().toString().equalsIgnoreCase("") || edt_patient_name1.getText().toString().equalsIgnoreCase(null)){
                    Toast.makeText(getActivity(), "Please enter patient name.", Toast.LENGTH_SHORT).show();
                }else if(encodedResume .equals("")){
                    Toast.makeText(getActivity(), "Please upload Lab Report.", Toast.LENGTH_SHORT).show();
                }else {
                    callApi(RequestHealthConstants.SAVE_REPORTS);
                }
            }
        });

        tick_ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_patient_name2.getText().toString().equalsIgnoreCase("") || edt_patient_name2.getText().toString().equalsIgnoreCase(null)){
                    Toast.makeText(getActivity(), "Please enter patient name.", Toast.LENGTH_SHORT).show();
                } else if(encodedResume == null){
                    Toast.makeText(getActivity(), "Please upload Report.", Toast.LENGTH_SHORT).show();
                }else {
                    callApi(RequestHealthConstants.SAVE_OTHERS);
                }
            }
        });
    }

    public void getprescription() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_PRESCRIPTION, this, RequestHealthConstants.GET_PRESCRIPTION);
        req.execute();
    }

    private void getreports() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_REPORTS, this, RequestHealthConstants.GET_REPORTS);
        req.execute();
    }

    private void getothers() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_OTHERS, this, RequestHealthConstants.GET_OTHERS);
        req.execute();
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void initPolicy() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("UserID", prefrences.getUID());
        }catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getContext(), object, UrlHealthConstants.UNIVERSAL_HEALTH_POLICY, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Success")) {
                    customerProgress.hideProgressBar();
                    if (Tag != RequestHealthConstants.UNIVERSAL_HEALTH_POLICY) {
                        JSONArray arr;
                        if (!myHealthPolicyData.isEmpty())
                            myHealthPolicyData.clear();
                        try {
                            rcv_healthpolicy.setVisibility(View.VISIBLE);
                            liner.setVisibility(View.GONE);
                            arr = object.getJSONArray("UnivSompoHealthPolicyList");
                            for (int i = 0; i < arr.length(); i++) {
                                String RemainingDay = arr.optJSONObject(i).getString("RemainingDay");
                                int day_left_to_expire = Integer.parseInt(RemainingDay);
                                myHealthPolicyData.add(
                                        new MyHealthPolicyModel(
                                                arr.optJSONObject(i).optString("ClaimContactNumber"),
                                                arr.optJSONObject(i).optString("ClaimEmailID"),
                                                arr.optJSONObject(i).optString("Composition"),
                                                arr.optJSONObject(i).optString("ExpiryDate"),
                                                arr.optJSONObject(i).optString("InsCompLogoPath"),
                                                arr.optJSONObject(i).optString("InsCompName"),
                                                arr.optJSONObject(i).optString("IsClaimInitiated"),
                                                arr.optJSONObject(i).optString("PolicyID"),
                                                arr.optJSONObject(i).optString("Policy_Category"),
                                                arr.optJSONObject(i).optString("Policy_Holder_Name"),
                                                arr.optJSONObject(i).optString("Policy_Number"),
                                                arr.optJSONObject(i).optString("Premium"),
                                                arr.optJSONObject(i).optString("Product_Name"),
                                                arr.optJSONObject(i).optString("RemainingDay"),
                                                arr.optJSONObject(i).optString("SumInsured")
                                        )
                                );
                                Activity activity = getActivity();
                                if (isAdded() && activity != null) {
                                    getLayoutInflater().inflate(R.layout.claim_policy_items_shimmer_track, shimmerIncludeLayout, true);
                                }
                                if (myHealthPolicyData.size() != 0) {
//                                    GetPolicySummaryByPolicy();
                                    customerProgress.hideProgressBar();
                                    mShimmerViewContainer.startShimmer();
                                    mShimmerViewContainer.postDelayed(() -> {
                                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                        rcv_healthpolicy.setLayoutManager(layoutManager);
                                        myHealthRewardPolicyAdapter = new MyHealthRewardPolicyAdapter(getActivity(), myHealthPolicyData);
                                        rcv_healthpolicy.setAdapter(myHealthRewardPolicyAdapter);
                                        no_data.setVisibility(View.GONE);
                                        liner.setVisibility(View.GONE);
                                        mShimmerViewContainer.stopShimmer();
                                        mShimmerViewContainer.setVisibility(View.GONE);
                                    }, 3000);
                                }

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
            /*no_data.setText("No Policy Found");
            no_data.setVisibility(View.VISIBLE);*/
                    customerProgress.hideProgressBar();
                    rcv_healthpolicy.setVisibility(View.GONE);
                    liner.setVisibility(View.GONE);
                    no_data.setVisibility(View.VISIBLE);
                    no_data.setText("No Policy Found");
                }

//                if (object.optString("Message").equals("Success")) {
//                    if (Tag == RequestHealthConstants.UNIVERSAL_HEALTH_POLICY) {
//                        JSONArray arr;
//                        if (!myHealthPolicyData.isEmpty())
//                            myHealthPolicyData.clear();
//                        try {
//                            arr = object.getJSONArray("UnivSompoHealthPolicyList");
//                            for (int i = 0; i < arr.length(); i++) {
//                                String RemainingDay = arr.optJSONObject(i).getString("RemainingDay");
//                                day_left_to_expire = Integer.parseInt(RemainingDay);
//                                if (day_left_to_expire < 1) {
//                                }else {
//                                    myHealthPolicyData.add(
//                                            new MyHealthPolicyModel(
//                                                    arr.optJSONObject(i).optString("ClaimContactNumber"),
//                                                    arr.optJSONObject(i).optString("ClaimEmailID"),
//                                                    arr.optJSONObject(i).optString("Composition"),
//                                                    arr.optJSONObject(i).optString("ExpiryDate"),
//                                                    arr.optJSONObject(i).optString("InsCompLogoPath"),
//                                                    arr.optJSONObject(i).optString("InsCompName"),
//                                                    arr.optJSONObject(i).optString("IsClaimInitiated"),
//                                                    arr.optJSONObject(i).optString("PolicyID"),
//                                                    arr.optJSONObject(i).optString("Policy_Category"),
//                                                    arr.optJSONObject(i).optString("Policy_Holder_Name"),
//                                                    arr.optJSONObject(i).optString("Policy_Number"),
//                                                    arr.optJSONObject(i).optString("Premium"),
//                                                    arr.optJSONObject(i).optString("Product_Name"),
//                                                    arr.optJSONObject(i).optString("RemainingDay"),
//                                                    arr.optJSONObject(i).optString("SumInsured")
//                                            )
//                                    );
//                                }
//                            }
//                            Log.e("MyHealthPolicyData", String.valueOf(myHealthPolicyData.size()));
//                            if (myHealthPolicyData.size() == 0) {
//                                final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
//                                dialog.setCanceledOnTouchOutside(false);
//                                dialog.setCancelable(false);
//                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//                                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//                                dialog.setContentView(R.layout.rewards_popup_);
//
//                                TextView earn_dialog = dialog.findViewById(R.id.earn_dialog);
//                                earn_dialog.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        FunctionalityType="Earn";
//                                        earnAPi();
//                                        dialog.dismiss();
//                                    }
//                                });
//
//                                TextView burn_dialog = dialog.findViewById(R.id.burn_dialog);
//                                burn_dialog.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        FunctionalityType="Burn";
//                                        earnAPi();
//                                        dialog.dismiss();
//                                    }
//                                });
//                                dialog.show();
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                else{
//                    final Dialog dialog = new Dialog(getContext());
//                    dialog.setCanceledOnTouchOutside(false);
//                    dialog.setCancelable(false);
//                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                    Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//                    dialog.setContentView(R.layout.rewards_popup_);
//                    Typeface fontAwesomeFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
//                    TextView fitness_icon = dialog.findViewById(R.id.fitness_icon);
//                    fitness_icon.setTypeface(fontAwesomeFont);
//                    TextView earn_dialog = dialog.findViewById(R.id.earn_dialog);
//                    TextView burn_dialog = dialog.findViewById(R.id.burn_dialog);
//                    earn_dialog.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            FunctionalityType="Earn";
//                            earnAPi();
//                            dialog.dismiss();
//
//
//                        }
//                    });
//                    burn_dialog.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            FunctionalityType="Burn";
//                            earnAPi();
//                            dialog.dismiss();
//                        }
//                    });
//                    dialog.show();
//                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestConstants.BUY_POLICY_MOTOR_PRIVATE_PROPOSAL);
        req.execute();
    }

    private void GetPolicySummaryByPolicy() {
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("RequestSource", "1A9581EE-248C-48CB-9C64-W925C3CCC0EB");
            parameters.put("PolicyNumber", "2840/63125660/00/000");
        } catch (Exception e) {
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://testusgiapi.watchyourhealth.com/api/Policy/GetPolicySummaryByPolicy", parameters,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("onResponse", response.toString());
                customerProgress.hideProgressBar();
                try {
                    String StatusCode=response.getString("StatusCode");
                    if (StatusCode.equals("200")){
                         rewardPoint=response.getString("Data");
                         rewardPointText.setText(rewardPoint);
                    }else{
                        rewardPointText.setText("0");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    customerProgress.hideProgressBar();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("onErrorResponse", error.toString());
                customerProgress.hideProgressBar();
                Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("AppBase", "USGI");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getActivity());
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }


    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_PRESCRIPTION){
            if (object.optString("Message").equals("Success")){
                get_prescription_list.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("GetMedRecordRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new PrescriptionModel(
                                        obj.optString("ConsultDate"),
                                        obj.optString("MedRecordID"),
                                        obj.optString("PatientName"),
                                        obj.optString("ReportPath")
                                )
                        );
                    }

                    prescriptionAdapter = new PrescriptionAdapter(getActivity(), data);
                    get_prescription_list.setAdapter(prescriptionAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                get_prescription_list.setVisibility(View.GONE);
            }
        }

        else if (Tag == RequestHealthConstants.GET_REPORTS){
            if (object.optString("Message").equals("Success")){
                get_test_list.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("GetUserReportRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data1.add(
                                new ReportsModel(
                                        obj.optString("PatientName"),
                                        obj.optString("ReportID"),
                                        obj.optString("ReportPath"),
                                        obj.optString("TestDate")
                                )
                        );
                    }

                    reportsAdapter = new ReportsAdapter(getActivity(), data1);
                    get_test_list.setAdapter(reportsAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                get_test_list.setVisibility(View.GONE);
            }
        }

        else if (Tag == RequestHealthConstants.GET_OTHERS){
            if (object.optString("Message").equals("Success")){
                get_others_list.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!data2.isEmpty())
                    data2.clear();
                try {
                    arr = object.getJSONArray("GetOtherDocRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data2.add(
                                new OthersModel(
                                        obj.optString("Date"),
                                        obj.optString("DocID"),
                                        obj.optString("DocumentPath"),
                                        obj.optString("PatientName")
                                )
                        );
                    }

                    othersAdapter = new OthersAdapter(getActivity(), data2);
                    get_others_list.setAdapter(othersAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                get_others_list.setVisibility(View.GONE);
            }
        }

        else if (Tag == RequestHealthConstants.SAVE_PRESCRIPTION) {
            try {
                Log.d("Response", object.toString());
                Snackbar.make(getView(), "Prescription saved successfully.", Snackbar.LENGTH_LONG).show();
                if(add_prescription.getVisibility() == View.VISIBLE){
                    add_prescription.setVisibility(View.GONE);
                    list_prescription.setVisibility(View.GONE);
                    down_arrow.setVisibility(View.VISIBLE);
                    up_arrow.setVisibility(View.GONE);
                    encodedResume="";
                    //getprescription();
                }
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (Tag == RequestHealthConstants.SAVE_REPORTS) {
            try {
                Log.d("Response", object.toString());
                Snackbar.make(getView(), "Reports saved successfully.", Snackbar.LENGTH_LONG).show();
                if(add_reports.getVisibility() == View.VISIBLE){
                    add_reports.setVisibility(View.GONE);
                    list_reports.setVisibility(View.GONE);
                    down_arrow1.setVisibility(View.VISIBLE);
                    up_arrow1.setVisibility(View.GONE);
                    encodedResume="";
                    //getreports();
                }
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (Tag == RequestHealthConstants.SAVE_OTHERS) {
            try {
                Log.d("Response", object.toString());
                Snackbar.make(getView(), "Other document saved successfully.", Snackbar.LENGTH_LONG).show();
                if(add_others.getVisibility() == View.VISIBLE){
                    add_others.setVisibility(View.GONE);
                    list_others.setVisibility(View.GONE);
                    down_arrow2.setVisibility(View.VISIBLE);
                    up_arrow2.setVisibility(View.GONE);
                    encodedResume="";
                    //getothers();
                }
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    void processAhed() {
        if (Tag.equals(Tag_Camera)) {
            captureImage();

        } else if (Tag.equals(Tag_Gallery)) {
            viewFromGallery();
        }
    }

    void viewFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                GALLERY_REQUEST);
    }

    void captureImage() {
        mImageFile = new File(Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "temp.png");
        Uri tempURI = Uri.fromFile(mImageFile);
        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
        startActivityForResult(photoCaptureIntent, CAMERA_REQUEST);
    }


    /*public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            File_Name = null;
            //********************************* Gallery Request *************************************************
            if (requestCode == GALLERY_REQUEST) {
                Uri selectedImageUri = data.getData();
                CropImage.activity(selectedImageUri)
                        .start(getContext(), this);
                if (null != selectedImageUri) {

                    try {
                        File_Name = FileUtils.getPathFromURI(getActivity().getApplicationContext(), selectedImageUri);
                        base64imageextension = File_Name.substring(File_Name.lastIndexOf("."));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            //************************************* Camera Request *********************************************
            else if (requestCode == CAMERA_REQUEST) {
                File_Name = mImageFile.getAbsolutePath();
                Uri tempURI = Uri.fromFile(mImageFile);
                CropImage.activity(tempURI).start(getContext(), this);
                base64imageextension = File_Name.substring(File_Name.lastIndexOf("."));

            }

            //**************************** Crop REQUEST ****************************************************
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Uri resultUri = result.getUri();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), resultUri);
                    String imagePath = resultUri.toString();
                    handleCroppedImage(getFileName("help_image.png", bitmap), "helpimage.png");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultcode, Intent data) {
        super.onActivityResult(requestCode, resultcode, data);

        InputStream stream = null;
        if (requestCode == ACTIVITY_CHOOSE_FILE && resultcode == Activity.RESULT_OK) {
            try {
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                Uri urii = data.getData();
                String path = FilePath.getPath(getContext(), urii);
                File myFile = new File(path);
                extension = path.substring(path.lastIndexOf("."));
                if (extension.equals(".jpg") || extension.equals(".jpeg") || extension.equals(".png")) {
                    encodedResume = FilePath.encodeImage(path);
                    if (add_prescription.getVisibility() == View.VISIBLE) {
                        upload.setVisibility(View.GONE);
                        uploaded.setVisibility(View.VISIBLE);
                    } else if (add_reports.getVisibility() == View.VISIBLE) {
                        upload1.setVisibility(View.GONE);
                        uploaded1.setVisibility(View.VISIBLE);
                    } else {
                        upload2.setVisibility(View.GONE);
                        uploaded2.setVisibility(View.VISIBLE);
                    }
                } else if (extension.equals(".pdf") || extension.equals(".doc") || extension.equals(".docx")) {
                    encodedResume = ConvertFile(myFile);
                    if (add_prescription.getVisibility() == View.VISIBLE) {
                        upload.setVisibility(View.GONE);
                        uploaded.setVisibility(View.VISIBLE);
                    } else if (add_reports.getVisibility() == View.VISIBLE) {
                        upload1.setVisibility(View.GONE);
                        uploaded1.setVisibility(View.VISIBLE);
                    } else {
                        upload2.setVisibility(View.GONE);
                        uploaded2.setVisibility(View.VISIBLE);
                    }
                } else {
                    Toast.makeText(getContext(), "Unsupported media", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (stream != null)
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        } else {
            // Toast.makeText(getContext(), "error in image loading", Toast.LENGTH_LONG).show();

        }
    }

    void handleCroppedImage(final String Path, String image) {
        String f = null;
        f = compressNow(Path);
        LogUtils.showLog("@@@@@@@@@@@@@", f);
        myBitmap = BitmapFactory.decodeFile(f);
        startSaveImage(image, myBitmap);
    }

    void startSaveImage(String image, Bitmap myBitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), image);
        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        saveImageToFile(myBitmap, file.getAbsolutePath());
    }

    private void convertBitmaptoBase64(Bitmap bitmap) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bao);
        byte[] ba = bao.toByteArray();
        try {
            base64string = Base64.encodeToString(ba, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String compressNow(final String file) {
        FileUtils.deleteCache(getActivity());
        File compressedImage = new Compressor.Builder(getActivity())
                .setMaxWidth(350)
                .setMaxHeight(350)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .build()
                .compressToFile(new File(file));
        return compressedImage.getAbsolutePath();
    }

    void saveImageToFile(Bitmap bmp, String filename) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            convertBitmaptoBase64(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String getFileName(String filename, Bitmap bmp) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), filename);
        FileOutputStream out = null;
        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        try {
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file.getAbsolutePath();
    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.SAVE_PRESCRIPTION) {
            JSONObject object = new JSONObject();

            try {
                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
                String dateString = sdf.format(date);
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("DocID", "0");
                object.put("UserID", mySharedPreference.getUID());
                object.put("Patient_Name", edt_patient_name.getText().toString());
                object.put("ConsultDate", dateString);
                object.put("FileExt", extension);
                object.put("FileInBase64", encodedResume);
                /*if (base64string.equals("")) {
                    object.put("FileInBase64", "");
                } else {
                    object.put("FileInBase64", encodedResume);
                }

                if (base64imageextension.equals("")) {
                    object.put("FileExt", "0");
                } else {
                    object.put("FileExt", extension);
                }*/
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_PRESCRIPTION, this, RequestHealthConstants.SAVE_PRESCRIPTION);
            req.execute();
        }

        else if (id == RequestHealthConstants.SAVE_REPORTS) {
            JSONObject object = new JSONObject();

            try {
                long date1 = System.currentTimeMillis();
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy");
                String dateString1 = sdf1.format(date1);
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("DocID", "0");
                object.put("UserID", mySharedPreference.getUID());
                object.put("PatientName", edt_patient_name1.getText().toString());
                object.put("TestDate", dateString1);
                object.put("FileExt", extension);
                object.put("FileInBase64", encodedResume);
                /*if (base64string.equals("")) {
                    object.put("FileInBase64", "");
                } else {
                    object.put("FileInBase64", base64string);
                }

                if (base64imageextension.equals("")) {
                    object.put("FileExt", "0");
                } else {
                    object.put("FileExt", base64imageextension);
                }*/
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_REPORTS, this, RequestHealthConstants.SAVE_REPORTS);
            req.execute();
        }

        else if (id == RequestHealthConstants.SAVE_OTHERS) {
            JSONObject object = new JSONObject();

            try {
                long date2 = System.currentTimeMillis();
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy");
                String dateString2 = sdf2.format(date2);
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("DocID", "0");
                object.put("UserID", mySharedPreference.getUID());
                object.put("PatientName", edt_patient_name2.getText().toString());
                object.put("Date", dateString2);
                object.put("FileExt", extension);
                object.put("FileInBase64", encodedResume);
                /*if (base64string.equals("")) {
                    object.put("FileInBase64", "");
                } else {
                    object.put("FileInBase64", base64string);
                }

                if (base64imageextension.equals("")) {
                    object.put("FileExt", "0");
                } else {
                    object.put("FileExt", base64imageextension);
                }*/
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_OTHERS, this, RequestHealthConstants.SAVE_OTHERS);
            req.execute();
        }
    }

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public static String ConvertFile(File file) {

        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
            for (int j = 0; j < b.length; j++) {
                System.out.print((char) b[j]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Error Reading The File.");
            e1.printStackTrace();
        }

        byte[] byteFileArray = readBytesFromFile(file);
        // byte[] byteFileArray = new byte[0];
        /*try {
            byteFileArray = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String base64String = "";
        if (byteFileArray.length > 0) {
            base64String = android.util.Base64.encodeToString(byteFileArray, android.util.Base64.NO_WRAP);
            Log.i("File Base64 string", "IMAGE PARSE ==>" + base64String);
        }
        return base64String;
    }

    private static byte[] readBytesFromFile(File filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            bytesArray = new byte[(int) filePath.length()];

            fileInputStream = new FileInputStream(filePath);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytesArray;
    }




}
