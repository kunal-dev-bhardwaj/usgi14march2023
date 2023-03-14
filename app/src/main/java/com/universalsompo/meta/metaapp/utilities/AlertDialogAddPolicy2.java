package com.universalsompo.meta.metaapp.utilities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy;

import java.util.Objects;

public class AlertDialogAddPolicy2 {
    Context context;
    private Dialog alert_dialog;
    private SelectorListener binder;

    @SuppressLint("SetTextI18n")
    public void showAlertDialogForPolicy(Context c, String msg) {
        context = c;
        binder = (SelectorListener) context;
        alert_dialog = new Dialog(c);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText(msg);
        alert_heading.setText("Add Policy");

        alert_dialog.show();
        ok_txt.setOnClickListener(v -> {
            replaceFragment(new FragmentPolicy());
            alert_dialog.dismiss();
        });
    }

    private void replaceFragment(Fragment frag) {
        if (NetworkUtils.isConnected(context)) {
            Bundle args = new Bundle();
            args.putInt("otherFrag", 0);
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(context, frag, R.id.main_frame, FragmentsTags.POLICY_FRAGMENT);
            binder.detect(FragmentsTags.POLICY_FRAGMENT);
        } else {
            Toast.makeText(context, "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
