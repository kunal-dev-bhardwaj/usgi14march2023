package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class FragmentExercise extends Fragment {
    private View v;
    private TextView ques;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private String selected_choice;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_exercise, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        db = new LifestyleHRADatabaseHelper(getActivity());
        init();
        return v;
    }

    private void init() {
        Button previous = v.findViewById(R.id.previous);
        Button next = v.findViewById(R.id.next);
        RadioGroup exercise = v.findViewById(R.id.exercise);
        ques =  v.findViewById(R.id.ques);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(15);

        boolean check_exercise = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentExercise");
        if (check_exercise) {
            String answer_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentExercise");
            if (answer_code.equalsIgnoreCase("6_PHYEXEALW")) {
                selected_choice = "Always";
                exercise.check(R.id.always);
            } else if (answer_code.equalsIgnoreCase("6_PHYEXEMSTWEEK")) {
                selected_choice = "Usually";
                exercise.check(R.id.usually);
            } else if (answer_code.equalsIgnoreCase("6_PHYEXERARE")) {
                selected_choice = "Sometimes";
                exercise.check(R.id.sometimes);
            } else {
                selected_choice = "Never";
                exercise.check(R.id.never);
            }
        } else {
            exercise.clearCheck();
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentWorkShift();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        exercise.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    selected_choice = (String) rb.getText();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected_choice == null) {
                    Toast.makeText(getActivity(), "Please select a value", Toast.LENGTH_SHORT).show();
                } else {
                    boolean check_exercise = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentExercise");
                    if (check_exercise) {
                        if (selected_choice.equalsIgnoreCase("Always")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXEALW", "", "", "", "yes", "FragmentExercise");
                        } else if (selected_choice.equalsIgnoreCase("Usually")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXEMSTWEEK", "", "", "", "yes", "FragmentExercise");
                        } else if (selected_choice.equalsIgnoreCase("Sometimes")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXERARE", "", "", "", "yes", "FragmentExercise");
                        } else if (selected_choice.equalsIgnoreCase("Never")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXENEVER", "", "", "", "yes", "FragmentExercise");
                        }
                    } else {
                        if (selected_choice.equalsIgnoreCase("Always")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXEALW", "", "", "", "yes", "FragmentExercise");
                        } else if (selected_choice.equalsIgnoreCase("Usually")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXEMSTWEEK", "", "", "", "yes", "FragmentExercise");
                        } else if (selected_choice.equalsIgnoreCase("Sometimes")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXERARE", "", "", "", "yes", "FragmentExercise");
                        } else if (selected_choice.equalsIgnoreCase("Never")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "16", ques.getText().toString(), "PHYEXER", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYEXENEVER", "", "", "", "yes", "FragmentExercise");
                        }
                    }

                    Fragment frag = new FragmentSleep();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });
    }
}
