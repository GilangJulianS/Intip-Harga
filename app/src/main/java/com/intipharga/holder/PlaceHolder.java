package com.intipharga.holder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
    public ViewGroup card;

    public PlaceHolder(View v, Activity activity, RecyclerAdapter adapter) {
        super(v, activity, adapter);
        img = (ImageView) v.findViewById(R.id.img);
        txtName = (TextView) v.findViewById(R.id.txt_nama);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingbar);
        txtReviewCounter = (TextView) v.findViewById(R.id.txt_review_counter);
        txtAlamat = (TextView) v.findViewById(R.id.txt_alamat);
        card = (ViewGroup) v.findViewById(R.id.card_view);
    }

    @Override
    public void bind(DataModel dataModel, final Activity activity, int position) {
        Place p = (Place) dataModel;
        img.setImageResource(p.imgRes);
        txtName.setText(p.txtName);
        ratingBar.setRating(p.rating);
        txtReviewCounter.setText(p.reviewCounter + " Reviews");
        txtAlamat.setText(p.txtAlamat);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, null, MainActivity.FRAGMENT_PLACE));
            }
        });
    }
}
