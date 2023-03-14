package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.water;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WaterReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Calendar;
import java.util.Objects;

public class AlarmWaterCancelReceiver extends BroadcastReceiver {
    static int JOB_ID = 8000;
    MySharedPreference pref;
    WaterReminderDatabaseHelper db;
    String reminder_name = "Water Reminder";
    String interval_time_name = "interval";

    @Override
    public void onReceive(Context context, Intent intent) {
        PendingIntent pendingIntent = intent.getParcelableExtra("Cancel_Triggered");
        String times = intent.getStringExtra("times");
        showNotification(pendingIntent,times,context,intent);
        startAlarm(context,times);
    }



    private void showNotification(PendingIntent pendingIntent, String times, Context context, Intent intent){
        db = new WaterReminderDatabaseHelper(context);
        pref = new MySharedPreference(context);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context,AlarmWaterReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(
                context, 8888, myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.cancel(pi);

    }
    private void startAlarm(Context context,String times) {
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


            String end_time = db.getEndTimeofReminder(pref.getUID(), reminder_name, interval_time_name);
            String[] time_split_end = end_time.split(":");
            String end_time_hr = time_split_end[0];
            String end_time_min = time_split_end[1];
            int end_time_hr_int = Integer.parseInt(end_time_hr);
            int end_time_min_int = Integer.parseInt(end_time_min);


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
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            if (times.equals("30 minutes")) {

                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + (30 * 60 * 1000), AlarmManager.INTERVAL_HALF_HOUR, pi);
                } else {
                    RegisterWater(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    /* am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HALF_HOUR, pi);*/
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                            calendar.getTimeInMillis() + (30 * 60 * 1000),
                            pi);
                }
                cancelRepeatingAlarm(context, pi, times);
            }
            if (times.equals("45 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + (AlarmManager.INTERVAL_HALF_HOUR + AlarmManager.INTERVAL_FIFTEEN_MINUTES), 45 * 60 * 1000, pi);
                } else {
                    RegisterWater(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + (45 * 60 * 1000), pi);
                }
                cancelRepeatingAlarm(context, pi, times);
            }
            if (times.equals("60 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + (60 * 60 * 1000), AlarmManager.INTERVAL_HOUR, pi);

                } else {
                    RegisterWater(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + (60 * 60 * 1000), pi);
                }
                cancelRepeatingAlarm(context, pi, times);
            }
        }
    }

    private void RegisterWater(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WATER");
        AlarmWaterReceiver myReceiver = new AlarmWaterReceiver();
        Objects.requireNonNull(context).getApplicationContext().registerReceiver(myReceiver,intent1);
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
        calendar.add(Calendar.DAY_OF_MONTH, 1); // add, not set!
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
            doRegisterReceiver(context);
            context.getApplicationContext().startService(myIntent);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }

    public void doRegisterReceiver(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WATERCANCEL");
        AlarmWaterCancelReceiver myReceiver = new AlarmWaterCancelReceiver();
        Objects.requireNonNull(context).getApplicationContext().registerReceiver(myReceiver,intent1);

    }
}
