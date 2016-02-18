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

    public static int TYPE_SELECT_TO_ADD = 100;
    public static int TYPE_SELECT_TO_DETAIL_OWN = 101;
    public static int TYPE_SELECT_TO_DETAIL_OTHER = 102;
    public int imgRes;
    public String txtPrimary;
    public int jumlah;
    public int type;

    public CollectionItem(int imgRes, String txtPrimary, int jumlah, int type){
        this.imgRes = imgRes;
        this.txtPrimary = txtPrimary;
        this.jumlah = jumlah;
        this.type = type;
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
