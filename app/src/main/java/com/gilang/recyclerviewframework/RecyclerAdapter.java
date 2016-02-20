package com.gilang.recyclerviewframework;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 1/15/16.
 */
public class RecyclerAdapter extends Adapter<RecyclerHolder>{

    public List<DataModel> datas;
    private Activity activity;
    private int showLimit;

    public RecyclerAdapter(Activity activity){
        datas = new ArrayList<>();
        this.activity = activity;
        showLimit = -1;
    }

    public void add(DataModel dataModel){
        datas.add(dataModel);
    }

    public void add(DataModel dataModel, int position){
        datas.add(position, dataModel);
    }

    public void addAll(List<DataModel> dataModels){
        datas.addAll(dataModels);
    }

    public void remove(DataModel dataModel){ datas.remove(dataModel); }

    public void remove(int position){ datas.remove(position); }

    public void clearAll(){ datas.clear(); }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return createViewHolder(v, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        holder.bind(datas.get(position), activity, position);
    }

    @Override
    public int getItemCount() {
        if(showLimit < 0){
            return datas.size();
        }else{
            return showLimit;
        }
    }

    @Override
    public int getItemViewType(int position){
        return datas.get(position).getViewResId();
    }

    public void setShowLimit(int limit){
        showLimit = limit;
        notifyDataSetChanged();
    }

    public int searchViewTypePosition(int viewType){
        int i = 0;
        boolean found = false;
        while(i < datas.size() && !found){
            if(datas.get(i).getViewResId() == viewType){
                found = true;
                i--;
            }
            i++;
        }
        return i;
    }

    public RecyclerHolder createViewHolder(View v, int viewType){
        return datas.get(searchViewTypePosition(viewType)).createViewHolder(v, activity, this);
    }
}
