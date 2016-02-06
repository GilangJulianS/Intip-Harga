package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intipharga.activity.R;
import com.intipharga.custom.HomePagerAdapter;
import com.intipharga.model.HomePagerItem;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by macair on 2/6/16.
 */
public class HomeFragment extends Fragment {

    private AppCompatActivity activity;
    private ViewPager pager;
    private HomePagerAdapter adapter;
    private CirclePageIndicator indicator;

    public HomeFragment(){}

    public static HomeFragment newInstance(AppCompatActivity activity){
        HomeFragment fragment = new HomeFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_home, parent, false);

        bindView(v);
        setupView(v);

        return v;
    }

    public void bindView(View v){
        pager = (ViewPager) v.findViewById(R.id.view_pager);
        indicator = (CirclePageIndicator) v.findViewById(R.id.page_indicator);
    }

    public void setupView(View v){
        setupViewPager();
    }

    public void setupViewPager(){
        adapter = new HomePagerAdapter(activity);

        addDummyData();

        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }

    public void addDummyData(){
        adapter.add(new HomePagerItem("", "", "Kursus Masak1?", "Lihat jadwal yang sesuai1", "Klik di sini1"));
        adapter.add(new HomePagerItem("", "", "Kursus Masak2?", "Lihat jadwal yang sesuai2", "Klik di sini2"));
        adapter.add(new HomePagerItem("", "", "Kursus Masak3?", "Lihat jadwal yang sesuai3", "Klik di sini3"));
        adapter.add(new HomePagerItem("", "", "Kursus Masak4?", "Lihat jadwal yang sesuai4", "Klik di sini4"));
    }
}
