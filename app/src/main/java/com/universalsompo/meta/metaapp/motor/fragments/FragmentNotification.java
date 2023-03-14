package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.adapters.NotificationAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.NotificationModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentNotification extends Fragment implements ResponseListener {
    private View v;
    private ListView listView;
    private MySharedPreference prefrences;
    private LinearLayout ll_no_notification;
    private ArrayList<NotificationModel> dataList;
    private Menu mMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmnet_notification, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void init() {
        listView = v.findViewById(R.id.notification_list);
        ll_no_notification = v.findViewById(R.id.ll_no_notification);
        hitApi();
    }

    private void hitApi() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("UserId", prefrences.getUID());
            object.put("NotificationType", "MOTOR");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.CHECK_NOTIFICATION, this, RequestConstants.GET_NOTIFICATION);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_NOTIFICATION) {
            new AppDataPushApi().callApi(getActivity(),"Notification","Notification page","User checked his notifications");
            if (object.optString("Message").equals("Success")) {
                try {
                    if (dataList != null) {
                        dataList.clear();
                    }
                    ll_no_notification.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    JSONArray array = object.getJSONArray("objNotificationMsg");
                    dataList = new ArrayList<>();
                    for (int i = 0; i < array.length(); i++) {
                        NotificationModel model = new NotificationModel();
                        JSONObject obj = array.getJSONObject(i);
                        model.setCreateDate(obj.optString("createDate"));
                        model.setIsRead(obj.optString("IsRead"));
                        model.setMessage(obj.optString("message"));
                        model.setNotificationId(obj.optString("notificationId"));
                        dataList.add(model);
                    }
                    prefrences.setTotalNotificationCount("" + array.length());
                    NotificationAdapter adapter = new NotificationAdapter(getActivity(), dataList);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    ll_no_notification.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                }
            } else {
                mMenu.removeItem(R.id.clean_notification);
                ll_no_notification.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            }
        } else if (Tag == RequestConstants.CLEAR_NOTIFICATION) {
            new AppDataPushApi().callApi(getActivity(),"Notification","Notification page","User cleared all his notification");
            if (object.optString("Message").equals("Success")) {
                prefrences.setTotalNotificationCount("0");
                Objects.requireNonNull(getActivity()).onBackPressed();
            } else {
                Toast.makeText(getActivity(), object.optString("Message"), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        mMenu = menu;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.clean_notification) {
            if (dataList != null && dataList.size() > 0) {
                showAlertTocleanNotification();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void showAlertTocleanNotification() {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.notify_delete_confirm_motor);
        TextView txt_no = dialog.findViewById(R.id.tvmobnumber);
        txt_no.setText("Do you want to clean all notification?");
        TextView call = dialog.findViewById(R.id.tvyes);
        TextView cancel = dialog.findViewById(R.id.tvno);
        cancel.setOnClickListener(v -> dialog.dismiss());
        call.setOnClickListener(v -> {
            dialog.dismiss();
            hitApiToCleanNotification();
        });
        dialog.show();
    }

    private void hitApiToCleanNotification() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("Uid", prefrences.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ProjectVolleyRequest(getActivity(), object, UrlConstants.CLEAR_NOTIFICATION, this, RequestConstants.CLEAR_NOTIFICATION).execute();
    }
}
