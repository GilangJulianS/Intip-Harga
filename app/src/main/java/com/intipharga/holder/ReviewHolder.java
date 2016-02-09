package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.Review;

/**
 * Created by macair on 2/9/16.
 */
public class ReviewHolder extends RecyclerHolder {

    public ImageView img;
    public TextView txtNama, txtCounter, txtReview, txtMVP;
    public RatingBar ratingBar;

    public ReviewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        img = (ImageView) v.findViewById(R.id.img);
        txtNama = (TextView) v.findViewById(R.id.txt_nama);
        txtCounter = (TextView) v.findViewById(R.id.txt_counter);
        txtReview = (TextView) v.findViewById(R.id.txt_review);
        txtMVP = (TextView) v.findViewById(R.id.txt_mvp);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingbar);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        Review r = (Review) dataModel;
        img.setImageResource(r.imgRes);
        txtNama.setText(r.nama);
        txtCounter.setText(r.followersCount + " Followers | " + r.reviewsCount + " Reviews");
        txtReview.setText(r.review);
        if(!r.isMVP){
            txtMVP.setVisibility(View.GONE);
        }
        ratingBar.setRating(r.rating);
    }
}
