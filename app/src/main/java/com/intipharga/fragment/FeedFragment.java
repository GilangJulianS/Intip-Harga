package com.intipharga.fragment;

import android.support.v7.app.AppCompatActivity;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerFragment;
import com.intipharga.activity.R;
import com.intipharga.model.Feed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/20/16.
 */
public class FeedFragment extends RecyclerFragment {

    public FeedFragment(){}

    public static FeedFragment newInstance(AppCompatActivity activity){
        FeedFragment fragment = new FeedFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public List<DataModel> getDatas() {
        List<DataModel> datas = new ArrayList<>();

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.tiptop);
        images.add(R.drawable.steak);
        images.add(R.drawable.product1);

        datas.add(new Feed(R.drawable.user, "Anita", "Octagon Studio", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_CHECKIN, "08.00"));
        datas.add(new Feed(R.drawable.user, "Baifern", "Zengarden", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_PHOTOS, "08.00")
                            .setImages(images));
        datas.add(new Feed(R.drawable.user, "Destra", "Tip-Top Restaurant", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_REVIEW, "08.00")
                            .setRating(3.5f).setReview("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore"));
        datas.add(new Feed(R.drawable.user, "Anita", "Octagon Studio", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_CHECKIN, "08.00"));
        datas.add(new Feed(R.drawable.user, "Baifern", "Zengarden", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_PHOTOS, "08.00")
                .setImages(images));
        datas.add(new Feed(R.drawable.user, "Destra", "Tip-Top Restaurant", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_REVIEW, "08.00")
                .setRating(3.5f).setReview("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore"));
        datas.add(new Feed(R.drawable.user, "Anita", "Octagon Studio", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_CHECKIN, "08.00"));
        datas.add(new Feed(R.drawable.user, "Baifern", "Zengarden", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_PHOTOS, "08.00")
                .setImages(images));
        datas.add(new Feed(R.drawable.user, "Destra", "Tip-Top Restaurant", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_REVIEW, "08.00")
                .setRating(3.5f).setReview("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore"));
        datas.add(new Feed(R.drawable.user, "Anita", "Octagon Studio", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_CHECKIN, "08.00"));
        datas.add(new Feed(R.drawable.user, "Baifern", "Zengarden", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_PHOTOS, "08.00")
                .setImages(images));
        datas.add(new Feed(R.drawable.user, "Destra", "Tip-Top Restaurant", "Jl. Prof. Dr. Surya Sumantri No.91 Majesty Office Building Block A6-A7", Feed.TYPE_REVIEW, "08.00")
                .setRating(3.5f).setReview("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore"));

        return datas;
    }
}
