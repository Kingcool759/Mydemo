package com.example.mydemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @data on 2020/8/29 1:21 PM
 * @auther
 * @describe  自定义广播接收器
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收到我自定义的广播",Toast.LENGTH_SHORT).show();
    }
}
