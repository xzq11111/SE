package com.xzq.student.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.se.R;
import com.hope.base.BaseLazyFragment;

/**
 * @anthor FanHY
 * @time 2019/6/17
 * @describe
 */
public class NewsFragment extends BaseLazyFragment{
    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.setText("新闻");

        //TODO 自行编写布局
        /*View view = inflater.inflate(R.layout.activity_base,null);
        return  view;*/
        return view;
    }

    @Override
    protected void initData() {

    }
}
