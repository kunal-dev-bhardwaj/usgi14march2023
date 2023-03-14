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
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.MedicineReminderDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentMedicineReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.model.MedReminder_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.List;

public class MedReminderAdapter extends RecyclerView.Adapter<MedReminderAdapter.MyViewHolder> {
    private Activity activity;
    private List<MedReminder_getter_setter> medlistreminder1;
    private LayoutInflater inflater;
    MySharedPreference pref;
    MedicineReminderDatabaseHelper db;
    FragmentMedicineReminder frag;

    public MedReminderAdapter(Activity activity, List<MedReminder_getter_setter> medreminder, FragmentMedicineReminder frag1) {
        this.activity = activity;
        this.medlistreminder1 = medreminder;
        this.frag = frag1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  time, active_deactive;
        LinearLayout delete_reminder;

        public MyViewHolder(View view) {
            super(view);

            time =  view.findViewById(R.id.time);
            active_deactive =  view.findViewById(R.id.active_deactive);
            delete_reminder =  view.findViewById(R.id.delete_reminder);
        }
    }

    @Override
    public MedReminderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.med_reminder_list, parent, false);
        pref = MySharedPreference.getInstance(activity);
        db = new MedicineReminderDatabaseHelper(activity);
        return new MedReminderAdapter.MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MedReminderAdapter.MyViewHolder holder, final int position) {

        String[] time_split = medlistreminder1.get(position).getTime().split(":");
        String time_hr = time_split[0];
        String time_min = time_split[1];
        int time_hr_int = Integer.parseInt(time_hr);
        int time_min_int = Integer.parseInt(time_min);
        if (time_hr_int >= 0 && time_hr_int < 12) {
            holder.time.setText(initHour(time_hr_int)+":"+initMin(time_min_int)+ " AM");
        } else {
            holder.time.setText(initHour(time_hr_int)+":"+initMin(time_min_int)+ " PM");

        }

        if (medlistreminder1.get(position).getActivedeactive().equalsIgnoreCase("active")) {
            holder.active_deactive.setText(medlistreminder1.get(position).getActivedeactive());
            holder.active_deactive.setTextColor(activity.getResources().getColor(R.color.green));
        } else {
            holder.active_deactive.setText(medlistreminder1.get(position).getActivedeactive());
            holder.active_deactive.setTextColor(activity.getResources().getColor(R.color.red));
        }

        holder.delete_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteMedRem(medlistreminder1.get(position).getUserid(), medlistreminder1.get(position).getId());
                frag.responsebuilder();
            }
        });
    }

    @Override
    public int getItemCount() {
        return medlistreminder1.size();
    }

    String initHour(int hr) {
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
