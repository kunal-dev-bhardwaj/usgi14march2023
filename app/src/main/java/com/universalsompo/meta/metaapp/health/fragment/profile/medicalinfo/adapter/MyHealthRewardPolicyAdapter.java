package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.earnburn.EarnBurnWebView;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentMetaHealthPolicyDetails;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyHealthRewardPolicyAdapter extends RecyclerView.Adapter<MyHealthRewardPolicyAdapter.MyViewHolder> {
    private Activity mContext;
    private List<MyHealthPolicyModel> listModelJobsInfo;
    private MySharedPreference prefrences;
    String FunctionalityType="",strPolicyNumber="",rewardPoint="";
    TextView rewardPointText;
    CustomProgressDialog customerProgress;
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

    public MyHealthRewardPolicyAdapter(Activity mContext, List<MyHealthPolicyModel> listModelJobsInfo) {
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
        customerProgress = new CustomProgressDialog(mContext);
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
            strPolicyNumber=listModelJobsInfo.get(position).getPolicy_Number();
            GetPolicySummaryByPolicy();
            final Dialog dialog = new Dialog(mContext);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.setContentView(R.layout.rewards_popup_);
            Typeface fontAwesomeFont = Typeface.createFromAsset(mContext.getAssets(), "fonts/fontawesome-webfont.ttf");
            TextView fitness_icon = dialog.findViewById(R.id.fitness_icon);
            rewardPointText= dialog.findViewById(R.id.rewardPointText);
            fitness_icon.setTypeface(fontAwesomeFont);
            TextView earn_dialog = dialog.findViewById(R.id.earn_dialog);
            TextView burn_dialog = dialog.findViewById(R.id.burn_dialog);
            TextView close_dialog = dialog.findViewById(R.id.close_dialog);
            earn_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FunctionalityType="Earn";
                    earnAPi();
                    dialog.dismiss();


                }
            });
            close_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            burn_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rewardPoint.equals("0")){
                        dialog.dismiss();
                        Toast.makeText(mContext, "Reward point must be greater than 0", Toast.LENGTH_SHORT).show();
                    }else{
                        FunctionalityType="Burn";
                        earnAPi();
                        dialog.dismiss();
                    }


                }
            });
            dialog.show();

        });


    }

    private void GetPolicySummaryByPolicy() {
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("RequestSource", "1A9581EE-248C-48CB-9C64-W925C3CCC0EB");
            parameters.put("PolicyNumber", strPolicyNumber);
        } catch (Exception e) {
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, UrlHealthConstants.EarnBurnRewardURL, parameters,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("onResponse", response.toString());
//                customerProgress.hideProgressBar();
                try {
                    String StatusCode=response.getString("StatusCode");
                    if (StatusCode.equals("200")){
                        rewardPoint=response.getString("Data");
                        rewardPointText.setText(rewardPoint);
                    }else{
                        rewardPoint="0";
                        rewardPointText.setText(rewardPoint);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
//                    customerProgress.hideProgressBar();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("onErrorResponse", error.toString());
                rewardPoint="0";
                rewardPointText.setText(rewardPoint);

//                customerProgress.hideProgressBar();
//                Toast.makeText(mContext, "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("AppBase", "USGI");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(mContext);
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }


    private void earnAPi() {
//        String policyNumber="\+strPolicyNumber+\"";
        String mobleNumber="\"";
//           String BurnPolicy = "http://testusgiapi.watchyourhealth.com/api/EncryptString?jsonString=" + "{PolicyNo:" + "\"" + "2840/62384466/00/000" + "\"" + ",Mobile:" + "\"" + "9876543210" + "\"" + ",Functionality:" + "\"" + FunctionalityType + "\"" + "}";
        String BurnPolicy="https://ddec1-0-en-ctp.trendmicro.com:443/wis/clicktime/v1/query?url=https%3a%2f%2fwyhmobile.universalsompo.in%2fusgiapi%2fapi%2fEncryptString%3fjsonString%3d%257B&umid=5d8ace35-8818-4a09-b19f-416db809e839&auth=1f026cc2f27458ed1634747a8d893652ef851070-be54d7729f5c2798024136c49208f7e3f8cade6e"+"{PolicyNo:"+"\""+strPolicyNumber+"\""+",Mobile:"+"\""+prefrences.getMOBILE()+"\""+",Functionality:"+ "\""+FunctionalityType+"\""+"}" ;
        Log.e("BurnPolicy",BurnPolicy);
        customerProgress.showProgressBar();
        StringRequest request = new StringRequest(Request.Method.GET,BurnPolicy, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    customerProgress.hideProgressBar();
                    try {
                        customerProgress.hideProgressBar();
                        JSONObject object = new JSONObject(response);
                        if (object.optString("StatusCode").equals("200")){
                            JSONObject Data = object.getJSONObject("Data");
                            Log.e("@@@@@", String.valueOf(object));
                            String TokenNo = Data.getString("Token");

                            Intent intent=new Intent(mContext, EarnBurnWebView.class);
                            intent.putExtra("TokenNo",TokenNo);
                            intent.putExtra("FunctionalityType",FunctionalityType);
                            mContext.startActivity(intent);
                        }else{
                           String Message =object.optString("Message");
                            Toast.makeText(mContext, ""+Message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        customerProgress.hideProgressBar();
                    }
                } else {
                    customerProgress.hideProgressBar();
                    Toast.makeText(mContext, "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                customerProgress.hideProgressBar();
                Log.e("error is ", "" + error);
            }
        }) ;
        RequestQueue queue = Volley.newRequestQueue(mContext);
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }
}
