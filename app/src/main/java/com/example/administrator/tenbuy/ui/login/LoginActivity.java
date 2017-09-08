package com.example.administrator.tenbuy.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by meidou on 2016/9/1.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.textview_register)
    TextView textviewRegister;
    @BindView(R.id.edittext_name)
    EditText edittextName;
    @BindView(R.id.edittext_pass)
    EditText edittextPass;
    @BindView(R.id.button_login)
    Button buttonLogin;
    @BindView(R.id.textview_forget)
    TextView textviewForget;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.image_back, R.id.textview_register, R.id.button_login, R.id.textview_forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.textview_register:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.button_login:
                break;
            case R.id.textview_forget:
                Intent intent1=new Intent(this,FindActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
