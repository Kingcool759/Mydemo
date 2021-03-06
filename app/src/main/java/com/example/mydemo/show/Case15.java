package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.view.FlowLayoutView;

import java.util.ArrayList;

@Route(path = ARouterPath.case15)

//自定义View实现流式布局（带点击事件）
public class Case15 extends AppCompatActivity {
    private FlowLayoutView flowLayoutView;  //自定义ViewGroup
    private ArrayList<String> datas = new ArrayList();

    private String[] tagTextArray = new String[]{"天猫精灵", "充电台灯", "睡衣", "手表", "创意水杯", "夏天T恤男", "灯光机械键盘",
            "计算机原理", "学霸笔记本", "可口可乐", "跑步机", "旅行箱", "竹浆卫生纸", "吹风机", "洗面奶", "窗帘"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case15);

        //将数组转成list，因为一般都是从api接口接收的数据都是list
        for (int i = 0; i < tagTextArray.length; i++) {
            datas.add(tagTextArray[i]);
        }
        initView();
    }

    private void initView() {
        flowLayoutView = findViewById(R.id.flowlayout);
        for (int i = 0; i < datas.size(); i++) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.flow_tv_content, null);
            TextView tvContent = view.findViewById(R.id.flow_tv);
            tvContent.setText(datas.get(i));
            flowLayoutView.addView(view);

            //点击事件
            tvContent.setOnClickListener((View)->{
                Toast.makeText(this,tvContent.getText()+"",Toast.LENGTH_SHORT).show();
            });
        }
    }
}