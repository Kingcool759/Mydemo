package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mydemo.R;
import com.example.mydemo.adapter.DividerItemDecoration;
import com.example.mydemo.adapter.FruitHorRecyclerVIewAdapter;
import com.example.mydemo.adapter.FruitRecyclerViewAdapter;
import com.example.mydemo.adapter.RecyclerViewTypeAdapter;
import com.example.mydemo.adapter.TimeLineItemDecoration;
import com.example.mydemo.databinding.ActivityCase33Binding;
import com.example.mydemo.databinding.ActivityCase7Binding;
import com.example.mydemo.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Case33 extends AppCompatActivity {
    private ActivityCase33Binding binding;
    private RecyclerViewTypeAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<Fruit> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_case33);
        binding.setLifecycleOwner(this);
        initView();
        //RecyclerView瀑布流布局
        adapter = new RecyclerViewTypeAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rvRecyclerView.setLayoutManager(layoutManager);
        binding.rvRecyclerView.setAdapter(adapter);
        binding.rvRecyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.rvRecyclerView.addItemDecoration(new DividerItemDecoration(this)); //item分割线
        binding.rvRecyclerView.addItemDecoration(new TimeLineItemDecoration(this)); //时间轴效果
    }

    private void initView() {
        mList = new ArrayList();
        for (int i = 0; i < 21; i++) {
            mList.add(new Fruit("banana" + i, R.mipmap.apple)); //纵向
        }
    }


}