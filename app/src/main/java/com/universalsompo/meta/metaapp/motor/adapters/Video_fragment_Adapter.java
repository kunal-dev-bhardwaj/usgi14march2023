package com.universalsompo.meta.metaapp.motor.adapters;

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

public class Video_fragment_Adapter extends RecyclerView.Adapter<Video_fragment_Adapter.MyViewHolder> {
    private List<ContentModel> list;
    private Lifecycle lifecycle;

    public Video_fragment_Adapter(List<ContentModel> list, Lifecycle lifecycle) {
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
    public Video_fragment_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate(R.layout.video_fragment, parent, false);
        lifecycle.addObserver(youTubePlayerView);

        return new MyViewHolder(youTubePlayerView);
    }

    @Override
    public void onBindViewHolder(final Video_fragment_Adapter.MyViewHolder holder, final int position) {
        holder.cueVideo(list.get(position).geturl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
