package com.example.administrator.tenbuy.ui.specialoffer.secialactivity;

import com.example.administrator.tenbuy.base.IBaseModel;
import com.example.administrator.tenbuy.base.IBasePersenter;
import com.example.administrator.tenbuy.base.IBaseView;
import com.example.administrator.tenbuy.bean.SpeciaBean;
import com.example.administrator.tenbuy.bean.SpeciaRowsBean;
import com.example.administrator.tenbuy.bean.TowBean;
import com.example.administrator.tenbuy.bean.TowRowBean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/9/3.
 */
public class SpecialContract {
    public interface View extends IBaseView {
        public void onGetNewSucess(List<TowRowBean> list);
        public void onGetNewFail(String erro);
    };
    public interface  Modle extends IBaseModel {
        public void getdata(Map<String, Object> params, Callback<TowBean> callback);
    };
    public interface Presenter extends IBasePersenter {
        public void getdata(Map<String, Object> params);
    };
}
