package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.ReviewHolder;

/**
 * Created by macair on 2/9/16.
 */
public class Review extends DataModel {

    public int imgRes;
    public String nama;
    public float rating;
    public boolean isMVP;
    public int followersCount;
    public int reviewsCount;
    public String review;

    public Review(int imgRes, String nama, float rating, boolean isMVP, int followersCount, int reviewsCount, String review) {
        this.imgRes = imgRes;
        this.nama = nama;
        this.rating = rating;
        this.isMVP = isMVP;
        this.followersCount = followersCount;
        this.reviewsCount = reviewsCount;
        this.review = review;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_review;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new ReviewHolder(v, activity, adapter);
    }
}
