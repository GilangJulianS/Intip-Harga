package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.FriendSection;

/**
 * Created by macair on 2/20/16.
 */
public class FriendSectionHolder extends RecyclerHolder {

    public TextView txt;

    public FriendSectionHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        txt = (TextView) v.findViewById(R.id.txt);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        FriendSection section = (FriendSection) dataModel;
        txt.setText(section.txt);
    }
}
