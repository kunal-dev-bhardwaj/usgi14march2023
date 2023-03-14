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

public class FragmentCigarettes extends Fragment {
    private View v;
    private TextView ques;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private String selected_choice;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_cigarettes, container, false);
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
        RadioGroup smoke = v.findViewById(R.id.smoke);
        ques =  v.findViewById(R.id.ques);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(6);

        boolean check_smoke = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentCigarettes");
        if (check_smoke) {
            String answer_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentCigarettes");
            if (answer_code.equalsIgnoreCase("86_NONE")) {
                selected_choice = "Do not smoke";
                smoke.check(R.id.no);
            } else if (answer_code.equalsIgnoreCase("SMKCNT12")) {
                selected_choice = "1 - 2 Cigarettes";
                smoke.check(R.id.one_two);
            } else if (answer_code.equalsIgnoreCase("SMKCNT34")) {
                selected_choice = "3 - 4 Cigarettes";
                smoke.check(R.id.three_four);
            } else {
                selected_choice = "More than 4 Cigarettes";
                smoke.check(R.id.more);
            }
        } else {
            smoke.clearCheck();
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentAlcohol();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        smoke.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                    boolean check_smoke = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentCigarettes");
                    if (check_smoke) {
                        if (selected_choice.equalsIgnoreCase("Do not smoke")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "HABIT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "86_NONE", "", "", "", "yes", "FragmentCigarettes");
                        } else if (selected_choice.equalsIgnoreCase("1 - 2 Cigarettes")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "SMOKECNT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "SMKCNT12", "", "", "", "yes", "FragmentCigarettes");
                        } else if (selected_choice.equalsIgnoreCase("3 - 4 Cigarettes")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "SMOKECNT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "SMKCNT34", "", "", "", "yes", "FragmentCigarettes");
                        } else if (selected_choice.equalsIgnoreCase("More than 4 Cigarettes")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "SMOKECNT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "SMKCNTGT4", "", "", "", "yes", "FragmentCigarettes");
                        }
                    } else {
                        if (selected_choice.equalsIgnoreCase("Do not smoke")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "HABIT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "86_NONE", "", "", "", "yes", "FragmentCigarettes");
                        } else if (selected_choice.equalsIgnoreCase("1 - 2 Cigarettes")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "SMOKECNT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "SMKCNT12", "", "", "", "yes", "FragmentCigarettes");
                        } else if (selected_choice.equalsIgnoreCase("3 - 4 Cigarettes")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "SMOKECNT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "SMKCNT34", "", "", "", "yes", "FragmentCigarettes");
                        } else if (selected_choice.equalsIgnoreCase("More than 4 Cigarettes")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "7", ques.getText().toString(), "SMOKECNT", "0", "0", "0", "0", "0", "0", "DEPENDENCY", "SMKCNTGT4", "", "", "", "yes", "FragmentCigarettes");
                        }
                    }

                    Fragment frag = new FragmentFamilyHealth();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });
    }
}
