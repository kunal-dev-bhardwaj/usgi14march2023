package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.water;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import android.util.Log;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WaterReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import java.util.Calendar;

public class WaterCancelJobService extends JobIntentService {
    static int JOB_ID = 8000;
    MySharedPreference pref;
    WaterReminderDatabaseHelper db;
    String reminder_name = "Water Reminder";
    String interval_time_name = "interval";

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, WaterCancelJobService.class, JOB_ID, intent);

    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        db = new WaterReminderDatabaseHelper(WaterCancelJobService.this);

        pref = new MySharedPreference(WaterCancelJobService.this);
        AlarmManager am = (AlarmManager) WaterCancelJobService.this.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = intent.getParcelableExtra("Cancel_Triggered");
        String times = intent.getStringExtra("times");
        am.cancel(pendingIntent);
        PendingIntent pi = PendingIntent.getBroadcast(WaterCancelJobService.this, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        startAlarm(WaterCancelJobService.this,times,pi);
    }

    private void startAlarm(final Context context, final String time, final PendingIntent pendingIntent){
        String status = db.getStatusofReminder(pref.getUID(), reminder_name, interval_time_name);
        if (status.equalsIgnoreCase("active")) {
            String start_time = db.getStartTimeofReminder(pref.getUID(), reminder_name, interval_time_name);
            String[] time_split = start_time.split(":");
            String time_hr = time_split[0];
            String time_min = time_split[1];
            int time_hr_int = Integer.parseInt(time_hr);
            int time_min_int = Integer.parseInt(time_min);

            AlarmManager am = (AlarmManager) WaterCancelJobService.this.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, AlarmWaterReceiver.class);
            intent.putExtra("water_Time", "8520");
            intent.putExtra("start_time", start_time);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int);
            calendar.set(Calendar.MINUTE, time_min_int);
            calendar.set(Calendar.SECOND, 00);

            long diff = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)- calendar.get(time_hr_int);
            Log.e("this is diff",String.valueOf(diff));

            if (time.equals("30 minutes")) {
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 60 * 1000, pendingIntent);
                    cancelRepeatingAlarm(WaterCancelJobService.this,pendingIntent,time);
                } else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
//                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 60 * 1000, pendingIntent);
//                    cancelRepeatingAlarm(WaterCancelJobService.this,pendingIntent, time);
                }
            }
            if (time.equals("45 minutes")) {
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 45 * 60 * 1000, pendingIntent);
                    cancelRepeatingAlarm(WaterCancelJobService.this,pendingIntent, time);
                } else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 45 * 60 * 1000, pendingIntent);
                    cancelRepeatingAlarm(WaterCancelJobService.this,pendingIntent, time);
                }
            }
            if (time.equals("60 minutes")) {
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, pendingIntent);
                    cancelRepeatingAlarm(WaterCancelJobService.this,pendingIntent, time);
                } else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, pendingIntent);
                    cancelRepeatingAlarm(WaterCancelJobService.this,pendingIntent, time);
                }
            }
        }
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
        myIntent.setAction("com.universalsompo.meta.BROADCAST");
        myIntent.putExtra("Cancel_Triggered",pi);
        myIntent.putExtra("times",times);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 8888, myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT < 23) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//            startAlarm(context,times);
//            alarmManager.cancel(pendingIntent);
        } else {
            doRegisterReceiver();
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//            startAlarm(context,times);
//            alarmManager.cancel(pendingIntent);
        }
    }

    public void doRegisterReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.BROADCAST");
        AlarmWaterReceiver myReceiver = new AlarmWaterReceiver();
        WaterCancelJobService.this.registerReceiver(myReceiver,intent1);
    }
}