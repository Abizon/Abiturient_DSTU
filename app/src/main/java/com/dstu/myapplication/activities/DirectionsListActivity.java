package com.dstu.myapplication.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.adapters.DirectionsListAdapter;
import com.dstu.myapplication.dstu.ConfigRetrofit;
import com.dstu.myapplication.dstu.Requests;
import com.dstu.myapplication.models.Specialty;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class DirectionsListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Callback<Specialty.Array> {

    ListView recyclerView;
    DirectionsListAdapter directionsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar3);


        recyclerView = (ListView) findViewById(R.id.rv);

        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        String name = intent.getStringExtra("name");
        setTitle(name);
        Requests requests = ConfigRetrofit.getRetrofit().create(Requests.class);
        requests.getSpecialties(id).enqueue(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            finish();
        }
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onResponse(Call<Specialty.Array> call, Response<Specialty.Array> response) {

        directionsListAdapter = new DirectionsListAdapter(DirectionsListActivity.this, response.body().getArray());
        recyclerView.setAdapter(directionsListAdapter);
    }

    @Override
    public void onFailure(Call<Specialty.Array> call, Throwable t) {

    }
}
