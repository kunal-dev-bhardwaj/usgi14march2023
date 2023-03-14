package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.annotation.SuppressLint;
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

public class FragmentSleep extends Fragment {
    private View v;
    private TextView ques;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private String selected_choice;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_sleep, container, false);
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
        RadioGroup sleep = v.findViewById(R.id.sleep);
        ques =  v.findViewById(R.id.ques);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(16);

        boolean check_sleep = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentSleep");
        if (check_sleep) {
            String answer_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSleep");
            if (answer_code.equalsIgnoreCase("6_PHYSLPALL")) {
                selected_choice = "Always";
                sleep.check(R.id.always);
            } else if (answer_code.equalsIgnoreCase("6_PHYSLPMOST")) {
                selected_choice = "Usually";
                sleep.check(R.id.usually);
            } else if (answer_code.equalsIgnoreCase("6_PHYSLPHRDNGT")) {
                selected_choice = "Sometimes";
                sleep.check(R.id.sometimes);
            } else {
                selected_choice = "Never";
                sleep.check(R.id.never);
            }
        } else {
            sleep.clearCheck();
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentWorkShift();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        sleep.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                    boolean check_sleep = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentSleep");
                    if (check_sleep) {
                        if (selected_choice.equalsIgnoreCase("Always")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPALL", "", "", "", "yes", "FragmentSleep");
                        } else if (selected_choice.equalsIgnoreCase("Usually")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPMOST", "", "", "", "yes", "FragmentSleep");
                        } else if (selected_choice.equalsIgnoreCase("Sometimes")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPHRDNGT", "", "", "", "yes", "FragmentSleep");
                        } else if (selected_choice.equalsIgnoreCase("Never")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPMSTNGT", "", "", "", "yes", "FragmentSleep");
                        }
                    } else {
                        if (selected_choice.equalsIgnoreCase("Always")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPALL", "", "", "", "yes", "FragmentSleep");
                        } else if (selected_choice.equalsIgnoreCase("Usually")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPMOST", "", "", "", "yes", "FragmentSleep");
                        } else if (selected_choice.equalsIgnoreCase("Sometimes")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPHRDNGT", "", "", "", "yes", "FragmentSleep");
                        } else if (selected_choice.equalsIgnoreCase("Never")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "17", ques.getText().toString(), "PHYSLEEP", "0", "0", "0", "0", "0", "0", "PHYSICAL", "6_PHYSLPMSTNGT", "", "", "", "yes", "FragmentSleep");
                        }
                    }

                    Fragment frag = new FragmentUserLife();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });
    }
}
