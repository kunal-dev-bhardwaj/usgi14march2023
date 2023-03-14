package com.universalsompo.meta.metaapp.utilities;

import android.content.Context;

import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import org.json.JSONObject;

public class AppDataPushApi {
    public void callApi(Context context, String module, String page, String action){
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(context).getToken_no());
            object.put("UserId", MySharedPreference.getInstance(context).getUID());
            object.put("ModuleName", module );
            object.put("PageName", page);
            object.put("ActionName", action);
            object.put("AppType", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        final ProjectVolleyRequest2 req = new ProjectVolleyRequest2(context, object, UrlConstants.APP_USER_LOG_DATA_PUSH,
                new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
            }
            @Override
            public void onError(VolleyError error, int Tag) { }
        }, RequestConstants.APP_USER_LOG_DATA_PUSH);
        req.execute();
    }



}
