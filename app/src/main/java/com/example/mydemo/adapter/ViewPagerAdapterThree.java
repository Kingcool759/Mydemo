package com.example.mydemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

/**
 * @data on 2020/9/18 11:33 AM
 * @auther
 * @describe
 */
public class ViewPagerAdapterThree extends PagerAdapter {
    ArrayList<ImageView> images;

    private int maxValue = Integer.MAX_VALUE;


    public ViewPagerAdapterThree(ArrayList<ImageView> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return maxValue;
    }

    //是否是同一张图片
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        // 在父布局中添加View前先判断父布局中是否已经存在View
        // 如果父布局中已经有了需要在添加前做remove操作
        // 否则会报错Android-The specified child already has a parent. You must call removeView() on the child's parent first.
        int currentPosition = (position % images.size());
        ImageView iv = images.get(currentPosition);
        if (iv.getParent()!=null){
            ((ViewPager)iv.getParent()).removeView(iv);
        }
        view.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {

    }
}
