package com.example.ktw.instagramclone;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ktw on 2017-07-22.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private List<ThumbnailItem> mThumbnailItems;

    public RecyclerAdapter(List<ThumbnailItem> thumbnailItems) {
        mThumbnailItems = thumbnailItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.list_thumbnail_item, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ThumbnailItem thumbnailItem = mThumbnailItems.get(position);
       RecyclerViewHolder ViewHolder  = (RecyclerViewHolder) holder;
        ViewHolder.thumbnail.setImageBitmap(thumbnailItem.image);
        ViewHolder.thumbnail.setScaleType(ImageView.ScaleType.FIT_START);

    }

    @Override
    public int getItemCount() {
        return mThumbnailItems.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
       private ImageView thumbnail;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }
}

