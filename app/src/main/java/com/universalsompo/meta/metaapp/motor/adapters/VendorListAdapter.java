package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.RSAModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VendorListAdapter extends RecyclerView.Adapter<VendorListAdapter.MyViewHolder> {
    private ArrayList<RSAModel> modelArrayList;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_com_name, txt_com_offer, txt_description,txt_discount;
        public ImageView com_img;

        public MyViewHolder(View view) {
            super(view);
            txt_discount = view.findViewById(R.id.txt_discount);
            txt_com_offer = view.findViewById(R.id.txt_com_offer);
            txt_description = view.findViewById(R.id.txt_description);
            txt_com_name = view.findViewById(R.id.txt_com_name);
            com_img = view.findViewById(R.id.com_img);
        }
    }
    public VendorListAdapter(Activity activity, ArrayList<RSAModel> modelArrayList) {
        this.activity = activity;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmnet_rsa_ventor_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txt_com_name.setText(modelArrayList.get(position).getVendor_name());
        holder.txt_discount.setText("Discount : "+modelArrayList.get(position).getVendor_discount()+"%");
        holder.txt_description.setText(modelArrayList.get(position).getOffers());
        Picasso.get().load(modelArrayList.get(position).getVendor_img()).error(R.drawable.error).placeholder(R.drawable.loading).into(holder.com_img);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
