package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HandpickedBean {
    @SerializedName("total")
    private int total;
    @SerializedName("totalnew")
    private int totalnew;
    @SerializedName("rows")
    private List<HandpickedDataBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalnew() {
        return totalnew;
    }

    public void setTotalnew(int totalnew) {
        this.totalnew = totalnew;
    }

    public List<HandpickedDataBean> getRows() {
        return rows;
    }

    public void setRows(List<HandpickedDataBean> rows) {
        this.rows = rows;
    }


}
