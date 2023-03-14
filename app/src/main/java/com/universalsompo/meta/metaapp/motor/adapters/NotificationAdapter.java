package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.NotificationModel;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONObject;

import java.util.ArrayList;

public class NotificationAdapter extends BaseAdapter implements ResponseListener {
    private Context context;
    private ArrayList<NotificationModel> data;

    public NotificationAdapter(Context context, ArrayList<NotificationModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public NotificationModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView txt_head, txt_msg;
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.fragmnet_notification_items, null);
        imageView = convertView.findViewById(R.id.notify_img);
        txt_head = convertView.findViewById(R.id.txt_notify_head);
        txt_msg = convertView.findViewById(R.id.txt_notify_msg);
        final NotificationModel model = getItem(position);
         LogUtils.showLog("@@@@@@@", position + ":" + model.getIsRead());
        if (model.getIsRead().equals("False")) {
            imageView.setBackgroundResource(R.drawable.notify_unread);
            txt_msg.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
            txt_head.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        } else {
            imageView.setBackgroundResource(R.drawable.notify_read);
            txt_msg.setTypeface(Typeface.create("sans-serif-thin", Typeface.NORMAL));
            txt_head.setTypeface(Typeface.create("sans-serif-thin", Typeface.NORMAL));

        }
        txt_msg.setText(model.getMessage());
        txt_head.setText(model.getCreateDate());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.getIsRead().equals("False")) {
                    model.setIsRead("True");
                    hitApiToMarkRead(model.getNotificationId());
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }


    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.MARK_READ_NOTIFICATION && object.optString("Message").equals("Success")) {

        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
    }


    private void hitApiToMarkRead(String notificationId) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(context).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(context).getUID());
            object.put("NotificationId", notificationId);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(context, object, UrlConstants.MARK_READ_NOTIFICATION, this, RequestConstants.MARK_READ_NOTIFICATION);
        req.execute();
    }
}
