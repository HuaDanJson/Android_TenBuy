package com.example.administrator.tenbuy.http;

import android.util.Log;

import com.example.administrator.tenbuy.bean.CarouseDataBean;
import com.example.administrator.tenbuy.bean.CarouselBean;
import com.example.administrator.tenbuy.bean.HandpickedBean;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;
import com.example.administrator.tenbuy.bean.AdsaBean;
import com.example.administrator.tenbuy.bean.CarouselBean;
import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.bean.SpeciaBean;
import com.example.administrator.tenbuy.bean.TowBean;
import com.example.administrator.tenbuy.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HttpUtils {
    private static volatile HttpUtils singleton;
    private Retrofit retrofit;
    private ITenbuyService tenbuy;

    private HttpUtils() {
        retrofit = createRetrofit();
        tenbuy = createTenbuy();
    }

    public static HttpUtils getInstance() {
        if (singleton == null) {
            synchronized (HttpUtils.class) {
                if (singleton == null) {
                    singleton = new HttpUtils();
                }
            }
        }
        return singleton;
    }

    /**
     * 创建retrofit的实例
     * @return
     */
    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(UrlConfig.Path.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build();
    }

    /**
     * 创建gson实例,用于retrofit解析返回的结果
     * @return
     */
    private Gson createGson() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        return gson;
    }

    /**
     * 创建网络连接接口的实例
     * @return
     */
    private ITenbuyService createTenbuy() {
        ITenbuyService tenbuy = retrofit.create(ITenbuyService.class);
        return tenbuy;
    }

    /**
     * 网络获取颜值的方法
     *
     * @param params   参数列表 包含两个参数 limit和offset
     * @param callback 访问数据的回调接口
     */

    public void getCarouseData(Map<String, String> params, Callback<CarouselBean> callback) {
        Call<CarouselBean> call = tenbuy.getHomePageData(params);
        call.enqueue(callback);
    }
    public void getRowsData(Map<String, String> params, Callback<ContentBean> callback) {
        Call<ContentBean> rows = tenbuy.getRows(params);
        rows.enqueue(callback);
    }
    public void getNewData(Map<String, Object> params, Callback<SpeciaBean> callback) {
        Call<SpeciaBean> aNew = tenbuy.getNew(params);
        aNew.enqueue(callback);
    }
    public void getTowNewData(Map<String, Object> params, Callback<TowBean> callback) {
        Call<TowBean> aNew = tenbuy.getTowNew(params);
        aNew.enqueue(callback);
    }

    public void getHandpickedData(Map<String, Object> params, Callback<HandpickedBean> callbacks) {
        Call<HandpickedBean> call = tenbuy.getHandpicked(params);
        call.enqueue(callbacks);
        Log.i("TAG","----------->2");
    }




}
