package com.intipharga.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;
import com.intipharga.custom.PlacePagerAdapter;
import com.intipharga.model.CollectionItem;

/**
 * Created by macair on 2/8/16.
 */
public class PlaceFragment extends Fragment {

    public static final int TYPE_RESTAURANT = 100;
    public static final int TYPE_OTHER = 101;
    private AppCompatActivity activity;
    private PlacePagerAdapter adapter;
    private ViewPager viewPager;
    private PagerSlidingTabStrip pagertab;
    private Button btnAdd, btnCall;
    private AlertDialog dialog;
    private RatingBar ratingBar;
    private TextView txtNama, txtReviewCount, txtAddress, txtPhone, txtStatus;

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

        if(getType() == TYPE_OTHER)
            hideTab();

        return v;
    }

    public void bindViews(View v){
        pagertab = (PagerSlidingTabStrip) v.findViewById(R.id.pagertab);
        viewPager = (ViewPager) v.findViewById(R.id.view_pager);
        btnAdd = (Button) v.findViewById(R.id.btn_add);
        btnCall = (Button) v.findViewById(R.id.btn_call);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingbar);
        txtNama = (TextView) v.findViewById(R.id.txt_nama);
        txtAddress = (TextView) v.findViewById(R.id.txt_alamat);
        txtReviewCount = (TextView) v.findViewById(R.id.txt_review_counter);
        txtPhone = (TextView) v.findViewById(R.id.txt_telpon);
        txtStatus = (TextView) v.findViewById(R.id.txt_status);
    }

    public void setupViews(){

        adapter = new PlacePagerAdapter(activity, viewPager);

        viewPager.setAdapter(adapter);

        pagertab.setShouldExpand(true);
        pagertab.setIndicatorColor(ContextCompat.getColor(activity, R.color.background_container));
        pagertab.setUnderlineHeight(0);

        pagertab.setViewPager(viewPager);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                LayoutInflater inflater = activity.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_add_to_collection, null);
                Button btnMakeNew = (Button) dialogView.findViewById(R.id.btn_make_new);
                RecyclerView recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler_view);
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(activity);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);

                int type = CollectionItem.TYPE_SELECT_TO_ADD;
                recyclerAdapter.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12, type));
                recyclerAdapter.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1, type));
                recyclerAdapter.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5, type));
                recyclerAdapter.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12, type));
                recyclerAdapter.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1, type));
                recyclerAdapter.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5, type));

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(recyclerAdapter);

                btnMakeNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(activity, "Make New Button Clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                builder.setView(dialogView);
                dialog = builder.create();
                dialog.show();
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+6283824455975"));
                startActivity(intent);
            }
        });


        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(activity, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);

    }

    public void hideTab(){
        pagertab.setVisibility(View.GONE);
    }

    public void setupViewPager(){

    }

    public int getType(){
        // return TYPE_OTHER buat ngilangin tab
        // return TYPE_RESTAURANT buat munculin tab
        return TYPE_RESTAURANT;
    }

}
