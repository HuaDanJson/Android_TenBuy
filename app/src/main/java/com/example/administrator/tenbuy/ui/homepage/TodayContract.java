package com.example.administrator.tenbuy.ui.homepage;

import com.example.administrator.tenbuy.base.IBaseModel;
import com.example.administrator.tenbuy.base.IBasePersenter;
import com.example.administrator.tenbuy.base.IBaseView;
import com.example.administrator.tenbuy.bean.CarouselBean;
import com.example.administrator.tenbuy.bean.RowsBean;
import com.example.administrator.tenbuy.bean.TodayBean;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class TodayContract {
    public interface View extends IBaseView{
        public void onGetTodaySucess(List<TodayBean> list);
        public void onGetTodayFail(String erro);
    };
    public interface  Modle extends IBaseModel{
        public void getCarouselImage(Map<String,String> params, Callback<ResponseBody> callback);
    };
    public interface Presenter extends IBasePersenter{
        public void getToday(Map<String,String> params);
    };
}
