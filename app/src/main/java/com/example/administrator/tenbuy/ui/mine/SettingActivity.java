package com.example.administrator.tenbuy.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;
import com.example.administrator.tenbuy.utils.DataUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by meidou on 2016/9/1.
 */
public class SettingActivity extends BaseActivity {


    @BindView(R.id.setting_back)
    Button settingBack;
    @BindView(R.id.setting_sweep_image)
    ImageView settingSweepImage;
    @BindView(R.id.setting_sweep)
    RelativeLayout settingSweep;
    @BindView(R.id.Setting_update_image)
    ImageView SettingUpdateImage;
    @BindView(R.id.Setting_update)
    RelativeLayout SettingUpdate;
    @BindView(R.id.setting_aboutus_image)
    ImageView settingAboutusImage;
    @BindView(R.id.setting_aboutus)
    RelativeLayout settingAboutus;
    @BindView(R.id.textview_size)
    TextView textviewSize;


    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        try {
            String size = DataUtils.getTotalCacheSize(this);
            if (size != "0K") {
                textviewSize.setVisibility(View.VISIBLE);
                textviewSize.setText(size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.setting_back, R.id.setting_sweep, R.id.Setting_update, R.id.setting_aboutus})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_back:
                finish();
                break;
            case R.id.setting_sweep:
                    DataUtils.clearAllCache(this);
                try {
                    String size = DataUtils.getTotalCacheSize(this);
                    Logger.v(size);
                    if (size=="0K"){
                        textviewSize.setVisibility(View.INVISIBLE);
                        Toast.makeText(this, "缓存已清理", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.Setting_update:
                Toast.makeText(SettingActivity.this, "已经是最新版本了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_aboutus:
                Intent intent1 = new Intent(SettingActivity.this, AboutActivity.class);
                startActivity(intent1);
                break;
        }
    }

}
