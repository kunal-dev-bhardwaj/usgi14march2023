package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentClaimStatusDetail;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthClaimStatusModel;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentSinglePolicyStatus;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyHealthClaimStatusPolicyAdapter extends RecyclerView.Adapter<MyHealthClaimStatusPolicyAdapter.MyViewHolder> {
    private Activity mContext;
    private List<MyHealthClaimStatusModel> listModelJobsInfo;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView product_name, tv_policynumber, tv_insurancecompany;
        TextView claim_number_txt, fullname, tv_suminsured, tv_expiry_date;
        ImageView insurer_img;
        RelativeLayout rel1;

        public MyViewHolder(View view) {
            super(view);
            insurer_img = view.findViewById(R.id.insurer_img);
            product_name = view.findViewById(R.id.product_name);
            tv_policynumber = view.findViewById(R.id.tv_policynumber);
            tv_insurancecompany = view.findViewById(R.id.tv_insurancecompany);
            fullname = view.findViewById(R.id.fullname);
            tv_suminsured = view.findViewById(R.id.tv_suminsured);
            tv_expiry_date = view.findViewById(R.id.tv_expiry_date);
            claim_number_txt = view.findViewById(R.id.claim_number_txt);
            rel1 = view.findViewById(R.id.rel1);
        }
    }

    public MyHealthClaimStatusPolicyAdapter(Activity mContext, List<MyHealthClaimStatusModel> listModelJobsInfo) {
        this.mContext = mContext;
        this.listModelJobsInfo = listModelJobsInfo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meta_health_claim_status_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.product_name.setText(listModelJobsInfo.get(position).getProduct_Name());
        holder.tv_expiry_date.setText(parseDateToddMMyyyy(listModelJobsInfo.get(position).getExpiryDate()));
        holder.tv_policynumber.setText(listModelJobsInfo.get(position).getPolicyNumber());
        holder.tv_suminsured.setText(listModelJobsInfo.get(position).getSumInsured());
        holder.tv_insurancecompany.setText("Universal Sompo General Insurance Co. Ltd.");
        holder.fullname.setText(listModelJobsInfo.get(position).getInsurerName());
        holder.claim_number_txt.setText(listModelJobsInfo.get(position).getClaimNo());
        holder.insurer_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.universal_logo));

        holder.rel1.setOnClickListener(view -> {
            Fragment frag = new FragmentClaimStatusDetail();
            Bundle b = new Bundle();
            b.putString("claimNo", listModelJobsInfo.get(position).getClaimNo());
            frag.setArguments(b);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(mContext, frag, R.id.main_frame1, FragmentsHealthTags.CLAIM_STATUS_TAG);
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
