package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.MedicalHistoryModel1;

import java.util.ArrayList;

public class MedicalHistoryAdapter1 extends RecyclerView.Adapter<MedicalHistoryAdapter1.MedHistoryHolder> {

    private ArrayList<MedicalHistoryModel1> medicalHistoryModelArrayList;
    Context context;
    private Activity activity;
    private ArrayList<String> Cbvalues = new ArrayList<String>();
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    private AdddiseaseListener adddiseaseListener;


    public MedicalHistoryAdapter1(ArrayList<MedicalHistoryModel1> medicalHistoryModelArrayList, Context context, Activity activity, AdddiseaseListener adddiseaseListener) {
        this.medicalHistoryModelArrayList = medicalHistoryModelArrayList;
        this.context = context;
        this.activity = activity;
        this.adddiseaseListener = adddiseaseListener;
    }

    @Override
    public MedicalHistoryAdapter1.MedHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicalhistory_row, parent, false);
        return new MedHistoryHolder(itemView, context, medicalHistoryModelArrayList);

    }

    @Override
    public void onBindViewHolder(final MedicalHistoryAdapter1.MedHistoryHolder holder, final int position) {

        MedicalHistoryModel1 medicalHistoryModel = medicalHistoryModelArrayList.get(position);
        holder.tvName.setText(medicalHistoryModelArrayList.get(position).getName());
        holder.TvId.setText(medicalHistoryModelArrayList.get(position).getId());
        String isSuffer = medicalHistoryModelArrayList.get(position).getId();

        if (isSuffer.equals("True")) {
            holder.cb.setChecked(true);
            String DiseaseID = medicalHistoryModelArrayList.get(position).getDiseaseId();
            if (adddiseaseListener != null) {
                adddiseaseListener.onClick(DiseaseID);
            }
        } else if (isSuffer.equals("False")) {
            holder.cb.setChecked(false);
        }

        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                String DiseaseID = medicalHistoryModelArrayList.get(position).getDiseaseId();

                if (holder.cb.isChecked()) {
                    if (adddiseaseListener != null) {
                        adddiseaseListener.onClick(DiseaseID);
                    }
                } else {
                    if (adddiseaseListener != null) {
                        adddiseaseListener.onUnClick(DiseaseID);
                    }

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (medicalHistoryModelArrayList == null)
            return 0;
        return medicalHistoryModelArrayList.size();
    }

    public class MedHistoryHolder extends RecyclerView.ViewHolder {
        TextView tvName, TvId, tvdiseaseid;
        CheckBox cb;

        public MedHistoryHolder(View itemView, Context context, ArrayList<MedicalHistoryModel1> medicalHistoryModelArrayList) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_medhisrow);
            TvId = itemView.findViewById(R.id.tv_medhisId);
            cb = itemView.findViewById(R.id.cb_medhisrow);
            tvdiseaseid = itemView.findViewById(R.id.tv_id);


        }
    }

    public interface AdddiseaseListener {
        void onClick(String diseaseID);

        void onUnClick(String diseaseID);
    }


}
