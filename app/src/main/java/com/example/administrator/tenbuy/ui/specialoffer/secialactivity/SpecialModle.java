package com.example.administrator.tenbuy.ui.specialoffer.secialactivity;

import com.example.administrator.tenbuy.bean.TowBean;
import com.example.administrator.tenbuy.http.HttpUtils;

import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/9/3.
 */
public class SpecialModle implements SpecialContract.Modle {
    @Override
    public void getdata(Map<String, Object> params, Callback<TowBean> callback) {
        HttpUtils.getInstance().getTowNewData(params,callback);
    }
}
