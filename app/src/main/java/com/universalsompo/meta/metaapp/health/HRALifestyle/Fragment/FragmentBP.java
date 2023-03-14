package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.Objects;

import params.com.stepprogressview.StepProgressView;

public class FragmentBP extends Fragment {
    private View v;
    private EditText edt_systolic, edt_diastolic;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private Context mContext;
    private LinearLayout allizhealth_txt, button;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bp, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getActivity().getCurrentFocus();
        if (view == null) {
            view = new View(getActivity());
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        pref = MySharedPreference.getInstance(getActivity());
        db = new LifestyleHRADatabaseHelper(getActivity());
        mContext = getActivity();
        init();

        final View activityRootView = getActivity().findViewById(R.id.content_main1);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(mContext, 200)) { // if more than 200 dp, it's probably a keyboard...
                    button.setVisibility(View.GONE);
                    allizhealth_txt.setVisibility(View.GONE);
                } else {
                    button.setVisibility(View.VISIBLE);
                    allizhealth_txt.setVisibility(View.VISIBLE);
                }
            }
        });
        return v;
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    private void init() {
        edt_systolic = v.findViewById(R.id.edt_systolic);
        edt_diastolic = v.findViewById(R.id.edt_diastolic);
        Button previous = v.findViewById(R.id.previous);
        Button next = v.findViewById(R.id.next);
        TextView dont_know = v.findViewById(R.id.dont_know);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        button =  v.findViewById(R.id.button);
        allizhealth_txt =  v.findViewById(R.id.allizhealth_txt);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(2);

        boolean check_bp = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentBP");
        if (check_bp) {
            String systolic = db.getLifestyleCol1Value(pref.getUID(), "FragmentBP");
            String diastolic = db.getLifestyleCol2Value(pref.getUID(), "FragmentBP");

            if (systolic.equalsIgnoreCase("0")) {
                edt_systolic.setText("");
            } else {
                edt_systolic.setText(systolic);
            }

            if (diastolic.equalsIgnoreCase("0")) {
                edt_diastolic.setText("");
            } else {
                edt_diastolic.setText(diastolic);
            }
        } else {
            edt_systolic.setText("");
            edt_diastolic.setText("");
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_systolic.getText().toString().isEmpty() || edt_systolic.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter systolic", Toast.LENGTH_SHORT).show();
                } else if (edt_diastolic.getText().toString().isEmpty() || edt_diastolic.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter diastolic", Toast.LENGTH_SHORT).show();
                } else {
                    boolean check_bp = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentBP");
                    if (check_bp) {
                        db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "3", "", "KNWBPNUM", edt_systolic.getText().toString(), edt_diastolic.getText().toString(), "0", "0", "0", "true", "BPSCREEN", "86_YES", "", "", "", "yes", "FragmentBP");
                    } else {
                        db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "3", "", "KNWBPNUM", edt_systolic.getText().toString(), edt_diastolic.getText().toString(), "0", "0", "0", "true", "BPSCREEN", "86_YES", "", "", "", "yes", "FragmentBP");
                    }
                    Fragment frag = new FragmentBloodSugar();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });

        dont_know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check_bp = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentBP");
                if (check_bp) {
                    db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "3", "", "KNWBPNUM", "180", "90", "0", "0", "0", "false", "BPSCREEN", "86_NO", "", "", "", "yes", "FragmentBP");
                } else {
                    db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "3", "", "KNWBPNUM", "180", "90", "0", "0", "0", "false", "BPSCREEN", "86_NO", "", "", "", "yes", "FragmentBP");
                }
                Fragment frag = new FragmentBloodSugar();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentWHR();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });
    }
}
