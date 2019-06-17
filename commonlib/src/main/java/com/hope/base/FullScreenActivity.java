package com.hope.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @anthor FanHY
 * @time 2018/9/3
 * @describe
 */
public abstract class FullScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestFullScreen();
        //是否支持横竖屏切换
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(setLayoutContentView());
        initView();
        initData();
    }

    protected abstract int setLayoutContentView();

    protected void requestFullScreen() {
        //hide the status bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hide the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    protected abstract void initView();

    protected abstract void initData();
}
