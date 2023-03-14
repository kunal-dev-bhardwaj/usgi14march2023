package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model;


import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.MyApplication;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONObject;

/**
 * Created by Flash_Netcomm on 5/28/2018.
 */

public class Vrequest {
    private Context mContext;
    private JSONObject object;
    private String url;
    private ResponseListener listener;

    private int Tag;


    public Vrequest(Context mContext, JSONObject object, String url, ResponseListener listener, int Tag) {
        this.mContext = mContext;
        this.object = object;
        this.url = url;
        this.listener = listener;
        this.Tag = Tag;

    }

    synchronized public void execute() {
        if (NetworkUtils.isConnected(mContext)) {
          //  customDialog.showProgressBar();
            LogUtils.showLog("@@@@@@URL::", url);
            LogUtils.showLog("@@@@@@URL::", object.toString());
//            Log.e("@@@@@@URL::", url);
//            Log.e("@@@@@@URL::", object.toString());

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, object,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                        //    customDialog.hideProgressBar();
                            listener.onSuccess(response, Tag);
//                            Log.e("@@@@@@@@", response.toString());
                            LogUtils.showLog("@@@@@@@@", response.toString());

                        }
                    }, new Response.ErrorListener() {


                @Override
                public void onErrorResponse(VolleyError volleyError) {
                 //   customDialog.hideProgressBar();
                    volleyError.printStackTrace();
                    listener.onError(volleyError, Tag);
                    if (volleyError instanceof NetworkError) {
                        Toast.makeText(mContext, "No connection, Please check your network", Toast.LENGTH_LONG).show();
                    } else if (volleyError instanceof ServerError) {
                        Toast.makeText(mContext, "We're facing technical issue ,Please try again later", Toast.LENGTH_LONG).show();
                    } else if (volleyError instanceof AuthFailureError) {
                        Toast.makeText(mContext, "You're authentication fail. Don't worry, Just login again to continue.", Toast.LENGTH_LONG).show();
                    } else if (volleyError instanceof ParseError) {
                        Toast.makeText(mContext, "We're facing technical issue ,Please try again later", Toast.LENGTH_LONG).show();
                    } else if (volleyError instanceof NoConnectionError) {
                        Toast.makeText(mContext, "No connection, Please check your network", Toast.LENGTH_LONG).show();
                    } else if (volleyError instanceof TimeoutError) {
                        Toast.makeText(mContext, "You've been logged out of USGI. Don't worry, Just login again to continue.", Toast.LENGTH_LONG).show();
                    }
                    // AppAlertDialog.showDialogSelfFinish(mContext,"title","sms");
                }
            }
            );
            MyApplication.getInstance().addToRequestQueue(jsonObjReq, "" + Tag);
        } else {
            if (mContext != null)
                Toast.makeText(mContext, "No internet connection found", Toast.LENGTH_LONG).show();
            return;
        }
    }
}
