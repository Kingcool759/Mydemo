package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

import java.util.ArrayList;
import java.util.List;

//wheelView
@Route(path = ARouterPath.blog49)
public class Case49 extends AppCompatActivity {
    private WheelView wheelView1;
    private WheelView wheelView2;
    private List<String> mOptionsItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case49);
        initList();
        initView1();
        initView2();
    }
    private void initView1(){
        wheelView1 = findViewById(R.id.wheelview1);
        wheelView1.setCyclic(false); //设置不可循环滚动
        setWheelView(wheelView1);
    }
    private void initView2(){
        wheelView2 = findViewById(R.id.wheelview2);
        wheelView2.setCyclic(true); //设置循环滚动
        setWheelView(wheelView2);
    }
    private void initList(){
        mOptionsItems.add("中国");
        mOptionsItems.add("加利福尼亚");
        mOptionsItems.add("俄罗斯");
        mOptionsItems.add("美国");
        mOptionsItems.add("索马里海域大三峡");
        mOptionsItems.add("中国");
        mOptionsItems.add("加利福尼亚");
        mOptionsItems.add("俄罗斯");
        mOptionsItems.add("美国");
        mOptionsItems.add("索马里海域大三峡");
        mOptionsItems.add("中国");
        mOptionsItems.add("加利福尼亚");
        mOptionsItems.add("日本");
        mOptionsItems.add("俄罗斯");
        mOptionsItems.add("美国");
        mOptionsItems.add("索马里海域大三峡");
    }
    private void setWheelView(WheelView wheelView){
        wheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                Toast.makeText(getBaseContext(), "" + mOptionsItems.get(index), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
