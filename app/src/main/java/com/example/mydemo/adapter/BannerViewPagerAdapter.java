package com.example.mydemo.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mydemo.entity.BannerImg;

import java.util.List;

/**
 * @data on 2020/9/1 5:41 PM
 * @auther
 * @describe  banner使用
 */
public class BannerViewPagerAdapter extends PagerAdapter {
    List<BannerImg> imgList;

    public BannerViewPagerAdapter(List<BannerImg> imgList) {
        this.imgList = imgList;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
