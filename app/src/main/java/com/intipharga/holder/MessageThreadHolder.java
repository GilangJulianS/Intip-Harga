package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.MessageThread;

/**
 * Created by macair on 2/20/16.
 */
public class MessageThreadHolder extends RecyclerHolder {

    public ImageView imgUser;
    public TextView txtNama, txtContent, txtTime, txtCounter;

    public MessageThreadHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        imgUser = (ImageView) v.findViewById(R.id.img_user);
        txtNama = (TextView) v.findViewById(R.id.txt_nama);
        txtContent = (TextView) v.findViewById(R.id.txt_content);
        txtTime = (TextView) v.findViewById(R.id.txt_time);
        txtCounter = (TextView) v.findViewById(R.id.txt_counter);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        MessageThread msg = (MessageThread) dataModel;
        imgUser.setImageResource(msg.imgRes);
        txtNama.setText(msg.nama);
        txtContent.setText(msg.content);
        txtCounter.setText("" + msg.counter);
        txtTime.setText(msg.time);
    }
}
