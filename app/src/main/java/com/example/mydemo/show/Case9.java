package com.example.mydemo.show;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @data 2020-08-31
 * @auther armstrong
 * @describe RxJava的基本用法
 */
@Route(path = ARouterManager.Path.case9)

public class Case9 extends AppCompatActivity {
    /* 定义TAG标签，这样可以很好的区分打印出来的log */
    private static final String TAG = "ArmStrong";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case9);

        //创建一个观察者
        //使用Observer方式
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe: ====>>>>");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: ====>>>>" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "Error：====>>>>");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete:====>>>> ");
            }
        };
        //使用Observable.creat()创建被观察者
        Observable observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello");
                emitter.onNext("RxJava");
                emitter.onNext("!");
                emitter.onComplete();
            }
        });
        //订阅
        observable1.subscribe(observer);

//        //使用场景1
//        //打印字符串数组
//        String[] names = {"hello", "rxjava", "!"};
//        Observable.fromArray(names)
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        Log.i(TAG, "Consumer:====>>>> " + s);
//                    }
//                });
    }
}