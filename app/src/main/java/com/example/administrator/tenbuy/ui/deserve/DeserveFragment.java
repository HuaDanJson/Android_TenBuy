package com.example.administrator.tenbuy.ui.deserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseFragment;
import com.example.administrator.tenbuy.bean.RowsBean;
import com.example.administrator.tenbuy.config.UrlConfig;
import com.example.administrator.tenbuy.ui.homepage.ContentAdapter;
import com.example.administrator.tenbuy.ui.homepage.DetailsActivity;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeserveFragment extends BaseFragment implements DeserveContentContract.View {


    @BindView(R.id.tab_deserve)
    TabLayout tabDeserve;
    @BindView(R.id.deserve_grid)
    PullToRefreshGridView deserveGrid;
    private DeserveContentContract.Presenter presenter;
    private String bc = "0";
    private Map<String, String> map;
    private View rootView;
    private Map<Integer,Object> totalist=new HashMap<>();
    private List<RowsBean> rlist;
    @Override
    protected void initData() {
        tabDeserve.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabLayout.Tab tab1 = tabDeserve.newTab().setText("精装");
        tabDeserve.addTab(tab1);
        TabLayout.Tab tab2 = tabDeserve.newTab().setText("女装");
        tabDeserve.addTab(tab2);
        TabLayout.Tab tab3 = tabDeserve.newTab().setText("男装");
        tabDeserve.addTab(tab3);
        TabLayout.Tab tab4 = tabDeserve.newTab().setText("居家");
        tabDeserve.addTab(tab4);
        TabLayout.Tab tab5 = tabDeserve.newTab().setText("母婴");
        tabDeserve.addTab(tab5);
        TabLayout.Tab tab6 = tabDeserve.newTab().setText("鞋包");
        tabDeserve.addTab(tab6);
        TabLayout.Tab tab7 = tabDeserve.newTab().setText("配饰");
        tabDeserve.addTab(tab7);
        TabLayout.Tab tab8 = tabDeserve.newTab().setText("美食");
        tabDeserve.addTab(tab8);
        TabLayout.Tab tab9 = tabDeserve.newTab().setText("数码");
        tabDeserve.addTab(tab9);
        TabLayout.Tab tab10 = tabDeserve.newTab().setText("美妆");
        tabDeserve.addTab(tab10);
        TabLayout.Tab tab11 = tabDeserve.newTab().setText("文体");
        tabDeserve.addTab(tab11);
        presenter = new DeserveContentPresenter(this);
         map= new HashMap();
        map.put(UrlConfig.Key.ACT, "getworth");
        map.put(UrlConfig.Key.PAGES, "1");
        map.put(UrlConfig.Key.BC,bc);
        map.put(UrlConfig.Key.BRANDID,"0");
        map.put(UrlConfig.Key.V,"34");
        presenter.getRows(map);
        presenter = new DeserveContentPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_deserve;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onGetRowsSucess( List<RowsBean> list) {
        rlist=list;
        final ContentAdapter adapter = new ContentAdapter(rlist);
        deserveGrid.setAdapter(adapter);
        deserveGrid.setMode(PullToRefreshBase.Mode.BOTH);
        deserveGrid.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                ILoadingLayout startLabels = deserveGrid.getLoadingLayoutProxy ( ) ;
                startLabels.setPullLabel ( "下拉刷新" ) ; // 刚下拉时，显示的提示
                startLabels.setRefreshingLabel ( "刷新中" ) ; // 刷新时
                startLabels.setReleaseLabel ( "松开刷新" ) ; // 下来达到一定距离时，显示的提示
                startLabels.setLoadingDrawable(getResources().getDrawable(R.drawable.load_refresh));
                deserveGrid.setAdapter(adapter);
                adapter.relodView(rlist,false);
                deserveGrid.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                deserveGrid.setAdapter(adapter);
                adapter.relodView(rlist,false);
                deserveGrid.onRefreshComplete();
            }
        });
        deserveGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(),DetailsActivity.class);
                if (rlist!=null){
                    String web = rlist.get(position).getmSpreadUrl();
                    String name = rlist.get(position).getmName();
                    intent.putExtra("web",web);
                    intent.putExtra("name",name);
                }
                startActivity(intent);
            }
        });
        tabDeserve.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab!=tabDeserve.getTabAt(0)){
                    if(totalist.get(tabDeserve.getSelectedTabPosition())!=null){
                        rlist= (List<RowsBean>) totalist.get(tabDeserve.getSelectedTabPosition());
                        adapter.reloadData(rlist);
                    }else {
                    bc=tabDeserve.getSelectedTabPosition()+"";
                    map.put(UrlConfig.Key.BC,bc);
                    presenter.getRows(map);
                    totalist.put(tabDeserve.getSelectedTabPosition(),rlist);}
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onGetRowsFail(String erro) {
        Toast.makeText(getContext(), erro, Toast.LENGTH_SHORT).show();
    }
}
