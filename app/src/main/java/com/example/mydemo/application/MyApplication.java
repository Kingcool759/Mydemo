package com.example.mydemo.application;

import android.app.Application;

import com.hjq.toast.ToastUtils;

/**
 * @data on 2020/10/9 11:09 AM
 * @auther
 * @describe
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}
