package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.PhotosHolder;

/**
 * Created by macair on 2/8/16.
 */
public class Photos extends DataModel {

    public int imgRes;

    public Photos(int imgRes){
        this.imgRes = imgRes;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_photos;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new PhotosHolder(v, activity, adapter);
    }
}
