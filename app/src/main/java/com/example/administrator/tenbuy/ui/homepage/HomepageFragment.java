package com.example.administrator.tenbuy.ui.homepage;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseFragment;
import com.example.administrator.tenbuy.bean.CarouseDataBean;
import com.example.administrator.tenbuy.bean.RowsBean;
import com.example.administrator.tenbuy.bean.TodayBean;
import com.example.administrator.tenbuy.config.UrlConfig;
import com.example.administrator.tenbuy.ui.homepage.search.SearchActivity;
import com.example.administrator.tenbuy.ui.homepage.search.detailsinfo.InfoActivity;
import com.example.administrator.tenbuy.ui.homepage.singnin.SingninActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomepageFragment extends BaseFragment implements HomepageContract.View, HomeContentContract.View, TodayContract.View {

    @BindView(R.id.imageview_search)
    ImageView imageviewSearch;
    @BindView(R.id.imageview_signin)
    ImageView imageviewSignin;
    @BindView(R.id.viewpager_carouse)
    ViewPager viewpagerCarouse;
    @BindView(R.id.linear_frock)
    LinearLayout linearFrock;
    @BindView(R.id.linear_living)
    LinearLayout linearLiving;
    @BindView(R.id.linear_mom)
    LinearLayout linearMom;
    @BindView(R.id.linear_all)
    LinearLayout linearAll;
    @BindView(R.id.gridview_content)
    GridView gridviewContent;
    @BindView(R.id.image_today)
    ImageView imageToday;
    @BindView(R.id.image_phone)
    ImageView imagePhone;
    @BindView(R.id.image_beauty)
    ImageView imageBeauty;
    @BindView(R.id.image_food)
    ImageView imageFood;
    @BindView(R.id.image_last)
    ImageView imageLast;


    private HomepageContract.Presenter presenter;
    private HomeContentContract.Presenter rowspresenter;
    private TodayContract.Presenter todaypresenter;
    List<RowsBean> list;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int index = msg.arg1;

                viewpagerCarouse.setCurrentItem(index);
            }
        }
    };

    @Override
    protected void initData() {
        viewpagerCarouse.requestFocus();
        viewpagerCarouse.setFocusable(true);
        viewpagerCarouse.setFocusableInTouchMode(true);
        presenter = new HomepagePresenter(this);
        Map<String, String> params = new HashMap();
        params.put(UrlConfig.Key.V, UrlConfig.DefaultValue.V);
        presenter.getCarouselImage(params);
        rowspresenter = new HomeContentPresenter(this);
        Map<String, String> map = new HashMap();
        map.put(UrlConfig.Key.ACT, UrlConfig.DefaultValue.ACT);
        map.put(UrlConfig.Key.V, UrlConfig.DefaultValue.V);
        map.put(UrlConfig.Key.PAGES, UrlConfig.DefaultValue.PAGES);
        rowspresenter.getRows(map);
        todaypresenter = new TodayPresenter(this);
        Map<String, String> today = new HashMap();
        today.put(UrlConfig.Key.V, UrlConfig.DefaultValue.V);
        todaypresenter.getToday(today);
        gridviewContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(),DetailsActivity.class);
                if (list!=null){
                    String web = list.get(position).getmSpreadUrl();
                    String name = list.get(position).getmName();
                    intent.putExtra("web",web);
                    intent.putExtra("name",name);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {

        //开始线程任务
        final AutoRunTask autoTask = new AutoRunTask();
        autoTask.startRun();

        //处理ViewPager的触摸事件
        viewpagerCarouse.setOnTouchListener(new View.OnTouchListener()

                                            {
                                                //当触摸屏幕的时候调用
                                                //MotionEvent:手指触摸到屏幕的时候,所触发的一系列的事件.
                                                //down,up,move,cancle.
                                                @Override
                                                public boolean onTouch(View v, MotionEvent event) {
                                                    //当手指触摸到ViewPager的时候,ViewPager的自动跳转会停止;
                                                    //如果手指没有触摸ViewPager,ViewPager的自动跳转又会开始.
                                                    switch (event.getAction()) {
                                                        case MotionEvent.ACTION_DOWN://第一个被执行的事件
                                                            autoTask.stopRun();
                                                            break;
                                                        case MotionEvent.ACTION_CANCEL:
                                                        case MotionEvent.ACTION_UP:
                                                            autoTask.startRun();
                                                            break;
                                                    }

                                                    //此处只能返回false
                                                    return false;
                                                }
                                            }

        );
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_homepage;
    }

    @Override
    public void onGetSucess(List<CarouseDataBean> list) {
        Log.i("sfdsf","sdfdsfs"+list.size());
        //轮播数据
        CarouseAdapter adapter = new CarouseAdapter(list);
        viewpagerCarouse.setAdapter(adapter);
        viewpagerCarouse.setCurrentItem(100 * list.size());
    }

    @Override
    public void onGetFail(String erro) {
        Toast.makeText(getContext(), erro, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetRowsSucess(List<RowsBean> list) {
        this.list=list;
        ContentAdapter adapter = new ContentAdapter(list);
        gridviewContent.setAdapter(adapter);
    }

    @Override
    public void onGetRowsFail(String erro) {
        Toast.makeText(getContext(), erro, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetTodaySucess(List<TodayBean> list) {

        Glide.with(this).load(list.get(0).getImgUrl()).into(imageToday);

        Glide.with(this).load(list.get(1).getImgUrl()).into(imagePhone);

        Glide.with(this).load(list.get(2).getImgUrl()).into(imageBeauty);

        Glide.with(this).load(list.get(3).getImgUrl()).into(imageFood);

        Glide.with(this).load(list.get(4).getImgUrl()).into(imageLast);
    }

    @Override
    public void onGetTodayFail(String erro) {

    }

    @OnClick({R.id.imageview_search, R.id.imageview_signin, R.id.linear_frock, R.id.linear_living, R.id.linear_mom, R.id.linear_all, R.id.image_today, R.id.image_phone, R.id.image_beauty, R.id.image_food, R.id.image_last})
    public void onClick(View view) {
        Intent showIntent=new Intent(getContext(), InfoActivity.class);
        switch (view.getId()) {
            case R.id.imageview_search:
                Intent intent=new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.imageview_signin:
                Intent intent1=new Intent(getContext(), SingninActivity.class);
                startActivity(intent1);
                break;
            case R.id.linear_frock:
                showIntent.putExtra("bj","1");
                showIntent.putExtra("homename","女装");
                startActivity(showIntent);
                break;
            case R.id.linear_living:

                showIntent.putExtra("bj","3");
                showIntent.putExtra("homename","居家");
                startActivity(showIntent);
                break;
            case R.id.linear_mom:

                showIntent.putExtra("bj","5");
                showIntent.putExtra("homename","母婴");
                startActivity(showIntent);
                break;
            case R.id.linear_all:
                Intent allIntent=new Intent(getContext(), SearchActivity.class);
                startActivity(allIntent);
                break;
            case R.id.image_today:
                break;
            case R.id.image_phone:
                break;
            case R.id.image_beauty:
                break;
            case R.id.image_food:
                break;
            case R.id.image_last:
                break;
        }

    }


    //自定跳转的线程任务
    class AutoRunTask implements Runnable {

        private int delayTime = 2000;
        private boolean isStart = false;

        //开始线程任务
        public void startRun() {
            if (!isStart) {
                //关闭之前所有正在执行的任务
                handler.removeCallbacks(this);
                isStart = true;
                handler.postDelayed(this, delayTime);
            }
        }

        //停止线程的方法
        public void stopRun() {
            if (isStart) {
                isStart = false;
                handler.removeCallbacks(this);
            }
        }

        @Override
        public void run() {
            int currentItem = 0;
            if (viewpagerCarouse!=null){
                 currentItem = viewpagerCarouse.getCurrentItem();
            }


            //发送消息
            Message msg = Message.obtain();
            msg.what = 1;
            msg.arg1 = ++currentItem;
            handler.sendMessage(msg);

            //递归调用自身,形成循环.
            handler.postDelayed(this, delayTime);
        }
    }
}
