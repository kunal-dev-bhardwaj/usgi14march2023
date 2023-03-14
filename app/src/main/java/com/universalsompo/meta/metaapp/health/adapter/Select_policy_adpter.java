package com.universalsompo.meta.metaapp.health.adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;


import com.universalsompo.meta.R;

import java.util.ArrayList;
import java.util.List;

public class Select_policy_adpter extends ArrayAdapter<String> {
    Context mContext;
    FragmentActivity activity;
    List<String> list_policy = new ArrayList<>();

    public Select_policy_adpter(FragmentActivity activity, List<String> list_policy, int resource) {
        super(activity, resource, list_policy);
        this.activity=activity;
        this.list_policy=list_policy;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.spinner_item);
        //ContextCompat.getColor(context, R.color.my_color)
        //tvName.setTextColor(mContext.getColor(R.color.spn_color));
        //tvName.setTextColor(Color.GRAY);
        tvName.setTextColor( ContextCompat.getColor(getContext(), R.color.black));
        return super.getDropDownView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.spinner_item);
        if(tvName!=null)

            tvName.setText(list_policy.get(position));

        return convertView;
    }
}
