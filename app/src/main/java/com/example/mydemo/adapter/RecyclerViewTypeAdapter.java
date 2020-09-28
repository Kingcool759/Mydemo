package com.example.mydemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mydemo.R;
import com.example.mydemo.entity.Fruit;
import java.util.List;

/**
 * @data on 2020/9/25 5:28 PM
 * @auther
 * @describe  Recycler多布局效果
 */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int IMAGEVIEW = 0;
    private final int VER_RECYCLERVIEW = 1;

    private List<Fruit> fruitList;


    public RecyclerViewTypeAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == IMAGEVIEW){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view,parent,false);
            return new ImageHolder(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.case7_item_fruit, parent, false);
            return new VerViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ImageHolder){
            ImageHolder horViewHolder = (ImageHolder)holder;
            horViewHolder.userImage.setImageResource(R.drawable.user_img);
        }else if(holder instanceof VerViewHolder){
            VerViewHolder verViewHolder = (VerViewHolder)holder;
            verViewHolder.fruitImage.setImageResource(fruitList.get(position).getImageId());
            verViewHolder.fruitName.setText(fruitList.get(position).getName());
        }
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {
        public ImageView userImage;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image);
        }
    }

    public static class VerViewHolder extends RecyclerView.ViewHolder {
        public ImageView fruitImage;
        public TextView fruitName;

        public VerViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return IMAGEVIEW;
        }else {
            return VER_RECYCLERVIEW;
        }
    }
}
