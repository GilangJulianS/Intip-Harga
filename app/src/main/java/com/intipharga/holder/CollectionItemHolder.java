package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.R;
import com.intipharga.model.CollectionItem;

/**
 * Created by macair on 2/7/16.
 */
public class CollectionItemHolder extends RecyclerHolder {

    public ImageView img;
    public TextView txtPrimary;
    public TextView txtSecondary;

    public CollectionItemHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        img = (ImageView) v.findViewById(R.id.img);
        txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
        txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        CollectionItem item = (CollectionItem) dataModel;
        img.setImageResource(item.imgRes);
        txtPrimary.setText(item.txtPrimary);
        txtSecondary.setText(item.jumlah + " Tempat");
    }
}
