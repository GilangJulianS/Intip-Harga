package com.intipharga.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.intipharga.activity.R;

/**
 * Created by macair on 2/8/16.
 */
public class MenuFragment extends Fragment {

    private AppCompatActivity activity;
    private TextView txtMenu;

    public MenuFragment(){}

    public static MenuFragment newInstance(AppCompatActivity activity){
        MenuFragment fragment = new MenuFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_menu, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        txtMenu = (TextView) v.findViewById(R.id.txt_menu);
    }

    public void setupViews(){
        txtMenu.setText(Html.fromHtml("<br/><br/><b>AUTHENTIC JAPANESE BEEF</b><br/><br/>Kobe Beef - IDR 550.000<br/><br/><b>U.S CERTIFIED ANGUS BEEF</b><br/>U.S Sirloin - IDR 99.000<br/>U.S Rib Eye - IDR 130.000<br/>U.S Tenderloin - IDR 109.000<br/><br/><b>WAGYU BEEF</b><br/><br/>Wagyu Sirloin Mb 9+ (200g) - IDR 260.000<br/>Wagyu Tenderloin Mb 9+ (200g) - IDR 300.000<br/>Wagyu Sirloin (200g) - IDR 125.000<br/>Wagyu Tenderloin (200g) - IDR 100.000<br/>Wagyu Rib Eye (200g) - IDR 135.000<br/>Wagyu Petite Tender (200g) - IDR 90.000<br/>Wagyu Sonar Blade (200g) - IDR 87.000<br/>Bergyu (200g) - IDR 75.000<br/>Meatballs (200g) - IDR 40.000<br/><br/><b>AUSTRALIAN PRIME BEEF</b><br/><br/>Sirloin BIG BITES! (400g) - IDR 128.000<br/>Tenderloin BIG BITES! (400g) - IDR 128.000<br/>Sirloin Young Beef (200g) - IDR 92.000<br/>Prime Sirloin (200g) - IDR 86.500<br/>Prime Tenderloin (200g) - IDR 79.000<br/>Prime Rib Eye (200g) - IDR 87.000<br/>Buddy's Special (200g) - IDR 45.000<br/><br/><b>ONLY ON MONDAY & TUESDAY</b><br/><br/>Buddy's Combo (2 Buddy's Special + 2 Drinks Coke/Fanta/Sprite/Minute Maid) - IDR 149.000<br/>Normal Price - IDR 192.000<br/><br/><b>Drinks</b><br/><br/>Ice Tea (free refill, not for sharing) - IDR 17.000<br/>Hot Tea (free refill, not for sharing) - IDR 17.000<br/>Ice/Hot Cappucino - IDR 20.000<br/>Mineral Water - IDR 10.000<br/>Soft Drinks - IDR 12.000<br/>Minute Maid - IDR 10.000<br/><br/><b>Desserts</b><br/><br/>Tiramisu - IDR 45.000<br/>Matcha, Ogura Ice Cream - IDR 23.000<br/><br/><b>Easy Bites</b><br/><br/>Herbs Wedges - IDR 17.000<br/>Add French Fries/Mashed Potatoes - IDR 10.000"));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AppCompatActivity)
            activity = (AppCompatActivity) context;
    }
}
