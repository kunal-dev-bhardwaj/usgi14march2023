package com.universalsompo.meta.metaapp.health.fragment.reminders.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.ConsultationReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentConsultationReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.model.ConsultationReminder_getter_setter;
import java.util.List;

public class ConsultationReminderAdapter extends RecyclerView.Adapter<ConsultationReminderAdapter.MyViewHolder> {
    private Activity activity;
    private List<ConsultationReminder_getter_setter> consultationreminderList1;
    private ConsultationReminderDatabaseHelper db;
    private FragmentConsultationReminder frag;

    public ConsultationReminderAdapter(Activity activity, List<ConsultationReminder_getter_setter> consultationreminderList1, FragmentConsultationReminder frag1) {
        this.activity = activity;
        this.consultationreminderList1 = consultationreminderList1;
        this.frag = frag1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView doctorname, doctornumber, date, time, active_deactive;
        LinearLayout delete_reminder;

        public MyViewHolder(View view) {
            super(view);
            doctorname =  view.findViewById(R.id.doctorname);
            doctornumber =  view.findViewById(R.id.doctornumber);
            date =  view.findViewById(R.id.date);
            time =  view.findViewById(R.id.time);
            active_deactive =  view.findViewById(R.id.active_deactive);
            delete_reminder =  view.findViewById(R.id.delete_reminder);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.consultation_list, parent, false);
        db = new ConsultationReminderDatabaseHelper(activity);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.doctorname.setText(consultationreminderList1.get(position).getDoctorname());
        holder.doctornumber.setText(consultationreminderList1.get(position).getDoctornumber());
        holder.date.setText(consultationreminderList1.get(position).getDate());
        String[] time_split = consultationreminderList1.get(position).getTime().split(":");
        String time_hr = time_split[0];
        String time_min = time_split[1];
        int time_hr_int = Integer.parseInt(time_hr);
        int time_min_int = Integer.parseInt(time_min);
        if (time_hr_int >= 0 && time_hr_int < 12) {
            holder.time.setText(initHour(time_hr_int)+":"+initMin(time_min_int)+ " AM");
        } else {
            holder.time.setText(initHour(time_hr_int)+":"+initMin(time_min_int)+ " PM");
        }

        if (consultationreminderList1.get(position).getActivedeactive().equalsIgnoreCase("active")) {
            holder.active_deactive.setText(consultationreminderList1.get(position).getActivedeactive());
            holder.active_deactive.setTextColor(activity.getResources().getColor(R.color.green));
        } else {
            holder.active_deactive.setText(consultationreminderList1.get(position).getActivedeactive());
            holder.active_deactive.setTextColor(activity.getResources().getColor(R.color.red));
        }

        holder.delete_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteLabtest(consultationreminderList1.get(position).getUserid(), consultationreminderList1.get(position).getDoctorname(), consultationreminderList1.get(position).getDoctornumber(), consultationreminderList1.get(position).getId());
                frag.responsebuilder();
            }
        });
    }

    @Override
    public int getItemCount() {
        return consultationreminderList1.size();
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

    private String initMin(int min) {
        String min1;
        if (min <= 9) {
            min1 = "0" + min;
        } else {
            min1 = "" + min;
        }
        return min1;
    }
}