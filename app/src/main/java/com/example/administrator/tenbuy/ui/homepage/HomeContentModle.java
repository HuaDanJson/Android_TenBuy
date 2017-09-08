package com.example.administrator.tenbuy.ui.homepage;

import com.example.administrator.tenbuy.bean.CarouselBean;
import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.http.HttpUtils;

import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HomeContentModle implements HomeContentContract.Modle {

    @Override
    public void getRows(Map<String, String> params, Callback<ContentBean> callback) {
        HttpUtils.getInstance().getRowsData(params,callback);
    }
}
