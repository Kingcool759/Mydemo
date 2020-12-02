package com.example.mydemo.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mydemo.R;
import com.example.mydemo.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class Case68Other extends AppCompatActivity {
    private TextView tvShowStr;
    private TextView tvShowList;

    private String str;
    private ArrayList<Movie> mList = new ArrayList<Movie> ();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case68_other);
        initView();
        getParameter();
        showText();
    }

    private void initView() {
        tvShowStr = findViewById(R.id.showTvStr);
        tvShowList = findViewById(R.id.showTvList);
    }

    private void getParameter(){
        str = getIntent().getStringExtra("key1");
        mList = getIntent().getParcelableArrayListExtra("key2");
    }

    private void showText(){
        tvShowStr.setText(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (Movie m : mList){
            stringBuilder.append("Id:"+m.getId()+";"+"Name:"+m.getName()+";"+"Record:"+m.getRecord()+"."+"\n");
        }
        tvShowList.setText(stringBuilder);
    }
}