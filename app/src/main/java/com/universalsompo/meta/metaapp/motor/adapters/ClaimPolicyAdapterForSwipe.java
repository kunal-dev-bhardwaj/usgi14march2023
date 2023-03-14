package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.universalsompo.meta.R;

public class ClaimPolicyAdapterForSwipe extends PagerAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] arr;

    public ClaimPolicyAdapterForSwipe(Context context, String[] arr) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_items, container, false);
        ScrollView scrolled_content = itemView.findViewById(R.id.scrolled_content);
        TextView text_here = itemView.findViewById(R.id.text_here);
        TextView no_data = itemView.findViewById(R.id.no_data);
        if (!arr[position].equals("null")  ) {
            no_data.setVisibility(View.GONE);
            scrolled_content.setVisibility(View.VISIBLE);
            text_here.setText(Html.fromHtml(arr[position]));
        } else {
            no_data.setVisibility(View.VISIBLE);
            scrolled_content.setVisibility(View.GONE);
        }
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}