package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.CircleTransform;
import com.universalsompo.meta.metaapp.motor.models.ServiceModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ServiceGrideAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ServiceModel> vendorModelArrayList;

    public ServiceGrideAdapter(Context context, ArrayList<ServiceModel> vendorModelArrayList) {
        this.context = context;
        this.vendorModelArrayList = vendorModelArrayList;
    }

    @Override
    public int getCount() {
        return vendorModelArrayList.size();
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
        ServiceGrideAdapter.Holder h=new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_accessories_grid_item, null);
            h.img = convertView.findViewById(R.id.access_grid_image);
            h.txt = convertView.findViewById(R.id.access_grid_image_name);
            h.discount = convertView.findViewById(R.id.access_grid_discount);
            convertView.setTag(h);
        } else
            h = (ServiceGrideAdapter.Holder) convertView.getTag();

        Picasso.get().load(vendorModelArrayList.get(position).getIconPath()).transform(new CircleTransform(15,3)).placeholder(R.drawable.loading).error(R.drawable.error).into(h.img);
        h.txt.setText(vendorModelArrayList.get(position).getVendorName());
        h.discount.setText(vendorModelArrayList.get(position).getDiscount());
        return convertView;
    }

    class Holder {
        ImageView img;
        TextView txt,discount;
    }

}

