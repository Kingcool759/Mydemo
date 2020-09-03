package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.example.mydemo.R;

/**
 * @data on 2020/8/25 11:30 AM
 * @auther      ArmStrong
 * @describe  退出应用程序
 */
public class Case2 extends AppCompatActivity {
    private TextView tvEndApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2);
        tvEndApp = findViewById(R.id.end_app);
        tvEndApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert();
            }
        });
    }
    private void alert(){
        new AlertDialog.Builder(Case2.this).setTitle("是否退出应用程序")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作
                        Case2.this.finish();
                        Intent intent = new Intent(Case2.this, LoginActivity.class);//这个地方怎么写要看自己具体情况，我这里是退出当前Activity然后返回到登录界面
                        startActivity(intent);
                    }
                })
                .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“返回”后的操作,这里不设置没有任何操作
                    }
                }).show();
        Looper.loop();
    }
}