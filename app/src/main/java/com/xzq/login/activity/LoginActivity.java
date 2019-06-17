package com.xzq.login.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.se.R;
import com.hope.base.BaseActivity;
import com.xzq.config.CommonConfig;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private int roleType;
    private final static String PARAM_ROLE_TYPE = "PARAM_ROLE_TYPE";
    private Button btnLogin;

    public static void startIntent(Context context, int roleType) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(PARAM_ROLE_TYPE, roleType);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        roleType = getIntent().getIntExtra(PARAM_ROLE_TYPE, 1);
        btnLogin = findViewById(R.id.btn_test);

        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test://同理自行编写不同角色的注册页

                //添加校验逻辑，成功后根据roleType跳往不同的首页

                if (roleType == CommonConfig.ROLE_TYPE_ADMIN) {//跳转管理者首页

                } else if (roleType == CommonConfig.ROLE_TYPE_ORGANIZATION) {//跳转组织机构首页

                } else if (roleType == CommonConfig.ROLE_TYPE_STUDENT) {//跳转学生家长首页

                } else if (roleType == CommonConfig.ROLE_TYPE_TEACHER) {//跳转教师首页

                }
                break;
        }
    }
}
