package com.intipharga.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;
import com.intipharga.custom.HomePagerAdapter;
import com.intipharga.model.CollectionItem;
import com.intipharga.model.HomePagerItem;
import com.intipharga.model.Promo;
import com.intipharga.model.Review;
import com.viewpagerindicator.CirclePageIndicator;

import org.solovyev.android.views.llm.DividerItemDecoration;
import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/6/16.
 */
public class HomeFragment extends Fragment {

    private AppCompatActivity activity;
    private ViewPager pager;
    private HomePagerAdapter pagerAdapter;
    private CirclePageIndicator indicator;
    private ScrollView scrollView;
    private Button btnQuickSearch1, btnQuickSearch2, btnQuickSearch3, btnQuickSearch4;
    private Button btnBrowseAll;
    private ViewGroup collectionsContainer;
    private List<CollectionItem> datas;

    public HomeFragment(){}

    public static HomeFragment newInstance(AppCompatActivity activity){
        HomeFragment fragment = new HomeFragment();
        fragment.activity = activity;
        fragment.datas = new ArrayList<>();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_home, parent, false);

        bindView(v);
        setupView();

        return v;
    }

    public void bindView(View v){
        pager = (ViewPager) v.findViewById(R.id.view_pager);
        indicator = (CirclePageIndicator) v.findViewById(R.id.page_indicator);
        btnQuickSearch1 = (Button) v.findViewById(R.id.btn_quick_search_1);
        btnQuickSearch2 = (Button) v.findViewById(R.id.btn_quick_search_2);
        btnQuickSearch3 = (Button) v.findViewById(R.id.btn_quick_search_3);
        btnQuickSearch4 = (Button) v.findViewById(R.id.btn_quick_search_4);
        collectionsContainer = (ViewGroup) v.findViewById(R.id.collections_container);
        btnBrowseAll = (Button) v.findViewById(R.id.btn_browse_all);
        scrollView = (ScrollView) v.findViewById(R.id.scroll_view);
    }

    public void setupView(){
        addDummyData();
        LayoutInflater inflater = activity.getLayoutInflater();
        for(CollectionItem item : datas){
            final CollectionItem temp = item;
            View v = inflater.inflate(R.layout.card_collection_item, collectionsContainer, false);
            ImageView img = (ImageView) v.findViewById(R.id.img);
            final TextView txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
            TextView txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);
            ViewGroup card = (ViewGroup) v.findViewById(R.id.card_view);

            img.setImageResource(item.imgRes);
            txtPrimary.setText(item.txtPrimary);
            txtSecondary.setText(item.jumlah + " Tempat");

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = MainActivity.newIntent(activity, txtPrimary.getText().toString(), MainActivity.FRAGMENT_PLACE_LIST);
                    i.putExtra(MainActivity.KEY_MODE, PlaceListFragment.MODE_OWN);
                    activity.startActivity(i);
                }
            });

            collectionsContainer.addView(v);
        }


        setupViewPager();

        btnQuickSearch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, "Restaurants", MainActivity.FRAGMENT_PLACE_LIST));
            }
        });

        btnQuickSearch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, "Salon & Spa", MainActivity.FRAGMENT_PLACE_LIST));
            }
        });

        btnQuickSearch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, "Klinik", MainActivity.FRAGMENT_PLACE_LIST));
            }
        });

        btnQuickSearch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, "Lainnya", MainActivity.FRAGMENT_PLACE_LIST));
            }
        });

        btnBrowseAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, "My Collections", MainActivity.FRAGMENT_MY_COLLECTION));
            }
        });


    }

    public void setupViewPager(){
        pagerAdapter = new HomePagerAdapter(activity);

        getPagerItem();

        pager.setAdapter(pagerAdapter);
        indicator.setViewPager(pager);
        pager.invalidate();
    }

    public void getPagerItem(){
        // dummy
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak1?", "Lihat jadwal yang sesuai1", "Klik di sini1"));
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak2?", "Lihat jadwal yang sesuai2", "Klik di sini2"));
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak3?", "Lihat jadwal yang sesuai3", "Klik di sini3"));
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak4?", "Lihat jadwal yang sesuai4", "Klik di sini4"));
    }

    public void addDummyData(){
        // dummy
        int type = CollectionItem.TYPE_SELECT_TO_DETAIL_OWN;
        if(datas == null)
            datas = new ArrayList<>();
        else
            datas.clear();
        datas.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12, type));
        datas.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1, type));
        datas.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5, type));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AppCompatActivity)
            activity = (AppCompatActivity) context;
    }
}
