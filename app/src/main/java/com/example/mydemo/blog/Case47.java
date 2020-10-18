package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mydemo.R;
import com.example.mydemo.utils.CountDownTimerUtils;

//获取验证码倒计时功能
public class Case47 extends AppCompatActivity {
    private TextView tvGetNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case47);
        initView();
    }
    private void initView(){
        tvGetNum = findViewById(R.id.tvGetNum);
        tvGetNum.setOnClickListener((View)->{
            CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(tvGetNum, 60000, 1000);
            mCountDownTimerUtils.start();
        });
    }
}