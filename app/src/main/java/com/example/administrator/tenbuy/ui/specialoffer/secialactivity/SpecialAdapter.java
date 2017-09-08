package com.example.administrator.tenbuy.ui.specialoffer.secialactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.TowRowBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/3.
 */
public class SpecialAdapter extends BaseAdapter {
    private List<TowRowBean> mList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;

    public SpecialAdapter(Context mContext, List<TowRowBean> mList) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.special_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        String isBaoYou = "";
        if (mList.get(position).getIsBaoYou().equals(1)){
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

        Glide.with(mContext).load(mList.get(position).getProductImg()).into(holder.icon);
        holder.titleTextivew.setText(mList.get(position).getName());
        holder.currentPriceTextview.setText("￥"+newformat);
        holder.originalPriceTextview.setText(oldformat);
        holder.discountTextview.setText(disformat+"折");
        holder.fromTextview.setText(isBaoYou);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.title_textivew)
        TextView titleTextivew;
        @BindView(R.id.current_price_textview)
        TextView currentPriceTextview;
        @BindView(R.id.original_price_textview)
        TextView originalPriceTextview;
        @BindView(R.id.discount_textview)
        TextView discountTextview;
        @BindView(R.id.from_textview)
        TextView fromTextview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
