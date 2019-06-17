package com;

import android.app.Application;

/**
 * @anthor FanHY
 * @time 2019/6/14
 * @describe
 */
public class UserCaseApplication extends Application {
    private static UserCaseApplication mApplication;

    public static Application getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
}
