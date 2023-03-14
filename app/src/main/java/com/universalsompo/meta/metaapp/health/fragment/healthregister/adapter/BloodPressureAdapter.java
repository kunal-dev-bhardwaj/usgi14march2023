package com.universalsompo.meta.metaapp.health.fragment.healthregister.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.model.BloodPressure;
import java.util.List;

public class BloodPressureAdapter extends RecyclerView.Adapter<BloodPressureAdapter.MyViewHolder> {
    private List<BloodPressure> listbloodpressure;

    public BloodPressureAdapter(List<BloodPressure> listbloodpressure) {
        this.listbloodpressure = listbloodpressure;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, systolic_value, diff_systolic_value, diastolic_value, diff_diastolic_value;
        ImageView down_arrow5, up_arrow5, down_arrow6, up_arrow6;

        public MyViewHolder(View view) {
            super(view);
            date = view.findViewById(R.id.date);
            systolic_value = view.findViewById(R.id.systolic_value);
            diff_systolic_value = view.findViewById(R.id.diff_systolic_value);
            diastolic_value = view.findViewById(R.id.diastolic_value);
            diff_diastolic_value = view.findViewById(R.id.diff_diastolic_value);
            down_arrow5 = view.findViewById(R.id.down_arrow5);
            up_arrow5 = view.findViewById(R.id.up_arrow5);
            down_arrow6 = view.findViewById(R.id.down_arrow6);
            up_arrow6 = view.findViewById(R.id.up_arrow6);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_blood_pressure_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.date.setText(listbloodpressure.get(position).getDate());
        holder.systolic_value.setText(listbloodpressure.get(position).getSystolic());
        holder.diastolic_value.setText(listbloodpressure.get(position).getDiastolic());
        holder.diff_systolic_value.setText(listbloodpressure.get(position).getSystolicDiffrence());
        holder.diff_diastolic_value.setText(listbloodpressure.get(position).getDiastolicDiffrence());

        int sys_diff = Integer.parseInt(listbloodpressure.get(position).getSystolicDiffrence());
        int dia_diff = Integer.parseInt(listbloodpressure.get(position).getDiastolicDiffrence());

        if(sys_diff < 0){
            holder.down_arrow5.setVisibility(View.VISIBLE);
            holder.up_arrow5.setVisibility(View.GONE);
        } else if(sys_diff > 0){
            holder.down_arrow5.setVisibility(View.GONE);
            holder.up_arrow5.setVisibility(View.VISIBLE);
        } else {
            holder.down_arrow5.setVisibility(View.GONE);
            holder.up_arrow5.setVisibility(View.GONE);
        }

        if(dia_diff < 0){
            holder.down_arrow6.setVisibility(View.VISIBLE);
            holder.up_arrow6.setVisibility(View.GONE);
        } else if(dia_diff > 0){
            holder.down_arrow6.setVisibility(View.GONE);
            holder.up_arrow6.setVisibility(View.VISIBLE);
        } else {
            holder.down_arrow6.setVisibility(View.GONE);
            holder.up_arrow6.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listbloodpressure.size();
    }
}
