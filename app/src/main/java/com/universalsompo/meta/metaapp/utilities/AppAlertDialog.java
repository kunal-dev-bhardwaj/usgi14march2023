package com.universalsompo.meta.metaapp.utilities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.universalsompo.meta.R;
import java.util.Objects;

public class AppAlertDialog {

    public static void showDialogFinishWithActivity(final Context tmContext, String Title,String Msg) {
        final Dialog alert_dialog = new Dialog(tmContext);
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText(Msg);
        alert_heading.setText(Title);

        alert_dialog.show();
        ok_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog.cancel();
                ((Activity) tmContext).finish();
            }
        });
    }
}
