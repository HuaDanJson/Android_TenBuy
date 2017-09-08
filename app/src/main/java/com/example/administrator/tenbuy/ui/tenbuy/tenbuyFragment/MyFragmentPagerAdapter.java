package com.example.administrator.tenbuy.ui.tenbuy.tenbuyFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment>mList = null;
    private String[] names = null;
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment>mList, String[] names) {
        super(fm);
        this.mList = mList;
        this.names = names;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
    //把names的值赋值给导航
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
