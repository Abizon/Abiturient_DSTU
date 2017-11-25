package com.dstu.myapplication.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by root on 25.11.2017.
 */

public class NewsListAdapter extends BaseAdapter {


    class NewsItemHolder{
        TextView Titele;


        public NewsItemHolder(View view){


        }

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
