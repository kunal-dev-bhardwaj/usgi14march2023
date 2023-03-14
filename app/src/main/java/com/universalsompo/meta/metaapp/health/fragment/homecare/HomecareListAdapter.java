package com.universalsompo.meta.metaapp.health.fragment.homecare;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentMultipleVendor;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class HomecareListAdapter extends BaseAdapter implements ResponseListener {
    private Activity mContext;
    private ArrayList<HomecareList> listhomecare;
    private String homercare_list_id, homecare_service_name;
    private String city, state;
    private Dialog alert_dialog;
    private String wellness_name, wellness_id, wellness_url;

    public HomecareListAdapter(Activity mContext, ArrayList<HomecareList> listhomecare, String city, String state) {
        this.mContext = mContext;
        this.listhomecare = listhomecare;
        this.city = city;
        this.state = state;
    }

    @Override
    public int getCount() {
        return listhomecare.size();
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HomecareListAdapter.Holder h= new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_homecare_item, parent, false);

            h.homecare_service = convertView.findViewById(R.id.homecare_service);
            h.homecare_name = convertView.findViewById(R.id.homecare_name);
            h.icon = convertView.findViewById(R.id.icons);
            convertView.setTag(h);
        } else
            h = (HomecareListAdapter.Holder) convertView.getTag();

        h.homecare_name.setText(listhomecare.get(position).getTypeName());

        if (listhomecare.get(position).getIconPath().equalsIgnoreCase("")) {
            Picasso.get().load(R.drawable.dummy).fit().placeholder(R.drawable.dummy).into(h.icon);
        } else {
            Picasso.get().load(listhomecare.get(position).getIconPath()).fit().placeholder(R.drawable.dummy).into(h.icon);
        }

        if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Physiotherapy")) {
            Picasso.get().load(R.drawable.physiotherapy_new_icon).fit().placeholder(R.drawable.physiotherapy_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Nursing")) {
            Picasso.get().load(R.drawable.nurse_1).fit().placeholder(R.drawable.nurse_1).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Trained Attendants")) {
            Picasso.get().load(R.drawable.attendants_new_icon).fit().placeholder(R.drawable.attendants_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Mother & Baby Care")) {
            Picasso.get().load(R.drawable.mother_care_new_icon).fit().placeholder(R.drawable.mother_care_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Doctor Visit")) {
            Picasso.get().load(R.drawable.doctor_1_new_icon).fit().placeholder(R.drawable.doctor_1_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Nutrition & Diet Consulation")) {
            h.homecare_name.setText("Nutrition & Diet Consultation");
            Picasso.get().load(R.drawable.nutrition_new_icon).fit().placeholder(R.drawable.nutrition_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Diagnostics Tests")) {
            Picasso.get().load(R.drawable.labtest_1).fit().placeholder(R.drawable.labtest_1).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Doctor Teleconsulation")) {
            h.homecare_name.setText("Doctor" + "\n" + " Consultation");
            Picasso.get().load(R.drawable.doctor_consultation_online_new_icon).fit().placeholder(R.drawable.doctor_consultation_online_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Diabetes Management Program")) {
            Picasso.get().load(R.drawable.diabetes__management_new_icon).fit().placeholder(R.drawable.diabetes__management_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Vaccation")) {
            h.homecare_name.setText("Vaccination");
            Picasso.get().load(R.drawable.vaccination_new_icon).fit().placeholder(R.drawable.vaccination_new_icon).into(h.icon);
        } else if (listhomecare.get(position).getTypeName().equalsIgnoreCase("Elder Care")) {
            Picasso.get().load(R.drawable.elder_care_new_icon).fit().placeholder(R.drawable.elder_care_new_icon).into(h.icon);
        }

        h.homecare_service.setTag(position);
        h.homecare_service.setOnClickListener(view ->{
            int position1 =(Integer)view.getTag();
            homercare_list_id = listhomecare.get(position1).getTypeID();
            homecare_service_name = listhomecare.get(position1).getTypeName();
            new AppDataPushApi().callApi(mContext,"Homecare","Homecare list","User clicked on " + homecare_service_name + " homecare services");
            callApi(homercare_list_id);
        });

        return convertView;
    }

    static class Holder {
        TextView homecare_name;
        ImageView icon;
        LinearLayout homecare_service;
    }

    private void callApi(String homecare_id) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH,MySharedPreference.getInstance(mContext).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(mContext).getUID());
            object.put("HomeCareTypeID", homecare_id);
            object.put("State", state);
            object.put("City", city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(mContext, object, UrlHealthConstants.GET_HOMECARE_VENDOR_LIST, this, RequestHealthConstants.GET_HOMECARE_VENDOR_LIST);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_HOMECARE_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success") || object.optString("Message").equalsIgnoreCase("Data Not Found")) {
                if (object.optString("NoOfVendor").equalsIgnoreCase("0")) {
                    showAlertDialog();
                } else if (object.optString("NoOfVendor").equalsIgnoreCase("1")) {
                    JSONArray arr1;
                    try {
                        arr1 = object.getJSONArray("MarketPlaceResList");
                        for (int i = 0; i < arr1.length(); i++) {
                            JSONObject obj = arr1.getJSONObject(i);
                            wellness_name = obj.optString("VendorName");
                            wellness_id = obj.optString("VendorID");
                            wellness_url = obj.optString("WebsiteURL");
                        }
                        new AppDataPushApi().callApi(mContext,"Homecare","Homecare vendor","User got only one vendor in " + homecare_service_name + " which is " + wellness_name);
                        URL url = new URL(wellness_url);
                        String host = url.getHost();
                        Intent intent = new Intent(mContext, BookDriver.class);
                        intent.putExtra("title", "Home Care");
                        intent.putExtra("URL", wellness_url);
                        intent.putExtra("domain", host);
                        intent.putExtra("name", wellness_name);
                        intent.putExtra("VendorId", wellness_id);
                        intent.putExtra("VehicleType", "Homecare");
                        mContext.startActivity(intent);
                    } catch (JSONException | MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    new AppDataPushApi().callApi(mContext,"Homecare","Homecare vendor","User got multiple vendor for " + homecare_service_name);
                    replaceFragment1(new FragmentMultipleVendor(), homercare_list_id);
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
    }

    @SuppressLint("SetTextI18n")
    private void showAlertDialog() {
        alert_dialog = new Dialog(mContext);
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
        alert_msg.setText("No vendor found at your current location.");
        alert_heading.setText("Homecare");

        alert_dialog.show();
        ok_txt.setOnClickListener(v -> {
            new AppDataPushApi().callApi(mContext,"Homecare","Homecare vendor","User do not find any vendor for " + homecare_service_name);
            alert_dialog.dismiss();
        });
    }

    private void replaceFragment1(Fragment frag, String homercare_list_id) {
        if (NetworkUtils.isConnected(mContext)) {
            Bundle args = new Bundle();
            args.putString("type", "Homecare");
            args.putString("state", state);
            args.putString("city", city);
            args.putString("id", homercare_list_id);
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(mContext, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HOMECARE_HISTORY);
        } else {
            Toast.makeText(mContext, "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
