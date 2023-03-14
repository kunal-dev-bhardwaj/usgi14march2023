package com.universalsompo.meta.metaapp.motor.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class MYSharePrefLifestyleHRA {
    private static MYSharePrefLifestyleHRA object;
    private Context mContext;
    public static final String MyPREF = "MyPref";

    public static final String HIT_LIFESTYLE_API = "hit_lifestyle_api";

    SharedPreferences sharedpreferences1;

    public MYSharePrefLifestyleHRA(Context mContext) {
        this.mContext = mContext;
        sharedpreferences1 = mContext.getSharedPreferences(MyPREF, Context.MODE_PRIVATE);
    }

    public static MYSharePrefLifestyleHRA getInstance(Context mContext) {
        if (object == null) {
            object = new MYSharePrefLifestyleHRA(mContext);
        }
        return object;
    }

    public void setHitLifestyleAPI(String lifestyle_api) {
        SharedPreferences.Editor editor = sharedpreferences1.edit();
        editor.putString(HIT_LIFESTYLE_API, lifestyle_api);
        editor.commit();
    }

    public String getHitLifestyleAPI() {
        return sharedpreferences1.getString(HIT_LIFESTYLE_API, null);
    }
}
