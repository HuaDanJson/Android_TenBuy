package com.example.administrator.tenbuy.config;

import retrofit2.http.PUT;

/**
 * Created by Administrator on 2016/8/30.
 */
public class UrlConfig {
    public static class Path{
        public static final String BASE_URL="http://www.syby8.com/";
    }
    public static class ToPath{
        public static final String CAROUSEL="apptools/indexad.aspx";
        public static final String HANDPICKED="apptools/productlist.aspx";
        public static final String ROWS="apptools/productlist.aspx";
        public static final String TODAY="apptools/app.aspx";
        public static final String NEWON="apptools/brandsale.aspx";
    }
     public static class Key{
        public static final String V="v";
         public static final String ACT="act";
         public static final String PAGES="pages";
         public static final String CPAGE="cpage";
         public static final String PAGESIZE="pagesize";
         public static final String BCLASS="bclass";

         public static final String BC="bc";
         public static final String SC="sc";
         public static final String SORTS="sorts";
         public static final String CHANNEL="channel";
         public static final String CKEY="ckey";
         public static final String DAYNEWS="daynews";
         public static final String LPRICE="lprice";
         public static final String HPRICE="hprice";
         public static final String TBCLASS="tbclass";
         public static final String ACTID="actid";
         public static final String BRANDID="brandid";
         public static final String PREDATE="predate";
         public static final String INDEX="index";
     }
    public static class DefaultValue{
        public static final String ACTNEW="brandlist";
        public static final String CPAGE="1";
        public static final String PAGESIZE="20";
        public static final String BCLASS="99";

        public static final String V="34";
        public static final String ACT="getproductlist";
        public static final String PAGES="1";
        public static final String BC="0";
        public static final String SC="0";
        public static final String SORTS="";
        public static final String CHANNEL="0";
        public static final String CKEY="";
        public static final String DAYNEWS="";
        public static final String LPRICE="0";
        public static final String HPRICE="0";
        public static final String TBCLASS="0";
        public static final String ACTID="0";
        public static final String BRANDID="0";
        public static final String PREDATE="2016-08-28+17%3A43%3A19";
        public static final String INDEX="1";
    }
}
