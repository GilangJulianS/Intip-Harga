package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.CollectionItemHolder;

/**
 * Created by macair on 2/7/16.
 */
public class CollectionItem extends DataModel {

    public int imgRes;
    public String txtPrimary;
    public int jumlah;

    public CollectionItem(int imgRes, String txtPrimary, int jumlah){
        this.imgRes = imgRes;
        this.txtPrimary = txtPrimary;
        this.jumlah = jumlah;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_collection_item;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new CollectionItemHolder(v, activity, adapter);
    }
}
