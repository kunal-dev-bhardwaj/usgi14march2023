package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.BuyPolicyModel;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.List;
import java.util.Objects;

public class BuyPolicyAdapter extends BaseAdapter {
    private Context context;
    private List<BuyPolicyModel> modelList;
    private MySharedPreference pref;

    public BuyPolicyAdapter(Context context, List<BuyPolicyModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
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
        BuyPolicyAdapter.ViewHolder vh = new BuyPolicyAdapter.ViewHolder();
        pref = MySharedPreference.getInstance(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_buy_policy_item, null);
            vh.product_name = convertView.findViewById(R.id.product_name);
            vh.product_desc = convertView.findViewById(R.id.product_desc);
            vh.btn_complete_health = convertView.findViewById(R.id.btn_complete_health);
            convertView.setTag(vh);
        } else
            vh = (BuyPolicyAdapter.ViewHolder) convertView.getTag();

        vh.product_name.setText(modelList.get(position).getProductName());
        vh.product_desc.setText(modelList.get(position).getProductDesc());
        vh.btn_complete_health.setOnClickListener(v -> {
            Intent in = new Intent(context, PolicyInBrowser.class);
            in.putExtra("PolicyNo", "");
            in.putExtra("VehicleType", "");
            in.putExtra("vendor_id", "");
            in.putExtra("ISFROMPDFFULL", "");
            if (pref.getisUSGIUser().equals("1")) {
                in.putExtra("Url", modelList.get(position).getProductUrl() + pref.getMOBILE() + "&CustId=" + pref.getCustID());
            } else {
                in.putExtra("Url", modelList.get(position).getProductUrl() + pref.getMOBILE() + "&CustId=0");
            }
            in.putExtra("fargmentTag", "Buy Policy");
            in.putExtra("type", modelList.get(position).getProductName());
            Objects.requireNonNull(context).startActivity(in);
        });
        return convertView;
    }

    class ViewHolder {
        TextView product_name;
        TextView product_desc;
        Button btn_complete_health;
    }
}
