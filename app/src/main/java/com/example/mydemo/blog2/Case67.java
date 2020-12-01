package com.example.mydemo.blog2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.activity.Case67Other;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog67)
public class Case67 extends AppCompatActivity {
    private TextView tvShowA;
    private Button btnA;
    private String userName;
    private String userId;

    //第三人称说的话
    private String speakenB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case67);
        initView();
        userId = "900000000";  //9亿,懂得都懂
        userName = "林更新";
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToB();
            }
        });
    }

    private void initView() {
        tvShowA = findViewById(R.id.showA_view);
        btnA = findViewById(R.id.btn_A);
    }

    //正戏来啦
    private void goToB() {
        Intent intent = new Intent(this, Case67Other.class);
        //第一种：直接使用Intent对象传值
        intent.putExtra("Id", userId);
        intent.putExtra("Name", userName);
//        //第二种：通过Bundle对象传值(更佳)
//        Bundle bundle = new Bundle();
//        bundle.putString("Id",userId);
//        bundle.putString("Name",userName);
//        intent.putExtras(bundle)
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == Activity.RESULT_OK) {
                speakenB = data.getStringExtra("speakenB");
                if (speakenB.isEmpty()) {
                    tvShowA.setText("未接收到信息");
                }else {
                    tvShowA.setText(speakenB);
                }
            }
        }
    }
}