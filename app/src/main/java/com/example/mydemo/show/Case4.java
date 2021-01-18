package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
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
//        viewModel.getMyString().observe(this, s -> Log.e("onChanged: 值有变化=",s));
        //LiveData与Observer的区别
        //LiveData是每次赋值就触发监听；而Observer是只有当数据发生改变时才触发监听。
        viewModel.myLiveDataString.observe(this, s -> {
            Log.d( "onCreate: ","LiveData监听触发");
        });
        viewModel.myObserString.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("onPropertyChanged: ","Observer监听触发");
            }
        });

        binding.btnTest.setOnClickListener((View v)->{
            viewModel.setLiveDataString("1");
            viewModel.setMyObserString("1");
        });
    }
}
