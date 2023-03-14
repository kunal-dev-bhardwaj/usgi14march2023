package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.walk;

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

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WalkTypeDatasbaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

public class WalkJobService extends JobIntentService {
    MySharedPreference pref;
    WalkTypeDatasbaseHelper db;
    String date;
    String walk_id, WalkReminder, walkTime, walkDay;
    private String CHANNEL_ID = "Walk";

    static int JOB_ID = 8696;

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, WalkJobService.class, JOB_ID, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        pref = MySharedPreference.getInstance(WalkJobService.this);
        db = new WalkTypeDatasbaseHelper(WalkJobService.this);
        walk_id = intent.getStringExtra("walkid");
        WalkReminder = intent.getStringExtra("Walk_Reminder");
        walkTime = intent.getStringExtra("walk_Time");
        walkDay = intent.getStringExtra("dayname");
        if (pref.getNotificationOnOrOff()) {

            String notificationTitle = "Walk Reminder";
            String notificationText = "Start marching towards your step goal and beyond!";
            NotificationCompat.Builder builder = new NotificationCompat.Builder(WalkJobService.this, CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(WalkJobService.this, 2000, new Intent(WalkJobService.this, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()) {
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) WalkJobService.this.getSystemService(WalkJobService.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            notificationManager.notify(Integer.parseInt(walk_id), builder.build());
        }
    }

    @Override
    public boolean isStopped() {
        return super.isStopped();
    }

    @Override
    public void setInterruptIfStopped(boolean interruptIfStopped) {
        super.setInterruptIfStopped(interruptIfStopped);
        Log.e("stoppedService", "JOB_INTENT_SERVICE_STOPPED");
    }

    final Handler mHandler = new Handler();

    // Helper for showing tests
    void toast(final CharSequence text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(WalkJobService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
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
