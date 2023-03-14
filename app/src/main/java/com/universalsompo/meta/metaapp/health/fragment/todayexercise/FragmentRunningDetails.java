package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
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
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class FragmentRunningDetails extends Fragment implements ResponseListener {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    // private TextView month_year_txt;
    int year, month;
    String selected_date, selected_date1;
    private HorizontalCalendar horizontalCalendar;
    private int running_steps;
    private float running_calorie, running_distance;
    private long running_duration;
    private LineChart mChart;
    private String todate, fromdate;
    private ArrayList<Entry> yVals;
    private TextView tvfromdate, tvtodate;
    private TextView tv_totalcalsteps, tv_totaldursteps/*, tv_totaldistancesteps*//*, tv_totalsteps*/;
    // CircleProgressView circleViewstatsexercise;
    private String Distance, Duration, Runningduration;
    public static final String TAG = "RunningCounter";
    private float disInKm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_running_details, container,false);
        prefrences = MySharedPreference.getInstance(getActivity());
        getcurrentdate();
        init();
        // getcurrentyear();
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        todate = df.format(c);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        fromdate = df.format(calendar.getTime());

        yVals = new ArrayList<Entry>();
        return v;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        selected_date1 = selected_date;
    }

    /*public void getcurrentyear(){
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        getmonthstring(month, year);
    }*/

    /*public void getmonthstring(int mon, int yr){
        if(mon == 0){
            month_year_txt.setText("" + year);
        } else if(mon == 1){
            month_year_txt.setText("" + year);
        } else if(mon == 2){
            month_year_txt.setText("" + year);
        } else if(mon == 3){
            month_year_txt.setText("" + year);
        } else if(mon == 4){
            month_year_txt.setText("" + year);
        } else if(mon == 5){
            month_year_txt.setText("" + year);
        } else if(mon == 6){
            month_year_txt.setText("" + year);
        } else if(mon == 7){
            month_year_txt.setText("" + year);
        } else if(mon == 8){
            month_year_txt.setText("" + year);
        } else if(mon == 9){
            month_year_txt.setText("" + year);
        } else if(mon == 10){
            month_year_txt.setText("" + year);
        } else {
            month_year_txt.setText("" + year);
        }
    }*/

    void init() {
        mChart = v.findViewById(R.id.linechartexecise);
        tvfromdate = v.findViewById(R.id.tv_fromdateexer);
        tvtodate = v.findViewById(R.id.tv_todateexer);
        tv_totalcalsteps = v.findViewById(R.id.tv_totalcalsteps);
        tv_totaldursteps = v.findViewById(R.id.tv_totaldursteps);
        // tv_totaldistancesteps = v.findViewById(R.id.tv_totaldistancesteps);
        // tv_totalsteps = v.findViewById(R.id.tv_totalsteps);
        // circleViewstatsexercise = (CircleProgressView) v.findViewById(R.id.circleViewstatsexercise);

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
                // getmonthstring(Integer.parseInt(day_of_month), date.get(Calendar.YEAR));

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

    private void callApi1(Integer id) {
        if (id == RequestHealthConstants.GET_EXERCISE_LOG) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
                object.put("UserID", prefrences.getUID());
                object.put("Date", selected_date);
                object.put("Type", "2");
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
                    object.put("TargetSteps", "5000");
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
                object.put("Type", "2");
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
                running_steps = 0;
                running_calorie = 0.0f;
                running_distance = 0.0f;
                running_duration = 0;
                printData(dataReadResponse);
                printData2(dataReadResponse);
                Log.e("gfitttt", "Walking data -->" + running_steps + " walking_calorie " + running_calorie + " walking_distance " + running_distance + " walking_duration " + running_duration);
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

        DataSource ACTIVITY_SEGMENT = new DataSource.Builder()
                .setDataType(DataType.TYPE_ACTIVITY_SEGMENT)
                .setType(DataSource.TYPE_DERIVED)
                .setStreamName("estimated_activity_segment")
                .setAppPackageName("com.google.android.gms")
                .build();

        DataSource ESTIMATED_STEPS = new DataSource.Builder()
                .setDataType(DataType.TYPE_STEP_COUNT_DELTA)
                .setType(DataSource.TYPE_DERIVED)
                .setStreamName("estimated_steps")
                .setAppPackageName("com.google.android.gms")
                .build();

        return new DataReadRequest.Builder()
                .aggregate(DataType.TYPE_CALORIES_EXPENDED, DataType.AGGREGATE_CALORIES_EXPENDED)
                .aggregate(DataType.TYPE_DISTANCE_DELTA, DataType.AGGREGATE_DISTANCE_DELTA)
                .aggregate(DataType.TYPE_STEP_COUNT_DELTA, DataType.AGGREGATE_STEP_COUNT_DELTA)
                .aggregate(ACTIVITY_SEGMENT, DataType.AGGREGATE_ACTIVITY_SUMMARY)
                .aggregate(ESTIMATED_STEPS, DataType.AGGREGATE_STEP_COUNT_DELTA)
                .bucketByActivitySegment(1, TimeUnit.MILLISECONDS)
                .setTimeRange(startTime, endTime, TimeUnit.MILLISECONDS)
                .build();
    }

    private void printData(DataReadResponse dataReadResult) {
        running_duration = 0;
        running_calorie = 0;
        running_distance = 0;
        for (Bucket bucket : dataReadResult.getBuckets()) {
            String bucketActivity = bucket.getActivity();
            if (bucketActivity.contains(FitnessActivities.RUNNING)) {
                List<DataSet> dataSetx = bucket.getDataSets();
                for (DataSet dataSet : dataSetx) {
                    if (dataSet.getDataType().getName().equals("com.google.step_count.delta")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.i(TAG, bucket.getActivity());
                            long activeTime = bucket.getEndTime(TimeUnit.MINUTES) - bucket.getStartTime(TimeUnit.MINUTES);
                            Log.i(TAG, "Active time " + activeTime);
                            running_duration = running_duration + activeTime;
                            long hours = running_duration / 60; //since both are ints, you get an int
                            long minutes = running_duration % 60;
                            if (!TextUtils.isEmpty(String.valueOf(Runningduration))) {
                                tv_totaldursteps.setText(hours + ":" + minutes + " hours");
                            } else {
                                tv_totaldursteps.setText("00:00 hours");
                            }
                        }
                    }
                    if (dataSet.getDataType().getName().equals("com.google.calories.expended")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Calories dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat());
                            running_calorie = running_calorie + dataSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat();
                            if (!TextUtils.isEmpty(String.valueOf(running_calorie))) {
                                running_calorie = Math.round(running_calorie);
                                tv_totalcalsteps.setText(running_calorie + " Cal");
                            } else {
                                tv_totalcalsteps.setText("0");
                            }
                        }
                    }
                    if (dataSet.getDataType().getName().equals("com.google.distance.delta")) {
                        if (dataSet.getDataPoints().size() > 0) {
                            Log.e(TAG, "Distance dddd-->" + dataSet.getDataPoints().get(0).getValue(Field.FIELD_DISTANCE).asFloat());
                            running_distance = running_distance + dataSet.getDataPoints().get(0).getValue(Field.FIELD_DISTANCE).asFloat();
                            running_distance = running_distance / 1000;
                            running_distance = Math.round(running_distance);
                            /*if (!TextUtils.isEmpty(String.valueOf(running_distance))) {
                                tv_totaldistancesteps.setText(String.valueOf(running_distance) + " km");
                            } else {
                                tv_totaldistancesteps.setText("0 km");
                            }*/
                        }
                    }
                }
            }
        }

        if (running_duration == 0) {
            tv_totaldursteps.setText("00:00 hours");
        }
        if (running_calorie == 0) {
            tv_totalcalsteps.setText("0 Cal");
        }
        /*if (running_distance == 0) {
            tv_totaldistancesteps.setText("0 km");
        }*/
    }

    private void printData2(DataReadResponse dataReadResult) {
        Log.d("tag", String.valueOf(dataReadResult.getBuckets().size()));
        running_steps = 0;
        for (Bucket bucket : dataReadResult.getBuckets()) {
            String bucketActivity = bucket.getActivity();
            if (bucketActivity.contains(FitnessActivities.RUNNING)) {
                List<DataSet> dataSetx = bucket.getDataSets();
                for (DataSet dataSet : dataSetx) {
                    if (dataSet.getDataType().getName().equals("com.google.step_count.delta")) {
                        try {
                            running_steps = running_steps + dataSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        // tv_totalsteps.setText(String.valueOf(running_steps));
        //CustomProgressBar((int) running_steps);
        Log.e(TAG, "ssssssSteps -->" + running_steps);
    }

    /*private void CustomProgressBar(int Value) {
        Activity activity = getActivity();
        if (isAdded() && activity != null){
            if (!TextUtils.isEmpty(prefrences.getStepTarget())) {
                circleViewstatsexercise.setMaxValue(Float.parseFloat(prefrences.getStepTarget()));
            } else {
                circleViewstatsexercise.setMaxValue(5000);
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
    }*/

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
            obj.put("TotalStep", "0"/*tv_totalsteps.getText().toString()*/);
            obj.put("Calories", String.valueOf(running_calorie));
            obj.put("Duration", String.valueOf(Runningduration));
            obj.put("Distance", String.valueOf(disInKm));
            obj.put("Type", "2");
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
        if (Tag == RequestHealthConstants.GET_EXERCISE_LOG) {
            Activity activity = getActivity();
            if (isAdded() && activity != null){
                if (object.optString("Message").equalsIgnoreCase("Success")) {
                    if (!selected_date.equalsIgnoreCase(selected_date1)) {
                        try{
                            Distance = object.getString("Distance");
                            Duration = object.getString("Duration");
                            String TargetSteps = object.getString("TargetSteps");
                            String TotalSteps = object.getString("TotalSteps");
                            String TotalCalories = object.getString("TotalCalories");

                            if ((Distance.equals("0.0") || Distance.equals("0")) && (Duration.equals("0") || Duration.equals("null"))) {
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
                                if (!TotalCalories.equals("0")) {
                                    float Cal = Float.parseFloat(TotalCalories);
                                    Cal = Math.round(Cal);
                                    TotalCalories = String.valueOf((int) Cal);
                                }
                                float distance = 0;
                                if (!TextUtils.isEmpty(Distance)) {
                                    distance = Float.parseFloat(Distance);
                                }

                                // tv_totalsteps.setText(TotalSteps);
                                //tv_totaldistancesteps.setText(String.valueOf(distance) + " km");
                                tv_totaldursteps.setText(Duration + " hours");
                                tv_totalcalsteps.setText(Integer.parseInt(TotalCalories) + " Cal");
                                double result = Math.round((Double.parseDouble(TotalSteps) / Double.parseDouble(TargetSteps)) * 100);

                                /*if (!TextUtils.isEmpty(TargetSteps) && !TextUtils.isEmpty(TotalSteps)) {
                                    circleViewstatsexercise.setMaxValue(Integer.parseInt(TargetSteps));
                                    circleViewstatsexercise.setValue(Integer.parseInt(TotalSteps));
                                }*/
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
                    } catch (Exception ex) { }
                }
            }else{
                LayoutInflater result = null;
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

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
}
