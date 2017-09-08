package com.example.administrator.tenbuy.ui.homepage;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.tenbuy.bean.TodayBean;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/30.
 */
public class TodayPresenter implements TodayContract.Presenter  {
    private TodayContract.View view;
    private TodayContract.Modle modle;

    public TodayPresenter(TodayContract.View view) {
        this.view = view;
        this.modle=new TodayModle();
    }

    @Override
    public void getToday(Map<String, String> params) {
        modle.getCarouselImage(params, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody body = response.body();
                try {
                    String string = body.string();
                    JSONArray jsonArray=new JSONArray(string);
                    final List<TodayBean>list=new ArrayList();
                    for (int i = 0; i <jsonArray.length() ; i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String aId = object.getString("AId");
                        String name = object.getString("Name");
                        String urlAddress = object.getString("UrlAddress");
                        String urlClass = object.getString("UrlClass");
                        String imgUrl = object.getString("imgUrl");
                        TodayBean todayBean=new TodayBean(aId,name,urlAddress,urlClass,imgUrl);
                        list.add(todayBean);
                    }
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.onGetTodaySucess(list);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                view.onGetTodayFail("网络访问失败");
            }
        });
    }
}
