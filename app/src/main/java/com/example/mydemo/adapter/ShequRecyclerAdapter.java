package com.example.mydemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydemo.R;
import com.example.mydemo.entity.Fruit;

import java.util.List;

/**
 * @data on 2020/10/26 7:25 PM
 * @auther armStrong
 * @describe
 */
public class ShequRecyclerAdapter extends RecyclerView.Adapter<ShequRecyclerAdapter.MyViewHolder> {
    private List<Fruit> fruitList;

    public ShequRecyclerAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stag_grid_layout, parent, false);
        final MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Fruit fruitItem = fruitList.get(position);
        holder.sgl_image.setImageResource(fruitItem.getImageId());
        holder.sgl_title.setText(fruitItem.getName());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        //图片
        public ImageView sgl_image;
        //标题
        public TextView sgl_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            sgl_image = itemView.findViewById(R.id.sgl_image);
            sgl_title = itemView.findViewById(R.id.sgl_title);
        }
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

}