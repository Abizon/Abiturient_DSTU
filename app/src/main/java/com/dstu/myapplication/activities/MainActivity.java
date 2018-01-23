package com.dstu.myapplication.activities;

import android.content.Intent;
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
import android.view.View;
import android.widget.Toast;

import com.dstu.myapplication.R;
import com.dstu.myapplication.fragments.FacultieListFragment;
import com.dstu.myapplication.fragments.EventFragment;
import com.dstu.myapplication.fragments.FeedbackFragment;
import com.dstu.myapplication.fragments.NewsListFragment;
import com.dstu.myapplication.fragments.ProfileEditFragment;
import com.dstu.myapplication.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentTransaction ft;
    Menu menu_main;

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
        getMenuInflater().inflate(R.menu.main, menu);
        menu_main=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        fragmentSelector(item.getItemId());
        return true;
    }

    public void fragmentSelector(int id){
        Fragment fragment = new NewsListFragment();
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
                menu_main.getItem(1).setVisible(false);
                menu_main.getItem(6).setVisible(true);
                fragment = new ProfileFragment();

            break;
            case R.id.nav_portfolio:
                fragment = new ProfileFragment();
                break;
            case R.id.nav_news:
                fragment = new NewsListFragment();
            break;
            case R.id.nav_directions:
                fragment = new FacultieListFragment();
            break;
            case R.id.nav_ivent:
                fragment = new EventFragment();
                menu_main.getItem(1).setVisible(false);
                break;
            case R.id.nav_feedback:
                fragment = new FeedbackFragment();
                break;
            case R.id.nav_signup:
                startActivity(new Intent(MainActivity.this, PhoneAuthActivity.class));
                finish();
                break;
            case R.id.edit:
                startActivity(new Intent(MainActivity.this,ProfileEditActivity.class));
                menu_main.getItem(6).setVisible(false);
                menu_main.getItem(5).setVisible(true);
                break;
            case R.id.save:
                menu_main.getItem(5).setVisible(false);
                menu_main.getItem(6).setVisible(true);
                break;
        }
        ft.replace(R.id.fragment_container,fragment);
        ft.addToBackStack("MyStack");
        ft.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        fragmentSelector(item.getItemId());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
