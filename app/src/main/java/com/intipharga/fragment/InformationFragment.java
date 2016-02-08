package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.intipharga.activity.R;
import com.intipharga.model.Photos;

/**
 * Created by macair on 2/8/16.
 */
public class InformationFragment extends Fragment {

    private AppCompatActivity activity;
    private RecyclerView photosRecycler;
    private RecyclerAdapter photosAdapter;
    private RecyclerView.LayoutManager photosManager;

    public InformationFragment(){}

    public static InformationFragment newInstance(AppCompatActivity activity){
        InformationFragment fragment = new InformationFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_information, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        photosRecycler = (RecyclerView) v.findViewById(R.id.recycler_photos);
    }

    public void setupViews(){
        photosAdapter = new RecyclerAdapter(activity);
        photosManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);

        addDummyData();

        photosRecycler.setLayoutManager(photosManager);
        photosRecycler.setAdapter(photosAdapter);
    }

    public void addDummyData(){
        photosAdapter.add(new Photos(R.drawable.product1));
        photosAdapter.add(new Photos(R.drawable.product2));
        photosAdapter.add(new Photos(R.drawable.product3));
        photosAdapter.add(new Photos(R.drawable.product4));
        photosAdapter.add(new Photos(R.drawable.product1));
        photosAdapter.add(new Photos(R.drawable.product2));
        photosAdapter.add(new Photos(R.drawable.product3));
        photosAdapter.add(new Photos(R.drawable.product4));
    }
}
