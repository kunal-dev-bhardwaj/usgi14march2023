package com.universalsompo.meta.metaapp.health.notificationReminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;

import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.consultation.AlarmReceiverConsultation;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Calendar;
import java.util.Objects;

public class ReminderForNotification {
    public void insertValues(Context context, String activityName, String pending_intent, String date,
                             String time, String status, String active_deactive){
        MySharedPreference pref = new MySharedPreference(context);
        ReminderDatabase db = new ReminderDatabase(context);
        db.insertReminderDatabase(pref.getUID(),activityName,pending_intent,date,time,status,active_deactive);
        createReminder(context,pending_intent,activityName);
    }

    private void createReminder(Context context,String penValue,String activityName) {
        MySharedPreference pref = new MySharedPreference(context);
        ReminderDatabase db = new ReminderDatabase(context);
        String reminderNotification = db.getStatusofReminder(pref.getUID(), activityName);
        if (reminderNotification.equalsIgnoreCase("active")) {

            String time_reminder = db.getTimeofReminder(pref.getUID(), activityName);
            String[] time_split_reminder = time_reminder.split(":");
            String time_hr_reminder = time_split_reminder[0];
            String time_min_reminder = time_split_reminder[1];
            int time_hr_int_reminder = Integer.parseInt(time_hr_reminder);
            int time_min_int_reminder = Integer.parseInt(time_min_reminder);

            String date_reminder = db.getDateofReminder(pref.getUID(), activityName);
            String[] date_split_reminder = date_reminder.split("/");
            String date_day_reminder = date_split_reminder[0];
            String date_month_reminder = date_split_reminder[1];
            String date_year_reminder = date_split_reminder[2];
            int date_day_int_reminder = Integer.parseInt(date_day_reminder);
            int date_month_int_reminder = Integer.parseInt(date_month_reminder);
            int date_year_int_reminder = Integer.parseInt(date_year_reminder);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, ReminderBroadcastReceiver.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.ReminderNotification");
            intent.putExtra("activity", activityName);

            ComponentName receiver = new ComponentName(context, AlarmReceiverConsultation.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            PendingIntent pi = PendingIntent.getBroadcast(context, Integer.parseInt(penValue), intent, PendingIntent.FLAG_ONE_SHOT);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, date_year_int_reminder);
            calendar.set(Calendar.MONTH, date_month_int_reminder - 1);
            calendar.set(Calendar.DAY_OF_MONTH, date_day_int_reminder);
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_reminder);
            calendar.set(Calendar.MINUTE, time_min_int_reminder);
            calendar.set(Calendar.SECOND, 0);
            if (Build.VERSION.SDK_INT < 23) {
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            } else {
                doRegisterReceiver(context);
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void doRegisterReceiver(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.ReminderNotification");
        ReminderBroadcastReceiver myReceiver = new ReminderBroadcastReceiver();
        Objects.requireNonNull(context).registerReceiver(myReceiver,intent1);
    }
}
