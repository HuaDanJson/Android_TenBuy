package com.example.administrator.tenbuy.ui.homepage;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.tenbuy.bean.CarouseDataBean;
import com.example.administrator.tenbuy.bean.CarouselBean;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HomepagePresenter implements HomepageContract.Presenter  {
    private HomepageContract.View view;
    private HomepageContract.Modle modle;

    public HomepagePresenter(HomepageContract.View view) {
        this.view = view;
        this.modle=new HomepageModle();
    }


    @Override
    public void getCarouselImage(Map<String, String> params) {
        modle.getCarouselImage(params, new Callback<CarouselBean>() {
            @Override
            public void onResponse(Call<CarouselBean> call, Response<CarouselBean> response) {
                final List<CarouseDataBean> carouseList = response.body().getAdList();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.onGetSucess(carouseList);
                    }
                });
            }

            @Override
            public void onFailure(Call<CarouselBean> call, Throwable t) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.onGetFail("网络访问失败");
                    }
                });
            }
        });
    }

}
