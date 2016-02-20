package com.intipharga.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.intipharga.fragment.BugReportFragment;
import com.intipharga.fragment.FeedFragment;
import com.intipharga.fragment.FriendListFragment;
import com.intipharga.fragment.HomeFragment;
import com.intipharga.fragment.MessageFragment;
import com.intipharga.fragment.MessageThreadFragment;
import com.intipharga.fragment.MyCollectionsFragment;
import com.intipharga.fragment.PlaceFragment;
import com.intipharga.fragment.PlaceListFragment;
import com.intipharga.fragment.ProfileFragment;
import com.intipharga.fragment.PromoFragment;
import com.intipharga.fragment.SettingsFragment;
import com.intipharga.fragment.TermConditionFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String KEY_PARENT = "isParentView";
    public static final String KEY_FRAGMENT = "fragmentType";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MENU_ID = "menuId";
    public static final String KEY_MODE = "mode";
    public static final int FRAGMENT_HOME = 100;
    public static final int FRAGMENT_MY_COLLECTION = 101;
    public static final int FRAGMENT_PLACE_LIST = 102;
    public static final int FRAGMENT_PLACE = 103;
    public static final int FRAGMENT_PROFILE = 104;
    public static final int FRAGMENT_SETTINGS = 105;
    public static final int FRAGMENT_BUG_REPORT = 106;
    public static final int FRAGMENT_TERM_CONDITION = 107;
    public static final int FRAGMENT_PROMO = 108;
    public static final int FRAGMENT_FRIENDS = 109;
    public static final int FRAGMENT_MESSAGE_THREAD = 110;
    public static final int FRAGMENT_MESSAGE = 111;
    public static final int FRAGMENT_TIMELINE = 112;
    private ActionBarDrawerToggle toggle;
    private boolean isParentView;
    private String title;
    private int menuId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent caller = getIntent();
        Bundle extras = null;
        if(caller != null) {
            extras = caller.getExtras();
        }else{
            isParentView = true;
        }
        if(extras != null){

            isParentView = extras.getBoolean(KEY_PARENT, true);
            int fragmentType = extras.getInt(KEY_FRAGMENT, FRAGMENT_HOME);
            title = extras.getString(KEY_TITLE, "Intip Harga");
            menuId = extras.getInt(KEY_MENU_ID, 0);

            getSupportActionBar().setTitle(title);
            navigationView.getMenu().getItem(menuId).setChecked(true);

            FragmentManager manager = getSupportFragmentManager();
            if(fragmentType == FRAGMENT_HOME){
                manager.beginTransaction().replace(R.id.container, HomeFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_MY_COLLECTION){
                manager.beginTransaction().replace(R.id.container, MyCollectionsFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_PLACE_LIST){
                int mode = extras.getInt(KEY_MODE, PlaceListFragment.MODE_OTHER);
                manager.beginTransaction().replace(R.id.container, PlaceListFragment.newInstance(this, mode)).commit();
            }else if(fragmentType == FRAGMENT_PLACE){
                manager.beginTransaction().replace(R.id.container, PlaceFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_PROFILE){
                manager.beginTransaction().replace(R.id.container, ProfileFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_SETTINGS){
                getFragmentManager().beginTransaction().replace(R.id.container, SettingsFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_BUG_REPORT){
                manager.beginTransaction().replace(R.id.container, BugReportFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_TERM_CONDITION){
                manager.beginTransaction().replace(R.id.container, TermConditionFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_PROMO){
                manager.beginTransaction().replace(R.id.container, PromoFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_FRIENDS){
                manager.beginTransaction().replace(R.id.container, FriendListFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_MESSAGE_THREAD){
                manager.beginTransaction().replace(R.id.container, MessageThreadFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_MESSAGE){
                manager.beginTransaction().replace(R.id.container, MessageFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_TIMELINE){
                manager.beginTransaction().replace(R.id.container, FeedFragment.newInstance(this)).commit();
            }
        }else {
            getSupportActionBar().setTitle("Intip Harga");
            isParentView = true;
            getSupportFragmentManager().beginTransaction().replace(R.id.container, HomeFragment.newInstance(this)).commit();
            navigationView.getMenu().getItem(menuId).setChecked(true);
        }

        if(isParentView){
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();
        }else{
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            toggle = new ActionBarDrawerToggle(
                    this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(isParentView){
            super.onBackPressed();
        }else{
            supportFinishAfterTransition();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case android.R.id.home:
                if(!isParentView) {
                    onBackPressed();
                    return true;
                }
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(KEY_PARENT, true);
        switch (id){
            case R.id.nav_home:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_HOME);
                intent.putExtra(KEY_MENU_ID, 0);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_PROFILE);
                intent.putExtra(KEY_MENU_ID, 1);
                intent.putExtra(KEY_TITLE, "My Profile");
                startActivity(intent);
                break;
            case R.id.nav_message:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_MESSAGE_THREAD);
                intent.putExtra(KEY_MENU_ID, 2);
                intent.putExtra(KEY_TITLE, "Messages");
                startActivity(intent);
                break;
            case R.id.nav_friends:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_FRIENDS);
                intent.putExtra(KEY_MENU_ID, 3);
                intent.putExtra(KEY_TITLE, "My Friends");
                startActivity(intent);
                break;
            case R.id.nav_timeline:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_TIMELINE);
                intent.putExtra(KEY_MENU_ID, 4);
                intent.putExtra(KEY_TITLE, "Timeline");
                startActivity(intent);
                break;
            case R.id.nav_settings:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_SETTINGS);
                intent.putExtra(KEY_MENU_ID, 5);
                intent.putExtra(KEY_TITLE, "Settings");
                startActivity(intent);
                break;
            case R.id.nav_promo:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_PROMO);
                intent.putExtra(KEY_MENU_ID, 6);
                intent.putExtra(KEY_TITLE, "Promo");
                startActivity(intent);
                break;
            case R.id.nav_collections:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_MY_COLLECTION);
                intent.putExtra(KEY_MENU_ID, 7);
                intent.putExtra(KEY_TITLE, "My Collections");
                startActivity(intent);
                break;
            case R.id.nav_report_bug:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_BUG_REPORT);
                intent.putExtra(KEY_MENU_ID, 10);
                intent.putExtra(KEY_TITLE, "Report Bug");
                startActivity(intent);
                break;
            case R.id.nav_terms_conditions:
                intent.putExtra(KEY_FRAGMENT, FRAGMENT_TERM_CONDITION);
                intent.putExtra(KEY_MENU_ID, 11);
                startActivity(intent);
                break;
            default:
                intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
        }
        finish();
        return true;
    }

    public static Intent newIntent(Context context, @Nullable String title, int fragmentType){
        Intent intent = new Intent(context, MainActivity.class);
        if(title != null){
            intent.putExtra(KEY_TITLE, title);
            System.out.println(title);
        }
        intent.putExtra(KEY_PARENT, false);
        intent.putExtra(KEY_FRAGMENT, fragmentType);
        if(fragmentType == FRAGMENT_HOME)
            intent.putExtra(KEY_PARENT, true);
        return intent;
    }
}
