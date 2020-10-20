package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;

/**
 * @data on 2020/8/22 11:30 AM
 * @auther
 * @describe 拨打电话
 */

@Route(path = ARouterManager.Path.case1)
public class Case1 extends AppCompatActivity {
    private TextView gotoPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1);
        gotoPhone = findViewById(R.id.goto_phone);
        gotoPhone.setOnClickListener((View v)->call("15226519139"));
    }
    /**
     * 调用拨号界面
     * @param phone 电话号码
     */
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
