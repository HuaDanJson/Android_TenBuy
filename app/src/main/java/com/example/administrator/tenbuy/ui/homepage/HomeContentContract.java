package com.example.administrator.tenbuy.ui.homepage;

import com.example.administrator.tenbuy.base.IBaseModel;
import com.example.administrator.tenbuy.base.IBasePersenter;
import com.example.administrator.tenbuy.base.IBaseView;
import com.example.administrator.tenbuy.bean.CarouseDataBean;
import com.example.administrator.tenbuy.bean.CarouselBean;
import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.bean.RowsBean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HomeContentContract {
    public interface View extends IBaseView{
        public void onGetRowsSucess(List<RowsBean> list);
        public void onGetRowsFail(String erro);
    };
    public interface  Modle extends IBaseModel{
        public void getRows(Map<String, String> params, Callback<ContentBean> callback);
    };
    public interface Presenter extends IBasePersenter{
        public void getRows(Map<String, String> params);
    };
}
