package com.example.mydemo.show;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.OfficialAccountsAdapter;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.bean.HomePageResBean;
import com.example.mydemo.databinding.ActivityCase10Binding;
import com.example.mydemo.viewmodel.Case10viewModel;

import java.util.ArrayList;
import java.util.List;

//retrofit基础用法
@Route(path = ARouterPath.case10)

public class Case10 extends AppCompatActivity {
    private ActivityCase10Binding binding;
    private Case10viewModel viewModel;

    //RecyclerView
    private LinearLayoutManager layoutManager;
    private OfficialAccountsAdapter adapter;
    public List<HomePageResBean.DataBean> publiclist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //databinding+viewmodel
        binding = DataBindingUtil.setContentView(this, R.layout.activity_case10);
        viewModel = ViewModelProviders.of(this).get(Case10viewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        publiclist = new ArrayList();

        //RecyclerView
        adapter = new OfficialAccountsAdapter(publiclist);  //把从Api接口解析的数据json解析后的List<databean>传进去
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        binding.rvHorRecyclerView.setLayoutManager(layoutManager);
        binding.rvHorRecyclerView.setAdapter(adapter);
        binding.rvHorRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //网络请求调用Api接口————>拿到数据。
        viewModel.getPublicList();//Https
        viewModel.getHomeDataList();//测试Http
//        //方式一：回调事件(观察者模式)————>处理数据
//        viewModel.getOfficialAccountsCallBack().observe(this, it -> {
//            publiclist.addAll(it);
//            adapter.notifyDataSetChanged();
//        });
        //方式二：直接观察字段mOfficialAccountsList
        viewModel.mOfficialAccountsList.observe(this,it->{
            publiclist.addAll(it);
            adapter.notifyDataSetChanged();
        });

    }
}
