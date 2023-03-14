package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.YoutubeVideo;
import com.universalsompo.meta.metaapp.motor.models.ContentModel;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.MyViewHolder> {
    private Context mContext;
    private List<ContentModel> listModelJobsInfo;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt_title, txt_date;
        LinearLayout whole_layout;

        public MyViewHolder(View view) {
            super(view);
            txt_title = view.findViewById(R.id.txt_content);
            txt_date = view.findViewById(R.id.txt_content_date);
            img = view.findViewById(R.id.img_content);
            whole_layout = view.findViewById(R.id.whole_layout);
        }
    }

    public ContentAdapter(Context mContext, List<ContentModel> listModelJobsInfo) {
        this.mContext = mContext;
        this.listModelJobsInfo = listModelJobsInfo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_content_iterm, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txt_title.setText(listModelJobsInfo.get(position).getheading());
        holder.txt_date.setText(listModelJobsInfo.get(position).getPubDate());

        Picasso.get().load(listModelJobsInfo.get(position).getthumbnail()).into(holder.img);
        holder.whole_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(mContext,"Content","Content detail page","User clicked on " + listModelJobsInfo.get(position).getheading() + " content");
                Intent i = new Intent(mContext,YoutubeVideo.class);
                i.putExtra("Title",listModelJobsInfo.get(position).getheading());
                i.putExtra("Description",listModelJobsInfo.get(position).getdescription());
                i.putExtra("VideoCode",listModelJobsInfo.get(position).geturl());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }
}
