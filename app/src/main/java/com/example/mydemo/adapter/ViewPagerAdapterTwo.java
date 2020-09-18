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
    private ItemTouchListener mItemTouchListener;

    public ViewPagerAdapterTwo(ArrayList<ImageView> views) {
        this.listviews = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        if (listviews.get(position % listviews.size()).getParent() != null) {
            container.removeView(listviews.get(position % listviews.size()));
        }
        container.addView(listviews.get(position % listviews.size()), 0);

        //触摸事件
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        //按下
                        if(mItemTouchListener != null){
                        mItemTouchListener.getItemTouchData(1);}
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //移动
                        if(mItemTouchListener != null){
                        mItemTouchListener.getItemTouchData(2);}
                        break;
                    case MotionEvent.ACTION_UP:
                        //松开
                        if(mItemTouchListener != null){
                        mItemTouchListener.getItemTouchData(3);}
                        break;
                }
                return true;
            }
        });

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

    //回调事件
    public interface ItemTouchListener{
        void getItemTouchData(int type);
    }
    public void setItemTouchListener(ItemTouchListener itemTouchListener){
        mItemTouchListener = itemTouchListener;
    }
}
