package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.intipharga.activity.R;
import com.intipharga.model.Photos;
import com.intipharga.model.Review;

import org.solovyev.android.views.llm.DividerItemDecoration;

/**
 * Created by macair on 2/8/16.
 */
public class InformationFragment extends Fragment {

    private AppCompatActivity activity;
    private RecyclerView photosRecycler, reviewRecycler;
    private RecyclerAdapter photosAdapter, reviewAdapter;
    private RecyclerView.LayoutManager photosManager, reviewManager;
    private ImageButton btnToggleDetail;
    private ViewGroup containerInformation;
    private OnStateChangeListener callback;

    public InformationFragment(){}

    public static InformationFragment newInstance(AppCompatActivity activity){
        InformationFragment fragment = new InformationFragment();
        fragment.activity = activity;
        return fragment;
    }

    public void setOnStateChangeListener(OnStateChangeListener listener){
        callback = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_information, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        photosRecycler = (RecyclerView) v.findViewById(R.id.recycler_photos);
        reviewRecycler = (RecyclerView) v.findViewById(R.id.recycler_reviews);
        btnToggleDetail = (ImageButton) v.findViewById(R.id.btn_toggle_detail);
        containerInformation = (ViewGroup) v.findViewById(R.id.container_information);
    }

    public void setupViews(){
        photosAdapter = new RecyclerAdapter(activity);
        photosManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        reviewAdapter = new RecyclerAdapter(activity);
        reviewManager = new org.solovyev.android.views.llm.LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);

        addDummyData();

        photosRecycler.setLayoutManager(photosManager);
        photosRecycler.setAdapter(photosAdapter);
        reviewRecycler.setLayoutManager(reviewManager);
        reviewRecycler.addItemDecoration(new DividerItemDecoration(activity, null));
        reviewRecycler.setAdapter(reviewAdapter);

        btnToggleDetail.setOnClickListener(new View.OnClickListener() {
            private boolean isExpanded = false;

            @Override
            public void onClick(View v) {
                if(callback != null) {
                    callback.onStateChange();
                }
                if(!isExpanded){
                    containerInformation.setVisibility(View.VISIBLE);
                    btnToggleDetail.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    isExpanded = true;
                }else{
                    containerInformation.setVisibility(View.GONE);
                    btnToggleDetail.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    isExpanded = false;
                }
            }
        });
    }

    public void addDummyData(){
        photosAdapter.add(new Photos(R.drawable.product1));
        photosAdapter.add(new Photos(R.drawable.product2));
        photosAdapter.add(new Photos(R.drawable.product3));
        photosAdapter.add(new Photos(R.drawable.product4));
        photosAdapter.add(new Photos(R.drawable.product1));
        photosAdapter.add(new Photos(R.drawable.product2));
        photosAdapter.add(new Photos(R.drawable.product3));
        photosAdapter.add(new Photos(R.drawable.product4));

        int img = R.drawable.user;
        reviewAdapter.add(new Review(img, "Vriske R.", 4.5f, true, 1450, 254, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        reviewAdapter.add(new Review(img, "Vriske R.", 3.5f, false, 1450, 254, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        reviewAdapter.add(new Review(img, "Vriske R.", 5f, true, 1450, 254, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        reviewAdapter.add(new Review(img, "Vriske R.", 3.8f, true, 1450, 254, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        reviewAdapter.add(new Review(img, "Vriske R.", 2.5f, false, 1450, 254, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        reviewAdapter.add(new Review(img, "Vriske R.", 1.5f, true, 1450, 254, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
    }

    public interface OnStateChangeListener{

        public abstract void onStateChange();

    }
}
