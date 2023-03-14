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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class AlarmReceiverUpdateStepsGoogleFit extends BroadcastReceiver implements ResponseListener {
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    private int walking_steps;
    private float walking_calorie, walking_distance;
    private long walking_duration;
    private String Stepduration;
    private float disInKm;
    String selected_date, selected_date1;
    Context context;
    private String CHANNEL_ID = "UpdateGoogleFit";

    @Override
    public void onReceive(final Context context, Intent intent) {
        this.context = context;
        pref = MySharedPreference.getInstance(context);
        getcurrentdate();
        FitnessOptions fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .build();
        if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(context), fitnessOptions)) {
            DataReadRequest readRequest = queryDateFitnessData();
            Task<DataReadResponse> response = Fitness.getHistoryClient(context, Objects.requireNonNull(GoogleSignIn.getLastSignedInAccount(context))).readData(readRequest);
            response.addOnSuccessListener(new OnSuccessListener<DataReadResponse>() {
                @Override
                public void onSuccess(DataReadResponse dataReadResponse) {
                    walking_steps = 0;
                    walking_calorie = 0.0f;
                    walking_distance = 0.0f;
                    walking_duration = 0;
                    printData(dataReadResponse);
                    printData2(dataReadResponse);
                    responsebuilder(context);
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 24) {
            setAlarm(context);
        }
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        selected_date1 = selected_date;
    }

    private DataReadRequest queryDateFitnessData() {
        Calendar startCalendar = Calendar.getInstance(Locale.getDefault());
        if (!selected_date.equals(selected_date1)) {
            StringTokenizer st = new StringTokenizer(selected_date, "/");
            String dd = st.nextToken();
            int DD = Integer.parseInt(dd);
            startCalendar.set(Calendar.DAY_OF_MONTH, DD);
        }
        startCalendar.set(Calendar.HOUR_OF_DAY, 23);
        startCalendar.set(Calendar.MINUTE, 59);
        startCalendar.set(Calendar.SECOND, 59);
        startCalendar.set(Calendar.MILLISECOND, 999);
        long endTime = startCalendar.getTimeInMillis();

        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        long startTime = startCalendar.getTimeInMillis();

        return new DataReadRequest.Builder()
                .aggregate(DataType.TYPE_CALORIES_EXPENDED, DataType.AGGREGATE_CALORIES_EXPENDED)
                .aggregate(DataType.TYPE_DISTANCE_DELTA, DataType.AGGREGATE_DISTANCE_DELTA)
                .aggregate(DataType.TYPE_STEP_COUNT_DELTA, DataType.AGGREGATE_STEP_COUNT_DELTA)
                .bucketByActivitySegment(1, TimeUnit.MILLISECONDS)
                .setTimeRange(startTime, endTime, TimeUnit.MILLISECONDS)
                .build();
    }

    private void printData(DataReadResponse dataReadResult) {
        walking_duration = 0;
        walking_calorie = 0;
        walking_distance = 0;
        for (Bucket bucket : dataReadResult.getBuckets()) {
            String bucketActivity = bucket.getActivity();
            if (bucketActivity.contains(FitnessActivities.WALKING)) {
                List<DataSet> dataSetx = bucket.getDataSets();
                for (DataSet dataSet : dataSetx) {
                    if (dataSet.getDataType().getName().equals("com.google.step_count.delta")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Steps -->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt());
                            Log.e(TAG, "datapoints -->" + dataSet.getDataPoints().get(0).getStartTime(TimeUnit.MILLISECONDS) + " -- " + dataSet.getDataPoints().get(0).getEndTime(TimeUnit.MILLISECONDS));
                            long diffTime = dataSet.getDataPoints().get(0).getEndTime(TimeUnit.MILLISECONDS) - dataSet.getDataPoints().get(0).getStartTime(TimeUnit.MILLISECONDS);
                            walking_duration = walking_duration + diffTime;
                            Stepduration = getDuration(walking_duration);
                        }
                    }
                    if (dataSet.getDataType().getName().equals("com.google.calories.expended")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Calories dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat());
                            walking_calorie = walking_calorie + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat();
                            walking_calorie = Math.round(walking_calorie);
                        }
                    }
                    if (dataSet.getDataType().getName().equals("com.google.distance.delta")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Distance dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_DISTANCE).asFloat());
                            walking_distance = walking_distance + dataSet.getDataPoints().get(0).getValue(Field.FIELD_DISTANCE).asFloat();
                            disInKm = walking_distance / 1000;
                            disInKm = Math.round(disInKm);
                        }
                    }
                }
            }
        }
    }

    private void printData2(DataReadResponse dataReadResult) {
        Log.d("tag", String.valueOf(dataReadResult.getBuckets().size()));
        walking_steps = 0;
        for (Bucket bucket : dataReadResult.getBuckets()) {

            List<DataSet> dataSetx = bucket.getDataSets();

            for (DataSet dataSet : dataSetx) {
                if (dataSet.getDataType().getName().equals("com.google.step_count.delta")) {
                    try {
                        walking_steps = walking_steps + dataSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    static String getDuration(long diffTime) {
        @SuppressLint("DefaultLocale") String periodAsHH_MM_SS = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(diffTime),
                TimeUnit.MILLISECONDS.toMinutes(diffTime) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(diffTime) % TimeUnit.MINUTES.toSeconds(1));
        return periodAsHH_MM_SS;
    }

    private void responsebuilder (Context context) {
        JSONArray arr1 = new JSONArray();
        JSONObject obj = new JSONObject();
        try {
            obj.put("TotalStep", walking_steps);
            obj.put("Calories", String.valueOf(walking_calorie));
            obj.put("Duration", String.valueOf(Stepduration));
            obj.put("Distance", String.valueOf(disInKm));
            obj.put("Type", "1");
            obj.put("Date", selected_date);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        arr1.put(obj);
        callApi2(arr1, context);
    }

    private void callApi2(JSONArray arr, Context context) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("TargetCalories", String.valueOf((int) (Double.parseDouble(pref.getcaloriegoal()) / 5)));
            if (pref.getStepTarget() != null) {
                object.put("TargetSteps", pref.getStepTarget());
            } else {
                object.put("TargetSteps", "5000");
            }
            object.put("DboardExerciseLogListReq", arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(context, object, UrlHealthConstants.SAVE_STEPS_EXERCISE_DATA, this, RequestHealthConstants.SAVE_STEPS_EXERCISE_DATA);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_STEPS_EXERCISE_DATA) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                Log.e("Message", "Successfully Added");
                String notificationTitle = "USGI-PULZ";
                String notificationText = "Updated fitness data successfully";
                if (pref.getNotificationOnOrOff()) {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                            .setAutoCancel(true)
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle(notificationTitle)
                            .setContentText(notificationText)
                            .setLights(Color.RED, 1000, 1000)
                            .setVibrate(new long[]{0, 400, 250, 400})
                            .setContentIntent(PendingIntent.getActivity(context, 1, new Intent(context, MainActivityHealth.class), PendingIntent.FLAG_UPDATE_CURRENT));
                    if (pref.getNotificationSound()){
                        builder.setDefaults(Notification.DEFAULT_SOUND);
                    }
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(notificationManager);

                    notificationManager.notify(1, builder.build());
                } else {
                    Log.e("Message", "Not Added");
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
    public void onError(VolleyError error, int Tag) { }

    public void setAlarm(Context context) {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent();
        intent.setClass(context,AlarmReceiverUpdateStepsGoogleFit.class);
        intent.setPackage("com.universalsompo.meta");
        intent.setAction("com.universalsompo.meta.UpdateGoogleFit");
        ComponentName receiver = new ComponentName(context, AlarmReceiverUpdateStepsGoogleFit.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        PendingIntent pi = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 55);
        calendar.set(Calendar.SECOND, 10);

        if (Build.VERSION.SDK_INT < 23) {
            am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
        } else {
            RegisterGoogleFit(context);
            context.startService(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        }
    }

    private void RegisterGoogleFit(Context context){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.UpdateGoogleFit");
        AlarmReceiverUpdateStepsGoogleFit myReceiver = new AlarmReceiverUpdateStepsGoogleFit();
        context.getApplicationContext().registerReceiver(myReceiver,intent1);
    }
}
