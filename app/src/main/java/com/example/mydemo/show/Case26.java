package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.DividerItemDecoration;
import com.example.mydemo.adapter.FruitRecyclerViewAdapter;
import com.example.mydemo.adapter.TimeLineItemDecoration;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Fruit;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.List;
@Route(path = ARouterPath.case26)

public class Case26 extends AppCompatActivity {
    private FruitRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case26);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //RecyclerView
        List<Fruit> mList = new ArrayList();
        for ( int i=1 ; i<20 ; i++){
            mList.add(new Fruit("apple"+i,R.mipmap.apple));
        }
        //瀑布流布局
        adapter = new FruitRecyclerViewAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this)); //item分割线
        recyclerView.addItemDecoration(new TimeLineItemDecoration(this)); //时间轴效果

        //自定义TitleBar的点击事件处理
        TitleBar titleBar = findViewById(R.id.toolbar);
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
    }
}
