package com.example.mydemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.mydemo.R;
import com.example.mydemo.entity.MessageEvent;
import com.example.mydemo.entity.RxBus;

//用于RxBus实现发布-订阅事件总线，替代EventBus
public class ActivityC extends AppCompatActivity {
    private Button btnSendMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        initView();
    }
    private void initView(){
        btnSendMes = findViewById(R.id.btnSendMes);
        btnSendMes.setOnClickListener((View)->{
            RxBus.getDefault().post(new MessageEvent("接收到了RxBus发布的事件"));
            finish();
        });
    }
}