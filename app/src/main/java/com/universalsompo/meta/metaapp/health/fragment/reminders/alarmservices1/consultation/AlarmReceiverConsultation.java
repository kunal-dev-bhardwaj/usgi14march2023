package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.consultation;

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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.ConsultationReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiverConsultation extends BroadcastReceiver {
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    ConsultationReminderDatabaseHelper db;
    String date;
    String con_id, docname;
    static int JOB_ID = 0000;
    private  String CHANNEL_ID = "Consultation";

    @Override
    public void onReceive(Context context, Intent intent) {

        con_id = intent.getStringExtra("conid");
        docname = intent.getStringExtra("docname");
        showNotification(con_id,docname,context);
    }

    private void showNotification(String con_id, String docname, Context context){
        pref = MySharedPreference.getInstance(context);
        db = new ConsultationReminderDatabaseHelper(context);
//        Uri sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getPackageName() + "/" + R.raw.);

        String notificationTitle = "Consultation";
        String notificationText = "You have an upcoming consultation with " + docname + " today.";
        if (pref.getNotificationOnOrOff()){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})
//                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
                    .setContentIntent(PendingIntent.getActivity(context, Integer.parseInt(con_id), new Intent(context, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);

            // Build the notification and display it
            notificationManager.notify(Integer.parseInt(con_id), builder.build());
        }
        db.deleteLabtest(pref.getUID(), con_id);
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
