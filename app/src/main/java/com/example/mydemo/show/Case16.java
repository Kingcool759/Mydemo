package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mydemo.R;
import com.example.mydemo.adapter.FlowTagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;

public class Case16 extends AppCompatActivity {
    private ArrayList<String> datas;
    private TagFlowLayout tagFlowLayout;
    private FlowTagAdapter flowTagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case16);
        //初始化数据
        initData();
        tagFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);
        Log.d("onCreate:case16 ", "" + datas);
        flowTagAdapter = new FlowTagAdapter(this, datas);
        tagFlowLayout.setAdapter(flowTagAdapter);
    }

    private void initData() {
        datas = new ArrayList<String>();
        datas.add("林更新");
        datas.add("古力娜扎");
        datas.add("周星驰");
        datas.add("王源");
        datas.add("四千年难得一遇的美少女");
        datas.add("印度耍蛇人");
        datas.add("王建国");
        datas.add("易洋千玺");
        datas.add("花果山水帘洞齐天大圣孙悟空是也");
        datas.add("天猫精灵");
        datas.add("充电台灯");
        datas.add("睡衣");
        datas.add("创意水杯");
        datas.add("夏天T恤男");
        datas.add("灯光机械键盘");
        datas.add("计算机原理");
        datas.add("学霸笔记本");
        datas.add("可口可乐");
        datas.add("跑步机");
        datas.add("旅行箱");
        datas.add("竹浆卫生纸");
        datas.add("吹风机");
        datas.add("洗面奶");
        datas.add("窗帘");
    }
}
