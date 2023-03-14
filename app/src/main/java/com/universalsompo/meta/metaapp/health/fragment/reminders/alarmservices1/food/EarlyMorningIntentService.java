package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.food;

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
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentFoodReminder;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

public class EarlyMorningIntentService extends JobIntentService {
    public static final String TAG = "MyTag";
    FragmentFoodReminder mContext;
    MySharedPreference pref;
    static int JOB_ID = 1001;
    private  String CHANNEL_ID = "EarlyMor";

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, EarlyMorningIntentService.class, JOB_ID, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        pref = MySharedPreference.getInstance(EarlyMorningIntentService.this);
        mContext = new FragmentFoodReminder();
        String notificationTitle = "Early Morning";
        String notificationText = "A cup of tea is all you need to kick start your day. So make it perfect!";
        if (pref.getNotificationOnOrOff()) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(EarlyMorningIntentService.this,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationText)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(EarlyMorningIntentService.this, 2, new Intent(EarlyMorningIntentService.this, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) EarlyMorningIntentService.this.getSystemService(NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            // Build the notification and display it
            notificationManager.notify(2, builder.build());
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
