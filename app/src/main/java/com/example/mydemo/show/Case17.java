package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;

@Route(path = ARouterManager.Path.case17)

public class Case17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case17);
        //路由初始化调用，传入参数为Application
//        ARouterManager.initRouter(getApplication());  //在application中进行
        //跳转界面+传递数据
//        ARouter.getInstance().build(ARouterManager.Path.ARouter_B).navigation(); //不带数据
        ARouter.getInstance()
                .build(ARouterManager.Path.case18)
                .withString("zhangsan","我是张三")
                .withString("lisi","我是李四")
                .navigation();
    }
}