package com.intipharga.holder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;
import com.intipharga.model.Review;

/**
 * Created by macair on 2/9/16.
 */
public class ReviewHolder extends RecyclerHolder {

    public ImageView img;
    public TextView txtNama, txtCounter, txtReview, txtMVP;
    public RatingBar ratingBar;
    public Dialog dialog;

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
        }else{
            txtMVP.setVisibility(View.VISIBLE);
        }
        ratingBar.setRating(r.rating);
//        Drawable ratingDrawable = ratingBar.getProgressDrawable();
//        DrawableCompat.setTint(ratingDrawable, ContextCompat.getColor(activity, R.color.colorPrimary));
//        ratingBar.setProgressDrawable(ratingDrawable);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);

        setupViews();
    }

    public void setupViews(){
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                LayoutInflater inflater = activity.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_profile, null);
                Button btnFollow = (Button) dialogView.findViewById(R.id.btn_follow);
                Button btnProfile = (Button) dialogView.findViewById(R.id.btn_profile);
                Button btnCancel = (Button) dialogView.findViewById(R.id.btn_cancel);

                btnFollow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(activity, "User Successfully Followed", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                btnProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.startActivity(MainActivity.newIntent(activity, "Profile", MainActivity.FRAGMENT_PROFILE));
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                builder.setView(dialogView);
                dialog = builder.create();
                dialog.show();
            }
        });
    }
}
