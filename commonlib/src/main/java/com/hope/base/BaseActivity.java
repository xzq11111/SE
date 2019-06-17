package com.hope.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hope.commonlib.R;

/**
 * @anthor FanHY
 * @time 2018/9/3
 * @describe
 */
public abstract class BaseActivity extends AppCompatActivity {
    private LinearLayout llRoot;
    private ConstraintLayout mClTitle;
    private ImageView ivBack;
    private TextView tvTitle;
    private FrameLayout flBody;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.iv_back) {
                finish();
            } else {
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestNoTitleStyle();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_base);

        initTitle();
        initView();
        initData();
    }

    private void initTitle() {
        llRoot = findViewById(R.id.ll_root);
        mClTitle = findViewById(R.id.cl_title);
        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_title);
        flBody = findViewById(R.id.fl_body);

        ivBack.setOnClickListener(mOnClickListener);

        View bodyView = LayoutInflater.from(this).inflate(setLayoutContentView(), null);
        flBody.addView(bodyView);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    protected abstract int setLayoutContentView();

    protected void requestNoTitleStyle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
//                    calculateStatusColor(Color.WHITE, (int) alphaValue)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected abstract void initView();

    protected abstract void initData();
}
