package com.intipharga.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by macair on 2/7/16.
 */
public class MyCollectionsFragment extends Fragment {

    private AppCompatActivity activity;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;

    public MyCollectionsFragment(){}

    public static MyCollectionsFragment newInstance(AppCompatActivity activity){
        MyCollectionsFragment fragment = new MyCollectionsFragment();
        fragment.activity = activity;
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
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
    }

    public void setupViews(){
        layoutManager = new LinearLayoutManager(activity);

        recyclerAdapter = new RecyclerAdapter(activity);
        addDummyData();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

    }

    public void addDummyData(){
        int type = CollectionItem.TYPE_SELECT_TO_DETAIL_OWN;
        recyclerAdapter.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12, type));
        recyclerAdapter.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1, type));
        recyclerAdapter.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5, type));
        recyclerAdapter.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12, type));
        recyclerAdapter.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1, type));
        recyclerAdapter.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5, type));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity)context;
    }
}
