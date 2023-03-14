package com.universalsompo.meta.metaapp.health.fragment.reminders;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.reminders.adapter.LabTestReminderAdapter;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.labtest.AlarmReceiverLabTest;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.LabTestReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.LabTestReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.model.LabTestReminder_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FragmentLabTestReminder extends Fragment {
    private View myView;
    private LinearLayout add_lab_test_reminder;
    private TextView date, time, no_data;
    private EditText edt_lab_name, edt_test_name;
    private RecyclerView lab_test_list;
    private FloatingActionButton fab;
    private LabTestReminderDatabaseHelper db;
    private MySharedPreference pref;
    private int startyear, startmonth, startday;
    private int curYear, curMonth, curDay;
    private int lab_hour;
    private int lab_minute;
    private int lab_hr;
    private int lab_min;
    private String selected_date;
    private String selected_time;
    private String lab_test_id;
    private Calendar lab_calSet;
    private ArrayList<LabTestReminder_getter_setter> labtestreminderList1 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_lab_test_reminder, container, false);
        setHasOptionsMenu(true);
        ((InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        pref = new MySharedPreference(getActivity());
        db = new LabTestReminderDatabaseHelper(getActivity());
        init();
        return myView;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        lab_test_list = myView.findViewById(R.id.lab_test_list);
        fab =  myView.findViewById(R.id.fab);
        add_lab_test_reminder =  myView.findViewById(R.id.add_lab_test_reminder);
        edt_test_name = myView.findViewById(R.id.edt_test_name);
        edt_lab_name = myView.findViewById(R.id.edt_lab_name);
        LinearLayout date_layout = myView.findViewById(R.id.date_layout);
        LinearLayout time_layout = myView.findViewById(R.id.time_layout);
        date =  myView.findViewById(R.id.date);
        time =  myView.findViewById(R.id.time);
        no_data =  myView.findViewById(R.id.no_data);
        LinearLayout save = myView.findViewById(R.id.save);

        int count = db.getCount(pref.getUID());
        fab.show();
        if (count == 0) {
            no_data.setVisibility(View.VISIBLE);
            lab_test_list.setVisibility(View.GONE);
            add_lab_test_reminder.setVisibility(View.GONE);
        } else {
            no_data.setVisibility(View.GONE);
            lab_test_list.setVisibility(View.VISIBLE);
            add_lab_test_reminder.setVisibility(View.GONE);
            responsebuilder();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_lab_name.setText("");
                edt_test_name.setText("");
                FragmentLabTestReminder.this.getCurrentDate();
                FragmentLabTestReminder.this.getCurrentTime();
                no_data.setVisibility(View.GONE);
                lab_test_list.setVisibility(View.GONE);
                add_lab_test_reminder.setVisibility(View.VISIBLE);
                fab.hide();
            }
        });

        date_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog expdatePickerDialog = new DatePickerDialog(Objects.requireNonNull(FragmentLabTestReminder.this.getActivity()), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        startyear = year;
                        startmonth = month + 1;
                        startday = dayOfMonth;
                        selected_date = FragmentLabTestReminder.this.initDay(startday) + "/" + startmonth + "/" + startyear;
                        date.setText(selected_date);
                    }
                }, curYear, curMonth - 1, curDay);
                Calendar cal = FragmentLabTestReminder.this.createCalender("" + curDay, "" + curMonth, "" + curYear);
                expdatePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis());
                expdatePickerDialog.show();
            }
        });

        time_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime_lab = Calendar.getInstance();
                lab_hour = mcurrentTime_lab.get(Calendar.HOUR_OF_DAY);
                lab_minute = mcurrentTime_lab.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_dinner;
                mTimePicker_dinner = new TimePickerDialog(FragmentLabTestReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar calNow = Calendar.getInstance();
                        lab_calSet = (Calendar) calNow.clone();
                        lab_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        lab_calSet.set(Calendar.MINUTE, selectedMinute);
                        lab_hr = selectedHour;
                        lab_min = Integer.parseInt(FragmentLabTestReminder.this.initMin(selectedMinute));
                        selected_time = lab_hr + ":" + lab_min;
                        if (lab_hr >= 0 && lab_hr < 12) {
                            time.setText(FragmentLabTestReminder.this.initHour(selectedHour) + ":" + FragmentLabTestReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            time.setText(FragmentLabTestReminder.this.initHour(selectedHour) + ":" + FragmentLabTestReminder.this.initMin(selectedMinute) + " PM");
                        }
                    }
                }, lab_hour, lab_minute, false);//Yes 24 hour time
                mTimePicker_dinner.setTitle(FragmentLabTestReminder.this.getResources().getString(R.string.select_time));
                mTimePicker_dinner.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_test_name.getText().toString().length() <= 0) {
                    Toast.makeText(FragmentLabTestReminder.this.getActivity(), "Please enter test name", Toast.LENGTH_SHORT).show();
                } else if (edt_lab_name.getText().toString().length() <= 0) {
                    Toast.makeText(FragmentLabTestReminder.this.getActivity(), "Please enter lab name", Toast.LENGTH_SHORT).show();
                } else {
                    no_data.setVisibility(View.GONE);
                    lab_test_list.setVisibility(View.VISIBLE);
                    add_lab_test_reminder.setVisibility(View.GONE);
                    fab.show();
                    Random ran = new Random();
                    lab_test_id = String.valueOf((100 + ran.nextInt(900)));
                    db.insertLabTestReminder(pref.getUID(), edt_test_name.getText().toString(), edt_lab_name.getText().toString(), selected_date, selected_time, lab_test_id, "active");
                    FragmentLabTestReminder.this.responsebuilder();
                    FragmentLabTestReminder.this.setAlarm_labtest(FragmentLabTestReminder.this.getContext(), lab_test_id, edt_test_name.getText().toString(), edt_lab_name.getText().toString());
                    pref.addNotificationOnOrOff(true);
                    new AppDataPushApi().callApi(FragmentLabTestReminder.this.getActivity(), "Reminders", "Lab Test", "set Alarm for the Lab test " + edt_lab_name.getText().toString());
                }
            }
        });
    }

    private Calendar createCalender(String day, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, Integer.parseInt(month));
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        return calendar;
    }

    private String initDay(int day) {
        String days;
        if (day <= 9) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        return days;
    }

    private void getCurrentDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        curYear = c.get(Calendar.YEAR);
        curMonth = c.get(Calendar.MONTH);
        curDay = c.get(Calendar.DAY_OF_MONTH);

        selected_date = initDay(curDay) + "/" + (curMonth + 1) + "/" + curYear;
        date.setText(selected_date);
    }

    @SuppressLint("SetTextI18n")
    private void getCurrentTime() {
        Calendar mcurrentTime = Calendar.getInstance();
        int curHr = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int curMin = mcurrentTime.get(Calendar.MINUTE);

        selected_time = curHr + ":" + initMin(curMin);
        if (curHr < 12) {
            time.setText( initHour(curHr) + ":" + initMin(curMin) + " AM");
        } else {
            time.setText( initHour(curHr) + ":" + initMin(curMin) + " PM");
        }
    }

    private String initMin(int min) {
        String min1;
        if (min <= 9) {
            min1 = "0" + min;
        } else {
            min1 = "" + min;
        }
        return min1;
    }

    private String initHour(int hr) {
        String hr1;
        if (hr <= 9) {
            if (hr == 0) {
                hr1 = "12";
            } else {
                hr1 = "0" + hr;
            }
        } else {
            if (hr == 13) {
                hr1 = "01";
            } else if (hr == 14) {
                hr1 = "02";
            } else if (hr == 15) {
                hr1 = "03";
            } else if (hr == 16) {
                hr1 = "04";
            } else if (hr == 17) {
                hr1 = "05";
            } else if (hr == 18) {
                hr1 = "06";
            } else if (hr == 19) {
                hr1 = "07";
            } else if (hr == 20) {
                hr1 = "08";
            } else if (hr == 21) {
                hr1 = "09";
            } else if (hr == 22) {
                hr1 = "10";
            } else if (hr == 23) {
                hr1 = "11";
            } else {
                hr1 = "" + hr;
            }
        }
        return hr1;
    }

    public void responsebuilder(){
        List<LabTestReminder> labtestList = new ArrayList<>();
        labtestList.addAll(db.getAllLabtest(pref.getUID()));
        JSONArray jsonArray = new JSONArray();
        for (LabTestReminder cn : labtestList) {
            JSONObject labtest = new JSONObject();
            try {
                labtest.put("userid", cn.getUserid());
                labtest.put("testname", cn.getTestname());
                labtest.put("labname", cn.getLabname());
                labtest.put("date", cn.getDate());
                labtest.put("time", cn.getTime());
                labtest.put("labid", cn.getId());
                labtest.put("activedeactive", cn.getActivedeactive());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(labtest);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("labtest", jsonArray);
            if (jsonArray.length() > 0) {
                sympObj.put("message", "Success");
            } else {
                sympObj.put("message", "No data found");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = sympObj.toString();
        System.out.println("jsonString: " + jsonStr);

        try {
            JSONObject obj = new JSONObject(jsonStr);
            if (obj.optString("message").equalsIgnoreCase("success")) {
                fab.show();
                no_data.setVisibility(View.GONE);
                lab_test_list.setVisibility(View.VISIBLE);
                add_lab_test_reminder.setVisibility(View.GONE);
                JSONArray arr;
                if (!labtestreminderList1.isEmpty())
                    labtestreminderList1.clear();
                try {
                    arr = obj.getJSONArray("labtest");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj1 = arr.getJSONObject(i);
                        labtestreminderList1.add(
                                new LabTestReminder_getter_setter(
                                        obj1.optString("userid"),
                                        obj1.optString("testname"),
                                        obj1.optString("labname"),
                                        obj1.optString("date"),
                                        obj1.optString("time"),
                                        obj1.optString("labid"),
                                        obj1.optString("activedeactive")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    lab_test_list.setLayoutManager(layoutManager);
                    LabTestReminderAdapter mAdapter2 = new LabTestReminderAdapter(getActivity(), labtestreminderList1, FragmentLabTestReminder.this);
                    lab_test_list.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()),
                            DividerItemDecoration.VERTICAL));
                    lab_test_list.setAdapter(mAdapter2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                fab.show();
                no_data.setVisibility(View.VISIBLE);
                lab_test_list.setVisibility(View.GONE);
                add_lab_test_reminder.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAlarm_labtest(Context context, String labid, String test_name, String lab_name) {
        MySharedPreference pref = new MySharedPreference(context);
        LabTestReminderDatabaseHelper db = new LabTestReminderDatabaseHelper(context);
        String labtest_status_remin = db.getStatusofReminder(pref.getUID(),labid);
        if (labtest_status_remin.equalsIgnoreCase("active")) {

            String time_labtest = db.getTimeofReminder(pref.getUID(), labid);
            String[] time_split_labtest = time_labtest.split(":");
            String time_hr_labtest = time_split_labtest[0];
            String time_min_labtest = time_split_labtest[1];
            int time_hr_int_labtest = Integer.parseInt(time_hr_labtest);
            int time_min_int_labtest = Integer.parseInt(time_min_labtest);

            String date_labtest = db.getDateofReminder(pref.getUID(), labid);
            String[] date_split_labtest = date_labtest.split("/");
            String date_day_labtest = date_split_labtest[0];
            String date_month_labtest = date_split_labtest[1];
            String date_year_labtest = date_split_labtest[2];
            int date_day_int_labtest = Integer.parseInt(date_day_labtest);
            int date_month_int_labtest = Integer.parseInt(date_month_labtest);
            int date_year_int_labtest = Integer.parseInt(date_year_labtest);

            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiverLabTest.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.LABTEST");
            intent.putExtra("labid", labid);
            intent.putExtra("testname", test_name);
            intent.putExtra("labname", lab_name);

            ComponentName receiver = new ComponentName(context, AlarmReceiverLabTest.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            PendingIntent pi = PendingIntent.getBroadcast(context, Integer.parseInt(labid), intent, PendingIntent.FLAG_ONE_SHOT);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, date_year_int_labtest);
            calendar.set(Calendar.MONTH, date_month_int_labtest - 1);
            calendar.set(Calendar.DAY_OF_MONTH, date_day_int_labtest);
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
            calendar.set(Calendar.MINUTE, time_min_int_labtest);
            calendar.set(Calendar.SECOND, 0);

            if (Build.VERSION.SDK_INT < 23) {
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            } else {
                RegisterLabTestReceiver();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void RegisterLabTestReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.LABTEST");
        AlarmReceiverLabTest myReceiver = new AlarmReceiverLabTest();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);

    }
}