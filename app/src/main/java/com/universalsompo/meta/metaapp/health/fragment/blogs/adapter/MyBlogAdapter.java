package com.universalsompo.meta.metaapp.health.fragment.blogs.adapter;

import android.app.Activity;
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

import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.blogs.fragment.FragmentBlogDetail;
import com.universalsompo.meta.metaapp.health.fragment.blogs.model.Blog;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class MyBlogAdapter extends RecyclerView.Adapter<MyBlogAdapter.MyViewHolder> {
    private Activity mContext;
    private List<Blog> list;

    public MyBlogAdapter(Activity mContext, List<Blog> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView heading;
        ImageView blogimage;
        LinearLayout blog_detail;

        public MyViewHolder(View view) {
            super(view);
            heading = view.findViewById(R.id.heading);
            blogimage = view.findViewById(R.id.blogimage);
            blog_detail = view.findViewById(R.id.blog_detail);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_list_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.heading.setText(list.get(position).getBlogHeading());
        Picasso.get().load(list.get(position).getImagePath()).placeholder(R.drawable.loading).error(R.drawable.error).into(holder.blogimage);
        holder.blog_detail.setOnClickListener(v -> {
            new AppDataPushApi().callApi(mContext,"Blogs","Blog list","User wants to know more about blog - " + list.get(position).getBlogHeading());
            Fragment frag = new FragmentBlogDetail();
            Bundle args = new Bundle();
            args.putString("blog_id", list.get(position).getBlogID());
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(mContext, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_BLOGS);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
