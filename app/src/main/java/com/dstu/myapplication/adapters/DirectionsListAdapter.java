package com.dstu.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.fragments.DirectionsListFragment;
import com.dstu.myapplication.models.Specialty;

import java.util.ArrayList;


public class DirectionsListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Specialty> directions;

    private class DirectionsItemHolder{
        TextView title, date, text, author, date2;
        ImageView cardIcon;

        DirectionsItemHolder(View view){
            title = (TextView) view.findViewById(R.id.textView32);
        }

    }
    public DirectionsListAdapter(Context context){
        this(context, new ArrayList<Specialty>());
    }

    public DirectionsListAdapter(Context context, ArrayList<Specialty> directions){
        this.context = context;
        this.directions = directions;
    }
    @Override
    public int getCount() {
        return directions.size();
    }

    @Override
    public Object getItem(int i) {
        return directions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return directions.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.faculties, viewGroup, false);
        DirectionsListAdapter.DirectionsItemHolder itemHolder = new DirectionsListAdapter.DirectionsItemHolder(view);

        itemHolder.title.setText(directions.get(i).getSpecilaty_title());

        return view;
    }
}
