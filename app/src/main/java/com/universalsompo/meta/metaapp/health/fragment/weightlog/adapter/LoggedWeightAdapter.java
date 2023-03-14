package com.universalsompo.meta.metaapp.health.fragment.weightlog.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.weightlog.model.LoggedWeight;
import java.util.List;

public class LoggedWeightAdapter extends RecyclerView.Adapter<LoggedWeightAdapter.MyViewHolder> {
    private List<LoggedWeight> loggedWeight;

    public LoggedWeightAdapter(List<LoggedWeight> loggedWeight) {
        this.loggedWeight = loggedWeight;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView weight_in_number, weight_logging_date;
        ImageView user_img;

        public MyViewHolder(View view) {
            super(view);
            weight_in_number = view.findViewById(R.id.weight_in_number);
            weight_logging_date = view.findViewById(R.id.weight_logging_date);
            user_img = view.findViewById(R.id.user_img);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_logged_weight_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.weight_in_number.setText(loggedWeight.get(position).getWeight());
        holder.weight_logging_date.setText(loggedWeight.get(position).getDate());
        if(loggedWeight.get(position).getImagePath() == null || loggedWeight.get(position).getImagePath().equals("")){
            Picasso.get().load(R.drawable.dummy).fit().placeholder(R.drawable.dummy).into(holder.user_img);
        } else {
            Picasso.get().load(loggedWeight.get(position).getImagePath()).fit().placeholder(R.drawable.dummy).into(holder.user_img);
        }
    }

    @Override
    public int getItemCount() {
        return loggedWeight.size();
    }
}
