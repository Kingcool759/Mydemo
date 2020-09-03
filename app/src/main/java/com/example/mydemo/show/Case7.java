package com.example.mydemo.show;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.mydemo.R;
import com.example.mydemo.adapter.DividerItemDecoration;
import com.example.mydemo.adapter.FruitHorRecyclerVIewAdapter;
import com.example.mydemo.adapter.FruitRecyclerViewAdapter;
import com.example.mydemo.adapter.TimeLineItemDecoration;
import com.example.mydemo.databinding.ActivityCase7Binding;
import com.example.mydemo.entity.Fruit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Case7 extends AppCompatActivity {
    private ActivityCase7Binding binding;

    private FruitHorRecyclerVIewAdapter adapter0;
    private FruitRecyclerViewAdapter adapter;

    private LinearLayoutManager layoutManager0;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case7);
        binding.setLifecycleOwner(this);

        //RecyclerView
        List<Fruit> mList = new ArrayList();
        for ( int i=1 ; i<20 ; i++){
            mList.add(new Fruit("apple"+i,R.mipmap.apple));
        }

        //横向滚动
        adapter0 = new FruitHorRecyclerVIewAdapter(mList);
        layoutManager0 = new LinearLayoutManager(this);
        layoutManager0.setOrientation(RecyclerView.HORIZONTAL);
        binding.recyclerViewHor.setLayoutManager(layoutManager0);
        binding.recyclerViewHor.setAdapter(adapter0);
        binding.recyclerViewHor.setItemAnimator(new DefaultItemAnimator());


        //瀑布流布局
        adapter = new FruitRecyclerViewAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rvRecyclerView.setLayoutManager(layoutManager);
        binding.rvRecyclerView.setAdapter(adapter);
        binding.rvRecyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.rvRecyclerView.addItemDecoration(new DividerItemDecoration(this)); //item分割线
        binding.rvRecyclerView.addItemDecoration(new TimeLineItemDecoration(this)); //时间轴效果
    }
}
