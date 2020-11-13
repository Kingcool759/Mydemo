package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog64)
public class Case64 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case64);


    }
}