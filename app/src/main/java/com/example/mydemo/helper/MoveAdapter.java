package com.example.mydemo.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mydemo.R;

import java.util.Collections;
import java.util.List;

/**
 * @data on 2020/11/13 5:55 PM
 * @auther armStrong
 * @describe  ItemTouchHelper用法（RecyclerView拖拽、删除）
 */
public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveHolder> implements IOperationData {

    private List<String> mDataList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MoveAdapter(Context context) {
        this.mContext = context;
        mInflater =LayoutInflater.from(mContext);
    }

    MoveAdapter(List<String> dataList) {
        mDataList = dataList;
    }

    public void setData(List<String> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public MoveHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MoveHolder(mInflater.inflate(R.layout.item_move, parent, false));
    }

    @Override
    public void onBindViewHolder(MoveHolder holder, int position) {
        holder.mTextTitle.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交换位置
        Collections.swap(mDataList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);

    }

    @Override
    public void onItemDissmiss(int position) {
        //移除数据
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

    static class MoveHolder extends RecyclerView.ViewHolder {

        TextView mTextTitle;

        MoveHolder(View itemView) {
            super(itemView);
            mTextTitle = itemView.findViewById(R.id.tv_move);
        }
    }

}