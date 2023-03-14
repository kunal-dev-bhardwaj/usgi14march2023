package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.walk;

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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WalkTypeDatasbaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import java.util.Calendar;

public class AlarmWalkReceiver extends BroadcastReceiver {
    MySharedPreference pref;
    WalkTypeDatasbaseHelper db;
    String date;
    String walk_id, WalkReminder, walkTime, walkDay;
    private String CHANNEL_ID = "Walk";
    static int JOB_ID = 8696;

    @Override
    public void onReceive(Context context, Intent intent) {
//        WalkJobService.enqueueWork(context,intent);
        walk_id = intent.getStringExtra("walkid");
        WalkReminder = intent.getStringExtra("Walk_Reminder");
        walkTime = intent.getStringExtra("walk_Time");
        walkDay = intent.getStringExtra("dayname");

        if (Build.VERSION.SDK_INT >= 24){
            if (WalkReminder.equals("Morning")) setMorningWalkAlarm(context, walk_id, WalkReminder, walkTime, walkDay);
            else setEveningWalkAlarm(context, walk_id, WalkReminder, walkTime, walkDay);
        }
        showNotification(walk_id,walkDay,walkTime,WalkReminder,context);
    }



    public void setEveningWalkAlarm(Context context, String walkid, String type_of_walk, String walk,String days) {
        MySharedPreference pref = new MySharedPreference(context);
        WalkTypeDatasbaseHelper db = new WalkTypeDatasbaseHelper(context);
        String labtest_status_remin = db.getStatusofReminder(pref.getUID(), "Walk reminder", "Evening");
        if (labtest_status_remin.equalsIgnoreCase("active")) {

            String time_labtest = db.getTimeofReminder(pref.getUID(), "Walk reminder", "Evening");
            String[] time_split_labtest = time_labtest.split(":");
            String time_hr_labtest = time_split_labtest[0];
            String time_min_labtest = time_split_labtest[1];
            int time_hr_int_labtest = Integer.parseInt(time_hr_labtest);
            int time_min_int_labtest = Integer.parseInt(time_min_labtest);

            Calendar dayitem = Calendar.getInstance();
            if(days.contains("sunday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);

                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 00011, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("monday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
//
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 00022, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("tuesday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                }                        dayitem.add(Calendar.DAY_OF_YEAR,7);

                PendingIntent pi = PendingIntent.getBroadcast(context, 00033, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);
                }
            }
            if(days.contains("wednesday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
//
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 00044, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("thursday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 00055, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("friday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 00066, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("saturday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", walkid);
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 00077, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
        }
    }

    public void setMorningWalkAlarm(Context context, String walkid, String type_of_walk, String walk,String days) {

        MySharedPreference pref = new MySharedPreference(context);
        WalkTypeDatasbaseHelper db = new WalkTypeDatasbaseHelper(context);
        String labtest_status_remin = db.getStatusofReminder(pref.getUID(), "Walk reminder", "Morning");
        if (labtest_status_remin.equalsIgnoreCase("active")) {

            String time_labtest = db.getTimeofReminder(pref.getUID(), "Walk reminder", "Morning");
            String[] time_split_labtest = time_labtest.split(":");
            String time_hr_labtest = time_split_labtest[0];
            String time_min_labtest = time_split_labtest[1];
            int time_hr_int_labtest = Integer.parseInt(time_hr_labtest);
            int time_min_int_labtest = Integer.parseInt(time_min_labtest);

            Calendar dayitem = Calendar.getInstance();
            if(days.contains("sunday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", "00111");
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 0001, intent, PendingIntent.FLAG_UPDATE_CURRENT);


                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("monday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", "00112");
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 0002, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("tuesday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", "00113");
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 0003, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("wednesday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", "00114");
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
//
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);

                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 0004, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("thursday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", "00115");
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
//
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);

                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 0005, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("friday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", "00116");
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
//
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 0006, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);

                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }
            if(days.contains("saturday")){
                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setClass(context, AlarmWalkReceiver.class);
                intent.setPackage("com.universalsompo.meta");
                intent.setAction("com.universalsompo.meta.WALK");
                intent.putExtra("walkid", "00117");
                intent.putExtra("Walk_Reminder", type_of_walk);
                intent.putExtra("walk_Time", walk);
                intent.putExtra("dayname",days);
                ComponentName receiver = new ComponentName(context, AlarmWalkReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);
//
                dayitem.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                dayitem.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
                dayitem.set(Calendar.MINUTE, time_min_int_labtest);
                dayitem.set(Calendar.SECOND, 00);
                if(dayitem.getTimeInMillis()<System.currentTimeMillis()) {
//                    dayitem.add(Calendar.DAY_OF_YEAR, new GregorianCalendar().get(Calendar.DAY_OF_WEEK)-1);
                    dayitem.add(Calendar.DAY_OF_YEAR,7);
                }
                PendingIntent pi = PendingIntent.getBroadcast(context, 0007, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                if (Build.VERSION.SDK_INT < 23) {
                    am.setRepeating(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(),AlarmManager.INTERVAL_DAY*7, pi);
                } else {
                    RegisterWalk(context);
                    context.startService(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                    am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, dayitem.getTimeInMillis(), pi);

                }
            }

        }

//        }
    }

    private void RegisterWalk(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WALK");
        AlarmWalkReceiver myReceiver = new AlarmWalkReceiver();
        context.getApplicationContext().registerReceiver(myReceiver,intent1);
    }
    private void showNotification(String walk_id, String walkDay, String walkTime, String walkReminder, Context context){
        pref = MySharedPreference.getInstance(context);
        db = new WalkTypeDatasbaseHelper(context);

        if (pref.getNotificationOnOrOff()) {
            Intent intent = new Intent(context,MainActivityHealth.class);
            String notificationTitle = "Walk Reminder";
            String notificationText = "Start marching towards your step goal and beyond!";
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
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(WalkJobService.NOTIFICATION_SERVICE);
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
}
