package com.gilang.recyclerviewframework;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by macair on 1/15/16.
 */
public abstract class RecyclerHolder extends RecyclerView.ViewHolder{

    protected Activity activity;
    protected RecyclerAdapter adapter;

    public RecyclerHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v);
        this.activity = activity;
        this.adapter = adapter;
    }

    public abstract void bind(DataModel dataModel, Activity activity, int position);
}
