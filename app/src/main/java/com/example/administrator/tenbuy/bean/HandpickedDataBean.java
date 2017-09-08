package com.example.administrator.tenbuy.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HandpickedDataBean implements Parcelable {
        @SerializedName("Discount")
        private double Discount;
        @SerializedName("Id")
        private int Id;
        @SerializedName("IsBaoYou")
        private int IsBaoYou;
        @SerializedName("IsPromotion")
        private int IsPromotion;
        @SerializedName("Name")
        private String Name;
        @SerializedName("NewPrice")
        private double NewPrice;
        @SerializedName("OldPrice")
        private double OldPrice;
        @SerializedName("PFrom")
        private int PFrom;
        @SerializedName("ProductImg")
        private String ProductImg;
        @SerializedName("ProductImg1")
        private String ProductImg1;
        @SerializedName("ProductImgWX")
        private String ProductImgWX;
        @SerializedName("ProductUrl")
        private String ProductUrl;
        @SerializedName("SaleTotal")
        private int SaleTotal;
        @SerializedName("SpreadUrl")
        private String SpreadUrl;
        @SerializedName("comment")
        private Object comment;
        @SerializedName("commentNickName")
        private Object commentNickName;
        @SerializedName("picHeight")
        private int picHeight;
        @SerializedName("picWidth")
        private int picWidth;

        public double getDiscount() {
            return Discount;
        }

        public void setDiscount(int Discount) {
            this.Discount = Discount;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getIsBaoYou() {
            return IsBaoYou;
        }

        public void setIsBaoYou(int IsBaoYou) {
            this.IsBaoYou = IsBaoYou;
        }

        public int getIsPromotion() {
            return IsPromotion;
        }

        public void setIsPromotion(int IsPromotion) {
            this.IsPromotion = IsPromotion;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public double getNewPrice() {
            return NewPrice;
        }

        public void setNewPrice(int NewPrice) {
            this.NewPrice = NewPrice;
        }

        public double getOldPrice() {
            return OldPrice;
        }

        public void setOldPrice(int OldPrice) {
            this.OldPrice = OldPrice;
        }

        public int getPFrom() {
            return PFrom;
        }

        public void setPFrom(int PFrom) {
            this.PFrom = PFrom;
        }

        public String getProductImg() {
            return ProductImg;
        }

        public void setProductImg(String ProductImg) {
            this.ProductImg = ProductImg;
        }

        public String getProductImg1() {
            return ProductImg1;
        }

        public void setProductImg1(String ProductImg1) {
            this.ProductImg1 = ProductImg1;
        }

        public String getProductImgWX() {
            return ProductImgWX;
        }

        public void setProductImgWX(String ProductImgWX) {
            this.ProductImgWX = ProductImgWX;
        }

        public String getProductUrl() {
            return ProductUrl;
        }

        public void setProductUrl(String ProductUrl) {
            this.ProductUrl = ProductUrl;
        }

        public int getSaleTotal() {
            return SaleTotal;
        }

        public void setSaleTotal(int SaleTotal) {
            this.SaleTotal = SaleTotal;
        }

        public String getSpreadUrl() {
            return SpreadUrl;
        }

        public void setSpreadUrl(String SpreadUrl) {
            this.SpreadUrl = SpreadUrl;
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

        public int getPicHeight() {
            return picHeight;
        }

        public void setPicHeight(int picHeight) {
            this.picHeight = picHeight;
        }

        public int getPicWidth() {
            return picWidth;
        }

        public void setPicWidth(int picWidth) {
            this.picWidth = picWidth;
        }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.Discount);
        dest.writeInt(this.Id);
        dest.writeInt(this.IsBaoYou);
        dest.writeInt(this.IsPromotion);
        dest.writeString(this.Name);
        dest.writeDouble(this.NewPrice);
        dest.writeDouble(this.OldPrice);
        dest.writeInt(this.PFrom);
        dest.writeString(this.ProductImg);
        dest.writeString(this.ProductImg1);
        dest.writeString(this.ProductImgWX);
        dest.writeString(this.ProductUrl);
        dest.writeInt(this.SaleTotal);
        dest.writeString(this.SpreadUrl);
        dest.writeParcelable((Parcelable) this.comment, flags);
        dest.writeParcelable((Parcelable) this.commentNickName, flags);
        dest.writeInt(this.picHeight);
        dest.writeInt(this.picWidth);
    }

    public HandpickedDataBean() {
    }

    protected HandpickedDataBean(Parcel in) {
        this.Discount = in.readDouble();
        this.Id = in.readInt();
        this.IsBaoYou = in.readInt();
        this.IsPromotion = in.readInt();
        this.Name = in.readString();
        this.NewPrice = in.readDouble();
        this.OldPrice = in.readDouble();
        this.PFrom = in.readInt();
        this.ProductImg = in.readString();
        this.ProductImg1 = in.readString();
        this.ProductImgWX = in.readString();
        this.ProductUrl = in.readString();
        this.SaleTotal = in.readInt();
        this.SpreadUrl = in.readString();
        this.comment = in.readParcelable(Object.class.getClassLoader());
        this.commentNickName = in.readParcelable(Object.class.getClassLoader());
        this.picHeight = in.readInt();
        this.picWidth = in.readInt();
    }

    public static final Parcelable.Creator<HandpickedDataBean> CREATOR = new Parcelable.Creator<HandpickedDataBean>() {
        @Override
        public HandpickedDataBean createFromParcel(Parcel source) {
            return new HandpickedDataBean(source);
        }

        @Override
        public HandpickedDataBean[] newArray(int size) {
            return new HandpickedDataBean[size];
        }
    };
}

