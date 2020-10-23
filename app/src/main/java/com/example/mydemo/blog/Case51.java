package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.google.android.material.snackbar.Snackbar;
import com.hjq.toast.ToastUtils;

@Route(path = ARouterPath.blog51)
//悬浮按钮+可交互提示
public class Case51 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case51);
        findViewById(R.id.floatingActionBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ToastUtils.show("发布消息");    //用户不可交互
                Snackbar.make(v,"删除数据",Snackbar.LENGTH_SHORT).setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.show("取消");
                    }
                }).show();
            }
        });
    }
}
