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
import com.universalsompo.meta.metaapp.health.fragment.reminders.adapter.ConsultationReminderAdapter;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.consultation.AlarmReceiverConsultation;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.ConsultationReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.ConsultationReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.model.ConsultationReminder_getter_setter;
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

public class FragmentConsultationReminder extends Fragment {
    private View myView;
    private LinearLayout add_consultation_reminder;
    private TextView date, time, no_data;
    private EditText edt_consultation_name, edt_consultation_number;
    private RecyclerView consultation_list;
    private FloatingActionButton fab;
    private ConsultationReminderDatabaseHelper db;
    private MySharedPreference pref;
    private int startyear, startmonth, startday;
    private int curYear, curMonth, curDay;
    private int con_hour;
    private int con_minute;
    private int con_hr;
    private int con_min;
    private String selected_date;
    private String selected_time;
    private String consultation_id;
    private Calendar con_calSet;
    private ArrayList<ConsultationReminder_getter_setter> consultationreminderList1 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_consultation_reminder, container, false);
        setHasOptionsMenu(true);
        ((InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        pref = new MySharedPreference(getActivity());
        db = new ConsultationReminderDatabaseHelper(getActivity());
        init();
        return myView;
    }

    @SuppressLint({"RestrictedApi", "SetTextI18n"})
    private void init() {
        consultation_list = myView.findViewById(R.id.consultation_list);
        fab =  myView.findViewById(R.id.fab);
        add_consultation_reminder =  myView.findViewById(R.id.add_consultation_reminder);
        edt_consultation_name = myView.findViewById(R.id.edt_consultation_name);
        edt_consultation_number = myView.findViewById(R.id.edt_consultation_number);
        LinearLayout date_layout = myView.findViewById(R.id.date_layout);
        LinearLayout time_layout = myView.findViewById(R.id.time_layout);
        date =  myView.findViewById(R.id.date);
        time =  myView.findViewById(R.id.time);
        no_data =  myView.findViewById(R.id.no_data);
        LinearLayout save = myView.findViewById(R.id.save);

        int count = db.getCount(pref.getUID());
        fab.setVisibility(View.VISIBLE);
        if (count == 0) {
            no_data.setVisibility(View.VISIBLE);
            consultation_list.setVisibility(View.GONE);
            add_consultation_reminder.setVisibility(View.GONE);
        } else {
            no_data.setVisibility(View.GONE);
            consultation_list.setVisibility(View.VISIBLE);
            add_consultation_reminder.setVisibility(View.GONE);
            responsebuilder();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_consultation_name.setText("");
                edt_consultation_number.setText("");
                FragmentConsultationReminder.this.getCurrentDate();
                FragmentConsultationReminder.this.getCurrentTime();
                no_data.setVisibility(View.GONE);
                consultation_list.setVisibility(View.GONE);
                add_consultation_reminder.setVisibility(View.VISIBLE);
                fab.setVisibility(View.GONE);
            }
        });

        date_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog expdatePickerDialog = new DatePickerDialog(Objects.requireNonNull(FragmentConsultationReminder.this.getActivity()), R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        startyear = year;
                        startmonth = month + 1;
                        startday = dayOfMonth;
                        selected_date = FragmentConsultationReminder.this.initDay(startday) + "/" + startmonth + "/" + startyear;
                        date.setText(selected_date);
                    }
                }, curYear, curMonth - 1, curDay);
                Calendar cal = FragmentConsultationReminder.this.createCalender("" + curDay, "" + curMonth, "" + curYear);
                expdatePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis());
                expdatePickerDialog.show();
            }
        });

        time_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime_con = Calendar.getInstance();
                con_hour = mcurrentTime_con.get(Calendar.HOUR_OF_DAY);
                con_minute = mcurrentTime_con.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_dinner;
                mTimePicker_dinner = new TimePickerDialog(FragmentConsultationReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        Calendar calNow = Calendar.getInstance();
                        con_calSet = (Calendar) calNow.clone();
                        con_calSet.set(Calendar.HOUR_OF_DAY, selectedHour);
                        con_calSet.set(Calendar.MINUTE, selectedMinute);
                        con_hr = selectedHour;
                        con_min = Integer.parseInt(FragmentConsultationReminder.this.initMin(selectedMinute));
                        selected_time = con_hr + ":" + con_min;
                        if (con_hr >= 0 && con_hr < 12) {
                            time.setText(FragmentConsultationReminder.this.initHour(selectedHour) + ":" + FragmentConsultationReminder.this.initMin(selectedMinute) + " AM");
                        } else {
                            time.setText(FragmentConsultationReminder.this.initHour(selectedHour) + ":" + FragmentConsultationReminder.this.initMin(selectedMinute) + " PM");
                        }
                    }
                }, con_hour, con_minute, false);//Yes 24 hour time
                mTimePicker_dinner.setTitle(FragmentConsultationReminder.this.getResources().getString(R.string.select_time));
                mTimePicker_dinner.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_consultation_name.getText().toString().length() <= 0) {
                    Toast.makeText(FragmentConsultationReminder.this.getActivity(), "Please enter doctor name", Toast.LENGTH_SHORT).show();
                } else if (edt_consultation_number.getText().toString().length() <= 0) {
                    Toast.makeText(FragmentConsultationReminder.this.getActivity(), "Please enter doctor number", Toast.LENGTH_SHORT).show();
                } else {
                    no_data.setVisibility(View.GONE);
                    consultation_list.setVisibility(View.VISIBLE);
                    add_consultation_reminder.setVisibility(View.GONE);
                    fab.setVisibility(View.VISIBLE);
                    Random ran = new Random();
                    consultation_id = String.valueOf((1000 + ran.nextInt(9000)));
                    db.insertConsultationReminder(pref.getUID(), edt_consultation_name.getText().toString(), edt_consultation_number.getText().toString(), selected_date, selected_time, consultation_id, "active");
                    FragmentConsultationReminder.this.responsebuilder();
                    FragmentConsultationReminder.this.setAlarm_consultation(FragmentConsultationReminder.this.getContext(), consultation_id, edt_consultation_name.getText().toString());
                    pref.addNotificationOnOrOff(true);
                    new AppDataPushApi().callApi(FragmentConsultationReminder.this.getActivity(), "Reminders", "Consultation", "set Alarm for the doctor consultation " + edt_consultation_name.getText().toString());
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
        List<ConsultationReminder> consultationList = new ArrayList<>();
        consultationList.addAll(db.getAllConsultation(pref.getUID()));
        JSONArray jsonArray = new JSONArray();
        for (ConsultationReminder cn : consultationList) {
            JSONObject consultation = new JSONObject();
            try {
                consultation.put("userid", cn.getUserid());
                consultation.put("doctorname", cn.getDoctorname());
                consultation.put("doctornumber", cn.getDoctornumber());
                consultation.put("date", cn.getDate());
                consultation.put("time", cn.getTime());
                consultation.put("conid", cn.getId());
                consultation.put("activedeactive", cn.getActivedeactive());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(consultation);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("consultation", jsonArray);
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
                consultation_list.setVisibility(View.VISIBLE);
                add_consultation_reminder.setVisibility(View.GONE);
                JSONArray arr;
                if (!consultationreminderList1.isEmpty())
                    consultationreminderList1.clear();
                try {
                    arr = obj.getJSONArray("consultation");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj1 = arr.getJSONObject(i);
                        consultationreminderList1.add(
                                new ConsultationReminder_getter_setter(
                                        obj1.optString("userid"),
                                        obj1.optString("doctorname"),
                                        obj1.optString("doctornumber"),
                                        obj1.optString("date"),
                                        obj1.optString("time"),
                                        obj1.optString("conid"),
                                        obj1.optString("activedeactive")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    consultation_list.setLayoutManager(layoutManager);
                    ConsultationReminderAdapter mAdapter2 = new ConsultationReminderAdapter(getActivity(), consultationreminderList1, FragmentConsultationReminder.this);
                    consultation_list.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()),
                            DividerItemDecoration.VERTICAL));
                    consultation_list.setAdapter(mAdapter2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                fab.show();
                no_data.setVisibility(View.VISIBLE);
                consultation_list.setVisibility(View.GONE);
                add_consultation_reminder.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAlarm_consultation(Context context, String conid, String doc_name) {
        MySharedPreference pref = new MySharedPreference(context);
        ConsultationReminderDatabaseHelper db = new ConsultationReminderDatabaseHelper(context);
        String consultation_status_remin = db.getStatusofReminder(pref.getUID(),conid);
        if (consultation_status_remin.equalsIgnoreCase("active")) {

            String time_consultation = db.getTimeofReminder(pref.getUID(), conid);
            String[] time_split_consultation = time_consultation.split(":");
            String time_hr_consultation = time_split_consultation[0];
            String time_min_consultation = time_split_consultation[1];
            int time_hr_int_consultation = Integer.parseInt(time_hr_consultation);
            int time_min_int_consultation = Integer.parseInt(time_min_consultation);

            String date_consultation = db.getDateofReminder(pref.getUID(), conid);
            String[] date_split_consultation = date_consultation.split("/");
            String date_day_consultation = date_split_consultation[0];
            String date_month_consultation = date_split_consultation[1];
            String date_year_consultation = date_split_consultation[2];
            int date_day_int_consultation = Integer.parseInt(date_day_consultation);
            int date_month_int_consultation = Integer.parseInt(date_month_consultation);
            int date_year_int_consultation = Integer.parseInt(date_year_consultation);

            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context,AlarmReceiverConsultation.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.CONSULTATION");
            intent.putExtra("conid", conid);
            intent.putExtra("docname", doc_name);

            ComponentName receiver = new ComponentName(context, AlarmReceiverConsultation.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            PendingIntent pi = PendingIntent.getBroadcast(context, Integer.parseInt(conid), intent, PendingIntent.FLAG_ONE_SHOT);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, date_year_int_consultation);
            calendar.set(Calendar.MONTH, date_month_int_consultation - 1);
            calendar.set(Calendar.DAY_OF_MONTH, date_day_int_consultation);
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_consultation);
            calendar.set(Calendar.MINUTE, time_min_int_consultation);
            calendar.set(Calendar.SECOND, 0);
            if (Build.VERSION.SDK_INT < 23) {
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            } else {
                doRegisterReceiver();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void doRegisterReceiver(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.CONSULTATION");
        AlarmReceiverConsultation myReceiver = new AlarmReceiverConsultation();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);
    }
}