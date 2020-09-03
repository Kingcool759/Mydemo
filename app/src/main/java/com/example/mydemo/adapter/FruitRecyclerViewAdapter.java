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
 * @data on 2020/8/28 1:51 PM
 * @auther
 * @describe
 */
public class FruitRecyclerViewAdapter extends RecyclerView.Adapter<FruitRecyclerViewAdapter.MyViewHolder>{
    private List<Fruit> fruitList;


    public FruitRecyclerViewAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.case7_item_fruit,parent,false);
       final MyViewHolder holder = new MyViewHolder(itemView);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Fruit fruitItem = fruitList.get(position);
        holder.fruitImage.setImageResource(fruitItem.getImageId());
        holder.fruitName.setText(fruitItem.getName());
        //item的点击事件
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positon = holder.getAdapterPosition();
                Fruit fruit = fruitList.get(positon);
                Toast.makeText(v.getContext(),"ver："+"你点击了"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        View fruitView;

        //图片
        public ImageView fruitImage;
        //标题
        public TextView fruitName;

        public MyViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

}
