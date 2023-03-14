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
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.suke.widget.SwitchButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.workout.AlarmWorkOutReceiver;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WorkOutReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class FragmentWorkoutReminder extends Fragment implements View.OnClickListener {
    private View myView;
    private LinearLayout sundaySelected,sundayUnSelected;
    private LinearLayout mondaySelcted,mondayUnSelcted;
    private LinearLayout tuesdaySelected,tuesdayUnSelected;
    private LinearLayout wedSelected,wedUnSelected;
    private LinearLayout thurSelected,thurUnSelected;
    private LinearLayout friSelected,friUnSelected;
    private LinearLayout satSelected,satUnSelected;
    private TextView morningWorkoutTime;
    private TextView eveningWorkoutkTime;
    private SwitchButton morningWorkout;
    private SwitchButton eveningWorkout;
    private int morningWorkoutHour;
    private int eveningWorkoutHour;
    private int morningWorkoutMin;
    private int eveningWorkoutMin;
    private Calendar morning_workout_calset;
    private Calendar evening_workout_calset;
    private  int morning_hr, morning_min;
    private  int evening_hr, evening_min;
    private ArrayList<String> selectedDaysArray;
    String morning_time1, morning_part1, morning_part2, db_morning_time;
    String[] morning_split;
    String evening_time1, evening_part1, evening_part2, db_evening_time;
    String[] evening_split;
    WorkOutReminderDatabaseHelper db;
    MySharedPreference pref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_workout_reminder, container, false);
        setHasOptionsMenu(true);
        ((InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        pref = new MySharedPreference(getActivity());
        db = new WorkOutReminderDatabaseHelper(getActivity());
        selectedDaysArray = new ArrayList<>();
        init();
        return myView;
    }
    @SuppressLint("SetTextI18n")
    private void init() {
        sundaySelected = myView.findViewById(R.id.sunday_selected);
        sundayUnSelected = myView.findViewById(R.id.sunday_unselected);
        mondaySelcted = myView.findViewById(R.id.monday_selected);
        mondayUnSelcted = myView.findViewById(R.id.monday_unselected);
        tuesdaySelected = myView.findViewById(R.id.tuesday_selected);
        tuesdayUnSelected = myView.findViewById(R.id.tuesday_unselected);
        wedSelected = myView.findViewById(R.id.wednesday_selected);
        wedUnSelected = myView.findViewById(R.id.wednesday_unselected);
        thurSelected = myView.findViewById(R.id.thursday_selected);
        thurUnSelected = myView.findViewById(R.id.thursday_unselected);
        friSelected = myView.findViewById(R.id.friday_selected);
        friUnSelected = myView.findViewById(R.id.friday_unselected);
        satSelected = myView.findViewById(R.id.saturday_selected);
        satUnSelected = myView.findViewById(R.id.saturday_unselected);
        morningWorkout = myView.findViewById(R.id.morning_workout_switch);
        eveningWorkout = myView.findViewById(R.id.evening_workout_switch);
        morningWorkoutTime = myView.findViewById(R.id.morning_workout_text);
        eveningWorkoutkTime = myView.findViewById(R.id.evening_workout_text);
        sundaySelected.setOnClickListener(this);
        sundayUnSelected.setOnClickListener(this);
        mondaySelcted.setOnClickListener(this);
        mondayUnSelcted.setOnClickListener(this);
        tuesdaySelected.setOnClickListener(this);
        tuesdayUnSelected.setOnClickListener(this);
        wedSelected.setOnClickListener(this);
        wedUnSelected.setOnClickListener(this);
        thurSelected.setOnClickListener(this);
        thurUnSelected.setOnClickListener(this);
        friSelected.setOnClickListener(this);
        friUnSelected.setOnClickListener(this);
        satSelected.setOnClickListener(this);
        satUnSelected.setOnClickListener(this);

        boolean days_available = db.CheckIsDataAlreadyInDBorNot(pref.getUID(), "Workout reminder");
        if (days_available){
            String days = db.getDaysofReminder(pref.getUID());
            if (days!=null){
                ArrayList<String> dayofReminder = new ArrayList<>();
                JSONObject json;
                try {
                    json = new JSONObject(days);
                    JSONArray items = json.optJSONArray("selectedDays");
                    for (int i = 0; i<items.length();i++){
                        dayofReminder.add(items.getString(i));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (dayofReminder.contains("sunday")){
                    selectedDaysArray.add("sunday");
                    sundaySelected.setVisibility(View.VISIBLE);
                    sundayUnSelected.setVisibility(View.GONE);
                }
                if (dayofReminder.contains("monday")){
                    selectedDaysArray.add("monday");
                    mondaySelcted.setVisibility(View.VISIBLE);
                    mondayUnSelcted.setVisibility(View.GONE);
                }
                if (dayofReminder.contains("tuesday")){
                    selectedDaysArray.add("tuesday");
                    tuesdaySelected.setVisibility(View.VISIBLE);
                    tuesdayUnSelected.setVisibility(View.GONE);
                }
                if (dayofReminder.contains("wednesday")){
                    selectedDaysArray.add("wednesday");
                    wedSelected.setVisibility(View.VISIBLE);
                    wedUnSelected.setVisibility(View.GONE);
                }
                if (dayofReminder.contains("thursday")){
                    selectedDaysArray.add("thursday");
                    thurSelected.setVisibility(View.VISIBLE);
                    thurUnSelected.setVisibility(View.GONE);
                }
                if (dayofReminder.contains("friday")){
                    selectedDaysArray.add("friday");
                    friSelected.setVisibility(View.VISIBLE);
                    friUnSelected.setVisibility(View.GONE);
                }
                if (dayofReminder.contains("saturday")){
                    selectedDaysArray.add("saturday");
                    satSelected.setVisibility(View.VISIBLE);
                    satUnSelected.setVisibility(View.GONE);
                }
            }
        }

        /* morning walk */
        boolean morning_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Workout reminder", "Morning");
        if (morning_reminder_available) {
            String morning_walk_status_remin = db.getStatusofReminder(pref.getUID(), "Workout reminder", "Morning");
            if (morning_walk_status_remin.equalsIgnoreCase("active")) {
                morningWorkout.setChecked(true);
                morning_time1 = db.getTimeofReminder(pref.getUID(), "Workout reminder", "Morning");
                if (morning_time1.length() != 0) {
                    morning_split = morning_time1.split(":");
                    morning_part1 = morning_split[0];
                    morning_part2 = morning_split[1];
                    int morning_part1_int = Integer.parseInt(morning_part1);
                    int morning_part2_int = Integer.parseInt(morning_part2);
                    morningWorkoutTime.setVisibility(View.VISIBLE);
                    if (morning_part1_int >= 0 && morning_part1_int < 12) {
                        morningWorkoutTime.setText(initHour(morning_part1_int)+":"+initMin(morning_part2_int) + " AM");
                    } else {
                        morningWorkoutTime.setText(initHour(morning_part1_int)+":"+initMin(morning_part2_int) + " PM");
                    }
                } else {
                    morningWorkoutTime.setVisibility(View.GONE);
                    morningWorkout.setChecked(false);
                }
            } else {
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
            }
        } else {
            morningWorkout.setChecked(false);
            morningWorkoutTime.setVisibility(View.GONE);
            db.insertWorkOutTypeReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
        }


        /* evening walk */
        boolean evening_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Workout reminder", "Evening");
        if (evening_reminder_available) {
            String evening_walk_status_remin = db.getStatusofReminder(pref.getUID(), "Workout reminder", "Evening");
            if (evening_walk_status_remin.equalsIgnoreCase("active")) {
                eveningWorkout.setChecked(true);
                evening_time1 = db.getTimeofReminder(pref.getUID(), "Workout reminder", "Evening");
                if (evening_time1.length() != 0) {
                    evening_split = evening_time1.split(":");
                    evening_part1 = evening_split[0];
                    evening_part2 = evening_split[1];
                    int evening_part1_int = Integer.parseInt(evening_part1);
                    int evening_part2_int = Integer.parseInt(evening_part2);
                    eveningWorkoutkTime.setVisibility(View.VISIBLE);
                    if (evening_part1_int >= 0 && evening_part1_int < 12) {
                        eveningWorkoutkTime.setText(initHour(evening_part1_int)+":"+initMin(evening_part2_int) + " AM");
                    } else {
                        eveningWorkoutkTime.setText(initHour(evening_part1_int)+":"+initMin(evening_part2_int) + " PM");
                    }
                } else {
                    eveningWorkout.setChecked(false);
                    eveningWorkoutkTime.setVisibility(View.GONE);
                }
            } else {
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
            }
        }
        else {
            eveningWorkout.setChecked(false);
            eveningWorkoutkTime.setVisibility(View.GONE);
            db.insertWorkOutTypeReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
        }

        /* morning walk clicklistner */
        morningWorkout.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (selectedDaysArray.isEmpty()) {
                    if (isChecked)
                        Toast.makeText(FragmentWorkoutReminder.this.getActivity(), "Please select days first", Toast.LENGTH_SHORT).show();
                } else {
                    if (morningWorkout.isChecked()) {
                        Calendar mcurrentTime_early_morning = Calendar.getInstance();
                        morningWorkoutHour = mcurrentTime_early_morning.get(Calendar.HOUR_OF_DAY);
                        morningWorkoutMin = mcurrentTime_early_morning.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker_early_morning;
                        mTimePicker_early_morning = new TimePickerDialog(FragmentWorkoutReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                Calendar calNow = Calendar.getInstance();
                                morning_workout_calset = (Calendar) calNow.clone();
                                morning_workout_calset.set(Calendar.HOUR_OF_DAY, selectedHour);
                                morning_workout_calset.set(Calendar.MINUTE, selectedMinute);
                                morning_hr = selectedHour;
                                morning_min = Integer.parseInt(FragmentWorkoutReminder.this.initMin(selectedMinute));
                                if (morning_hr >= 0 && morning_hr < 12) {
                                    morningWorkoutTime.setVisibility(View.VISIBLE);
                                    morningWorkoutTime.setText(FragmentWorkoutReminder.this.initHour(morning_hr) + ":" + FragmentWorkoutReminder.this.initMin(selectedMinute) + " AM");
                                } else {
                                    morningWorkoutTime.setVisibility(View.VISIBLE);
                                    morningWorkoutTime.setText(FragmentWorkoutReminder.this.initHour(morning_hr) + ":" + FragmentWorkoutReminder.this.initMin(selectedMinute) + " PM");
                                }

                                JSONObject json = new JSONObject();
                                try {
                                    json.put("selectedDays", new JSONArray(selectedDaysArray));
                                    String selectDays = json.toString();
                                    db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", selectedHour + ":" + FragmentWorkoutReminder.this.initMin(selectedMinute), "active", selectDays);
                                    morningWorkout.setChecked(true);
                                    pref.addNotificationOnOrOff(true);
                                    FragmentWorkoutReminder.this.setMorningWalkAlarm(FragmentWorkoutReminder.this.getContext(), "3000", "Morning", "Morning Workout");
                                    new AppDataPushApi().callApi(FragmentWorkoutReminder.this.getActivity(), "Reminders", "Workout", "set Alarm for the morning workout");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        }, morningWorkoutHour, morningWorkoutMin, false);//Yes 24 hour time

                        mTimePicker_early_morning.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                morningWorkout.setChecked(false);
                                morningWorkoutTime.setVisibility(View.GONE);
                            }
                        });
                        mTimePicker_early_morning.setTitle(FragmentWorkoutReminder.this.getResources().getString(R.string.select_time));
                        mTimePicker_early_morning.show();
                    } else {
                        morningWorkout.setChecked(false);
                        db_morning_time = "";
                        morningWorkoutTime.setVisibility(View.GONE);
                        db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", db_morning_time, "deactive", "");

                        if (selectedDaysArray.contains("sunday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1101, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("monday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1102, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("tuesday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1103, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("wednesday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1104, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("thursday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1105, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("friday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1106, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("saturday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1107, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        }
                    }
                }
            }
        });

        /* evening walk clicklistner */
        eveningWorkout.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (selectedDaysArray.isEmpty()) {
                    if (isChecked)
                        Toast.makeText(FragmentWorkoutReminder.this.getActivity(), "Please select days first", Toast.LENGTH_SHORT).show();
                } else {
                    if (eveningWorkout.isChecked()) {
                        Calendar mcurrentTime_early_morning = Calendar.getInstance();
                        eveningWorkoutHour = mcurrentTime_early_morning.get(Calendar.HOUR_OF_DAY);
                        eveningWorkoutMin = mcurrentTime_early_morning.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker_early_morning;
                        mTimePicker_early_morning = new TimePickerDialog(FragmentWorkoutReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                Calendar calNow = Calendar.getInstance();
                                evening_workout_calset = (Calendar) calNow.clone();
                                evening_workout_calset.set(Calendar.HOUR_OF_DAY, selectedHour);
                                evening_workout_calset.set(Calendar.MINUTE, selectedMinute);
                                evening_hr = selectedHour;
                                evening_min = Integer.parseInt(FragmentWorkoutReminder.this.initMin(selectedMinute));
                                if (evening_hr >= 0 && evening_hr < 12) {
                                    eveningWorkoutkTime.setVisibility(View.VISIBLE);
                                    eveningWorkoutkTime.setText(FragmentWorkoutReminder.this.initHour(selectedHour) + ":" + FragmentWorkoutReminder.this.initMin(selectedMinute) + " AM");
                                } else {
                                    eveningWorkoutkTime.setVisibility(View.VISIBLE);
                                    eveningWorkoutkTime.setText(FragmentWorkoutReminder.this.initHour(selectedHour) + ":" + FragmentWorkoutReminder.this.initMin(selectedMinute) + " PM");
                                }

                                JSONObject json = new JSONObject();
                                try {
                                    json.put("selectedDays", new JSONArray(selectedDaysArray));
                                    String selectDays = json.toString();
                                    db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", selectedHour + ":" + FragmentWorkoutReminder.this.initMin(selectedMinute), "active", selectDays);
                                    eveningWorkout.setChecked(true);
                                    pref.addNotificationOnOrOff(true);
                                    FragmentWorkoutReminder.this.setEveningWalkAlarm(FragmentWorkoutReminder.this.getContext(), "2000", "Evening", "Evening Workout");
                                    new AppDataPushApi().callApi(FragmentWorkoutReminder.this.getActivity(), "Reminders", "Workout", "set Alarm for the evening workout");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, eveningWorkoutHour, eveningWorkoutMin, false);//Yes 24 hour time

                        mTimePicker_early_morning.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                eveningWorkout.setChecked(false);
                                eveningWorkoutkTime.setVisibility(View.GONE);
                            }
                        });
                        mTimePicker_early_morning.setTitle(FragmentWorkoutReminder.this.getResources().getString(R.string.select_time));
                        mTimePicker_early_morning.show();
                    } else {
                        db_evening_time = "";
                        eveningWorkout.setChecked(false);
                        eveningWorkoutkTime.setVisibility(View.GONE);
                        db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", db_evening_time, "deactive", "");

                        if (selectedDaysArray.contains("sunday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1111, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("monday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1112, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("tuesday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1113, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("wednesday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1114, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("thursday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1115, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("friday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1116, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        } else if (selectedDaysArray.contains("saturday")) {
                            FragmentWorkoutReminder.this.cancelAlarm(1117, Objects.requireNonNull(FragmentWorkoutReminder.this.getContext()), AlarmWorkOutReceiver.class);
                        }
                    }
                }
            }
        });
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

    public void setEveningWalkAlarm(Context context, String walkid, String type_of_walk, String walk) {
        MySharedPreference pref = new MySharedPreference(context);
        WorkOutReminderDatabaseHelper db = new WorkOutReminderDatabaseHelper(context);
        String labtest_status_remin = db.getStatusofReminder(pref.getUID(), "Workout reminder", "Evening");
        if (labtest_status_remin.equalsIgnoreCase("active")) {
            String time_labtest = db.getTimeofReminder(pref.getUID(), "Workout reminder", "Evening");
            String[] time_split_labtest = time_labtest.split(":");
            String time_hr_labtest = time_split_labtest[0];
            String time_min_labtest = time_split_labtest[1];
            int time_hr_int_labtest = Integer.parseInt(time_hr_labtest);
            int time_min_int_labtest = Integer.parseInt(time_min_labtest);
            Calendar dayitem = Calendar.getInstance();
            for (String days : selectedDaysArray){
                if(days.contains("sunday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);

                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);


                    PendingIntent pi = PendingIntent.getBroadcast(context, 1111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("monday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1112, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("tuesday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1113, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("wednesday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1114, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("thursday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1115, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("friday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1116, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("saturday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1117, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
            }
        }
    }

    public void setMorningWalkAlarm(Context context, String walkid, String type_of_walk, String walk) {
        MySharedPreference pref = new MySharedPreference(context);
        WorkOutReminderDatabaseHelper db = new WorkOutReminderDatabaseHelper(context);
        String labtest_status_remin = db.getStatusofReminder(pref.getUID(), "Workout reminder", "Morning");
        if (labtest_status_remin.equalsIgnoreCase("active")) {
            String time_labtest = db.getTimeofReminder(pref.getUID(), "Workout reminder", "Morning");
            String[] time_split_labtest = time_labtest.split(":");
            String time_hr_labtest = time_split_labtest[0];
            String time_min_labtest = time_split_labtest[1];
            int time_hr_int_labtest = Integer.parseInt(time_hr_labtest);
            int time_min_int_labtest = Integer.parseInt(time_min_labtest);
            Calendar dayitem = Calendar.getInstance();
            for (String days : selectedDaysArray){
                if(days.contains("sunday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("monday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1102, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("tuesday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.
                            getBroadcast(context, 1103, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("wednesday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1104, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("thursday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1105, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("friday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setClass(context,AlarmWorkOutReceiver.class);
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1106, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
                if(days.contains("saturday")){
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Intent intent = new Intent();
                    intent.setPackage("com.universalsompo.meta");
                    intent.setAction("com.universalsompo.meta.WORKOUT");
                    intent.putExtra("walkid", walkid);
                    intent.putExtra("Walk_Reminder", type_of_walk);
                    intent.putExtra("walk_Time", walk);
                    intent.putExtra("dayname",days);
                    ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                    PackageManager pm = context.getPackageManager();
                    pm.setComponentEnabledSetting(receiver,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                    PendingIntent pi = PendingIntent.getBroadcast(context, 1107, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                    dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                    dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                    dayitem.set(Calendar.SECOND, 00);
                    if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                        dayitem.add(Calendar.DAY_OF_YEAR,7);
                    }
                    if (Build.VERSION.SDK_INT < 23) {
                        am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                    } else {
                        doRegisterReceiver();
                        context.startService(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sunday_selected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.remove("sunday");
                sundaySelected.setVisibility(View.GONE);
                sundayUnSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.sunday_unselected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.add("sunday");
                sundayUnSelected.setVisibility(View.GONE);
                sundaySelected.setVisibility(View.VISIBLE);
                break;
            case R.id.monday_selected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.remove("monday");
                mondaySelcted.setVisibility(View.GONE);
                mondayUnSelcted.setVisibility(View.VISIBLE);
                break;
            case R.id.monday_unselected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.add("monday");
                mondayUnSelcted.setVisibility(View.GONE);
                mondaySelcted.setVisibility(View.VISIBLE);
                break;
            case R.id.tuesday_selected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.remove("tuesday");
                tuesdaySelected.setVisibility(View.GONE);
                tuesdayUnSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.tuesday_unselected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.add("tuesday");
                tuesdayUnSelected.setVisibility(View.GONE);
                tuesdaySelected.setVisibility(View.VISIBLE);
                break;
            case R.id.wednesday_selected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.remove("wednesday");
                wedSelected.setVisibility(View.GONE);
                wedUnSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.wednesday_unselected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.add("wednesday");
                wedUnSelected.setVisibility(View.GONE);
                wedSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.thursday_selected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.remove("thursday");
                thurSelected.setVisibility(View.GONE);
                thurUnSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.thursday_unselected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.add("thursday");
                thurUnSelected.setVisibility(View.GONE);
                thurSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.friday_selected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.remove("friday");
                friSelected.setVisibility(View.GONE);
                friUnSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.friday_unselected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.add("friday");
                friUnSelected.setVisibility(View.GONE);
                friSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.saturday_selected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);

                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.remove("saturday");
                satSelected.setVisibility(View.GONE);
                satUnSelected.setVisibility(View.VISIBLE);
                break;
            case R.id.saturday_unselected:
                morningWorkout.setChecked(false);
                morningWorkoutTime.setVisibility(View.GONE);
                eveningWorkout.setChecked(false);
                eveningWorkoutkTime.setVisibility(View.GONE);
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Morning", "", "deactive","");
                db.updateStatusofReminder(pref.getUID(), "Workout reminder", "Evening", "", "deactive","");
                selectedDaysArray.add("saturday");
                satUnSelected.setVisibility(View.GONE);
                satSelected.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void doRegisterReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WORKOUT");
        AlarmWorkOutReceiver myReceiver = new AlarmWorkOutReceiver();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);
    }

    public void cancelAlarm(int requestCode,Context context,Class receiver){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context,receiver);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, requestCode, myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);
    }
}