package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.mydemo.R;
import com.example.mydemo.adapter.PublicTabAdapter;
import com.example.mydemo.databinding.ActivityCase14Binding;
import com.example.mydemo.fragment.HotCollectionFragment;
import com.example.mydemo.fragment.HotRecommendFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Case14 extends AppCompatActivity {
    //定义
    private PublicTabAdapter adapter;
    private List<Fragment> list_fragment; //定义要装frament的列表
    private List<String> list_title; //tab名称列表
    //定义fragment
    private HotRecommendFragment hotRecommendFragment;
    private HotCollectionFragment hotCollectionFragment;

    private ActivityCase14Binding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case14);
        binding.setLifecycleOwner(this);
        //初始化
        hotRecommendFragment = new HotRecommendFragment();
        hotCollectionFragment = new HotCollectionFragment();
        //将fragment装进列表
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        //将名称加载tab列表
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        //设置Tablayout的模式
        binding.tablayout.setTabMode(TabLayout.MODE_FIXED);
        //为tablayout添加tab名称
        binding.tablayout.addTab(binding.tablayout.newTab().setText(list_title.get(0)));
        binding.tablayout.addTab(binding.tablayout.newTab().setText(list_title.get(1)));
        //绑定适配器
        adapter = new PublicTabAdapter(this.getSupportFragmentManager(),list_fragment,list_title);
        //viewpager加载adapter
        binding.viewPager.setAdapter(adapter);
        //TabLayout加载viewpager
        binding.tablayout.setupWithViewPager(binding.viewPager);

        //点击事件处理 （怎么做）
        binding.tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选择时触发
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选择时触发
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //选中之后再次点击即复选时触发

            }
        });
    }
}


