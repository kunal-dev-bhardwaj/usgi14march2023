package com.universalsompo.meta.metaapp.health.fragment.marketplace.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class MultipleVendorGridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MultipleVendor> vendorModelArrayList;
    private String market_url, market_name, vendor_id;
    private String category;

    public MultipleVendorGridAdapter(Context context, ArrayList<MultipleVendor> vendorModelArrayList, String category) {
        this.context = context;
        this.vendorModelArrayList = vendorModelArrayList;
        this.category = category;
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
        MultipleVendorGridAdapter.Holder h=new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_accessories_grid_item, null);
            h.img = convertView.findViewById(R.id.access_grid_image);
            h.txt = convertView.findViewById(R.id.access_grid_image_name);
            h.linear_layout = convertView.findViewById(R.id.linear_layout);
            convertView.setTag(h);
        } else
            h = (MultipleVendorGridAdapter.Holder) convertView.getTag();

        Picasso.get().load(vendorModelArrayList.get(position).getLogoURL()).transform(new CircleTransform(15,3)).placeholder(R.drawable.loading).error(R.drawable.error).into(h.img);

        h.txt.setText(vendorModelArrayList.get(position).getVendorName());

        h.linear_layout.setTag(position);

        h.linear_layout.setOnClickListener(v -> {
            int position1 =(Integer)v.getTag();
            market_url = vendorModelArrayList.get(position1).getWebsiteURL();
            market_name = vendorModelArrayList.get(position1).getVendorName();
            vendor_id = vendorModelArrayList.get(position1).getVendorID();

            new AppDataPushApi().callApi(context,"Vendor","Vendor selected","User clicked on vendor " + market_name);

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
                Intent intent = new Intent(context, BookDriver.class);
                intent.putExtra("title", category);
                intent.putExtra("URL", market_url);
                intent.putExtra("domain", host);
                intent.putExtra("name", market_name);
                intent.putExtra("VendorId", vendor_id);
                intent.putExtra("VehicleType", category);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class Holder {
        ImageView img;
        TextView txt;
        LinearLayout linear_layout;
    }

    private void replaceFragment(Fragment frag, String id) {
        if (NetworkUtils.isConnected(context)) {
            Bundle args = new Bundle();
            args.putString("id", id);
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(context, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_COUPON_CODE);
        } else {
            Toast.makeText(context, "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
