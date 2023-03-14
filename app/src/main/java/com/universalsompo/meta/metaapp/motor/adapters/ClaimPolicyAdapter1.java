package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.Constants;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentClaimDetail;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import java.util.List;

public class ClaimPolicyAdapter1 extends RecyclerView.Adapter<ClaimPolicyAdapter1.MyViewHolder> {
    private Activity mContext;
    private List<MyPolicyModel> listModelJobsInfo;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView claim_policy_reg_no, claim_policy_exp_date, claim_policy_policy_no, claim_policy_name, claim_com_name;
        TextView fullname, helper_text, expiry_time;
        LinearLayout track_status_layout,  whole_layout;
        View view2;
        CardView card_view;
        ImageView vehcle_type_img;

        public MyViewHolder(View view) {
            super(view);
            claim_policy_reg_no = view.findViewById(R.id.claim_policy_reg_no);
            claim_policy_exp_date = view.findViewById(R.id.claim_policy_exp_date);
            claim_policy_policy_no = view.findViewById(R.id.claim_policy_policy_no);
            claim_policy_name = view.findViewById(R.id.claim_policy_name);
            claim_com_name = view.findViewById(R.id.claim_company_txt);
            helper_text = view.findViewById(R.id.helper_text);
            fullname = view.findViewById(R.id.fullname);
            track_status_layout = view.findViewById(R.id.track_status_layout);
            whole_layout = view.findViewById(R.id.whole_layout2);
            card_view = view.findViewById(R.id.card_view2);
            view2 = view.findViewById(R.id.view2);
            expiry_time = view.findViewById(R.id.expiry_time);
            vehcle_type_img= view.findViewById(R.id.vehcle_type_img);
        }
    }

    public ClaimPolicyAdapter1(Activity mContext, List<MyPolicyModel> listModelJobsInfo) {
        this.mContext = mContext;
        this.listModelJobsInfo =listModelJobsInfo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.claim_policy_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.claim_policy_reg_no.setText(listModelJobsInfo.get(position).getRegistrationNumber());
        holder.claim_policy_exp_date.setText(listModelJobsInfo.get(position).getPolicyToDate());
        holder.claim_policy_policy_no.setText(listModelJobsInfo.get(position).getPolicyNumber());
        holder.claim_policy_name.setText(listModelJobsInfo.get(position).getModel());
        holder.claim_com_name.setText(listModelJobsInfo.get(position).getInsCompName());
        holder.fullname.setText(listModelJobsInfo.get(position).getPolicyHolderName());
        if (listModelJobsInfo.get(position).getVehicleType().equals(Constants.TWO_WHEELER)) {
            holder.vehcle_type_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bike));
        } else {
            holder.vehcle_type_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.car1));
        }
        if (Integer.parseInt(listModelJobsInfo.get(position).getNoOfDaysLeft()) == 1) {
            holder.helper_text.setText(listModelJobsInfo.get(position).getNoOfDaysLeft() + " Day");
        } else if (Integer.parseInt(listModelJobsInfo.get(position).getNoOfDaysLeft()) > 1 && Integer.parseInt(listModelJobsInfo.get(position).getNoOfDaysLeft()) < 31) {
            holder.helper_text.setText(listModelJobsInfo.get(position).getNoOfDaysLeft() + " Days");
        } else {
            holder.expiry_time.setVisibility(View.GONE);
            holder.helper_text.setVisibility(View.GONE);
        }
        if (listModelJobsInfo.get(position).getIsClaimInitiated().equals("True")) {
            holder.view2.setVisibility(View.VISIBLE);
            holder.track_status_layout.setVisibility(View.VISIBLE);
        } else {
            holder.view2.setVisibility(View.GONE);
            holder.track_status_layout.setVisibility(View.GONE);
        }

        holder.whole_layout.setOnClickListener(view -> {
            if (NetworkUtils.isConnected(mContext)) {
                Fragment frag = new FragmentClaimDetail();
                Bundle b = new Bundle();
                b.putString("key", listModelJobsInfo.get(position).getInsCompID());
                b.putString("make", listModelJobsInfo.get(position).getMake());
                b.putString("contact", listModelJobsInfo.get(position).getInsCompContactNo());
                b.putString("policyIdFrDots", listModelJobsInfo.get(position).getPolicyID());
                b.putString("vehicleType", listModelJobsInfo.get(position).getVehicleType());
                b.putString("CoverageDetails" , listModelJobsInfo.get(position).getCoverageDetails());
                frag.setArguments(b);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(mContext, frag, R.id.main_frame, FragmentsTags.FRAGMENT_CLAIM_DETAIL);
            } else {
                Toast.makeText(mContext, "You are not connected to internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }
}
