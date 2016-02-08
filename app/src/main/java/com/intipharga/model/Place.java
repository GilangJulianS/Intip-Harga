package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.PlaceHolder;

/**
 * Created by macair on 2/8/16.
 */
public class Place extends DataModel {

    public int imgRes;
    public String txtName;
    public float rating;
    public int reviewCounter;
    public String txtAlamat;

    public Place(int imgRes, String txtName, float rating, int reviewCounter, String txtAlamat) {
        this.imgRes = imgRes;
        this.txtName = txtName;
        this.rating = rating;
        this.reviewCounter = reviewCounter;
        this.txtAlamat = txtAlamat;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_place;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new PlaceHolder(v, activity, adapter);
    }
}
