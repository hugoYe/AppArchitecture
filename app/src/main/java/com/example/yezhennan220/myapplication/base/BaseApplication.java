package com.example.yezhennan220.myapplication.base;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Class description
 *
 * @author YEZHENNAN220
 * @date 2016-08-08 11:22
 */
public class BaseApplication extends Application {

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        mRefWatcher = LeakCanary.install(this);
    }
}
