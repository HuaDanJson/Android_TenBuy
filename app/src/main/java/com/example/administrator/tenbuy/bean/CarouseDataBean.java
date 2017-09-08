package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

public  class CarouseDataBean {
    /**
     * UrlClass : 2
     * address : intent:#Intent;launchFlags=0x4000000;component=com.syby8/.PromotionActivity;i.actid=11;end
     * cName : 氧气女神爱运动
     * cStatus : 1
     * imgUrl : http://img.syby8.com/upload/ad/201608171218389580.jpg
     */
        @SerializedName("UrlClass")
        private int nullUrlClass;
        @SerializedName("address")
        private String nullAddress;
        @SerializedName("cName")
        private String nullCName;
        @SerializedName("cStatus")
        private int nullCStatus;
        @SerializedName("imgUrl")
        private String nullImgUrl;

        public int getUrlClass() {
            return nullUrlClass;
        }

        public void setUrlClass(int urlClass) {
            nullUrlClass = urlClass;
        }

        public String getAddress() {
            return nullAddress;
        }

        public void setAddress(String address) {
            nullAddress = address;
        }

        public String getCName() {
            return nullCName;
        }

        public void setCName(String cName) {
            nullCName = cName;
        }

        public int getCStatus() {
            return nullCStatus;
        }

        public void setCStatus(int cStatus) {
            nullCStatus = cStatus;
        }

        public String getImgUrl() {
            return nullImgUrl;
        }

        public void setImgUrl(String imgUrl) {
            nullImgUrl = imgUrl;
        }
    }