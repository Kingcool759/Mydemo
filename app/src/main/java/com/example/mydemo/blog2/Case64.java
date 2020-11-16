package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.DividerItemDecoration;
import com.example.mydemo.helper.IHCallback;
import com.example.mydemo.helper.MoveAdapter;
import com.example.mydemo.adapter.TimeLineItemDecoration;
import com.example.mydemo.arouter.ARouterPath;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.blog64)
public class Case64 extends AppCompatActivity {
    private MoveAdapter adapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView recycler;
    private List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case64);
        initView();
        initData();
        initRecycler();
    }
    private void initView(){
        recycler = findViewById(R.id.recycler64);
    }

    private void initData(){
        itemList = new ArrayList<>();
        itemList.add("hahhhha");
        itemList.add("aaaaaaa");
        itemList.add("bbbbbbb");
        itemList.add("cccccc");
        itemList.add("ddddd");
        itemList.add("hahhhha");
        itemList.add("aaaaaaa");
        itemList.add("bbbbbbb");
        itemList.add("cccccc");
        itemList.add("ddddd");
    }

    private void initRecycler(){
        //瀑布流布局
        adapter = new MoveAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
        adapter.setData(itemList);

        //拖拽、删除
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new IHCallback(adapter));
        itemTouchHelper.attachToRecyclerView(recycler);

        //装饰
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.addItemDecoration(new DividerItemDecoration(this)); //item分割线
        recycler.addItemDecoration(new TimeLineItemDecoration(this)); //时间轴效果
    }
}