package com.example.administrator.tenbuy.ui.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.RowsBean;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/30.
 */
public class ContentAdapter extends BaseAdapter {
    private List<RowsBean> list;

    public ContentAdapter(List<RowsBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }
        DecimalFormat df   = new DecimalFormat("######0.00");
        String newPrice = list.get(position).getmNewPrice();
        String oldPrice = list.get(position).getmOldPrice();
        String discount = list.get(position).getmDiscount();
        Double n = Double.parseDouble(newPrice);
        Double o = Double.parseDouble(oldPrice);
        Double d = Double.parseDouble(discount);
        String newformat = df.format(n);
        String oldformat = df.format(o);
        String disformat = df.format(d);

        holder.titleTextivew.setText(list.get(position).getmName());
        holder.currentPriceTextview.setText("¥"+newformat);
        holder.originalPriceTextview.setText(oldformat);
        holder.sellTextview.setText("已售出"+list.get(position).getmSaleTotal()+"件");
        holder.discountTextview.setText(disformat+"折");
        Glide.with(parent.getContext()).load(list.get(position).getmProductImg()).into(holder.icon);
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
        @BindView(R.id.sell_textview)
        TextView sellTextview;
        @BindView(R.id.from_textview)
        TextView fromTextview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    public void relodView(List<RowsBean> totalistlist,boolean isClear){
        if (isClear){
            list.clear();
        }
        list.addAll(list);
        notifyDataSetChanged();
    }
    public void reloadData(List<RowsBean> totalistlist) {

        list=totalistlist;
        notifyDataSetChanged();
    }

}
