package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.animation.OvershootInterpolator;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.util.Random;

@Route(path = ARouterManager.Path.blog37)

public class Case37 extends AppCompatActivity {
    protected static final Random RANDOM = new Random(System.currentTimeMillis());//当前毫秒数范围类的随机数
    private TickerView tickerView;
    private Handler handler = new Handler();//定义一个handle用来启动线程来动态更新UI
    private boolean resumed;//定义一个开关:是否可以开始动态改变Ticker上的text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case37);

        tickerView= (TickerView) findViewById(R.id.tickerView);
        tickerView.setCharacterLists(TickerUtils.provideNumberList());
        tickerView.setTextSize(56);//设置文字大小,自己经验:jar包导入推荐使用代码设置文字大小
        tickerView.setAnimationDuration(500);//设置动画持续时间
        tickerView.setAnimationInterpolator(new OvershootInterpolator());//设置动画插值器
        tickerView.setGravity(Gravity.CENTER);//设置对齐方式
    }
    @Override
    protected void onResume() {
        super.onResume();
        resumed = true;//打开开关
        handler.post(createRunnable());//启动更新UI的线程
    }

    /**
     * 递归
     * 创建Runnable对象(动态延迟)
     * @return
     */
    private Runnable createRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                onUpdate();//更新UI
                if (resumed) {
                    handler.postDelayed(createRunnable(), RANDOM.nextInt(1750) + 250);
                }
            }
        };
    }
    /**
     * 更新界面显示
     */
    protected void onUpdate() {
        final int digits = RANDOM.nextInt(2) + 6;//将digits(字符长度)限定在[6,8]内
        tickerView.setText("$"+getRandomNumber(digits));
    }

    /**
     * 将数值通过固定算法并转化成字符串
     * @param digits
     * @return
     */
    protected String getRandomNumber(int digits) {
        final String currencyFloat = Float.toString(RANDOM.nextFloat() * 1000);//价格显示范围在1000$内
        final String showText = currencyFloat.substring(0,  digits-1);//在[0,digits)之间取一个子字符串
        return showText;
    }

    @Override
    protected void onPause() {
        resumed = false;//关闭开关
        super.onPause();
    }
}