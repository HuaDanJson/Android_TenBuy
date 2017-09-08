package com.example.administrator.tenbuy.ui.homepage.search.detailsinfo;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.bean.RowsBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/30.
 */
public class ShowinfoPresenter implements ShowInfoContract.Presenter  {
    private ShowInfoContract.View view;
    private ShowInfoContract.Modle modle;

    public ShowinfoPresenter(ShowInfoContract.View view) {
        this.view = view;
        this.modle = new ShowinfoModle();
    }

    @Override
    public void getShow(Map<String, String> params) {
        modle.getShow(params, new Callback<ContentBean>() {
            @Override
            public void onResponse(Call<ContentBean> call, Response<ContentBean> response) {
                final List<RowsBean> rows = response.body().getRows();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.onGetInfoSucess(rows);
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
