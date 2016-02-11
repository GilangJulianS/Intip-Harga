package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.Promo;

/**
 * Created by macair on 2/11/16.
 */
public class PromoHolder extends RecyclerHolder {

    public ImageView imgCover, img;
    public TextView txtNama, txtDescription;

    public PromoHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        imgCover = (ImageView) v.findViewById(R.id.img_cover);
        img = (ImageView) v.findViewById(R.id.img);
        txtNama = (TextView) v.findViewById(R.id.txt_nama);
        txtDescription = (TextView) v.findViewById(R.id.txt_description);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        Promo p = (Promo) dataModel;
        imgCover.setImageResource(p.imgCoverRes);
        img.setImageResource(p.imgRes);
        txtNama.setText(p.txtNama);
        txtDescription.setText(p.txtDescription);
    }
}
