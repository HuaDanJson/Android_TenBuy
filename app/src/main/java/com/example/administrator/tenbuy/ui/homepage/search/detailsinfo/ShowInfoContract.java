package com.example.administrator.tenbuy.ui.homepage.search.detailsinfo;

import com.example.administrator.tenbuy.base.IBaseModel;
import com.example.administrator.tenbuy.base.IBasePersenter;
import com.example.administrator.tenbuy.base.IBaseView;
import com.example.administrator.tenbuy.bean.ContentBean;
import com.example.administrator.tenbuy.bean.RowsBean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class ShowInfoContract {
    public interface View extends IBaseView {
        public void onGetInfoSucess(List<RowsBean> list);
        public void onGetInfoFail(String erro);
    };
    public interface  Modle extends IBaseModel {
        public void getShow(Map<String, String> params, Callback<ContentBean> callback);
    };
    public interface Presenter extends IBasePersenter {
        public void getShow(Map<String, String> params);
    };
}
