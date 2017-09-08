package com.example.administrator.tenbuy.ui.specialoffer;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.SpeciaRowsBean;
import com.example.administrator.tenbuy.ui.specialoffer.secialactivity.SpecialActivity;
import com.example.administrator.tenbuy.ui.specialoffer.specialoffers.NewContract;
import com.example.administrator.tenbuy.ui.specialoffer.specialoffers.NewPresenter;
import com.example.administrator.tenbuy.ui.specialoffer.specialoffers.SpecialAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DummyFragment extends Fragment implements NewContract.View {
    @BindView(R.id.special_listview)
    ListView specialListview;
    private int tabIndex = 0;
    private Context mContext;
    private NewContract.Presenter persenter;
    private Map<String, Object> param;
    private SpecialAdapter adapter;
    private List<SpeciaRowsBean> mList = new ArrayList<>();

    public static DummyFragment newInstance(int tabIndex) {
        Bundle bundle = new Bundle();
        DummyFragment fragment = new DummyFragment();
        bundle.putInt("tabIndex", tabIndex);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        tabIndex = getArguments().getInt("tabIndex");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {


    }

    private void initData() {
        persenter = new NewPresenter(this);
        param = new HashMap<>();
        param.put("act", "brandlist");
        param.put("cpage", 1);
        param.put("pagesize", 20);
        switch (tabIndex){
            case 0:
                param.put("bclass", 99);
                break;
            case 1:
                param.put("bclass", 98);
                break;
            case 2:
                param.put("bclass", 97);
                break;
            case 3:
                param.put("bclass", 1);
                break;
            case 4:
                param.put("bclass", 5);
                break;
            case 5:
                param.put("bclass", 98);
                break;
            case 6:
                param.put("bclass", 9);
                break;
            case 7:
                param.put("bclass", 99);
                break;
            case 8:
                param.put("bclass", 2);
                break;
            case 9:
                param.put("bclass", 8);
                break;
            case 10:
                param.put("bclass", 2);
                break;
            case 11:
                param.put("bclass", 1);
                break;

        }

        param.put("v", 34);
        persenter.getdata(param);
    }

    @Override
    public void onGetNewSucess(List<SpeciaRowsBean> list) {
        mList = list;
        adapter = new SpecialAdapter(mContext, mList);
        specialListview.setAdapter(adapter);
        Log.i("sfdsf","fsfsfsf"+mList.get(1).getProductInfo());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onGetNewFail(String erro) {
    }
}
