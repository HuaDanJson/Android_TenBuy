package com.example.administrator.tenbuy.ui.specialoffer.specialoffers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.SpeciaRowsBean;
import com.example.administrator.tenbuy.ui.specialoffer.secialactivity.SpecialActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/2.
 */
public class SpecialAdapter extends BaseAdapter {
    private List<SpeciaRowsBean> mList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;
    private DecimalFormat df;

    public SpecialAdapter(Context mContext, List<SpeciaRowsBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_specialoffer_pulltorefrsh, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        df = new DecimalFormat(".0");
        final String vvv = df.format(mList.get(position).getDisCount());
        holder.tmOneText.setText(mList.get(position).getName());
        holder.tmPriceDistcount.setText(vvv + "折起");
        String sss = mList.get(position).getProductInfo();
//        String ssss = date2TimeStamp(mList.get(position).getEndDateStr(),"yyyy-MM-dd HH:mm:ss");
//        Date yyy = getNowDate();
//        String ssssss = date2TimeStamp("yyy","yyyy-MM-dd HH:mm:ss");
        //     Long bbb = getDays(ssss,ssssss);
        holder.tmTime.setText("剩" + mList.get(position).getEndDateStr() + "天");
        try {
            JSONArray array = new JSONArray(sss);
            Glide.with(mContext).load(array.getJSONObject(0).get("ProductImg")).into(holder.tmBrandPic1);
            Glide.with(mContext).load(array.getJSONObject(1).get("ProductImg")).into(holder.tmBrandPic2);
            Glide.with(mContext).load(array.getJSONObject(2).get("ProductImg")).into(holder.tmBrandPic3);
            Glide.with(mContext).load("http://www.syby8.com" + mList.get(position).getImgUrlSml()).into(holder.tmOneImg1);
            String ccc = df.format(array.getJSONObject(0).get("disCount"));
            holder.tmProductPrice1.setText("￥" + array.getJSONObject(0).get("oldPrice"));
            holder.tmProductZhe1.setText(ccc + "折");
            holder.tmProductPrice2.setText("￥" + array.getJSONObject(1).get("oldPrice"));
            holder.tmProductZhe2.setText(array.getJSONObject(1).get("disCount") + "折");
            holder.tmProductPrice3.setText("￥" + array.getJSONObject(2).get("oldPrice"));
            holder.tmProductZhe3.setText(array.getJSONObject(2).get("disCount") + "折");
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(mContext, SpecialActivity.class);
                    intent.putExtra("url", "http://www.syby8.com" + mList.get(position).getImgUrlSml());
                    intent.putExtra("xiu", mList.get(position).getName());
                    intent.putExtra("zhe", vvv+ "折起");
                    intent.putExtra("brandid", mList.get(position).getBrandId()+"");
                    mContext.startActivity(intent);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tm_one_img1)
        ImageView tmOneImg1;
        @BindView(R.id.tm_one_text)
        TextView tmOneText;
        @BindView(R.id.tm_time)
        TextView tmTime;
        @BindView(R.id.tm_priceDistcount)
        TextView tmPriceDistcount;
        @BindView(R.id.tm_brand_pic_1)
        ImageView tmBrandPic1;
        @BindView(R.id.tm_productPrice1)
        TextView tmProductPrice1;
        @BindView(R.id.tm_productZhe1)
        TextView tmProductZhe1;
        @BindView(R.id.tm_brand_pic_2)
        ImageView tmBrandPic2;
        @BindView(R.id.tm_productPrice2)
        TextView tmProductPrice2;
        @BindView(R.id.tm_productZhe2)
        TextView tmProductZhe2;
        @BindView(R.id.tm_sale_rpic1)
        RelativeLayout tmSaleRpic1;
        @BindView(R.id.tm_brand_pic_3)
        ImageView tmBrandPic3;
        @BindView(R.id.tm_productPrice3)
        TextView tmProductPrice3;
        @BindView(R.id.tm_productZhe3)
        TextView tmProductZhe3;
        @BindView(R.id.tm_sale_rpic2)
        RelativeLayout tmSaleRpic2;
        @BindView(R.id.brandTab)
        LinearLayout brandTab;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
// 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = null;
        java.util.Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
