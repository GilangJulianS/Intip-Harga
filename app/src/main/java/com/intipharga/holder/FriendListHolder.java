package com.intipharga.holder;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.Friend;
import com.intipharga.model.FriendList;

/**
 * Created by macair on 2/20/16.
 */
public class FriendListHolder extends RecyclerHolder {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerAdapter recyclerAdapter;

    public FriendListHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);

        recyclerAdapter = new RecyclerAdapter(activity);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        FriendList friendList = (FriendList) dataModel;
        recyclerAdapter.clearAll();
        for(Friend f : friendList.friends){
            recyclerAdapter.add(f);
        }
        recyclerAdapter.notifyDataSetChanged();
    }
}
