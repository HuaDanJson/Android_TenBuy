package com.example.administrator.tenbuy.ui.homepage;


import com.example.administrator.tenbuy.bean.CarouselBean;

import com.example.administrator.tenbuy.http.HttpUtils;


import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HomepageModle implements HomepageContract.Modle {
    @Override
    public void getCarouselImage(Map<String, String> params, Callback<CarouselBean> callback) {
        HttpUtils.getInstance().getCarouseData(params,callback);
    }
}
