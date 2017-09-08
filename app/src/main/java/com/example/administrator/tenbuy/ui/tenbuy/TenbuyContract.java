package com.example.administrator.tenbuy.ui.tenbuy;

import android.util.Log;

import com.example.administrator.tenbuy.base.IBaseModel;
import com.example.administrator.tenbuy.base.IBasePersenter;
import com.example.administrator.tenbuy.base.IBaseView;
import com.example.administrator.tenbuy.bean.CarouseDataBean;
import com.example.administrator.tenbuy.bean.HandpickedBean;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/30.
 */
public class TenbuyContract {

    //activity fragment
    public interface View extends IBaseView{
        public void onGetVerticalSucess(List<HandpickedDataBean> rooms);
        public void onGetVerticalFail(String erro);
    }
    //M层网络请求
    public interface Model extends IBaseModel {
        public void getVertical(Map<String,Object> params, Callback<HandpickedBean> callback);

    }
      // 是modle和acativty 在P中操作
    public interface Persenter extends IBasePersenter{
        public void getVertical(Map<String,Object> params);
    }
}
