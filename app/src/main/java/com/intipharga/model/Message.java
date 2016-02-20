package com.intipharga.model;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.MessageHolder;

/**
 * Created by macair on 2/20/16.
 */
public class Message extends DataModel {

    public static final int SIDE_LEFT = 100;
    public static final int SIDE_RIGHT = 101;
    public int imgUser;
    public int img;
    public String info;
    public String content;
    public int side;

    public Message(int imgUser, int img, @Nullable String info, @Nullable String content, int side) {
        this.imgUser = imgUser;
        this.img = img;
        this.info = info;
        this.content = content;
        this.side = side;
    }

    @Override
    public int getViewResId() {
        if(side == SIDE_LEFT)
            return R.layout.card_message_in;
        else
            return R.layout.card_message_out;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new MessageHolder(v, activity, adapter);
    }
}
