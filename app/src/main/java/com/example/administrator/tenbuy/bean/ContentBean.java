package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class ContentBean {


    @SerializedName("total")
    private int nullTotal;
    @SerializedName("totalnew")
    private int nullTotalnew;

    @SerializedName("rows")
    private List<RowsBean> nullRows;

    public int getTotal() {
        return nullTotal;
    }

    public void setTotal(int total) {
        nullTotal = total;
    }

    public int getTotalnew() {
        return nullTotalnew;
    }

    public void setTotalnew(int totalnew) {
        nullTotalnew = totalnew;
    }

    public List<RowsBean> getRows() {
        return nullRows;
    }

    public void setRows(List<RowsBean> rows) {
        nullRows = rows;
    }


}
