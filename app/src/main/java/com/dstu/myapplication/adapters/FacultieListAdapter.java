package com.dstu.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.activities.MainActivity;
import com.dstu.myapplication.activities.SplashActivity;
import com.dstu.myapplication.fragments.DirectionsListFragment;
import com.dstu.myapplication.models.Facultie;

import java.util.ArrayList;
import java.util.List;


public class FacultieListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Facultie> faculties;

    private class FacultieItemHolder{
        TextView name,count, date, text, author, date2;
        ImageView cardIcon;
        CardView cardView;

        FacultieItemHolder(View view){
            name = (TextView) view.findViewById(R.id.textView32);
            cardView = (CardView)view.findViewById(R.id.cv);
        }
    }
    public FacultieListAdapter(Context context, List<Facultie> children){
        this(context, new ArrayList<Facultie>());
    }

    public FacultieListAdapter(final Context context, ArrayList<Facultie> faculties){
        this.context = context;
        this.faculties = faculties;
    }
    @Override
    public int getCount() {
        return faculties.size();
    }

    @Override
    public Object getItem(int i) {
        return faculties.get(i);
    }

    @Override
    public long getItemId(int i) {
        return faculties.get(i).getId();
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.faculties, viewGroup, false);
        }


        final FacultieListAdapter.FacultieItemHolder itemHolder = new FacultieListAdapter.FacultieItemHolder(convertView);

        itemHolder.name.setText(faculties.get(i).getName());
        itemHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new DirectionsListFragment(faculties.get(i).getId());
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
        });
        return convertView;
    }

}
