package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.FriendSectionHolder;

/**
 * Created by macair on 2/20/16.
 */
public class FriendSection extends DataModel {

    public String txt;

    public FriendSection(String txt){
        this.txt = txt;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_section_friend;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new FriendSectionHolder(v, activity, adapter);
    }
}
