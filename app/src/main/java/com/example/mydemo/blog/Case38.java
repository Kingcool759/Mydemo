package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.fragment.TestFragment;

@Route(path = ARouterPath.blog38)

public class Case38 extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Fragment fragment = new TestFragment();
    final String TAG = "TestFragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case38);
        //fragment生命周期探究
        findViewById(R.id.btnStart).setOnClickListener((View) -> {
            replaceFragment(fragment);
        });
        Log.i(TAG, "(Activity)onCreate: ");
    }
    //Fragment启动方法：

    private void replaceFragment(Fragment fragment) {
        // 1.获取FragmentManager，在活动中可以直接通过调用getFragmentManager()方法得到
        fragmentManager = getSupportFragmentManager();
        // 2.开启一个事务，通过调用beginTransaction()方法开启
        transaction = fragmentManager.beginTransaction();
        // 3.向容器内添加或替换碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例
        transaction.replace(R.id.testFragment, fragment);  //fr_container不能为fragment布局，可使用线性布局相对布局等。
        // 4.使用addToBackStack()方法，将事务添加到返回栈中，填入的是用于描述返回栈的一个名字
        transaction.addToBackStack(null);
        // 5.提交事物,调用commit()方法来完成
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "(Activity)onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "(Activity)onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "(Activity)onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "(Activity)onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "(Activity)onResume: ");
    }
}