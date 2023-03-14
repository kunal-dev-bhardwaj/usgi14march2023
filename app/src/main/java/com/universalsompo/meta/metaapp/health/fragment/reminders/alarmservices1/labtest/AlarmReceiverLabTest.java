package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.labtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.LabTestReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiverLabTest extends BroadcastReceiver {
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    static int JOB_ID = 2001;
    LabTestReminderDatabaseHelper db;
    String date;
    String lab_id, testname, labname;
    private  String CHANNEL_ID = "LabTest";

    @Override
    public void onReceive(Context context, Intent intent) {
        lab_id = intent.getStringExtra("labid");
        testname = intent.getStringExtra("testname");
        labname = intent.getStringExtra("labname");
//        LabTestIntentService.enqueueWork(context,intent);
        showNotification(lab_id,testname,labname,context);

    }

    private void showNotification(String lab_id, String testname, String labname, Context context){
        pref = MySharedPreference.getInstance(context);
        db = new LabTestReminderDatabaseHelper(context);

        String notificationTitle = "Lab Test";
        String notificationText = "Your " + testname +" test is scheduled at " + labname + " today.";
        if (pref.getNotificationOnOrOff()) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(context, Integer.parseInt(lab_id), new Intent(context, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);

            // Build the notification and display it
            notificationManager.notify(Integer.parseInt(lab_id), builder.build());
        }
        long status_update = db.updateStatusofReminder(pref.getUID(), lab_id, "deactive");
        db.deleteLabtest(pref.getUID(), lab_id);
        //mContext.setAlarm_breakfast(context);
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