package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.RSSActivity;
import com.universalsompo.meta.metaapp.motor.models.MotorRssModel;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.List;

public class RSSNewAdapter extends BaseAdapter {
    private Context context;
    private List<MotorRssModel> modelList;

    public interface call {
        void onItemClick(int position);
    }

    public RSSNewAdapter(Context context, List<MotorRssModel> modelList) {
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
        ViewHolder vh = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(context);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rss_items1, null);
            vh.image = convertView.findViewById(R.id.image1);
            vh.itemTitle1 = convertView.findViewById(R.id.itemTitle1);
            vh.itemPostedDate1 = convertView.findViewById(R.id.itemPostedDate1);
            vh.news = convertView.findViewById(R.id.news);
            convertView.setTag(vh);
        } else
            vh = (ViewHolder) convertView.getTag();

        vh.itemTitle1.setText(modelList.get(position).getTitle());
        vh.itemPostedDate1.setText(modelList.get(position).getPubDate());
        Picasso.get().load(modelList.get(position).getImagePath()).placeholder(R.drawable.loading).error(R.drawable.error).into(vh.image);

        vh.news.setOnClickListener(v -> {
            new AppDataPushApi().callApi(context,"News & Updates","News & update detail page","User clicked on " + modelList.get(position).getTitle() + " content");
            Intent in = new Intent(context, RSSActivity.class);
            in.putExtra("url", modelList.get(position).getLinks());
            context.startActivity(in);
        });
        return convertView;
    }

    class ViewHolder {
        ImageView image;
        TextView itemTitle1, itemPostedDate1;
        LinearLayout news;
    }
}
