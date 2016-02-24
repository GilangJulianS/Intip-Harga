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

    public HomePagerAdapter(AppCompatActivity activity){
        super(activity.getSupportFragmentManager());
        this.activity = activity;
        datas = new ArrayList<>();
    }

    public void add(HomePagerItem item){
        datas.add(item);
    }

    public void remove(HomePagerItem item){
        datas.remove(item);
    }

    @Override
    public Fragment getItem(int position) {
        System.out.println("Created new fragment at position " + position);
        return HomePagerItemFragment.newInstance(activity, datas.get(position));
    }

    @Override
    public int getCount() {
        return datas.size();
    }


}
