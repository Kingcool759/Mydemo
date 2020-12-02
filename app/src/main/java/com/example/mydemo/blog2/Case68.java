package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.activity.Case68Other;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Movie;

import java.util.ArrayList;

@Route(path = ARouterPath.blog68)
public class Case68 extends AppCompatActivity {
    private Button btnA;
    //定义一个ArrayList并且跳转时传递它
    private ArrayList movieList = new ArrayList<Movie> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case68);
        initView();
        initList();
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToB();
            }
        });
    }

    private void initView() {
        btnA = findViewById(R.id.btnGo);
    }

    private void goToB(){
        Intent intent = new Intent();
        intent.putExtra("key1", "可可托海的牧羊人");
        intent.putParcelableArrayListExtra("key2",movieList);
        intent.setClass(this, Case68Other.class);
        startActivity(intent);
        finish();
    }

    private void initList(){
        movieList.add(new Movie(1,"《金刚川》","100万"));
        movieList.add(new Movie(2,"《疯狂原始人》","200万"));
        movieList.add(new Movie(3,"《一秒钟》","300万"));
        movieList.add(new Movie(4,"《除暴》","400万"));
    }
}