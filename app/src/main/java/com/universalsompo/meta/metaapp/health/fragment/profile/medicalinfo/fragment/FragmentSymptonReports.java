package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.SymptomReportAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.SymptomReportModel;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.SelectedSympDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentBasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomQuestions;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomResult;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomSearch;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomSuggestions;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class FragmentSymptonReports extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference pref;
    private LinearLayout first_time;
    private RelativeLayout second_time;
    private RecyclerView symptom_hra_list;
    private LinearLayout symptom_draft_hra;
    private Dialog alert_dialog;
    private String interviewid;
    private ArrayList<SymptomReportModel> data = new ArrayList<>();
    private BasicQuesDatabaseHelper db;
    private SelectedSympDatabaseHelper db1;
    private ResultDatabaseHelper db2;
    private String frag_name;

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_symptom_reports, container, false);
        setHasOptionsMenu(true);
        pref = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        db1 = new SelectedSympDatabaseHelper(getActivity());
        db2 = new ResultDatabaseHelper(getActivity());
        init();
        return v;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        first_time = v.findViewById(R.id.first_time);
        LinearLayout start_hra = v.findViewById(R.id.start_hra);
        second_time = v.findViewById(R.id.second_time);
        symptom_hra_list = v.findViewById(R.id.symptom_hra_list);
        LinearLayout participate_hra = v.findViewById(R.id.participate_hra);
        symptom_draft_hra = v.findViewById(R.id.symptom_draft_hra);
        LinearLayout continue_button = v.findViewById(R.id.continue_button);
        LinearLayout discard_button = v.findViewById(R.id.discard_button);
        TextView date1 = v.findViewById(R.id.date1);

        getsymptomreport();

        int no_of_interview = db.getBasicSymptomInterviewID();
        int no_of_interview1 = db1.getSymptomInterviewID();
        boolean result_true = db2.CheckIsInterviewIdDataAlreadyInDBorNot(pref.getUID(), pref.getSymptominterviewid());

        if (result_true) {
            symptom_draft_hra.setVisibility(View.GONE);
        } else {
            if (no_of_interview == 0 && no_of_interview1 == 0) {
                symptom_draft_hra.setVisibility(View.GONE);
            } else if (no_of_interview != 0 && no_of_interview1 == 0) {
                symptom_draft_hra.setVisibility(View.VISIBLE);
                String frag_name_date = db.getLastRowFragmentName(pref.getUID(), pref.getSymptominterviewid());
                String[] parts = frag_name_date.split(" ");
                frag_name = parts[0];
                String date = parts[1];
                date1.setText("Date : " + date);
            } else {
                symptom_draft_hra.setVisibility(View.VISIBLE);
                String frag_name_date = db1.getLastRowFragmentName(pref.getUID(), pref.getSymptominterviewid());
                String[] parts = frag_name_date.split(" ");
                frag_name = parts[0];
                String date = parts[1];
                date1.setText("Date : " + date);
            }
        }

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Reports page","User resumed his draft HRA");
                if (frag_name.equalsIgnoreCase("FragmentBasicQuestion")) {
                    replaceFragment(new FragmentBasicQuestion());
                } else if (frag_name.equalsIgnoreCase("FragmentSymptomSearch")) {
                    replaceFragment(new FragmentSymptomSearch());
                } else if (frag_name.equalsIgnoreCase("FragmentSymptomSuggestions")) {
                    replaceFragment(new FragmentSymptomSuggestions());
                } else if (frag_name.equalsIgnoreCase("FragmentSymptomQuestions")) {
                    replaceFragment(new FragmentSymptomQuestions());
                } else {
                    replaceFragment(new FragmentSymptomResult());
                }
            }
        });

        discard_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Reports page","User discarded his draft HRA");
                symptom_draft_hra.setVisibility(View.GONE);
                db.close();
                Objects.requireNonNull(getContext()).deleteDatabase("basic_symptom_added_db");
                db1.close();
                getContext().deleteDatabase("user_symptom_added_db");
                Toast.makeText(getActivity(), "Discarded Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        participate_hra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result_true = db.CheckIsInterviewIdDataAlreadyInDBorNot(pref.getUID(), pref.getSymptominterviewid());
                boolean result_true1 = db1.CheckIsInterviewIdDataAlreadyInDBorNot(pref.getUID(), pref.getSymptominterviewid());

                if (result_true && result_true1) {
                    openconfirmationdialog();
                } else if (result_true || result_true1) {
                    openconfirmationdialog();
                } else {
                    new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Reports page","User instialized a new symptom HRA");
                    String username = pref.getUserName();
                    String[] arr = username.split(" ", 2);
                    String userfirstname = arr[0];
                    Random ran = new Random();
                    String code= String.valueOf((100000 + ran.nextInt(900000)));
                    interviewid = userfirstname + "_" + code;
                    callApi();
                }
            }
        });

        start_hra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Reports page","User instialized a new symptom HRA");
                String username = pref.getUserName();
                String[] arr = username.split(" ", 2);
                String userfirstname = arr[0];
                Random ran = new Random();
                String code= String.valueOf((100000 + ran.nextInt(900000)));
                interviewid = userfirstname + "_" + code;
                callApi();
            }
        });
    }

    private void getsymptomreport() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_SYMPTOM_REPORT, this, RequestHealthConstants.GET_SYMPTOM_REPORT);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_SYMPTOM_REPORT) {
            new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Reports page","User loaded all his previous HRA reports");
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                first_time.setVisibility(View.GONE);
                second_time.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("PDFSymptomListRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new SymptomReportModel(
                                        obj.optString("Date"),
                                        obj.optString("FileName"),
                                        obj.optString("FilePath")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    symptom_hra_list.setLayoutManager(layoutManager);
                    SymptomReportAdapter reportAdapter = new SymptomReportAdapter(getActivity(), data);
                    symptom_hra_list.setAdapter(reportAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                int no_of_data = db.getBasicSymptomCount();
                if (no_of_data != 0) {
                    first_time.setVisibility(View.GONE);
                    second_time.setVisibility(View.VISIBLE);
                } else {
                    first_time.setVisibility(View.VISIBLE);
                    second_time.setVisibility(View.GONE);
                }
            }
        } else if (Tag == RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                pref.setSymptom_interview_id(interviewid);
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_7", "Are you overweight or obese?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_28", "Do you smoke cigarettes?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_10", "Do you have high cholesterol?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_9", "Do you have hypertension?", "true", "0", date, "FragmentBasicQuestion");
                db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_8", "Do you have diabetes?", "true", "0", date, "FragmentBasicQuestion");
                replaceFragment(new FragmentBasicQuestion());
            } else {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    private void replaceFragment(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
            binder.detect(FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void openconfirmationdialog() {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert1);
        TextView alert_heading, alert_msg;
        LinearLayout linear_no, linear_yes;
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        linear_no = alert_dialog.findViewById(R.id.linear_no);
        linear_yes = alert_dialog.findViewById(R.id.linear_yes);
        alert_msg.setText("You have already initiated a HRA. If you start a new HRA, then values saved in previous HRA will be lost. Are your sure you want to start with a new HRA?");
        alert_heading.setText("Alert");

        linear_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog.dismiss();
            }
        });

        linear_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Reports page","User instialized a new symptom HRA");
                alert_dialog.dismiss();
                Objects.requireNonNull(getActivity()).deleteDatabase("basic_symptom_added_db");
                String username = pref.getUserName();
                String[] arr = username.split(" ", 2);
                String userfirstname = arr[0];
                Random ran = new Random();
                String code= String.valueOf((100000 + ran.nextInt(900000)));
                interviewid = userfirstname + "_" + code;
                callApi();
            }
        });

        alert_dialog.show();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("InterviewID", interviewid);
        } catch (Exception e) {
                    e.printStackTrace();
                }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID, this, RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID);
        req.execute();
    }

    private List<SymptomReportModel> reverseListOrder(List<SymptomReportModel> status)
    {
        Iterator<SymptomReportModel> it = status.iterator();
        List<SymptomReportModel> destination = new ArrayList<>();
        while (it.hasNext()) {
            destination.add(0, it.next());
            it.remove();
        }
        return destination;
    }
}
