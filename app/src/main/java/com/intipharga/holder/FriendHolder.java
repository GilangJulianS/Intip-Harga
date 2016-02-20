package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.Friend;

/**
 * Created by macair on 2/20/16.
 */
public class FriendHolder extends RecyclerHolder {

    public ImageView imgUser;
    public TextView txtNama;

    public FriendHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        imgUser = (ImageView) v.findViewById(R.id.img_user);
        txtNama = (TextView) v.findViewById(R.id.txt_nama);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        Friend friend = (Friend) dataModel;
        imgUser.setImageResource(friend.imgRes);
        txtNama.setText(friend.nama);
    }
}
