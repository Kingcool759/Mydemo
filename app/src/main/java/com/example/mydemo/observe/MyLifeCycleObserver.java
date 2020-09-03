package com.example.mydemo.observe;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @data on 2020/8/28 11:53 AM
 * @auther
 * @describe  自定义lifecycle观察者类
 */
public class MyLifeCycleObserver implements LifecycleObserver {

    public MyLifeCycleObserver() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onActivityResume(){
        Log.d("onActivityResume===>>>>","追踪1");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onActivityPause(){
        Log.d("onActivityPause====>>>>","追踪2");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroy(){
        Log.d("onActivityDestroy====>>","追踪3");
    }
}
