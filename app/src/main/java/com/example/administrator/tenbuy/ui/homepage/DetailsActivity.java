package com.example.administrator.tenbuy.ui.homepage;

import android.content.Intent;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.imageview_back)
    ImageView imageviewBack;
    @BindView(R.id.imageview_share)
    ImageView imageviewShare;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.title_textview)
    TextView titleTextview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String web = intent.getStringExtra("web");
        String name = intent.getStringExtra("name");
        if (web != null && name != null) {
            titleTextview.setText(name);
            webview.loadUrl(web);
            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
            webview.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // TODO Auto-generated method stub
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });

        }
    }

    @Override
    public void initData() {

    }


}
