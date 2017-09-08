package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/9/2.
 */
public class SpeciaRowsBean {
        @SerializedName("DisCount")
        private double DisCount;
        @SerializedName("EndDate")
        private String EndDate;
        @SerializedName("EndDateStr")
        private String EndDateStr;
        @SerializedName("ImgUrlSml")
        private String ImgUrlSml;
        @SerializedName("Name")
        private String Name;
        @SerializedName("ProductInfo")
        private String ProductInfo;
        @SerializedName("brandId")
        private int brandId;

        public double getDisCount() {
            return DisCount;
        }

        public void setDisCount(double DisCount) {
            this.DisCount = DisCount;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public String getEndDateStr() {
            return EndDateStr;
        }

        public void setEndDateStr(String EndDateStr) {
            this.EndDateStr = EndDateStr;
        }

        public String getImgUrlSml() {
            return ImgUrlSml;
        }

        public void setImgUrlSml(String ImgUrlSml) {
            this.ImgUrlSml = ImgUrlSml;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getProductInfo() {
            return ProductInfo;
        }

        public void setProductInfo(String ProductInfo) {
            this.ProductInfo = ProductInfo;
        }

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }
    }

