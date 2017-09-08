package com.example.administrator.tenbuy.ui.tenbuy.tenbuyFragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HandpickedFragment extends Fragment {
    @BindView(R.id.mGridView)
    GridView mGridView;
    private GridViewAdapter adapter;
    private List<HandpickedDataBean> mList;
    private Context mContext;
    public HandpickedFragment(){
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_handpicked, container, false);
        ButterKnife.bind(this, view);
        mList = getArguments().getParcelableArrayList("ssss");
        Log.i("Info",mList.size()+"");


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        adapter = new GridViewAdapter(mList, mContext);
        mGridView.setAdapter(adapter);
    }
}
