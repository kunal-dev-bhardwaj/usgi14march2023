package com.universalsompo.meta.metaapp.health.fragment.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.suke.widget.SwitchButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ConditionsDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.ResultDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.SelectedSympDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.TriageDatabaseHelper;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.LoginActivity;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentTermsCondition;
import com.universalsompo.meta.metaapp.motor.fragments.FratgmentPrivacyPolicy;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONObject;

import java.util.Objects;

public class FragmentSettings extends Fragment implements View.OnClickListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference pref;
    private TriageDatabaseHelper db;
    private SelectedSympDatabaseHelper db1;
    private ResultDatabaseHelper db2;
    private ConditionsDatabaseHelper db3;
    private BasicQuesDatabaseHelper db4;
    private LifestyleHRADatabaseHelper db5;
    private LifestyleResultDatabaseHelper db6;
    private SwitchButton notification_on_switch,notification_sound_switch;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_settings, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();

        db = new TriageDatabaseHelper(getActivity());
        db1 = new SelectedSympDatabaseHelper(getActivity());
        db2 = new ResultDatabaseHelper(getActivity());
        db3 = new ConditionsDatabaseHelper(getActivity());
        db4 = new BasicQuesDatabaseHelper(getActivity());
        db5 = new LifestyleHRADatabaseHelper(getActivity());
        db6 = new LifestyleResultDatabaseHelper(getActivity());
        init();
        return v;
    }

    private void init() {
        /*LinearLayout about_us = v.findViewById(R.id.about_us);*/
        LinearLayout terms_condition = v.findViewById(R.id.terms_condition);
        LinearLayout privacy_policy = v.findViewById(R.id.privacy_policy);
        LinearLayout logout = v.findViewById(R.id.logout);
        pref = MySharedPreference.getInstance(getActivity());
        notification_on_switch = v.findViewById(R.id.notification_on_switch);
        notification_sound_switch = v.findViewById(R.id.notification_sound_switch);
        LinearLayout notification = v.findViewById(R.id.notifications);
        LinearLayout notification_sound = v.findViewById(R.id.notification_sounds);
        if (pref.getNotificationOnOrOff()){
            notification_on_switch.setChecked(true);
        }else {
            notification_on_switch.setChecked(false);
        }
        if (pref.getNotificationSound()){
            notification_sound_switch.setChecked(true);
        }else {
            notification_sound_switch.setChecked(false);
        }

        // about_us.setOnClickListener(this);
        terms_condition.setOnClickListener(this);
        privacy_policy.setOnClickListener(this);
        logout.setOnClickListener(this);
        notification.setOnClickListener(this);
        notification_sound.setOnClickListener(this);
        notification_on_switch.setOnCheckedChangeListener((view, isChecked) -> {
            if (notification_on_switch.isChecked()){
                Enable();
            }else {
                Disable();
            }
        });
        notification_sound_switch.setOnCheckedChangeListener((view, isChecked) -> {
            if (notification_sound_switch.isChecked()){
                EnableSound();
            }else {
                DisableSound();
            }
        });
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            /*case R.id.about_us:
                new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User clicked on about us button");
                replaceFragment(new FragmentAboutUs(), FragmentsHealthTags.FRAGMENT_ABOUT_US);
                break;*/

            case R.id.terms_condition:
                new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User clicked on terms & condition button");
                replaceFragment(new FragmentTermsCondition(), FragmentsHealthTags.FRAGMENT_TERMS_CONDITION);
                break;

            case R.id.privacy_policy:
                new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User clicked on privacy policy button");
                replaceFragment(new FratgmentPrivacyPolicy(), FragmentsHealthTags.FRAGMENT_PRIVACY_POLICY);
                break;

            case R.id.logout:
                new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User logged out from the app");
                logout();
                break;

            case R.id.notification_sounds:
                if (notification_sound_switch.isChecked()){
                    notification_sound_switch.setChecked(false);
                    DisableSound();

                }else{
                    notification_sound_switch.setChecked(true);
                    EnableSound();
                }
                break;

            case R.id.notifications:
                if (notification_on_switch.isChecked()){
                    notification_on_switch.setChecked(false);
                    Disable();
                }else{
                    notification_on_switch.setChecked(true);
                    Enable();
                }
                break;
        }
    }

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void Enable(){
        new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User enabled notification");
        pref.addNotificationOnOrOff(true);
    }

    private void Disable(){
        new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User disabled notification");
        pref.addNotificationOnOrOff(false);
    }

    private void EnableSound(){
        new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User enabled notification sound");
        pref.addNotificationSound(true);
    }

    private void DisableSound(){
        new AppDataPushApi().callApi(getActivity(),"Settings","Settings page","User disabled notification sound");
        pref.addNotificationSound(false);
    }

    private void logout(){
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("userId", pref.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.URL_LOGOUT_USER, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Message").equals("Logout")) {
                    Toast.makeText(getActivity(),"Logged Out Successfully",Toast.LENGTH_SHORT).show();
                    db.deleteTriage(pref.getUID());
                    db1.deleteSelectedSymp(pref.getUID());
                    db2.deleteResult(pref.getUID());
                    db3.deleteCondition(pref.getUID());
                    db4.deleteBasicQuestion(pref.getUID());
                    db5.deleteLifestyleHRA(pref.getUID());
                    db6.deleteResultLifestyle(pref.getUID());
                    Objects.requireNonNull(getActivity()).deleteDatabase("consultation_reminder_db");
                    getActivity().deleteDatabase("food_reminder_db");
                    getActivity().deleteDatabase("food_type_reminder_db");
                    getActivity().deleteDatabase("lab_test_reminder_db");
                    getActivity().deleteDatabase("medicine_reminder_db");
                    getActivity().deleteDatabase("walk_type_reminder_db");
                    getActivity().deleteDatabase("water_type_reminder_db");
                    getActivity().deleteDatabase("weight_reminder_db");
                    getActivity().deleteDatabase("workout_type_reminder_db");
                    MySharedPreference.getInstance(getActivity()).clearAll();
                    Intent in = new Intent(getActivity(), LoginActivity.class);
                    startActivity(in);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_LOGOUT_USER);
        req.execute();
    }
}