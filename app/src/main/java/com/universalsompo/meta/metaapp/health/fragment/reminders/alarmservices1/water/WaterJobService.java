package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.water;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WaterReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

public class WaterJobService extends JobIntentService {
    MySharedPreference pref;
    WaterReminderDatabaseHelper db;
    static int JOB_ID = 8000;
    String waterId;
    String endTime;
    private  String CHANNEL_ID = "Water";

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, WaterJobService.class, JOB_ID, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        pref = MySharedPreference.getInstance(WaterJobService.this);
        db = new WaterReminderDatabaseHelper(WaterJobService.this);
        waterId = intent.getStringExtra("water_Time");
        endTime = intent.getStringExtra("start_time");
        String[] time_split_end = endTime.split(":");
        String end_time_hr = time_split_end[0];
        String end_time_min = time_split_end[1];
        String notificationTitle = "Water Reminder";
        String notificationText = "Cleanse your system and hydrate yourself with a fresh glass of water!";
        if (pref.getNotificationOnOrOff()) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(WaterJobService.this,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(WaterJobService.this, 8888, new Intent(WaterJobService.this, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT))
                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) WaterJobService.this.getSystemService(WaterJobService.NOTIFICATION_SERVICE);
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