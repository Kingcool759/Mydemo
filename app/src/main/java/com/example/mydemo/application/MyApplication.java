package com.example.mydemo.application;

import android.app.Application;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mydemo.BuildConfig;
import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * @data on 2020/10/9 11:09 AM
 * @auther
 * @describe
 */
public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //ToastUtils第三方库初始化
        ToastUtils.init(this);
        //解决65536问题
        MultiDex.install(this); //必须
        //路由初始化
        ARouter.init(this);
        //炫酷Logger

//        Logger.addLogAdapter(new AndroidLogAdapter());  // 初始化Logger
//        Logger.d("debug");
//        Logger.e("error");
//        Logger.w("warning");
//        Logger.v("verbose");
//        Logger.i("information");
//        Logger.wtf("wtf!!!!");

    }
}
