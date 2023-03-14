package com.universalsompo.meta.metaapp.health.fragment.profile.myriskprofile.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.APIRequest.CheckIfLoginNameExist;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentHRAReportsTabs;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentBasicQuestion;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class FragmentDontKnowQuestions extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private SelectorListener binder;
    private LinearLayout ques1, ques2, ques3, ques4;
    private LinearLayout well, not_well;
    private LinearLayout yes, yes1, yes2, no, no1, no2;
    private MySharedPreference pref;
    private BasicQuesDatabaseHelper db;
    private ResultDatabaseHelper db1;
    private LifestyleHRADatabaseHelper db2;
    private LifestyleResultDatabaseHelper db3;
    String interviewid;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dont_know_question, container, false);
        ((MainActivityHealth) getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).show_elevation();
        ((MainActivityHealth) getActivity()).hidefooter();
        pref = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        db1 = new ResultDatabaseHelper(getActivity());
        db2 = new LifestyleHRADatabaseHelper(getActivity());
        db3 = new LifestyleResultDatabaseHelper(getActivity());
        init();
        return v;
    }

    private void init() {
        ques1 = v.findViewById(R.id.ques1);
        ques2 = v.findViewById(R.id.ques2);
        ques3 = v.findViewById(R.id.ques3);
        ques4 = v.findViewById(R.id.ques4);
        well = v.findViewById(R.id.well);
        not_well = v.findViewById(R.id.not_well);
        yes = v.findViewById(R.id.yes);
        yes1 = v.findViewById(R.id.yes1);
        yes2 = v.findViewById(R.id.yes2);
        no = v.findViewById(R.id.no);
        no1 = v.findViewById(R.id.no1);
        no2 = v.findViewById(R.id.no2);

        yes.setOnClickListener(this);
        yes1.setOnClickListener(this);
        yes2.setOnClickListener(this);
        no.setOnClickListener(this);
        no1.setOnClickListener(this);
        no2.setOnClickListener(this);
        well.setOnClickListener(this);
        not_well.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.well:
                ques1.setVisibility(View.GONE);
                ques2.setVisibility(View.GONE);
                ques3.setVisibility(View.GONE);
                ques4.setVisibility(View.VISIBLE);
                break;

            case R.id.not_well:
                ques1.setVisibility(View.GONE);
                ques2.setVisibility(View.VISIBLE);
                ques3.setVisibility(View.GONE);
                ques4.setVisibility(View.GONE);
                break;

            case R.id.yes:
                ques1.setVisibility(View.GONE);
                ques2.setVisibility(View.GONE);
                ques3.setVisibility(View.VISIBLE);
                ques4.setVisibility(View.GONE);
                break;

            case R.id.yes1:
                boolean result_true = db1.CheckIsInterviewIdDataAlreadyInDBorNot(pref.getUID(), pref.getSymptominterviewid());

                if (result_true == true) {
                    String username = pref.getUserName();
                    String[] arr = username.split(" ", 2);
                    String userfirstname = arr[0];
                    Random ran = new Random();
                    String code = String.valueOf((100000 + ran.nextInt(900000)));
                    interviewid = userfirstname + "_" + code;
                    callApi(RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID);
                } else {
                    int no_of_data = db.getBasicSymptomCount();
                    if (no_of_data != 0) {
                        Fragment frag1 = new FragmentHRAReportsTabs();
                        Bundle args1 = new Bundle();
                        args1.putString("value", "2");
                        frag1.setArguments(args1);
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag1, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
                        binder.detect(FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
                    } else {
                        String username = pref.getUserName();
                        String[] arr = username.split(" ", 2);
                        String userfirstname = arr[0];
                        Random ran = new Random();
                        String code = String.valueOf((100000 + ran.nextInt(900000)));
                        interviewid = userfirstname + "_" + code;
                        callApi(RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID);
                    }
                }
                //replaceFragment(new FragmentHRA(), FragmentsHealthTags.FRAGMENT_HRA);
                break;

            case R.id.yes2:
                boolean result_true_lifestyle = db3.CheckIsAuthTokenDataAlreadyInDBorNot(pref.getUID(), pref.getsessionid());

                if (result_true_lifestyle == true) {
                    CheckIfLoginNameExist checkforloginname = new CheckIfLoginNameExist(getContext());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        checkforloginname.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    } else {
                        checkforloginname.execute();
                    }
                } else {
                    int no_of_data_lifestyle = db2.getLifestyleCount();
                    if (no_of_data_lifestyle != 0) {
                        Fragment frag = new FragmentHRAReportsTabs();
                        Bundle args = new Bundle();
                        args.putString("value", "1");
                        frag.setArguments(args);
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
                        binder.detect(FragmentsHealthTags.FRAGMENT_HRA_REPORTS_TAB);
                    } else {
                        CheckIfLoginNameExist checkforloginname = new CheckIfLoginNameExist(getContext());
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                            checkforloginname.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                        } else {
                            checkforloginname.execute();
                        }
                    }
                }
                break;

            case R.id.no:
                ques1.setVisibility(View.GONE);
                ques2.setVisibility(View.GONE);
                ques3.setVisibility(View.GONE);
                ques4.setVisibility(View.VISIBLE);
                break;

            case R.id.no1:
                ((MainActivityHealth) getActivity()).changeFragmnet();
                break;

            case R.id.no2:
                ((MainActivityHealth) getActivity()).changeFragmnet();
                break;
        }
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

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("InterviewID", interviewid);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID, this, RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_SYMPTOM_INTERVIEW_ID) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                pref.setSymptom_interview_id(interviewid);
                long a = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_7", "Are you overweight or obese?", "true", "0", date, "FragmentBasicQuestion");
                long b = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_28", "Do you smoke cigarettes?", "true", "0", date, "FragmentBasicQuestion");
                long c = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_10", "Do you have high cholesterol?", "true", "0", date, "FragmentBasicQuestion");
                long d = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_9", "Do you have hypertension?", "true", "0", date, "FragmentBasicQuestion");
                long e = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", "p_8", "Do you have diabetes?", "true", "0", date, "FragmentBasicQuestion");
                replaceFragment(new FragmentBasicQuestion(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
            } else {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
