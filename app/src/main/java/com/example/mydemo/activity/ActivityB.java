package com.example.mydemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.mydemo.R;
import com.example.mydemo.entity.MessageEvent;

import org.greenrobot.eventbus.EventBus;

//用作EventBus订阅-发布事件总线实战
public class ActivityB extends AppCompatActivity {
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initView();
    }
    private void initView(){
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener((View)->{
            EventBus.getDefault().post(new MessageEvent("这是我的EventBus演示"));
            finish();
        });
    }
}