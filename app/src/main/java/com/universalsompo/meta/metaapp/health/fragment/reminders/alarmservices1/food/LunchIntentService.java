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

public class LunchIntentService extends JobIntentService {
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    static int JOB_ID = 1003;
    FragmentFoodReminder mContext;
    private  String CHANNEL_ID = "Lunch";


    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, LunchIntentService.class, JOB_ID, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        pref = MySharedPreference.getInstance(LunchIntentService.this);
        mContext = new FragmentFoodReminder();
        String notificationTitle = "Lunch";
        String notificationText = "Keep calm and take your lunch break!";
        if (pref.getNotificationOnOrOff()) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(LunchIntentService.this,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(LunchIntentService.this, 4, new Intent(LunchIntentService.this, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) LunchIntentService.this.getSystemService(NOTIFICATION_SERVICE);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            // Build the notification and display it
            notificationManager.notify(4, builder.build());

            //mContext.setAlarm_lunch(context);
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
