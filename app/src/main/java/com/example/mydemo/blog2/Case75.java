package com.example.mydemo.blog2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog75)
//LeakCanary工具使用
public class Case75 extends AppCompatActivity {

    private static Context sContext;
//    private static View sView;
    private static TextView tvShowMessage;
    MyHandler myHandler;

    //主线程中创建的Handler，因此不需要对Looper进行操作，例如无需调用Looper.prepare()和Looper.loop()方法。
//    @SuppressLint("HandlerLeak")
//    private static Handler handler = new Handler(){
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){  //根据消息类型区别消息
//                case 1:
//                    tvShowMessage.setText(""+msg.arg1+"-"+msg.arg2);
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case75);
        /**
         * 【内存泄露：静态对象持有外部类activity的引用（场景1）】
         * 原因分析：
         * 静态对象持有外部类对象（Activity）的引用，
         * 导致Activity无法被gc回收。
         */
        sContext = this;
//        sView = new View(this);

        /**
         * 【内存泄露：匿名内部类创建Handler对象隐式地持有外部类activity的引用（场景2）】
         * 原因分析：
         * 使用内部类（包括匿名类）来创建Handler，Handler对象会隐式地持有一个外部类对象（Activity）的引用
         * 导致Activity无法被gc回收。
         */

        tvShowMessage = findViewById(R.id.tvShow);
        myHandler = new MyHandler();
        new Thread(){
            @Override
            public void run() {
                super.run();
                //在一个子线程中去做这件事，模拟异步耗时操作
                myHandler.postDelayed(new MyRunnable(),2000);  //延迟两秒后分发Runnable对象
//                Looper.prepare();
//                子线程创建handler，主线程给子线程发消息，更新子线程的数据。
//                Handler handler = new Handler(){
//                    @Override
//                    public void handleMessage(@NonNull Message msg) {
//                        super.handleMessage(msg);
//                        ...
//                    }
//                };
//                myHandler.postDelayed(new MyRunnable(),2000);
//                Looper.loop();
            }
        }.start();
//        new Thread(){   //子线程模拟耗时操作，5s后通过Message更新ui
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    sleep(2000);
////                    Message msg = new Message();
//                    Message msg = Message.obtain();//从全局池中返回一个message实例，避免多次创建（如new Message()）
//                    msg.what = 1;
//                    msg.arg1 = 100;
//                    myHandler.sendMessage(msg);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 【解决方法：（场景一）】
         * 因为这是由于静态对象持有外部activity引用，导致activity无法被回收
         * 所以要解决，就需要将该静态变量在Destroy的时候移除对activity持有的引用，
         * 这样可以保证activity被正常回收，解除内存泄露问题。
         */
        sContext = null;
//        sView = null;
    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String updatedStr = b.getString("str1");
            tvShowMessage.setText(updatedStr);
        }
    }
    class MyRunnable implements Runnable{

        @Override
        public void run() {
            Message msg = new Message();
            Bundle b = new Bundle();
            b.putString("str1", "更新的字符串");
            msg.setData(b);
            // 向Handler发送消息,更新UI
            myHandler.sendMessage(msg);  //Case75.this.myHandler
        }
    }
}