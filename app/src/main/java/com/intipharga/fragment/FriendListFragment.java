package com.intipharga.fragment;

import android.support.v7.app.AppCompatActivity;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerFragment;
import com.intipharga.activity.R;
import com.intipharga.model.Friend;
import com.intipharga.model.FriendList;
import com.intipharga.model.FriendSection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/20/16.
 */
public class FriendListFragment extends RecyclerFragment {

    public FriendListFragment(){}

    public static FriendListFragment newInstance(AppCompatActivity activity){
        FriendListFragment fragment = new FriendListFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public List<DataModel> getDatas() {
        List<DataModel> datas = new ArrayList<>();
        List<Friend> friends;

        datas.add(new FriendSection("A"));
        friends = new ArrayList<>();
        friends.add(new Friend(R.drawable.user, "Anita"));
        datas.add(new FriendList(friends));

        datas.add(new FriendSection("B"));
        friends = new ArrayList<>();
        friends.add(new Friend(R.drawable.user, "Baifern"));
        datas.add(new FriendList(friends));

        datas.add(new FriendSection("D"));
        friends = new ArrayList<>();
        friends.add(new Friend(R.drawable.user, "Destra"));
        datas.add(new FriendList(friends));

        datas.add(new FriendSection("E"));
        friends = new ArrayList<>();
        friends.add(new Friend(R.drawable.user, "Erneza"));
        friends.add(new Friend(R.drawable.user, "Evelyn"));
        friends.add(new Friend(R.drawable.user, "Erneza"));
        friends.add(new Friend(R.drawable.user, "Evelyn"));
        friends.add(new Friend(R.drawable.user, "Erneza"));
        friends.add(new Friend(R.drawable.user, "Evelyn"));
        friends.add(new Friend(R.drawable.user, "Erneza"));
        friends.add(new Friend(R.drawable.user, "Evelyn"));
        friends.add(new Friend(R.drawable.user, "Erneza"));
        friends.add(new Friend(R.drawable.user, "Evelyn"));
        friends.add(new Friend(R.drawable.user, "Erneza"));
        friends.add(new Friend(R.drawable.user, "Evelyn"));
        datas.add(new FriendList(friends));

        datas.add(new FriendSection("R"));
        friends = new ArrayList<>();
        friends.add(new Friend(R.drawable.user, "Ricky"));
        datas.add(new FriendList(friends));

        datas.add(new FriendSection("W"));
        friends = new ArrayList<>();
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        friends.add(new Friend(R.drawable.user, "Windy"));
        datas.add(new FriendList(friends));

        datas.add(new FriendSection("Y"));
        friends = new ArrayList<>();
        friends.add(new Friend(R.drawable.user, "Yulisnaini"));
        friends.add(new Friend(R.drawable.user, "Yuyut"));
        datas.add(new FriendList(friends));

        return datas;
    }
}
