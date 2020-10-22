package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.FruitListViewAdapter;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

//ListView使用

@Route(path = ARouterPath.case5)

public class Case5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case5);

        List<Fruit> fruitList = new ArrayList<>();
        for (int i = 0; i < 30; i++){   //加两边，才足以铺满屏幕
            Fruit apple = new Fruit("水果儿"+i,R.mipmap.apple);
            fruitList.add(apple);
        }

        FruitListViewAdapter adapter = new FruitListViewAdapter(Case5.this,R.layout.case5_item_fruit,fruitList);
        ListView listView = (ListView) findViewById(R.id.lv_listView);
        listView.setAdapter(adapter);

        //设置item的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);   //i=position
                Toast.makeText(Case5.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
