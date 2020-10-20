package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.DividerItemDecoration;
import com.example.mydemo.adapter.FruitRecyclerViewAdapter;
import com.example.mydemo.adapter.TimeLineItemDecoration;
import com.example.mydemo.arouter.ARouterManager;
import com.example.mydemo.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterManager.Path.case21)


public class Case21 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FruitRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case21);
        mRecyclerView = findViewById(R.id.recyclerView);

        //RecyclerView填充数据
        List<Fruit> mList = new ArrayList();
        for ( int i=1 ; i<20 ; i++){
            mList.add(new Fruit("apple"+i,R.mipmap.apple));
        }

        //瀑布流布局
        adapter = new FruitRecyclerViewAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this)); //item分割线
        mRecyclerView.addItemDecoration(new TimeLineItemDecoration(this)); //time时间轴
    }
}

