package com.xzq.student.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.se.R;
import com.hope.base.BaseActivity;
import com.xzq.student.adapter.StudentHomePagerAdapter;
import com.xzq.student.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class StudentHomeActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private StudentHomePagerAdapter mHomePagerAdapter;
    private List<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutContentView() {
        return R.layout.activity_student_home;
    }

    @Override
    protected void initView() {
        mTabLayout = findViewById(R.id.tl_home);
        mViewPager = findViewById(R.id.vp_home);
    }

    @Override
    protected void initData() {
        //自行替换相应fragment和图标
        Fragment newsFragment = new NewsFragment();
        Fragment courseFragment = new NewsFragment();
        Fragment mineFragment = new NewsFragment();
        fragmentList.add(newsFragment);
        fragmentList.add(courseFragment);
        fragmentList.add(mineFragment);

        mHomePagerAdapter = new StudentHomePagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(mHomePagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab());//.setText("xw").setIcon(getResources().getDrawable(R.mipmap.ic_launcher))
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("xw").setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(1).setText("xw").setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(2).setText("xw").setIcon(R.mipmap.ic_launcher);
    }
}
