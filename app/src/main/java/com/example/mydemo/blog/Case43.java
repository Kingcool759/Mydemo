package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.activity.ActivityC;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.MessageEvent;
import com.example.mydemo.entity.RxBus;

import java.util.ArrayList;

import rx.Subscription;
import rx.functions.Action1;

//RxBus--EventBus的升级版，可替代EventBus,进行事件发布订阅。
@Route(path = ARouterPath.blog43)

public class Case43 extends AppCompatActivity {
    private Button btnIntentC;
    private TextView tvMessageC;
    private ArrayList<Subscription> rxBusList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case43);
        initView();
    }
    private void initView(){
        btnIntentC = findViewById(R.id.btnIntentC);
        tvMessageC = findViewById(R.id.tvMessageC);
        tvMessageC.setText("千夜零一");
        btnIntentC.setOnClickListener((View)->{
            startActivity(new Intent(this, ActivityC.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        receive();
    }

    private void receive(){
        Subscription subscription = RxBus.getDefault().toObservable(MessageEvent.class)
                .subscribe(new Action1<MessageEvent>() {
                    @Override
                    public void call(MessageEvent messageEvent) {
                        tvMessageC.setText(messageEvent.getMessage());
                    }
                });
        rxBusList.add(subscription);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearSubscription();
    }
    /**
     * 取消该页面所有订阅
     */
    private void clearSubscription() {
        for (Subscription subscription : rxBusList) {  //增强型for循环，遍历rxBusList
            if (subscription != null && subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }
}
