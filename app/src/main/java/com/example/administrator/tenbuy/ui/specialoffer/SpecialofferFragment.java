package com.example.administrator.tenbuy.ui.specialoffer;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SpecialofferFragment extends BaseFragment {
private FragmentManager manager = null;
    private List<Fragment>mList = new ArrayList<>();
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.specialoffer_framelayout)
    FrameLayout specialofferFramelayout;

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        manager = getFragmentManager();
        String[] names = getResources().getStringArray(R.array.name);
        for (int i = 0; i < names.length; i++) {
            DummyFragment fragment = DummyFragment.newInstance(i);
            mList.add(fragment);
            mTabLayout.addTab(mTabLayout.newTab().setText(names[i]),i);
        }
        mTabLayout.getTabAt(0).select();
        FragmentHelper.replaceFragment(manager, mList, 0,
                R.id.specialoffer_framelayout);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentHelper.switchFragment(manager, mList, tab.getPosition(), R.id.specialoffer_framelayout);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
