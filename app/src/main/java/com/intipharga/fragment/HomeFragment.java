package com.intipharga.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;
import com.intipharga.custom.HomePagerAdapter;
import com.intipharga.model.CollectionItem;
import com.intipharga.model.HomePagerItem;
import com.viewpagerindicator.CirclePageIndicator;

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
    private Button btnQuickSearch1, btnQuickSearch2, btnQuickSearch3, btnQuickSearch4;
    private Button btnBrowseAll;
    private ViewGroup collectionsContainer;
    private List<CollectionItem> collections;

    public HomeFragment(){}

    public static HomeFragment newInstance(AppCompatActivity activity){
        HomeFragment fragment = new HomeFragment();
        fragment.activity = activity;
        fragment.collections = new ArrayList<>();
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
        btnQuickSearch1 = (Button) v.findViewById(R.id.btn_quick_search_1);
        btnQuickSearch2 = (Button) v.findViewById(R.id.btn_quick_search_2);
        btnQuickSearch3 = (Button) v.findViewById(R.id.btn_quick_search_3);
        btnQuickSearch4 = (Button) v.findViewById(R.id.btn_quick_search_4);
        collectionsContainer = (ViewGroup) v.findViewById(R.id.collections_container);
        btnBrowseAll = (Button) v.findViewById(R.id.btn_browse_all);
    }

    public void setupView(View v){
        setupViewPager();
        setupCollections();

        btnBrowseAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MainActivity.class);
                intent.putExtra(MainActivity.KEY_FRAGMENT, MainActivity.FRAGMENT_MY_COLLECTION);
                activity.startActivity(intent);
            }
        });
    }

    public void setupViewPager(){
        pagerAdapter = new HomePagerAdapter(activity);

        addDummyPager();

        pager.setAdapter(pagerAdapter);
        indicator.setViewPager(pager);
        pager.invalidate();
    }

    public void setupCollections(){
        addDummyCollections();
        LayoutInflater inflater = activity.getLayoutInflater();
        for(CollectionItem item : collections){
            View v = inflater.inflate(R.layout.card_collection_item, collectionsContainer, false);
            ImageView img = (ImageView) v.findViewById(R.id.img);
            TextView txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
            TextView txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);

            img.setImageResource(item.imgRes);
            txtPrimary.setText(item.txtPrimary);
            txtSecondary.setText(item.jumlah + " Tempat");
            collectionsContainer.addView(v);
        }
    }

    public void addDummyPager(){
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak1?", "Lihat jadwal yang sesuai1", "Klik di sini1"));
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak2?", "Lihat jadwal yang sesuai2", "Klik di sini2"));
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak3?", "Lihat jadwal yang sesuai3", "Klik di sini3"));
        pagerAdapter.add(new HomePagerItem("", "", "Kursus Masak4?", "Lihat jadwal yang sesuai4", "Klik di sini4"));
    }

    public void addDummyCollections(){
        collections.clear();
        collections.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12));
        collections.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1));
        collections.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }
}
