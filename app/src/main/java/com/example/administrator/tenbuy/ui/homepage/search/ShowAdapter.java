package com.example.administrator.tenbuy.ui.homepage.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.bean.ClasslyBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/1.
 */
public class ShowAdapter extends BaseAdapter {
    private List<ClasslyBean> list;

    public ShowAdapter(List<ClasslyBean> list) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textviewName.setText(list.get(position).getName());
        holder.imageShow.setImageResource(list.get(position).getImage());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image_show)
        ImageView imageShow;
        @BindView(R.id.textview_name)
        TextView textviewName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
