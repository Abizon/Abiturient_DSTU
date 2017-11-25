package com.dstu.myapplication.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dstu.myapplication.R;

public class NewsListAdapter extends BaseAdapter {

    class NewsItemHolder{
        TextView title, date, text, author, date2;
        ImageView cardIcon;

        public NewsItemHolder(View view){
            title = (TextView) view.findViewById(R.id.card_title);
            date = (TextView) view.findViewById(R.id.card_date);
            date2 = (TextView) view.findViewById(R.id.card_date2);
            text = (TextView) view.findViewById(R.id.text);
            author = (TextView) view.findViewById(R.id.card_author);
            cardIcon = (ImageView) view.findViewById(R.id.card_icon);
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
