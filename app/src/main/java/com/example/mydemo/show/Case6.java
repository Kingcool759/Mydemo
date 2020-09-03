package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mydemo.R;
import com.example.mydemo.observe.MyLifeCycleObserver;

//lifecycle使用
public class Case6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case6);
        //绑定
        getLifecycle().addObserver(new MyLifeCycleObserver());
    }
}
