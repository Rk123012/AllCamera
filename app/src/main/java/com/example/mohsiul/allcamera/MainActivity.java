package com.example.mohsiul.allcamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");
        animalNames.add("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");
        animalNames.add("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");
        animalNames.add("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");
        animalNames.add("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.all_camera_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
