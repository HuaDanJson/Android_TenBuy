package com.example.administrator.tenbuy.ui.specialoffer.specialoffers;



import com.example.administrator.tenbuy.bean.AdsaBean;
import com.example.administrator.tenbuy.bean.SpeciaBean;
import com.example.administrator.tenbuy.http.HttpUtils;
import com.example.administrator.tenbuy.ui.specialoffer.specialoffers.NewContract;

import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class NewModle implements NewContract.Modle {


    @Override
    public void getdata(Map<String, Object> params, Callback<SpeciaBean> callback) {
        HttpUtils.getInstance().getNewData(params,callback);
    }


}
