package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.weight;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

public class AlarmReceiverMonthly extends BroadcastReceiver {
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    static int JOB_ID = 3002;
    String monthid;
    WeightReminderDatabaseHelper db;
    private  String CHANNEL_ID = "WeightMontly";

    @Override
    public void onReceive(Context context, Intent intent) {
        monthid = intent.getStringExtra("monthid");

//        MonthlyIntentService.enqueueWork(context,intent);
        if (Build.VERSION.SDK_INT>23){
            setAlarm_monthly(context,monthid);
        }
        showNotification(monthid,context);
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
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH+1));
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date_monthly_part));
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_monthly);
            calendar.set(Calendar.MINUTE, time_min_int_monthly);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 31, pi);
            } else {
                RegisterMonthlyWeight(context);
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
//                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 31, pi);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void RegisterMonthlyWeight(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.WEIGHTMONTHLY");
        AlarmReceiverMonthly myReceiver = new AlarmReceiverMonthly();
        Objects.requireNonNull(context).getApplicationContext().registerReceiver(myReceiver,intent1);
    }

    private void showNotification(String monthid, Context context){
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

                    .setContentIntent(PendingIntent.getActivity(context, Integer.parseInt(monthid), intent, PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            // Build the notification and display it
            notificationManager.notify(Integer.parseInt(monthid), builder.build());
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