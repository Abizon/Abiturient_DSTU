package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.adapters.EventListAdapter;
import com.dstu.myapplication.dstu.ConfigRetrofit;
import com.dstu.myapplication.dstu.Requests;
import com.dstu.myapplication.models.Event;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class EventFragment extends Fragment implements Callback<Event.Array> {
    ListView recyclerView;
    EventListAdapter eventListAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (ListView) view.findViewById(R.id.rv);
        getActivity().setTitle("Мероприятия");

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
        eventListAdapter = new EventListAdapter(this.getContext(), response.body().getEvents());
        recyclerView.setAdapter(eventListAdapter);
    }

    @Override
    public void onFailure(Throwable t) {
    }
}
