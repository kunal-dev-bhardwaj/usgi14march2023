package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthClaimPolicyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class MyHealthClaimPolicyAdapter extends RecyclerView.Adapter<MyHealthClaimPolicyAdapter.MyViewHolder> implements ResponseListener {
    private Activity mContext;
    private List<MyHealthClaimPolicyModel> listModelJobsInfo;

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

    public MyHealthClaimPolicyAdapter(Activity mContext, List<MyHealthClaimPolicyModel> listModelJobsInfo) {
        this.mContext = mContext;
        this.listModelJobsInfo = listModelJobsInfo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meta_health_claim_own_policy_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
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

        holder.rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callApi(listModelJobsInfo.get(position).getPolicyID());
            }
        });
    }

    private void callApi(String s) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(mContext).getToken_no());
            object.put("PolicyID", s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(mContext, object, UrlHealthConstants.HEALTH_CLAIM_FILE, this, RequestHealthConstants.HEALTH_CLAIM_FILE);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.HEALTH_CLAIM_FILE) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {

            } else {
                final Dialog dialog = new Dialog(mContext);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setCancelable(true);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.setContentView(R.layout.no_data_found_dialog);
                TextView heading = dialog.findViewById(R.id.dialog_heading);
                TextView subheading = dialog.findViewById(R.id.dialog_subheading);
                heading.setText("Tracking Status");
                subheading.setText("No claim to be tracked");
                TextView ok = dialog.findViewById(R.id.tvok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }
}
