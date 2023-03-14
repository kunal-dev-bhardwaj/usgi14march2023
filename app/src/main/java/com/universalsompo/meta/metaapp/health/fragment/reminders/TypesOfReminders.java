package com.universalsompo.meta.metaapp.health.fragment.reminders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.suke.widget.SwitchButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.ConsultationReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodTypeDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.LabTestReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.MedicineReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WalkTypeDatasbaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WaterReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WeightReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WorkOutReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import java.util.Objects;

public class TypesOfReminders extends Fragment implements View.OnClickListener {
    private View myView;
    private SelectorListener binder;
    private SwitchButton switch1, switch2, switch3, switch4, switch5, switch6, switch7, switch8;
    private MySharedPreference pref;
    private FoodReminderDatabaseHelper db;
    private FoodTypeDatabaseHelper db1;
    private LabTestReminderDatabaseHelper db2;
    private ConsultationReminderDatabaseHelper db3;
    private WeightReminderDatabaseHelper db4;
    private WalkTypeDatasbaseHelper db5;
    private WorkOutReminderDatabaseHelper db6;
    private WaterReminderDatabaseHelper db7;
    private MedicineReminderDatabaseHelper db8;
    private TextView food_reminder_description;
    private TextView consultation_reminder_description;
    private TextView weight_reminder_description;
    private TextView walk_reminder_descriptiion;
    private TextView workout_reminder_description;
    private TextView water_reminder_description;
    private TextView medicine_reminder_description;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_reminder_types, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        setHasOptionsMenu(true);
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        pref = new MySharedPreference(getActivity());
        db = new FoodReminderDatabaseHelper(getActivity());
        db1 = new FoodTypeDatabaseHelper(getActivity());
        db2 = new LabTestReminderDatabaseHelper(getActivity());
        db3 = new ConsultationReminderDatabaseHelper(getActivity());
        db4 = new WeightReminderDatabaseHelper(getActivity());
        db5 = new WalkTypeDatasbaseHelper(getActivity());
        db6 = new WorkOutReminderDatabaseHelper(getActivity());
        db7 = new WaterReminderDatabaseHelper(getActivity());
        db8 = new MedicineReminderDatabaseHelper(getActivity());
        init();
        return myView;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        LinearLayout set_food_reminder = myView.findViewById(R.id.set_food_reminder);
        LinearLayout set_water_reminder = myView.findViewById(R.id.set_water_reminder);
        LinearLayout set_workout_reminder = myView.findViewById(R.id.set_workout_reminder);
        LinearLayout set_walk_reminder = myView.findViewById(R.id.set_walk_reminder);
        LinearLayout set_weight_reminder = myView.findViewById(R.id.set_weight_reminder);
        LinearLayout set_medicine_reminder = myView.findViewById(R.id.set_medicine_reminder);
        LinearLayout set_consultation_reminder = myView.findViewById(R.id.set_consultation_reminder);
        LinearLayout set_labtest_reminder = myView.findViewById(R.id.set_labtest_reminder);
        switch1 = myView.findViewById(R.id.switch1);
        switch2 = myView.findViewById(R.id.switch2);
        switch3 = myView.findViewById(R.id.switch3);
        switch4 = myView.findViewById(R.id.switch4);
        switch5 = myView.findViewById(R.id.switch5);
        switch6 = myView.findViewById(R.id.switch6);
        switch7 = myView.findViewById(R.id.switch7);
        switch8 = myView.findViewById(R.id.switch8);
        food_reminder_description =  myView.findViewById(R.id.food_reminder_description);
        TextView lab_test_reminder_description = myView.findViewById(R.id.lab_test_reminder_description);
        consultation_reminder_description =  myView.findViewById(R.id.consultation_reminder_description);
        weight_reminder_description =  myView.findViewById(R.id.weight_reminder_description);
        walk_reminder_descriptiion =  myView.findViewById(R.id.walk_reminder_description);
        workout_reminder_description =  myView.findViewById(R.id.workout_reminder_description);
        water_reminder_description =  myView.findViewById(R.id.water_reminder_description);
        medicine_reminder_description = myView.findViewById(R.id.med_reminder_description);

        int active_count = db4.getActiveCount(pref.getUID(), "active");
        if (active_count == 0) {
            db4.updateStatusofReminder(pref.getUID(), "Weight reminder", "deactive");
        } else {
            db4.updateStatusofReminder(pref.getUID(), "Weight reminder", "active");
        }

        int lab_test_count = db2.getCount(pref.getUID());
        int deactive_count = db2.getdeactiveCount(pref.getUID(), "deactive");
        if (lab_test_count == 0 || lab_test_count == deactive_count) {
            db2.updateStatusofReminder(pref.getUID(), "Lab test reminder", "deactive");
        } else {
            db2.updateStatusofReminder(pref.getUID(), "Lab test reminder", "active");
        }

        int consultation_count = db3.getCount(pref.getUID());
        int deactive_count1 = db3.getdeactiveCount(pref.getUID(), "deactive");
        if (consultation_count == 0 || consultation_count == deactive_count1) {
            db3.updateStatusofReminder(pref.getUID(), "Consultation reminder", "deactive");
        } else {
            db3.updateStatusofReminder(pref.getUID(), "Consultation reminder", "active");
        }

        boolean food_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Food reminder");
        if (food_reminder_available) {
            String food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder");
            if (food_status_remin.equalsIgnoreCase("deactive")) {
                switch1.setChecked(false);
                food_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_food_reminder));
            } else {
                int status_count = db1.getActiveStatus(pref.getUID(), "Food reminder", "active");
                switch1.setChecked(true);
                food_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.remind_me_txt)+" " + status_count + " "+getActivity().getResources().getString(R.string.times));
            }
        } else {
            switch1.setChecked(false);
            db.insertFoodReminder(pref.getUID(), "Food reminder", "deactive");
        }

        boolean weight_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Weight reminder");
        if (weight_reminder_available) {
            String weight_status_remin = db.getStatusofReminder(pref.getUID(), "Weight reminder");
            if (weight_status_remin.equalsIgnoreCase("deactive")) {
                switch5.setChecked(false);
                weight_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_weight_reminder));
            } else {
                switch5.setChecked(true);
                String week_month = db4.getWeeklyMonthlyReminder(pref.getUID(), "active");
                if (week_month.equalsIgnoreCase("Monthly")) {
                    weight_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.remind_me_once));
                } else {
                    weight_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.remind_me_once_week));
                }
            }
        } else {
            switch5.setChecked(false);
            db.insertFoodReminder(pref.getUID(), "Weight reminder", "deactive");
        }

        boolean walk_reminder_available = db5.CheckIsDataAlreadyInDBorNot(pref.getUID(), "Walk reminder");
        if (walk_reminder_available) {
            int walk_status_remin = db5.getStatusofReminder(pref.getUID());
            if (walk_status_remin==0) {
                switch3.setChecked(false);
                walk_reminder_descriptiion.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_walk_reminder));
            } else {
                switch3.setChecked(true);
                walk_reminder_descriptiion.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.remind_me_txt)+" " + walk_status_remin + " "+getActivity().getResources().getString(R.string.times));
            }
        }
        else {
            switch3.setChecked(false);
            walk_reminder_descriptiion.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_walk_reminder));
        }

        boolean work_reminder_available = db6.CheckIsDataAlreadyInDBorNot(pref.getUID(), "Workout reminder");
        if (work_reminder_available) {
            int workout_status_remin = db6.getStatusofReminder(pref.getUID());
            if (workout_status_remin==0) {
                switch4.setChecked(false);
                workout_reminder_description.setText(getActivity().getResources().getString(R.string.set_workout_reminder));
            } else {
                switch4.setChecked(true);
                workout_reminder_description.setText(getActivity().getResources().getString(R.string.remind_me_txt)+" " + workout_status_remin + " "+getActivity().getResources().getString(R.string.times));
            }
        }
        else {
            switch4.setChecked(false);
            workout_reminder_description.setText(getActivity().getResources().getString(R.string.set_workout_reminder));
        }

        boolean water_reminder_available = db7.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Water Reminder","interval");
        if (water_reminder_available){
            String water_status_remin = db7.getStatusofReminder(pref.getUID(), "Water Reminder","interval");
            if (water_status_remin.equalsIgnoreCase("active")){
                int water_status_count = db7.getStatusofReminder(pref.getUID());
                switch2.setChecked(true);
                water_reminder_description.setText(water_status_count + " "+getActivity().getResources().getString(R.string.reminder_set_txt));
            }else {
                switch2.setChecked(false);
                water_reminder_description.setText(getActivity().getResources().getString(R.string.set_water_reminder));
            }
        }  else {
            switch2.setChecked(false);
            water_reminder_description.setText(getActivity().getResources().getString(R.string.set_water_reminder));
            db7.updateNoofTimeReminder(pref.getUID(),"Water Reminder","interval","","deactive");
        }

        boolean consultation_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Consultation reminder");
        if (consultation_reminder_available) {
            String consultation_status_remin = db.getStatusofReminder(pref.getUID(), "Consultation reminder");
            if (consultation_status_remin.equalsIgnoreCase("deactive")) {
                switch7.setChecked(false);
                consultation_reminder_description.setText(getActivity().getResources().getString(R.string.set_consultation_reminder));
            } else {
                int consultation_status_count = db3.getCount(pref.getUID());
                if (consultation_status_count==0) switch7.setChecked(false);
                else switch7.setChecked(true);
                consultation_reminder_description.setText(consultation_status_count + " "+getActivity().getResources().getString(R.string.reminder_set_txt));
            }
        } else {
            switch7.setChecked(false);
            db.insertFoodReminder(pref.getUID(), "Consultation reminder", "deactive");
        }

        boolean lab_test_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Lab test reminder");
        if (lab_test_reminder_available) {
            String lab_test_status_remin = db.getStatusofReminder(pref.getUID(), "Lab test reminder");
            if (lab_test_status_remin.equalsIgnoreCase("deactive")) {
                switch8.setChecked(false);
                lab_test_reminder_description.setText(getActivity().getResources().getString(R.string.set_lab_test_reminder));
            } else {
                int lab_test_status_count = db2.getCount(pref.getUID());
                if (lab_test_status_count==0){
                    switch8.setChecked(false);
                    lab_test_reminder_description.setText(getActivity().getResources().getString(R.string.set_lab_test_reminder));
                }else{
                    switch8.setChecked(true);
                    lab_test_reminder_description.setText(lab_test_status_count + " "+getActivity().getResources().getString(R.string.reminder_set_txt));
                }
            }
        } else {
            switch8.setChecked(false);
            db.insertFoodReminder(pref.getUID(), "Lab test reminder", "deactive");
        }

        boolean med_reminder_available = db8.CheckIsDataAlreadyInDBorNot(pref.getUID());
        if (med_reminder_available) {
            String med_status_remin = db8.getStatusofReminder(pref.getUID());
            if (med_status_remin.equalsIgnoreCase("deactive")) {
                switch6.setChecked(false);
                medicine_reminder_description.setText(getActivity().getResources().getString(R.string.set_medicine_reminder));
            } else {
                int lab_test_status_count = db8.getCount(pref.getUID());
                switch6.setChecked(true);
                medicine_reminder_description.setText(lab_test_status_count + " "+getActivity().getResources().getString(R.string.reminder_set_txt));
            }
        } else {
            switch6.setChecked(false);
            db8.updateStatusofReminder(pref.getUID(), "Medicine reminder", "deactive");
        }

        switch1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if (switch1.isChecked()) {
                    db.updateStatusofReminder(pref.getUID(), "Food reminder", "active");
                    replaceFragment(new FragmentFoodReminder(), FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
                } else {
                    food_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_food_reminder));
                    db.updateStatusofReminder(pref.getUID(), "Food reminder", "deactive");
                    db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Early Morning", "",  "deactive");
                    db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Breakfast", "",  "deactive");
                    db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Lunch", "",  "deactive");
                    db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks", "",  "deactive");
                    db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Dinner", "",  "deactive");
                }
            }
        });

        switch3.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if (switch3.isChecked()) {
                    db5.updateStatusofReminder(pref.getUID(), "Walk reminder", "active");
                    replaceFragment(new FragmentWalkReminder(), FragmentsHealthTags.FRAGMENT_WALK_REMINDER);
                } else {
                    walk_reminder_descriptiion.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_walk_reminder));
                    db.updateStatusofReminder(pref.getUID(), "Walk reminder", "deactive");
                    db5.updateStatusofReminder(pref.getUID(), "Walk reminder", "Morning", "", "deactive","");
                    db5.updateStatusofReminder(pref.getUID(), "Walk reminder", "Evening", "", "deactive","");
                }
            }
        });

        switch2.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch2.isChecked()) {
                    db7.updateStatusofReminder(pref.getUID(), "Water reminder", "active");
                    replaceFragment(new FragmentWaterReminder(), FragmentsHealthTags.FRAGMENT_WATER_REMINDER);
                } else {
                    water_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_water_reminder));
                    db.updateStatusofReminder(pref.getUID(), "Water reminder", "deactive");
                    db7.updateNoofTimeReminder(pref.getUID(),"Water Reminder","interval","","deactive");
                }
            }
        });

        switch4.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if (switch4.isChecked()) {
                    db6.updateStatusofReminder(pref.getUID(), "Workout reminder", "active");
                    replaceFragment(new FragmentWorkoutReminder(), FragmentsHealthTags.FRAGMENT_WORKOUT_REMINDER);
                } else {
                    workout_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_workout_reminder));
                    db.updateStatusofReminder(pref.getUID(), "Workout reminder", "deactive");
                    db6.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                    db6.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                }
            }
        });

        switch5.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if (switch5.isChecked()) {
                    db.updateStatusofReminder(pref.getUID(), "Weight reminder", "active");
                    replaceFragment(new FragmentWeightReminder(), FragmentsHealthTags.FRAGMENT_WEIGHT_REMINDER);
                } else {
                    weight_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_weight_reminder));
                    db.updateStatusofReminder(pref.getUID(), "Weight reminder", "deactive");
                    db4.updateStatusofReminder(pref.getUID(), "deactive");
                }
            }
        });

        switch6.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if (switch6.isChecked()) {
                    db8.updateStatusofReminder(pref.getUID(), "Medicine reminder", "active");
                    replaceFragment(new FragmentMedicineReminder(), FragmentsHealthTags.FRAGMENT_MEDICINE_REMINDER);
                } else {
                    medicine_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_medicine_reminder));
                    db8.updateStatusofReminder(pref.getUID(), "deactive");
                }
            }
        });

        switch7.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if (switch7.isChecked()) {
                    db.updateStatusofReminder(pref.getUID(), "Consultation reminder", "active");
                    replaceFragment(new FragmentConsultationReminder(), FragmentsHealthTags.FRAGMENT_CONSULTATION_REMINDER);
                } else {
                    consultation_reminder_description.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_consultation_reminder));
                    db.updateStatusofReminder(pref.getUID(), "Consultation reminder", "deactive");
                    db3.updateStatusofReminder(pref.getUID(), "deactive");
                }
            }
        });

        switch8.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
                if (switch8.isChecked()) {
                    db.updateStatusofReminder(pref.getUID(), "Lab test reminder", "active");
                    replaceFragment(new FragmentLabTestReminder(), FragmentsHealthTags.FRAGMENT_LAB_TEST_REMINDER);
                } else {
                    db.updateStatusofReminder(pref.getUID(), "Lab test reminder", "deactive");
                    db2.updateStatusofReminder(pref.getUID(), "deactive");
                }
            }
        });

        set_food_reminder.setOnClickListener(this);
        set_water_reminder.setOnClickListener(this);
        set_workout_reminder.setOnClickListener(this);
        set_walk_reminder.setOnClickListener(this);
        set_weight_reminder.setOnClickListener(this);
        set_medicine_reminder.setOnClickListener(this);
        set_consultation_reminder.setOnClickListener(this);
        set_labtest_reminder.setOnClickListener(this);
    }

    private void replaceFragment(Fragment frag, String Tag) {
        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
        binder.detect(Tag);
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
            case R.id.set_food_reminder:
                replaceFragment(new FragmentFoodReminder(), FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
                break;

            case R.id.set_water_reminder:
                replaceFragment(new FragmentWaterReminder(), FragmentsHealthTags.FRAGMENT_WATER_REMINDER);
                break;

            case R.id.set_workout_reminder:
                replaceFragment(new FragmentWorkoutReminder(), FragmentsHealthTags.FRAGMENT_WORKOUT_REMINDER);
                break;

            case R.id.set_walk_reminder:
                replaceFragment(new FragmentWalkReminder(), FragmentsHealthTags.FRAGMENT_WALK_REMINDER);
                break;

            case R.id.set_weight_reminder:
                replaceFragment(new FragmentWeightReminder(), FragmentsHealthTags.FRAGMENT_WEIGHT_REMINDER);
                break;

            case R.id.set_medicine_reminder:
                replaceFragment(new FragmentMedicineReminder(), FragmentsHealthTags.FRAGMENT_MEDICINE_REMINDER);
                break;

            case R.id.set_consultation_reminder:
                replaceFragment(new FragmentConsultationReminder(), FragmentsHealthTags.FRAGMENT_CONSULTATION_REMINDER);
                break;

            case R.id.set_labtest_reminder:
                replaceFragment(new FragmentLabTestReminder(), FragmentsHealthTags.FRAGMENT_LAB_TEST_REMINDER);
                break;
        }
    }
}
