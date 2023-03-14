package com.universalsompo.meta.metaapp.motor.adapters;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.CircleTransform;
import com.universalsompo.meta.metaapp.motor.models.ServiceModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.MyViewHolder> {
    private ArrayList<ServiceModel> modelArrayList;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_com_name;
        public ImageView com_img;
        public TextView txt_com_discount;
        public TextView txt_com_category;

        public MyViewHolder(View view) {
            super(view);
            txt_com_name = view.findViewById(R.id.txt_com_name);
            com_img = view.findViewById(R.id.com_img);
            txt_com_discount = view.findViewById(R.id.txt_com_discount);
            txt_com_category = view.findViewById(R.id.txt_com_category);
        }
    }

    public ServiceListAdapter(Activity activity, ArrayList<ServiceModel> modelArrayList) {
        this.activity = activity;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ServiceListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_static_vendor_item, parent, false);
        return new ServiceListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ServiceListAdapter.MyViewHolder holder, int position) {
        holder.txt_com_name.setText(modelArrayList.get(position).getVendorName());
        Picasso.get().load(modelArrayList.get(position).getIconPath()).transform(new CircleTransform(15,3)).error(R.drawable.error).placeholder(R.drawable.loading).into(holder.com_img);
        holder.txt_com_discount.setText(modelArrayList.get(position).getDescription());
        holder.txt_com_category.setText(modelArrayList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}

