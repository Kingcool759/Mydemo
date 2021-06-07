package com.example.mydemo.blog;

import android.annotation.SuppressLint;
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
//        /**
//         *  创建Handler有两种方法
//         */
//        //第一种、传入callBack对象
//        Handler handler = new Handler(Looper.myLooper(), new Handler.Callback() {
//            @Override
//            public boolean handleMessage( Message msg) {
//                return false;
//            }
//        });
//
//        //弹出延迟Toast
//        findViewById(R.id.btnShow).setOnClickListener((View)->{
//            MyHandler1 myHandler1 = new MyHandler1(Looper.myLooper());
//            myHandler1.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(Case52.this,"弹出Toast", Toast.LENGTH_SHORT).show(); //默认底部显示
//                }
//            }, 1000 * 3);
//        });

        /**
         * Handler用法
         */
        @SuppressLint("HandlerLeak")
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x11) {
                    //更新ui
                    Toast.makeText(getApplicationContext(),"更新UI操作",Toast.LENGTH_SHORT).show();
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                //FIXME 这里直接更新ui是不行的
                //还有其他更新ui方式,runOnUiThread()等
                Message message = Message.obtain();
                message.what = 0x11;
//                handler.sendMessage(message);

                //从子线程切换到UI线程做更新UI操作
                runOnUiThread(()->{
                    Toast.makeText(getApplicationContext(),"更新UI操作",Toast.LENGTH_SHORT).show();
                });

                //也就是说指定的主线程的Looper来进行消息循环，自然就跨线程了
                Looper.prepare();
                new Handler(Looper.getMainLooper()){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 0x11) {
                            //更新ui
//                            Toast.makeText(getApplicationContext(),"更新UI操作",Toast.LENGTH_SHORT).show();
                        }
                    }
                }.sendMessage(message);
                Looper.loop();
            }
        }).start();
    }

//    //第二种、继承Handler并重写handleMessage方法
//    //要使用静态内部类，不然可能会造成内存泄露。原因是非静态内部类会持有外部类的引用，
//    private static class MyHandler1 extends Handler{
//        public MyHandler1(Looper looper) {
//            super(looper);
//        }
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//        }
//    }
}
