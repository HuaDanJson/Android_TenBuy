package com.example.administrator.tenbuy.ui.specialoffer.specialoffers;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.administrator.tenbuy.bean.AdsaBean;
import com.example.administrator.tenbuy.bean.HandpickedBean;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;
import com.example.administrator.tenbuy.bean.RowBean;
import com.example.administrator.tenbuy.bean.SpeciaBean;
import com.example.administrator.tenbuy.bean.SpeciaRowsBean;
import com.example.administrator.tenbuy.ui.specialoffer.specialoffers.NewContract;
import com.example.administrator.tenbuy.ui.specialoffer.specialoffers.NewModle;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/30.
 */
public class NewPresenter implements NewContract.Presenter  {
    private NewContract.View view;
    private NewContract.Modle modle;
    public NewPresenter(NewContract.View view) {
        this.view = view;
        this.modle = new NewModle();
    }


    @Override
    public void getdata(Map<String, Object> params) {
        modle.getdata(params, new Callback<SpeciaBean>() {
            @Override
            public void onResponse(Call<SpeciaBean> call, Response<SpeciaBean> response) {

                SpeciaBean speciaBean= response.body();
                final List<SpeciaRowsBean> rooms=speciaBean.getRows();


                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.onGetNewSucess(rooms);
                    }
                });

            }

            @Override
            public void onFailure(Call<SpeciaBean> call, Throwable t) {
                t.printStackTrace();
                view.onGetNewFail("");
            }
        });
    }

}
