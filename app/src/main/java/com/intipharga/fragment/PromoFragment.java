package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.gilang.recyclerviewframework.RecyclerFragment;
import com.intipharga.activity.R;
import com.intipharga.model.Promo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/11/16.
 */
public class PromoFragment extends RecyclerFragment {

    private AppCompatActivity activity;
    private Spinner spinnerFilter;

    public PromoFragment(){}

    public static PromoFragment newInstance(AppCompatActivity activity){
        PromoFragment fragment = new PromoFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreateView(View v, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(v, parent, savedInstanceState);

        RecyclerViewHeader header = RecyclerViewHeader.fromXml(activity, R.layout.header_promo_list);
        bindHeader(header);

        header.attachTo(recyclerView);
    }

    public void bindHeader(View v){
        spinnerFilter = (Spinner) v.findViewById(R.id.spinner_filter);

        String[] items = {"View All", "Popular", "New"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerFilter.setAdapter(spinnerAdapter);
    }

    @Override
    public List<DataModel> getDatas() {
        List<DataModel> datas = new ArrayList<>();

        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));
        datas.add(new Promo(R.drawable.zengarden, "Sowe Restaurant & Lounge", R.drawable.steak, "Dapatkan discount up to 40% untuk menu-menu tertentu di Sowe Resto & Lounge\n\nSowe Resto & Lounge menyediakan live band akustik di Jumat & Sabtu dari jam 8 sampai selesai dan free karaoke setiap hari kamis mulai jam 9."));

        return datas;
    }
}
