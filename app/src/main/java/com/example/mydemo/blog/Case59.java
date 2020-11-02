package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Book;
import com.example.mydemo.entity.MyRetrofit;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.blog59)
//模拟建造者模式（这个设计模式主要应用在Retrofit中）
public class Case59 extends AppCompatActivity {
    private MyRetrofit retrofit;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case59);
        MyRetrofitBuildTest();
        tvContentShow();
    }
    //建造者模式应用
    private void MyRetrofitBuildTest() {
        List<Book> datas = new ArrayList();
        datas.add(new Book("1", "《姜子牙》"));
        datas.add(new Book("2", "《我和我的祖国》"));
        datas.add(new Book("3", "《伍佰》"));
        datas.add(new Book("4", "《我和我的家乡》"));
        retrofit = new MyRetrofit.Builder()
                .setName("千夜零一")
                .setAge(23)
                .setList(datas)
                .build();
    }
    //将数据取出设置到TextView中展示出来
    @SuppressLint("SetTextI18n")
    private void tvContentShow(){
        tvContent  = findViewById(R.id.tvContent);
        StringBuffer sb = new StringBuffer();
        for (Book book : retrofit.getBooks()) {  //遍历List取出对象
            sb.append(book.getName()).append(",");
        }
        tvContent.setText("姓名："+retrofit.getName()+"\n"+"年龄："+retrofit.getAge()+"\n"+"喜欢："+sb.toString());
    }
}
