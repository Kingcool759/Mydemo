package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;

@Route(path = ARouterManager.Path.case18)
public class Case18 extends AppCompatActivity {
    @Autowired(name = "zhangsan")   //获取ARouter传过来值需要使用的注解
    String key1;
    @Autowired(name = "lisi")   //获取ARouter传过来值需要使用的注解
    String key2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case18);
        ARouter.getInstance().inject(this); //接收数据
        Toast.makeText(this,key1+key2,Toast.LENGTH_SHORT).show();
    }
}