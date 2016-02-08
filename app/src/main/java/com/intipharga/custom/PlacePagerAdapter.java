package com.intipharga.custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.intipharga.fragment.HomePagerItemFragment;
import com.intipharga.fragment.MenuFragment;
import com.intipharga.model.HomePagerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/8/16.
 */
public class PlacePagerAdapter extends FragmentPagerAdapter {

    private AppCompatActivity activity;
    private MenuFragment menuFragment;
    private MenuFragment fragment2;

    public PlacePagerAdapter(AppCompatActivity activity){
        super(activity.getSupportFragmentManager());
        this.activity = activity;
        init();
    }

    public void init(){
        menuFragment = MenuFragment.newInstance(activity);
        fragment2 = MenuFragment.newInstance(activity);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Menu";
        }else if(position == 1){
            return "Information";
        }
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return menuFragment;
        }else if(position == 1){
            return fragment2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
