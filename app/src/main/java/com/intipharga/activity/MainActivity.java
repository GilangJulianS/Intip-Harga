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

import com.intipharga.fragment.HomeFragment;
import com.intipharga.fragment.MyCollectionsFragment;
import com.intipharga.fragment.PlaceFragment;
import com.intipharga.fragment.PlaceListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String KEY_PARENT = "isParentView";
    public static final String KEY_FRAGMENT = "fragmentType";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MENU_ID = "menuId";
    public static final int FRAGMENT_HOME = 100;
    public static final int FRAGMENT_MY_COLLECTION = 101;
    public static final int FRAGMENT_PLACE_LIST = 102;
    public static final int FRAGMENT_PLACE = 103;
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
                manager.beginTransaction().replace(R.id.container, PlaceListFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_PLACE){
                manager.beginTransaction().replace(R.id.container, PlaceFragment.newInstance(this)).commit();
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
        return intent;
    }
}
