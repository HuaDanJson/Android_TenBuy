package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/9/3.
 */
    public  class TowRowBean {
        @SerializedName("Discount")
        private double Discount;
        @SerializedName("Id")
        private String Id;
        @SerializedName("IsBaoYou")
        private String IsBaoYou;
        @SerializedName("IsPromotion")
        private String IsPromotion;
        @SerializedName("Name")
        private String Name;
        @SerializedName("NewPrice")
        private String NewPrice;
        @SerializedName("OldPrice")
        private String OldPrice;
        @SerializedName("PFrom")
        private String PFrom;
        @SerializedName("ProductImg")
        private String ProductImg;
        @SerializedName("ProductImg1")
        private String ProductImg1;
        @SerializedName("ProductImgWX")
        private String ProductImgWX;
        @SerializedName("ProductUrl")
        private String ProductUrl;
        @SerializedName("SaleTotal")
        private String SaleTotal;
        @SerializedName("SpreadUrl")
        private String SpreadUrl;
        @SerializedName("comment")
        private Object comment;
        @SerializedName("commentNickName")
        private Object commentNickName;
        @SerializedName("picHeight")
        private String picHeight;
        @SerializedName("picWidth")
        private String picWidth;


    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIsBaoYou() {
        return IsBaoYou;
    }

    public void setIsBaoYou(String isBaoYou) {
        IsBaoYou = isBaoYou;
    }

    public String getIsPromotion() {
        return IsPromotion;
    }

    public void setIsPromotion(String isPromotion) {
        IsPromotion = isPromotion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNewPrice() {
        return NewPrice;
    }

    public void setNewPrice(String newPrice) {
        NewPrice = newPrice;
    }

    public String getOldPrice() {
        return OldPrice;
    }

    public void setOldPrice(String oldPrice) {
        OldPrice = oldPrice;
    }

    public String getPFrom() {
        return PFrom;
    }

    public void setPFrom(String PFrom) {
        this.PFrom = PFrom;
    }

    public String getProductImg() {
        return ProductImg;
    }

    public void setProductImg(String productImg) {
        ProductImg = productImg;
    }

    public String getProductImg1() {
        return ProductImg1;
    }

    public void setProductImg1(String productImg1) {
        ProductImg1 = productImg1;
    }

    public String getProductImgWX() {
        return ProductImgWX;
    }

    public void setProductImgWX(String productImgWX) {
        ProductImgWX = productImgWX;
    }

    public String getProductUrl() {
        return ProductUrl;
    }

    public void setProductUrl(String productUrl) {
        ProductUrl = productUrl;
    }

    public String getSaleTotal() {
        return SaleTotal;
    }

    public void setSaleTotal(String saleTotal) {
        SaleTotal = saleTotal;
    }

    public String getSpreadUrl() {
        return SpreadUrl;
    }

    public void setSpreadUrl(String spreadUrl) {
        SpreadUrl = spreadUrl;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public Object getCommentNickName() {
        return commentNickName;
    }

    public void setCommentNickName(Object commentNickName) {
        this.commentNickName = commentNickName;
    }

    public String getPicHeight() {
        return picHeight;
    }

    public void setPicHeight(String picHeight) {
        this.picHeight = picHeight;
    }

    public String getPicWidth() {
        return picWidth;
    }

    public void setPicWidth(String picWidth) {
        this.picWidth = picWidth;
    }
}

