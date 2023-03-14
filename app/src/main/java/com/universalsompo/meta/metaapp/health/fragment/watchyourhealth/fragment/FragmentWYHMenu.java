package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataType;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.fragment.FragmentBloodPressureChart;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.fragment.FragmentBloodSugarChart;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentStats;
import com.universalsompo.meta.metaapp.health.fragment.todayexercise.FragmentFitnessTrackerMenu;
import com.universalsompo.meta.metaapp.health.fragment.todayexercise.FragmentTodayExerciseTab;
import com.universalsompo.meta.metaapp.health.fragment.watertracking.fragment.WaterIntakeMainTab;
import com.universalsompo.meta.metaapp.health.fragment.weightlog.fragment.FragmentLogWeight;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import java.util.Objects;

public class FragmentWYHMenu extends Fragment implements View.OnClickListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference pref;
    private View activityRootView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_wyh_menu, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).remove_elevation();
        activityRootView = v.findViewById(R.id.main_layout);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi") @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(Objects.requireNonNull(getContext()))) { // if more than 200 dp, it's probably a keyboard...
                    InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                }
                // Once data has been obtained, this listener is no longer needed, so remove it...
                activityRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        pref = MySharedPreference.getInstance(getActivity());
        initView();
        return v;
    }

    private static float dpToPx(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 200, metrics);
    }

    private void initView() {
        LinearLayout layout_log_steps = v.findViewById(R.id.layout_log_steps);
        LinearLayout layout_log_water = v.findViewById(R.id.layout_log_water);
        LinearLayout layout_log_weight = v.findViewById(R.id.layout_log_weight);
        LinearLayout layout_log_blood_sugar = v.findViewById(R.id.layout_log_blood_sugar);
        LinearLayout layout_log_blood_pressure = v.findViewById(R.id.layout_log_blood_pressure);
        LinearLayout layout_log_lipid_profile = v.findViewById(R.id.layout_log_lipid_profile);
        LinearLayout wyh_hra = v.findViewById(R.id.wyh_hra);
        LinearLayout wyh_upload_doc = v.findViewById(R.id.wyh_upload_doc);
        LinearLayout wyh_redeem_points = v.findViewById(R.id.wyh_redeem_points);
        LinearLayout wyh_transaction_history = v.findViewById(R.id.wyh_transaction_history);

        layout_log_steps.setOnClickListener(this);
        layout_log_water.setOnClickListener(this);
        layout_log_weight.setOnClickListener(this);
        layout_log_blood_sugar.setOnClickListener(this);
        layout_log_blood_pressure.setOnClickListener(this);
        layout_log_lipid_profile.setOnClickListener(this);
        wyh_hra.setOnClickListener(this);
        wyh_upload_doc.setOnClickListener(this);
        wyh_redeem_points.setOnClickListener(this);
        wyh_transaction_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.layout_log_steps :
                checkIfLoggedIn();
                break;

            case R.id.layout_log_water :
                replaceFragment(new WaterIntakeMainTab(), FragmentsHealthTags.FRAGMENT_WATER_TRACKING);
                break;

            case R.id.layout_log_weight :
                Fragment frag = new FragmentLogWeight();
                if (pref.getweight() != null) {
                    Bundle args = new Bundle();
                    args.putString("previous_weight", pref.getweight());
                    frag.setArguments(args);
                } else {
                    Bundle args = new Bundle();
                    args.putString("previous_weight", "0");
                    frag.setArguments(args);
                }
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_WEIGHT_LOG);
                break;

            case R.id.layout_log_blood_sugar :
                replaceFragment(new FragmentBloodSugarChart(), FragmentsHealthTags.FRAGMENT_BLOOD_SUGAR);
                break;

            case R.id.layout_log_blood_pressure :
                replaceFragment(new FragmentBloodPressureChart(), FragmentsHealthTags.FRAGMENT_BLOOD_PRESSURE);
                break;

            case R.id.layout_log_lipid_profile:
                replaceFragment1(new FragmentStats());
                break;

            case R.id.wyh_hra :
                replaceFragment(new FragmentWYHHra(), FragmentsHealthTags.FRAGMENT_WYH_HRA);
                break;

            case R.id.wyh_upload_doc :
                replaceFragment(new FragmentWYHUpload(), FragmentsHealthTags.FRAGMENT_UPLOAD_DOC);
                break;

            case R.id.wyh_redeem_points:
                replaceFragment(new FragmentWYHRedeemPoints(), FragmentsHealthTags.FRAGMENT_REDEEM_POINTS);
                break;

            case R.id.wyh_transaction_history:
                replaceFragment(new FragmentTransactionHistory(), FragmentsHealthTags.FRAGMENT_TRANSACTION_HISTORY);
                break;
        }
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

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void replaceFragment1(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("open_lipid_profile", "1");
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_STATS);
            binder.detect(FragmentsHealthTags.FRAGMENT_STATS);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkIfLoggedIn() {
        FitnessOptions fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .build();
        if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(Objects.requireNonNull(getActivity())), fitnessOptions)) {
            replaceFragment(new FragmentTodayExerciseTab(), FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE);
        } else if (pref.getFibitUserId()!=null){
            replaceFragment(new FragmentTodayExerciseTab(), FragmentsHealthTags.FRAGMENT_TODAY_EXERCISE);
        } else {
            replaceFragment3(new FragmentFitnessTrackerMenu());
        }
    }

    private void replaceFragment3(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("from", "1");
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_FITNESS_TRACKER_MENU);
            binder.detect(FragmentsHealthTags.FRAGMENT_FITNESS_TRACKER_MENU);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
