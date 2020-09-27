package com.example.mydemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mydemo.R;
import com.example.mydemo.entity.Fruit;
import com.example.mydemo.entity.ImageUrl;

import java.util.List;

/**
 * @data on 2020/9/27 11:27 AM
 * @auther
 * @describe
 */
public class RecyclerGridAdapter extends RecyclerView.Adapter<RecyclerGridAdapter.MyViewHolder>{
    private List<Integer> imgList;
    private List<String> tvList;
    private Context mContext;

    public RecyclerGridAdapter(Context context, List<Integer> imageList,List<String> tvList) {
        this.mContext = context;
        this.imgList = imageList;
        this.tvList = tvList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.case35_hottype_hor,parent,false);
        final MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //加载图片
        holder.img.setImageResource(imgList.get(position));
        holder.tv.setText(tvList.get(position));
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //图片
        public ImageView img;
        //分类
        public TextView tv;


        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.case35_iv);
            tv = itemView.findViewById(R.id.case35_tv);
        }
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

}