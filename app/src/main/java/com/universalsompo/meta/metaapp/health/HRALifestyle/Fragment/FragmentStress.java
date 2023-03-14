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

public class FragmentStress extends Fragment {
    private View v;
    private TextView ques;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private String selected_choice;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_stress, container, false);
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
        RadioGroup stress = v.findViewById(R.id.stress);
        ques =  v.findViewById(R.id.ques);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(18);

        boolean check_stress = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentStress");
        if (check_stress) {
            String answer_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentStress");
            if (answer_code.equalsIgnoreCase("6_PHYSTRYES")) {
                selected_choice = "Yes";
                stress.check(R.id.yes);
            } else {
                selected_choice = "No";
                stress.check(R.id.no);
            }
        } else {
            stress.clearCheck();
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentUserLife();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        stress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                    boolean check_stress = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentStress");
                    if (check_stress) {
                        if (selected_choice.equalsIgnoreCase("Yes")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "19", ques.getText().toString(), "PHYSTRES", "0", "0", "0", "0", "0", "0", "SOCIAL", "6_PHYSTRYES", "", "", "", "yes", "FragmentStress");
                        } else if (selected_choice.equalsIgnoreCase("No")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "19", ques.getText().toString(), "PHYSTRES", "0", "0", "0", "0", "0", "0", "SOCIAL", "6_PHYSTRNO", "", "", "", "yes", "FragmentStress");
                        }
                    } else {
                        if (selected_choice.equalsIgnoreCase("Yes")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "19", ques.getText().toString(), "PHYSTRES", "0", "0", "0", "0", "0", "0", "SOCIAL", "6_PHYSTRYES", "", "", "", "yes", "FragmentStress");
                        } else if (selected_choice.equalsIgnoreCase("No")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "19", ques.getText().toString(), "PHYSTRES", "0", "0", "0", "0", "0", "0", "SOCIAL", "6_PHYSTRNO", "", "", "", "yes", "FragmentStress");
                        }
                    }

                    Fragment frag = new FragmentSocialLife();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });
    }
}
