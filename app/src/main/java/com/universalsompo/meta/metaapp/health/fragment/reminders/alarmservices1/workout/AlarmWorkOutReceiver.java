package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.workout;

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

import androidx.core.app.NotificationCompat;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WorkOutReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Calendar;

public class AlarmWorkOutReceiver extends BroadcastReceiver {
    MySharedPreference pref;
    WorkOutReminderDatabaseHelper db;
    String date;
    String walk_id, WalkReminder, walkTime, walkDay;
    static int JOB_ID = 8697;
    private String CHANNEL_ID = "WorkOut";
    private Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        walk_id = intent.getStringExtra("walkid");
        WalkReminder = intent.getStringExtra("Walk_Reminder");
        walkTime = intent.getStringExtra("walk_Time");
        walkDay = intent.getStringExtra("dayname");
        showNotification(walk_id, walkDay, walkTime, WalkReminder, context);
//        WorkOutJobService.enqueueWork(context,intent);

        if (Build.VERSION.SDK_INT >= 24){
            if (WalkReminder.equals("Morning")) setMorningWalkAlarm(context, walk_id, WalkReminder, walkTime, walkDay);
            else setEveningWalkAlarm(context, walk_id, WalkReminder, walkTime, walkDay);
        }

    }


    private void showNotification(String walk_id, String walkDay, String walkTime, String walkReminder, Context context) {
        pref = MySharedPreference.getInstance(context);
        db = new WorkOutReminderDatabaseHelper(context);
        Intent intent = new Intent(context,MainActivityHealth.class);
        intent.putExtra("menuFragment","WorkOutReminder");

        if (pref.getNotificationOnOrOff()) {
            String notificationTitle = "WorkOut Reminder";
            String notificationText = "Every workout counts even if it is only for 15 minutes. Just do it!";
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})
                    .setContentIntent(PendingIntent.getActivity(context, 2000, intent, PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()) {
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            notificationManager.notify(Integer.parseInt(walk_id), builder.build());
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


    public void setMorningWalkAlarm(Context context, String walkid, String type_of_walk, String walk, String days) {

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

            if (walkDay.contains("sunday")) {
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWorkOutReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WORKOUT");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname", days);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                PendingIntent pi = PendingIntent.getBroadcast(context, 1101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if (dayitem.getTimeInMillis() < System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);

                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if (days.contains("monday")) {
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWorkOutReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WORKOUT");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname", days);
                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                PendingIntent pi = PendingIntent.getBroadcast(context, 1102, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if (dayitem.getTimeInMillis() < System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);

                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                }
            }
            if (days.contains("tuesday")) {
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWorkOutReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WORKOUT");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname", days);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                PendingIntent pi = PendingIntent.
                        getBroadcast(context, 1103, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if (dayitem.getTimeInMillis() < System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);
                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                }
            }
            if (days.contains("wednesday")) {
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWorkOutReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WORKOUT");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname", days);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                PendingIntent pi = PendingIntent.getBroadcast(context, 1104, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                dayitem.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if (dayitem.getTimeInMillis() < System.currentTimeMillis()) {
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);

                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if (days.contains("thursday")) {
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWorkOutReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WORKOUT");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname", days);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                PendingIntent pi = PendingIntent.getBroadcast(context, 1105, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if (dayitem.getTimeInMillis() < System.currentTimeMillis()) {
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);

                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                }
            }
            if (days.contains("friday")) {
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWorkOutReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WORKOUT");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname", days);
                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                PendingIntent pi = PendingIntent.getBroadcast(context, 1106, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if (dayitem.getTimeInMillis() < System.currentTimeMillis()) {
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);

                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if (days.contains("saturday")) {
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WORKOUT");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname", days);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                PendingIntent pi = PendingIntent.getBroadcast(context, 1107, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if (dayitem.getTimeInMillis() < System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);
                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }

        }
    }

    public void setEveningWalkAlarm(Context context, String walkid, String type_of_walk, String walk, String days) {
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
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);

                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_WEEK, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);

                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    doRegisterReceiver(context);
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
                PendingIntent pi = PendingIntent.getBroadcast(context, 1112, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_WEEK, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);

                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                } else {
                    doRegisterReceiver(context);
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
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);

                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_WEEK, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);

                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    doRegisterReceiver(context);
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

//
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
//                    dayitem.add(Calendar.DAY_OF_WEEK, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    doRegisterReceiver(context);
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
                PendingIntent pi = PendingIntent.getBroadcast(context, 1115, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
//                    dayitem.add(Calendar.DAY_OF_WEEK, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    doRegisterReceiver(context);
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

                PendingIntent pi = PendingIntent.getBroadcast(context, 1116, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);

                ComponentName receiver = new ComponentName(context, AlarmWorkOutReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_WEEK, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    doRegisterReceiver(context);
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

                PendingIntent pi = PendingIntent.getBroadcast(context, 1117, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
//                    dayitem.add(Calendar.DAY_OF_WEEK, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                }
                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    doRegisterReceiver(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }

        }

    }

    public void doRegisterReceiver(Context context) {
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WORKOUT");
        AlarmWorkOutReceiver myReceiver = new AlarmWorkOutReceiver();
        context.getApplicationContext().registerReceiver(myReceiver, intent1);
    }
}