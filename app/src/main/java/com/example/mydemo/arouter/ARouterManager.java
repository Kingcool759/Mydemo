package com.example.mydemo.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mydemo.BuildConfig;

/**
 * @data on 2020/9/9 12:18 PM
 * @auther  ArmStrong
 * @describe  路由跳转框架管理
 */
public class ARouterManager {
    public static class Path {
        public static final String ARouter_B = "/ArmStrong/hello_ARouter";

    }

    /**
     * 初始化路由框架
     * @param application
     */
    public static void initRouter(Application application) {
        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openDebug();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openLog();
        }
        ARouter.init(application);
    }
}
