package com.example.administrator.tenbuy.ui.specialoffer.secialactivity;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.administrator.tenbuy.bean.SpeciaBean;
import com.example.administrator.tenbuy.bean.SpeciaRowsBean;
import com.example.administrator.tenbuy.bean.TowBean;
import com.example.administrator.tenbuy.bean.TowRowBean;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/3.
 */
public class SpecialPresenter implements SpecialContract.Presenter {
    private SpecialContract.View view;
    private SpecialContract.Modle modle;
    public SpecialPresenter(SpecialContract.View view){
        this.view = view;
        modle = new SpecialModle();
    }
    @Override
    public void getdata(Map<String, Object> params) {
        modle.getdata(params, new Callback<TowBean>() {
            @Override
            public void onResponse(Call<TowBean> call, Response<TowBean> response) {

                TowBean towBean= response.body();
                final List<TowRowBean> rooms=towBean.getRows();
                Logger.i(rooms.get(0).getName());
                for (int i = 0; i <rooms.size() ; i++) {
                    Log.i("qwe","qwe0"+rooms.get(i).getName());
                }
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.onGetNewSucess(rooms);
                    }
                });

            }

            @Override
            public void onFailure(Call<TowBean> call, Throwable t) {
                t.printStackTrace();
                view.onGetNewFail("");
            }
        });
    }
}
