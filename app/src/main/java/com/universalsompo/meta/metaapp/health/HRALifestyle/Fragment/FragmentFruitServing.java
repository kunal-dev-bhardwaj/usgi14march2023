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

public class FragmentFruitServing extends Fragment {
    private View v;
    private TextView ques;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private String selected_choice;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fruit_serving, container, false);
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
        RadioGroup fruits = v.findViewById(R.id.fruits);
        ques =  v.findViewById(R.id.ques);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(9);

        boolean check_fruits = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentFruitServing");
        if (check_fruits) {
            String answer_code = db.getLifestyleAnswerCodeValue(pref.getUID(), "FragmentFruitServing");
            if (answer_code.equalsIgnoreCase("12_NEV")) {
                selected_choice = "Never";
                fruits.check(R.id.never);
            } else if (answer_code.equalsIgnoreCase("12_SOM")) {
                selected_choice = "Sometimes";
                fruits.check(R.id.sometimes);
            } else if (answer_code.equalsIgnoreCase("12_USU")) {
                selected_choice = "Usually";
                fruits.check(R.id.usually);
            } else {
                selected_choice = "Always";
                fruits.check(R.id.always);
            }
        } else {
            fruits.clearCheck();
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentGeneralHealth();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        fruits.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                    boolean check_fruits = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentFruitServing");
                    if (check_fruits) {
                        if (selected_choice.equalsIgnoreCase("Never")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_NEV", "", "", "", "yes", "FragmentFruitServing");
                        } else if (selected_choice.equalsIgnoreCase("Sometimes")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_SOM", "", "", "", "yes", "FragmentFruitServing");
                        } else if (selected_choice.equalsIgnoreCase("Usually")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_USU", "", "", "", "yes", "FragmentFruitServing");
                        } else if (selected_choice.equalsIgnoreCase("Always")) {
                            db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_ALW", "", "", "", "yes", "FragmentFruitServing");
                        }
                    } else {
                        if (selected_choice.equalsIgnoreCase("Never")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_NEV", "", "", "", "yes", "FragmentFruitServing");
                        } else if (selected_choice.equalsIgnoreCase("Sometimes")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_SOM", "", "", "", "yes", "FragmentFruitServing");
                        } else if (selected_choice.equalsIgnoreCase("Usually")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_USU", "", "", "", "yes", "FragmentFruitServing");
                        } else if (selected_choice.equalsIgnoreCase("Always")) {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "10", ques.getText().toString(), "5FRUIT", "0", "0", "0", "0", "0", "0", "NUTRITION", "12_ALW", "", "", "", "yes", "FragmentFruitServing");
                        }
                    }

                    Fragment frag = new FragmentFriedFood();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });
    }
}
