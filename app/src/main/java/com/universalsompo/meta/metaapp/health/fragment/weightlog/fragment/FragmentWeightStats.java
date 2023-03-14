package com.universalsompo.meta.metaapp.health.fragment.weightlog.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.suke.widget.SwitchButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.WeightReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentWeightReminder;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class FragmentWeightStats extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private LineChart mChart;
    private String todate, fromdate;
    private ArrayList<Entry> yVals;
    private TextView tvfromdate, tvtodate;
    private LinearLayout setting_of_target_weight;
    MySharedPreference pref;
    private SwitchButton weightReminder;
    FoodReminderDatabaseHelper db;
    WeightReminderDatabaseHelper db4;
    private RelativeLayout weight_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_weight_log_stats, container,false);
        pref = MySharedPreference.getInstance(getActivity());
        findViewById(v);
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        todate = df.format(c);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        fromdate = df.format(calendar.getTime());

        yVals = new ArrayList<Entry>();
        callApi(RequestHealthConstants.GET_WEIGHT_STATS_DATA);
        return v;
    }

    private void findViewById(View v) {
        mChart = v.findViewById(R.id.linechartweightstats);
        tvfromdate = v.findViewById(R.id.tv_fromdateweight);
        tvtodate = v.findViewById(R.id.tv_todateweight);
        setting_of_target_weight = v.findViewById(R.id.setting_of_target_weight);
        setting_of_target_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentSetYourTarget(), FragmentsHealthTags.FRAGMENT_SET_YOUR_TARGET);
                // Toast.makeText(getActivity(), "Functionality disabled", Toast.LENGTH_SHORT).show();
            }
        });
        db = new FoodReminderDatabaseHelper(getActivity());
        db4 = new WeightReminderDatabaseHelper(getActivity());
        weightReminder = v.findViewById(R.id.weight_reminder_btn);
        weight_layout = v.findViewById(R.id.rl_fr);

        boolean weight_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Weight reminder");
        if (weight_reminder_available == true) {
            String weight_status_remin = db.getStatusofReminder(pref.getUID(), "Weight reminder");
            if (weight_status_remin.equalsIgnoreCase("deactive")) {
                weightReminder.setChecked(false);
            } else {
                weightReminder.setChecked(true);
                String week_month = db4.getWeeklyMonthlyReminder(pref.getUID(), "active");

            }
        } else {
            weightReminder.setChecked(false);
            long weight_remin = db.insertFoodReminder(pref.getUID(), "Weight reminder", "deactive");
        }

        weight_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkUtils.isConnected(getActivity())) {
                    FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), new FragmentWeightReminder(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_WEIGHT_REMINDER);
                    binder.detect(FragmentsHealthTags.FRAGMENT_WEIGHT_REMINDER);
                } else {
                    Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
        weightReminder.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked){
                    if (NetworkUtils.isConnected(getActivity())) {
                        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), new FragmentWeightReminder(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_WEIGHT_REMINDER);
                        binder.detect(FragmentsHealthTags.FRAGMENT_WEIGHT_REMINDER);
                    } else {
                        Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    long update_weight = db.updateStatusofReminder(pref.getUID(), "Weight reminder", "deactive");
                    long update_weight_status = db4.updateStatusofReminder(pref.getUID(), "deactive");

                }
            }
        });
    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.GET_WEIGHT_STATS_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("FromDate", fromdate);
                object.put("ToDate", todate);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_WEIGHT_STATS_DATA, this, RequestHealthConstants.GET_WEIGHT_STATS_DATA);
            req.execute();
        }
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
    public void onSuccess(JSONObject object, int Tag) {
        if(Tag == RequestHealthConstants.GET_WEIGHT_STATS_DATA) {
            if(object.optString("Message").equalsIgnoreCase("Success")) {
                try {
                    yVals = new ArrayList<Entry>();
                    JSONArray jsonArray = object.getJSONArray("DashboardUsersWeightChart");
                    ArrayList<String> DateofRecord = new ArrayList<String>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String weights = jsonObject.getString("WeightInKG");
                        DateofRecord.add(jsonObject.getString("Date"));

                        StringTokenizer st = new StringTokenizer(weights, " ");
                        String str = st.nextToken();
                        float f = Float.parseFloat(str);
                        yVals.add(new Entry(i, f));
                    }
                    int size = DateofRecord.size();
                    tvfromdate.setText(DateofRecord.get(0));
                    tvtodate.setText(DateofRecord.get(size - 1));
                    getChartView();
                } catch (Exception ex) {

                }
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
        yy.add("0.00");
        yy.add("0.50");
        yy.add("1.00");
        yy.add("1.50");
        yy.add("2.00");

        LineDataSet dataSet = new LineDataSet(yVals, "All data in Kgs");
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
        mChart.setBackgroundColor(getResources().getColor(R.color.white));
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

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
