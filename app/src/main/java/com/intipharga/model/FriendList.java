package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.FriendListHolder;

import java.util.List;

/**
 * Created by macair on 2/20/16.
 */
public class FriendList extends DataModel {

    public List<Friend> friends;

    public FriendList(List<Friend> friendList){
        friends = friendList;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_friend_list;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new FriendListHolder(v, activity, adapter);
    }
}
