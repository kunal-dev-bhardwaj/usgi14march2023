package com.universalsompo.meta.metaapp.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

public class MyCheckPermission {


    public static boolean checkAppPermission(Context mContext, String permission) {
        int hasWriteContactsPermission = ActivityCompat.checkSelfPermission(mContext, permission);

        return hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermissionNow(Activity mContext, String[] permission, int flag) {
        ActivityCompat.requestPermissions(mContext, permission, flag);
    }

}
