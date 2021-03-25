package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog78)
public class Case78 extends AppCompatActivity {

    Button btnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case78);

        /**
         * Binder进程间通信
         * 原理：Binder使用C/S模式，也就是S(Server)端提供服务入口，C(Client)调用服务提供的接口，进而两者可以进行通信。
         *
         * 本例中：通过APP调起手机系统的震动服务
         * APP进程  -->>  Client
         * system_service -->> Server
         *
         *
         * Android系统启动后会开启名为：system_server的进程，顾名思义：系统服务，提供给所有App使用的公共服务进程。
         * 当我们调用Context中的getSystemService（xx）方法的时候，相当于App进程与system_service（服务提供进程）进行了一次IPC过程
         * 简单来说，通过ServiceManager获取Binder，该Binder连接system_server，ServiceManager跑在另外的进程里)。
         * 参考文章：
         * https://mp.weixin.qq.com/s/y2Qx9vwSpJIVItWLgxU1qg
         */
        btnBinder = findViewById(R.id.btnBinder);
        btnBinder.setOnClickListener((View)->{
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
        });
    }
}