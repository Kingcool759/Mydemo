package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.singleton.SingletonDCL;

@Route(path = ARouterPath.blog80)
public class Case80 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case80);
//        SingletonDCL singletonDCL = new SingletonDCL();
//        SingletonDCL.getInstance();
    }
}