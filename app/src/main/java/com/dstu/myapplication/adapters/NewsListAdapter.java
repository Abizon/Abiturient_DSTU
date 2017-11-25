package com.dstu.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.models.News;

import java.util.ArrayList;

public class NewsListAdapter extends BaseAdapter {

    Context context;
    ArrayList<News> news;

    class NewsItemHolder{
        TextView title, date, text, author, date2;
        ImageView cardIcon;

        public NewsItemHolder(View view){
            title = (TextView) view.findViewById(R.id.card_title);
            date = (TextView) view.findViewById(R.id.card_date);
            date2 = (TextView) view.findViewById(R.id.card_date2);
            text = (TextView) view.findViewById(R.id.card_text);
            author = (TextView) view.findViewById(R.id.card_author);
            cardIcon = (ImageView) view.findViewById(R.id.card_icon);
        }

    }

    public NewsListAdapter(Context context){
        this(context, new ArrayList<News>());
    }

    public NewsListAdapter(Context context, ArrayList<News> news){
        this.context = context;
        this.news = news;
    }



    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int i) {
        return news.get(i);
    }

    @Override
    public long getItemId(int i) {
        return news.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        News news = this.news.get(i);
        view = LayoutInflater.from(context).inflate(R.layout.holder_news_card, viewGroup, false);
        NewsItemHolder itemHolder = new NewsItemHolder(view);

        String author = news.getFirstname() + " " + news.getSurname();
        itemHolder.author.setText(author);
        itemHolder.title.setText(news.getTitle());
        itemHolder.date.setText(news.getTime_create());
        itemHolder.date2.setText(news.getTime_last_modify());
        itemHolder.text.setText(news.getDescription());


        return view;
    }
}
