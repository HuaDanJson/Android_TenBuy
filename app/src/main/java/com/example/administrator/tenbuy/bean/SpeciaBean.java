package com.example.administrator.tenbuy.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/9/2.
 */
public class SpeciaBean  {

    @SerializedName("total")
    private String total;
    @SerializedName("rows")
    private List<SpeciaRowsBean> rows;

        public String getTotal() {
        return total;
}

    public void setTotal(String total) {
        this.total = total;
    }

    public List<SpeciaRowsBean> getRows() {
        return rows;
    }

    public void setRows(List<SpeciaRowsBean> rows) {
        this.rows = rows;
    }


}
