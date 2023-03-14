package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.medicine;

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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.MedicineReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Calendar;
import java.util.Objects;

public class AlarmMedicineReceiver extends BroadcastReceiver {
    static int JOB_ID = 8630;
    MySharedPreference pref;
    MedicineReminderDatabaseHelper db;
    String med_id;
    private  String CHANNEL_ID = "Medicine";

    @Override
    public void onReceive(Context context, Intent intent) {
//        MedicineJobService.enqueueWork(context,intent);
        med_id = intent.getStringExtra("med_id");
        showNotification(med_id,context);
        if (Build.VERSION.SDK_INT >= 24) {
            setAlarm_Medicine(context,med_id);
        }
    }

    private void setAlarm_Medicine(Context context, String med_id) {
        MySharedPreference pref = new MySharedPreference(context);
        MedicineReminderDatabaseHelper db = new MedicineReminderDatabaseHelper(context);
        String med_status_remin = db.getStatusofReminder(pref.getUID());
        if (med_status_remin.equalsIgnoreCase("active")) {

            String time_medicine = db.getTimeofReminder(pref.getUID(), med_id);
            String[] time_split_labtest = time_medicine.split(":");
            String time_hr_labtest = time_split_labtest[0];
            String time_min_labtest = time_split_labtest[1];
            int time_hr_int_labtest = Integer.parseInt(time_hr_labtest);
            int time_min_int_labtest = Integer.parseInt(time_min_labtest);

            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmMedicineReceiver.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.MEDICINE");
            intent.putExtra("med_id", med_id);

            ComponentName receiver = new ComponentName(context, AlarmMedicineReceiver.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            PendingIntent pi = PendingIntent.getBroadcast(context, Integer.parseInt(med_id), intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
            calendar.set(Calendar.MINUTE, time_min_int_labtest);
            calendar.set(Calendar.SECOND, 0);

            if (Build.VERSION.SDK_INT < 23) {
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            } else {
                RegisterMedicine(context);
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void RegisterMedicine(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.MEDICINE");
        AlarmMedicineReceiver myReceiver = new AlarmMedicineReceiver();
        Objects.requireNonNull(context).registerReceiver(myReceiver,intent1);
    }
    private void showNotification(String med_id, Context context){
        pref = MySharedPreference.getInstance(context);
        db = new MedicineReminderDatabaseHelper(context);

        if (pref.getNotificationOnOrOff()){
            String notificationTitle = "Medicine Reminder";
            String notificationText = "Hello there! It’s time to take your Medicine";
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationText)
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(context, 2000, new Intent(context, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(MedicineJobService.NOTIFICATION_SERVICE);
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
