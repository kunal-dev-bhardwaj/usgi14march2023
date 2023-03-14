package com.universalsompo.meta.metaapp.health.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.ContentModel;
import com.universalsompo.meta.metaapp.motor.models.VideoDashboardModel;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private List<ContentModel> list;
    private Lifecycle lifecycle;

    public VideoAdapter(List<ContentModel> list, Lifecycle lifecycle) {
        this.list = list;
        this.lifecycle = lifecycle;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView;
        private com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer;
        private String currentVideoId;

        private MyViewHolder(com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView playerView) {
            super(playerView);
            youTubePlayerView = playerView;
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer initializedYouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer;
                    youTubePlayer.cueVideo(currentVideoId, 0);
                }
            });
        }

        void cueVideo(String videoId) {
            currentVideoId = videoId;

            if(youTubePlayer == null)
                return;

            youTubePlayer.cueVideo(videoId, 0);
        }
    }

    @NonNull
    @Override
    public VideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        lifecycle.addObserver(youTubePlayerView);
        return new MyViewHolder(youTubePlayerView);
    }

    @Override
    public void onBindViewHolder(final VideoAdapter.MyViewHolder holder, final int position) {
        holder.cueVideo(list.get(position).geturl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
