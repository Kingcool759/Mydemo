package com.example.mydemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mydemo.entity.ImageUrl;

import java.util.List;

/**
 * @data on 2020/9/1 5:41 PM
 * @auther
 * @describe  banner使用
 */
public class ViewPagerAdapterOne extends PagerAdapter {
    List<View> viewPagerList;

    public ViewPagerAdapterOne(List<View> imgList) {
        this.viewPagerList = imgList;
    }

    @Override
    public int getCount() {
        return viewPagerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewPagerList.get(position));
        return viewPagerList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewPagerList.get(position));
    }

}
