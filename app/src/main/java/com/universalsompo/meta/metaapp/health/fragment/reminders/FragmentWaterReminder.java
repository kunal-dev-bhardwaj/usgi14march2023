package com.universalsompo.meta.metaapp.health.fragment.reminders;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
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
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.water.AlarmWaterCancelReceiver;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.water.AlarmWaterReceiver;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WaterReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import java.util.Calendar;
import java.util.Objects;

public class FragmentWaterReminder extends Fragment implements View.OnClickListener {
    private View myView;
    TextView startTime,endTime,interval_time_text;
    SwitchButton interval_time;
    Dialog alert_dialog;
    String selected_interval_of_time;
    int startHour,startMin;
    int endHour,endMin;
    private Calendar start_calset;
    private Calendar end_calset;
    private  int start_hr,start_min;
    private  int end_hr,end_min;
    private WaterReminderDatabaseHelper db;
    MySharedPreference pref;
    String reminder_name = "Water Reminder";
    String interval_time_name = "interval";
    String start_time_from_db,start_time_from_db_hour,start_time_from_db_min;
    String[] start_time_split;
    int start_time_hour=9,start_time_min=30;
    String end_time_from_db,end_time_from_db_hour,end_time_from_db_min;
    String[] end_time_split;
    int end_time_hour=21,end_time_min=30;
    String get_interval_time;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_water_reminder, container, false);
        setHasOptionsMenu(true);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        pref = new MySharedPreference(getActivity());
        db = new WaterReminderDatabaseHelper(getActivity());
        initView();
        return myView;
    }

    @SuppressLint("SetTextI18n")
    private void initView(){
        startTime = myView.findViewById(R.id.water_start_time);
        endTime = myView.findViewById(R.id.water_end_time);
        interval_time_text = myView.findViewById(R.id.water_interval_3_text);
        interval_time = myView.findViewById(R.id.water_3times_reminder_btn);
        startTime.setOnClickListener(this);
        endTime.setOnClickListener(this);

        boolean interval_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(),reminder_name,interval_time_name);
        if (interval_reminder_available){
            String interval_reminder_Status_available =db.getStatusofReminder(pref.getUID(),reminder_name,interval_time_name);
            if (interval_reminder_Status_available.equalsIgnoreCase("active")){
                get_interval_time = db.getNoOfTimeofReminder(pref.getUID(),reminder_name,interval_time_name);
                if (get_interval_time.length()!=0){
                    String int_text = get_interval_time.substring(0,6);
                    interval_time_text.setText(int_text);
                    interval_time.setChecked(true);
                } else {
                    interval_time_text.setVisibility(View.GONE);
                    interval_time.setChecked(false);
                }
            } else {
                interval_time_text.setVisibility(View.GONE);
                interval_time.setChecked(false);

            }
        }else {
            interval_time_text.setVisibility(View.GONE);
            interval_time.setChecked(false);
            db.insertWaterTypeReminder(pref.getUID(), reminder_name, interval_time_name, "9:30", "21:30","","deactive");
        }

        /*start time from database method*/
        boolean start_time_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(),reminder_name,interval_time_name);
        if (start_time_available){
            String start_time_status_available =db.getStatusofReminder(pref.getUID(),reminder_name,interval_time_name);
            if (start_time_status_available.equalsIgnoreCase("active")){
                start_time_from_db = db.getStartTimeofReminder(pref.getUID(),reminder_name,interval_time_name);
                if (start_time_from_db.length() !=0 ){
                    start_time_split = start_time_from_db.split(":");
                    start_time_from_db_hour = start_time_split[0];
                    start_time_from_db_min = start_time_split[1];
                    start_time_hour = Integer.parseInt(start_time_from_db_hour);
                    start_time_min = Integer.parseInt(start_time_from_db_min);

                    if (start_time_hour >= 0 && start_time_hour < 12) {
                        startTime.setText(initHour(start_time_hour)+":"+initMin(start_time_min)+ " AM");
                    } else {
                        startTime.setText(initHour(start_time_hour)+":"+initMin(start_time_min)+ " PM");
                    }
                }
                else {
                    start_time_hour = 9;
                    start_time_min = 30;
                }
            }
            else {
                end_time_hour = 9;
                end_time_min = 30;
            }
        }else {
            startTime.setText("9:30 AM");
            db.insertWaterTypeReminder(pref.getUID(), reminder_name, interval_time_name, "9:30", "21:30","","deactive");
        }

        /*end time from database method*/
        boolean end_time_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(),reminder_name,interval_time_name);
        if (end_time_available){
            String start_time_status_available =db.getStatusofReminder(pref.getUID(),reminder_name,interval_time_name);
            if (start_time_status_available.equalsIgnoreCase("active")){
                end_time_from_db = db.getEndTimeofReminder(pref.getUID(),reminder_name,interval_time_name);
                if (end_time_from_db.length() !=0 ){
                    end_time_split = end_time_from_db.split(":");
                    end_time_from_db_hour = end_time_split[0];
                    end_time_from_db_min = end_time_split[1];
                    end_time_hour = Integer.parseInt(end_time_from_db_hour);
                    end_time_min = Integer.parseInt(end_time_from_db_min);
                    if (end_time_hour >= 0 && end_time_hour < 12) {
                        endTime.setText(initHour(end_time_hour)+":"+initMin(end_time_min)+ " AM");
                    } else {
                        endTime.setText(initHour(end_time_hour)+":"+initMin(end_time_min)+ " PM");
                    }
                }
                else {
                    end_time_hour = 21;
                    end_time_min = 30;
                }
            } else {
                end_time_hour = 21;
                end_time_min = 30;
            }
        } else {
            endTime.setText("9:30 PM");
            db.insertWaterTypeReminder(pref.getUID(), reminder_name, interval_time_name, "9:30", "21:30","","deactive");
        }

        interval_time.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (interval_time.isChecked()) {
                    FragmentWaterReminder.this.showIntervalDialog();
                } else {
                    FragmentWaterReminder.this.cancelImmediateAlarm();
                    db.updateNoofTimeReminder(pref.getUID(), reminder_name, interval_time_name, "", "deactive");
                    interval_time_text.setVisibility(View.GONE);
                }
            }
        });
    }

    private void showIntervalDialog() {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_three_no_of_times);
        final LinearLayout cancel, save;
        NumberPicker weekly_numberpicker;
        final String[] NO_OF_TIMES = {"30 minutes", "45 minutes", "60 minutes"};
        cancel =  alert_dialog.findViewById(R.id.cancel);
        save =  alert_dialog.findViewById(R.id.save);
        weekly_numberpicker = alert_dialog.findViewById(R.id.three_no_of_numberpicker);
        weekly_numberpicker.setMinValue(0);
        weekly_numberpicker.setMaxValue(NO_OF_TIMES.length-1);
        weekly_numberpicker.setDisplayedValues(NO_OF_TIMES);
        weekly_numberpicker.setWrapSelectorWheel(true);
        selected_interval_of_time ="30 minutes";

        weekly_numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                //Display the newly selected value from picker
                selected_interval_of_time = NO_OF_TIMES[newVal];
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interval_time.setChecked(false);
                interval_time_text.setVisibility(View.GONE);
                alert_dialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateNoofTimeReminder(pref.getUID(), reminder_name, interval_time_name, selected_interval_of_time, "active");
                String int_text = selected_interval_of_time.substring(0, 6);
                interval_time_text.setText(int_text);
                interval_time_text.setVisibility(View.VISIBLE);
                FragmentWaterReminder.this.startAlarm(FragmentWaterReminder.this.getContext(), selected_interval_of_time);
                pref.addNotificationOnOrOff(true);
                alert_dialog.dismiss();
                new AppDataPushApi().callApi(FragmentWaterReminder.this.getActivity(), "Reminders", "Water", "set Alarm for the Water");
            }
        });

        alert_dialog.show();
    }

    private void startAlarm(Context context,String times){
        MySharedPreference pref = new MySharedPreference(context);
        WaterReminderDatabaseHelper db = new WaterReminderDatabaseHelper(context);
        String status = db.getStatusofReminder(pref.getUID(), reminder_name, interval_time_name);
        if (status.equalsIgnoreCase("active")) {
            String start_time = db.getStartTimeofReminder(pref.getUID(), reminder_name, interval_time_name);
            String[] time_split = start_time.split(":");
            String time_hr = time_split[0];
            String time_min = time_split[1];
            int time_hr_int = Integer.parseInt(time_hr);
            int time_min_int = Integer.parseInt(time_min);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmWaterReceiver.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.WATER");
            intent.putExtra("water_Time", "8521");
            intent.putExtra("start_time", start_time);
            intent.putExtra("times", times);
            ComponentName receiver = new ComponentName(context, AlarmWaterReceiver.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int);
            calendar.set(Calendar.MINUTE, time_min_int);
            calendar.set(Calendar.SECOND, 00);
            if (times.equals("30 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+(30 * 60 * 1000), AlarmManager.INTERVAL_HALF_HOUR, pi);
                } else {
                    RegisterWater();
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                            calendar.getTimeInMillis()+(30 * 60 * 1000),
                            pi);
                }
                cancelRepeatingAlarm(context,pi,times);
            }
            if (times.equals("45 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+ (AlarmManager.INTERVAL_HALF_HOUR + AlarmManager.INTERVAL_FIFTEEN_MINUTES), 45 * 60 * 1000, pi);
                } else {
                    RegisterWater();
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+(45 * 60 * 1000), pi);
                }
                cancelRepeatingAlarm(context,pi, times);
            }
            if (times.equals("60 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+(60 * 60 * 1000), AlarmManager.INTERVAL_HOUR, pi);

                } else {
                    RegisterWater();
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+(60 * 60 * 1000), pi);
                }
                cancelRepeatingAlarm(context,pi, times);
            }
        }
    }

    public void cancelImmediateAlarm(){
        AlarmManager alarmManager = (AlarmManager) Objects.requireNonNull(getActivity()).getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(getActivity(),AlarmWaterReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getActivity(), 8888, myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);
    }

    public void cancelRepeatingAlarm(Context context, PendingIntent pi, String times){
        String end_time = db.getEndTimeofReminder(pref.getUID(), reminder_name, interval_time_name);
        String[] time_split_end = end_time.split(":");
        String end_time_hr = time_split_end[0];
        String end_time_min = time_split_end[1];
        int end_time_hr_int = Integer.parseInt(end_time_hr);
        int end_time_min_int = Integer.parseInt(end_time_min);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, end_time_hr_int);
        calendar.set(Calendar.MINUTE, end_time_min_int);
        calendar.set(Calendar.SECOND, 00);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent();
        myIntent.setClass(context, AlarmWaterCancelReceiver.class);
        myIntent.setPackage("com.universalsompo.meta");
        myIntent.setAction("com.universalsompo.meta.WATERCANCEL");
        myIntent.putExtra("Cancel_Triggered",pi);
        myIntent.putExtra("times",times);
        ComponentName receiver = new ComponentName(context, AlarmWaterCancelReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 8888, myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT < 23) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            RegisterCancelWater();
            context.startService(myIntent);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.water_start_time:
                StartTimePickerDialog(start_time_hour,start_time_min);
                break;
            case R.id.water_end_time:
                EndTimePickerDialog(end_time_hour,end_time_min);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void StartTimePickerDialog(final int start_time_hour, final int start_time_min){
        Calendar mcurrentTime_early_morning = Calendar.getInstance();
        startHour = mcurrentTime_early_morning.get(Calendar.HOUR_OF_DAY);
        startMin = mcurrentTime_early_morning.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar calNow = Calendar.getInstance();
                start_calset = (Calendar) calNow.clone();
                start_calset.set(Calendar.HOUR_OF_DAY, hourOfDay);
                start_calset.set(Calendar.MINUTE, minute);
                start_hr = hourOfDay;
                start_min = Integer.parseInt(FragmentWaterReminder.this.initMin(minute));
                if (start_hr >= 0 && start_hr < 12) {
                    startTime.setVisibility(View.VISIBLE);
                    startTime.setText(FragmentWaterReminder.this.initHour(hourOfDay) + ":" + FragmentWaterReminder.this.initMin(minute) + " AM");
                } else {
                    startTime.setVisibility(View.VISIBLE);
                    startTime.setText(FragmentWaterReminder.this.initHour(hourOfDay) + ":" + FragmentWaterReminder.this.initMin(minute) + " PM");
                }
                db.updateStartTimeReminder(pref.getUID(), reminder_name, interval_time_name, hourOfDay + ":" + FragmentWaterReminder.this.initMin(minute), "active");
            }
        },startHour,startMin,false);
        timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (start_time_hour >= 0 && start_time_hour < 12) {
                    startTime.setText(start_time_hour + ":" + start_time_min + " AM");
                } else {
                    startTime.setText(start_time_hour + ":" + start_time_min + " AM");
                }
            }
        });
        timePickerDialog.setTitle(getResources().getString(R.string.select_time));
        timePickerDialog.updateTime(start_time_hour,start_time_min);
        timePickerDialog.show();
    }

    @SuppressLint("SetTextI18n")
    public void EndTimePickerDialog(final int end_time_hour, final int end_time_min){
        Calendar mcurrentTime_early_morning = Calendar.getInstance();
        endHour = mcurrentTime_early_morning.get(Calendar.HOUR_OF_DAY);
        endMin = mcurrentTime_early_morning.get(Calendar.MINUTE);
        @SuppressLint("SetTextI18n") TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar calNow = Calendar.getInstance();
                end_calset = (Calendar) calNow.clone();
                end_calset.set(Calendar.HOUR_OF_DAY, hourOfDay);
                end_calset.set(Calendar.MINUTE, minute);
                end_hr = hourOfDay;
                end_min = Integer.parseInt(FragmentWaterReminder.this.initMin(minute));
                if (end_hr >= 0 && end_hr < 12) {
                    endTime.setVisibility(View.VISIBLE);
                    endTime.setText(FragmentWaterReminder.this.initHour(hourOfDay) + ":" + FragmentWaterReminder.this.initMin(minute) + " AM");
                } else {
                    endTime.setVisibility(View.VISIBLE);
                    endTime.setText(FragmentWaterReminder.this.initHour(hourOfDay) + ":" + FragmentWaterReminder.this.initMin(minute) + " PM");
                }
                db.updateEndTimeReminder(pref.getUID(), reminder_name, interval_time_name, hourOfDay + ":" + FragmentWaterReminder.this.initMin(minute), "active");
            }
        },endHour,endMin,false);
        timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (end_time_hour >= 0 && end_time_hour < 12) {
                    endTime.setText(end_time_hour + ":" + end_time_min + " AM");
                } else {
                    endTime.setText(end_time_hour + ":" + end_time_min + " PM");
                }
            }
        });
        timePickerDialog.setTitle(getResources().getString(R.string.select_time));
        timePickerDialog.updateTime(end_time_hour,end_time_min);
        timePickerDialog.show();
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

    private void RegisterWater(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WATER");
        AlarmWaterReceiver myReceiver = new AlarmWaterReceiver();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);
    }

    private void RegisterCancelWater(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WATERCANCEL");
        AlarmWaterCancelReceiver myReceiver = new AlarmWaterCancelReceiver();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);
    }
}