package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.weight;

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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WeightReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Calendar;
import java.util.Objects;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiverWeekly extends BroadcastReceiver {
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    static int JOB_ID = 3001;
    WeightReminderDatabaseHelper db;
    String weekid;
    private String CHANNEL_ID = "WeightWeekly";


    @Override
    public void onReceive(Context context, Intent intent) {
        weekid = intent.getStringExtra("weekid");
        showNotification(weekid,context);
//        WeeklyIntentService.enqueueWork(context,intent);

        if (Build.VERSION.SDK_INT>23){
            setAlarm_weekly(context,weekid);
        }
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
                value_of_day = 1;
            } else if (day_weekly.equalsIgnoreCase("Tuesday")) {
                value_of_day = 2;
            } else if (day_weekly.equalsIgnoreCase("Wednesday")) {
                value_of_day = 3;
            } else if (day_weekly.equalsIgnoreCase("Thursday")) {
                value_of_day = 4;
            } else if (day_weekly.equalsIgnoreCase("Friday")) {
                value_of_day = 5;
            } else if (day_weekly.equalsIgnoreCase("Saturday")) {
                value_of_day = 6;
            } else if (day_weekly.equalsIgnoreCase("Sunday")) {
                value_of_day = 7;
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
            calendar.add(Calendar.DAY_OF_WEEK,1);
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
                RegisterWeeklyWeight(context);
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
//                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pi);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void RegisterWeeklyWeight(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WEIGHTWEEKLY");
        AlarmReceiverWeekly myReceiver = new AlarmReceiverWeekly();
        Objects.requireNonNull(context).getApplicationContext().registerReceiver(myReceiver,intent1);
    }
    private void showNotification(String weekid, Context context){
        pref = MySharedPreference.getInstance(context);
        db = new WeightReminderDatabaseHelper(context);
        if (pref.getNotificationOnOrOff()) {
            Intent intent = new Intent(context,MainActivityHealth.class);
            intent.putExtra("menuFragment","WeightReminder");

            String notificationTitle = "Weight Reminder";
            String notificationText = "Add another milestone in your ideal weight journey. Log your weight now!";
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})
                    .setContentIntent(PendingIntent.getActivity(context, Integer.parseInt(weekid), intent, PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()) {
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);

            // Build the notification and display it
            notificationManager.notify(Integer.parseInt(weekid), builder.build());
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