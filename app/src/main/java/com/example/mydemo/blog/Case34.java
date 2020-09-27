package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mydemo.R;
import com.example.mydemo.adapter.RecyclerView2TypeAdapter;
import com.example.mydemo.databinding.ActivityCase34Binding;
import com.example.mydemo.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Case34 extends AppCompatActivity {
    private ActivityCase34Binding binding;
    private LinearLayoutManager layoutManager;
    private List<Fruit> mList1;
    private List<Fruit> mList2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case34);
        initView();
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.recycler.setLayoutManager(layoutManager);
        binding.recycler.setAdapter(new RecyclerView2TypeAdapter(this,mList1,mList2));
    }
    private void initView() {
        mList1 = new ArrayList();
        for (int i = 1; i < 7; i++) {
            mList1.add(new Fruit("香蕉" + i, R.mipmap.banana)); //纵向
        }
        mList2 = new ArrayList();
        for (int i = 0; i < 21; i++) {
            mList2.add(new Fruit("芒果" + i, R.mipmap.mangguo)); //纵向
        }
    }
}