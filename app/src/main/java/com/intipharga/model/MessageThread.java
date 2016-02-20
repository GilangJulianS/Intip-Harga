package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.MessageThreadHolder;

/**
 * Created by macair on 2/20/16.
 */
public class MessageThread extends DataModel {

    public int imgRes;
    public int counter;
    public String nama;
    public String content;
    public String time;

    public MessageThread(int imgRes, int counter, String nama, String content, String time) {
        this.imgRes = imgRes;
        this.counter = counter;
        this.nama = nama;
        this.content = content;
        this.time = time;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_message_thread;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new MessageThreadHolder(v, activity, adapter);
    }
}
