package com.universalsompo.meta.metaapp.health.alarmservices;

import android.annotation.SuppressLint;
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
import androidx.core.app.NotificationCompat;
import android.os.Build;
import android.util.Log;
import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class AlarmReceiverUpdateTargets extends BroadcastReceiver implements ResponseListener {
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    String date;
    Context context;
    public static String CHANNEL_ID = "UpdateTargets";


    @Override
    public void onReceive(Context context, Intent intent) {
        pref = MySharedPreference.getInstance(context);
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        date = df.format(c);
        callApi(context);
        if (Build.VERSION.SDK_INT >= 24) {
            setAlarm(context);
        }
    }

    private void callApi(Context a) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
            object.put("UserID", pref.getUID());
            if (pref.getWaterGlassTarget() != null) {
                object.put("WaterTarget", pref.getWaterGlassTarget());
            } else {
                object.put("WaterTarget", "8");
            }
            if (pref.getTargetweight() != null) {
                object.put("WeightTarget", pref.getTargetweight());
            } else {
                object.put("WeightTarget", "0");
            }
            int exercise_goal = (int) (Double.parseDouble(pref.getcaloriegoal()) / 5);
            object.put("ExerciseTarget", String.valueOf(exercise_goal));
            if (pref.getcaloriegoal() != null) {
                object.put("FoodTarget", pref.getcaloriegoal());
                object.put("TargetCalories", String.valueOf((int) Double.parseDouble(pref.getcaloriegoal()) / 5));
            } else {
                object.put("FoodTarget", "");
                object.put("TargetCalories", "");
            }
            if (pref.getlossgain_txt() != null) {
                object.put("LoseGain", pref.getlossgain_txt());
            } else {
                object.put("LoseGain", "");
            }
            object.put("ActivityType", "");
            object.put("Date", date);
            if (pref.getlossgain() != null) {
                object.put("LoseGainBy", String.valueOf(Double.parseDouble(pref.getlossgain())));
            } else {
                object.put("LoseGainBy", "");
            }
            if (pref.getweight() != null) {
                object.put("CurrentWeight", pref.getweight());
            } else {
                object.put("CurrentWeight", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(a, object, UrlHealthConstants.SAVE_TARGETS, this, RequestHealthConstants.SAVE_TARGETS);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_TARGETS) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                Log.e("Success", "Successfully added");
                String notificationTitle = "USGI-PULZ";
                String notificationText = "Data updated successfully";
                if (pref.getNotificationOnOrOff()){


                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                            .setAutoCancel(true)
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle(notificationTitle)
                            .setContentText(notificationText)
                            .setLights(Color.RED, 1000, 1000)
                            .setVibrate(new long[]{0, 400, 250, 400})
                            .setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
                    if (pref.getNotificationSound()){
                        builder.setDefaults(Notification.DEFAULT_SOUND);
                    }
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);
                    notificationManager.notify(0, builder.build());
                } else {
                    Log.e("Unsuccess", "Not added successfully");
                }
            }
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
    @Override
    public void onError(VolleyError error, int Tag) {

    }

    public void setAlarm(Context context) {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent();
        intent.setClass(context, AlarmReceiverUpdateTargets.class);
        intent.setPackage("com.universalsompo.meta");
        intent.setAction("com.universalsompo.meta.UpdateTargets");
        ComponentName receiver = new ComponentName(context, AlarmReceiverUpdateTargets.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 4) {
            calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
        } else {
            Log.e(TAG, Objects.requireNonNull(context).getResources().getString(R.string.schedule_for_today));
        }
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 55);
        calendar.set(Calendar.SECOND, 10);

        if (Build.VERSION.SDK_INT < 23) {
            am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
        } else {
            RegisterUpdateTargets(context);
            context.startService(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        }
    }

    private void RegisterUpdateTargets(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.UpdateTargets");
        AlarmReceiverUpdateTargets myReceiver = new AlarmReceiverUpdateTargets();
        context.getApplicationContext().registerReceiver(myReceiver,intent1);
    }
}
