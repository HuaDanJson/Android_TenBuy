package com.example.administrator.tenbuy.ui.tenbuy;

import android.util.Log;

import com.example.administrator.tenbuy.bean.HandpickedBean;
import com.example.administrator.tenbuy.http.HttpUtils;

import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class TenbuyModle implements TenbuyContract.Model {
    @Override
    public void getVertical(Map<String, Object> params, Callback<HandpickedBean> callback) {
        Log.i("TAG","----------->1");
        HttpUtils.getInstance().getHandpickedData(params,callback);
    }
}
