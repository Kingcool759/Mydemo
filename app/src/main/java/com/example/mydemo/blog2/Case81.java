package com.example.mydemo.blog2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

import java.lang.ref.WeakReference;

@Route(path = ARouterPath.blog81)
public class Case81 extends AppCompatActivity {

    private  WHandler wHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case81);

        /**
         * handler内存优化
         * 将 Handler 定义成静态的内部类，在内部持有 Activity 的弱引用，
         * 并在Acitivity的onDestroy()中调用handler.removeCallbacksAndMessages(null)及时移除所有消息。
         */
        //发送消息
//        Thread1 thread1=new Thread1();
//        thread1.start();
        //处理消息
        wHandler = new WHandler(this);
        Message message = Message.obtain();
        message.what = 0x11;
        wHandler.sendMessageDelayed(message,10000000);
    }

    private static class WHandler extends Handler{
        private final WeakReference<Case81> wActivity;

        public WHandler(Case81 activity) {
            wActivity = new WeakReference<Case81>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Case81 mOuter = wActivity.get();
            if (mOuter != null){
                if (msg.what == 0x11){
                    Log.d("bbb","避免内存泄露！！！");
                }
            }
        }
    }

//    private class Thread1 extends Thread{
//        @Override
//        public void run() {
//            super.run();
//            Message message = Message.obtain();
//            message.what = 0x11;
//            wHandler.sendMessageDelayed(message,10000000);
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wHandler.removeCallbacksAndMessages(null);
    }

}
