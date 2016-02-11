package com.intipharga.model;

import android.app.Activity;
import android.view.View;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.holder.PromoHolder;

/**
 * Created by macair on 2/11/16.
 */
public class Promo extends DataModel{

    public int imgCoverRes;
    public String txtNama;
    public int imgRes;
    public String txtDescription;

    public Promo(int imgCoverRes, String txtNama, int imgRes, String txtDescription) {
        this.imgCoverRes = imgCoverRes;
        this.txtNama = txtNama;
        this.imgRes = imgRes;
        this.txtDescription = txtDescription;
    }

    @Override
    public int getViewResId() {
        return R.layout.card_promo;
    }

    @Override
    public RecyclerHolder createViewHolder(View v, Activity activity, RecyclerAdapter adapter) {
        return new PromoHolder(v, activity, adapter);
    }
}
