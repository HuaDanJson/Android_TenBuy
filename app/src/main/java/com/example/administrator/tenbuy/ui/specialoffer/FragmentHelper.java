package com.example.administrator.tenbuy.ui.specialoffer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by StevenWang on 16/7/21.
 */
public class FragmentHelper {

    public static void replaceFragment(FragmentManager manager, List<Fragment> list, int
            tabIndex, int layoutId) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(layoutId, list.get(tabIndex));
        transaction.commit();
    }

    public static void switchFragment(FragmentManager manager, List<Fragment> list, int
            tabIndex, int layoutId) {
        FragmentTransaction transaction = manager.beginTransaction();
        //让当前显示的碎片进行隐藏
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isVisible()) {
                transaction.hide(list.get(i));
            }
        }
        Fragment toFragment = list.get(tabIndex);
        if (toFragment.isAdded()) {
            transaction.show(toFragment);
        } else {
            transaction.add(layoutId, toFragment);
        }
        transaction.commit();
    }
}
