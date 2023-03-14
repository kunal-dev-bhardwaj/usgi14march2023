package com.universalsompo.meta.metaapp.health.fragment.healthregister.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.adapter.BloodSugarAdapter;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.FragmentHealthRegisterUSGI;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.model.BloodSugar;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class FragmentBloodSugarChart extends Fragment implements View.OnClickListener, ResponseListener, OnChartValueSelectedListener {
    private View v;
    private SelectorListener binder;
    private EditText blood_sugar_fasting,blood_sugar_pp;
    private LinearLayout view_list, view_graph;
    private MySharedPreference pref;
    private RecyclerView blood_sugar_list;
    private TextView no_data;
    private LinearLayout list, graph, view_graph_list;
    private final ArrayList<BloodSugar> data = new ArrayList<>();
    private BarChart mChart;
    private ArrayList<BarEntry> yVals1;
    private ArrayList<BarEntry> yVals2;
    private ArrayList<String> DiastolicList = new ArrayList<>();
    private ArrayList<String> SystolicList = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    private TextView tvdate1, tvdate2, tvdate3, tvdate4, tvdate5;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_blood_sugar_chart, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).remove_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    private void init() {
        LinearLayout clear_data = v.findViewById(R.id.clear_data);
        LinearLayout save = v.findViewById(R.id.save);
        blood_sugar_fasting = v.findViewById(R.id.blood_sugar_fasting);
        blood_sugar_pp = v.findViewById(R.id.blood_sugar_pp);
        view_list = v.findViewById(R.id.view_list);
        view_graph = v.findViewById(R.id.view_graph);
        blood_sugar_list = v.findViewById(R.id.blood_sugar_list);
        list = v.findViewById(R.id.list);
        graph = v.findViewById(R.id.graph);
        no_data = v.findViewById(R.id.no_data);
        view_graph_list = v.findViewById(R.id.view_graph_list);
        mChart = v.findViewById(R.id.chart1);
        tvdate1 = v.findViewById(R.id.tvdate1);
        tvdate2 = v.findViewById(R.id.tvdate2);
        tvdate3 = v.findViewById(R.id.tvdate3);
        tvdate4 = v.findViewById(R.id.tvdate4);
        tvdate5 = v.findViewById(R.id.tvdate5);
        getbloodsugarlist();
        clear_data.setOnClickListener(this);
        save.setOnClickListener(this);
        view_list.setOnClickListener(this);
        view_graph.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context activity) {
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
            case R.id.clear_data:
                blood_sugar_fasting.getText().clear();
                blood_sugar_pp.getText().clear();
                break;

            case R.id.save:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if (blood_sugar_fasting.getText().toString().isEmpty() || blood_sugar_fasting.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please provide end diastolic", Toast.LENGTH_SHORT).show();
                } else if (blood_sugar_pp.getText().toString().isEmpty() || blood_sugar_pp.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please provide end systolic", Toast.LENGTH_SHORT).show();
                } else {
                    savebloodsugar(blood_sugar_fasting.getText().toString(), blood_sugar_pp.getText().toString());
                }
                break;

            case R.id.view_list:
                view_graph.setVisibility(View.VISIBLE);
                view_list.setVisibility(View.GONE);
                list.setVisibility(View.VISIBLE);
                graph.setVisibility(View.GONE);
                break;

            case R.id.view_graph:
                view_graph.setVisibility(View.GONE);
                view_list.setVisibility(View.VISIBLE);
                list.setVisibility(View.GONE);
                graph.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void getbloodsugarlist() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("UserID", pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_BLOOD_SUGAR_LIST, this, RequestHealthConstants.GET_BLOOD_SUGAR_LIST);
        req.execute();
    }

    private void savebloodsugar(String a, String b) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Fasting", a);
            object.put("PP", b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_BLOOD_SUGAR, this, RequestHealthConstants.SAVE_BLOOD_SUGAR);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if(Tag == RequestHealthConstants.GET_BLOOD_SUGAR_LIST){
            new AppDataPushApi().callApi(getActivity(),"Health Register","Blood sugar","User loaded list of logged blood sugar");
                if(object.optString("NoOfCount").equals("0")){
                    view_graph_list.setVisibility(View.GONE);
                    blood_sugar_list.setVisibility(View.GONE);
                } else {
                    view_graph_list.setVisibility(View.VISIBLE);
                    blood_sugar_list.setVisibility(View.VISIBLE);
                    JSONArray arr;
                    if (!data.isEmpty())
                        data.clear();
                    try {
                        arr = object.getJSONArray("BloodSugerRes");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);
                            String Date = obj.getString("Date");
                            DiastolicList.add(obj.getString("Fasting"));
                            SystolicList.add(obj.getString("PP"));
                            if (!TextUtils.isEmpty(Date)) {
                                StringTokenizer st = new StringTokenizer(Date, " ");
                                String first = st.nextToken();
                                String second = st.nextToken();
                                date.add(first + " " + second);
                            }
                                data.add(
                                    new BloodSugar(
                                            obj.optString("Date"),
                                            obj.optString("Fasting"),
                                            obj.optString("FastingDiffrence"),
                                            obj.optString("PP"),
                                            obj.optString("PPDiffrence")
                                    )
                            );
                        }
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        blood_sugar_list.setLayoutManager(layoutManager);
                        BloodSugarAdapter bloodsugarAdapter = new BloodSugarAdapter(data);
                        blood_sugar_list.setAdapter(bloodsugarAdapter);
                        no_data.setVisibility(View.GONE);
                        chartData();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
        } else if (Tag == RequestHealthConstants.SAVE_BLOOD_SUGAR){
            if (object.optString("Message").equals("Success")){
                new AppDataPushApi().callApi(getActivity(),"Health Register","Blood sugar","User successfully added latest blood sugar - Fasting : " + blood_sugar_fasting.getText().toString() + " & PP : " + blood_sugar_pp.getText().toString());
                blood_sugar_fasting.clearFocus();
                blood_sugar_fasting.getText().clear();
                blood_sugar_pp.clearFocus();
                blood_sugar_pp.getText().clear();
                Toast.makeText(getActivity(), "Successfully saved", Toast.LENGTH_SHORT).show();
                if(list.getVisibility() != View.VISIBLE){
                    view_graph.setVisibility(View.VISIBLE);
                    view_list.setVisibility(View.GONE);
                    list.setVisibility(View.VISIBLE);
                    graph.setVisibility(View.GONE);
                }
                replaceFragment(new FragmentHealthRegisterUSGI());
            }
        }
    }

    private void replaceFragment(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle bdl = new Bundle();
            bdl.putString("Page", "1");
            frag.setArguments(bdl);
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.REGISTER_BLOOD_SUGAR_TAG);
            binder.detect(FragmentsHealthTags.REGISTER_BLOOD_SUGAR_TAG);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void chartData() {
        mChart.setOnChartValueSelectedListener(this);
        mChart.getDescription().setEnabled(false);
        mChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        mChart.getXAxis().setDrawGridLines(false);
        mChart.setDoubleTapToZoomEnabled(false);
        mChart.setPinchZoom(false);
        mChart.setScaleEnabled(false);
        mChart.setTouchEnabled(false);
        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);
        Legend l = mChart.getLegend();
        l.setEnabled(false);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(true);
        l.setYOffset(0f);
        l.setXOffset(10f);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setDrawLabels(false);
        xAxis.setGranularity(1f);
        xAxis.setCenterAxisLabels(true);
        xAxis.setValueFormatter((value, axis) -> String.valueOf((int) value));
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setEnabled(false);
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(false);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);
        mChart.getAxisRight().setEnabled(false);
        SetData();
    }

    private void SetData() {
        float groupSpace = 0.55f;
        float barSpace = 0.02f;
        float barWidth = 0.2f;
        int startYear = 1980;
        yVals1 = new ArrayList<>();
        yVals2 = new ArrayList<>();
        setDataToArrayList();
        BarDataSet set1, set2;
        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet) mChart.getData().getDataSetByIndex(1);
            set1.setValues(yVals1);
            set2.setValues(yVals2);
            set1.setColors(new int[]{R.color.yellow}, getContext());
            set2.setColors(new int[]{R.color.colorPrimary}, getContext());
            set1.setHighlightEnabled(false);
            set2.setHighlightEnabled(false);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Company A");
            set1.setColors(new int[]{R.color.yellow}, getContext());
            set2 = new BarDataSet(yVals2, "Company B");
            set2.setColors(new int[]{R.color.colorPrimary}, getContext());
            BarData data = new BarData(set1, set2);
            data.setValueFormatter(new LargeValueFormatter());
            mChart.setData(data);
            mChart.getBarData().setBarWidth(barWidth);
            mChart.getXAxis().setAxisMinimum(startYear);
            mChart.getXAxis().setAxisMaximum(startYear + mChart.getBarData().getGroupWidth(groupSpace, barSpace) * 5);
            mChart.groupBars(startYear, groupSpace, barSpace);
            mChart.invalidate();
        }
    }

    private void setDataToArrayList() {
        if (DiastolicList.size() == 1) {
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(0))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(0))));
            tvdate1.setVisibility(View.VISIBLE);
            tvdate1.setText(date.get(0));
        } else if (DiastolicList.size() == 2) {
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(0))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(0))));
            tvdate1.setText(date.get(0));
            tvdate1.setVisibility(View.VISIBLE);
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(1))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(1))));
            tvdate2.setText(date.get(1));
            tvdate2.setVisibility(View.VISIBLE);
        } else if (DiastolicList.size() == 3) {
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(0))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(0))));
            tvdate1.setText(date.get(0));
            tvdate1.setVisibility(View.VISIBLE);
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(1))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(1))));
            tvdate2.setText(date.get(1));
            tvdate2.setVisibility(View.VISIBLE);
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(2))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(2))));
            tvdate3.setText(date.get(2));
            tvdate3.setVisibility(View.VISIBLE);
        } else if (DiastolicList.size() == 4) {
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(0))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(0))));
            tvdate1.setText(date.get(0));
            tvdate1.setVisibility(View.VISIBLE);
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(1))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(1))));
            tvdate2.setText(date.get(1));
            tvdate2.setVisibility(View.VISIBLE);
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(2))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(2))));
            tvdate3.setText(date.get(2));
            tvdate3.setVisibility(View.VISIBLE);
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(3))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(3))));
            tvdate4.setText(date.get(3));
            tvdate4.setVisibility(View.VISIBLE);
        } else {
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(0))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(0))));
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(1))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(1))));
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(2))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(2))));
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(3))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(3))));
            yVals1.add(new BarEntry(0, Integer.parseInt(DiastolicList.get(4))));
            yVals2.add(new BarEntry(1, Integer.parseInt(SystolicList.get(4))));
            tvdate1.setText(date.get(0));
            tvdate2.setText(date.get(1));
            tvdate3.setText(date.get(2));
            tvdate4.setText(date.get(3));
            tvdate5.setText(date.get(4));
            tvdate1.setVisibility(View.VISIBLE);
            tvdate2.setVisibility(View.VISIBLE);
            tvdate3.setVisibility(View.VISIBLE);
            tvdate4.setVisibility(View.VISIBLE);
            tvdate5.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) { }

    @Override
    public void onNothingSelected() { }
}
