package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mydemo.R;
import com.example.mydemo.databinding.ActivityCase19Binding;
import com.example.mydemo.databinding.ActivityCase19BindingImpl;
import com.example.mydemo.databinding.ActivityCase3BindingImpl;

public class Case19 extends AppCompatActivity {
    private ActivityCase19Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_case19); //默认布局
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case19);
        binding.tvDataBindingShow.setText("我是千夜零一，期待你的关注！");
    }
}
