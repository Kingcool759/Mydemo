package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.mydemo.R;
import com.example.mydemo.adapter.RecyclerView2TypeAdapter;
import com.example.mydemo.entity.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Case34 extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private List<Fruit> mList1;
    private List<Fruit> mList2;
    private RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case34);
        initView();
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new RecyclerView2TypeAdapter(this,mList1,mList2));
    }
    private void initView() {
        recycler = findViewById(R.id.recycler);
        mList1 = new ArrayList();
        for (int i = 1; i < 7; i++) {
            mList1.add(new Fruit("香蕉" + i, R.mipmap.banana)); //纵向
        }
        mList2 = new ArrayList();
        for (int i = 0; i < 21; i++) {
            mList2.add(new Fruit("芒果" + i, R.mipmap.mangguo)); //纵向
        }
    }
}