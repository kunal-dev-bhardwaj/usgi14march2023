package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.water;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WaterReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Calendar;

public class AlarmWaterReceiver extends BroadcastReceiver {
    MySharedPreference pref;
    WaterReminderDatabaseHelper db;
    static int JOB_ID = 8000;
    String waterId;
    String startTime;
    String times;
    private  String CHANNEL_ID = "Water";
    String reminder_name = "Water Reminder";
    String interval_time_name = "interval";

    @Override
    public void onReceive(Context context, Intent intent) {
        waterId = intent.getStringExtra("water_Time");
        startTime = intent.getStringExtra("start_time");
        times = intent.getStringExtra("times");
        if (Build.VERSION.SDK_INT >= 24) {
            startAlarm(context,times);
        }
        showNotification(waterId,startTime,context);
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

            if (times.equals("30 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+(30 * 60 * 1000) , AlarmManager.INTERVAL_HALF_HOUR, pi);
                } else {
                    RegisterWater(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    /* am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HALF_HOUR, pi);*/
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                            System.currentTimeMillis() +(30 * 60 * 1000),
                            pi);
                }
            }
            if (times.equals("45 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+ (AlarmManager.INTERVAL_HALF_HOUR + AlarmManager.INTERVAL_FIFTEEN_MINUTES), 45 * 60 * 1000, pi);
                } else {
                    RegisterWater(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +(45 * 60 * 1000), pi);

//                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,SystemClock.elapsedRealtime()+ (AlarmManager.INTERVAL_HALF_HOUR + AlarmManager.INTERVAL_FIFTEEN_MINUTES), pi);
                }
            }

            if (times.equals("60 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+(60 * 60 * 1000) , AlarmManager.INTERVAL_HOUR, pi);
                } else {
                    RegisterWater(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +(60 * 60 * 1000),pi);
                }
            }

           /* if (times.equals("60 minutes")) {
                PendingIntent pi = PendingIntent.getBroadcast(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+(60 * 60 * 1000), AlarmManager.INTERVAL_HOUR, pi);
                } else {
                    RegisterWater(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                            SystemClock.elapsedRealtime()+(60 * 60 * 1000), pi);
                }
            }*/

        }
    }
    private void RegisterWater(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WATER");
        AlarmWaterReceiver myReceiver = new AlarmWaterReceiver();
        context.getApplicationContext().registerReceiver(myReceiver,intent1);
    }
    private void showNotification(String waterId, String endTime, Context context){
        pref = MySharedPreference.getInstance(context);
        db = new WaterReminderDatabaseHelper(context);
        Intent intent = new Intent(context,MainActivityHealth.class);
        intent.putExtra("menuFragment","WaterReminder");

        String[] time_split_end = endTime.split(":");
        String end_time_hr = time_split_end[0];
        String end_time_min = time_split_end[1];
        String notificationTitle = "Water Reminder";
        String notificationText = "Cleanse your system and hydrate yourself with a fresh glass of water!";
        if (pref.getNotificationOnOrOff()) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(context, 8888, intent, PendingIntent.FLAG_UPDATE_CURRENT))
                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(WaterJobService.NOTIFICATION_SERVICE);
            // Build the notification and display it
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            notificationManager.notify(Integer.parseInt(waterId), builder.build());
        }
    }

    private void createChannel(NotificationManager notificationManager) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String name = "USGI-PULZ";
            String description = "Notification of USGI-PULZ";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.BLUE);
            notificationManager.createNotificationChannel(mChannel);
        }
    }
}
