package com.example.administrator.tenbuy.ui.specialoffer.secialactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.TowRowBean;
import com.example.administrator.tenbuy.ui.homepage.DetailsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialActivity extends AppCompatActivity implements SpecialContract.View {
    @BindView(R.id.special_image)
    ImageView specialImage;
    @BindView(R.id.special_text1)
    TextView specialText1;
    @BindView(R.id.special_text2)
    TextView specialText2;
    @BindView(R.id.special_gridview)
    GridView specialGridview;
    private SpecialContract.Presenter persenter;
    private Map<String, Object> param;
    private SpecialAdapter adapter;
    private List<TowRowBean>mList = new ArrayList<>();
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
        Glide.with(this).load(getIntent().getStringExtra("url")).into(specialImage);
        specialText1.setText(getIntent().getStringExtra("xiu"));
        specialText2.setText(getIntent().getStringExtra("zhe"));
        specialGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtra("name", mList.get(position).getName());
                intent.putExtra("web", mList.get(position).getSpreadUrl());
                mContext.startActivity(intent);
            }
        });
    }


    private void initData() {
        persenter = new SpecialPresenter(this);
        param = new HashMap<>();
        param.put("act", "getworth");
        param.put("pages", "1");
        param.put("bc", "0");
        param.put("brandid", getIntent().getStringExtra("brandid"));
        param.put("v", "34");
        persenter.getdata(param);
    }


    @Override
    public void onGetNewSucess(List<TowRowBean> list) {
        this.mList = list;
        adapter = new SpecialAdapter(this,mList);
        specialGridview.setAdapter(adapter);

    }

    @Override
    public void onGetNewFail(String erro) {

    }
}
