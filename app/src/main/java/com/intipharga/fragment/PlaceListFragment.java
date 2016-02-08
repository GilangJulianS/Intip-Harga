package com.intipharga.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerFragment;
import com.intipharga.activity.R;
import com.intipharga.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/8/16.
 */
public class PlaceListFragment extends RecyclerFragment {

    private AppCompatActivity activity;

    public PlaceListFragment(){}

    public static PlaceListFragment newInstance(AppCompatActivity activity){
        PlaceListFragment fragment = new PlaceListFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreateView(View v, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(v, parent, savedInstanceState);
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(activity, R.layout.header_place_list);

        bindHeader(header);

        header.attachTo(recyclerView);

    }

    public void bindHeader(View v){
        Spinner sortSpinner = (Spinner) v.findViewById(R.id.spinner_sort);
        Spinner categoriesSpinner = (Spinner) v.findViewById(R.id.spinner_categories);

        String[] sortList = {"Distance", "Rating", "Popularity"};
        String[] categoriesList = {"All", "Beverages", "Snacks", "Lunch", "Dinner"};

        ArrayAdapter<String> sortAdapter = new ArrayAdapter<String>(activity, R.layout.spinner_dropdown, R.id.textView, sortList);
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(activity, R.layout.spinner_dropdown, R.id.textView, categoriesList);

        sortSpinner.setAdapter(sortAdapter);
        categoriesSpinner.setAdapter(categoriesAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Override
    public List<DataModel> getDatas() {
        List<DataModel> datas = new ArrayList<>();

        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));
        datas.add(new Place(R.drawable.tiptop, "Tip Top Restaurant", 4.5f, 78, "Jl. K. L. Yos Sudarso No. 92 A-B, Kota Medan, Sumatera Utara 20111"));

        return datas;
    }
}
