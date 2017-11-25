package com.dstu.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dstu.myapplication.Fragment1;
import com.dstu.myapplication.Fragment_main;
import com.dstu.myapplication.R;
import com.dstu.myapplication.fragments.FeedbackFragment;
import com.dstu.myapplication.fragments.EventFragment;
import com.dstu.myapplication.fragments.NewsListFragment;
import com.dstu.myapplication.fragments.TestFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //переизбыток иконок в toolbare
        //Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_settings_black_18dp);
        //toolbar.setOverflowIcon(drawable);

        fragmentSelector(0);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        fragmentSelector(item.getItemId());
        return true;
    }

    public void fragmentSelector(int id){
        Fragment fragment = new Fragment_main();
        ft = getSupportFragmentManager().beginTransaction();
        switch (id){
            case R.id.action_settings:

                break;
            case R.id.theme:

                break;
            case R.id.order:
                //
                break;
            case R.id.account:
                fragment = new Fragment1();
            break;
            case R.id.nav_news:
                fragment = new NewsListFragment();
            break;
            case R.id.nav_test:
                fragment = new TestFragment();
            break;
            case R.id.nav_ivent:
                fragment = new EventFragment();
                break;
            case R.id.nav_feedback:
                fragment = new FeedbackFragment();
                break;
        }
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        fragmentSelector(item.getItemId());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
