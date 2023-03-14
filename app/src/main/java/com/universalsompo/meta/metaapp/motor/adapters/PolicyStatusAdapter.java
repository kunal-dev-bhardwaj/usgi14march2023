package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.Constants;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentSinglePolicyStatus;
import com.universalsompo.meta.metaapp.motor.models.ClaimStatusPolicy;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PolicyStatusAdapter extends RecyclerView.Adapter<PolicyStatusAdapter.MyViewHolder> {
    private Activity mContext;
    private List<ClaimStatusPolicy> listModelJobsInfo;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_motor, tv_policynumber, tv_expiry_date, tv_car_no, tv_insurancecompany;
        TextView claim_number_txt, fullname;
        ImageView vehicle_type_img;
        RelativeLayout rel1;

        public MyViewHolder(View view) {
            super(view);
            tv_motor = view.findViewById(R.id.tv_motor);
            tv_policynumber = view.findViewById(R.id.tv_policynumber);
            tv_insurancecompany = view.findViewById(R.id.tv_insurancecompany);
            tv_expiry_date = view.findViewById(R.id.tv_expiry_date);
            tv_car_no = view.findViewById(R.id.tv_car_no);
            claim_number_txt = view.findViewById(R.id.claim_number_txt);
            rel1 = view.findViewById(R.id.rel1);
            vehicle_type_img = view.findViewById(R.id.vehicle_type_img);
            fullname = view.findViewById(R.id.fullname);
        }
    }

    public PolicyStatusAdapter(Activity mContext, List<ClaimStatusPolicy> listModelJobsInfo) {
        this.mContext = mContext;
        this.listModelJobsInfo = listModelJobsInfo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meta_own_policy_claim_status_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_motor.setText(listModelJobsInfo.get(position).getMake() + " " +listModelJobsInfo.get(position).getModel());
        holder.tv_expiry_date.setText(parseDateToddMMyyyy(listModelJobsInfo.get(position).getExpiryDate()));
        holder.tv_policynumber.setText(listModelJobsInfo.get(position).getPolicyNumber());
        holder.claim_number_txt.setText(listModelJobsInfo.get(position).getClaimNo());
        holder.tv_car_no.setText(listModelJobsInfo.get(position).getVechileRegNo());
        holder.tv_insurancecompany.setText("Universal Sompo General Insurance Co. Ltd.");
        holder.fullname.setText(listModelJobsInfo.get(position).getInsurerName());

        if (listModelJobsInfo.get(position).getVechileType().equals(Constants.TWO_WHEELER))
            holder.vehicle_type_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bike));
        else
            holder.vehicle_type_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.car1));

        holder.rel1.setOnClickListener(view -> {
            Fragment frag = new FragmentSinglePolicyStatus();
            Bundle b = new Bundle();
            b.putString("claim_no", listModelJobsInfo.get(position).getClaimNo());
            b.putString("PolicyId", listModelJobsInfo.get(position).getPolicyId());
            frag.setArguments(b);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(mContext, frag, R.id.main_frame, FragmentsTags.FRAGMENT_TRACKING_STATUS);
        });
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "MM/dd/yyyy hh:mm:ss aa";
        String outputPattern = "dd MMM yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
