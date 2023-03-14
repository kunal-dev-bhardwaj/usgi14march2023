package com.universalsompo.meta.metaapp.health.fragment.reminders;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.TimePicker;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.reminders.adapter.MedReminderAdapter;
import com.universalsompo.meta.metaapp.health.fragment.reminders.alarmservices1.medicine.AlarmMedicineReceiver;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.MedicineReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.MedicineTypeReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.model.MedReminder_getter_setter;
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

public class FragmentMedicineReminder extends Fragment {
    private View view ;
    private MySharedPreference pref;
    private MedicineReminderDatabaseHelper db;
    private int med_hour, med_hr, med_min;
    private String selected_time;
    private FloatingActionButton fab;
    private RecyclerView med_rem_list;
    private TextView no_data;
    private ArrayList<MedReminder_getter_setter> medreminderList1 = new ArrayList<>();
    private Calendar med_calset;
    private String med_id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_medicine_reminder,container,false);
        setHasOptionsMenu(true);
        ((InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(view.getWindowToken(), 0);
        pref = new MySharedPreference(getActivity());
        db = new MedicineReminderDatabaseHelper(getActivity());
        init();
        return view;
    }

    public void init(){
        no_data =  view.findViewById(R.id.no_data);
        med_rem_list = view.findViewById(R.id.medicine_list);
        fab =  view.findViewById(R.id.fab_med);
        int count = db.getCount(pref.getUID());

        fab.show();
        if (count == 0) {
            no_data.setVisibility(View.VISIBLE);
            med_rem_list.setVisibility(View.GONE);
        } else {
            no_data.setVisibility(View.GONE);
            med_rem_list.setVisibility(View.VISIBLE);
            responsebuilder();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime_lab = Calendar.getInstance();
                med_hour = mcurrentTime_lab.get(Calendar.HOUR_OF_DAY);
                med_min = mcurrentTime_lab.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker_dinner;
                mTimePicker_dinner = new TimePickerDialog(FragmentMedicineReminder.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar calNow = Calendar.getInstance();
                        med_calset = (Calendar) calNow.clone();
                        med_calset.set(Calendar.HOUR_OF_DAY, selectedHour);
                        med_calset.set(Calendar.MINUTE, selectedMinute);
                        med_hr = Integer.parseInt(FragmentMedicineReminder.this.initHour(selectedHour));
                        med_min = Integer.parseInt(FragmentMedicineReminder.this.initMin(selectedMinute));
                        selected_time = med_hr + ":" + med_min;
                        Random ran = new Random();
                        med_id = String.valueOf((100 + ran.nextInt(900)));
                        db.insertMedReminder(pref.getUID(), selected_time, med_id, "active");
                        FragmentMedicineReminder.this.responsebuilder();
                        FragmentMedicineReminder.this.setAlarm_Medicine(FragmentMedicineReminder.this.getContext(), med_id);
                        pref.addNotificationOnOrOff(true);
                        new AppDataPushApi().callApi(FragmentMedicineReminder.this.getActivity(), "Reminders", "Medicine", "set Alarm for the Medicine");
                    }
                }, med_hour, med_hour, false);//Yes 24 hour time
                mTimePicker_dinner.setTitle(FragmentMedicineReminder.this.getResources().getString(R.string.select_time));
                mTimePicker_dinner.show();
            }
        });
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
            hr1 = "0" + hr;
        } else {
            hr1 = "" + hr;
        }
        return hr1;
    }

    @SuppressLint("RestrictedApi")
    public void responsebuilder(){
        List<MedicineTypeReminder> medList = new ArrayList<>();
        medList.addAll(db.getAllMedList(pref.getUID()));
        JSONArray jsonArray = new JSONArray();
        for (MedicineTypeReminder cn : medList) {
            JSONObject labtest = new JSONObject();
            try {
                labtest.put("userid", cn.getUser_id());
                labtest.put("time", cn.getTime());
                labtest.put("medId", cn.getId());
                labtest.put("activedeactive", cn.getActive_deactive());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(labtest);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("medList", jsonArray);
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
                fab.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                med_rem_list.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!medreminderList1.isEmpty())
                    medreminderList1.clear();
                try {
                    arr = obj.getJSONArray("medList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj1 = arr.getJSONObject(i);


                        medreminderList1.add(
                                new MedReminder_getter_setter(
                                        obj1.optString("userid"),
                                        obj1.optString("time"),
                                        obj1.optString("medId"),
                                        obj1.optString("activedeactive")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    med_rem_list.setLayoutManager(layoutManager);
                    MedReminderAdapter mAdapter2 = new MedReminderAdapter(getActivity(), medreminderList1, FragmentMedicineReminder.this);
                    med_rem_list.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()),
                            DividerItemDecoration.VERTICAL));
                    med_rem_list.setAdapter(mAdapter2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                fab.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.VISIBLE);
                med_rem_list.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAlarm_Medicine(Context context, String med_id) {
        MySharedPreference pref = new MySharedPreference(context);
        MedicineReminderDatabaseHelper db = new MedicineReminderDatabaseHelper(context);
        String med_status_remin = db.getStatusofReminder(pref.getUID());
        if (med_status_remin.equalsIgnoreCase("active")) {

            String time_medicine = db.getTimeofReminder(pref.getUID(), med_id);
            String[] time_split_labtest = time_medicine.split(":");
            String time_hr_labtest = time_split_labtest[0];
            String time_min_labtest = time_split_labtest[1];
            int time_hr_int_labtest = Integer.parseInt(time_hr_labtest);
            int time_min_int_labtest = Integer.parseInt(time_min_labtest);

            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent();
            intent.setClass(context, AlarmMedicineReceiver.class);
            intent.setPackage("com.universalsompo.meta");
            intent.setAction("com.universalsompo.meta.MEDICINE");
            intent.putExtra("med_id", med_id);

            ComponentName receiver = new ComponentName(context, AlarmMedicineReceiver.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

            PendingIntent pi = PendingIntent.getBroadcast(context, Integer.parseInt(med_id), intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, time_hr_int_labtest);
            calendar.set(Calendar.MINUTE, time_min_int_labtest);
            calendar.set(Calendar.SECOND, 0);

            if (Build.VERSION.SDK_INT < 23) {
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            } else {
                RegisterMedicine();
                context.startService(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS | Intent.FLAG_FROM_BACKGROUND);
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
            }
        }
    }

    private void RegisterMedicine(){
        IntentFilter intent1 = new IntentFilter();
        intent1.addAction("com.universalsompo.meta.MEDICINE");
        AlarmMedicineReceiver myReceiver = new AlarmMedicineReceiver();
        Objects.requireNonNull(getActivity()).registerReceiver(myReceiver,intent1);
    }
}