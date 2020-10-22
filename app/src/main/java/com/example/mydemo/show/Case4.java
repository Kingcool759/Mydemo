package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.databinding.ActivityCase4Binding;
import com.example.mydemo.viewmodel.Case4viewModel;

/**
 * @data
 * @auther ArmStrong
 * @describe MutableLiveData的使用
 */

@Route(path = ARouterPath.case4)
public class Case4 extends AppCompatActivity {

    private Case4viewModel viewModel;
    private ActivityCase4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //databinding+viewmodel
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case4);
        viewModel = ViewModelProviders.of(this).get(Case4viewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        //注册观察者
        viewModel.getMyString().observe(this, s -> Log.e("onChanged: 值有变化=",s));

        binding.btnTest.setOnClickListener((View v)->{
            viewModel.setMyString("测试");
        });
    }
}
