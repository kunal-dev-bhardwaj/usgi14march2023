package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
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
import com.universalsompo.meta.metaapp.health.HRALifestyle.APIRequest.SaveHRA;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.Objects;

import params.com.stepprogressview.StepProgressView;

public class FragmentSocialLife extends Fragment {
    private View v;
    private TextView ques;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private String selected_choice;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_social_life, container, false);
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
        RadioGroup social_ties = v.findViewById(R.id.social_ties);
        ques =  v.findViewById(R.id.ques);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(19);

        boolean check_social_ties = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentSocialLife");
        if (check_social_ties) {
            String answer_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentSocialLife");
            if (answer_code.equalsIgnoreCase("7_SOCSYSLOTFRD")) {
                selected_choice = "Very Strong";
                social_ties.check(R.id.very_strong);
            } else if (answer_code.equalsIgnoreCase("7_SOCSYSTLKFRD")) {
                selected_choice = "Above Average";
                social_ties.check(R.id.above_average);
            } else if (answer_code.equalsIgnoreCase("7_SOCSYSRARFRD")) {
                selected_choice = "Below Average";
                social_ties.check(R.id.below_average);
            } else {
                selected_choice = "Not Sure";
                social_ties.check(R.id.not_sure);
            }
        } else {
            social_ties.clearCheck();
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentStress();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        social_ties.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                    boolean check_social_ties = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentSocialLife");
                    if (check_social_ties) {
                        if (selected_choice.equalsIgnoreCase("Very Strong")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSLOTFRD", "", "", "", "yes", "FragmentSocialLife");
                        } else if (selected_choice.equalsIgnoreCase("Above Average")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSTLKFRD", "", "", "", "yes", "FragmentSocialLife");
                        } else if (selected_choice.equalsIgnoreCase("Below Average")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSRARFRD", "", "", "", "yes", "FragmentSocialLife");
                        } else if (selected_choice.equalsIgnoreCase("Not Sure")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSDONTFRD", "", "", "", "yes", "FragmentSocialLife");
                        }
                    } else {
                        if (selected_choice.equalsIgnoreCase("Very Strong")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSLOTFRD", "", "", "", "yes", "FragmentSocialLife");
                        } else if (selected_choice.equalsIgnoreCase("Above Average")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSTLKFRD", "", "", "", "yes", "FragmentSocialLife");
                        } else if (selected_choice.equalsIgnoreCase("Below Average")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSRARFRD", "", "", "", "yes", "FragmentSocialLife");
                        } else if (selected_choice.equalsIgnoreCase("Not Sure")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "20", ques.getText().toString(), "SOCSYSTM", "0", "0", "0", "0", "0", "0", "SOCIAL", "7_SOCSYSDONTFRD", "", "", "", "yes", "FragmentSocialLife");
                        }
                    }

                    SaveHRA save_hra = new SaveHRA(getActivity());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        save_hra.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    } else {
                        save_hra.execute();
                    }
                }
            }
        });
    }
}
