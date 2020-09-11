package com.example.mydemo.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mydemo.R;
import com.example.mydemo.blog.Case21;
import com.example.mydemo.show.Case10;
import com.example.mydemo.show.Case11;
import com.example.mydemo.show.Case12;
import com.example.mydemo.show.Case13;
import com.example.mydemo.show.Case14;
import com.example.mydemo.show.Case15;
import com.example.mydemo.show.Case16;
import com.example.mydemo.blog.Case17;
import com.example.mydemo.blog.Case19;
import com.example.mydemo.blog.Case20;
import com.example.mydemo.show.Case4;
import com.example.mydemo.show.Case1;
import com.example.mydemo.show.Case2;
import com.example.mydemo.show.Case3;
import com.example.mydemo.show.Case5;
import com.example.mydemo.show.Case6;
import com.example.mydemo.show.Case7;
import com.example.mydemo.show.Case8;
import com.example.mydemo.show.Case9;

public class MainActivity extends AppCompatActivity {
    private String data[] = {
            "1：任务：我的客服-拨打电话",  //0
            "2：任务：系统设置-退出登录",  //1
            "3：ObservableField使用", //2
            "4：LiveData使用",  //3
            "5：ListView使用",  //4
            "6：LifeCycle使用", //5
            "7：RecyclerView使用",  //6
            "8：ViewPager使用实现轮播图",  //case7
            "9：RxJava使用", //8
            "10：Retrofit使用，Api接口调用实现", //case9
            "11：CollapsingToolbarLayout折叠布局",  //10
            "12：WebView使用", //11
            "13：DrawerLayout滑动菜单",  //12
            "14：TabLayout使用",  //13
            "15：FlowLayout流式布局使用(不带点击事件)",  //14
            "16：FlowLayout流式布局使用(hongyang)",  //15
            "17：ARouter路由跳转（博客1）", //16
            "18：DataBinding示例（博客2）",  //17
            "19：Lambda表达式示例（博客3）", //18
            "20：RecyclerView示例（博客4）", //19
            "3：cc",
            "3：cc",
            "3：cc",
            "3：dd",
            "z：bb",
            "3：aa",
            "3：cc",
            "3：dd",
            "3：dd"};//假数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);//在视图中找到ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);//新建并配置ArrayAapeter
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent1 = new Intent(MainActivity.this, Case1.class);
                        startActivity(intent1);
                        break;

                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, Case2.class);
                        startActivity(intent2);
                        break;

                    case 2:
                        Intent intent3 = new Intent(MainActivity.this, Case3.class);
                        startActivity(intent3);
                        break;

                    case 3:
                        Intent intent4 = new Intent(MainActivity.this, Case4.class);
                        startActivity(intent4);
                        break;

                    case 4:
                        Intent intent5 = new Intent(MainActivity.this, Case5.class);
                        startActivity(intent5);
                        break;

                    case 5:
                        Intent intent6 = new Intent(MainActivity.this, Case6.class);
                        startActivity(intent6);
                        break;
                    case 6:  //recyclerview
                        Intent intent7 = new Intent(MainActivity.this, Case7.class);
                        startActivity(intent7);
                        break;
                    case 7:  //ViewPager
                        Intent intent8 = new Intent(MainActivity.this, Case8.class);
                        startActivity(intent8);
                        break;
                    case 8:  //RxJava
                        Intent intent9 = new Intent(MainActivity.this, Case9.class);
                        startActivity(intent9);
                        break;
                    case 9:  //Retrofit
                        Intent intent10 = new Intent(MainActivity.this, Case10.class);
                        startActivity(intent10);
                        break;
                    case 10:  //折叠布局
                        Intent intent11 = new Intent(MainActivity.this, Case11.class);
                        startActivity(intent11);
                        break;
                    case 11:  //WebView
                        Intent intent12 = new Intent(MainActivity.this, Case12.class);
                        startActivity(intent12);
                        break;
                    case 12:  //滑出菜单
                        Intent intent13 = new Intent(MainActivity.this, Case13.class);
                        startActivity(intent13);
                        break;
                    case 13:  //Tablayout
                        Intent intent14 = new Intent(MainActivity.this, Case14.class);
                        startActivity(intent14);
                        break;
                    case 14:  //流式布局
                        Intent intent15 = new Intent(MainActivity.this, Case15.class);
                        startActivity(intent15);
                        break;
                    case 15:  //流式布局(hongyang)
                        Intent intent16 = new Intent(MainActivity.this, Case16.class);
                        startActivity(intent16);
                        break;
                    case 16:  //ARouter路由跳转
                        Intent intent17 = new Intent(MainActivity.this, Case17.class);
                        startActivity(intent17);
                        break;
                    case 17:  //DataBinding示例
                        Intent intent18 = new Intent(MainActivity.this, Case19.class);
                        startActivity(intent18);
                        break;
                    case 18:  //lambda
                        Intent intent20 = new Intent(MainActivity.this, Case20.class);
                        startActivity(intent20);
                        break;
                    case 19:  //recyclerview
                        Intent intent21 = new Intent(MainActivity.this, Case21.class);
                        startActivity(intent21);
                        break;
                }
            }
        });
    }
}