package com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.food;

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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodTypeDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentFoodReminder;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Calendar;
import java.util.Objects;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiverEarlyMorning extends BroadcastReceiver {
    public static final String TAG = "MyTag";
    FragmentFoodReminder mContext;
    MySharedPreference pref;
    static int JOB_ID = 1001;
    private  String CHANNEL_ID = "EarlyMor";

    @Override
    public void onReceive(Context context, Intent intent) {
//        EarlyMorningIntentService.enqueueWork(context,intent);
        //mContext.setAlarm_early_morning(context);
        showNotification(context);
        if (Build.VERSION.SDK_INT >= 24){
            setAlarm_early_morning(context);
        }
    }
    public void setAlarm_early_morning(Context context) {
        MySharedPreference pref = new MySharedPreference(context);
        FoodTypeDatabaseHelper db = new FoodTypeDatabaseHelper(context);
        String food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder", "Early Morning");
        if (food_status_remin.equalsIgnoreCase("active")) {
            String time = db.getTimeofReminder(pref.getUID(), "Food reminder", "Early Morning");
            String[] time_split = time.split(":");
            String time_hr = time_split[0];
            String time_min = time_split[1];
            int time_hr_int = Integer.parseInt(time_hr);
            int time_min_int = Integer.parseInt(time_min);
            AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiverEarlyMorning.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.EARLYMORNING");

            ComponentName receiver = new ComponentName(context, AlarmReceiverEarlyMorning.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            PendingIntent pi = PendingIntent.getBroadcast(context, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!

            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int);
            calendar.set(Calendar.MINUTE, time_min_int);
            calendar.set(Calendar.SECOND, 00);

            if (Build.VERSION.SDK_INT < 23) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            } else {
                RegisterEarlyReceiver(context);
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
//                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void showNotification(Context context){  pref = MySharedPreference.getInstance(context);
        mContext = new FragmentFoodReminder();
        String notificationTitle = "Early Morning";
        String notificationText = "A cup of tea is all you need to kick start your day. So make it perfect!";
        Intent intent = new Intent(context,MainActivityHealth.class);
        intent.putExtra("menuFragment","EarlyMorningReminder");
        if (pref.getNotificationOnOrOff()) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.universal_logo)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationText)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                    .setLights(Color.RED, 1000, 1000)
                    .setVibrate(new long[]{0, 400, 250, 400})

                    .setContentIntent(PendingIntent.getActivity(context, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT));
            if (pref.getNotificationSound()){
                builder.setDefaults(Notification.DEFAULT_SOUND);
            }
            // Get an instance of the NotificationManager service
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
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
    private void RegisterEarlyReceiver(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.EARLYMORNING");
        AlarmReceiverEarlyMorning myReceiver = new AlarmReceiverEarlyMorning();
        Objects.requireNonNull(context).getApplicationContext().registerReceiver(myReceiver,intent1);

    }
}