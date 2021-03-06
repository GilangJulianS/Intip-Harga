package com.intipharga.holder;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerHolder;
import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;
import com.intipharga.model.Place;

/**
 * Created by macair on 2/8/16.
 */
public class PlaceHolder extends RecyclerHolder{

    public ImageView img;
    public TextView txtName;
    public RatingBar ratingBar;
    public TextView txtReviewCounter;
    public TextView txtAlamat;
    public ImageButton btnDelete;
    public ViewGroup card;
    public AlertDialog dialog;


    public PlaceHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        img = (ImageView) v.findViewById(R.id.img);
        txtName = (TextView) v.findViewById(R.id.txt_nama);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingbar);
        txtReviewCounter = (TextView) v.findViewById(R.id.txt_review_counter);
        txtAlamat = (TextView) v.findViewById(R.id.txt_alamat);
        card = (ViewGroup) v.findViewById(R.id.card_view);
        btnDelete = (ImageButton) v.findViewById(R.id.btn_delete);
    }

    @Override
    public void bind(DataModel dataModel, final Activity activity, int position) {
        Place p = (Place) dataModel;
        img.setImageResource(p.imgRes);
        txtName.setText(p.txtName);

        ratingBar.setRating(p.rating);
//        Drawable ratingDrawable = ratingBar.getProgressDrawable();
//        DrawableCompat.setTint(ratingDrawable, ContextCompat.getColor(activity, R.color.colorPrimary));
//        ratingBar.setProgressDrawable(ratingDrawable);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);

        txtReviewCounter.setText(p.reviewCounter + " Reviews");
        txtAlamat.setText(p.txtAlamat);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, null, MainActivity.FRAGMENT_PLACE));
            }
        });

        if(p.deleteable){
            btnDelete.setVisibility(View.VISIBLE);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    LayoutInflater inflater = activity.getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.dialog_removed, null);
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
        }else{
            btnDelete.setVisibility(View.GONE);
        }
    }
}
