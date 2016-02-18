package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilang.recyclerviewframework.RecyclerAdapter;
import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;
import com.intipharga.model.CollectionItem;
import com.intipharga.model.Review;

import org.solovyev.android.views.llm.DividerItemDecoration;
import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/10/16.
 */
public class ProfileFragment extends Fragment {

    private AppCompatActivity activity;
    private ImageView imgUser, imgCover, imgToggleReview;
    private TextView txtNama, txtMVP, txtUserFollowerCount, txtUserReviewCount, txtMoreReview;
    private Button btnFollow, btnMessage, btnMore;
    private ViewGroup collectionContainer, groupToggleReview;
    private RecyclerView recyclerReview;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<CollectionItem> items;

    public ProfileFragment(){}

    public static ProfileFragment newInstance(AppCompatActivity activity){
        ProfileFragment fragment = new ProfileFragment();
        fragment.activity = activity;
        fragment.items = new ArrayList<>();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_profile, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        imgUser = (ImageView) v.findViewById(R.id.img_user);
        imgUser = (ImageView) v.findViewById(R.id.img_cover);
        imgToggleReview = (ImageView) v.findViewById(R.id.btn_toggle_reviews);
        txtNama = (TextView) v.findViewById(R.id.txt_nama);
        txtMVP = (TextView) v.findViewById(R.id.txt_mvp);
        txtUserFollowerCount = (TextView) v.findViewById(R.id.txt_user_follower_count);
        txtUserReviewCount = (TextView) v.findViewById(R.id.txt_user_review_count);
        txtMoreReview = (TextView) v.findViewById(R.id.txt_more_reviews);
        btnFollow = (Button) v.findViewById(R.id.btn_follow);
        btnMessage = (Button) v.findViewById(R.id.btn_message);
        btnMore = (Button) v.findViewById(R.id.btn_more);
        collectionContainer = (ViewGroup) v.findViewById(R.id.collections_container);
        groupToggleReview = (ViewGroup) v.findViewById(R.id.group_toggle_review);
        recyclerReview = (RecyclerView) v.findViewById(R.id.recycler_reviews);
    }

    public void setupViews(){
        recyclerAdapter = new RecyclerAdapter(activity);
        recyclerAdapter.setShowLimit(2);

        addDummyData();

        layoutManager = new LinearLayoutManager(activity, android.support.v7.widget.LinearLayoutManager.VERTICAL, false);
        recyclerReview.setLayoutManager(layoutManager);
        recyclerReview.addItemDecoration(new DividerItemDecoration(activity, null));
        recyclerReview.setAdapter(recyclerAdapter);
        
        LayoutInflater inflater = activity.getLayoutInflater();
        for(CollectionItem item : items){
            final CollectionItem temp = item;
            View v = inflater.inflate(R.layout.card_collection_item, collectionContainer, false);
            ImageView img = (ImageView) v.findViewById(R.id.img);
            TextView txtPrimary = (TextView) v.findViewById(R.id.txt_primary);
            TextView txtSecondary = (TextView) v.findViewById(R.id.txt_secondary);
            ViewGroup card = (ViewGroup) v.findViewById(R.id.card_view);

            img.setImageResource(item.imgRes);
            txtPrimary.setText(item.txtPrimary);
            txtSecondary.setText(item.jumlah + " Tempat");

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(MainActivity.newIntent(activity, temp.txtPrimary, MainActivity.FRAGMENT_PLACE_LIST));
                }
            });

            collectionContainer.addView(v);
        }

        groupToggleReview.setOnClickListener(new View.OnClickListener() {
            boolean isExpanded = false;

            @Override
            public void onClick(View v) {
                if(isExpanded){
                    isExpanded = false;
                    txtMoreReview.setText("More Review");
                    imgToggleReview.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    recyclerAdapter.setShowLimit(2);
                }else{
                    isExpanded = true;
                    txtMoreReview.setText("Less Review");
                    imgToggleReview.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    recyclerAdapter.setShowLimit(-1);
                }
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(MainActivity.newIntent(activity, "My Collection", MainActivity.FRAGMENT_MY_COLLECTION));
            }
        });
    }

    public void addDummyData(){
        items.clear();
        int type = CollectionItem.TYPE_SELECT_TO_DETAIL_OWN;
        items.add(new CollectionItem(R.drawable.tempat_nongkrong, "Tempat Nongkrong Favorit", 12, type));
        items.add(new CollectionItem(R.drawable.klinik_gigi, "Klinik Gigi", 1, type));
        items.add(new CollectionItem(R.drawable.spa_murah, "Spa Murah", 5, type));
        items.add(new CollectionItem(R.drawable.spa_murah, "Bookmarks", 3, type));

        recyclerAdapter.add(new Review(R.drawable.tiptop, "Tip Top", 4.5f, false, 1000, 100, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        recyclerAdapter.add(new Review(R.drawable.tiptop, "Tip Top", 4.5f, false, 1000, 100, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        recyclerAdapter.add(new Review(R.drawable.tiptop, "Tip Top", 4.5f, false, 1000, 100, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        recyclerAdapter.add(new Review(R.drawable.tiptop, "Tip Top", 4.5f, false, 1000, 100, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        recyclerAdapter.add(new Review(R.drawable.tiptop, "Tip Top", 4.5f, false, 1000, 100, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
        recyclerAdapter.add(new Review(R.drawable.tiptop, "Tip Top", 4.5f, false, 1000, 100, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"));
    }
}
