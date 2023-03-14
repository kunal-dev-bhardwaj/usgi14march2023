package com.universalsompo.meta.metaapp.utilities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.universalsompo.meta.R;
import java.util.Objects;

public class CustomProgressDialog {

    @SuppressLint("StaticFieldLeak")
    private static CustomProgressDialog object;
    private Dialog dialog;
    private Context mContext;


    public static CustomProgressDialog getInstance(Context mContext) {
        if (object != null) {
            return object;
        } else return new CustomProgressDialog(mContext);
    }

    public CustomProgressDialog(Context mContext) {
        this.mContext = mContext;
    }

    public void showProgressBar() {
        dialog = new Dialog(mContext);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.loader_layout);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

    }

    public void hideProgressBar() {
        dialog.dismiss();
    }
}
