package com.universalsompo.meta.metaapp.health.activities.hospital.adapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.hospital.model.HospitalModel;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyHealthPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;

import java.util.List;

public class Hospital_adapter extends RecyclerView.Adapter<Hospital_adapter.MyViewHolder>{
    private Activity mContext;
    private List<HospitalModel> hospitalList;

    public Hospital_adapter(Activity mContext, List<HospitalModel> hospitalList) {
        this.mContext = mContext;
        this.hospitalList = hospitalList;
    }
    @NonNull
    @Override
    public Hospital_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_listing, parent, false);
        return new Hospital_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Hospital_adapter.MyViewHolder holder, int position) {
        holder.hospital_nm.setText(hospitalList.get(position).getNameOfWorkshop());
        holder.txt_contact.setText(hospitalList.get(position).getContactNo());
        holder.txt_pin_code.setText(hospitalList.get(position).getPinCode());
        holder.txt_full_address.setText(hospitalList.get(position).getFullAddress());
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView hospital_nm,txt_contact,txt_pin_code,txt_full_address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hospital_nm=itemView.findViewById(R.id.hospital_nm);
            txt_contact=itemView.findViewById(R.id.txt_contact);
            txt_pin_code=itemView.findViewById(R.id.txt_pin_code);
            txt_full_address=itemView.findViewById(R.id.txt_full_address);

        }
    }
}
