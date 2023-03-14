package com.universalsompo.meta.metaapp.health.fragment.marketplace.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment.FragmentCouponCode;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.model.MultipleVendor;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.activities.CircleTransform;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MultipleVendorListAdapter extends RecyclerView.Adapter<MultipleVendorListAdapter.MyViewHolder> {
    private ArrayList<MultipleVendor> modelArrayList;
    private Activity activity;
    private String category;
    private String market_url, market_name, vendor_id;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_com_name, txt_com_category;
        private ImageView com_img;
        private LinearLayout linear_layout;

        public MyViewHolder(View view) {
            super(view);
            txt_com_name = view.findViewById(R.id.txt_com_name);
            com_img = view.findViewById(R.id.com_img);
            txt_com_category = view.findViewById(R.id.txt_com_category);
            linear_layout = view.findViewById(R.id.linear_layout);
        }
    }


    public MultipleVendorListAdapter(Activity activity, ArrayList<MultipleVendor> modelArrayList, String category) {
        this.activity = activity;
        this.modelArrayList = modelArrayList;
        this.category = category;
    }

    @NonNull
    @Override
    public MultipleVendorListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_static_vendor_item, parent, false);
        return new MultipleVendorListAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MultipleVendorListAdapter.MyViewHolder holder, int position) {
        holder.txt_com_name.setText(modelArrayList.get(position).getVendorName());
        holder.txt_com_category.setText(category);
        Picasso.get().load(modelArrayList.get(position).getLogoURL()).transform(new CircleTransform(15,3)).error(R.drawable.error).placeholder(R.drawable.loading).into(holder.com_img);

        holder.linear_layout.setTag(position);

        holder.linear_layout.setOnClickListener(v -> {
            int position1 =(Integer)v.getTag();
            market_url = modelArrayList.get(position1).getWebsiteURL();
            market_name = modelArrayList.get(position1).getVendorName();
            vendor_id = modelArrayList.get(position1).getVendorID();

            new AppDataPushApi().callApi(activity,"Vendor","Vendor selected","User clicked on vendor " + market_name);

            if (market_name.equalsIgnoreCase("1mg") && category.equalsIgnoreCase("Lab Test")) {
                replaceFragment(new FragmentCouponCode(), vendor_id);
            } else {
                URL url = null;
                try {
                    url = new URL(market_url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                assert url != null;
                String host = url.getHost();
                Intent intent = new Intent(activity, BookDriver.class);
                intent.putExtra("title", category);
                intent.putExtra("URL", market_url);
                intent.putExtra("domain", host);
                intent.putExtra("name", market_name);
                intent.putExtra("VendorId", vendor_id);
                intent.putExtra("VehicleType", category);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    private void replaceFragment(Fragment frag, String id) {
        if (NetworkUtils.isConnected(activity)) {
            Bundle args = new Bundle();
            args.putString("id", id);
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_COUPON_CODE);
        } else {
            Toast.makeText(activity, "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
