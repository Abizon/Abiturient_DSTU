package com.dstu.myapplication.adapters;


import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.models.Event;

import java.util.ArrayList;

public class EventListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Event> events;

    class EventItemHolder{
        TextView title, date, text, date2;

        EventItemHolder(View view){
            title = (TextView) view.findViewById(R.id.card_title);
            date = (TextView) view.findViewById(R.id.card_date);
            date2 = (TextView) view.findViewById(R.id.card_date2);
            text = (TextView) view.findViewById(R.id.card_text);
        }

    }

    public EventListAdapter(Context context){
        this(context, new ArrayList<Event>());
    }

    public EventListAdapter(Context context, ArrayList<Event> events){
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
        view = LayoutInflater.from(context).inflate(R.layout.holder_events_card, viewGroup, false);
        EventItemHolder itemHolder = new EventItemHolder(view);

        String plain = Html.fromHtml(event.getDescription()).toString();
        itemHolder.title.setText(event.getName());
        itemHolder.date.setText(event.getDate_start_event());
        itemHolder.text.setText(plain.trim());


        return view;
    }
}
