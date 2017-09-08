package com.example.administrator.tenbuy.ui.homepage;



import com.example.administrator.tenbuy.config.UrlConfig;
import com.example.administrator.tenbuy.http.ITenbuyService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/30.
 */
public class TodayModle implements TodayContract.Modle {


    @Override
    public void getCarouselImage(Map<String, String> params, Callback<ResponseBody> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(UrlConfig.Path.BASE_URL)
                .build();
        ITenbuyService service = retrofit.create(ITenbuyService.class);
        Call<ResponseBody> today = service.getToday(params);
        today.enqueue(callback);
    }
}
