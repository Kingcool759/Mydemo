package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.FruitRecyclerViewAdapter;
import com.example.mydemo.adapter.ShequRecyclerAdapter;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.blog56)
public class Case56 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ShequRecyclerAdapter adapter;
    private StaggeredGridLayoutManager layoutManager;
    private List<Fruit> mList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case56);
        initView();
        setData();
        setRecycler();
    }

    private void setData() {
        //RecyclerView
        mList.add(new Fruit("千夜零一", R.drawable.meizi));
        mList.add(new Fruit("RecylerView实现瀑布流布局StaggeredGridLayoutManager使用", R.drawable.meizi2));
        mList.add(new Fruit("RecylerView实现瀑布流布局", R.drawable.meizi));
        mList.add(new Fruit("RecylerView实现瀑布流布局StaggeredGridLayoutManager使用RecylerView实现瀑布流布局StaggeredGridLayoutManager使用RecylerView实现瀑布流布局StaggeredGridLayoutManager使用", R.drawable.meizi2));
        mList.add(new Fruit("RecylerView", R.drawable.meizi));
        mList.add(new Fruit("千夜零一千夜零一千夜零一千夜零一千夜零一", R.drawable.meizi2));
        mList.add(new Fruit("千夜", R.drawable.meizi2));

    }


    private void setRecycler() {
        adapter = new ShequRecyclerAdapter(mList);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); //每行两个瀑布流排列
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initView() {
        recyclerView = findViewById(R.id.case56_rv);
    }
}
