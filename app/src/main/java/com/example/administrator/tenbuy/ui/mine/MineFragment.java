package com.example.administrator.tenbuy.ui.mine;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseFragment;
import com.example.administrator.tenbuy.ui.homepage.singnin.SingninActivity;
import com.example.administrator.tenbuy.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineFragment extends BaseFragment {


    @BindView(R.id.mine_Fragment_setting)
    ImageView mineFragmentSetting;
    @BindView(R.id.mine_fragment_perporstyle)
    Button mineFragmentPerporstyle;
    @BindView(R.id.mine_fragment_login)
    Button mineFragmentLogin;
    @BindView(R.id.btn_indent)
    RelativeLayout btnIndent;
    @BindView(R.id.mine_fragment_logistics)
    ImageView mineFragmentLogistics;
    @BindView(R.id.btn_loginstics)
    RelativeLayout btnLoginstics;
    @BindView(R.id.mine_fragment_shop)
    ImageView mineFragmentShop;
    @BindView(R.id.btn_shop)
    RelativeLayout btnShop;
    @BindView(R.id.mine_fragment_collect)
    ImageView mineFragmentCollect;
    @BindView(R.id.btn_collects)
    RelativeLayout btnCollects;
    @BindView(R.id.sign_in)
    ImageView signIn;
    @BindView(R.id.sign_in_text)
    TextView signInText;
    @BindView(R.id.btn_sign)
    RelativeLayout btnSign;
    @BindView(R.id.grade_image)
    ImageView gradeImage;
    @BindView(R.id.btn_grade)
    RelativeLayout btnGrade;
    @BindView(R.id.store_image)
    ImageView storeImage;
    @BindView(R.id.btn_store)
    RelativeLayout btnStore;

    @Override
    protected void initData() {

        }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }


    @OnClick({R.id.mine_Fragment_setting, R.id.mine_fragment_perporstyle, R.id.mine_fragment_login, R.id.btn_indent, R.id.btn_loginstics, R.id.btn_shop, R.id.btn_collects, R.id.btn_sign, R.id.btn_grade, R.id.btn_store})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_Fragment_setting:
                Intent setting=new Intent(getContext(),SettingActivity.class);
                startActivity(setting);
                break;
            case R.id.mine_fragment_perporstyle:
                Intent identity=new Intent(getContext(),IdentityActivity.class);
                startActivityForResult(identity,1 );
                break;
            case R.id.mine_fragment_login:
                Intent login=new Intent(getContext(),LoginActivity.class);
                startActivity(login);
                break;
            case R.id.btn_indent:
                Intent taobao2=new Intent(getContext(),TaoBaoAcitivity.class);
                startActivity(taobao2);
                break;
            case R.id.btn_loginstics:
                Intent taobao1=new Intent(getContext(),TaoBaoAcitivity.class);
                startActivity(taobao1);
                break;
            case R.id.btn_shop:
                Intent taobao3=new Intent(getContext(),TaoBaoAcitivity.class);
                startActivity(taobao3);
                break;
            case R.id.btn_collects:
                Intent taobao4=new Intent(getContext(),TaoBaoAcitivity.class);
                startActivity(taobao4);
                break;
            case R.id.btn_sign:
                Intent intent=new Intent(getContext(),SingninActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_grade:
                //判断是否有登录没有就跳到登录界面，有就跳到积分界面

                break;
            case R.id.btn_store:
                Toast.makeText(getContext(),"不要急.还没开始做",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            String s = data.getStringExtra("1");
            mineFragmentPerporstyle.setText(s);
        }
    }
}
