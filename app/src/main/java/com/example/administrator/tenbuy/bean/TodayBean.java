package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/31.
 */
public class TodayBean {
    /**
     * AId : 1
     * Name : 今日更新
     * UrlAddress : intent:#Intent;launchFlags=0x4000000;component=com.syby8/.product_list;i.daynews=1;end
     * UrlClass : 2
     * imgUrl : http://img.syby8.com/upload/index/201510281446469246.png
     */

    @SerializedName("AId")
    private String aId;
    @SerializedName("Name")
    private String name;
    @SerializedName("UrlAddress")
    private String urlAddress;
    @SerializedName("UrlClass")
    private String urlClass;
    @SerializedName("imgUrl")
    private String imgUrl;

    public TodayBean(String aId, String name, String urlAddress, String urlClass, String imgUrl) {
        this.aId = aId;
        this.name = name;
        this.urlAddress = urlAddress;
        this.urlClass = urlClass;
        this.imgUrl = imgUrl;
    }

    public String getAId() {
        return aId;
    }

    public void setAId(String aId) {
        this.aId = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getUrlClass() {
        return urlClass;
    }

    public void setUrlClass(String urlClass) {
        this.urlClass = urlClass;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
