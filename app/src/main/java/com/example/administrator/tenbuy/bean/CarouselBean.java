package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class CarouselBean {
    /**
     * adList : [{"UrlClass":2,"address":"intent:#Intent;launchFlags=0x4000000;component=com.syby8/.PromotionActivity;i.actid=11;end","cName":"氧气女神爱运动 ","cStatus":1,"imgUrl":"http://img.syby8.com/upload/ad/201608171218389580.jpg"},{"UrlClass":2,"address":"intent:#Intent;launchFlags=0x4000000;component=com.syby8/.PromotionActivity;i.actid=19;end","cName":"返校季 省钱大作战","cStatus":1,"imgUrl":"http://img.syby8.com/upload/ad/201608301151234503.jpg"},{"UrlClass":2,"address":"intent:#Intent;launchFlags=0x4000000;component=com.syby8/.PromotionActivity;i.actid=18;end","cName":"中秋佳节 超低价囤货","cStatus":1,"imgUrl":"http://img.syby8.com/upload/ad/201608231118301830.jpg"},{"UrlClass":2,"address":"intent:#Intent;launchFlags=0x4000000;component=com.syby8/.PromotionActivity;i.actid=16;end","cName":"妹子注意！！夏甩卖","cStatus":1,"imgUrl":"http://img.syby8.com/upload/ad/201607181118375043.jpg"}]
     * searchHotKey : null
     */

    @SerializedName("searchHotKey")
    private Object nullSearchHotKey;


    @SerializedName("adList")
    private List<CarouseDataBean> nullAdList;

    public Object getSearchHotKey() {
        return nullSearchHotKey;
    }

    public void setSearchHotKey(Object searchHotKey) {
        nullSearchHotKey = searchHotKey;
    }

    public List<CarouseDataBean> getAdList() {
        return nullAdList;
    }

    public void setAdList(List<CarouseDataBean> adList) {
        nullAdList = adList;
    }

}
