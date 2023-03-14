package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
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
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.alarmservices.AlarmReceiverUpdateStepsFitBit;
import com.universalsompo.meta.metaapp.health.alarmservices.AlarmReceiverUpdateStepsGoogleFit;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.database.DatabaseActivityID;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import at.grabner.circleprogress.CircleProgressView;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class FragmentStepsDetails extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    //private TextView month_year_txt;
    int year, month;
    String selected_date, selected_date1;
    String selected_date_fitbit, selected_date1_fitbit;
    private HorizontalCalendar horizontalCalendar;
    private int walking_steps;
    private float walking_calorie, walking_distance;
    private long walking_duration;
    private LinearLayout edit_exercise_goal;
    Dialog dialog;
    int step_count_target;
    String steps1;
    private TextView tv_totalgoal;
    private LineChart mChart;
    private String todate, fromdate;
    private ArrayList<Entry> yVals;
    private TextView tvfromdate, tvtodate;
    private TextView tv_totalcalsteps, tv_totaldursteps, tv_totaldistancesteps, tv_totalsteps, tv_steppercentage;
    private String TotalStepsGoal;
    CircleProgressView circleViewstatsexercise;
    private String Distance, Duration, Stepduration;
    public static final String TAG = "StepCounter";
    private float disInKm;
    Calendar calSet;
    final private static int RQS_1 = 1;
    int FLAG_FITBIT = 0;
    DatabaseActivityID activityID;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_step_details, container,false);
        prefrences = MySharedPreference.getInstance(getActivity());
        getcurrentdate();
        init();
        //getcurrentyear();
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        todate = df.format(c);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        fromdate = df.format(calendar.getTime());
        activityID = new DatabaseActivityID(getActivity());
        yVals = new ArrayList<Entry>();

        /*if (prefrences.getIsExerciseAlarm()) {

        } else {
            Calendar calNow = Calendar.getInstance();
            calSet = (Calendar) calNow.clone();
            calSet.set(Calendar.HOUR_OF_DAY, 23);
            calSet.set(Calendar.MINUTE, 59);
            calSet.set(Calendar.SECOND, 0);
            setAlarm(calSet);
        }*/
        SetAlarm();
        return v;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        selected_date = df.format(c);
        selected_date1 = selected_date;
        selected_date_fitbit = df1.format(c);
        selected_date1_fitbit = selected_date_fitbit;
    }

    void init() {
        edit_exercise_goal = v.findViewById(R.id.edit_exercise_goal);
        tv_totalgoal = v.findViewById(R.id.tv_totalgoal);
        mChart = v.findViewById(R.id.linechartexecise);
        tvfromdate = v.findViewById(R.id.tv_fromdateexer);
        tvtodate = v.findViewById(R.id.tv_todateexer);
        tv_totalcalsteps = v.findViewById(R.id.tv_totalcalsteps);
        tv_totaldursteps = v.findViewById(R.id.tv_totaldursteps);
        tv_totaldistancesteps = v.findViewById(R.id.tv_totaldistancesteps);
        tv_totalsteps = v.findViewById(R.id.tv_totalsteps);
        tv_steppercentage = v.findViewById(R.id.tv_steppercentage);
        circleViewstatsexercise = v.findViewById(R.id.circleViewstatsexercise);

        if (prefrences.getStepTarget() != null) {
            tv_totalgoal.setText("Target " + prefrences.getStepTarget() + " steps");
            TotalStepsGoal = prefrences.getStepTarget();
        } else {
            tv_totalgoal.setText("Target 10000 steps");
            prefrences.setStepTarget("10000");
        }

        edit_exercise_goal.setOnClickListener(this);

        FitnessOptions fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                .build();
        if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(getActivity()), fitnessOptions)) {
            readData();
        } else if (prefrences.getFibitUserId()!=null)
        {
            FLAG_FITBIT = 1;
            callFitBitData();
        }
        if (FLAG_FITBIT==1){
            setAlarm1(getActivity());
        }else {
            SetAlarm();
        }

        callApi3(RequestHealthConstants.GET_EXERCISE_LOG1);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 0);
        horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();
        // month_year_txt = v.findViewById(R.id.month_year_txt);

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String month1 = Integer.toString(date.get(Calendar.MONTH));
                String day_of_month, month3;
                if (date.get(Calendar.DAY_OF_MONTH) <= 9) {
                    day_of_month = "0" + date.get(Calendar.DAY_OF_MONTH);
                } else {
                    day_of_month = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
                }
                int month2 = Integer.parseInt(month1) + 1;
                if (month2 <= 9) {
                    month3 = "0" + month2;
                } else {
                    month3 = String.valueOf(month2);
                }
                selected_date = month3 + "/" + day_of_month + "/" + date.get(Calendar.YEAR);
                selected_date_fitbit = date.get(Calendar.YEAR)+"-"+month3+"-"+day_of_month;
                selected_date1_fitbit = selected_date_fitbit;

                if (selected_date.equalsIgnoreCase(selected_date1)) {
                    edit_exercise_goal.setVisibility(View.VISIBLE);
                }  else if (selected_date_fitbit.equalsIgnoreCase(selected_date1_fitbit)){
                    edit_exercise_goal.setVisibility(View.VISIBLE);
                } else {
                    edit_exercise_goal.setVisibility(View.GONE);
                }

                callApi1(RequestHealthConstants.GET_EXERCISE_LOG);
            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {

            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                return true;
            }
        });
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.edit_exercise_goal:
                editstepgoalDialog();
                break;
        }
    }

    private void callFitBitData(){
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://api.fitbit.com/1/user/"+prefrences.getFibitUserId()+"/activities/date/"+selected_date1_fitbit+".json";
        StringRequest postr = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
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
                    SimpleDateFormat sdf = new SimpleDateFormat("mm");
                    try {
                        Date dt = sdf.parse(String.valueOf(totalMin));
                        sdf = new SimpleDateFormat("HH:mm");
                        tv_totaldursteps.setText(sdf.format(dt) + " hours");
                        Stepduration = sdf.format(dt);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    JSONArray jsonArray = object.getJSONArray("distances");
                    JSONObject obj = jsonArray.getJSONObject(0);
                    String distance = obj.getString("distance");
//                    tv_totalsteps.setText(steps);
                    int tsteps = Integer.parseInt(steps);
                    printData2(tsteps);
                    walking_calorie = Float.parseFloat(cal);
                    tv_totalcalsteps.setText(cal + " Cal");
                    tv_totaldistancesteps.setText(distance);
                    disInKm = Float.parseFloat(distance);
                    Log.e("bhaikasam",response);
                    responsebuilder();
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
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                params.put("Authorization", "Bearer "+prefrences.getFitbitAccessToken());
                return params;
            }
        };
        queue.add(postr);
    }

    private void editstepgoalDialog() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        dialog = new Dialog(getActivity());
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.edit_steps_goal);

        LinearLayout cancel = dialog.findViewById(R.id.cancel);
        LinearLayout tvok = dialog.findViewById(R.id.tv_okwatergoal);
        final EditText steps_goal = dialog.findViewById(R.id.steps_goal);

        if (prefrences.getStepTarget() != null) {
            steps_goal.setText(prefrences.getStepTarget());
            steps1 = steps_goal.getText().toString();
        } else {
            steps_goal.setText("0");
            steps1 = steps_goal.getText().toString();
        }

        tvok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkUtils.isConnected(getContext())) {
                    if (steps_goal.getText().toString().equalsIgnoreCase(null) || steps_goal.getText().toString().equalsIgnoreCase("0")) {
                        Toast.makeText(getActivity(), "Please enter your steps goal", Toast.LENGTH_SHORT).show();
                    } else {
                        steps1 = steps_goal.getText().toString();
                        callApi(RequestHealthConstants.SAVE_STEP_TARGET, steps1);
                    }
                } else {
                    Toast.makeText(getContext(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void callApi(Integer id, String step2) {
        if (id == RequestHealthConstants.SAVE_STEP_TARGET) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
                object.put("UserID", prefrences.getUID());
                object.put("Steps", step2);
                object.put("Type", "1");
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_STEP_TARGET, this, RequestHealthConstants.SAVE_STEP_TARGET);
            req.execute();
        }
    }

    private void callApi1(Integer id) {
        if (id == RequestHealthConstants.GET_EXERCISE_LOG) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
                object.put("UserID", prefrences.getUID());
                object.put("Date", selected_date);
                object.put("Type", "1");
                object.put("NoOfdays", "7");
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_EXERCISE_LOG, this, RequestHealthConstants.GET_EXERCISE_LOG);
            req.execute();
        }
    }

    private void callApi2(Integer id, JSONArray arr) {
        if (id == RequestHealthConstants.SAVE_STEPS_EXERCISE_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
                object.put("UserID", prefrences.getUID());
                object.put("TargetCalories", String.valueOf((int) (Double.parseDouble(prefrences.getcaloriegoal()) / 5)));
                if (prefrences.getStepTarget() != null) {
                    object.put("TargetSteps", prefrences.getStepTarget());
                } else {
                    object.put("TargetSteps", "10000");
                }

                object.put("DboardExerciseLogListReq", arr);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_STEPS_EXERCISE_DATA, this, RequestHealthConstants.SAVE_STEPS_EXERCISE_DATA);
            req.execute();
        }
    }

    private void callApi3(Integer id) {
        if (id == RequestHealthConstants.GET_EXERCISE_LOG1) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
                object.put("UserID", prefrences.getUID());
                object.put("Date", selected_date);
                object.put("Type", "1");
                object.put("NoOfdays", "7");
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_EXERCISE_LOG1, this, RequestHealthConstants.GET_EXERCISE_LOG1);
            req.execute();
        }
    }

    private void readData() {
        DataReadRequest readRequest = queryDateFitnessData();

        Task<DataReadResponse> response = Fitness.getHistoryClient(getActivity(), GoogleSignIn.getLastSignedInAccount(getActivity())).readData(readRequest);
        response.addOnSuccessListener(new OnSuccessListener<DataReadResponse>() {
            @Override
            public void onSuccess(DataReadResponse dataReadResponse) {
                walking_steps = 0;
                walking_calorie = 0.0f;
                walking_distance = 0.0f;
                walking_duration = 0;
                printData(dataReadResponse);
                printData2(dataReadResponse);
                Log.e("gfitttt", "Walking data -->" + walking_steps + " walking_calorie " + walking_calorie + " walking_distance " + walking_distance + " walking_duration " + walking_duration);
                responsebuilder();
            }
        });
    }

    private DataReadRequest queryDateFitnessData() {
        Calendar startCalendar = Calendar.getInstance(Locale.getDefault());
        if (!selected_date.equals(selected_date1)) {
            StringTokenizer st = new StringTokenizer(selected_date, "/");
            String mm = st.nextToken();
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
                            SimpleDateFormat sdf = new SimpleDateFormat("mm");
                            String[] split = Stepduration.split(":");
                            String part1 = split[0];
                            String part2 = split[1];
                            String part3 = split[2];
                            if (!TextUtils.isEmpty(String.valueOf(Stepduration))) {
                                try {
                                    Date dt = sdf.parse(String.valueOf(Stepduration));
                                    tv_totaldursteps.setText(Stepduration.substring(0, 5) + " hours");
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                tv_totaldursteps.setText("00:00 hours");
                            }
                        }
                    }
                    if (dataSet.getDataType().getName().equals("com.google.calories.expended")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Calories dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat());
                            walking_calorie = walking_calorie + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat();
                            if (!TextUtils.isEmpty(String.valueOf(walking_calorie))) {
                                walking_calorie = Math.round(walking_calorie);
                                tv_totalcalsteps.setText((int) walking_calorie + " Cal");
                            } else {
                                tv_totalcalsteps.setText("0");
                            }
                        }
                    }
                    if (dataSet.getDataType().getName().equals("com.google.distance.delta")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Distance dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_DISTANCE).asFloat());
                            walking_distance = walking_distance + dataSet.getDataPoints().get(0).getValue(Field.FIELD_DISTANCE).asFloat();
                            disInKm = walking_distance / 1000;
                            disInKm = Math.round(disInKm);
                            if (!TextUtils.isEmpty(String.valueOf(disInKm))) {
                                tv_totaldistancesteps.setText(disInKm + " km");
                            } else {
                                tv_totaldistancesteps.setText("0 km");
                            }
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
        tv_totalsteps.setText(String.valueOf(walking_steps));
        CustomProgressBar(walking_steps);
        if (!TextUtils.isEmpty(TotalStepsGoal)) {
            double result = Math.round(((double) walking_steps / Double.parseDouble(TotalStepsGoal)) * 100);
            tv_steppercentage.setText(result + "%");
            LogUtils.showLog("percentage", " " + result);
        } else {
            if (!selected_date.equalsIgnoreCase(selected_date1)) {
                double result = Math.round(((double) walking_steps / 10000) * 100);
                tv_steppercentage.setText(result + "%");
            } else {
                double result = Math.round(((double) walking_steps / Double.parseDouble(prefrences.getStepTarget())) * 100);
                tv_steppercentage.setText(result + "%");
            }
        }
        Log.e(TAG, "ssssssSteps -->" + walking_steps);
    }

    private void printData2(int walking_steps)
    {
        tv_totalsteps.setText(String.valueOf(walking_steps));
        CustomProgressBar(walking_steps);
        if (!TextUtils.isEmpty(TotalStepsGoal)) {
            double result = Math.round(((double) walking_steps / Double.parseDouble(TotalStepsGoal)) * 100);
            tv_steppercentage.setText(result + "%");
            LogUtils.showLog("percentage", " " + result);
        } else {
            if (!selected_date.equalsIgnoreCase(selected_date1)) {
                double result = Math.round(((double) walking_steps / 10000) * 100);
                tv_steppercentage.setText(result + "%");
            } else {
                double result = Math.round(((double) walking_steps / Double.parseDouble(prefrences.getStepTarget())) * 100);
                tv_steppercentage.setText(result + "%");
            }
        }
        Log.e(TAG, "ssssssSteps -->" + walking_steps);
    }

    private void CustomProgressBar(int Value) {
        Activity activity = getActivity();
        if (isAdded() && activity != null){
            if (!TextUtils.isEmpty(TotalStepsGoal)) {
                circleViewstatsexercise.setMaxValue(Float.parseFloat(TotalStepsGoal));
            } else {
                circleViewstatsexercise.setMaxValue(10000);
            }
            circleViewstatsexercise.setValue(0);
            circleViewstatsexercise.setValueAnimated(Value);
            circleViewstatsexercise.setTextColor(getResources().getColor(R.color.white));
            circleViewstatsexercise.setBarColor(getResources().getColor(R.color.colorPrimary));
            circleViewstatsexercise.setBarWidth(8);
            circleViewstatsexercise.setRimColor(getResources().getColor(R.color.grey));
            circleViewstatsexercise.setRimWidth(8);
            circleViewstatsexercise.setOuterContourSize(0);
            circleViewstatsexercise.setInnerContourColor(0);
        }else{
            LayoutInflater result = null;
        }
    }


    static String getDuration(long diffTime) {
        String periodAsHH_MM_SS = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(diffTime),
                TimeUnit.MILLISECONDS.toMinutes(diffTime) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(diffTime) % TimeUnit.MINUTES.toSeconds(1));
        return periodAsHH_MM_SS;
    }

    private void responsebuilder () {
        JSONArray arr1 = new JSONArray();
        JSONObject obj = new JSONObject();
        try {
            obj.put("TotalStep", tv_totalsteps.getText().toString());
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
        callApi2(RequestHealthConstants.SAVE_STEPS_EXERCISE_DATA, arr1);
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        Activity activity = getActivity();
        if (isAdded() && activity != null){
            if (Tag == RequestHealthConstants.SAVE_STEP_TARGET) {
                if (object.optString("Message").equalsIgnoreCase("Success")) {
                    Log.e("Success" , "Successfully added");
                    prefrences.setStepTarget(steps1);
                    TotalStepsGoal = prefrences.getStepTarget();
                    dialog.dismiss();
                    tv_totalgoal.setText("Target " + prefrences.getStepTarget() + " steps");
                    FitnessOptions fitnessOptions = FitnessOptions.builder()
                            .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                            .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                            .build();
                    if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(getActivity()), fitnessOptions)) {
                        readData();
                    }
                } else {
                    Log.e("Unsuccess" , "Not added");
                }
            } else if (Tag == RequestHealthConstants.GET_EXERCISE_LOG) {
                if (object.optString("Message").equalsIgnoreCase("Success")) {
                    if (!selected_date.equalsIgnoreCase(selected_date1)) {
                        try{
                            Distance = object.getString("Distance");
                            Duration = object.getString("Duration");
                            String TargetSteps = object.getString("TargetSteps");
                            String TotalSteps = object.getString("TotalSteps");
                            String TotalCalories = object.getString("TotalCalories");

                            if ((Distance.equals("0.0") || Distance.equals("0")) && (Duration.equals("0") || Duration.equals("null"))) {
                                if (FLAG_FITBIT==1) {
                                    callFitBitData();
                                } else {
                                    FitnessOptions fitnessOptions = FitnessOptions.builder()
                                            .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                                            .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                                            .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                                            .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                                            .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                                            .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                                            .build();
                                    if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(getActivity()), fitnessOptions)) {
                                        readData();
                                    }
                                }
                            } else {
                                if (!TotalCalories.equals("0")) {
                                    float Cal = Float.parseFloat(TotalCalories);
                                    Cal = Math.round(Cal);
                                    TotalCalories = String.valueOf((int) Cal);
                                }
                                float distance = 0;
                                if (!TextUtils.isEmpty(Distance)) {
                                    distance = Float.parseFloat(Distance);
                                }

                                tv_totalsteps.setText(TotalSteps);
                                tv_totaldistancesteps.setText(distance + " km");
                                String[] split = Duration.split(":");
                                String part1 = split[0];
                                String part2 = split[1];
                                String part3 = split[2];
                                tv_totaldursteps.setText(part1 + ":" + part2 + " hours");
                                tv_totalcalsteps.setText(Integer.parseInt(TotalCalories) + " Cal");
                                tv_totalgoal.setText("Target " + TargetSteps + " steps");
                                double result = Math.round((Double.parseDouble(TotalSteps) / Double.parseDouble(TargetSteps)) * 100);
                                tv_steppercentage.setText(result + "%");

                                if (!TextUtils.isEmpty(TargetSteps) && !TextUtils.isEmpty(TotalSteps)) {
                                    circleViewstatsexercise.setMaxValue(Integer.parseInt(TargetSteps));
                                    circleViewstatsexercise.setValue(Integer.parseInt(TotalSteps));
                                }
                            }
                        } catch (Exception e) { }

                        try {
                            yVals = new ArrayList<Entry>();
                            JSONArray jsonArray = object.getJSONArray("DBoardUsersExerciseChartLogRes");
                            if (jsonArray.length() == 0) {
                                mChart.setVisibility(View.GONE);
                                tvfromdate.setVisibility(View.GONE);
                                tvtodate.setVisibility(View.GONE);
                            } else {
                                mChart.setVisibility(View.VISIBLE);
                                tvfromdate.setVisibility(View.VISIBLE);
                                tvtodate.setVisibility(View.VISIBLE);
                                ArrayList<String> DateofRecord = new ArrayList<String>();
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String InCalories = jsonObject.getString("TotalCalaries");
                                    DateofRecord.add(jsonObject.getString("Date"));

                                    StringTokenizer st = new StringTokenizer(InCalories, " ");
                                    String str = st.nextToken();
                                    float f = Float.parseFloat(str);
                                    yVals.add(new Entry(i, f));
                                }
                                int size = DateofRecord.size();
                                tvfromdate.setText(DateofRecord.get(0));
                                tvtodate.setText(DateofRecord.get(size - 1));
                                getChartView();
                            }
                        } catch (Exception ex) {

                        }
                    } else {
                        if (prefrences.getStepTarget() != null) {
                            tv_totalgoal.setText("Target " + prefrences.getStepTarget() + " steps");
                        } else {
                            tv_totalgoal.setText("Target " + "10000" + " steps");
                        }

                        if (FLAG_FITBIT==1){
                            callFitBitData();
                        }else {
                            FitnessOptions fitnessOptions = FitnessOptions.builder()
                                    .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                                    .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                                    .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                                    .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                                    .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                                    .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                                    .build();
                            if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(getActivity()), fitnessOptions)) {
                                readData();
                            }
                        }
                    }
                } else {
                    if (prefrences.getStepTarget() != null) {
                        tv_totalgoal.setText("Target " + prefrences.getStepTarget() + " steps");
                    } else {
                        tv_totalgoal.setText("Target " + "10000" + " steps");
                    }

                    if (FLAG_FITBIT==1){
                        callFitBitData();
                    } else {
                        FitnessOptions fitnessOptions = FitnessOptions.builder()
                                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                                .addDataType(DataType.AGGREGATE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                                .addDataType(DataType.TYPE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                                .addDataType(DataType.AGGREGATE_CALORIES_EXPENDED, FitnessOptions.ACCESS_READ)
                                .addDataType(DataType.TYPE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                                .addDataType(DataType.AGGREGATE_DISTANCE_DELTA, FitnessOptions.ACCESS_READ)
                                .build();
                        if (GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(getActivity()), fitnessOptions)) {
                            readData();
                        }
                    }
                }
            } else if (Tag == RequestHealthConstants.SAVE_STEPS_EXERCISE_DATA) {
                if (object.optString("Message").equalsIgnoreCase("Success")) {
                    Log.e("Message", "Successfully Added");
                } else {
                    Log.e("Message", "Not Added");
                }
            } else if (Tag == RequestHealthConstants.GET_EXERCISE_LOG1) {
                if (object.optString("Message").equalsIgnoreCase("Success")) {
                    try {
                        yVals = new ArrayList<Entry>();
                        JSONArray jsonArray = object.getJSONArray("DBoardUsersExerciseChartLogRes");
                        if (jsonArray.length() == 0) {
                            mChart.setVisibility(View.GONE);
                            tvfromdate.setVisibility(View.GONE);
                            tvtodate.setVisibility(View.GONE);
                        } else {
                            mChart.setVisibility(View.VISIBLE);
                            tvfromdate.setVisibility(View.VISIBLE);
                            tvtodate.setVisibility(View.VISIBLE);
                            ArrayList<String> DateofRecord = new ArrayList<String>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String InCalories = jsonObject.getString("TotalCalaries");
                                DateofRecord.add(jsonObject.getString("Date"));

                                StringTokenizer st = new StringTokenizer(InCalories, " ");
                                String str = st.nextToken();
                                float f = Float.parseFloat(str);
                                yVals.add(new Entry(i, f));
                            }
                            int size = DateofRecord.size();
                            tvfromdate.setText(DateofRecord.get(0));
                            tvtodate.setText(DateofRecord.get(size - 1));
                            getChartView();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            LayoutInflater result = null;
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void getChartView() {
        mChart.setDrawGridBackground(false);
        mChart.getAxisLeft().setStartAtZero(true);
        setData();

        mChart.getAxisRight().setEnabled(false);
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setEnabled(true);
        mChart.setDrawGridBackground(true);
        leftAxis.setGranularityEnabled(true);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setGranularityEnabled(true);
        xAxis.setDrawGridLines(false);

        mChart.getXAxis().setDrawLabels(false);
        mChart.getLegend().setEnabled(false);

        mChart.getAxisRight().setDrawLabels(true);
        mChart.getAxisLeft().setDrawLabels(true);
        mChart.getLegend().setEnabled(true);

        Description description = new Description();
        description.setText("");
        mChart.setDescription(description);
        mChart.setTouchEnabled(false);
        mChart.setDragEnabled(false);
        mChart.setScaleEnabled(false);
        mChart.animateX(2500, Easing.EasingOption.EaseInOutQuart);
        mChart.invalidate();
    }

    private void setData() {
        final ArrayList<String> yy = new ArrayList<String>();
        yy.add("0");
        yy.add("100");
        yy.add("400");
        yy.add("800");
        yy.add("1200");

        LineDataSet dataSet = new LineDataSet(yVals, "All data in Calories");
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(5f);
        dataSet.setDrawCircleHole(true);
        dataSet.setColor(getResources().getColor(R.color.colorPrimary));
        dataSet.setCircleColor(getResources().getColor(R.color.colorPrimary));
        dataSet.setHighLightColor(getResources().getColor(R.color.white));
        dataSet.setDrawFilled(true);

        LineData data = new LineData(dataSet);
        ((LineDataSet) data.getDataSetByIndex(0)).setCircleColorHole(getResources().getColor(R.color.white));

        mChart.getDescription().setEnabled(false);
        mChart.setDrawGridBackground(false);
        mChart.setTouchEnabled(true);
        mChart.setBorderColor(getResources().getColor(R.color.colorPrimary));
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setPinchZoom(false);

        YAxis yAxisLeft = mChart.getAxisLeft();
        yAxisLeft.setTextColor(getResources().getColor(R.color.colorPrimary));
        yAxisLeft.setAxisLineColor(getResources().getColor(R.color.colorPrimary));

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
        xAxis.setAxisLineColor(getResources().getColor(R.color.colorPrimary));

        YAxis yAxis = mChart.getAxisLeft();
        yAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
        yAxis.setAxisLineColor(getResources().getColor(R.color.colorPrimary));
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.isDrawLabelsEnabled();
        yAxis.setDrawGridLines(false);

        mChart.animateX(2500);
        mChart.getLegend().setEnabled(false);
        mChart.setData(data);
        mChart.invalidate();
    }

    private void SetAlarm() {
        setAlarm(getContext());
        /*Calendar current = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 56);
        cal.set(Calendar.SECOND, 10);
        if (cal.getTimeInMillis() < System.currentTimeMillis())
            cal.add(Calendar.DAY_OF_MONTH, 1);
        if (cal.compareTo(current) <= 0) {
            Toast.makeText(getContext(), "Please correct your device Date", Toast.LENGTH_LONG).show();
        } else {
            setAlarm(cal);
        }*/
    }

    /*private void setAlarm(Calendar cal) {
        Intent intent = new Intent(getActivity(), AlarmReceiverUpdateStepsGoogleFit.class);
        if (Build.VERSION.SDK_INT < 23) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), RQS_1, intent, 0);
            AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), RQS_1, intent, 0);
            AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
        }
    }*/

    public void setAlarm(Context context) {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiverUpdateStepsGoogleFit.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 23) {
            Log.e(TAG, "Alarm will schedule for next day!");
            calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
        }
        else{
            Log.e(TAG, "Alarm will schedule for today!");
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 55);
        calendar.set(Calendar.SECOND, 10);

        if (Build.VERSION.SDK_INT < 23) {
            am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            //am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        }
    }

    public void setAlarm1(Context context) {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiverUpdateStepsFitBit.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 23) {
            Log.e(TAG, "Alarm will schedule for next day!");
            calendar.add(Calendar.DAY_OF_YEAR, 1); // add, not set!
        }
        else{
            Log.e(TAG, "Alarm will schedule for today!");
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 55);
        calendar.set(Calendar.SECOND, 10);
        if (Build.VERSION.SDK_INT < 23) {
            am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
            am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
            //am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        }
    }
}
