package com.universalsompo.meta.metaapp.motor.activities.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.AdditionalCoverGroupModel;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.AddonCoverGroupsModel;

import java.util.ArrayList;

public class AdditionalCoverageRecy extends RecyclerView.Adapter<AdditionalCoverageRecy.Holder>{
     Activity mContext;
    ArrayList<AdditionalCoverGroupModel> CoverGroupData;

    public AdditionalCoverageRecy(Activity mContext, ArrayList<AdditionalCoverGroupModel> CoverGroupData) {
        this.mContext=mContext;
        this.CoverGroupData=CoverGroupData;
    }


    @NonNull
    @Override
    public AdditionalCoverageRecy.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.additonal_coverage,parent,false);
        return new AdditionalCoverageRecy.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdditionalCoverageRecy.Holder holder, int position) {
        holder.CoverageName.setText(CoverGroupData.get(position).getAddonCoverGroupsValue());
        holder.CoveragePremiumTxt.setText("₹ "+CoverGroupData.get(position).getAddonCoverGroupsPremiumValue());
    }

    @Override
    public int getItemCount() {
        return CoverGroupData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView CoverageName,CoveragePremiumTxt;
        public Holder(@NonNull View itemView) {
            super(itemView);
            CoverageName=itemView.findViewById(R.id.CoverageName);
            CoveragePremiumTxt=itemView.findViewById(R.id.CoveragePremiumTxt);

        }
    }
}
