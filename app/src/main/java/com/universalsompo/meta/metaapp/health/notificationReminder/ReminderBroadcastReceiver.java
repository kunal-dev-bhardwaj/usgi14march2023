package com.universalsompo.meta.metaapp.health.notificationReminder;

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
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import static android.content.Context.NOTIFICATION_SERVICE;

public class ReminderBroadcastReceiver extends BroadcastReceiver {
    MySharedPreference pref;
    ReminderDatabase db;
    String notificationText;
    String CHANNEL_ID;
    @Override
    public void onReceive(Context context, Intent intent) {
        String activityName = intent.getStringExtra("activity");
        showNotification(context, activityName);
    }


    private void showNotification(Context context, String activityName){
        pref = MySharedPreference.getInstance(context);
        db = new  ReminderDatabase(context);
        switch (activityName){
            case "BloodPressure":
                notificationText = "Please enter your blood pressure readings to complete your health profile";
            case "BloodSugar":
                notificationText = "Please enter your blood sugar readings to complete your health profile";
            case "HbA":
                notificationText = "Please enter your HbA1c value to complete your health profile";
            case "LipidProfile":
                notificationText = "Please enter your cholesterol readings to complete your health profile";
            case "Thyroid":
                notificationText = "Please enter your thyroid readings to complete your health profile";
            case "Allergies":
                notificationText = "Please enter your allergies to complete your health profile";
            case "MedicalHistory":
                notificationText = "Your medical history, if any, and complete your health profile";
            case "FamilyHistory":
                notificationText = "Enter your family history, if any, and complete your health profile";
            case "FitnessDevices":
                notificationText = "Connect to a fitness device and track how many calories you burn in a day!";
            case "MedicalRecords":
                notificationText = "Digitize all your medical records and access them on the go!";
            case "WaterData":
                notificationText = "Track your daily water intake and reach your water goal!";
            case "WeightData":
                notificationText = "a weight goal & track your progress by logging your weight on regular basis";
            case "FoodData":
                notificationText = "Keep track of your daily calorie intake by entering what you ate throughout the day";
        }
        if (pref.getNotificationOnOrOff()) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(activityName)
                    .setContentText(notificationText)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})
                    .setContentIntent(PendingIntent.getActivity(context, 3, new Intent(context, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
            // Build the notification and display it
            notificationManager.notify(3, builder.build());
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
