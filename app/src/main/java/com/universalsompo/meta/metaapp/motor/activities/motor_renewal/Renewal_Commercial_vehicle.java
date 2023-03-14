package com.universalsompo.meta.metaapp.motor.activities.motor_renewal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.PaymentMotorWeb;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Renewal_Commercial_vehicle extends Fragment {

    Button renew_btn;
    EditText policy_number;
    String str_policy_number="";
    CustomProgressDialog customerProgress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        customerProgress = new CustomProgressDialog(getContext());
        View  view=inflater.inflate(R.layout.fragment_renewal__commercial_vehicle, container, false);

        renew_btn=view.findViewById(R.id.renew_btn);
        policy_number=view.findViewById(R.id.policy_number);

        renew_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_policy_number=policy_number.getText().toString();
                if (str_policy_number.equals("")){
                    Toast.makeText(getContext(), "Please Enter Policy Number", Toast.LENGTH_SHORT).show();
                }else {
                    renewPolicy();
                }

            }
        });


        return  view;
    }
    private void renewPolicy() {
        customerProgress.showProgressBar();
        StringRequest request = new StringRequest(Request.Method.GET, UrlConstants.RENEWAL_MOTOR_URL +str_policy_number + "&WACode=20000001&WAAppCode=30000004&DocType=WebAPI", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    try {
                        customerProgress.hideProgressBar();
                        JSONObject object = new JSONObject(response);
                        if (object != null){
                            Log.e("@@@@@", String.valueOf(object));
                            String PrevPolicyNo = object.getString("PrevPolicyNo");
                            String FinalPremium = object.getString("FinalPremium");
                            String QuoteID = object.getString("QuoteID");
                            Intent intent=new Intent(getActivity(), PaymentMotorWeb.class);
                            intent.putExtra("QuoteID",QuoteID);
                            startActivity(intent);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        customerProgress.hideProgressBar();
                    }
                } else {
                    customerProgress.hideProgressBar();
                    Toast.makeText(getContext(), "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                customerProgress.hideProgressBar();
                Log.e("error is ", "" + error);
            }
        }) {

            //This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String credentials = "20000001" +":" + "30000004";
                String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Basic " + base64EncodedCredentials);
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }

}