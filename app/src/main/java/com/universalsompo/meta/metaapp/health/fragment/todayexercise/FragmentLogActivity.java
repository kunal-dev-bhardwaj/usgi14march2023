package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class FragmentLogActivity extends Fragment implements View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    private HorizontalCalendar horizontalCalendar;
    int year1, month1;
    private TextView month_year_txt;
    private LinearLayout swimming_layout, yoga_layout, workout_layout, swimming_layout1, yoga_layout1, workout_layout1;
    private LinearLayout running_layout, running_layout1, cycling_layout1, cycling_layout;
    String selected_date;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_log_activity, container,false);
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(v.getWindowToken(), 0);
        ((MainActivityHealth)getActivity()).show_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        prefrences = MySharedPreference.getInstance(getActivity());
        getcurrentdate();
        init();
        getcurrentyear();
        return v;
    }

    void init() {
        month_year_txt = v.findViewById(R.id.month_year_txt);
        swimming_layout = v.findViewById(R.id.swimming_layout);
        yoga_layout = v.findViewById(R.id.yoga_layout);
        workout_layout = v.findViewById(R.id.workout_layout);
        swimming_layout1 = v.findViewById(R.id.swimming_layout1);
        yoga_layout1 = v.findViewById(R.id.yoga_layout1);
        workout_layout1 = v.findViewById(R.id.workout_layout1);
        running_layout = v.findViewById(R.id.running_layout);
        running_layout1 = v.findViewById(R.id.running_layout1);
        cycling_layout1 = v.findViewById(R.id.cycling_layout1);
        cycling_layout = v.findViewById(R.id.cycling_layout);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 0);
        horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
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
                getmonthstring(Integer.parseInt(day_of_month), date.get(Calendar.YEAR));

                if (running_layout.getVisibility() == View.VISIBLE) {

                } else if (cycling_layout.getVisibility() == View.VISIBLE) {

                } if (swimming_layout.getVisibility() == View.VISIBLE) {
                    addFragment(new FragmentSwimmingAddValue(), selected_date);
                } else if (yoga_layout.getVisibility() == View.VISIBLE) {
                    addFragment(new FragmentYogaAddValue(), selected_date);
                } else {
                    addFragment(new FragmentWorkoutAddValue(), selected_date);
                }
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

        swimming_layout1.setOnClickListener(this);
        yoga_layout1.setOnClickListener(this);
        workout_layout1.setOnClickListener(this);
        running_layout1.setOnClickListener(this);
        cycling_layout1.setOnClickListener(this);

        addFragment(new FragmentRunningAddValue(), selected_date);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.running_layout1:
                selectRunning();
                break;

            case R.id.cycling_layout1:
                selectCycling();
                break;

            case R.id.swimming_layout1:
                selectSwimming();
                break;

            case R.id.yoga_layout1:
                selectYoga();
                break;

            case R.id.workout_layout1:
                selectWorkout();
                break;
        }
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
    }

    public void getcurrentyear(){
        Calendar c = Calendar.getInstance();
        year1 = c.get(Calendar.YEAR);
        month1 = c.get(Calendar.MONTH);
        getmonthstring(month1, year1);
    }

    public void getmonthstring(int mon, int yr){
        if(mon == 0){
            month_year_txt.setText("" + yr);
        } else if(mon == 1){
            month_year_txt.setText("" + yr);
        } else if(mon == 2){
            month_year_txt.setText("" + yr);
        } else if(mon == 3){
            month_year_txt.setText("" + yr);
        } else if(mon == 4){
            month_year_txt.setText("" + yr);
        } else if(mon == 5){
            month_year_txt.setText("" + yr);
        } else if(mon == 6){
            month_year_txt.setText("" + yr);
        } else if(mon == 7){
            month_year_txt.setText("" + yr);
        } else if(mon == 8){
            month_year_txt.setText("" + yr);
        } else if(mon == 9){
            month_year_txt.setText("" + yr);
        } else if(mon == 10){
            month_year_txt.setText("" + yr);
        } else {
            month_year_txt.setText("" + yr);
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

    void selectRunning() {
        running_layout.setVisibility(View.VISIBLE);
        running_layout1.setVisibility(View.GONE);
        cycling_layout.setVisibility(View.GONE);
        cycling_layout1.setVisibility(View.VISIBLE);
        swimming_layout.setVisibility(View.GONE);
        swimming_layout1.setVisibility(View.VISIBLE);
        workout_layout.setVisibility(View.GONE);
        workout_layout1.setVisibility(View.VISIBLE);
        yoga_layout.setVisibility(View.GONE);
        yoga_layout1.setVisibility(View.VISIBLE);
        addFragment(new FragmentRunningAddValue(), selected_date);
    }

    void selectCycling() {
        running_layout.setVisibility(View.GONE);
        running_layout1.setVisibility(View.VISIBLE);
        cycling_layout.setVisibility(View.VISIBLE);
        cycling_layout1.setVisibility(View.GONE);
        swimming_layout.setVisibility(View.GONE);
        swimming_layout1.setVisibility(View.VISIBLE);
        workout_layout.setVisibility(View.GONE);
        workout_layout1.setVisibility(View.VISIBLE);
        yoga_layout.setVisibility(View.GONE);
        yoga_layout1.setVisibility(View.VISIBLE);
        addFragment(new FragmentCyclingAddValue(), selected_date);
    }

    void selectSwimming() {
        running_layout.setVisibility(View.GONE);
        running_layout1.setVisibility(View.VISIBLE);
        cycling_layout.setVisibility(View.GONE);
        cycling_layout1.setVisibility(View.VISIBLE);
        swimming_layout.setVisibility(View.VISIBLE);
        swimming_layout1.setVisibility(View.GONE);
        workout_layout.setVisibility(View.GONE);
        workout_layout1.setVisibility(View.VISIBLE);
        yoga_layout.setVisibility(View.GONE);
        yoga_layout1.setVisibility(View.VISIBLE);
        addFragment(new FragmentSwimmingAddValue(), selected_date);
    }

    void selectWorkout() {
        running_layout.setVisibility(View.GONE);
        running_layout1.setVisibility(View.VISIBLE);
        cycling_layout.setVisibility(View.GONE);
        cycling_layout1.setVisibility(View.VISIBLE);
        swimming_layout.setVisibility(View.GONE);
        swimming_layout1.setVisibility(View.VISIBLE);
        workout_layout.setVisibility(View.VISIBLE);
        workout_layout1.setVisibility(View.GONE);
        yoga_layout.setVisibility(View.GONE);
        yoga_layout1.setVisibility(View.VISIBLE);
        addFragment(new FragmentWorkoutAddValue(), selected_date);
    }

    void selectYoga() {
        running_layout.setVisibility(View.GONE);
        running_layout1.setVisibility(View.VISIBLE);
        cycling_layout.setVisibility(View.GONE);
        cycling_layout1.setVisibility(View.VISIBLE);
        swimming_layout.setVisibility(View.GONE);
        swimming_layout1.setVisibility(View.VISIBLE);
        workout_layout.setVisibility(View.GONE);
        workout_layout1.setVisibility(View.VISIBLE);
        yoga_layout.setVisibility(View.VISIBLE);
        yoga_layout1.setVisibility(View.GONE);
        addFragment(new FragmentYogaAddValue(), selected_date);
    }

    void addFragment(Fragment frg, String date) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        Bundle args = new Bundle();
        args.putString("Date", date);
        frg.setArguments(args);
        childFragTrans.replace(R.id.log_activity_container1, frg);
        childFragTrans.commit();
    }
}

