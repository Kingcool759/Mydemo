package com.example.mydemo.adapter;

import android.content.Context;

import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.example.mydemo.entity.GroupEntity;

import java.util.ArrayList;

/**
 * @data on 12/1/20 4:38 PM
 * @auther  armStrong
 * @describe  没有尾部的Adapter(用来做吸顶效果)
 */
public class NoFooterAdapter extends GroupedListAdapter {

    public NoFooterAdapter(Context context, ArrayList<GroupEntity> groups) {
        super(context, groups);
    }

    /**
     * 返回false表示没有组尾
     *
     * @param groupPosition
     * @return
     */
    @Override
    public boolean hasFooter(int groupPosition) {
        return false;
    }

    /**
     * 当hasFooter返回false时，这个方法不会被调用。
     *
     * @return
     */
    @Override
    public int getFooterLayout(int viewType) {
        return 0;
    }

    /**
     * 当hasFooter返回false时，这个方法不会被调用。
     *
     * @param holder
     * @param groupPosition
     */
    @Override
    public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {

    }

}
