package com.example.mydemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;
import com.example.mydemo.databinding.ActivityLoginBinding;
import com.example.mydemo.main.MainActivity;
import com.example.mydemo.viewmodel.LoginViewModel;

@Route(path = ARouterManager.Path.login)
public class LoginActivity extends AppCompatActivity{

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //databinding+viewmodel
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        //给点击登陆按钮设置点击事件监听器
        binding.btnLogin.setOnClickListener((View v)->{  //lambda表达式写法
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}