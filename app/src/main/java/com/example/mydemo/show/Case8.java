package com.example.mydemo.show;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.adapter.ViewPagerAdapterOne;
import com.example.mydemo.adapter.ViewPagerAdapterThree;
import com.example.mydemo.adapter.ViewPagerAdapterTwo;
import com.example.mydemo.arouter.ARouterPath;

import java.util.ArrayList;

//viewpager使用实现轮播图
@Route(path = ARouterPath.case8)

public class Case8 extends AppCompatActivity {
    //初始化viewpager1
    private ViewPager viewPager1;
    private ViewPagerAdapterOne bannerAdapter;
    private ArrayList<View> pageviewList;
    //初始化viewpager2
    private ViewPager viewPager2;
    private ArrayList<ImageView> listviews;
    private ViewPagerAdapterTwo viewPagerAdapterTwo;
    int[] pics = {R.drawable.lunbo1, R.drawable.lunbo2, R.drawable.lunbo3};
    @SuppressLint("HandlerLeak")
    private MyHandler myHandler = new MyHandler();
    //初始化viewpager3
    private ViewPager viewPager3;
    private int imageIds[];
    private String[] titles;
    private ArrayList<ImageView> images;
    private ArrayList<View> dots;
    private TextView title;
    private ViewPagerAdapterThree viewPagerAdapterThree;
    private int oldPosition = 0;//记录上一次点的位置
    private int currentItem; //当前页面

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case8);
        initViewPager1();  //简单切换图片
        inintViewPager2();  //图片动态切换
        initViewPager3();  //切换+动态+小点+标题

    }

    private void initViewPager1() {
        viewPager1 = findViewById(R.id.view_pager1);
        //查找布局文件用LayoutInflater.inflate
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.viewpager_view_item1, null);
        View view2 = inflater.inflate(R.layout.viewpager_view_item2, null);
        View view3 = inflater.inflate(R.layout.viewpager_view_item3, null);

        //将view装入数组
        pageviewList = new ArrayList<View>();
        pageviewList.add(view1);
        pageviewList.add(view2);
        pageviewList.add(view3);

        //绑定适配器
        bannerAdapter = new ViewPagerAdapterOne(pageviewList);
        viewPager1.setAdapter(bannerAdapter);
    }

    private void inintViewPager2() {
        viewPager2 = findViewById(R.id.view_pager2);
        //处理
        listviews = new ArrayList<ImageView>();
        for (int i = 0; i < pics.length; i++) {
            ImageView imageView = new ImageView(this);
            ViewGroup.LayoutParams viewPagerImageViewParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
            imageView.setLayoutParams(viewPagerImageViewParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageResource(pics[i]);
            listviews.add(imageView);
        }
        viewPagerAdapterTwo = new ViewPagerAdapterTwo(listviews);
        viewPager2.setAdapter(viewPagerAdapterTwo);
        viewPager2.setCurrentItem(1);
        myHandler.sendEmptyMessageDelayed(0, 1500);// 间隔一秒切换一次
    }

    //viewPager2使用
    @SuppressLint("HandlerLeak")
    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            myHandler.sendEmptyMessageDelayed(0, 2000);
        }
    }

    private void initViewPager3() {


        //图片ID
        imageIds = new int[]{
                R.drawable.lunbo1,
                R.drawable.lunbo2,
                R.drawable.lunbo3
        };
        //图片标题
        titles = new String[]{
                "巩俐不低俗，我就不能低俗",
                "乐视网TV版大派送",
                "热血屌丝的反杀"
        };
        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);

            images.add(imageView);
        }
        //显示的点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));

        title = (TextView) findViewById(R.id.title);
        title.setText(titles[0]);

        viewPager3 = (ViewPager) findViewById(R.id.view_pager3);

        viewPagerAdapterThree = new ViewPagerAdapterThree(images);

        viewPager3.setAdapter(viewPagerAdapterThree);

        viewPager3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentPosition = position % (images.size());
                title.setText(titles[currentPosition]);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
                dots.get(currentPosition).setBackgroundResource(R.drawable.dot_focused);

                oldPosition = currentPosition;
                currentItem = currentPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        handler.sendEmptyMessage(1);
        initViewPagerTouchEvent();
        setFirstLocation();
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //设置当前页面
            currentItem = viewPager3.getCurrentItem();
            viewPager3.setCurrentItem(currentItem + 1);
            handler.sendEmptyMessageDelayed(1, 2000);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initViewPagerTouchEvent() {
        viewPager3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        //按下
                        handler.removeCallbacksAndMessages(null);
                    }
                    break;

                    case MotionEvent.ACTION_UP: {
                        //抬起
                        handler.sendEmptyMessageDelayed(1, 2000);

                    }
                    break;
                }
                return false;
            }
        });
    }

    private void setFirstLocation() {
        // mTvPagerTitle.setText(mImageTitles[previousPosition]);
        // 把ViewPager设置为默认选中Integer.MAX_VALUE / 2，从十几亿次开始轮播图片，达到无限循环目的;
        int m = (Integer.MAX_VALUE / 2) % images.size();
        int currentPosition = Integer.MAX_VALUE / 2 - m - 1;
        viewPager3.setCurrentItem(currentPosition);
    }
}