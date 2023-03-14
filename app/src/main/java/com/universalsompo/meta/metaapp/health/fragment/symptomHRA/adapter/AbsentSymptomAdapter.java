package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.AbsentSymptom_getter_setter;

import java.util.ArrayList;

public class AbsentSymptomAdapter extends RecyclerView.Adapter<AbsentSymptomAdapter.MyViewHolder> {
    ArrayList<AbsentSymptom_getter_setter> modelArrayList;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView symptom_name;

        public MyViewHolder(View view) {
            super(view);
            symptom_name = view.findViewById(R.id.symptom_name);
        }
    }


    public AbsentSymptomAdapter(Activity activity, ArrayList<AbsentSymptom_getter_setter> modelArrayList) {
        this.activity = activity;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public AbsentSymptomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.absent_symptom_item, parent, false);
        return new AbsentSymptomAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(AbsentSymptomAdapter.MyViewHolder holder, int position) {
        holder.symptom_name.setText(modelArrayList.get(position).getname());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}