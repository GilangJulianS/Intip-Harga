package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.intipharga.activity.R;
import com.intipharga.custom.PlacePagerAdapter;

/**
 * Created by macair on 2/8/16.
 */
public class PlaceFragment extends Fragment {

    private AppCompatActivity activity;
    private PlacePagerAdapter adapter;
    private ViewPager viewPager;
    private PagerSlidingTabStrip pagertab;

    public PlaceFragment(){}

    public static PlaceFragment newInstance(AppCompatActivity activity){
        PlaceFragment fragment = new PlaceFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_place, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        pagertab = (PagerSlidingTabStrip) v.findViewById(R.id.pagertab);
        viewPager = (ViewPager) v.findViewById(R.id.view_pager);
    }

    public void setupViews(){

        adapter = new PlacePagerAdapter(activity, viewPager);

        viewPager.setAdapter(adapter);

        pagertab.setShouldExpand(true);
//        pagertab.setIndicatorColor(ContextCompat.getColor(activity, R.color.colorPrimary));

        pagertab.setViewPager(viewPager);

    }

    public void setupViewPager(){

    }
}
