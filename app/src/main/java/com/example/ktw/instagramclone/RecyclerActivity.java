package com.example.ktw.instagramclone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    private ImageView mImageView;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerImageView);

        // 1. imageView에 이미지 집어 넣기
        mImageView.setImageBitmap(
                Bitmap.createScaledBitmap
                        (BitmapFactory.decodeResource
                        (this.getApplicationContext().getResources(), R.drawable.photo),
                        640, 640, false));
        // 2. RecyclerAdapter에 레이아웃 세팅하기
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        // 3. RecyclerAdapter에 어댑터 세팅하기
        Bitmap thumbImage = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), R.drawable.photo),
                640, 640, false);
        ArrayList<ThumbnailItem> list = new ArrayList<>();
        list.add(new ThumbnailItem());
        list.add(new ThumbnailItem());
        list.add(new ThumbnailItem());
        list.add(new ThumbnailItem());
        list.add(new ThumbnailItem());
        list.add(new ThumbnailItem());
        list.add(new ThumbnailItem());


        for(ThumbnailItem item : list) {
            item.image = thumbImage;
        }

        RecyclerAdapter adapter = new RecyclerAdapter(list);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }}
