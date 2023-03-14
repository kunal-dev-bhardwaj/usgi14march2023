package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentMetaHealthPolicyDetails;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class MyHealthPolicyAdapter extends RecyclerView.Adapter<MyHealthPolicyAdapter.MyViewHolder> {
    private Activity mContext;
    private List<MyHealthPolicyModel> listModelJobsInfo;
    private MySharedPreference prefrences;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView product_name, tv_policynumber, tv_insurancecompany;
        TextView expire_day, expire, fullname, tv_suminsured, tv_expiry_date;
        ImageView insurer_img;
        RelativeLayout rel1;

        public MyViewHolder(View view) {
            super(view);
            insurer_img = view.findViewById(R.id.insurer_img);
            product_name = view.findViewById(R.id.product_name);
            tv_policynumber = view.findViewById(R.id.tv_policynumber);
            expire_day = view.findViewById(R.id.expire_day);
            expire = view.findViewById(R.id.expire);
            tv_insurancecompany = view.findViewById(R.id.tv_insurancecompany);
            fullname = view.findViewById(R.id.fullname);
            tv_suminsured = view.findViewById(R.id.tv_suminsured);
            tv_expiry_date = view.findViewById(R.id.tv_expiry_date);
            rel1 = view.findViewById(R.id.rel1);
        }
    }

    public MyHealthPolicyAdapter(Activity mContext, List<MyHealthPolicyModel> listModelJobsInfo) {
        this.mContext = mContext;
        this.listModelJobsInfo = listModelJobsInfo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meta_health_own_policy_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        prefrences = new MySharedPreference(mContext);
        holder.product_name.setText(listModelJobsInfo.get(position).getProduct_Name());
        holder.tv_expiry_date.setText(listModelJobsInfo.get(position).getExpiryDate());
        holder.tv_policynumber.setText(listModelJobsInfo.get(position).getPolicy_Number());
        holder.tv_suminsured.setText(listModelJobsInfo.get(position).getSumInsured());
        holder.tv_insurancecompany.setText("Universal Sompo General Insurance Co. Ltd.");
        holder.fullname.setText(listModelJobsInfo.get(position).getPolicy_Holder_Name());
        holder.insurer_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.universal_logo));

        int day_left_to_expire = Integer.parseInt(listModelJobsInfo.get(position).getRemainingDay());
        if (day_left_to_expire < 1) {
            holder.expire.setVisibility(View.GONE);
            holder.expire_day.setVisibility(View.VISIBLE);
            holder.expire_day.setText("Expired");
            holder.expire_day.setTypeface(Typeface.SERIF);
            holder.expire_day.setTextColor(ContextCompat.getColor(mContext, R.color.expiry_header));
        } else if (day_left_to_expire == 1) {
            holder.expire.setVisibility(View.VISIBLE);
            holder.expire_day.setVisibility(View.VISIBLE);
            holder.expire_day.setTextColor(ContextCompat.getColor(mContext, R.color.lightblack));
            holder.expire_day.setText(day_left_to_expire + " Day");
        } else if (day_left_to_expire < 31) {
            holder.expire.setVisibility(View.VISIBLE);
            holder.expire_day.setVisibility(View.VISIBLE);
            holder.expire_day.setTextColor(ContextCompat.getColor(mContext, R.color.lightblack));
            holder.expire_day.setText(day_left_to_expire + " Days");
        } else {
            holder.expire.setVisibility(View.GONE);
            holder.expire_day.setVisibility(View.GONE);
        }

        holder.rel1.setOnClickListener(view -> {
            prefrences.addPolicy_id_health(listModelJobsInfo.get(position).getPolicyID());
            prefrences.setHealthClaimNumber(listModelJobsInfo.get(position).getClaimContactNumber());
            prefrences.setHealthClaimEmail(listModelJobsInfo.get(position).getClaimEmailID());
            prefrences.setHealthPolicyRemainingDays(listModelJobsInfo.get(position).getRemainingDay());
            prefrences.addPolicy_no_health(listModelJobsInfo.get(position).getPolicy_Number());
            Fragment frag = new FragmentMetaHealthPolicyDetails();
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(mContext, frag, R.id.policy_container, FragmentsHealthTags.FRAGMENT_INDIVIDUAL_MY_POLICY);
        });
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }
}
