package com.gilang.recyclerviewframework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intipharga.activity.R;

import java.util.List;

/**
 * Created by macair on 1/15/16.
 */
public abstract class RecyclerFragment extends Fragment{

    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;
    protected RecyclerAdapter adapter;
    protected List<DataModel> datas;
    protected Activity activity;


    public RecyclerFragment(){}

    public abstract List<DataModel> getDatas();

    public void onCreateView(View v, ViewGroup parent, Bundle savedInstanceState){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_recycler, parent, false);

        prepareDatas();
        prepareViews(v);

        onCreateView(v, parent, savedInstanceState);

        return v;
    }

    private void prepareDatas(){
        datas = getDatas();
    }

    protected void bindViews(View v){
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
    }

    protected void prepareViews(View v){
        bindViews(v);
        setupLayoutManager();
//        setupAnimator();
        setupAdapter();
    }

    private void setupLayoutManager(){
        if(getColumnNumber() == 1){
            layoutManager = new LinearLayoutManager(activity);
        }else{
            layoutManager = new GridLayoutManager(activity, getColumnNumber());
        }
        recyclerView.setLayoutManager(layoutManager);
    }

//    private void setupAnimator(){
//        SlideInUpAnimator slideAnimator = new SlideInUpAnimator(new
//                DecelerateInterpolator());
//        slideAnimator.setAddDuration(500);
//        slideAnimator.setMoveDuration(500);
//        recyclerView.setItemAnimator(slideAnimator);
//    }

    private void setupAdapter(){
        adapter = new RecyclerAdapter(activity);
        adapter.addAll(datas);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        datas.clear();
    }

    /*  Override to create grid recyclerview
     *  @return number of column to be generated
     */
    public int getColumnNumber(){
        return 1;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof Activity) {
            activity = (Activity)context;
        }
    }
}
