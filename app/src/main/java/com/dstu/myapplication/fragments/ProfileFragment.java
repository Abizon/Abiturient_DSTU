package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dstu.myapplication.R;
import com.dstu.myapplication.adapters.ViewPagerAdapter;


public class ProfileFragment extends Fragment {

    ViewPager viewPager;

    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);
        getActivity().setTitle("Личный кабинет");

        viewPager = (ViewPager) view.findViewById(R.id.container_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getContext(), getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //табы
        tabLayout.addTab(tabLayout.newTab().setText(R.string.profile_main).setIcon(R.drawable.ic_menu_camera));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.profile_2).setIcon(R.drawable.ic_menu_gallery));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //по нажатию шлем опредленный фрагмент
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }

}
