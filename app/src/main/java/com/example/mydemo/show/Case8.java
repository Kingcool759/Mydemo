package com.example.mydemo.show;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mydemo.R;
import com.example.mydemo.adapter.BannerViewPagerAdapter;
import com.example.mydemo.entity.ImageUrl;

import java.util.ArrayList;
import java.util.List;

//viewpager使用实现轮播图
public class Case8 extends AppCompatActivity {
    private ViewPager viewPager;
    private BannerViewPagerAdapter bannerAdapter;
    private ArrayList<View> pageviewList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case8);

        viewPager = findViewById(R.id.view_pager);

        //查找布局文件用LayoutInflater.inflate
        LayoutInflater inflater =getLayoutInflater();
        View view1 = inflater.inflate(R.layout.viewpager_view_item1, null);
        View view2 = inflater.inflate(R.layout.viewpager_view_item2, null);
        View view3 = inflater.inflate(R.layout.viewpager_view_item3, null);


        //将view装入数组
        pageviewList = new ArrayList<View>();
        pageviewList.add(view1);
        pageviewList.add(view2);
        pageviewList.add(view3);

        //绑定适配器
        bannerAdapter = new BannerViewPagerAdapter(pageviewList);
        viewPager.setAdapter(bannerAdapter);
    }
}