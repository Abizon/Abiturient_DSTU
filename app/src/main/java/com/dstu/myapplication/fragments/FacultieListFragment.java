package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.adapters.FacultieListAdapter;
import com.dstu.myapplication.dstu.ConfigRetrofit;
import com.dstu.myapplication.dstu.Requests;
import com.dstu.myapplication.models.Facultie;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class FacultieListFragment extends Fragment implements Callback<Facultie.Answer>{

    ListView recyclerView;
    FacultieListAdapter facultieListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (ListView) view.findViewById(R.id.rv);
        getActivity().setTitle("Факультеты");

        Requests requests = ConfigRetrofit.getRetrofit().create(Requests.class);
        requests.getFaculties().enqueue(this);

        return view;
    }
    @Override
    public void onResponse(Response<Facultie.Answer> response, Retrofit retrofit) {
        facultieListAdapter = new FacultieListAdapter(this.getContext(), response.body().getAnswer().get(0).getChildren());
        recyclerView.setAdapter(facultieListAdapter);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
