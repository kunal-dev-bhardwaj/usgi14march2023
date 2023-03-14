package com.universalsompo.meta.metaapp.health.fragment.foodtracking.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.FoodTypeDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentFoodReminder;
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
import java.util.Scanner;
import java.util.StringTokenizer;

import at.grabner.circleprogress.CircleProgressView;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class FragmentFoodStats extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private TextView month_year_txt;
    int year, month;

    private LinearLayout all_food_background, early_breakfast_background, breakfast_background, lunch_background, evening_snack_background, dinner_background;
    private ImageView all_food, early_breakfast, breakfast, lunch, evening_snack, dinner;
    private ImageView all_food1, early_breakfast1, breakfast1, lunch1, evening_snack1, dinner1;
    private LinearLayout all_food_linear, early_breakfast_linear, breakfast_linear, lunch_linear, evening_snack_linear, dinner_linear;

    private CircleProgressView mCircleViewcal, mCircleViewprotein, mCircleViewfat, mCircleViewcarbs;
    private LineChart mChart;
    private TextView tvtargetcal, tvtotalcal, tvtotalcalper, tvprotien, tvfat, tvcarbs;
    private String TotalNutrition,TotalQty, description, currentdate, TotalTargetCalory;
    private int Proteins, Fats, Carb, Calories;
    private int TotalProtein, TotalFats, TotalCarbs, TotalCalories, TargetCalory;
    String selected_date, selected_date1;
    String formattedDate;
    private String type;
    private ArrayList<Entry> setYAxisValues;
    private TextView tvfromdate, tvtodate, daily_trend;
    private String todate, fromdate;
    String regexStr = "^[0-9]*$";

    private HorizontalCalendar horizontalCalendar;
    MySharedPreference pref;

    private ArrayList<Entry> yVals;
    private SwitchButton  setReminder;
    FoodReminderDatabaseHelper db;
    FoodTypeDatabaseHelper db1;
    private RelativeLayout food_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_food_stats, container,false);
        pref = MySharedPreference.getInstance(getActivity());
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        todate = df.format(c);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        fromdate = df.format(calendar.getTime());
        setHasOptionsMenu(true);
        getcurrentdate();
        init();
        getcurrentyear();
        return v;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        selected_date1 = selected_date;
        callApi(RequestHealthConstants.GET_FOOD_DATA);
    }

    public void getcurrentyear(){
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        getmonthstring(month, year);
    }

    public void getmonthstring(int mon, int yr){
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
    }

    public void init(){
        yVals = new ArrayList<Entry>();
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        formattedDate = df.format(c);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 0);
        horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        db = new FoodReminderDatabaseHelper(getActivity());
        db1 = new FoodTypeDatabaseHelper(getActivity());
        food_layout = v.findViewById(R.id.rl_fr);
        setReminder = v.findViewById(R.id.food_reminder_btn);
        boolean food_reminder_available = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "Food reminder");
        if (food_reminder_available == true) {
            String food_status_remin = db.getStatusofReminder(pref.getUID(), "Food reminder");
            if (food_status_remin.equalsIgnoreCase("deactive")) {
                setReminder.setChecked(false);
            } else {
                int status_count = db1.getActiveStatus(pref.getUID(), "Food reminder", "active");
                setReminder.setChecked(true);
            }
        } else {
            setReminder.setChecked(false);
            long food_remin = db.insertFoodReminder(pref.getUID(), "Food reminder", "deactive");
        }
        food_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkUtils.isConnected(getActivity())) {
                    FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), new FragmentFoodReminder(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
                    binder.detect(FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
                } else {
                    Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
        setReminder.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked){
                    if (NetworkUtils.isConnected(getActivity())) {
                        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), new FragmentFoodReminder(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
                        binder.detect(FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
                    } else {
                        Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    long update_food = db.updateStatusofReminder(pref.getUID(), "Food reminder", "deactive");
                    long early_morning_update = db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Early Morning", "",  "deactive");
                    long breakfast_update = db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Breakfast", "",  "deactive");
                    long lunch_update = db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Lunch", "",  "deactive");
                    long evening_snacks_update = db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Evening snacks", "",  "deactive");
                    long dinner_update = db1.updateStatusofReminder(pref.getUID(), "Food reminder", "Dinner", "",  "deactive");
//                    FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), new NoInternetConnection(), R.id.main_frame1, FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
//                    binder.detect(FragmentsHealthTags.FRAGMENT_FOOD_REMINDER);
                }
            }
        });

        month_year_txt = v.findViewById(R.id.month_year_txt);
        all_food_background = v.findViewById(R.id.all_food_background);
        early_breakfast_background = v.findViewById(R.id.early_breakfast_background);
        breakfast_background = v.findViewById(R.id.breakfast_background);
        lunch_background = v.findViewById(R.id.lunch_background);
        evening_snack_background = v.findViewById(R.id.evening_snack_background);
        dinner_background = v.findViewById(R.id.dinner_background);

        all_food = v.findViewById(R.id.all_food);
        early_breakfast = v.findViewById(R.id.early_breakfast);
        breakfast = v.findViewById(R.id.breakfast);
        lunch = v.findViewById(R.id.lunch);
        evening_snack = v.findViewById(R.id.evening_snack);
        dinner = v.findViewById(R.id.dinner);

        all_food1 = v.findViewById(R.id.all_food1);
        early_breakfast1 = v.findViewById(R.id.early_breakfast1);
        breakfast1 = v.findViewById(R.id.breakfast1);
        lunch1 = v.findViewById(R.id.lunch1);
        evening_snack1 = v.findViewById(R.id.evening_snack1);
        dinner1 = v.findViewById(R.id.dinner1);

        mCircleViewcal = v.findViewById(R.id.circleViewstatscalories);
        mCircleViewprotein = v.findViewById(R.id.circleViewstatsprotein);
        mCircleViewfat = v.findViewById(R.id.circleViewstatsfat);
        mCircleViewcarbs = v.findViewById(R.id.circleViewstatscarb);
        mChart = v.findViewById(R.id.linechart);

        CustomProgressBarCalory(Integer.parseInt(pref.getcaloriegoal()), 0);
        CustomProgressBarProtein(100, 0);
        CustomProgressBarFat(100, 0);
        CustomProgressBarCarb(300, 0);

        all_food_linear = v.findViewById(R.id.all_food_linear);
        early_breakfast_linear = v.findViewById(R.id.early_breakfast_linear);
        breakfast_linear = v.findViewById(R.id.breakfast_linear);
        lunch_linear = v.findViewById(R.id.lunch_linear);
        evening_snack_linear = v.findViewById(R.id.evening_snack_linear);
        dinner_linear = v.findViewById(R.id.dinner_linear);

        tvtargetcal = v.findViewById(R.id.tv_targetcalstats);
        tvtotalcal = v.findViewById(R.id.tv_totalcalorystats);
        tvtotalcalper = v.findViewById(R.id.tv_totalcaloryperstats);
        tvprotien = v.findViewById(R.id.tv_proteinstats);
        tvfat = v.findViewById(R.id.tv_fatstats);
        tvcarbs = v.findViewById(R.id.tv_carbstats);

        tvfromdate = v.findViewById(R.id.tv_fromdatefood);
        tvtodate = v.findViewById(R.id.tv_todatefood);
        daily_trend = v.findViewById(R.id.daily_trend);


        setYAxisValues = new ArrayList<Entry>();

        all_food_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allfoodmethod();
            }
        });

        early_breakfast_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                earlybreakfastmethod();
            }
        });

        breakfast_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breakfastmethod();
            }
        });

        lunch_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lunchmethod();
            }
        });

        evening_snack_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eveningsnackmethod();
            }
        });

        dinner_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dinnermethod();
            }
        });

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
                getmonthstring(Integer.parseInt(day_of_month), date.get(Calendar.YEAR));
                callApi(RequestHealthConstants.GET_FOOD_DATA);
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

        type = "All";
        callApi(RequestHealthConstants.GET_FOOD_DATA);
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

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void callApi(Integer id) {
        if (id == RequestHealthConstants.GET_FOOD_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("Type", type);
                object.put("Date", selected_date);
                object.put("NoOfDays", "7");
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_FOOD_DATA, this, RequestHealthConstants.GET_FOOD_DATA);
            req.execute();

        }
    }

    private void allfoodmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            all_food_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            all_food_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder));
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        all_food.setVisibility(View.VISIBLE);
        all_food1.setVisibility(View.GONE);
        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        type = "All";
        callApi(RequestHealthConstants.GET_FOOD_DATA);
    }

    private void earlybreakfastmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            all_food_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            all_food_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        all_food.setVisibility(View.GONE);
        all_food1.setVisibility(View.VISIBLE);
        early_breakfast.setVisibility(View.VISIBLE);
        early_breakfast1.setVisibility(View.GONE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        type = "EarlyMorning";
        callApi(RequestHealthConstants.GET_FOOD_DATA);
    }

    private void breakfastmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            all_food_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            all_food_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        all_food.setVisibility(View.GONE);
        all_food1.setVisibility(View.VISIBLE);
        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.GONE);
        breakfast1.setVisibility(View.VISIBLE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        type = "Breakfast";
        callApi(RequestHealthConstants.GET_FOOD_DATA);
    }

    private void lunchmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            all_food_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            all_food_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        all_food.setVisibility(View.GONE);
        all_food1.setVisibility(View.VISIBLE);
        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.GONE);
        lunch1.setVisibility(View.VISIBLE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        type = "Lunch";
        callApi(RequestHealthConstants.GET_FOOD_DATA);
    }

    private void eveningsnackmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            all_food_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            all_food_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        all_food.setVisibility(View.GONE);
        all_food1.setVisibility(View.VISIBLE);
        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.GONE);
        evening_snack1.setVisibility(View.VISIBLE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        type = "EveningSnacks";
        callApi(RequestHealthConstants.GET_FOOD_DATA);
    }

    private void dinnermethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            all_food_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
        } else {
            all_food_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
        }

        all_food.setVisibility(View.GONE);
        all_food1.setVisibility(View.VISIBLE);
        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.GONE);
        dinner1.setVisibility(View.VISIBLE);

        type = "Dinner";
        callApi(RequestHealthConstants.GET_FOOD_DATA);
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_FOOD_DATA) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                try {
                    String TotalCalories = object.getString("TotalCalories");
                    String TotalCarbs = object.getString("TotalCarbs");
                    String TotalFat = object.getString("TotalFat");
                    String TotalProtein = object.getString("TotalProtein");
                    String TargetCalories = object.getString("TargetCalories");

                    StringTokenizer st = new StringTokenizer(TotalCalories, " ");
                    String TCAl = st.nextToken();

                    if (TCAl.matches(regexStr)) {
                        tvtotalcal.setText(TCAl);
                    } else {
                        tvtotalcal.setText("0");
                    }

                    Scanner targcal = new Scanner(TargetCalories).useDelimiter("[^0-9]+");
                    int TargetCal = targcal.nextInt();

                    tvcarbs.setText("Carbs (" + TotalCarbs + ")");
                    tvprotien.setText("Protein (" + TotalProtein + ")");
                    tvfat.setText("Fat (" + TotalFat + ")");

                    StringTokenizer carbstr = new StringTokenizer(TotalCarbs, " ");
                    String carb = carbstr.nextToken();
                    StringTokenizer fatstr = new StringTokenizer(TotalFat, " ");
                    String fat = fatstr.nextToken();
                    StringTokenizer prostr = new StringTokenizer(TotalProtein, " ");
                    String prott = prostr.nextToken();

                    int call = Math.round(Float.parseFloat(TCAl));
                    int carbb = Math.round(Float.parseFloat(carb));
                    int fatt = Math.round(Float.parseFloat(fat));
                    int prot = Math.round(Float.parseFloat(prott));
                    int targetcal = Math.round(TargetCal);

                    tvtargetcal.setText("Target " + pref.getcaloriegoal() + " Calories");

                    double result = Math.round((Double.parseDouble(TCAl) / (double) TargetCal) * 100);
                    tvtotalcalper.setText(result + "%");

                    CustomProgressBarCalory(Integer.parseInt(pref.getcaloriegoal()), call);
                    CustomProgressBarProtein(100, prot);
                    CustomProgressBarFat(100, fatt);
                    CustomProgressBarCarb(300, carbb);

                    yVals = new ArrayList<Entry>();
                    JSONArray jsonArray = object.getJSONArray("DBoardUsersFoodChartLogRes");
                    ArrayList<String> DateofRecord = new ArrayList<String>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String InLiter = jsonObject.getString("TotalCalaries");
                        DateofRecord.add(jsonObject.getString("Date"));

                        StringTokenizer st1 = new StringTokenizer(InLiter, " ");
                        String str1 = st1.nextToken();
                        float f1 = Float.parseFloat(str1);
                        yVals.add(new Entry(i, f1));
                    }
                    int size = DateofRecord.size();
                    if (size == 0) {
                        mChart.setVisibility(View.GONE);
                        daily_trend.setVisibility(View.GONE);
                        tvfromdate.setVisibility(View.GONE);
                        tvtodate.setVisibility(View.GONE);
                    } else {
                        mChart.setVisibility(View.VISIBLE);
                        daily_trend.setVisibility(View.VISIBLE);
                        tvfromdate.setVisibility(View.VISIBLE);
                        tvtodate.setVisibility(View.VISIBLE);
                        tvfromdate.setText(DateofRecord.get(0));
                        tvtodate.setText(DateofRecord.get(size - 1));
                        getChartView();
                    }
                } catch (Exception e) {
                        e.printStackTrace();
                    }
            } else {

            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    private void CustomProgressBarCalory(int maxvalue, int Value) {
        mCircleViewcal.setMaxValue(maxvalue);
        mCircleViewcal.setValue(0);
        mCircleViewcal.setValueAnimated(Value);
        mCircleViewcal.setTextColor(getResources().getColor(R.color.white));
        mCircleViewcal.setBarColor(getResources().getColor(R.color.colorPrimary));
        mCircleViewcal.setBarWidth(8);
        mCircleViewcal.setRimColor(getResources().getColor(R.color.grey));
        mCircleViewcal.setRimWidth(8);
        mCircleViewcal.setOuterContourSize(0);
        mCircleViewcal.setInnerContourColor(0);
    }

    private void CustomProgressBarProtein(int maxvalue, int Value) {
        mCircleViewprotein.setMaxValue(maxvalue);
        mCircleViewprotein.setValue(0);
        mCircleViewprotein.setValueAnimated(Value);
        mCircleViewprotein.setTextColor(getResources().getColor(R.color.black));
        mCircleViewprotein.setBarColor(getResources().getColor(R.color.colorPrimary));
        mCircleViewprotein.setBarWidth(8);
        mCircleViewprotein.setRimColor(getResources().getColor(R.color.grey));
        mCircleViewprotein.setRimWidth(8);
        mCircleViewprotein.setOuterContourSize(0);
        mCircleViewprotein.setInnerContourColor(0);
    }

    private void CustomProgressBarFat(int maxvalue, int Value) {
        mCircleViewfat.setMaxValue(maxvalue);
        mCircleViewfat.setValue(0);
        mCircleViewfat.setValueAnimated(Value);
        mCircleViewfat.setTextColor(getResources().getColor(R.color.black));
        mCircleViewfat.setBarColor(getResources().getColor(R.color.colorPrimary));
        mCircleViewfat.setBarWidth(8);
        mCircleViewfat.setRimColor(getResources().getColor(R.color.grey));
        mCircleViewfat.setRimWidth(8);
        mCircleViewfat.setOuterContourSize(0);
        mCircleViewfat.setInnerContourColor(0);

    }

    private void CustomProgressBarCarb(int maxvalue, int Value) {
        mCircleViewcarbs.setMaxValue(maxvalue);
        mCircleViewcarbs.setValue(0);
        mCircleViewcarbs.setValueAnimated(Value*3);
        mCircleViewcarbs.setTextColor(getResources().getColor(R.color.black));
        mCircleViewcarbs.setBarColor(getResources().getColor(R.color.colorPrimary));
        mCircleViewcarbs.setBarWidth(8);
        mCircleViewcarbs.setRimColor(getResources().getColor(R.color.grey));
        mCircleViewcarbs.setRimWidth(8);
        mCircleViewcarbs.setOuterContourSize(0);
        mCircleViewcarbs.setInnerContourColor(0);
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

        LineDataSet dataSet = new LineDataSet(yVals, "All data in calories");
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