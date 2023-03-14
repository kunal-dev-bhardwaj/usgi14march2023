package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.medicine;

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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.MedicineReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

public class MedicineJobService extends JobIntentService {
    static int JOB_ID = 8630;
    MySharedPreference pref;
    MedicineReminderDatabaseHelper db;
    String med_id;
    private  String CHANNEL_ID = "Medicine";

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, MedicineJobService.class, JOB_ID, intent);
    }
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        pref = MySharedPreference.getInstance(MedicineJobService.this);
        db = new MedicineReminderDatabaseHelper(MedicineJobService.this);
        med_id = intent.getStringExtra("med_id");

        if (pref.getNotificationOnOrOff()){
            String notificationTitle = "Medicine Reminder";
            String notificationText = "Hello there! It’s time to take your Medicine";
            NotificationCompat.Builder builder = new NotificationCompat.Builder(MedicineJobService.this,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(MedicineJobService.this, 2000, new Intent(MedicineJobService.this, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) MedicineJobService.this.getSystemService(MedicineJobService.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            // Build the notification and display it
            notificationManager.notify(Integer.parseInt(med_id), builder.build());
        }
    }


    private void createChannel(NotificationManager notificationManager) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
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