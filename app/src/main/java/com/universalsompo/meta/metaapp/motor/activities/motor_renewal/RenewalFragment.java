package com.universalsompo.meta.metaapp.motor.activities.motor_renewal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHIAddOns;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.adapter.MotorRenewalAdapter;
import com.universalsompo.meta.metaapp.motor.activities.motor_model.QuotationRenewal;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


public class RenewalFragment extends Fragment implements ResponseListener {
    LinearLayout linerTwo,linerPrivate,linerCommercial;
    TextView txtTwo,txtPrivate,txtCommercial;
    RecyclerView RcyRenewMotor;
    TextView textViewNoPolicy;
    CustomProgressDialog customDialog;
    String PolicyNumber;
    private final ArrayList<MyPolicyModel> data1 = new ArrayList<>();
    private final ArrayList<QuotationRenewal> arrQuotationList = new ArrayList<>();
    ArrayList<JSONObject> arr = new ArrayList<JSONObject>();

    MotorRenewalAdapter motorRenewalAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_renewal, container, false);
        customDialog = CustomProgressDialog.getInstance(getContext());

        final Dialog viewBottomSheet = new Dialog(getContext());
        viewBottomSheet.setCanceledOnTouchOutside(false);
        viewBottomSheet.setCancelable(false);
        viewBottomSheet.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(viewBottomSheet.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        viewBottomSheet.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation1;
        viewBottomSheet.setContentView(R.layout.bottom_navigation_motor_renewal);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(viewBottomSheet.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        viewBottomSheet.getWindow().setAttributes(lp);
        ImageView bottomCancel=viewBottomSheet.findViewById(R.id.bottomCancel);
        RcyRenewMotor=viewBottomSheet.findViewById(R.id.RcyRenewMotor);
        textViewNoPolicy=viewBottomSheet.findViewById(R.id.textViewNoPolicy);
        init();

        customDialog.showProgressBar();
        bottomCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MainActivity.class);
                startActivity(intent);
//                bottomSheetDialog.dismiss();
            }
        });

        viewBottomSheet.show();

        return view;
    }
    private void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("UserID", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.UNIVERSAL_POLICY, this, RequestConstants.UNIVERSAL_POLICY);
        req.execute();
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.UNIVERSAL_POLICY) {
            new AppDataPushApi().callApi(getActivity(),"Policy Vault","Policy vault page","User checked his list of policies in vault");
            if (object.optString("Message").equals("Success")) {
                customDialog.hideProgressBar();
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("objPolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                         PolicyNumber = arr.optJSONObject(i).getString("PolicyNumber");
                        renewQuotation();
                        customDialog.hideProgressBar();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    customDialog.hideProgressBar();
                }
            }else {
                customDialog.hideProgressBar();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }


    private void renewQuotation() {
        customDialog.showProgressBar();
        StringRequest request = new StringRequest(Request.Method.GET, UrlConstants.RENEWAL_MOTOR_URL + PolicyNumber + "&WACode=20000001&WAAppCode=30000004&DocType=WebAPI", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    try {
                        customDialog.hideProgressBar();
                        JSONObject object = new JSONObject(response);
                        if (object != null){
                            Log.e("@@@@@", String.valueOf(object));
                            String ErrorDesc = object.getString("ErrorDesc");
                            if (ErrorDesc.equals("Quotation Successfully Generate.")){
                                JSONObject object1 = new JSONObject(response);
                                customDialog.hideProgressBar();
                                arr.add(object1);
                                Log.e("arrRenewal", String.valueOf(arr));
                                RcyRenewMotor.setVisibility(View.VISIBLE);
                                textViewNoPolicy.setVisibility(View.GONE);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                RcyRenewMotor.setLayoutManager(layoutManager);
                                motorRenewalAdapter = new MotorRenewalAdapter(getActivity(), RenewalFragment.this, arr);
                                RcyRenewMotor.setAdapter(motorRenewalAdapter);
                            }else {
//                                Toast.makeText(getContext(), ""+ErrorDesc, Toast.LENGTH_SHORT).show();
                                RcyRenewMotor.setVisibility(View.GONE);
                                textViewNoPolicy.setVisibility(View.VISIBLE);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        customDialog.hideProgressBar();

                    }
                } else {
                    customDialog.hideProgressBar();
                    Toast.makeText(getContext(), "We're facing technical issue ,Please try again later", Toast.LENGTH_SHORT).show();

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                customDialog.hideProgressBar();
                Log.e("error is ", "" + error);
            }
        }) ;

        RequestQueue queue = Volley.newRequestQueue(getContext());
//        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);

//        RequestQueue queue = Volley.newRequestQueue(Renewal_Motor.this);
//        queue.add(request);
    }

}