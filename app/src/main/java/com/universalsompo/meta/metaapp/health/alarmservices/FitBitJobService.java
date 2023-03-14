package com.universalsompo.meta.metaapp.health.alarmservices;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FitBitJobService extends JobIntentService implements ResponseListener {
    static int JOB_ID = 1541;
    public static final String TAG = "MyTag";
    MySharedPreference pref;
    private int walking_steps;
    private float walking_calorie;
    private String  Stepduration;
    private float disInKm;
    String selected_date_fitbit, selected_date1_fitbit;
    String selected_date, selected_date1;
    Context context;


    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, FitBitJobService.class, JOB_ID, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        pref = MySharedPreference.getInstance(context);
        getcurrentdate();
        callFitBitData();
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        selected_date1 = selected_date;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        selected_date_fitbit = df1.format(c);
        selected_date1_fitbit = selected_date_fitbit;
    }

    private void callApi2(JSONArray arr, Context context) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
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

    private void callFitBitData(){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.fitbit.com/1/user/"+pref.getFibitUserId()+"/activities/date/"+selected_date1_fitbit+".json";
        StringRequest postr = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @SuppressLint("SimpleDateFormat")
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject object = jsonObject.getJSONObject("summary");
                    String steps = object.getString("steps");
                    String cal = object.getString("caloriesOut");
                    String fairlyActive= object.getString("fairlyActiveMinutes");
                    String lightlyActive= object.getString("lightlyActiveMinutes");
                    String veryActive= object.getString("veryActiveMinutes");
                    float totalMin = Float.parseFloat(fairlyActive)+Float.parseFloat(lightlyActive)+Float.parseFloat(veryActive);
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("mm");
                    walking_steps = Integer.parseInt(steps);
                    try {
                        Date dt = sdf.parse(String.valueOf(totalMin));
                        sdf = new SimpleDateFormat("HH:mm");
                        Stepduration = sdf.format(dt);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    JSONArray jsonArray = object.getJSONArray("distances");
                    JSONObject obj = jsonArray.getJSONObject(0);
                    String distance = obj.getString("distance");
                    walking_calorie = Float.parseFloat(cal);
                    disInKm = Float.parseFloat(distance);
                    responsebuilder(context);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() {
                Map<String,String> params = new HashMap<>();

                params.put("Content-Type", "application/x-www-form-urlencoded");
                params.put("Authorization", "Bearer "+pref.getFitbitAccessToken());
                return params;
            }
        };
        queue.add(postr);
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

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_STEPS_EXERCISE_DATA) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                Log.e("Message", "Successfully Added");
                String notificationTitle = "Meta";
                String notificationText = "Updated fitness data successfully";
                if (pref.getNotificationOnOrOff()) {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
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
                    notificationManager.notify(1, builder.build());
                } else {
                    Log.e("Message", "Not Added");
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
