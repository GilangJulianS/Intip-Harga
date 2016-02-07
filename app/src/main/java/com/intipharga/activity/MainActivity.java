package com.intipharga.activity;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String KEY_PARENT = "isParentView";
    public static final String KEY_FRAGMENT = "fragmentType";
    public static final int FRAGMENT_HOME = 100;
    public static final int FRAGMENT_MY_COLLECTION = 101;
    private ActionBarDrawerToggle toggle;
    private boolean isParentView;

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
            isParentView = true;
        }
        if(extras != null){
            isParentView = extras.getBoolean(KEY_PARENT, false);
            int fragmentType = extras.getInt(KEY_FRAGMENT, FRAGMENT_HOME);
            FragmentManager manager = getSupportFragmentManager();
            if(fragmentType == FRAGMENT_HOME){
                manager.beginTransaction().replace(R.id.container, HomeFragment.newInstance(this)).commit();
            }else if(fragmentType == FRAGMENT_MY_COLLECTION){
                manager.beginTransaction().replace(R.id.container, MyCollectionsFragment.newInstance(this)).commit();
            }
        }else {
            isParentView = true;
            getSupportFragmentManager().beginTransaction().replace(R.id.container, HomeFragment.newInstance(this)).commit();
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
                startActivity(intent);
                break;
        }

        return true;
    }
}
