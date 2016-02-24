package com.intipharga.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.intipharga.activity.R;
import com.intipharga.model.HomePagerItem;

/**
 * Created by macair on 2/6/16.
 */
public class HomePagerItemFragment extends Fragment {

    private AppCompatActivity activity;
    private TextView txtPrimary;
    private TextView txtSecondary;
    private Button btn;
    private ImageView img;
    private HomePagerItem item;

    public HomePagerItemFragment(){}

    public static HomePagerItemFragment newInstance(AppCompatActivity activity, HomePagerItem item){
        HomePagerItemFragment fragment = new HomePagerItemFragment();
        fragment.activity = activity;
        fragment.item = item;
        fragment.setRetainInstance(true);
        return fragment;
    }

    public void setData(HomePagerItem item){
        this.item = item;
        update();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle b){
        View v = inflater.inflate(R.layout.pager_home_item_1, parent, false);

        bindView(v);

//        if(b != null){
//            item = new HomePagerItem(b.getString("imgUrl"), b.getString("destUrl"), b.getString("primary"), b.getString("secondary"), b.getString("button"));
//        }

        update();

        return v;
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        outState.putString("primary", item.txtPrimary);
//        outState.putString("secondary", item.txtSecondary);
//        outState.putString("button", item.txtButton);
//        outState.putString("destUrl", item.destUrl);
//        outState.putString("imgUrl", item.imgUrl);
//
//        super.onSaveInstanceState(outState);
//    }

    public void bindView(View v){
        txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
        txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);
        btn = (Button) v.findViewById(R.id.btn);
        img = (ImageView) v.findViewById(R.id.img);
    }

    public void update(){
        txtPrimary.setText(item.txtPrimary);
        txtSecondary.setText(item.txtSecondary);
        btn.setText(item.txtButton);
        img.setImageResource(R.drawable.kursus_masak);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AppCompatActivity)
            activity = (AppCompatActivity) context;
    }
}
