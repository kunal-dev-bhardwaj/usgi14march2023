package com.universalsompo.meta.metaapp.health.fragment.reminders;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.suke.widget.SwitchButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.food.AlarmReceiverBreakfast;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.food.AlarmReceiverDinner;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.food.AlarmReceiverEarlyMorning;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.food.AlarmReceiverEveningSnacks;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.food.AlarmReceiverLunch;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodTypeDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import java.util.Calendar;
import java.util.Objects;

public class FragmentFoodReminder extends Fragment implements View.OnClickListener {
    private View myView;
    private static String TAG = "previousdata";
    private TextView early_morning_time, breakfast_time, lunch_time, evening_snacks_time, dinner_time;
    private SwitchButton switch1, switch2, switch3, switch4, switch5;
    MySharedPreference pref;
    FoodTypeDatabaseHelper db;
    FoodReminderDatabaseHelper db1;

    /* Early morning */
    Calendar early_morning_calSet;
    int early_morning_hour, early_morning_minute, early_morning_part1_int, early_morning_part2_int;
    String early_morning_time1, early_morning_part1, early_morning_part2, db_early_morning_time;
    String[] early_morning_split;
    int early_morning_hr, early_morning_min;

    /* Breakfast */
    Calendar breakfast_calSet;
    int breakfast_hour, breakfast_minute, breakfast_part1_int, breakfast_part2_int;
    String breakfast_time1, breakfast_part1, breakfast_part2, db_breakfast_time;
    String[] breakfast_split;
    int breakfast_hr, breakfast_min;

    /* Lunch */
    Calendar lunch_calSet;
    int lunch_hour, lunch_minute, lunch_part1_int, lunch_part2_int;
    String lunch_time1, lunch_part1, lunch_part2, db_lunch_time;
    String[] lunch_split;
    int lunch_hr, lunch_min;

    /* Evening snacks */
    Calendar evening_snacks_calSet;
    int evening_snacks_hour, evening_snacks_minute, evening_snacks_part1_int, evening_snacks_part2_int;
    String evening_snacks_time1, evening_snacks_part1, evening_snacks_part2, db_evening_snacks_time;
    String[] evening_snacks_split;
    int evening_snacks_hr, evening_snacks_min;

    /* Dinner */
    Calendar dinner_calSet;
    int dinner_hour, dinner_minute, dinner_part1_int, dinner_part2_int;
    String dinner_time1, dinner_part1, dinner_part2, db_dinner_time;
    String[] dinner_split;
    int dinner_hr, dinner_min;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_food_reminder, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        setHasOptionsMenu(true);
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        pref = new MySharedPreference(getActivity());
        db = new FoodTypeDatabaseHelper(getActivity());
        db1 = new FoodReminderDatabaseHelper(getActivity());
        init();
        return myView;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        LinearLayout set_reminder_early_morning = myView.findViewById(R.id.set_reminder_early_morning);
        LinearLayout set_reminder_breakfast = myView.findViewById(R.id.set_reminder_breakfast);
        LinearLayout set_reminder_lunch = myView.findViewById(R.id.set_reminder_lunch);
        LinearLayout set_reminder_evening_snack = myView.findViewById(R.id.set_reminder_evening_snack);
        LinearLayout set_reminder_dinner = myView.findViewById(R.id.set_reminder_dinner);

        early_morning_time =  myView.findViewById(R.id.early_morning_time);
        breakfast_time =  myView.findViewById(R.id.breakfast_time);
        lunch_time =  myView.findViewById(R.id.lunch_time);
        evening_snacks_time =  myView.findViewById(R.id.evening_snack_time);
        dinner_time =  myView.findViewById(R.id.dinner_time);

        switch1 = myView.findViewById(R.id.switch1);
        switch2 = myView.findViewById(R.id.switch2);
        switch3 = myView.findViewById(R.id.switch3);
        switch4 = myView.findViewById(R.id.switch4);
        switch5 = myView.findViewById(R.id.switch5);

        /* Early morning */
        boolean early_morning_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Food reminder", "Early Morning");
        if (early_morning_reminder_available) {
            String early_morning_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Early Morning");
            if (early_morning_food_status_remin.equalsIgnoreCase("active")) {
                switch1.setChecked(true);
            } else {
                switch1.setChecked(false);
            }
            early_morning_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Early Morning");
            if (early_morning_time1.length() !=0) {
                early_morning_split = early_morning_time1.split(":");
                early_morning_part1 = early_morning_split[0];
                early_morning_part2 = early_morning_split[1];
                early_morning_part1_int = Integer.parseInt(early_morning_part1);
                if (early_morning_part1_int >= 0 && early_morning_part1_int < 12) {
                    early_morning_time.setVisibility(View.VISIBLE);
                    early_morning_time.setText(initHour(Integer.parseInt(early_morning_part1))+":"+ early_morning_part2 + " AM");
                } else {
                    early_morning_time.setVisibility(View.VISIBLE);
                    early_morning_time.setText(initHour(Integer.parseInt(early_morning_part1))+":"+ early_morning_part2 + " PM");
                }
            } else {
                early_morning_time.setVisibility(View.GONE);
            }
        } else {
            switch1.setChecked(false);
            early_morning_time.setVisibility(View.GONE);
            db.insertFoodTypeReminder(pref.getUID(), "Food reminder", "Early Morning", "",  "deactive");
        }

        /* Breakfast */
        boolean breakfast_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Food reminder", "Breakfast");
        if (breakfast_reminder_available) {
            String breakfast_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Breakfast");
            if (breakfast_food_status_remin.equalsIgnoreCase("active")) {
                switch2.setChecked(true);
            } else {
                switch2.setChecked(false);
            }
            breakfast_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Breakfast");
            if (breakfast_time1.length() !=0) {
                breakfast_split = breakfast_time1.split(":");
                breakfast_part1 = breakfast_split[0];
                breakfast_part2 = breakfast_split[1];
                breakfast_part1_int = Integer.parseInt(breakfast_part1);
                if (breakfast_part1_int >= 0 && breakfast_part1_int < 12) {
                    breakfast_time.setVisibility(View.VISIBLE);
                    breakfast_time.setText(initHour(Integer.parseInt(breakfast_part1))+":"+ breakfast_part2 + " AM");
                } else {
                    breakfast_time.setVisibility(View.VISIBLE);
                    breakfast_time.setText(initHour(Integer.parseInt(breakfast_part1))+":"+ breakfast_part2 + " PM");
                }
            } else {
                breakfast_time.setVisibility(View.GONE);
            }
        } else {
            switch2.setChecked(false);
            breakfast_time.setVisibility(View.GONE);
            db.insertFoodTypeReminder(pref.getUID(), "Food reminder", "Breakfast", "",  "deactive");
        }

        /* Lunch */
        boolean lunch_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Food reminder", "Lunch");
        if (lunch_reminder_available) {
            String lunch_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Lunch");
            if (lunch_food_status_remin.equalsIgnoreCase("active")) {
                switch3.setChecked(true);
            } else {
                switch3.setChecked(false);
            }
            lunch_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Lunch");
            if (lunch_time1.length() !=0) {
                lunch_split = lunch_time1.split(":");
                lunch_part1 = lunch_split[0];
                lunch_part2 = lunch_split[1];
                lunch_part1_int = Integer.parseInt(lunch_part1);
                if (lunch_part1_int >= 0 && lunch_part1_int < 12) {
                    lunch_time.setVisibility(View.VISIBLE);
                    lunch_time.setText(initHour(Integer.parseInt(lunch_part1))+":"+ lunch_part2 + " AM");
                } else {
                    lunch_time.setVisibility(View.VISIBLE);
                    lunch_time.setText(initHour(Integer.parseInt(lunch_part1))+":"+ lunch_part2 + " PM");

                }
            } else {
                lunch_time.setVisibility(View.GONE);
            }
        } else {
            switch3.setChecked(false);
            lunch_time.setVisibility(View.GONE);
            db.insertFoodTypeReminder(pref.getUID(), "Food reminder", "Lunch", "",  "deactive");
        }

        /* Evening snacks */
        boolean evening_snacks_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Food reminder", "Evening snacks");
        if (evening_snacks_available) {
            String evening_snacks_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks");
            if (evening_snacks_food_status_remin.equalsIgnoreCase("active")) {
                switch4.setChecked(true);
            } else {
                switch4.setChecked(false);
            }
            evening_snacks_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Evening snacks");
            if (evening_snacks_time1.length() !=0) {
                evening_snacks_split = evening_snacks_time1.split(":");
                evening_snacks_part1 = evening_snacks_split[0];
                evening_snacks_part2 = evening_snacks_split[1];
                evening_snacks_part1_int = Integer.parseInt(evening_snacks_part1);
                if (evening_snacks_part1_int >= 0 && evening_snacks_part1_int < 12) {
                    evening_snacks_time.setVisibility(View.VISIBLE);
                    evening_snacks_time.setText(initHour(Integer.parseInt(evening_snacks_part1))+":"+ evening_snacks_part2 + " AM");
                } else {
                    evening_snacks_time.setVisibility(View.VISIBLE);
                    evening_snacks_time.setText(initHour(Integer.parseInt(evening_snacks_part1))+":"+ evening_snacks_part2 + " PM");

                }
            } else {
                evening_snacks_time.setVisibility(View.GONE);
            }
        } else {
            switch4.setChecked(false);
            evening_snacks_time.setVisibility(View.GONE);
            db.insertFoodTypeReminder(pref.getUID(), "Food reminder", "Evening snacks", "",  "deactive");
        }

        /* Dinner */
        boolean dinner_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Food reminder", "Dinner");
        if (dinner_available) {
            String dinner_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Dinner");
            if (dinner_food_status_remin.equalsIgnoreCase("active")) {
                switch5.setChecked(true);
            } else {
                switch5.setChecked(false);
            }
            dinner_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Dinner");
            if (dinner_time1.length() !=0) {
                dinner_split = dinner_time1.split(":");
                dinner_part1 = dinner_split[0];
                dinner_part2 = dinner_split[1];
                dinner_part1_int = Integer.parseInt(dinner_part1);
                if (dinner_part1_int >= 0 && dinner_part1_int < 12) {
                    dinner_time.setVisibility(View.VISIBLE);
                    dinner_time.setText(initHour(Integer.parseInt(dinner_part1))+":"+ dinner_part2 + " AM");
                } else {
                    dinner_time.setVisibility(View.VISIBLE);
                    dinner_time.setText(initHour(Integer.parseInt(dinner_part1))+":"+ dinner_part2 + " PM");
                }
            } else {
                dinner_time.setVisibility(View.GONE);
            }
        } else {
            switch5.setChecked(false);
            dinner_time.setVisibility(View.GONE);
            db.insertFoodTypeReminder(pref.getUID(), "Food reminder", "Dinner", "",  "deactive");
        }


        switch1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch1.isChecked()) {
                    Calendar mcurrentTime_early_morning = Calendar.getInstance();
                    early_morning_hour = mcurrentTime_early_morning.get(Calendar.HOUR_OF_DAY);
                    early_morning_minute = mcurrentTime_early_morning.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker_early_morning;
                    mTimePicker_early_morning = new TimePickerDialog(FragmentFoodReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                            Calendar calNow = Calendar.getInstance();
                            early_morning_calSet = (Calendar) calNow.clone();
                            early_morning_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                            early_morning_calSet.set(Calendar.MINUTE, selectedMinute);
                            early_morning_hr = selectedHour;
                            early_morning_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                            if (early_morning_hr >= 0 && early_morning_hr < 12) {
                                early_morning_time.setVisibility(View.VISIBLE);
                                early_morning_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                            } else {
                                early_morning_time.setVisibility(View.VISIBLE);
                                early_morning_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                            }
                            db.updateStatusofReminder(pref.getUID(), "Food reminder", "Early Morning", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                            switch1.setChecked(true);
                            FragmentFoodReminder.this.setAlarm_early_morning(FragmentFoodReminder.this.getContext());
                            pref.addNotificationOnOrOff(true);
                            new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the early morning breakfast");
                        }
                    }, early_morning_hour, early_morning_minute, false);//Yes 24 hour time

                    mTimePicker_early_morning.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            switch1.setChecked(false);
                        }
                    });

                    mTimePicker_early_morning.setTitle(FragmentFoodReminder.this.getResources().getString(R.string.select_time));
                    mTimePicker_early_morning.show();
                } else {
                    early_morning_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Early Morning");
                    if (early_morning_time1.length() != 0) {
                        early_morning_split = early_morning_time1.split(":");
                        early_morning_part1 = early_morning_split[0];
                        early_morning_part2 = early_morning_split[1];
                        early_morning_part1_int = Integer.parseInt(early_morning_part1);
                        early_morning_part2_int = Integer.parseInt(early_morning_part2);
                        db_early_morning_time = FragmentFoodReminder.this.initHour(early_morning_part1_int) + ":" + FragmentFoodReminder.this.initMin(early_morning_part2_int);
                    } else {
                        db_early_morning_time = "";
                    }
                    db.updateStatusofReminder(pref.getUID(), "Food reminder", "Early Morning", db_early_morning_time, "deactive");
                    FragmentFoodReminder.this.cancelAlarm(2, Objects.requireNonNull(FragmentFoodReminder.this.getContext()), AlarmReceiverEarlyMorning.class);

                }
            }
        });

        switch2.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch2.isChecked()) {
                    Calendar mcurrentTime_breakfast = Calendar.getInstance();
                    breakfast_hour = mcurrentTime_breakfast.get(Calendar.HOUR_OF_DAY);
                    breakfast_minute = mcurrentTime_breakfast.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker_breakfast;
                    mTimePicker_breakfast = new TimePickerDialog(FragmentFoodReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                            Calendar calNow = Calendar.getInstance();
                            breakfast_calSet = (Calendar) calNow.clone();
                            breakfast_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                            breakfast_calSet.set(Calendar.MINUTE, selectedMinute);
                            breakfast_hr = selectedHour;
                            breakfast_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                            if (breakfast_hr >= 0 && breakfast_hr < 12) {
                                breakfast_time.setVisibility(View.VISIBLE);
                                breakfast_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                            } else {
                                breakfast_time.setVisibility(View.VISIBLE);
                                breakfast_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                            }
                            db.updateStatusofReminder(pref.getUID(), "Food reminder", "Breakfast", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                            switch2.setChecked(true);
                            FragmentFoodReminder.this.setAlarm_breakfast(FragmentFoodReminder.this.getContext());
                            pref.addNotificationOnOrOff(true);
                            new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the morning breakfast");

                        }
                    }, breakfast_hour, breakfast_minute, false);//Yes 24 hour time

                    mTimePicker_breakfast.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            switch2.setChecked(false);
                        }
                    });

                    mTimePicker_breakfast.setTitle(FragmentFoodReminder.this.getResources().getString(R.string.select_time));
                    mTimePicker_breakfast.show();
                } else {
                    breakfast_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Breakfast");
                    if (breakfast_time1.length() != 0) {
                        breakfast_split = breakfast_time1.split(":");
                        breakfast_part1 = breakfast_split[0];
                        breakfast_part2 = breakfast_split[1];
                        breakfast_part1_int = Integer.parseInt(breakfast_part1);
                        breakfast_part2_int = Integer.parseInt(breakfast_part2);
                        db_breakfast_time = FragmentFoodReminder.this.initHour(breakfast_part1_int) + ":" + FragmentFoodReminder.this.initMin(breakfast_part2_int);
                    } else {
                        FragmentFoodReminder.this.cancelAlarm(3, Objects.requireNonNull(FragmentFoodReminder.this.getContext()), AlarmReceiverBreakfast.class);

                        db_breakfast_time = "";
                    }
                    db.updateStatusofReminder(pref.getUID(), "Food reminder", "Breakfast", db_breakfast_time, "deactive");
                }
            }
        });

        switch3.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch3.isChecked()) {
                    Calendar mcurrentTime_lunch = Calendar.getInstance();
                    lunch_hour = mcurrentTime_lunch.get(Calendar.HOUR_OF_DAY);
                    lunch_minute = mcurrentTime_lunch.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker_lunch;
                    mTimePicker_lunch = new TimePickerDialog(FragmentFoodReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                            Calendar calNow = Calendar.getInstance();
                            lunch_calSet = (Calendar) calNow.clone();
                            lunch_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                            lunch_calSet.set(Calendar.MINUTE, selectedMinute);
                            lunch_hr = selectedHour;
                            lunch_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                            if (lunch_hr >= 0 && lunch_hr < 12) {
                                lunch_time.setVisibility(View.VISIBLE);
                                lunch_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                            } else {
                                lunch_time.setVisibility(View.VISIBLE);
                                lunch_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                            }
                            db.updateStatusofReminder(pref.getUID(), "Food reminder", "Lunch", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                            switch3.setChecked(true);
                            FragmentFoodReminder.this.setAlarm_lunch(FragmentFoodReminder.this.getContext());
                            pref.addNotificationOnOrOff(true);
                            new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the Lunch");

                        }
                    }, lunch_hour, lunch_minute, false);//Yes 24 hour time

                    mTimePicker_lunch.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            switch3.setChecked(false);
                        }
                    });

                    mTimePicker_lunch.setTitle(FragmentFoodReminder.this.getResources().getString(R.string.select_time));
                    mTimePicker_lunch.show();
                } else {
                    lunch_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Lunch");
                    if (lunch_time1.length() != 0) {
                        lunch_split = lunch_time1.split(":");
                        lunch_part1 = lunch_split[0];
                        lunch_part2 = lunch_split[1];
                        lunch_part1_int = Integer.parseInt(lunch_part1);
                        lunch_part2_int = Integer.parseInt(lunch_part2);
                        db_lunch_time = FragmentFoodReminder.this.initHour(lunch_part1_int) + ":" + FragmentFoodReminder.this.initMin(lunch_part2_int);
                    } else {
                        FragmentFoodReminder.this.cancelAlarm(4, Objects.requireNonNull(FragmentFoodReminder.this.getContext()), AlarmReceiverLunch.class);

                        db_lunch_time = "";
                    }
                    db.updateStatusofReminder(pref.getUID(), "Food reminder", "Lunch", db_lunch_time, "deactive");
                }
            }
        });

        switch4.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch4.isChecked()) {
                    Calendar mcurrentTime_evening_snacks = Calendar.getInstance();
                    evening_snacks_hour = mcurrentTime_evening_snacks.get(Calendar.HOUR_OF_DAY);
                    evening_snacks_minute = mcurrentTime_evening_snacks.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker_evening_snacks;
                    mTimePicker_evening_snacks = new TimePickerDialog(FragmentFoodReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                            Calendar calNow = Calendar.getInstance();
                            evening_snacks_calSet = (Calendar) calNow.clone();
                            evening_snacks_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                            evening_snacks_calSet.set(Calendar.MINUTE, selectedMinute);
                            evening_snacks_hr = selectedHour;
                            evening_snacks_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                            if (evening_snacks_hr >= 0 && evening_snacks_hr < 12) {
                                evening_snacks_time.setVisibility(View.VISIBLE);
                                evening_snacks_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                            } else {
                                evening_snacks_time.setVisibility(View.VISIBLE);
                                evening_snacks_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                            }
                            db.updateStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                            switch4.setChecked(true);
                            FragmentFoodReminder.this.setAlarm_evening_snacks(FragmentFoodReminder.this.getContext());
                            pref.addNotificationOnOrOff(true);
                            new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the evening snacks");

                        }
                    }, evening_snacks_hour, evening_snacks_minute, false);//Yes 24 hour time

                    mTimePicker_evening_snacks.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            switch4.setChecked(false);
                        }
                    });

                    mTimePicker_evening_snacks.setTitle(FragmentFoodReminder.this.getResources().getString(R.string.select_time));
                    mTimePicker_evening_snacks.show();
                } else {
                    evening_snacks_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Evening snacks");
                    if (evening_snacks_time1.length() != 0) {
                        evening_snacks_split = evening_snacks_time1.split(":");
                        evening_snacks_part1 = evening_snacks_split[0];
                        evening_snacks_part2 = evening_snacks_split[1];
                        evening_snacks_part1_int = Integer.parseInt(evening_snacks_part1);
                        evening_snacks_part2_int = Integer.parseInt(evening_snacks_part2);
                        db_evening_snacks_time = FragmentFoodReminder.this.initHour(evening_snacks_part1_int) + ":" + FragmentFoodReminder.this.initMin(evening_snacks_part2_int);
                    } else {
                        FragmentFoodReminder.this.cancelAlarm(5, Objects.requireNonNull(FragmentFoodReminder.this.getContext()), AlarmReceiverEveningSnacks.class);

                        db_evening_snacks_time = "";
                    }
                    db.updateStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks", db_evening_snacks_time, "deactive");
                }
            }
        });

        switch5.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch5.isChecked()) {
                    Calendar mcurrentTime_dinner = Calendar.getInstance();
                    dinner_hour = mcurrentTime_dinner.get(Calendar.HOUR_OF_DAY);
                    dinner_minute = mcurrentTime_dinner.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker_dinner;
                    mTimePicker_dinner = new TimePickerDialog(FragmentFoodReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            Calendar calNow = Calendar.getInstance();
                            dinner_calSet = (Calendar) calNow.clone();
                            dinner_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                            dinner_calSet.set(Calendar.MINUTE, selectedMinute);
                            dinner_hr = selectedHour;
                            dinner_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                            if (dinner_hr >= 0 && dinner_hr < 12) {
                                dinner_time.setVisibility(View.VISIBLE);
                                dinner_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                            } else {
                                dinner_time.setVisibility(View.VISIBLE);
                                dinner_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                            }
                            db.updateStatusofReminder(pref.getUID(), "Food reminder", "Dinner", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                            switch5.setChecked(true);
                            FragmentFoodReminder.this.setAlarm_dinner(FragmentFoodReminder.this.getContext());
                            pref.addNotificationOnOrOff(true);
                            new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the dinner");
                        }
                    }, dinner_hour, dinner_minute, false);//Yes 24 hour time

                    mTimePicker_dinner.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            switch5.setChecked(false);
                        }
                    });

                    mTimePicker_dinner.setTitle(FragmentFoodReminder.this.getResources().getString(R.string.select_time));
                    mTimePicker_dinner.show();
                } else {
                    dinner_time1 = db.getTimeofReminder(pref.getUID(), "Food reminder", "Dinner");
                    if (dinner_time1.length() != 0) {
                        dinner_split = dinner_time1.split(":");
                        dinner_part1 = dinner_split[0];
                        dinner_part2 = dinner_split[1];
                        dinner_part1_int = Integer.parseInt(dinner_part1);
                        dinner_part2_int = Integer.parseInt(dinner_part2);
                        db_dinner_time = FragmentFoodReminder.this.initHour(dinner_part1_int) + ":" + FragmentFoodReminder.this.initMin(dinner_part2_int);
                    } else {
                        FragmentFoodReminder.this.cancelAlarm(6, Objects.requireNonNull(FragmentFoodReminder.this.getContext()), AlarmReceiverDinner.class);
                        db_dinner_time = "";
                    }
                    db.updateStatusofReminder(pref.getUID(), "Food reminder", "Dinner", db_dinner_time, "deactive");
                }
            }
        });

        set_reminder_early_morning.setOnClickListener(this);
        set_reminder_breakfast.setOnClickListener(this);
        set_reminder_lunch.setOnClickListener(this);
        set_reminder_evening_snack.setOnClickListener(this);
        set_reminder_dinner.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.set_reminder_early_morning:
                Calendar mcurrentTime_early_morning = Calendar.getInstance();
                early_morning_hour = mcurrentTime_early_morning.get(Calendar.HOUR_OF_DAY);
                early_morning_minute = mcurrentTime_early_morning.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_early_morning;
                mTimePicker_early_morning = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar calNow = Calendar.getInstance();
                        early_morning_calSet = (Calendar) calNow.clone();
                        early_morning_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        early_morning_calSet.set(Calendar.MINUTE, selectedMinute);
                        early_morning_hr = selectedHour;
                        early_morning_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                        if (early_morning_hr >= 0 && early_morning_hr < 12) {
                            early_morning_time.setVisibility(View.VISIBLE);
                            early_morning_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            early_morning_time.setVisibility(View.VISIBLE);
                            early_morning_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                        }
                        db.updateStatusofReminder(pref.getUID(), "Food reminder", "Early Morning", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                        FragmentFoodReminder.this.setAlarm_early_morning(FragmentFoodReminder.this.getContext());
                        pref.addNotificationOnOrOff(true);
                        switch1.setChecked(true);
                        new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the early morning breakfast");
                    }
                }, early_morning_hour, early_morning_minute, false);//Yes 24 hour time
                mTimePicker_early_morning.setTitle(getResources().getString(R.string.select_time));
                mTimePicker_early_morning.show();
                break;

            case R.id.set_reminder_breakfast:
                Calendar mcurrentTime_breakfast = Calendar.getInstance();
                breakfast_hour = mcurrentTime_breakfast.get(Calendar.HOUR_OF_DAY);
                breakfast_minute = mcurrentTime_breakfast.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_breakfast;
                mTimePicker_breakfast = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar calNow = Calendar.getInstance();
                        breakfast_calSet = (Calendar) calNow.clone();
                        breakfast_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        breakfast_calSet.set(Calendar.MINUTE, selectedMinute);
                        breakfast_hr = selectedHour;
                        breakfast_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                        if (breakfast_hr >= 0 && breakfast_hr < 12) {
                            breakfast_time.setVisibility(View.VISIBLE);
                            breakfast_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            breakfast_time.setVisibility(View.VISIBLE);
                            breakfast_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                        }
                        db.updateStatusofReminder(pref.getUID(), "Food reminder", "Breakfast", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                        FragmentFoodReminder.this.setAlarm_breakfast(FragmentFoodReminder.this.getContext());
                        switch2.setChecked(true);
                        pref.addNotificationOnOrOff(true);
                        new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the morning breakfast");
                    }
                }, breakfast_hour, breakfast_minute, false);//Yes 24 hour time
                mTimePicker_breakfast.setTitle(getResources().getString(R.string.select_time));
                mTimePicker_breakfast.show();
                break;

            case R.id.set_reminder_lunch:
                Calendar mcurrentTime_lunch = Calendar.getInstance();
                lunch_hour = mcurrentTime_lunch.get(Calendar.HOUR_OF_DAY);
                lunch_minute = mcurrentTime_lunch.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_lunch;
                mTimePicker_lunch = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        Calendar calNow = Calendar.getInstance();
                        lunch_calSet = (Calendar) calNow.clone();
                        lunch_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        lunch_calSet.set(Calendar.MINUTE, selectedMinute);
                        lunch_hr = selectedHour;
                        lunch_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                        if (lunch_hr >= 0 && lunch_hr < 12) {
                            lunch_time.setVisibility(View.VISIBLE);
                            lunch_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            lunch_time.setVisibility(View.VISIBLE);
                            lunch_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                        }
                        db.updateStatusofReminder(pref.getUID(), "Food reminder", "Lunch", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                        FragmentFoodReminder.this.setAlarm_lunch(FragmentFoodReminder.this.getContext());
                        switch3.setChecked(true);
                        pref.addNotificationOnOrOff(true);
                        new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the Lunch");

                    }
                }, lunch_hour, lunch_minute, false);//Yes 24 hour time
                mTimePicker_lunch.setTitle(getResources().getString(R.string.select_time));
                mTimePicker_lunch.show();
                break;

            case R.id.set_reminder_evening_snack:
                Calendar mcurrentTime_evening_snacks = Calendar.getInstance();
                evening_snacks_hour = mcurrentTime_evening_snacks.get(Calendar.HOUR_OF_DAY);
                evening_snacks_minute = mcurrentTime_evening_snacks.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_evening_snacks;
                mTimePicker_evening_snacks = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar calNow = Calendar.getInstance();
                        evening_snacks_calSet = (Calendar) calNow.clone();
                        evening_snacks_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        evening_snacks_calSet.set(Calendar.MINUTE, selectedMinute);
                        evening_snacks_hr = selectedHour;
                        evening_snacks_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                        if (evening_snacks_hr >= 0 && evening_snacks_hr < 12) {
                            evening_snacks_time.setVisibility(View.VISIBLE);
                            evening_snacks_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            evening_snacks_time.setVisibility(View.VISIBLE);
                            evening_snacks_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                        }
                        db.updateStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                        FragmentFoodReminder.this.setAlarm_evening_snacks(FragmentFoodReminder.this.getContext());
                        switch4.setChecked(true);
                        pref.addNotificationOnOrOff(true);
                        new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the evening snacks");

                    }
                }, evening_snacks_hour, evening_snacks_minute, false);//Yes 24 hour time
                mTimePicker_evening_snacks.setTitle(getResources().getString(R.string.select_time));
                mTimePicker_evening_snacks.show();
                break;

            case R.id.set_reminder_dinner:
                Calendar mcurrentTime_dinner = Calendar.getInstance();
                dinner_hour = mcurrentTime_dinner.get(Calendar.HOUR_OF_DAY);
                dinner_minute = mcurrentTime_dinner.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_dinner;
                mTimePicker_dinner = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        Calendar calNow = Calendar.getInstance();
                        dinner_calSet = (Calendar) calNow.clone();
                        dinner_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        dinner_calSet.set(Calendar.MINUTE, selectedMinute);
                        dinner_hr = selectedHour;
                        dinner_min = Integer.parseInt(FragmentFoodReminder.this.initMin(selectedMinute));
                        if (dinner_hr >= 0 && dinner_hr < 12) {
                            dinner_time.setVisibility(View.VISIBLE);
                            dinner_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            dinner_time.setVisibility(View.VISIBLE);
                            dinner_time.setText(FragmentFoodReminder.this.initHour(selectedHour) + ":" + FragmentFoodReminder.this.initMin(selectedMinute) + " PM");
                        }
                        db.updateStatusofReminder(pref.getUID(), "Food reminder", "Dinner", selectedHour + ":" + FragmentFoodReminder.this.initMin(selectedMinute), "active");
                        FragmentFoodReminder.this.setAlarm_dinner(FragmentFoodReminder.this.getContext());
                        switch5.setChecked(true);
                        pref.addNotificationOnOrOff(true);
                        new AppDataPushApi().callApi(FragmentFoodReminder.this.getActivity(), "Reminders", "Food", "set Alarm for the dinner");
                    }
                }, dinner_hour, dinner_minute, false);//Yes 24 hour time
                mTimePicker_dinner.setTitle(getResources().getString(R.string.select_time));
                mTimePicker_dinner.show();
                break;
        }
    }

    String initMin(int min) {
        String min1;
        if (min <= 9) {
            min1 = "0" + min;
        } else {
            min1 = "" + min;
        }
        return min1;
    }

    String initHour(int hr) {
        String hr1;
        if (hr <= 9) {
            if (hr == 0) {
                hr1 = "12";
            } else {
                hr1 = "0" + hr;
            }
        } else {
            if (hr == 13) {
                hr1 = "01";
            } else if (hr == 14) {
                hr1 = "02";
            } else if (hr == 15) {
                hr1 = "03";
            } else if (hr == 16) {
                hr1 = "04";
            } else if (hr == 17) {
                hr1 = "05";
            } else if (hr == 18) {
                hr1 = "06";
            } else if (hr == 19) {
                hr1 = "07";
            } else if (hr == 20) {
                hr1 = "08";
            } else if (hr == 21) {
                hr1 = "09";
            } else if (hr == 22) {
                hr1 = "10";
            } else if (hr == 23) {
                hr1 = "11";
            } else {
                hr1 = "" + hr;
            }
        }
        return hr1;
    }

    public void setAlarm_early_morning(Context context) {
        MySharedPreference pref = new MySharedPreference(context);
        FoodTypeDatabaseHelper db = new FoodTypeDatabaseHelper(context);
        String food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Early Morning");
        if (food_status_remin.equalsIgnoreCase("active")) {
            String time = db.getTimeofReminder(pref.getUID(), "Food reminder", "Early Morning");
            String[] time_split = time.split(":");
            String time_hr = time_split[0];
            String time_min = time_split[1];
            int time_hr_int = Integer.parseInt(time_hr);
            int time_min_int = Integer.parseInt(time_min);
            AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiverEarlyMorning.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.EARLYMORNING");

            ComponentName receiver = new ComponentName(context, AlarmReceiverEarlyMorning.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            PendingIntent pi = PendingIntent.getBroadcast(context, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > time_hr_int) {
                Log.e(TAG, "Alarm will schedule for next day!");
                calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
            }
            else{
                Log.e(TAG, "Alarm will schedule for today!");
            }
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int);
            calendar.set(Calendar.MINUTE, time_min_int);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            } else {
                RegisterEarlyReceiver();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    public void setAlarm_breakfast(Context context) {
        MySharedPreference pref = new MySharedPreference(context);
        FoodTypeDatabaseHelper db = new FoodTypeDatabaseHelper(context);
        String breakfast_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Breakfast");
        if (breakfast_food_status_remin.equalsIgnoreCase("active")) {
            String time_breakfast = db.getTimeofReminder(pref.getUID(), "Food reminder", "Breakfast");
            String[] time_split_breakfast = time_breakfast.split(":");
            String time_hr_breakfast = time_split_breakfast[0];
            String time_min_breakfast = time_split_breakfast[1];
            int time_hr_int_breakfast = Integer.parseInt(time_hr_breakfast);
            int time_min_int_breakfast = Integer.parseInt(time_min_breakfast);
            AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiverBreakfast.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.BREAKFAST");

            ComponentName receiver = new ComponentName(context, AlarmReceiverBreakfast.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            PendingIntent pi = PendingIntent.getBroadcast(context, 3, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > time_hr_int_breakfast) {
                Log.e(TAG, "Alarm will schedule for next day!");
                calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
            }
            else{
                Log.e(TAG, "Alarm will schedule for today!");
            }
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_breakfast);
            calendar.set(Calendar.MINUTE, time_min_int_breakfast);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            } else {
                RegisterBreakFastReceiver();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    public void setAlarm_lunch(Context context) {
        MySharedPreference pref = new MySharedPreference(context);
        FoodTypeDatabaseHelper db = new FoodTypeDatabaseHelper(context);
        String lunch_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Lunch");
        if (lunch_food_status_remin.equalsIgnoreCase("active")) {
            String time_lunch = db.getTimeofReminder(pref.getUID(), "Food reminder", "Lunch");
            String[] time_split_lunch = time_lunch.split(":");
            String time_hr_lunch = time_split_lunch[0];
            String time_min_lunch = time_split_lunch[1];
            int time_hr_int_lunch = Integer.parseInt(time_hr_lunch);
            int time_min_int_lunch = Integer.parseInt(time_min_lunch);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiverLunch.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta");

            ComponentName receiver = new ComponentName(context, AlarmReceiverLunch.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            PendingIntent pi = PendingIntent.getBroadcast(context, 4, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > time_hr_int_lunch) {
                Log.e(TAG, "Alarm will schedule for next day!");
                calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
            } else {
                Log.e(TAG, "Alarm will schedule for today!");
            }
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_lunch);
            calendar.set(Calendar.MINUTE, time_min_int_lunch);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            } else {
                RegisterLunchReceiver();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    public void setAlarm_evening_snacks(Context context) {
        MySharedPreference pref = new MySharedPreference(context);
        FoodTypeDatabaseHelper db = new FoodTypeDatabaseHelper(context);
        String evening_snacks_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks");
        if (evening_snacks_food_status_remin.equalsIgnoreCase("active")) {
            String time_evening_snack = db.getTimeofReminder(pref.getUID(), "Food reminder", "Evening snacks");
            String[] time_split_evening_snacks = time_evening_snack.split(":");
            String time_hr_evening_snacks = time_split_evening_snacks[0];
            String time_min_evening_snacks = time_split_evening_snacks[1];
            int time_hr_int_evening_snacks = Integer.parseInt(time_hr_evening_snacks);
            int time_min_int_evening_snacks = Integer.parseInt(time_min_evening_snacks);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiverEveningSnacks.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.EVESNACK");

            ComponentName receiver = new ComponentName(context, AlarmReceiverEveningSnacks.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            PendingIntent pi = PendingIntent.getBroadcast(context, 5, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > time_hr_int_evening_snacks) {
                Log.e(TAG, "Alarm will schedule for next day!");
                calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
            } else {
                Log.e(TAG, "Alarm will schedule for today!");
            }
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_evening_snacks);
            calendar.set(Calendar.MINUTE, time_min_int_evening_snacks);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            } else {
                RegisterEveningReceiver();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                context.startService(intent);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    public void setAlarm_dinner(Context context) {
        MySharedPreference pref = new MySharedPreference(context);
        FoodTypeDatabaseHelper db = new FoodTypeDatabaseHelper(context);
        String dinner_food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Dinner");
        if (dinner_food_status_remin.equalsIgnoreCase("active")) {
            String time_dinner = db.getTimeofReminder(pref.getUID(), "Food reminder", "Dinner");
            String[] time_split_dinner = time_dinner.split(":");
            String time_hr_dinner = time_split_dinner[0];
            String time_min_dinner = time_split_dinner[1];
            int time_hr_int_dinner = Integer.parseInt(time_hr_dinner);
            int time_min_int_dinner = Integer.parseInt(time_min_dinner);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiverDinner.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.DINNER");

            ComponentName receiver = new ComponentName(context, AlarmReceiverDinner.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            PendingIntent pi = PendingIntent.getBroadcast(context, 6, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > time_hr_int_dinner) {
                Log.e(TAG, "Alarm will schedule for next day!");
                calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
            } else {
                Log.e(TAG, "Alarm will schedule for today!");
            }
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_dinner);
            calendar.set(Calendar.MINUTE, time_min_int_dinner);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            } else {
                RegisterDinnerReceiver();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }


    public void cancelAlarm(int requestCode,Context context,Class receiver){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context,receiver);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, requestCode, myIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.cancel(pendingIntent);
    }


    private void RegisterEarlyReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.EARLYMORNING");
        AlarmReceiverEarlyMorning myReceiver = new AlarmReceiverEarlyMorning();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);

    }
    private void RegisterBreakFastReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.BREAKFAST");
        AlarmReceiverBreakfast myReceiver = new AlarmReceiverBreakfast();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);

    }
    private void RegisterLunchReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.LUNCH");
        AlarmReceiverLunch myReceiver = new AlarmReceiverLunch();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);

    }
    private void RegisterEveningReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.EVESNACK");
        AlarmReceiverEveningSnacks myReceiver = new AlarmReceiverEveningSnacks();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);

    }
    private void RegisterDinnerReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.DINNER");
        AlarmReceiverDinner myReceiver = new AlarmReceiverDinner();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);

    }
}