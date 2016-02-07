package com.intipharga.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.intipharga.activity.R;
import com.intipharga.model.CollectionItem;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by macair on 2/7/16.
 */
public class MyCollectionsFragment extends Fragment {

    private AppCompatActivity activity;
    private List<CollectionItem> items;
    private ViewGroup container;

    public MyCollectionsFragment(){}

    public static MyCollectionsFragment newInstance(AppCompatActivity activity){
        MyCollectionsFragment fragment = new MyCollectionsFragment();
        fragment.activity = activity;
        fragment.items = new ArrayList<>();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_my_collections, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        container = (ViewGroup) v.findViewById(R.id.collections_container);
    }

    public void setupViews(){
        addDummyData();
        container.removeAllViews();
        LayoutInflater inflater = activity.getLayoutInflater();
        for(CollectionItem item : items){
            View v = inflater.inflate(R.layout.card_collection_item, container, false);
            ImageView img = (ImageView) v.findViewById(R.id.img);
            TextView txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
            TextView txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);

            img.setImageResource(item.imgRes);
            txtPrimary.setText(item.txtPrimary);
            txtSecondary.setText(item.jumlah + " Tempat");
            container.addView(v);
        }
    }

    public void addDummyData(){
        items.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12));
        items.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1));
        items.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5));
        items.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12));
        items.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1));
        items.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity)context;
    }
}
