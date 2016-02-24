package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
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

    private FloatingActionButton fabAdd;

    public MessageThreadFragment(){}

    public static MessageThreadFragment newInstance(AppCompatActivity activity){
        MessageThreadFragment fragment = new MessageThreadFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreateView(View v, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(v, parent, savedInstanceState);

        ViewGroup fabContainer = (ViewGroup) activity.findViewById(R.id.fab_container);
        View fab = activity.getLayoutInflater().inflate(R.layout.fab_message_thread, parent, false);
        fabAdd = (FloatingActionButton) fab.findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "FAB Add clicked", Toast.LENGTH_SHORT).show();
            }
        });

        fabContainer.removeAllViews();
        fabContainer.addView(fab);
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
