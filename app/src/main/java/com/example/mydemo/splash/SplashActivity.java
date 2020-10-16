package com.example.mydemo.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mydemo.show.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed (new Runnable () {    //匿名内部类  创建线程
            @Override
            public void run() {
                startActivity (new Intent(SplashActivity.this, LoginActivity.class));      //界面转跳
                finish();
            }
        },500);         //第二个参数是停留的时间
    }
}
