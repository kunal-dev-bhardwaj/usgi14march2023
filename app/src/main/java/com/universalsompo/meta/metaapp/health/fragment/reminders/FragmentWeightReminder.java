package com.universalsompo.meta.metaapp.health.fragment.reminders;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.suke.widget.SwitchButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.weight.AlarmReceiverMonthly;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.weight.AlarmReceiverWeekly;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WeightReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

public class FragmentWeightReminder extends Fragment implements View.OnClickListener {
    private View myView;
    private TextView reminder_set_time, reminder_set_time_monthly;
    private SwitchButton switch1, switch2;
    MySharedPreference pref;
    WeightReminderDatabaseHelper db;
    private Dialog alert_dialog;
    private String selected_time;
    int curHr, curMin;
    private TextView selected_time_txt, selected_time_txt_month;
    private String selected_week="Sunday", selected_month_day="1 st";
    private Calendar weight_calSet;
    private int weight_hour, weight_minute, weight_hr, weight_min;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_weight_reminder, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        setHasOptionsMenu(true);
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        pref = MySharedPreference.getInstance(getActivity());
        db = new WeightReminderDatabaseHelper(getActivity());
        init();
        return myView;
    }

    @SuppressLint("SetTextI18n")
    private void init(){
        LinearLayout set_reminder_weekly = myView.findViewById(R.id.set_reminder_weekly);
        LinearLayout set_reminder_monthly = myView.findViewById(R.id.set_reminder_monthly);
        reminder_set_time =  myView.findViewById(R.id.reminder_set_time);
        reminder_set_time_monthly =  myView.findViewById(R.id.reminder_set_time_monthly);
        switch1 = myView.findViewById(R.id.switch1);
        switch2 = myView.findViewById(R.id.switch2);

        /* Weekly */
        boolean weekly_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Weekly");
        String weekly_monthly_time;
        String[] split_weekly_monthly_time;
        String weekly_monthly_hr;
        String weekly_monthly_min;
        String weekly_monthly_time_1;
        if (weekly_reminder_available) {
            String weekly_status_remin = db.getStatus(pref.getUID(), "Weekly");
            String weekly_day;
            if (weekly_status_remin.equalsIgnoreCase("active")) {
                switch1.setChecked(true);
                weekly_day = db.getWeeklyDayReminder(pref.getUID(), "Weekly");
                weekly_monthly_time = db.getMonthlyWeeklyTimeReminder(pref.getUID(), "Weekly");
                split_weekly_monthly_time = weekly_monthly_time.split(":");
                weekly_monthly_hr = split_weekly_monthly_time[0];
                weekly_monthly_min = split_weekly_monthly_time[1];
                if (Integer.parseInt(weekly_monthly_hr) >= 0 && Integer.parseInt(weekly_monthly_hr) < 12) {
                    weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " AM";
                } else {
                    weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " PM";
                }
                reminder_set_time.setText(weekly_day + " " + weekly_monthly_time_1);
            } else {
                switch1.setChecked(false);
                weekly_day = db.getWeeklyDayReminder(pref.getUID(), "Weekly");
                weekly_monthly_time = db.getMonthlyWeeklyTimeReminder(pref.getUID(), "Weekly");
                if (weekly_monthly_time.length() == 0) {
                    reminder_set_time.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_weekly_reminder));
                } else {
                    split_weekly_monthly_time = weekly_monthly_time.split(":");
                    weekly_monthly_hr = split_weekly_monthly_time[0];
                    weekly_monthly_min = split_weekly_monthly_time[1];
                    if (Integer.parseInt(weekly_monthly_hr) >= 0 && Integer.parseInt(weekly_monthly_hr) < 12) {
                        weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " AM";
                    } else {
                        weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " PM";
                    }
                    reminder_set_time.setText(weekly_day + " " + weekly_monthly_time_1);
                }
            }
        } else {
            switch1.setChecked(false);
            reminder_set_time.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_weekly_reminder));
            db.insertWeightReminder(pref.getUID(), "Weekly", "", "",  "", "", "deactive");
        }

        /* Monthly */
        boolean monthly_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Monthly");
        if (monthly_reminder_available) {
            String monthly_status_remin = db.getStatus(pref.getUID(), "Monthly");
            String monthly_date;
            if (monthly_status_remin.equalsIgnoreCase("active")) {
                switch2.setChecked(true);
                monthly_date = db.getMonthlyDateReminder(pref.getUID(), "Monthly");
                weekly_monthly_time = db.getMonthlyWeeklyTimeReminder(pref.getUID(), "Monthly");
                split_weekly_monthly_time = weekly_monthly_time.split(":");
                weekly_monthly_hr = split_weekly_monthly_time[0];
                weekly_monthly_min = split_weekly_monthly_time[1];
                if (Integer.parseInt(weekly_monthly_hr) >= 0 && Integer.parseInt(weekly_monthly_hr) < 12) {
                    weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " AM";
                } else {
                    weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " PM";
                }
                reminder_set_time_monthly.setText(monthly_date + " " + weekly_monthly_time_1);
            } else {
                switch2.setChecked(false);
                monthly_date = db.getMonthlyDateReminder(pref.getUID(), "Monthly");
                weekly_monthly_time = db.getMonthlyWeeklyTimeReminder(pref.getUID(), "Monthly");
                if (weekly_monthly_time.length() == 0) {
                    reminder_set_time_monthly.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_monthly_reminder));
                } else {
                    split_weekly_monthly_time = weekly_monthly_time.split(":");
                    weekly_monthly_hr = split_weekly_monthly_time[0];
                    weekly_monthly_min = split_weekly_monthly_time[1];
                    if (Integer.parseInt(weekly_monthly_hr) >= 0 && Integer.parseInt(weekly_monthly_hr) < 12) {
                        weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " AM";
                    } else {
                        weekly_monthly_time_1 = initHour(Integer.parseInt(weekly_monthly_hr)) + ":" + initMin(Integer.parseInt(weekly_monthly_min)) + " PM";
                    }
                    reminder_set_time_monthly.setText(monthly_date + " " + weekly_monthly_time_1);
                }
            }
        } else {
            switch2.setChecked(false);
            reminder_set_time_monthly.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.set_monthly_reminder));
            db.insertWeightReminder(pref.getUID(), "Monthly", "", "",  "", "", "deactive");
        }

        switch1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch1.isChecked()) {
                    String monthly_status = db.getStatus(pref.getUID(), "Monthly");
                    if (monthly_status.equalsIgnoreCase("active")) {
                        switch2.setChecked(false);
                        db.updateStatusofReminder(pref.getUID(), "Monthly", "deactive");
                    }
                    FragmentWeightReminder.this.showWeeklyDialog();
                } else {
                    db.updateStatusofReminder(pref.getUID(), "Weekly", "deactive");
                }
            }
        });

        switch2.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch2.isChecked()) {
                    String weekly_status = db.getStatus(pref.getUID(), "Weekly");
                    if (weekly_status.equalsIgnoreCase("active")) {
                        switch1.setChecked(false);
                        db.updateStatusofReminder(pref.getUID(), "Weekly", "deactive");
                    }
                    FragmentWeightReminder.this.showMonthlyDialog();
                } else {
                    db.updateStatusofReminder(pref.getUID(), "Monthly", "deactive");
                }
            }
        });

        set_reminder_weekly.setOnClickListener(this);
        set_reminder_monthly.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.set_reminder_weekly:
                showWeeklyDialog();
                break;

            case R.id.set_reminder_monthly:
                showMonthlyDialog();
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

    @SuppressLint("SetTextI18n")
    private void getCurrentTime() {
        Calendar mcurrentTime = Calendar.getInstance();
        curHr = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        curMin = mcurrentTime.get(Calendar.MINUTE);

        selected_time = curHr + ":" + initMin(curMin);
        if (curHr >= 0 && curHr < 12) {
            selected_time_txt.setText( initHour(curHr) + ":" + initMin(curMin) + " AM");
        } else {
            selected_time_txt.setText( initHour(curHr) + ":" + initMin(curMin) + " PM");
        }
    }

    @SuppressLint("SetTextI18n")
    private void getCurrentTime_month() {
        Calendar mcurrentTime = Calendar.getInstance();
        curHr = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        curMin = mcurrentTime.get(Calendar.MINUTE);
        selected_time = curHr + ":" + initMin(curMin);
        if (curHr >= 0 && curHr < 12) {
            selected_time_txt_month.setText( initHour(curHr) + ":" + initMin(curMin) + " AM");
        } else {
            selected_time_txt_month.setText( initHour(curHr) + ":" + initMin(curMin) + " PM");
        }
    }

    @SuppressLint("SetTextI18n")
    private void showWeeklyDialog() {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_weekly_dialog);
        LinearLayout select_time, cancel, save;
        NumberPicker weekly_numberpicker;
        final String[] WEEKDAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        selected_time_txt =  alert_dialog.findViewById(R.id.selected_time_txt);
        select_time =  alert_dialog.findViewById(R.id.select_time);
        cancel =  alert_dialog.findViewById(R.id.cancel);
        save =  alert_dialog.findViewById(R.id.save);
        weekly_numberpicker = alert_dialog.findViewById(R.id.weekly_numberpicker);
        weekly_numberpicker.setMinValue(0);
        weekly_numberpicker.setMaxValue(WEEKDAYS.length-1);
        weekly_numberpicker.setDisplayedValues(WEEKDAYS);
        weekly_numberpicker.setWrapSelectorWheel(true);
        getCurrentTime();

        weekly_numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                selected_week = WEEKDAYS[newVal];
            }
        });

        select_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime_weight = Calendar.getInstance();
                weight_hour = mcurrentTime_weight.get(Calendar.HOUR_OF_DAY);
                weight_minute = mcurrentTime_weight.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_dinner;
                mTimePicker_dinner = new TimePickerDialog(FragmentWeightReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar calNow = Calendar.getInstance();
                        weight_calSet = (Calendar) calNow.clone();
                        weight_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        weight_calSet.set(Calendar.MINUTE, selectedMinute);
                        weight_hr = selectedHour;
                        weight_min = Integer.parseInt(FragmentWeightReminder.this.initMin(selectedMinute));
                        selected_time = weight_hr + ":" + FragmentWeightReminder.this.initMin(weight_min);
                        if (weight_hr >= 0 && weight_hr < 12) {
                            selected_time_txt.setText(FragmentWeightReminder.this.initHour(weight_hr) + ":" + FragmentWeightReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            selected_time_txt.setText(FragmentWeightReminder.this.initHour(weight_hr) + ":" + FragmentWeightReminder.this.initMin(selectedMinute) + " PM");
                        }
                    }
                }, weight_hour, weight_minute, false);//Yes 24 hour time
                mTimePicker_dinner.setTitle(FragmentWeightReminder.this.getResources().getString(R.string.select_time));
                mTimePicker_dinner.show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_status = db.getStatus(pref.getUID(), "Weekly");
                if (get_status.equalsIgnoreCase("active")) {
                    switch1.setChecked(true);
                } else {
                    switch1.setChecked(false);
                }
                alert_dialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random ran = new Random();
                String week_id = String.valueOf((1000 + ran.nextInt(9000)));
                db.updateStatusofReminder(pref.getUID(), "Weekly", selected_week, "", selected_time, week_id, "active");
                if (weight_hr >= 0 && weight_hr < 12) {
                    reminder_set_time.setText(selected_week + " " + FragmentWeightReminder.this.initHour(weight_hr) + ":" + FragmentWeightReminder.this.initMin(weight_min) + " AM");
                } else {
                    reminder_set_time.setText(selected_week + " " + FragmentWeightReminder.this.initHour(weight_hr) + ":" + FragmentWeightReminder.this.initMin(weight_min) + " PM");
                }
                FragmentWeightReminder.this.setAlarm_weekly(FragmentWeightReminder.this.getContext(), week_id);
                pref.addNotificationOnOrOff(true);
                alert_dialog.dismiss();
                new AppDataPushApi().callApi(FragmentWeightReminder.this.getActivity(), "Reminders", "Weight", "set Alarm for the weekly weight");
            }
        });

        alert_dialog.show();
    }

    @SuppressLint("SetTextI18n")
    private void showMonthlyDialog() {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_monthly_dialog);
        LinearLayout select_time_month, cancel_month, save_month;
        NumberPicker monthly_numberpicker;
        final String[] MONTHDAYS = {"1 st", "2 nd", "3 rd", "4 th", "5 th", "6 th", "7 th", "8 th", "9 th", "10 th", "11 th", "12 th", "13 th", "14 th", "15 th", "16 th", "17 th", "18 th", "19 th", "20 th", "21 st", "22 nd", "23 rd", "24 th", "25 th", "26 th", "27 th", "28 th", "29 th", "30 th", "31 st"};
        selected_time_txt_month =  alert_dialog.findViewById(R.id.selected_time_txt_month);
        select_time_month =  alert_dialog.findViewById(R.id.select_time_month);
        cancel_month =  alert_dialog.findViewById(R.id.cancel_month);
        save_month =  alert_dialog.findViewById(R.id.save_month);
        monthly_numberpicker = alert_dialog.findViewById(R.id.monthly_numberpicker);
        monthly_numberpicker.setMinValue(0);
        monthly_numberpicker.setMaxValue(MONTHDAYS.length-1);
        monthly_numberpicker.setDisplayedValues(MONTHDAYS);
        monthly_numberpicker.setWrapSelectorWheel(true);

        getCurrentTime_month();

        monthly_numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                selected_month_day = MONTHDAYS[newVal];
            }
        });

        select_time_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime_weight = Calendar.getInstance();
                weight_hour = mcurrentTime_weight.get(Calendar.HOUR_OF_DAY);
                weight_minute = mcurrentTime_weight.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_dinner;
                mTimePicker_dinner = new TimePickerDialog(FragmentWeightReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar calNow = Calendar.getInstance();
                        weight_calSet = (Calendar) calNow.clone();
                        weight_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        weight_calSet.set(Calendar.MINUTE, selectedMinute);
                        weight_hr = selectedHour;
                        weight_min = Integer.parseInt(FragmentWeightReminder.this.initMin(selectedMinute));
                        selected_time = weight_hr + ":" + FragmentWeightReminder.this.initHour(weight_min);
                        if (weight_hr >= 0 && weight_hr < 12) {
                            selected_time_txt_month.setText(FragmentWeightReminder.this.initHour(selectedHour) + ":" + FragmentWeightReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            selected_time_txt_month.setText(FragmentWeightReminder.this.initHour(selectedHour) + ":" + FragmentWeightReminder.this.initMin(selectedMinute) + " PM");
                        }
                    }
                }, weight_hour, weight_minute, false);//Yes 24 hour time
                mTimePicker_dinner.setTitle(FragmentWeightReminder.this.getResources().getString(R.string.select_time));
                mTimePicker_dinner.show();
            }
        });

        cancel_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_status = db.getStatus(pref.getUID(), "Monthly");
                if (get_status.equalsIgnoreCase("active")) {
                    switch2.setChecked(true);
                } else {
                    switch2.setChecked(false);
                }
                alert_dialog.dismiss();
            }
        });

        save_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random ran = new Random();
                String code = String.valueOf((1000 + ran.nextInt(9000)));
                db.updateStatusofReminder(pref.getUID(), "Monthly", "", selected_month_day, selected_time, code, "active");
                if (weight_hr >= 0 && weight_hr < 12) {
                    reminder_set_time_monthly.setText(selected_month_day + " " + FragmentWeightReminder.this.initHour(weight_hr) + ":" + FragmentWeightReminder.this.initMin(weight_min) + " AM");
                } else {
                    reminder_set_time_monthly.setText(selected_month_day + " " + FragmentWeightReminder.this.initHour(weight_hr) + ":" + FragmentWeightReminder.this.initMin(weight_min) + " PM");
                }
                FragmentWeightReminder.this.setAlarm_monthly(FragmentWeightReminder.this.getContext(), code);
                pref.addNotificationOnOrOff(true);
                alert_dialog.dismiss();
                new AppDataPushApi().callApi(FragmentWeightReminder.this.getActivity(), "Reminders", "Weight", "set Alarm for the monthly weight");
            }
        });

        alert_dialog.show();
    }

    public void setAlarm_weekly(Context context, String weekid) {
        MySharedPreference pref = new MySharedPreference(context);
        WeightReminderDatabaseHelper db = new WeightReminderDatabaseHelper(context);
        String weekly_status_remin = db.getStatus(pref.getUID(),"Weekly");
        if (weekly_status_remin.equalsIgnoreCase("active")) {
            String time_weekly = db.getMonthlyWeeklyTimeReminder(pref.getUID(), "Weekly");
            String[] time_split_weekly = time_weekly.split(":");
            String time_hr_weekly = time_split_weekly[0];
            String time_min_weekly = time_split_weekly[1];
            int time_hr_int_weekly = Integer.parseInt(time_hr_weekly);
            int time_min_int_weekly = Integer.parseInt(time_min_weekly);
            int value_of_day = 0;
            String day_weekly = db.getWeeklyDayReminder(pref.getUID(), "Weekly");
            if (day_weekly.equalsIgnoreCase("Monday")) {
                value_of_day = 2;
            } else if (day_weekly.equalsIgnoreCase("Tuesday")) {
                value_of_day = 3;
            } else if (day_weekly.equalsIgnoreCase("Wednesday")) {
                value_of_day = 4;
            } else if (day_weekly.equalsIgnoreCase("Thursday")) {
                value_of_day = 5;
            } else if (day_weekly.equalsIgnoreCase("Friday")) {
                value_of_day = 6;
            } else if (day_weekly.equalsIgnoreCase("Saturday")) {
                value_of_day = 7;
            } else if (day_weekly.equalsIgnoreCase("Sunday")) {
                value_of_day = 1;
            }

            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context,AlarmReceiverWeekly.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.WEIGHTWEEKLY");
            intent.putExtra("weekid", weekid);

            ComponentName receiver = new ComponentName(context, AlarmReceiverWeekly.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            PendingIntent pi = PendingIntent.getBroadcast(context, Integer.parseInt(weekid), intent, PendingIntent.FLAG_UPDATE_CURRENT);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_WEEK, value_of_day);
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_weekly);
            calendar.set(Calendar.MINUTE, time_min_int_weekly);
            calendar.set(Calendar.SECOND, 00);
            if(calendar.getTimeInMillis() < System.currentTimeMillis()) {
                calendar.add(Calendar.DAY_OF_YEAR, 7);
            }
            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);
            }
            else {
                RegisterWeeklyWeight();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    public void setAlarm_monthly(Context context, String monthid) {
        MySharedPreference pref = new MySharedPreference(context);
        WeightReminderDatabaseHelper db = new WeightReminderDatabaseHelper(context);
        String monthly_status_remin = db.getStatus(pref.getUID(),"Monthly");
        if (monthly_status_remin.equalsIgnoreCase("active")) {

            String time_monthly = db.getMonthlyWeeklyTimeReminder(pref.getUID(), "Monthly");
            String[] time_split_monthly = time_monthly.split(":");
            String time_hr_monthly = time_split_monthly[0];
            String time_min_monthly = time_split_monthly[1];
            int time_hr_int_monthly = Integer.parseInt(time_hr_monthly);
            int time_min_int_monthly = Integer.parseInt(time_min_monthly);

            String date_monthly = db.getMonthlyDateReminder(pref.getUID(), "Monthly");
            String[] date_monthly_split = date_monthly.split(" ");
            String date_monthly_part = date_monthly_split[0];

            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent();
            intent.setClass(context,AlarmReceiverMonthly.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.WEIGHTMONTHLY");
            intent.putExtra("monthid", monthid);

            PendingIntent pi = PendingIntent.getBroadcast(context, Integer.parseInt(monthid), intent, PendingIntent.FLAG_UPDATE_CURRENT);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date_monthly_part));
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_monthly);
            calendar.set(Calendar.MINUTE, time_min_int_monthly);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 31, pi);
            } else {
                RegisterMonthlyWeight();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void RegisterMonthlyWeight(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WEIGHTMONTHLY");
        AlarmReceiverMonthly myReceiver = new AlarmReceiverMonthly();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);
    }

    private void RegisterWeeklyWeight(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WEIGHTWEEKLY");
        AlarmReceiverWeekly myReceiver = new AlarmReceiverWeekly();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);
    }
}