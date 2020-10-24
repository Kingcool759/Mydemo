package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.FruitRecyclerViewAdapter;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Fruit;
import com.scwang.smart.refresh.footer.BallPulseFooter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.BezierRadarHeader;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.header.FalsifyHeader;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.header.TwoLevelHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.blog54)
//下拉刷新、上拉加载
public class Case54 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FruitRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<Fruit> mList = new ArrayList();
    private int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case54);

        initView();
        initData(n);
        setRecyclerView();
        setRefreshLayout();
    }
    private void initView(){
        recyclerView = findViewById(R.id.recyclerview);
    }
    private void initData(int n){
        for ( int i=1 ; i<13 ; i++){
            mList.add(new Fruit("apple"+(12*(n-1)+i),R.mipmap.apple));
        }
    }
    private void setRecyclerView(){
        //瀑布流布局
        adapter = new FruitRecyclerViewAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void setRefreshLayout(){
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout);
//        refreshLayout.setRefreshHeader(new ClassicsHeader(this)); //经典头
//        refreshLayout.setRefreshFooter(new ClassicsFooter(this)); //经典尾
        refreshLayout.setRefreshHeader(new BezierRadarHeader(this).setEnableHorizontalDrag(true));//雷达刷新头
//        refreshLayout.setRefreshHeader(new MaterialHeader(this));//谷歌刷新头
//        refreshLayout.setRefreshHeader(new TwoLevelHeader(this));//二级刷新头
        refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale)); //脉冲尾

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mList.clear();
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                initData(1);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                dataRefresh();
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }
    private void dataRefresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);//为了体现出刷新效果，所以这里休眠了线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //切回主线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initData(++n);//加载更多数据
                        adapter.notifyDataSetChanged();//通知数据已发生变化
                    }
                });
            }
        }).start();
    }
}
