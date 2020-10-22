package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog48)
//接入支付宝
public class Case48 extends AppCompatActivity {
    private TextView tvGotoZFB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case48);
        initView();
    }
    private void initView(){
        tvGotoZFB = findViewById(R.id.tvGotoZFB);
        tvGotoZFB.setOnClickListener((View)->{
            startZFB();
        });
    }
    private void startZFB(){

    }
}