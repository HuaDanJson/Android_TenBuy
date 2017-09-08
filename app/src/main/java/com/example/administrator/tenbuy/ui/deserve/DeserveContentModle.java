package com.example.administrator.tenbuy.ui.deserve;

import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.http.HttpUtils;

import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class DeserveContentModle implements DeserveContentContract.Modle {

    @Override
    public void getRows(Map<String, String> params, Callback<ContentBean> callback) {
        HttpUtils.getInstance().getRowsData(params,callback);
    }
}
