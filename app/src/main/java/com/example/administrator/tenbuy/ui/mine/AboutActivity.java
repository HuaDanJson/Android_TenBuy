package com.example.administrator.tenbuy.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by meidou on 2016/9/1.
 */
public class AboutActivity extends BaseActivity {
    @BindView(R.id.about_back)
    Button aboutBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.about_back)
    public void onClick() {
        Intent intent=new Intent(AboutActivity.this,SettingActivity.class);
        startActivity(intent);
        AboutActivity.this.finish();
    }
}
