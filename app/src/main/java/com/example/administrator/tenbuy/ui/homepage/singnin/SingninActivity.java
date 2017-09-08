package com.example.administrator.tenbuy.ui.homepage.singnin;

import android.app.AlertDialog;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tenbuy.R;
import com.example.administrator.tenbuy.base.BaseActivity;
import com.example.administrator.tenbuy.ui.homepage.explain.ExplainActivity;
import com.orhanobut.logger.Logger;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingninActivity extends BaseActivity {


    @BindView(R.id.imageview_back)
    ImageView imageviewBack;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textview_integral)
    TextView textviewIntegral;
    @BindView(R.id.textview_cost)
    TextView textviewCost;
    @BindView(R.id.textview_hint)
    TextView textviewHint;
    @BindView(R.id.button_sign)
    Button buttonSign;
    @BindView(R.id.calendar)
    MaterialCalendarView calendar;
    @BindView(R.id.textview_rule)
    TextView textviewRule;
    @BindView(R.id.textview_explain)
    TextView textviewExplain;
    @BindView(R.id.relative_login)
    RelativeLayout relativeLogin;
    @BindView(R.id.relative_invite)
    RelativeLayout relativeInvite;
    @BindView(R.id.relative_friday)
    RelativeLayout relativeFriday;

    @Override
    public int getLayoutId() {
        return R.layout.activity_singnin;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.button_sign, R.id.textview_rule, R.id.textview_explain, R.id.relative_login, R.id.relative_invite, R.id.relative_friday,R.id.imageview_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_back:
                finish();
                break;
            case R.id.button_sign:
                break;
            case R.id.textview_rule:
                final AlertDialog.Builder builder=new AlertDialog.Builder(this);
                View rule = getLayoutInflater().inflate(R.layout.rule_layout, null);
                ImageView close= (ImageView) rule.findViewById(R.id.image_close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SingninActivity.this, "白点", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setView(rule);
                builder.show();
                break;
            case R.id.textview_explain:
                Intent intent=new Intent(this, ExplainActivity.class);
                startActivity(intent);
                break;
            case R.id.relative_login:
                break;
            case R.id.relative_invite:
                break;
            case R.id.relative_friday:
                break;
        }
    }


}
