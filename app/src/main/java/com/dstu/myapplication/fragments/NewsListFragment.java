package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
    ListView recyclerView;
    NewsListAdapter newsListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (ListView) view.findViewById(R.id.rv);

        Requests requests = ConfigRetrofit.getRetrofit().create(Requests.class);
        requests.getNews(0).enqueue(this);

        /**
         * TODO: Выгрузка информации о последних новостях из базы данных телефона в случае отсутствия интернета
         */

        return view;
    }


    @Override
    public void onResponse(Response<News.Array> response, Retrofit retrofit) {
        newsListAdapter = new NewsListAdapter(this.getContext(), response.body().getArray());
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
