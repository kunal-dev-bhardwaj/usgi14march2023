package com.universalsompo.meta.metaapp.motor.activities.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.AddonCoverGroupsModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.Motor_AddOns;

import java.util.ArrayList;
import java.util.List;

public class AddOnCoverageRecy extends RecyclerView.Adapter<AddOnCoverageRecy.Holder>{
     Activity mContext;
    ArrayList<AddonCoverGroupsModel> data1;

    public AddOnCoverageRecy(Activity mContext, ArrayList<AddonCoverGroupsModel> data1) {
        this.mContext=mContext;
        this.data1=data1;
    }


    @NonNull
    @Override
    public AddOnCoverageRecy.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_on_coverage_motor,parent,false);
        return new AddOnCoverageRecy.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddOnCoverageRecy.Holder holder, int position) {
        holder.AddonCoverGroupsName.setText(data1.get(position).getAddonCoverGroupsValue());
        holder.AddonCoverGroupsPremium.setText(data1.get(position).getAddonCoverGroupsPremiumValue());
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView AddonCoverGroupsName,AddonCoverGroupsPremium;
        public Holder(@NonNull View itemView) {
            super(itemView);
            AddonCoverGroupsName=itemView.findViewById(R.id.AddonCoverGroupsName);
            AddonCoverGroupsPremium=itemView.findViewById(R.id.AddonCoverGroupsPremium);

        }
    }
}
