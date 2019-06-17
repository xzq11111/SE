package com.xzq.student.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @anthor FanHY
 * @time 2019/6/17
 * @describe
 */
public class StudentHomePagerAdapter  extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public StudentHomePagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
