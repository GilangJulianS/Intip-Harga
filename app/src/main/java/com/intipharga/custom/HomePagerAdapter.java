package com.intipharga.custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.intipharga.fragment.HomePagerItemFragment;
import com.intipharga.model.HomePagerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/6/16.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private AppCompatActivity activity;
    private List<HomePagerItem> datas;
    private List<HomePagerItemFragment> fragments;

    public HomePagerAdapter(AppCompatActivity activity){
        super(activity.getSupportFragmentManager());
        this.activity = activity;
        datas = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    public void add(HomePagerItem item){
        datas.add(item);
        HomePagerItemFragment fragment = HomePagerItemFragment.newInstance(activity, item);
        fragments.add(fragment);
    }

    public void remove(HomePagerItem item){
        int idx = datas.indexOf(item);
        datas.remove(item);
        fragments.remove(idx);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
