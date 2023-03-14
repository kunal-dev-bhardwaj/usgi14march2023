package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
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
import com.universalsompo.meta.metaapp.health.HRALifestyle.APIRequest.CheckIfLoginNameExist;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentAlcohol;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentBMI;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentBP;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentBloodSugar;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentCholestrol;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentCigarettes;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentExercise;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentFamilyHealth;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentFriedFood;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentFruitServing;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentGeneralHealth;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentLaptopWorking;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentSleep;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentSocialLife;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentStress;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentUserLife;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWHR;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWorkBalance;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWorkShift;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment.FragmentWorking;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.LifestyleReportAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.LifestyleReportModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MYSharePrefLifestyleHRA;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class FragmentLifestyleReports extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference pref;
    private MYSharePrefLifestyleHRA pref1;
    private LinearLayout first_time;
    private RelativeLayout second_time;
    private RecyclerView lifestyle_hra_list;
    private LinearLayout lifestyle_draft_hra;
    private ArrayList<LifestyleReportModel> data = new ArrayList<>();
    private LifestyleHRADatabaseHelper db;
    private LifestyleResultDatabaseHelper db1;
    private Dialog alert_dialog;

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
        v = inflater.inflate(R.layout.fragment_lifestyle_reports, container, false);
        setHasOptionsMenu(true);
        pref = MySharedPreference.getInstance(getActivity());
        pref1 = MYSharePrefLifestyleHRA.getInstance(getActivity());
        db = new LifestyleHRADatabaseHelper(getActivity());
        db1 = new LifestyleResultDatabaseHelper(getActivity());
        init();
        return v;
    }

    private void init() {
        first_time = v.findViewById(R.id.first_time);
        LinearLayout start_hra = v.findViewById(R.id.start_hra);
        second_time = v.findViewById(R.id.second_time);
        lifestyle_hra_list = v.findViewById(R.id.lifestyle_hra_list);
        LinearLayout participate_hra = v.findViewById(R.id.participate_hra);
        LinearLayout continue_button = v.findViewById(R.id.continue_button);
        LinearLayout discard_button = v.findViewById(R.id.discard_button);
        lifestyle_draft_hra = v.findViewById(R.id.lifestyle_draft_hra);

        getlifestylereport();

        int no_of_interview = db.getLifestyleCount();
        boolean result_true = db1.CheckIsAuthTokenDataAlreadyInDBorNot(pref.getUID(), pref.getsessionid());
        if (result_true) {
            lifestyle_draft_hra.setVisibility(View.GONE);
        } else {
            if (no_of_interview == 0) {
                lifestyle_draft_hra.setVisibility(View.GONE);
            } else {
                lifestyle_draft_hra.setVisibility(View.VISIBLE);
            }
        }

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Reports page","User resumed his draft HRA");
                pref1.setHitLifestyleAPI("false");
                String frag_name = db.getLastRowFragmentName(pref.getUID());
                if (frag_name.equalsIgnoreCase("FragmentBMI")) {
                    replaceFragment(new FragmentBMI());
                } else if (frag_name.equalsIgnoreCase("FragmentWHR")) {
                    replaceFragment(new FragmentWHR());
                } else if (frag_name.equalsIgnoreCase("FragmentBP")) {
                    replaceFragment(new FragmentBP());
                } else if (frag_name.equalsIgnoreCase("FragmentBloodSugar")) {
                    replaceFragment(new FragmentBloodSugar());
                } else if (frag_name.equalsIgnoreCase("FragmentCholestrol")) {
                    replaceFragment(new FragmentCholestrol());
                } else if (frag_name.equalsIgnoreCase("FragmentAlcohol")) {
                    replaceFragment(new FragmentAlcohol());
                } else if (frag_name.equalsIgnoreCase("FragmentCigarettes")) {
                    replaceFragment(new FragmentCigarettes());
                } else if (frag_name.equalsIgnoreCase("FragmentFamilyHealth")) {
                    replaceFragment(new FragmentFamilyHealth());
                } else if (frag_name.equalsIgnoreCase("FragmentGeneralHealth")) {
                    replaceFragment(new FragmentGeneralHealth());
                } else if (frag_name.equalsIgnoreCase("FragmentFruitServing")) {
                    replaceFragment(new FragmentFruitServing());
                } else if (frag_name.equalsIgnoreCase("FragmentFriedFood")) {
                    replaceFragment(new FragmentFriedFood());
                } else if (frag_name.equalsIgnoreCase("FragmentWorkBalance")) {
                    replaceFragment(new FragmentWorkBalance());
                } else if (frag_name.equalsIgnoreCase("FragmentWorking")) {
                    replaceFragment(new FragmentWorking());
                } else if (frag_name.equalsIgnoreCase("FragmentLaptopWorking")) {
                    replaceFragment(new FragmentLaptopWorking());
                } else if (frag_name.equalsIgnoreCase("FragmentWorkShift")) {
                    replaceFragment(new FragmentWorkShift());
                } else if (frag_name.equalsIgnoreCase("FragmentExercise")) {
                    replaceFragment(new FragmentExercise());
                } else if (frag_name.equalsIgnoreCase("FragmentSleep")) {
                    replaceFragment(new FragmentSleep());
                } else if (frag_name.equalsIgnoreCase("FragmentUserLife")) {
                    replaceFragment(new FragmentUserLife());
                } else if (frag_name.equalsIgnoreCase("FragmentStress")) {
                    replaceFragment(new FragmentStress());
                } else if (frag_name.equalsIgnoreCase("FragmentSocialLife")) {
                    replaceFragment(new FragmentSocialLife());
                }
            }
        });

        discard_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Reports page","User discarded his draft HRA");
                lifestyle_draft_hra.setVisibility(View.GONE);
                Objects.requireNonNull(getActivity()).deleteDatabase("lifestyle_hra_db");
                Toast.makeText(getActivity(), "Discarded Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        participate_hra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result_true = db.doesDatabaseExist(Objects.requireNonNull(getContext()),"lifestyle_hra_db");
                if (result_true) {
                    openconfirmationdialog();
                } else {
                    new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Reports page","User instialized a new lifestyle HRA");
                    CheckIfLoginNameExist checkforloginname = new CheckIfLoginNameExist(getContext());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        checkforloginname.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    } else {
                        checkforloginname.execute();
                    }
                }
            }
        });

        start_hra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Reports page","User instialized a new lifestyle HRA");
                CheckIfLoginNameExist checkforloginname = new CheckIfLoginNameExist(getContext());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    checkforloginname.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    checkforloginname.execute();
                }
            }
        });
    }

    private void getlifestylereport() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_LIFESTYLE_REPORT, this, RequestHealthConstants.GET_LIFESTYLE_REPORT);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_LIFESTYLE_REPORT) {
            new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Reports page","User loaded all his previous HRA reports");
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
                                new LifestyleReportModel(
                                        obj.optString("Date"),
                                        obj.optString("FileName"),
                                        obj.optString("FilePath")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    lifestyle_hra_list.setLayoutManager(layoutManager);
                    LifestyleReportAdapter reportAdapter = new LifestyleReportAdapter(getActivity(), data);
                    lifestyle_hra_list.setAdapter(reportAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                int no_of_data = db.getLifestyleCount();
                if (no_of_data != 0) {
                    first_time.setVisibility(View.GONE);
                    second_time.setVisibility(View.VISIBLE);
                } else {
                    first_time.setVisibility(View.VISIBLE);
                    second_time.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

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
                new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","Reports page","User instialized a new lifestyle HRA");
                alert_dialog.dismiss();
                Objects.requireNonNull(getActivity()).deleteDatabase("lifestyle_hra_db");
                CheckIfLoginNameExist checkforloginname = new CheckIfLoginNameExist(getContext());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    checkforloginname.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    checkforloginname.execute();
                }
            }
        });

        alert_dialog.show();
    }

    private void replaceFragment(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_LIFESTYLE_HRA);
            binder.detect(FragmentsHealthTags.FRAGMENT_LIFESTYLE_HRA);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private List<LifestyleReportModel> reverseListOrder(List<LifestyleReportModel> status)
    {
        Iterator<LifestyleReportModel> it = status.iterator();
        List<LifestyleReportModel> destination = new ArrayList<>();
        while (it.hasNext()) {
            destination.add(0, it.next());
            it.remove();
        }
        return destination;
    }
}
