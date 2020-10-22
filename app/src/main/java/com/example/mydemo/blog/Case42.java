package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.activity.ActivityB;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

//EventBus事件发布-订阅总线探究
@Route(path = ARouterPath.blog42)

public class Case42 extends AppCompatActivity {
    private Button btnIntent;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case42);
        //EventBus事件发布-订阅总线
        initView();
    }
    private void initView(){
        btnIntent = findViewById(R.id.btnIntent);
        tvMessage = findViewById(R.id.tvMessage);
        tvMessage.setText("千夜零一");
        //注册
        EventBus.getDefault().register(this);
        //点击事件
        btnIntent.setOnClickListener((View)->{
            startActivity(new Intent(this, ActivityB.class));
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)  //事件订阅者
    public void Event(MessageEvent messageEvent){
        tvMessage.setText(messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }
}
