package com.zhuangfei.preference_demo;

import android.app.Application;

import com.zhuangfei.preference.LiteMemory;

/**
 * Created by Liu ZhuangFei on 2019/6/1.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LiteMemory.initialize(this);
    }
}
