package com.example.administrator.tenbuy.ui.homepage.search.detailsinfo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;
import com.example.administrator.tenbuy.bean.RowsBean;
import com.example.administrator.tenbuy.config.UrlConfig;
import com.example.administrator.tenbuy.ui.homepage.ContentAdapter;
import com.example.administrator.tenbuy.ui.homepage.HomeContentContract;
import com.example.administrator.tenbuy.ui.homepage.HomeContentPresenter;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class InfoActivity extends BaseActivity implements HomeContentContract.View {


    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.imageview_select)
    TextView imageviewSelect;
    @BindView(R.id.button_default)
    Button buttonDefault;
    @BindView(R.id.button_sales)
    Button buttonSales;
    @BindView(R.id.button_price)
    Button buttonPrice;
    @BindView(R.id.button_newest)
    Button buttonNewest;

    @BindView(R.id.gridview_info)
    GridView gridviewInfo;
    private String[] mBc;
    private String[] mSc;
    private int index = 0;

    private int sort;

    private HomeContentContract.Presenter presenter;
    private Map<String, String> params;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detailsinfo;
    }

    @Override
    public void initView() {
        init();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        sort = intent.getIntExtra("sort", 0);

        String bc = intent.getStringExtra("bj");
        String homename = intent.getStringExtra("homename");
        Logger.v(bc);
        buttonDefault.setTextColor(Color.rgb(254, 68, 129));
        presenter=new HomeContentPresenter(this);
        params = new HashMap<>();
        if(bc!=null){
            params.put(UrlConfig.Key.BC, bc);
            titleTextview.setText(homename);
        }else {
            params.put(UrlConfig.Key.BC, mBc[sort]);
            titleTextview.setText(name);
        }
        params.put(UrlConfig.Key.SORTS,"");
        params.put(UrlConfig.Key.ACT, UrlConfig.DefaultValue.ACT);
        params.put(UrlConfig.Key.V, UrlConfig.DefaultValue.V);
        params.put(UrlConfig.Key.PAGES, UrlConfig.DefaultValue.PAGES);
        params.put(UrlConfig.Key.SC, mSc[sort]);
        if(sort==12){
            params.put(UrlConfig.Key.CHANNEL, "3");
        }else {
            params.put(UrlConfig.Key.CHANNEL, "0");
        }
        params.put(UrlConfig.Key.CKEY, UrlConfig.DefaultValue.CKEY);
        if(sort==14){
            params.put(UrlConfig.Key.DAYNEWS, "");
        }else {
            params.put(UrlConfig.Key.DAYNEWS, "1");
        }
        if(sort==13){
            params.put(UrlConfig.Key.DAYNEWS,"1");
        }else {
            params.put(UrlConfig.Key.DAYNEWS,"");
        }

        presenter.getRows(params);
    }

    private void init() {
        mBc = new String[]{"1", "2", "3", "4", "5", "1", "7", "8", "9", "10", "1", "6", "0", "0", "0"};
        mSc = new String[]{"0", "0", "0", "0", "0", "13", "0", "0", "0", "0", "16", "0", "0", "0", "0"};
    }

    @Override
    public void initData() {
    }

    @OnClick({R.id.title_textview, R.id.imageview_select, R.id.button_default, R.id.button_sales, R.id.button_price, R.id.button_newest})
    public void onClick(View view) {

        showColor();
        switch (view.getId()) {
            case R.id.title_textview:

                break;
            case R.id.imageview_select:
                break;
            case R.id.button_default:

                index = 0;
                buttonDefault.setTextColor(Color.rgb(254, 68, 129));
                params.put(UrlConfig.Key.SORTS,"");
                break;
            case R.id.button_sales:
                index = 0;
                buttonSales.setTextColor(Color.rgb(254, 68, 129));
                params.put(UrlConfig.Key.SORTS,"sale2l");
                break;
            case R.id.button_price:
                buttonPrice.setTextColor(Color.rgb(254, 68, 129));
                if (index % 2 == 0) {

                    Drawable drawable = getResources().getDrawable(R.mipmap.ic_sort_up);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    buttonPrice.setCompoundDrawables(null, null, drawable, null);
                    params.put(UrlConfig.Key.SORTS,"pl2h");
                } else {

                    Drawable drawable = getResources().getDrawable(R.mipmap.ic_sort_down);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    buttonPrice.setCompoundDrawables(null, null, drawable, null);
                    params.put(UrlConfig.Key.SORTS,"ph2l");
                }
                index++;
                break;
            case R.id.button_newest:

                index = 0;
                buttonNewest.setTextColor(Color.rgb(254, 68, 129));
                params.put(UrlConfig.Key.SORTS,"new");
                break;
        }
        presenter.getRows(params);
    }

    private void showColor() {
        buttonDefault.setTextColor(Color.BLACK);
        buttonSales.setTextColor(Color.BLACK);
        buttonPrice.setTextColor(Color.BLACK);
        buttonNewest.setTextColor(Color.BLACK);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_sort_unselected);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        buttonPrice.setCompoundDrawables(null, null, drawable, null);
    }


    @Override
    public void onGetRowsSucess(List<RowsBean> list) {
        ContentAdapter adapter=new ContentAdapter(list);
        gridviewInfo.setAdapter(adapter);
    }

    @Override
    public void onGetRowsFail(String erro) {

    }

}
