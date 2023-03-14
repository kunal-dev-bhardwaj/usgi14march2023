package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;

import com.universalsompo.meta.metaapp.motor.activities.TipsActivity;
import com.universalsompo.meta.metaapp.motor.models.MotorTipsModel;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.List;

public class Article_Adapter extends RecyclerView.Adapter<Article_Adapter.Holder>{

    private Context context;
    private List<MotorTipsModel> modelList;

    public Article_Adapter(Context context, List<MotorTipsModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt_tips;
        CardView card_view;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_tips);
            txt_tips = itemView.findViewById(R.id.txt_tips);
            card_view = itemView.findViewById(R.id.card_view);
        }
    }

    @NonNull
    @Override
    public Article_Adapter.Holder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_tips_iterm,parent,false);
        return new Article_Adapter.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Article_Adapter.Holder holder, final int position) {
        holder.txt_tips.setText(modelList.get(position).getTitle());
        Picasso.get().load(modelList.get(position).getImagePath()).placeholder(R.drawable.loading).error(R.drawable.error).into(holder.img);

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(context,"Tips of day","Tips of day detail page","User clicked on " + modelList.get(position).getTitle() + " content");
                Intent in = new Intent(context, TipsActivity.class);
                in.putExtra("url", modelList.get(position).getLinks());
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
