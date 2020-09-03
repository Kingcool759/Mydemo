package com.example.mydemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydemo.R;
import com.example.mydemo.bean.HomePageResBean;

import java.util.List;

/**
 * @data on 2020/9/1 9:46 AM
 * @auther
 * @describe
 */
public class OfficialAccountsAdapter extends RecyclerView.Adapter<OfficialAccountsAdapter.MyViewHolder> {
    private List<HomePageResBean.DataBean> data;

    public OfficialAccountsAdapter(List<HomePageResBean.DataBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.case10_item_official_accounts,parent,false);
        final OfficialAccountsAdapter.MyViewHolder holder = new OfficialAccountsAdapter.MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HomePageResBean.DataBean dataBean = data.get(position);
        holder.tvOfficalAccount.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvOfficalAccount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOfficalAccount = itemView.findViewById(R.id.tv_official_accounts);
        }
    }
}
