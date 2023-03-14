package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment.FragmentWYHRedeemPointsDocUpload;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model.RedeemPointsList;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import java.util.List;

public class RedeemPointsListAdapter extends RecyclerView.Adapter<RedeemPointsListAdapter.MyViewHolder> {
    private List<RedeemPointsList> loggedWeight;
    private Activity activity;

    public RedeemPointsListAdapter(Activity act, List<RedeemPointsList> loggedWeight) {
        this.activity = act;
        this.loggedWeight = loggedWeight;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView heading, description, points;
        LinearLayout redemption_button;

        public MyViewHolder(View view) {
            super(view);
            heading = view.findViewById(R.id.heading);
            description = view.findViewById(R.id.description);
            points = view.findViewById(R.id.points);
            redemption_button = view.findViewById(R.id.redemption_button);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_redeem_point_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.heading.setText(loggedWeight.get(position).getCategoryName());
        holder.description.setText(loggedWeight.get(position).getActivityDescription());
        holder.points.setText(loggedWeight.get(position).getAllowdUserLimit());

        holder.redemption_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentWYHRedeemPointsDocUpload();
                Bundle args = new Bundle();
                args.putString("id", loggedWeight.get(position).getId());
                args.putString("name", loggedWeight.get(position).getCategoryName());
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HELP);
            }
        });
    }

    @Override
    public int getItemCount() {
        return loggedWeight.size();
    }
}
