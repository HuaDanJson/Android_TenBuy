package com.example.administrator.tenbuy.http;

import com.example.administrator.tenbuy.bean.AdsaBean;
import com.example.administrator.tenbuy.bean.CarouselBean;
import com.example.administrator.tenbuy.bean.HandpickedBean;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;
import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.bean.SpeciaBean;
import com.example.administrator.tenbuy.bean.TowBean;
import com.example.administrator.tenbuy.config.UrlConfig;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/30.
 */
public interface ITenbuyService {
    @GET(UrlConfig.ToPath.CAROUSEL)
    Call<CarouselBean> getHomePageData(@QueryMap()Map<String,String> params);
    @GET(UrlConfig.ToPath.HANDPICKED)
    Call<HandpickedBean> getHandpicked(@QueryMap()Map<String,Object> params);
    @GET(UrlConfig.ToPath.ROWS)
    Call<ContentBean> getRows(@QueryMap()Map<String,String> params);
    @GET(UrlConfig.ToPath.TODAY)
    Call<ResponseBody>getToday(@QueryMap()Map<String,String> params);
    @GET(UrlConfig.ToPath.NEWON)
    Call<SpeciaBean>getNew(@QueryMap()Map<String,Object> params);

    @GET(UrlConfig.ToPath.HANDPICKED)
    Call<TowBean>getTowNew(@QueryMap()Map<String,Object> params);
}
