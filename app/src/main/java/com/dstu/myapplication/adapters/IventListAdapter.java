package com.dstu.myapplication.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.models.Event;
import com.dstu.myapplication.models.News;

import java.util.ArrayList;

public class IventListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Event> events;

    class IventItemHolder{
        TextView title, date, text, date2;

        public IventItemHolder(View view){
            title = (TextView) view.findViewById(R.id.card_title);
            date = (TextView) view.findViewById(R.id.card_date);
            date2 = (TextView) view.findViewById(R.id.card_date2);
            text = (TextView) view.findViewById(R.id.card_text);
        }

    }

    public IventListAdapter(Context context){
        this(context, new ArrayList<Event>());
    }

    public IventListAdapter(Context context, ArrayList<Event> events){
        this.context = context;
        this.events = events;
    }


    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return events.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Event event = this.events.get(i);
        view = LayoutInflater.from(context).inflate(R.layout.news_merop, viewGroup, false);
        IventListAdapter.IventItemHolder itemHolder = new IventListAdapter.IventItemHolder(view);

        itemHolder.title.setText(event.getName());
        itemHolder.date.setText(event.getDate_start_event());
        //itemHolder.date2.setText(news.getTime_last_modify());
        itemHolder.text.setText(event.getDescription());


        return view;
    }
}
