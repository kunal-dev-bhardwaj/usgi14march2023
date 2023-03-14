package com.universalsompo.meta.metaapp.motor.activities.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.QuotationRenewal;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.RenewalFragment;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.Renewal_Motor;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_Private_car;
import com.universalsompo.meta.metaapp.motor.adapters.MyPolicyAdapter;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MotorRenewalAdapter extends RecyclerView.Adapter<MotorRenewalAdapter.MyViewHolder>{
    Activity mContext;
//    ArrayList<QuotationRenewal> arrQuotationList;
    Fragment fragment;
    ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
    String VehiclePolicyHolderName="",VehiclePolicyNumber="",VehicleNumber="",IDV="",VehicleNewIDV="",VehiclePincode="",VehicleEndDate="",QuotationID="",VehicleModel="",VehicleRegistrationDate="",VehicleMobile="",VehicleNCB="",VehiclePremium="",VehicleNetPremium="",VehicleChasisNo="",VehicleEngineNo="",VehicleAuthCode="",str_vehicleManufacturerNm="",VehiclePolicyType="",VehicleProductCode="";
//    public MotorRenewalAdapter(Activity activity, Fragment fragment, ArrayList<MyPolicyModel> data1) {
//        this.mContext = activity;
//        this.fragment = fragment;
//        this.data1 = data1;
//    }

//    public MotorRenewalAdapter(Activity activity, Fragment fragment, ArrayList<QuotationRenewal> arrQuotationList) {
//        this.mContext = activity;
//        this.fragment = fragment;
//        this.arrQuotationList = arrQuotationList;
//    }
public MotorRenewalAdapter(Activity activity, Fragment fragment, ArrayList<JSONObject> arr) {
        this.mContext = activity;
        this.fragment = fragment;
        this.arr = arr;
    }


    @NonNull
    @Override
    public MotorRenewalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.motor_renewal_layout, parent, false);
        return new MotorRenewalAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MotorRenewalAdapter.MyViewHolder holder, int position) {

        try {
            VehicleNumber=arr.get(position).getString("RegistrationNo");
            VehicleChasisNo=arr.get(position).getString("ChassisNo");
            VehicleEngineNo=arr.get(position).getString("EngineNo");
            VehicleAuthCode=arr.get(position).getString("AuthCode");
            VehiclePolicyNumber=arr.get(position).getString("PrevPolicyNo");
            VehiclePolicyHolderName=arr.get(position).getString("ProposerName");
            VehiclePremium=arr.get(position).getString("FinalPremium");
//            VehicleNumber=arr.get(position).getString("FinancierName");
            IDV=arr.get(position).getString("Idv");
            VehicleEndDate=arr.get(position).getString("RED");
            VehicleNewIDV=arr.get(position).getString("NewIDV");
            str_vehicleManufacturerNm=arr.get(position).getString("ManufatureName");
            VehiclePolicyType=arr.get(position).getString("PolicyType");
            VehicleProductCode=arr.get(position).getString("ProductCode");
            VehicleModel=arr.get(position).getString("VehicleModel");
            QuotationID=arr.get(position).getString("QuoteID");
            VehicleNetPremium=arr.get(position).getString("NetPremium");
            VehicleNCB=arr.get(position).getString("NCB");
            VehicleMobile=arr.get(position).getString("Mobile");
            VehiclePincode=arr.get(position).getString("PinCode");
            VehicleRegistrationDate=arr.get(position).getString("RegistrationDate");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.VehicleNumberText.setText(VehicleNumber);
        holder.VehicleBrandText.setText(str_vehicleManufacturerNm);
        holder.VehicleModelTxt.setText(VehicleModel);
        holder.ExpireDateTxt.setText(VehicleEndDate);
        holder.PremiumDateTxt.setText("₹ "+VehiclePremium);
         holder.LinerRenewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    VehiclePolicyNumber=arr.get(position).getString("PrevPolicyNo");
                    Intent intent=new Intent(mContext, Renewal_Motor.class);
                    intent.putExtra("VehiclePolicyNumber",VehiclePolicyNumber);
                    intent.putExtra("VehicleEndDate",VehicleEndDate);
                    mContext.startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView VehicleNumberText,VehicleBrandText,VehicleModelTxt,ExpireDateTxt,PremiumDateTxt;
        LinearLayout LinerRenewal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            LinerRenewal=itemView.findViewById(R.id.LinerRenewal);
            VehicleNumberText=itemView.findViewById(R.id.VehicleNumberText);
            VehicleBrandText=itemView.findViewById(R.id.VehicleBrandText);
            VehicleModelTxt=itemView.findViewById(R.id.VehicleModelTxt);
            ExpireDateTxt=itemView.findViewById(R.id.ExpireDateTxt);
            PremiumDateTxt=itemView.findViewById(R.id.PremiumDateTxt);
        }
    }
}
