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

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerFragment;
import com.intipharga.activity.R;
import com.intipharga.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/20/16.
 */
public class MessageFragment extends Fragment{

    private AppCompatActivity activity;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;

    public MessageFragment(){}

    public static MessageFragment newInstance(AppCompatActivity activity){
        MessageFragment fragment = new MessageFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
    }

    public void setupViews(){
        layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, true);

        recyclerAdapter = new RecyclerAdapter(activity);
        addDummyData();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public void addDummyData() {

        recyclerAdapter.add(new Message(R.drawable.user, R.drawable.tiptop, "Destra sent you a gift", null, Message.SIDE_LEFT));
        recyclerAdapter.add(new Message(R.drawable.user, -1, null, "Pik! Happy birthday!", Message.SIDE_LEFT));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AppCompatActivity)
            activity = (AppCompatActivity) context;
    }
}
