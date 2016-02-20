package com.intipharga.fragment;

import android.support.v7.app.AppCompatActivity;

import com.gilang.recyclerviewframework.DataModel;
import com.gilang.recyclerviewframework.RecyclerFragment;
import com.intipharga.activity.R;
import com.intipharga.model.MessageThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macair on 2/20/16.
 */
public class MessageThreadFragment extends RecyclerFragment {

    public MessageThreadFragment(){}

    public static MessageThreadFragment newInstance(AppCompatActivity activity){
        MessageThreadFragment fragment = new MessageThreadFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public List<DataModel> getDatas() {
        List<DataModel> datas = new ArrayList<>();
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift Destra Bintang Perkasa sent a gift Destra Bintang Perkasa sent a gift Destra Bintang Perkasa sent a gift Destra Bintang Perkasa sent a gift Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));
        datas.add(new MessageThread(R.drawable.user, 2, "Destra Bintang Perkasa", "Destra Bintang Perkasa sent a gift", "08.00"));

        return datas;
    }
}
