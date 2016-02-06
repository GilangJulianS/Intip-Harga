package com.gilang.recyclerviewframework;

import android.app.Activity;
import android.view.View;

/**
 * Created by macair on 1/15/16.
 */
public abstract class DataModel {

    public abstract int getViewResId();

    public abstract RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter);
}
