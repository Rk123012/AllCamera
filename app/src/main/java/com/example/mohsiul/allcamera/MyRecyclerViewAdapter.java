package com.example.mohsiul.allcamera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.BridesViewHolder> {


    private  Context context;
    private  Activity activity;

    // data is passed into the constructor
    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public BridesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, parent, false);


        return new BridesViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final BridesViewHolder holder, int position) {



        holder.videoView.setVideoURI(Uri.parse(mData.toString()));

        holder.videoView.start();


        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int arg1,
                                                   int arg2) {
                        // TODO Auto-generated method stub
                        mp.setAudioStreamType(AudioManager.AUDIOFOCUS_NONE);
                       // holder.pb_brides_loading.setVisibility(View.GONE);
                        mp.start();
                    }
                });
            }
        });

        holder.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return true;
            }
        });







    }
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen


    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class BridesViewHolder extends RecyclerView.ViewHolder {


        VideoView videoView;
        SurfaceView surfaceView;

        public BridesViewHolder(View view) {
            super(view);

            videoView = view.findViewById(R.id.videoView);
            surfaceView = view.findViewById(R.id.surfaceView1);
            //fullView = view.findViewById(R.id.fullView);
            //pb_brides_loading = view.findViewById(R.id.pb_brides_loading);


        }


    }
}