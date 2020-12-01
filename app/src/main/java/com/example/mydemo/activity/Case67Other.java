package com.example.mydemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mydemo.R;
import com.example.mydemo.blog2.Case66;
import com.example.mydemo.blog2.Case67;

public class Case67Other extends AppCompatActivity {
    private Button btnB;
    private TextView tvShowB;

    //传递给A一个信息
    private String Bspeak = "他就是一个微博段子手。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case67_other);
        initView();
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToA();
            }
        });
        showText();
    }

    private void initView() {
        btnB = findViewById(R.id.btn_B);
        tvShowB = findViewById(R.id.showB_view);
    }

    private void goToA(){
        Intent intent = new Intent(this, Case67.class);
        intent.putExtra("speakenB",Bspeak);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    //获取从A传过来的值并展示在按钮下方
    private void showText(){
        Intent intent = getIntent();
        String id = intent.getStringExtra("Id");
        String name = intent.getStringExtra("Name");
        if (id.isEmpty()){
            tvShowB.setText("未接收到的参数：Id,Name");
        }else {
            tvShowB.setText("id:" + id + "name:" + name);
        }
    }
}