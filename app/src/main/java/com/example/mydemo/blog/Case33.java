package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.RecyclerViewTypeAdapter;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Fruit;
import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.blog33)

public class Case33 extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private List<Fruit> mList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case33);
        initView();
        //RecyclerView瀑布流布局
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewTypeAdapter(mList));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_recyclerView);
        mList = new ArrayList<Fruit>();
        for (int i = 0; i < 21; i++) {
            mList.add(new Fruit("apple" + i, R.mipmap.apple)); //纵向
        }
    }
}