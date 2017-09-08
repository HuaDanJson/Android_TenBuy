package com.example.administrator.tenbuy.ui.homepage.explain;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExplainActivity extends BaseActivity {


    @BindView(R.id.imageview_back)
    ImageView imageviewBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_explain;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }



    @OnClick(R.id.imageview_back)
    public void onClick() {
        finish();
    }
}
