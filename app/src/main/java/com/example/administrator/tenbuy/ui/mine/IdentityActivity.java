package com.example.administrator.tenbuy.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by meidou on 2016/9/1.
 */
public class IdentityActivity extends BaseActivity {

    @BindView(R.id.image_girl)
    ImageView imageGirl;
    @BindView(R.id.image_nan)
    ImageView imageNan;
    @BindView(R.id.image_woman)
    ImageView imageWoman;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private String name="";

    @Override
    public int getLayoutId() {
        return R.layout.activity_identity;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.image_girl, R.id.image_nan, R.id.image_woman, R.id.btn_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_girl:
                imageGirl.setImageResource(R.drawable.id_girl_sel_bg);
                imageNan.setImageResource(R.drawable.id_man_nor_bg);
                imageWoman.setImageResource(R.drawable.id_woman_nor_bg);
                name="美女";
                break;
            case R.id.image_nan:
                imageGirl.setImageResource(R.drawable.id_girl_nor_bg);
                imageNan.setImageResource(R.drawable.id_man_sel_bg);
                imageWoman.setImageResource(R.drawable.id_woman_nor_bg);
                name="帅哥";
                break;
            case R.id.image_woman:
                imageGirl.setImageResource(R.drawable.id_girl_nor_bg);
                imageNan.setImageResource(R.drawable.id_man_nor_bg);
                imageWoman.setImageResource(R.drawable.id_woman_sel_bg);
                name="辣妈";
                break;
            case R.id.btn_submit:
                if(name==""){
                    finish();
                }else {
                    Intent intent=new Intent();
                    intent.putExtra("1",name);
                    setResult(2, intent);
                    finish();
                }
                break;
        }
    }
}
