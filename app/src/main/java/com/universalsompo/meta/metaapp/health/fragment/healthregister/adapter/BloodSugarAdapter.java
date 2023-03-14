package com.universalsompo.meta.metaapp.health.fragment.healthregister.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.healthregister.model.BloodSugar;
import java.util.List;

public class BloodSugarAdapter extends RecyclerView.Adapter<BloodSugarAdapter.MyViewHolder> {
    private List<BloodSugar> listbloodsugar;

    public BloodSugarAdapter(List<BloodSugar> listbloodsugar) {
        this.listbloodsugar = listbloodsugar;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, fasting_value, diff_fasting_value, pp_value, diff_pp_value;
        ImageView down_arrow5, up_arrow5, down_arrow6, up_arrow6;

        public MyViewHolder(View view) {
            super(view);
            date = view.findViewById(R.id.date);
            fasting_value = view.findViewById(R.id.fasting_value);
            diff_fasting_value = view.findViewById(R.id.diff_fasting_value);
            pp_value = view.findViewById(R.id.pp_value);
            diff_pp_value = view.findViewById(R.id.diff_pp_value);
            down_arrow5 = view.findViewById(R.id.down_arrow5);
            up_arrow5 = view.findViewById(R.id.up_arrow5);
            down_arrow6 = view.findViewById(R.id.down_arrow6);
            up_arrow6 = view.findViewById(R.id.up_arrow6);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_blood_sugar_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.date.setText(listbloodsugar.get(position).getDate());
        holder.fasting_value.setText(listbloodsugar.get(position).getFasting());
        holder.pp_value.setText(listbloodsugar.get(position).getPP());
        holder.diff_fasting_value.setText(listbloodsugar.get(position).getFastingDiffrence());
        holder.diff_pp_value.setText(listbloodsugar.get(position).getPPDiffrence());

        int fasting_diff = Integer.parseInt(listbloodsugar.get(position).getFastingDiffrence());
        int pp_diff = Integer.parseInt(listbloodsugar.get(position).getPPDiffrence());

        if(fasting_diff < 0){
            holder.down_arrow5.setVisibility(View.VISIBLE);
            holder.up_arrow5.setVisibility(View.GONE);
        } else if(fasting_diff > 0){
            holder.down_arrow5.setVisibility(View.GONE);
            holder.up_arrow5.setVisibility(View.VISIBLE);
        } else {
            holder.down_arrow5.setVisibility(View.GONE);
            holder.up_arrow5.setVisibility(View.GONE);
        }

        if(pp_diff < 0){
            holder.down_arrow6.setVisibility(View.VISIBLE);
            holder.up_arrow6.setVisibility(View.GONE);
        } else if(pp_diff > 0){
            holder.down_arrow6.setVisibility(View.GONE);
            holder.up_arrow6.setVisibility(View.VISIBLE);
        } else {
            holder.down_arrow6.setVisibility(View.GONE);
            holder.up_arrow6.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listbloodsugar.size();
    }
}
