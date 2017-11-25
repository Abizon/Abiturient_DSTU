package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dstu.myapplication.R;
import com.dstu.myapplication.adapters.NewsListAdapter;
import com.dstu.myapplication.dstu.ConfigRetrofit;
import com.dstu.myapplication.dstu.Requests;
import com.dstu.myapplication.models.News;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by root on 25.11.2017.
 */

public class NewsListFragment extends Fragment implements Callback<News.Array> {
    RecyclerView recyclerView;
    NewsListAdapter newsListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);

        Requests requests = ConfigRetrofit.getRetrofit().create(Requests.class);
        requests.getNews(0).enqueue(this);

        /**
         * TODO: Выгрузка информации о последних новостях из базы данных телефона в случае отсутствия интернета
         */

        return view;
    }


    @Override
    public void onResponse(Response<News.Array> response, Retrofit retrofit) {
        int i = 0;
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
