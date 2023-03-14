package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.adapter;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model.ClaimMapHospitalDataModel;

import java.util.ArrayList;

public class ClaimMapHospitalListViewAdapter extends BaseAdapter {
    private ArrayList<ClaimMapHospitalDataModel> data;
    private Context mContext;
    private final LayoutInflater mInflater;

    public ClaimMapHospitalListViewAdapter(Context mContext, ArrayList<ClaimMapHospitalDataModel> data) {
        this.mContext = mContext;
        this.data = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.claim_map_garage_list_items, null);
        TextView name_of_workshop2 = convertView.findViewById(R.id.name_of_workshop2);
        name_of_workshop2.setText(data.get(position).getHospitalName());

        TextView help_line = convertView.findViewById(R.id.help_line);
        help_line.setText(data.get(position).getContactNo());

        TextView location_text2 = convertView.findViewById(R.id.location_text2);
        location_text2.setText(data.get(position).getAddress());
        ImageView icon_call = convertView.findViewById(R.id.icon_call);
        icon_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!data.get(position).getContactNo().equals(""))
                    popUpForCall(data.get(position).getContactNo(),data.get(position).getHospitalName());
                else
                    Toast.makeText(mContext, "Contact no. not available", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView icon_location = convertView.findViewById(R.id.icon_location);
        icon_location.setVisibility(View.GONE);

        View view1 = convertView.findViewById(R.id.view1);
        view1.setVisibility(View.GONE);
        return convertView;
    }

    void popUpForCall(final String no,final String name) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.callus_dialog);
        final TextView dialog_heading = dialog.findViewById(R.id.dialog_heading);
        final TextView number = dialog.findViewById(R.id.tvmobnumber);
        final TextView tvcall = dialog.findViewById(R.id.tvcall);
        final TextView tvcall_cancel = dialog.findViewById(R.id.tvcancel);
        if(name.equals("") || name.equals("0"))
        {
            dialog_heading.setText("Mr. XYZ");
        }
        else
        {
            dialog_heading.setText(name);
        }
        number.setText(no);
        tvcall_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        tvcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + no));
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mContext.startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
