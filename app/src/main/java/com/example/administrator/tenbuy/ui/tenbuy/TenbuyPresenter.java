package com.example.administrator.tenbuy.ui.tenbuy;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.administrator.tenbuy.bean.HandpickedBean;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/30.
 */
public class TenbuyPresenter implements TenbuyContract.Persenter {
   private TenbuyContract.View view;
    private TenbuyContract.Model tenbuyModle;

    public TenbuyPresenter(TenbuyContract.View view){
        this.view=view;
       tenbuyModle=new TenbuyModle();
    }


    @Override
    public void getVertical(Map<String, Object> params) {
        tenbuyModle.getVertical(params, new Callback<HandpickedBean>() {
            @Override
            public void onResponse(Call<HandpickedBean> call, Response<HandpickedBean> response) {
                      Log.i("TAG","------->3");

                HandpickedBean handpickedBean= response.body();
                Log.i("TAG","------------4"+handpickedBean.getRows().size());
                final List<HandpickedDataBean> rooms=handpickedBean.getRows();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.onGetVerticalSucess(rooms);
                    }
                });

            }
            @Override
            public void onFailure(Call<HandpickedBean> call, Throwable t) {
                t.printStackTrace();
               view.onGetVerticalFail("");
            }
        });
    }
}
