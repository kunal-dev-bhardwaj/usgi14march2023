package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.ContextCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.Constants;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;

import java.util.List;

public class RenewalPolicyAdapter1 extends RecyclerView.Adapter<RenewalPolicyAdapter1.MyViewHolder> {
    private Context mContext;
    private List<MyPolicyModel> listModelJobsInfo;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView reg_no, exp_date, policy_no, name, helper_text, com_name;
        TextView fullname,expiry_time;
        LinearLayout whole_layout;
        CardView card_view;
        ImageView veh_type_img;

        public MyViewHolder(View view) {
            super(view);
            reg_no = view.findViewById(R.id.reg_no);
            exp_date = view.findViewById(R.id.exp_date);
            policy_no = view.findViewById(R.id.policy_no);
            name = view.findViewById(R.id.name);
            helper_text = view.findViewById(R.id.helper_text);
            veh_type_img= view.findViewById(R.id.veh_type_img);
            whole_layout = view.findViewById(R.id.whole_layout);
            com_name = view.findViewById(R.id.renewal_company_txt);
            fullname = view.findViewById(R.id.fullname);
            expiry_time = view.findViewById(R.id.expiry_time);
            card_view = view.findViewById(R.id.card_view);
        }
    }

    public RenewalPolicyAdapter1(Context mContext, List<MyPolicyModel> listModelJobsInfo) {
        this.mContext = mContext;
        this.listModelJobsInfo = listModelJobsInfo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.renewal_policy_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.reg_no.setText(listModelJobsInfo.get(position).getRegistrationNumber());
        holder.exp_date.setText(listModelJobsInfo.get(position).getPolicyToDate());
        holder.policy_no.setText(listModelJobsInfo.get(position).getPolicyNumber());
        holder.name.setText(listModelJobsInfo.get(position).getModel());
        holder.com_name.setText(listModelJobsInfo.get(position).getInsCompName());
        holder.fullname.setText(listModelJobsInfo.get(position).getPolicyHolderName());

        if(listModelJobsInfo.get(position).getVehicleType().equals(Constants.TWO_WHEELER))
            holder.veh_type_img.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.bike));
        else
            holder.veh_type_img.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.car1));

        if (Integer.parseInt(listModelJobsInfo.get(position).getNoOfDaysLeft()) < 1) {
            holder.helper_text.setText("Expired");
            holder.helper_text.setTextColor(ContextCompat.getColor(mContext,R.color.expiry_header));
            holder.helper_text.setTypeface(Typeface.SERIF);
            holder.expiry_time.setVisibility(View.GONE);
        } else if(Integer.parseInt(listModelJobsInfo.get(position).getNoOfDaysLeft()) == 1){
            holder.helper_text.setText(listModelJobsInfo.get(position).getNoOfDaysLeft() + " Day");
        } else {
            holder.helper_text.setText(listModelJobsInfo.get(position).getNoOfDaysLeft() + " Days");
        }
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }
}
