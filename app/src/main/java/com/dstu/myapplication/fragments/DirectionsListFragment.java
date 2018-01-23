package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.adapters.DirectionsListAdapter;
import com.dstu.myapplication.dstu.ConfigRetrofit;
import com.dstu.myapplication.dstu.Requests;
import com.dstu.myapplication.models.Specialty;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class DirectionsListFragment extends Fragment implements Callback<Specialty.Array> {

    ListView recyclerView;
    DirectionsListAdapter directionsListAdapter;
    int id;


    public DirectionsListFragment(int a)
    {
        this.id=a;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (ListView) view.findViewById(R.id.rv);
        getActivity().setTitle("Направления");

        Requests requests = ConfigRetrofit.getRetrofit().create(Requests.class);
        requests.getSpecialties(id).enqueue(this);

        return view;
    }

    @Override
    public void onResponse(Response<Specialty.Array> response, Retrofit retrofit) {
        directionsListAdapter = new DirectionsListAdapter(this.getContext(), response.body().getArray());
        recyclerView.setAdapter(directionsListAdapter);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
