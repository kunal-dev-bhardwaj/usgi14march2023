package com.universalsompo.meta.metaapp.health.fragment.diary;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

import at.grabner.circleprogress.CircleProgressView;
import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.listeners.OnMonthChangeListener;
import sun.bob.mcalendarview.vo.DateData;

public class FragmentStepDetail extends Fragment implements ResponseListener {
    private View v;
    private MCalendarView calendardiet;
    private MySharedPreference pref;
    private int myear;
    private int mmonth;
    private String StartDate, EndDate;
    private ArrayList<String> datelist, yearlist;
    private int daysInMonth, daysInMonth1;
    private ArrayList<DietDiary> data;
    private String a;
    private int prev_month;
    private FrameLayout diet_frame;
    private CircleProgressView circleViewstatscalories;
    private TextView tv_totalcalorystats, tv_totalcaloryperstats;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_diary_step_details, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        init();
        Calendar c = Calendar.getInstance();
        myear = c.get(Calendar.YEAR);
        mmonth = c.get(Calendar.MONTH) + 1;
        if (mmonth == 4 || mmonth == 6 || mmonth == 9 || mmonth == 11)
            daysInMonth1 = 30;
        else if (mmonth == 2)
            daysInMonth1 = 28;
        else
            daysInMonth1 = 31;
        StartDate = mmonth + "/01/" + myear;
        EndDate = mmonth + "/" + daysInMonth1 + "/" + myear;
        callApi();
        return v;
    }

    private void init() {
        calendardiet =  v.findViewById(R.id.calendardiet);
        diet_frame =  v.findViewById(R.id.diet_frame);
        circleViewstatscalories =  v.findViewById(R.id.circleViewstatscalories);
        tv_totalcalorystats =  v.findViewById(R.id.tv_totalcalorystats);
        tv_totalcaloryperstats =  v.findViewById(R.id.tv_totalcaloryperstats);
        datelist = new ArrayList<>();
        yearlist = new ArrayList<>();
        calendardiet.setOnDateClickListener(new OnDateClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateClick(View view, DateData date) {
                try {
                    String mdate = date.getMonth() + "/" + date.getDay() + "/" + date.getYear();
                    String day_number = getmonthnumber(String.valueOf(date.getDay()));
                    String mdate1 = day_number + " " + getmonth(date.getMonth()) + " " + date.getYear();

                    Date current = new Date();
                    String myFormatString = "MM/dd/yyyy";
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat(myFormatString);
                    Date givenDate = df.parse(mdate);
                    assert givenDate != null;
                    long l = givenDate.getTime();
                    Date next = new Date(l);

                    if (next.after(current)) {
                        diet_frame.setVisibility(View.GONE);
                        Toast.makeText(getContext(), getResources().getString(R.string.select_date_before_current_date), Toast.LENGTH_SHORT).show();
                    } else {
                        for (int i = 0; i < data.size(); i++) {
                            if (data.get(i).getDatee().equalsIgnoreCase(mdate1)) {
                                diet_frame.setVisibility(View.VISIBLE);
                                String TotalCalories = data.get(i).getTotalCalaries();
                                String TargetCalories = data.get(i).getTarget();
                                double a = Double.parseDouble(TotalCalories);
                                int a1 = (int) a;
                                StringTokenizer st = new StringTokenizer(TotalCalories, " ");
                                String TCAl = st.nextToken();
                                Scanner targcal = new Scanner(TargetCalories).useDelimiter("[^0-9]+");
                                int TargetCal = targcal.nextInt();
                                tv_totalcalorystats.setText(String.valueOf(a1));
                                int call = Math.round(Float.parseFloat(TCAl));
                                double result = Math.round((Double.parseDouble(TCAl) / (double) TargetCal) * 100);
                                tv_totalcaloryperstats.setText(result + "%");
                                CustomProgressBarCalory(TargetCal, call);
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        calendardiet.setOnMonthChangeListener(new OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month) {
                prev_month = month;
                if (month == 4 || month == 6 || month == 9 || month == 11)
                    daysInMonth = 30;
                else if (month == 2)
                    daysInMonth = 28;
                else
                    daysInMonth = 31;
                StartDate = month + "/01/" + year;
                EndDate = month + "/" + daysInMonth + "/" + myear;
                callApi();
            }
        });
    }

    private String getmonth(int i) {
        if (i == 1) {
            a = "Jan";
        } else if (i == 2) {
            a = "Feb";
        } else if (i == 3) {
            a = "Mar";
        } else if (i == 4) {
            a = "Apr";
        } else if (i == 5) {
            a = "May";
        } else if (i == 6) {
            a = "Jun";
        } else if (i == 7) {
            a = "Jul";
        } else if (i == 8) {
            a = "Aug";
        } else if (i == 9) {
            a = "Sep";
        } else if (i == 10) {
            a = "Oct";
        } else if (i == 11) {
            a = "Nov";
        } else if (i == 12) {
            a = "Dec";
        }
        return a;
    }

    private void callApi() {
        if (datelist.size() > 0) {
            for (int i = 0; i < datelist.size(); i++) {
                calendardiet.unMarkDate(new DateData(Integer.parseInt(yearlist.get(i)), mmonth, Integer.parseInt(datelist.get(i))));
            }
        }
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("FromDate", StartDate);
            object.put("ToDate", EndDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_STEP_DIARY_DETAIL, this, RequestHealthConstants.GET_STEP_DIARY_DETAIL);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_STEP_DIARY_DETAIL) {
            if (datelist.size() > 0) {
                datelist.clear();
                yearlist.clear();
            }
            Calendar c1 = Calendar.getInstance();
            int curr_month = c1.get(Calendar.MONTH) + 1;
            if ((curr_month == prev_month) || (prev_month == 0)) {
                int first_day = 1;
                int end_day = daysInMonth1;
                int year = myear;
                for (int i1 = first_day; i1 <= end_day; i1++ ) {
                    calendardiet.unMarkDate(new DateData(year, curr_month, i1));
                }
            } else {
                int first_day = 1;
                int end_day = daysInMonth;
                int year = myear;
                for (int i1 = first_day; i1 <= end_day; i1++) {
                    calendardiet.unMarkDate(new DateData(year, prev_month, i1));
                }
            }
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                data = new ArrayList<>();
                try {
                    JSONArray jsonArray = object.getJSONArray("DiaryDietRes");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String datee = jsonObject.getString("Date");
                        String target = jsonObject.getString("Target");
                        String totalCalaries = jsonObject.getString("TotalCalaries");

                        data.add(new DietDiary(datee, target, totalCalaries));

                        if (!TextUtils.isEmpty(datee)) {
                            StringTokenizer st = new StringTokenizer(datee, " ");
                            String date = st.nextToken();
                            String month = st.nextToken();
                            String year = st.nextToken();

                            if (!TextUtils.isEmpty(target) && !TextUtils.isEmpty(totalCalaries)) {
                                if ((int) Float.parseFloat(target) < (int) Float.parseFloat(totalCalaries)) {
                                    calendardiet.unMarkDate(new DateData(Integer.parseInt(year), getnumbermonth(month), Integer.parseInt(date)));
                                    calendardiet.markDate(new DateData(Integer.parseInt(year), getnumbermonth(month), Integer.parseInt(date)).setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red))));
                                } else {
                                    double total_calories = Double.parseDouble(totalCalaries);
                                    double target_calories = Double.parseDouble(target);
                                    double per = (total_calories / target_calories) * 100;
                                    if (per < 70 && per > 0) {
                                        calendardiet.unMarkDate(new DateData(Integer.parseInt(year), getnumbermonth(month), Integer.parseInt(date)));
                                        calendardiet.markDate(new DateData(Integer.parseInt(year), getnumbermonth(month), Integer.parseInt(date)).setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.yellow))));
                                    } else if (per > 70) {
                                        calendardiet.unMarkDate(new DateData(Integer.parseInt(year), getnumbermonth(month), Integer.parseInt(date)));
                                        calendardiet.markDate(new DateData(Integer.parseInt(year), getnumbermonth(month), Integer.parseInt(date)).setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.green))));
                                    }
                                }
                            }
                        }
                    }
                    new AppDataPushApi().callApi(getActivity(),"Diary","Step Diary","Checked for Step diary");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getActivity(), getResources().getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private int getnumbermonth(String a1) {
        int a2 = 0;
        if (a1.equalsIgnoreCase("Jan")) {
            a2 = 1;
        } else if (a1.equalsIgnoreCase("Feb")) {
            a2 = 2;
        } else if (a1.equalsIgnoreCase("Mar")) {
            a2 = 3;
        } else if (a1.equalsIgnoreCase("Apr")) {
            a2 = 4;
        } else if (a1.equalsIgnoreCase("May")) {
            a2 = 5;
        } else if (a1.equalsIgnoreCase("Jun")) {
            a2 = 6;
        } else if (a1.equalsIgnoreCase("Jul")) {
            a2 = 7;
        } else if (a1.equalsIgnoreCase("Aug")) {
            a2 = 8;
        } else if (a1.equalsIgnoreCase("Sep")) {
            a2 = 9;
        } else if (a1.equalsIgnoreCase("Oct")) {
            a2 = 10;
        } else if (a1.equalsIgnoreCase("Nov")) {
            a2 = 11;
        } else if (a1.equalsIgnoreCase("Dec")) {
            a2 = 12;
        }
        return a2;
    }

    private String getmonthnumber(String a1) {
        String a2;
        if (a1.equalsIgnoreCase("1")) {
            a2 = "01";
        } else if (a1.equalsIgnoreCase("2")) {
            a2 = "02";
        } else if (a1.equalsIgnoreCase("3")) {
            a2 = "03";
        } else if (a1.equalsIgnoreCase("4")) {
            a2 = "04";
        } else if (a1.equalsIgnoreCase("5")) {
            a2 = "05";
        } else if (a1.equalsIgnoreCase("6")) {
            a2 = "06";
        } else if (a1.equalsIgnoreCase("7")) {
            a2 = "07";
        } else if (a1.equalsIgnoreCase("8")) {
            a2 = "08";
        } else if (a1.equalsIgnoreCase("9")) {
            a2 = "09";
        } else {
            a2 = a1;
        }
        return a2;
    }

    private void CustomProgressBarCalory(int maxvalue, int Value) {
        circleViewstatscalories.setMaxValue(maxvalue);
        circleViewstatscalories.setValue(0);
        circleViewstatscalories.setValueAnimated(Value);
        circleViewstatscalories.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.white));
        circleViewstatscalories.setBarColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.colorPrimary));
        circleViewstatscalories.setBarWidth(8);
        circleViewstatscalories.setRimColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        circleViewstatscalories.setRimWidth(8);
        circleViewstatscalories.setOuterContourSize(0);
        circleViewstatscalories.setInnerContourColor(0);
    }
}
