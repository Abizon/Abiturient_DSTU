package com.dstu.myapplication.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dstu.myapplication.Fragment1;
import com.dstu.myapplication.R;
import com.dstu.myapplication.fragments.NewsListFragment;
import com.dstu.myapplication.fragments.ProfileAchievementFragment;
import com.dstu.myapplication.fragments.ProfileInformationFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public static final int items = 2;

    private Context mContext;

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProfileInformationFragment();
            case 1:
                return new ProfileAchievementFragment();
            default:
                return new NewsListFragment();
        }
    }

    @Override
    public int getCount() {
        return items;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.profile_main);
            case 1:
                return mContext.getString(R.string.profile_2);
            default:
                return "";
        }
    }
}
