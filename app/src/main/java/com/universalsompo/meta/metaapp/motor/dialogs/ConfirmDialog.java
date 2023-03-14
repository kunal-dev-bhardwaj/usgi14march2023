package com.universalsompo.meta.metaapp.motor.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.LinkNewPolicyDailogCallback;

import java.util.Objects;

public class ConfirmDialog extends Dialog implements View.OnClickListener {
    private Activity activity;
    private String pos_bth_str;
    private String neg_bth_str;
    private String msg;
    private LinkNewPolicyDailogCallback linkNewPolicyDailogCallback;

    public ConfirmDialog(String msg, String pos_bth_str, String neg_bth_str, Activity activity, LinkNewPolicyDailogCallback linkNewPolicyDailogCallback) {
        super(activity);
        this.activity = activity;
        this.pos_bth_str = pos_bth_str;
        this.neg_bth_str = neg_bth_str;
        this.msg = msg;
        this.linkNewPolicyDailogCallback = linkNewPolicyDailogCallback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notify_delete_confirm1);
        Objects.requireNonNull(getWindow()).setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setCanceledOnTouchOutside(false);
        init();
    }

    private void init() {
        TextView txt_msg = findViewById(R.id.tvmobnumber);
        TextView txt_pos_btn = findViewById(R.id.tvyes);
        TextView txt_neg_btn = findViewById(R.id.tvno);
        txt_msg.setText(msg);
        txt_pos_btn.setText(pos_bth_str);
        txt_neg_btn.setText(neg_bth_str);
        txt_pos_btn.setOnClickListener(this);
        txt_neg_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvyes:
                linkNewPolicyDailogCallback.positive();
                dismiss();
                break;

            case R.id.tvno:
                linkNewPolicyDailogCallback.Negative();
                dismiss();
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            dismiss();
            activity.onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
