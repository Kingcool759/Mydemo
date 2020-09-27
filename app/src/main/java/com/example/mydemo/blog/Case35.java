package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mydemo.R;
import com.example.mydemo.adapter.DividerItemDecoration;
import com.example.mydemo.adapter.RecyclerGridAdapter;
import com.example.mydemo.adapter.RecyclerViewTypeAdapter;
import com.example.mydemo.databinding.ActivityCase35Binding;
import com.example.mydemo.entity.Fruit;
import com.example.mydemo.entity.ImageUrl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Case35 extends AppCompatActivity {
    private ActivityCase35Binding binding;
    private GridLayoutManager layoutManager;
    private List<Integer> mList;
    private List<String> tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_case35);
        initView();
        layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        binding.recycler.setLayoutManager(layoutManager);
        binding.recycler.setAdapter(new RecyclerGridAdapter(this, mList,tvList));
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
    }

    private void initView() {
        mList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            mList.add(R.mipmap.kepu);
            mList.add(R.mipmap.guanggao);
            mList.add(R.mipmap.shenghuo);
            mList.add(R.mipmap.kepu);
        }
        tvList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            tvList.add("#广告");
            tvList.add("#剧情");
            tvList.add("#运动");
            tvList.add("#创意");
        }
    }
}