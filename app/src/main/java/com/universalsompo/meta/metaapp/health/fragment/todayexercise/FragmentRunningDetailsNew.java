package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class FragmentRunningDetailsNew extends Fragment implements ResponseListener {
    private View v;
    private MySharedPreference prefrences;
    private TextView tv_totalcalsteps, tv_totaldursteps;
    private String selected_date;
    private LineChart mChart;
    private ArrayList<Entry> yVals;
    private TextView tvfromdate, tvtodate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_running_details, container,false);
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        yVals = new ArrayList<>();
        getcurrentdate();
        return v;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        callApi();
    }

    void init() {
        mChart = v.findViewById(R.id.linechartexecise);
        tvfromdate = v.findViewById(R.id.tv_fromdateexer);
        tvtodate = v.findViewById(R.id.tv_todateexer);
        tv_totalcalsteps = v.findViewById(R.id.tv_totalcalsteps);
        tv_totaldursteps = v.findViewById(R.id.tv_totaldursteps);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 0);
        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String month1 = Integer.toString(date.get(Calendar.MONTH));
                String day_of_month,month3;
                if(date.get(Calendar.DAY_OF_MONTH) <= 9)
                {
                    day_of_month = "0" + date.get(Calendar.DAY_OF_MONTH);
                } else {
                    day_of_month = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
                }
                int month2 = Integer.parseInt(month1) + 1;
                if(month2 <= 9){
                    month3 = "0" + month2;
                } else {
                    month3 = String.valueOf(month2);
                }
                selected_date = month3 + "/" + day_of_month + "/" + date.get(Calendar.YEAR);
                callApi();
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

    private void callApi() {
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        Activity activity = getActivity();
        if (isAdded() && activity != null) {
            if (Tag == RequestHealthConstants.GET_EXERCISE_LOG) {
                if (object.optString("Message").equalsIgnoreCase("Success")) {
                    tv_totalcalsteps.setText(object.optString("TotalCalories") + " Cal");
                    String time = object.optString("Duration");
                    if (time.equalsIgnoreCase("0")) {
                        tv_totaldursteps.setText("00:00 hours");
                    } else {
                        String a = time.substring(time.lastIndexOf(":") + 1);
                        if (a.length() == 1) {
                            tv_totaldursteps.setText(object.optString("Duration") + "0 hours");
                        } else {
                            tv_totaldursteps.setText(object.optString("Duration") + " hours");
                        }
                    }

                    try {
                        yVals = new ArrayList<>();
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
        final ArrayList<String> yy = new ArrayList<>();
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

