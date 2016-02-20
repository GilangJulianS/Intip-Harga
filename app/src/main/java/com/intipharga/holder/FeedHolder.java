package com.intipharga.holder;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.Feed;
import com.intipharga.model.Photos;

/**
 * Created by macair on 2/20/16.
 */
public class FeedHolder extends RecyclerHolder {

    private ImageView imgUser, imgIcon;
    private TextView txtPrimary, txtSecondary, txtReview, txtTime;
    private ViewGroup groupReview;
    private RatingBar ratingBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;


    public FeedHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        imgUser = (ImageView) v.findViewById(R.id.img_user);
        imgIcon = (ImageView) v.findViewById(R.id.img_icon);
        txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
        txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);
        txtReview = (TextView) v.findViewById(R.id.txt_review);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingbar);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_photos);
        groupReview = (ViewGroup) v.findViewById(R.id.group_review);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        Feed feed = (Feed) dataModel;
        imgUser.setImageResource(R.drawable.user);

        String actDesc = "";

        switch (feed.activityType){
            case Feed.TYPE_CHECKIN:
                actDesc = "check-in at";
                imgIcon.setImageResource(R.drawable.call);
                groupReview.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                break;
            case Feed.TYPE_PHOTOS:
                actDesc = "writes review of";
                groupReview.setVisibility(View.GONE);
                imgIcon.setImageResource(R.drawable.call);
                setupRecyclerView(feed);
                break;
            case Feed.TYPE_REVIEW:
                actDesc = "took photos of";
                imgIcon.setImageResource(R.drawable.call);
                recyclerView.setVisibility(View.GONE);
                txtReview.setText(feed.review);
                ratingBar.setRating(feed.rating);
                LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
                stars.getDrawable(0).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
                stars.getDrawable(1).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
                stars.getDrawable(2).setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                break;
        }
        String fullText = feed.nama + " " + actDesc + " " + feed.tempat;
        setHighlightText(fullText, feed.tempat, txtPrimary);

        txtSecondary.setText(feed.alamat);


    }

    public void setupRecyclerView(Feed feed){
        layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);

        recyclerAdapter = new RecyclerAdapter(activity);
        addData(feed);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public void addData(Feed feed){
        float scale = activity.getResources().getDisplayMetrics().density;
        int size = (int) scale * 40;
        for(Integer i : feed.images){
            recyclerAdapter.add(new Photos(i, size));
        }
    }

    public void setHighlightText(String fullText, String textToHighlight, TextView textView){
        SpannableString ss = new SpannableString(fullText);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(activity, "Place Clicked", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        };
        int idx = fullText.indexOf(textToHighlight);
        ss.setSpan(clickableSpan, idx, idx+textToHighlight.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }
}
