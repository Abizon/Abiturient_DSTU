package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.dstu.myapplication.R;
import com.dstu.myapplication.adapters.IventListAdapter;
import com.dstu.myapplication.adapters.NewsListAdapter;
import com.dstu.myapplication.dstu.ConfigRetrofit;
import com.dstu.myapplication.dstu.Requests;
import com.dstu.myapplication.models.Event;
import com.dstu.myapplication.models.News;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class IventFragment extends Fragment implements Callback<Event.Array> {
    ListView recyclerView;
    IventListAdapter iventListAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (ListView) view.findViewById(R.id.rv);

        Requests requests = ConfigRetrofit.getRetrofit().create(Requests.class);
        //requests.getNews(0).enqueue(this);
        requests.getEvents(0).enqueue(this);

        /**
         * TODO: Выгрузка информации о последних новостях из базы данных телефона в случае отсутствия интернета
         */

        return view;
    }
    @Override
    public void onResponse(Response<Event.Array> response, Retrofit retrofit) {
        iventListAdapter = new IventListAdapter(this.getContext(), response.body().getEvents());
        recyclerView.setAdapter(iventListAdapter);
    }

    @Override
    public void onFailure(Throwable t) {
    }
}
