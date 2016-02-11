package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.Photos;

/**
 * Created by macair on 2/8/16.
 */
public class PhotosHolder extends RecyclerHolder {

    public ImageView img;

    public PhotosHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        img = (ImageView) v.findViewById(R.id.img);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        Photos p = (Photos) dataModel;
        img.setImageResource(p.imgRes);
    }
}
