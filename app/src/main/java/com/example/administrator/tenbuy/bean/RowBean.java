package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

public  class RowBean {
        @SerializedName("DisCount")
        private String nullDisCount;
        @SerializedName("EndDate")
        private String nullEndDate;
        @SerializedName("EndDateStr")
        private String nullEndDateStr;
        @SerializedName("ImgUrlSml")
        private String nullImgUrlSml;
        @SerializedName("Name")
        private String nullName;
        @SerializedName("ProductInfo")
        private String nullProductInfo;
        @SerializedName("brandId")
        private String nullBrandId;

        public String getDisCount() {
            return nullDisCount;
        }

        public void setDisCount(String disCount) {
            nullDisCount = disCount;
        }

        public String getEndDate() {
            return nullEndDate;
        }

        public void setEndDate(String endDate) {
            nullEndDate = endDate;
        }

        public String getEndDateStr() {
            return nullEndDateStr;
        }

        public void setEndDateStr(String endDateStr) {
            nullEndDateStr = endDateStr;
        }

        public String getImgUrlSml() {
            return nullImgUrlSml;
        }

        public void setImgUrlSml(String imgUrlSml) {
            nullImgUrlSml = imgUrlSml;
        }

        public String getName() {
            return nullName;
        }

        public void setName(String name) {
            nullName = name;
        }

        public String getProductInfo() {
            return nullProductInfo;
        }

        public void setProductInfo(String productInfo) {
            nullProductInfo = productInfo;
        }

        public String getBrandId() {
            return nullBrandId;
        }

        public void setBrandId(String brandId) {
            nullBrandId = brandId;
        }
    }