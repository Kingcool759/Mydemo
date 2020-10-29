package com.example.mydemo.blog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog52)
public class Case52 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case52);
        /**
         *  创建Handler有两种方法
         */
        //第一种、传入callBack对象
        Handler handler = new Handler(Looper.myLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage( Message msg) {
                return false;
            }
        });

        //弹出延迟Toast
        findViewById(R.id.btnShow).setOnClickListener((View)->{
            MyHandler1 myHandler1 = new MyHandler1(Looper.myLooper());
            myHandler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Case52.this,"弹出Toast", Toast.LENGTH_SHORT).show(); //默认底部显示
                }
            }, 1000 * 3);
        });
    }

    //第二种、继承Handler并重写handleMessage方法
    //要使用静态内部类，不然可能会造成内存泄露。原因是非静态内部类会持有外部类的引用，
    private static class MyHandler1 extends Handler{
        public MyHandler1(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    }
}
