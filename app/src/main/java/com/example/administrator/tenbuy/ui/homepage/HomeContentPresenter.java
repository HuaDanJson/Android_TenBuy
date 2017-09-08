package com.example.administrator.tenbuy.ui.homepage;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.tenbuy.bean.CarouseDataBean;
import com.example.administrator.tenbuy.bean.CarouselBean;
import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.bean.RowsBean;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HomeContentPresenter implements HomeContentContract.Presenter  {
    private HomeContentContract.View view;
    private HomeContentContract.Modle modle;

    public HomeContentPresenter(HomeContentContract.View view) {
        this.view = view;
        this.modle = new HomeContentModle();
    }


    @Override
    public void getRows(Map<String, String> params) {

        modle.getRows(params, new Callback<ContentBean>() {
            @Override
            public void onResponse(Call<ContentBean> call, Response<ContentBean> response) {
                final List<RowsBean> rows = response.body().getRows();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.onGetRowsSucess(rows);
                    }
                });
            }

            @Override
            public void onFailure(Call<ContentBean> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
