package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.FeedHolder;

import java.util.List;

/**
 * Created by macair on 2/20/16.
 */
public class Feed extends DataModel {

    public static final int TYPE_REVIEW = 100;
    public static final int TYPE_CHECKIN = 101;
    public static final int TYPE_PHOTOS = 102;
    public int imgUser;
    public String nama;
    public int activityType;
    public String tempat;
    public String alamat;
    public String review;
    public float rating;
    public String time;
    public List<Integer> images;

    public Feed(int imgUser, String nama, String tempat, String alamat, int activityType, String time){
        this.imgUser = imgUser;
        this.nama = nama;
        this.activityType = activityType;
        this.time = time;
        this.tempat = tempat;
        this.alamat = alamat;
    }

    public Feed setReview(String review){
        this.review = review;
        return this;
    }

    public Feed setRating(float rating){
        this.rating = rating;
        return this;
    }

    public Feed setImages(List<Integer> images){
        this.images = images;
        return this;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_feed;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new FeedHolder(v, activity, adapter);
    }
}
