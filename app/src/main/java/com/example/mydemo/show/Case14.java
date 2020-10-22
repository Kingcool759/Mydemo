package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.PublicTabAdapter;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.fragment.HotCollectionFragment;
import com.example.mydemo.fragment.HotRecommendFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.case14)

public class Case14 extends AppCompatActivity {
    private List<Fragment> list_fragment; //定义要装frament的列表
    private List<String> list_title; //tab名称列表
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case14);
        initView();
        //设置Tablayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //为tablayout添加tab名称
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(1)));
        PublicTabAdapter adapter = new PublicTabAdapter(this.getSupportFragmentManager(), list_fragment, list_title);
        //viewpager设置适配器
        viewPager.setAdapter(adapter);
        //tabLayout加载viewpager
        tabLayout.setupWithViewPager(viewPager);
    }

    //初始化
    private void initView(){
        //定义fragment
        HotRecommendFragment hotRecommendFragment = new HotRecommendFragment();
        HotCollectionFragment hotCollectionFragment = new HotCollectionFragment();
        //将fragment装进列表
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        //将名称加载tab列表
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        //控件初始化
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.view_pager);
    }
}


