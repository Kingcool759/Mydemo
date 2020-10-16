package com.example.mydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydemo.R;
import com.example.mydemo.entity.Fruit;

import java.util.List;

/**
 * @data on 2020/9/27 9:21 AM
 * @auther armstrong
 * @describe Recycler多布局（2个Recycler）效果
 */
public class RecyclerView2TypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int HOR_RECYCLER = 0;
    private final int VER_RECYCLER = 1;

    private List<Fruit> banannaList;
    private List<Fruit> mangguoList;

    private Context mContext;

    public RecyclerView2TypeAdapter(Context context, List<Fruit> fruitList1, List<Fruit> fruitList2) {
        this.mContext = context;
        this.banannaList = fruitList1;
        this.mangguoList = fruitList2;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == HOR_RECYCLER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.case34_hor_recycler, parent, false);
            return new HorViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.case7_item_fruit, parent, false);
            return new VerViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HorViewHolder) {
            HorViewHolder horViewHolder = (HorViewHolder) holder;
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            horViewHolder.horRecycler.setLayoutManager(layoutManager);
            horViewHolder.horRecycler.setAdapter(new FruitHorRecyclerVIewAdapter(banannaList));
        } else if (holder instanceof VerViewHolder) {
            VerViewHolder verViewHolder = (VerViewHolder) holder;
            verViewHolder.fruitImage.setImageResource(mangguoList.get(position - 1).getImageId());
            verViewHolder.fruitName.setText(mangguoList.get(position - 1).getName());
        }
    }

    public static class HorViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView horRecycler;

        public HorViewHolder(@NonNull View itemView) {
            super(itemView);
            horRecycler = itemView.findViewById(R.id.hor_recycler);
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
        return mangguoList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HOR_RECYCLER;
        } else {
            return VER_RECYCLER;
        }
    }
}
