package com.example.mydemo.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mydemo.entity.ImageUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * @data on 2020/9/1 5:41 PM
 * @auther
 * @describe  banner使用
 */
public class ViewPagerAdapterTwo extends PagerAdapter {
    private ArrayList<ImageView> listviews;

    public ViewPagerAdapterTwo(ArrayList<ImageView> views) {
        this.listviews = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        if (listviews.get(position % listviews.size()).getParent() != null) {
            container.removeView(listviews.get(position % listviews.size()));
        }
        container.addView(listviews.get(position % listviews.size()), 0);

        return listviews.get(position % listviews.size());
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

}
