package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mydemo.R;
import com.example.mydemo.adapter.RecyclerGridAdapter;
import com.example.mydemo.arouter.ARouterPath;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.blog35)

public class Case35 extends AppCompatActivity {
    private GridLayoutManager layoutManager;
    private List<String> imgList;
    private List<String> tvList;
    private RecyclerView recycler;

    TextView testView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case35);
        initView();
        layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new RecyclerGridAdapter(this, imgList,tvList));
        recycler.setItemAnimator(new DefaultItemAnimator());

        //测试控件是否对用户可见
        testView2 = findViewById(R.id.testView);
        ddd();
    }

    private void initView() {
        recycler = findViewById(R.id.recycler);
        imgList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            String url1 = "https://gss0.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/w=580/sign=df5ea1e44b34970a47731027a5cbd1c0/47cd04d162d9f2d320a14d24a3ec8a136227cc06.jpg";
            String url2 = "https://gss0.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/w=580/sign=df5ea1e44b34970a47731027a5cbd1c0/47cd04d162d9f2d320a14d24a3ec8a136227cc06.jpg";
            String url3 = "https://gss0.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/w=580/sign=df5ea1e44b34970a47731027a5cbd1c0/47cd04d162d9f2d320a14d24a3ec8a136227cc06.jpg";
            String url4 = "https://gss0.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/w=580/sign=df5ea1e44b34970a47731027a5cbd1c0/47cd04d162d9f2d320a14d24a3ec8a136227cc06.jpg";
            imgList.add(url1);
            imgList.add(url2);
            imgList.add(url3);
            imgList.add(url4);
        }
        tvList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            tvList.add("#广告");
            tvList.add("#剧情");
            tvList.add("#运动");
            tvList.add("#创意");
        }

    }

    private void ddd(){
        new Handler().postDelayed (new Runnable () {    //匿名内部类  创建线程
            @Override
            public void run() {
//                Log.d("testView2", isShowInEyes(testView2).toString());
                Log.d("testView2", isShowInParent(testView2).toString());
            }
        },1000);         //第二个参数是停留的时间
    }


    //判断控件是否在屏幕中
    @SuppressLint("LongLogTag")
    private Boolean isShowInEyes(View view) {
//        Rect currentViewRect = new Rect();
//        boolean isShow = view.getGlobalVisibleRect(currentViewRect);
        //约束布局往左布局的时候有一个像素的误差，上边这种方式。
        /**
         * 换用View的绝对位置判断
         */
//        Log.d("testView", currentViewRect.toString());
        Log.d("testView.left", view.getLeft()+"");
        Log.d("testView.top", view.getTop()+"'");
        Log.d("testView.right", view.getRight()+"'");
        Log.d("testView.bottom", view.getBottom()+"");
        Log.d("testView.getMeasuredWidth", view.getMeasuredWidth()+"");
        if(view.getLeft()<0 || view.getTop()<0 ||view.getRight()<0 ||view.getBottom()<0){
            return false;
        }else {
            return true;
        }
    }

    //判断控件是否在父布局中完全可见
    @SuppressLint("LongLogTag")
    private Boolean isShowInParent(View view){
        Rect currentViewRect = new Rect();
        view.getLocalVisibleRect(currentViewRect);
        boolean b1 = currentViewRect.width() == view.getMeasuredWidth();
        boolean b2 = currentViewRect.height() == view.getMeasuredHeight();
        if (b1 && b2){
            return true;
        }else {
            return false;
        }
    }
}