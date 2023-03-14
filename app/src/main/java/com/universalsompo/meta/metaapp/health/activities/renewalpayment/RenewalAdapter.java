package com.universalsompo.meta.metaapp.health.activities.renewalpayment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.renewal_model.TenureModel;
import java.util.List;

public class RenewalAdapter extends RecyclerView.Adapter<RenewalAdapter.MyViewHolder> {

    Activity mContext;
    List<TenureModel> tenureModels;
    String QuotationID,strPolicyTenureTxt,strSumInsured,strNetPremiumTxtRenewal,strTotalPremiumTxt,CGST1,UGST1,SGST1,IGST1,GSt;
    int row_index=0;


    public RenewalAdapter(Activity mContext, List<TenureModel> tenureModels) {
        this.mContext = mContext;
        this.tenureModels = tenureModels;
    }

    @NonNull
    @Override
    public RenewalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.renewal_data, parent, false);
        return new RenewalAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RenewalAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        strPolicyTenureTxt=tenureModels.get(position).getTenure();
        strSumInsured=tenureModels.get(position).getSumInsured();
        strNetPremiumTxtRenewal=tenureModels.get(position).getNetpremium();
        strTotalPremiumTxt=tenureModels.get(position).getFinalpremium();
        strTotalPremiumTxt=tenureModels.get(position).getFinalpremium();
        CGST1=tenureModels.get(position).getCGST();
        IGST1=tenureModels.get(position).getIGST();
        SGST1=tenureModels.get(position).getSGST();
        UGST1=tenureModels.get(position).getUGST();
        GSt = String.valueOf(Double.parseDouble(CGST1) + Double.parseDouble(SGST1) + Double.parseDouble(IGST1) + Double.parseDouble(UGST1));

         if (strPolicyTenureTxt.equals("2")){
             holder.PolicyTenurePercent.setText("Discount: 5%");
         }else if (strPolicyTenureTxt.equals("3")){
            holder.PolicyTenurePercent.setText("Discount: 7.5%");
        }else{
             String parts1[] = strPolicyTenureTxt.split(" ");
             String str1= parts1[0];
             strPolicyTenureTxt=str1;
             holder.PolicyTenurePercent.setText(" ");
         }

        holder.PolicyTenureTxt1.setText(strPolicyTenureTxt+" Year");
        holder.SumInsuredTxt1.setText(strSumInsured);
        holder.NetPremiumTxtRenewal1.setText(strTotalPremiumTxt);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                if (mContext instanceof HealthRenewalSummary) {
                    QuotationID= tenureModels.get(position).getQuoteid();
                    ((HealthRenewalSummary) mContext).data_click(position);
                }
                row_index=position;
                notifyDataSetChanged();
            }
        });

        if(row_index==position){
            if (mContext instanceof HealthRenewalSummary) {
            QuotationID= tenureModels.get(position).getQuoteid();
            ((HealthRenewalSummary) mContext).data_click(position);
            }
            holder.MainLiner.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.green_tab_bg));
            holder.BookNowLinerComprehensive.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.green_bottom_border_curve));
            holder.radioButton.setChecked(true);
            holder.radioButton.setVisibility(View.VISIBLE);
            holder.radioButton.setEnabled(false);
        }else{
            holder.radioButton.setChecked(false);
            holder.radioButton.setVisibility(View.GONE);
            holder.MainLiner.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.grey_tab_bg));
            holder.BookNowLinerComprehensive.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.red_top_border_curve));
        }

    }



    @Override
    public int getItemCount() {
        return tenureModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView BasicPremiumTxt,PolicyTenureTxt1,PolicyTenurePercent,SumInsuredTxt1,NetPremiumTxtRenewal1,GSTTxt1,TotalPremiumTxt1;
        LinearLayout MainLiner,BookNowLinerComprehensive;
        RadioButton radioButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            PolicyTenurePercent=itemView.findViewById(R.id.PolicyTenurePercent);
            PolicyTenureTxt1=itemView.findViewById(R.id.PolicyTenureTxt1);
            BookNowLinerComprehensive=itemView.findViewById(R.id.BookNowLinerComprehensive);
            SumInsuredTxt1=itemView.findViewById(R.id.SumInsuredTxt1);
            NetPremiumTxtRenewal1=itemView.findViewById(R.id.NetPremiumTxtRenewal1);
            BasicPremiumTxt=itemView.findViewById(R.id.BasicPremiumTxt);
            radioButton=itemView.findViewById(R.id.radioButton);
            MainLiner=itemView.findViewById(R.id.MainLiner);
//            GSTTxt1=itemView.findViewById(R.id.GSTTxt1);
//            TotalPremiumTxt1=itemView.findViewById(R.id.TotalPremiumTxt1);
        }
    }
}
