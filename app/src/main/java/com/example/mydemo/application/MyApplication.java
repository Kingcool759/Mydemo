package com.example.mydemo.application;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * @data on 2020/10/9 11:09 AM
 * @auther armStrong
 * @describe 自定义Application
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
        //自定义炫酷Logger
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)// (Optional) Whether to show thread info or not. Default true
                .methodCount(5)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("My custom tag")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));  // 初始化Logger
    }
}
