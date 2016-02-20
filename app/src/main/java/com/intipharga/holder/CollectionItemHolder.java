package com.intipharga.holder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;
import com.intipharga.fragment.PlaceListFragment;
import com.intipharga.model.CollectionItem;

/**
 * Created by macair on 2/7/16.
 */
public class CollectionItemHolder extends RecyclerHolder {

    public ImageView img;
    public TextView txtPrimary;
    public TextView txtSecondary;
    public CardView card;
    private AlertDialog dialog;

    public CollectionItemHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        img = (ImageView) v.findViewById(R.id.img);
        txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
        txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);
        card = (CardView) v.findViewById(R.id.card_view);
    }

    @Override
    public void bind(DataModel dataModel, Activity activity, int position) {
        CollectionItem item = (CollectionItem) dataModel;
        img.setImageResource(item.imgRes);
        txtPrimary.setText(item.txtPrimary);
        txtSecondary.setText(item.jumlah + " Tempat");
        final Activity temp = activity;
        if(item.type == CollectionItem.TYPE_SELECT_TO_ADD){
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(temp);
                    LayoutInflater inflater = temp.getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.dialog_saved, null);
                    dialogView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    builder.setView(dialogView);
                    dialog = builder.create();
                    dialog.show();
                }
            });
        }else if(item.type == CollectionItem.TYPE_SELECT_TO_DETAIL_OTHER){
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = MainActivity.newIntent(temp, txtPrimary.getText().toString(), MainActivity.FRAGMENT_PLACE_LIST);
                    i.putExtra(MainActivity.KEY_MODE, PlaceListFragment.MODE_OTHER);
                    temp.startActivity(i);
                }
            });
        }else if(item.type == CollectionItem.TYPE_SELECT_TO_DETAIL_OWN){
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = MainActivity.newIntent(temp, txtPrimary.getText().toString(), MainActivity.FRAGMENT_PLACE_LIST);
                    i.putExtra(MainActivity.KEY_MODE, PlaceListFragment.MODE_OWN);
                    temp.startActivity(i);
                }
            });
        }
    }
}
