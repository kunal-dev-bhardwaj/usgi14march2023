package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;

import java.util.ArrayList;

public class AdapterLosstype extends BaseAdapter {
    private ArrayList<ClaimFilterModel> data;
    private Context mContext;
    private final LayoutInflater mInflater;

    public AdapterLosstype(Context mContext, ArrayList<ClaimFilterModel> data) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.loss_type_item, null);
        TextView txt = convertView.findViewById(R.id.txt);
        txt.setText(data.get(position).getName());
        return convertView;
    }
}
