package com.example.mydemo.helper;

/**
 * @data on 2020/11/13 5:49 PM
 * @auther armStrong
 * @describe ItemTouchHelper用法（RecyclerView拖拽、删除）
 */
public interface IOperationData {
    /**
     * 数据交换
     * @param fromPosition
     * @param toPosition
     */
    void onItemMove(int fromPosition,int toPosition);

    /**
     * 数据删除
     * @param position
     */
    void onItemDissmiss(int position);
}
