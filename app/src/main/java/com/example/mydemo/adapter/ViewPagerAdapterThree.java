package com.example.mydemo.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * @data on 2020/9/18 11:33 AM
 * @auther
 * @describe
 */
public class ViewPagerAdapterThree extends PagerAdapter {
    ArrayList<ImageView> images;
    ItemTouchListener mItemTouchListener;

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
    public void destroyItem(ViewGroup view, int position, Object object) {
        int currentPosition = (position % images.size());
        view.removeView(images.get(currentPosition));

    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        int currentPosition = (position % images.size());
        Log.d("tag", "currentPosition == " + currentPosition);
        view.addView(images.get(currentPosition));
        return images.get(currentPosition);
    }

    //回调事件
    public interface ItemTouchListener {
        void getItemTouchData(int type);
    }

    public void setItemTouchListener(ItemTouchListener itemTouchListener) {
        mItemTouchListener = itemTouchListener;
    }
}
