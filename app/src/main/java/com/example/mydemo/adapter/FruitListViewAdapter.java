package com.example.mydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mydemo.R;
import com.example.mydemo.entity.Fruit;

import java.util.List;

/**
 * @data on 2020/8/27 9:58 PM
 * @auther
 * @describe
 */
public class FruitListViewAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitListViewAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position); //获取当前项的Fruit实例
        View view;
        if(convertView ==null){    //优化1：提升ListView的运行效率，快速滚动时有更好的性能。
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        } else {
            view = convertView;
        }
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;
    }
}
