package com.example.mydemo.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.example.mydemo.R;
import com.example.mydemo.databinding.ActivityCase13Binding;

public class Case13 extends AppCompatActivity {
    private ActivityCase13Binding binding;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_case13);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case13);

        binding.btnOpenLeft.setOnClickListener((View)->{
            binding.drawerLayout.openDrawer(Gravity.START);
        });
        binding.btnOpenRight.setOnClickListener((View)->{
            binding.drawerLayout.openDrawer(Gravity.END);
        });
        binding.btnCloseRight.setOnClickListener((View)->{
            binding.drawerLayout.closeDrawer(Gravity.END);
        });

        //监听事件
        binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                Log.i("---", "滑动中");
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                Log.i("---", "打开");
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                Log.i("---", "关闭");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.i("---", "状态改变");
            }
        });
    }
}