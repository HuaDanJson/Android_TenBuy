package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public class TowBean {
    @SerializedName("total")
    private String total;
    @SerializedName("totalnew")
    private String totalnew;
    @SerializedName("rows")
    private List<TowRowBean> rows;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalnew() {
        return totalnew;
    }

    public void setTotalnew(String totalnew) {
        this.totalnew = totalnew;
    }

    public List<TowRowBean> getRows() {
        return rows;
    }

    public void setRows(List<TowRowBean> rows) {
        this.rows = rows;
    }


}
