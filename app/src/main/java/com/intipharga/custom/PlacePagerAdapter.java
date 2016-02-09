package com.intipharga.custom;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.intipharga.fragment.HomePagerItemFragment;
import com.intipharga.fragment.InformationFragment;
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
    private InformationFragment informationFragment;
    private ViewPager pager;

    public PlacePagerAdapter(AppCompatActivity activity, ViewPager pager){
        super(activity.getSupportFragmentManager());
        this.activity = activity;
        this.pager = pager;
        init();
    }

    public void init(){
        menuFragment = MenuFragment.newInstance(activity);
        informationFragment = InformationFragment.newInstance(activity);
        informationFragment.setOnStateChangeListener(new InformationFragment.OnStateChangeListener() {
            @Override
            public void onStateChange() {
                if(pager instanceof CustomViewPager) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            ((CustomViewPager) pager).update();
                        }
                    };
                    new Handler().postDelayed(r, 100);
                    new Handler().postDelayed(r, 300);
                    new Handler().postDelayed(r, 500);
                }
            }
        });
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
            return informationFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
