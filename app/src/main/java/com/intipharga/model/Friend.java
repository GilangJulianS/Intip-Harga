package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.FriendHolder;

/**
 * Created by macair on 2/20/16.
 */
public class Friend extends DataModel {

    public int imgRes;
    public String nama;

    public Friend(int imgRes, String nama) {
        this.imgRes = imgRes;
        this.nama = nama;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_friend;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new FriendHolder(v, activity, adapter);
    }
}
