package com.example.administrator.tenbuy.ui.tenbuy;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseFragment;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;
import com.example.administrator.tenbuy.ui.homepage.DetailsActivity;
import com.example.administrator.tenbuy.ui.tenbuy.tenbuyFragment.GridViewAdapter;
import com.example.administrator.tenbuy.ui.tenbuy.tenbuyFragment.HandpickedFragment;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 */
public class TenbuyFragment extends BaseFragment implements TenbuyContract.View {

    @BindView(R.id.tabLayout_main)
    TabLayout tabLayoutMain;
    @BindView(R.id.tengridView)
    PullToRefreshGridView tengridView;

    //    @BindView(R.id.fragment_viewpage)
//    ViewPager fragmentViewpage;
    // private List<Fragment> mList = new ArrayList<>();
    private TenbuyContract.Persenter persenter;//接口类  p的父类
    private String[] mArrayString;
    // private MyFragmentPagerAdapter adapter;
    private HandpickedFragment handpickedFragment;
    private GridViewAdapter adapter;
    private List<HandpickedDataBean> mList = new ArrayList<>();
    private String bc = "9";
    private Map<String, Object> param;
    private int aa = 1;

    @Override
    protected void initData() {
        persenter = new TenbuyPresenter(this);
        param = new HashMap<>();
        param.put("act", "getproductlist");
        param.put("v", 34);
        param.put("pages", aa);
        param.put("bc", 0);
        param.put("sc", 0);
        param.put("sorts", "");
        param.put("channel", 9);
        param.put("ckey", "");
        param.put("daynews", "");
        param.put("lprice", 0);
        param.put("hprice", 0);
        param.put("tbclass", 0);
        param.put("actid", 0);
        param.put("brandid", 0);
        param.put("predate", "");
        param.put("index", 0);
        persenter.getVertical(param);
//        handpickedFragment   =   new HandpickedFragment();
//        mList.add(handpickedFragment);
//        mList.add(new TenFragment());
//        mList.add(new TwentyFragment());
//        mList.add(new ThirtyFragment());
//        adapter.notifyDataSetChanged();
        mArrayString = getResources().getStringArray(R.array.arrTabTitles);
        for (int i = 0; i < mArrayString.length; i++) {
            tabLayoutMain.addTab(tabLayoutMain.newTab().setText(mArrayString[i]), i);
        }
    }

    //    @Override
//    protected void initView() {
//        mArrayString = getResources().getStringArray(R.array.arrTabTitles);
//        adapter = new MyFragmentPagerAdapter(getActivity().getSupportFragmentManager(), mList, mArrayString);
//        fragmentViewpage.setAdapter(adapter);
//        tabLayoutMain.setupWithViewPager(fragmentViewpage);
//    }
    @Override
    protected void initView() {
        tengridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("name", mList.get(position).getName());
                intent.putExtra("web", mList.get(position).getSpreadUrl());
                getActivity().startActivity(intent);
            }
        });
        tengridView.setMode(PullToRefreshBase.Mode.BOTH);
        tengridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                mList.clear();
                persenter.getVertical(param);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                aa++;
                param.put("pages", aa);
                persenter.getVertical(param);
            }
        });

    }

    private void initOnclick() {
        tabLayoutMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != tabLayoutMain.getTabAt(0)) {
                    bc = tabLayoutMain.getSelectedTabPosition() + 2 + "";
                    param.put("channel", bc);
                    persenter.getVertical(param);
                } else {
                    param.put("channel", "9");
                    persenter.getVertical(param);
                }
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
        return R.layout.fragment_tenbuy;
    }

    @Override
    public void onGetVerticalSucess(List<HandpickedDataBean> rooms) {
        initOnclick();
        mList = rooms;
        adapter = new GridViewAdapter(mList, getActivity());
        tengridView.setAdapter(adapter);
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("ssss", (ArrayList<? extends Parcelable>) rooms);
//        handpickedFragment.setArguments(bundle);
        adapter.notifyDataSetChanged();
        tengridView.onRefreshComplete();

    }

    @Override
    public void onGetVerticalFail(String erro) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
