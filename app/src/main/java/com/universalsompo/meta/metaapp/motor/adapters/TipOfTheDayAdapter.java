package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.TipsActivity;
import com.universalsompo.meta.metaapp.motor.models.MotorTipsModel;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.List;

public class TipOfTheDayAdapter extends BaseAdapter {
    private Context context;
    private List<MotorTipsModel> modelList;

    public interface call {
        void onItemClick(int position);
    }

    public TipOfTheDayAdapter(Context context, List<MotorTipsModel> modelList) {
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
            convertView = inflater.inflate(R.layout.fragment_tips_iterm, null);
            vh.img = convertView.findViewById(R.id.img_tips);
            vh.txt_tips = convertView.findViewById(R.id.txt_tips);
            vh.card_view = convertView.findViewById(R.id.card_view);
            convertView.setTag(vh);
        } else
            vh = (ViewHolder) convertView.getTag();

        vh.txt_tips.setText(modelList.get(position).getTitle());
        Picasso.get().load(modelList.get(position).getImagePath()).placeholder(R.drawable.loading).error(R.drawable.error).into(vh.img);

        vh.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(context,"Tips of day","Tips of day detail page","User clicked on " + modelList.get(position).getTitle() + " content");
                Intent in = new Intent(context, TipsActivity.class);
                in.putExtra("url", modelList.get(position).getLinks());
                context.startActivity(in);
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView txt_tips;
        CardView card_view;
    }
}
