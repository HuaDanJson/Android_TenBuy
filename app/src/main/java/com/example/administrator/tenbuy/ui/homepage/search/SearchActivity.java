package com.example.administrator.tenbuy.ui.homepage.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;
import com.example.administrator.tenbuy.bean.ClasslyBean;
import com.example.administrator.tenbuy.ui.homepage.search.detailsinfo.InfoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity {


    @BindView(R.id.gridview_show)
    GridView gridviewShow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        int[]classify={R.mipmap.ic_m_nvzhuang,R.mipmap.nanzhuang,
                R.mipmap.jujia,R.mipmap.muying,
                R.mipmap.xiebao,R.mipmap.neiyi,
                R.mipmap.meishi,R.mipmap.shuma,
                R.mipmap.huazhuangpin,R.mipmap.wenti,
                R.mipmap.oldman,R.mipmap.peishi,
                R.mipmap.jkj,R.mipmap.newsort,
                R.mipmap.all
        };
        final String[]name={"女装","男装","居家","母婴","鞋包","内衣","美食","数码家电","美妆个护","文体","中老年","配饰","十元包邮","今日更新","全部"};
        List<ClasslyBean>list=new ArrayList<>();
        for (int i = 0; i <classify.length ; i++) {
            ClasslyBean classlyBean=new ClasslyBean(name[i],classify[i]);
            list.add(classlyBean);
        }
        ShowAdapter adapter=new ShowAdapter(list);
        gridviewShow.setAdapter(adapter);
        gridviewShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(SearchActivity.this, InfoActivity.class);
                intent.putExtra("sort",position);
                intent.putExtra("name",name[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }
}
