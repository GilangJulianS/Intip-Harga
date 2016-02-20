package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.Message;

/**
 * Created by macair on 2/20/16.
 */
public class MessageHolder extends RecyclerHolder {

    public ImageView imgUser, img;
    public TextView txtInfo, txtContent;

    public MessageHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        imgUser = (ImageView) v.findViewById(R.id.img_user);
        img = (ImageView) v.findViewById(R.id.img);
        txtInfo = (TextView) v.findViewById(R.id.txt_info);
        txtContent = (TextView) v.findViewById(R.id.txt_content);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        Message message = (Message) dataModel;
        imgUser.setImageResource(message.imgUser);
        if(message.img != -1)
            img.setImageResource(message.img);
        else
            img.setVisibility(View.GONE);
        if(message.info != null)
            txtInfo.setText(message.info);
        else
            txtInfo.setVisibility(View.GONE);
        if(message.content != null)
            txtContent.setText(message.content);
        else
            txtContent.setVisibility(View.GONE);
    }
}
