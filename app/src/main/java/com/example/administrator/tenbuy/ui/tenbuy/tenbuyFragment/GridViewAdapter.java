package com.example.administrator.tenbuy.ui.tenbuy.tenbuyFragment;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.HandpickedDataBean;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/31.
 */
public class GridViewAdapter extends BaseAdapter {
    private List<HandpickedDataBean> mList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;

    public GridViewAdapter(List<HandpickedDataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.gridview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
//        String newPrice = "￥"+mList.get(position).getNewPrice()+"0";
//        newPrice = "￥"+(mList.get(position).getNewPrice()*100/100)+"."+(mList.get(position).getNewPrice()*100)/1%100;
//        String oldPrice =mList.get(position).getOldPrice()+"0" ;
//        String saleTotal ="已售"+ mList.get(position).getSaleTotal()+"件";
        String isBaoYou = "";
        if (mList.get(position).getIsBaoYou()==1){
            isBaoYou = "包邮";
        }else {
            isBaoYou = "不包邮";
        }
        DecimalFormat df   = new DecimalFormat("######0.00");
        String newPrice = mList.get(position).getNewPrice()+"";
        String oldPrice = mList.get(position).getOldPrice()+"";
        String discount = mList.get(position).getDiscount()+"";
        Double n = Double.parseDouble(newPrice);
        Double o = Double.parseDouble(oldPrice);
        Double d = Double.parseDouble(discount);
        String newformat = df.format(n);
        String oldformat = df.format(o);
        String disformat = df.format(d);
        // Glide.with(mContext).load(mList.get(position).getProductUrl()).into(holder.gridviewImage);
         Picasso.with(mContext).load(mList.get(position).getProductImg1()).into(holder.gridviewImage);
        holder.gridviewTextone.setText(mList.get(position).getName());
        holder.gridviewTexttow.setText("¥"+newformat);
        holder.gridviewTextthr.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
        holder.gridviewTextthr.setText(oldformat);
        holder.gridviewTextfor.setText(disformat+"折");
        holder.gridviewTextfive.setText("已售"+mList.get(position).getSaleTotal()+"件");
        holder.gridviewTextsix.setText(isBaoYou);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.gridview_image)
        ImageView gridviewImage;
        @BindView(R.id.gridview_textone)
        TextView gridviewTextone;
        @BindView(R.id.gridview_texttow)
        TextView gridviewTexttow;
        @BindView(R.id.gridview_textthr)
        TextView gridviewTextthr;
        @BindView(R.id.gridview_textfor)
        TextView gridviewTextfor;
        @BindView(R.id.gridview_textfive)
        TextView gridviewTextfive;
        @BindView(R.id.gridview_textsix)
        TextView gridviewTextsix;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
