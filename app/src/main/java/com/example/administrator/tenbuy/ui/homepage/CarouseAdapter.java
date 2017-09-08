package com.example.administrator.tenbuy.ui.homepage;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.tenbuy.bean.CarouseDataBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class CarouseAdapter extends PagerAdapter {
    private List<CarouseDataBean> list;

    public CarouseAdapter(List<CarouseDataBean> list) {
        this.list = list;
    }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        ImageView iv = new ImageView(container.getContext());
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(container.getContext()).load(list.get(position % list.size()).getImgUrl()).into(iv);
        container.addView(iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
