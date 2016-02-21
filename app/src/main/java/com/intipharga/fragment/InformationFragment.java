package com.intipharga.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.intipharga.activity.R;
import com.intipharga.model.Photos;
import com.intipharga.model.Review;

import org.solovyev.android.views.llm.DividerItemDecoration;

/**
 * Created by macair on 2/8/16.
 */
public class InformationFragment extends Fragment implements OnMapReadyCallback {

    private static final int REQUEST_CAMERA = 1;
    private AppCompatActivity activity;
    private RecyclerView photosRecycler, reviewRecycler;
    private RecyclerAdapter photosAdapter, reviewAdapter;
    private RecyclerView.LayoutManager photosManager, reviewManager;
    private ImageButton btnAddPhoto, btnWriteReview, btnCheckIn;
    private ViewGroup containerInformation, groupToggleReview, groupToggleDetail;
    private OnStateChangeListener callback;
    private TextView txtMoreReview;
    private ImageView imgToggleReview, imgToggleDetail;
    private GoogleMap mMap;

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
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return v;
    }

    public void bindViews(View v){
        photosRecycler = (RecyclerView) v.findViewById(R.id.recycler_photos);
        reviewRecycler = (RecyclerView) v.findViewById(R.id.recycler_reviews);
        imgToggleDetail = (ImageView) v.findViewById(R.id.btn_toggle_detail);
        containerInformation = (ViewGroup) v.findViewById(R.id.container_information);
        groupToggleReview = (ViewGroup) v.findViewById(R.id.group_toggle_review);
        groupToggleDetail = (ViewGroup) v.findViewById(R.id.group_toggle_detail);
        txtMoreReview = (TextView) v.findViewById(R.id.txt_more_reviews);
        imgToggleReview = (ImageView) v.findViewById(R.id.btn_toggle_reviews);
        btnAddPhoto = (ImageButton) v.findViewById(R.id.btn_add_photo);
        btnWriteReview = (ImageButton) v.findViewById(R.id.btn_write_review);
        btnCheckIn = (ImageButton) v.findViewById(R.id.btn_check_in);
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
        reviewRecycler.setNestedScrollingEnabled(false);

        groupToggleDetail.setOnClickListener(new View.OnClickListener() {
            private boolean isExpanded = false;

            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onStateChange();
                }
                if (!isExpanded) {
                    containerInformation.setVisibility(View.VISIBLE);
                    imgToggleDetail.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    isExpanded = true;
                } else {
                    containerInformation.setVisibility(View.GONE);
                    imgToggleDetail.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    isExpanded = false;
                }
            }
        });

        groupToggleReview.setOnClickListener(new View.OnClickListener() {
            boolean isExpanded = false;

            @Override
            public void onClick(View v) {
                if(isExpanded){
                    isExpanded = false;
                    txtMoreReview.setText("More Review");
                    imgToggleReview.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    reviewAdapter.setShowLimit(2);
                }else{
                    isExpanded = true;
                    txtMoreReview.setText("Less Review");
                    imgToggleReview.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    reviewAdapter.setShowLimit(-1);
                }
                if (callback != null) {
                    callback.onStateChange();
                }
            }
        });

        btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(activity.getPackageManager()) != null){
                    startActivityForResult(intent, REQUEST_CAMERA);
                }
            }
        });

        btnWriteReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Write Review clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Check in clicked", Toast.LENGTH_SHORT).show();
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
        reviewAdapter.setShowLimit(2);
    }

    public interface OnStateChangeListener{

        public abstract void onStateChange();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CAMERA && resultCode == activity.RESULT_OK){
            Bundle extras = data.getExtras();
            // photo taken
            Bitmap imageBitmap = (Bitmap) extras.get("data");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
