package com.universalsompo.meta.metaapp.health.fragment.reminders.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.LabTestReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentLabTestReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.model.LabTestReminder_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.List;

public class LabTestReminderAdapter extends RecyclerView.Adapter<LabTestReminderAdapter.MyViewHolder> {
    private Activity activity;
    private List<LabTestReminder_getter_setter> labtestreminderList1;
    private LayoutInflater inflater;
    MySharedPreference pref;
    LabTestReminderDatabaseHelper db;
    FragmentLabTestReminder frag;

    public LabTestReminderAdapter(Activity activity, List<LabTestReminder_getter_setter> labtestreminderList1, FragmentLabTestReminder frag1) {
        this.activity = activity;
        this.labtestreminderList1 = labtestreminderList1;
        this.frag = frag1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView testname, labname, date, time, active_deactive;
        LinearLayout delete_reminder;

        public MyViewHolder(View view) {
            super(view);
            testname =  view.findViewById(R.id.testname);
            labname =  view.findViewById(R.id.labname);
            date =  view.findViewById(R.id.date);
            time =  view.findViewById(R.id.time);
            active_deactive =  view.findViewById(R.id.active_deactive);
            delete_reminder =  view.findViewById(R.id.delete_reminder);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lab_reminder_list, parent, false);
        pref = MySharedPreference.getInstance(activity);
        db = new LabTestReminderDatabaseHelper(activity);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.testname.setText(labtestreminderList1.get(position).getTestname());
        holder.labname.setText(labtestreminderList1.get(position).getLabname());
        holder.date.setText(labtestreminderList1.get(position).getDate());
        String[] time_split = labtestreminderList1.get(position).getTime().split(":");
        String time_hr = time_split[0];
        String time_min = time_split[1];
        int time_hr_int = Integer.parseInt(time_hr);
        int time_min_int = Integer.parseInt(time_min);
        if (time_hr_int >= 0 && time_hr_int < 12) {
//            holder.time.setText(labtestreminderList1.get(position).getTime() + " AM");
            holder.time.setText(initHour(time_hr_int)+ ":"+initMin(time_min_int)+" AM");
        } else {
            holder.time.setText(initHour(time_hr_int)+ ":"+initMin(time_min_int)+" PM");
        }

        if (labtestreminderList1.get(position).getActivedeactive().equalsIgnoreCase("active")) {
            holder.active_deactive.setText(labtestreminderList1.get(position).getActivedeactive());
            holder.active_deactive.setTextColor(activity.getResources().getColor(R.color.green));
        } else {
            holder.active_deactive.setText(labtestreminderList1.get(position).getActivedeactive());
            holder.active_deactive.setTextColor(activity.getResources().getColor(R.color.red));
        }

        holder.delete_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteLabtest(labtestreminderList1.get(position).getUserid(), labtestreminderList1.get(position).getTestname(), labtestreminderList1.get(position).getLabname(), labtestreminderList1.get(position).getId());
                frag.responsebuilder();
            }
        });
    }

    @Override
    public int getItemCount() {
        return labtestreminderList1.size();
    }


    String initHour(int hr) {
        String hr1 = null;
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
    String initMin(int min) {
        String min1;
        if (min <= 9) {
            min1 = "0" + min;
        } else {
            min1 = "" + min;
        }
        return min1;
    }
}