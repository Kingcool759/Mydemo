package com.example.mydemo.show;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydemo.R;
import com.youth.banner.Banner;

//viewpager使用实现轮播图
public class Case8 extends AppCompatActivity {
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case8);
        banner = findViewById(R.id.banner);
    }
//    public void useBanner() {
//        //--------------------------简单使用-------------------------------
//        banner.addBannerLifecycleObserver(this)//添加生命周期观察者
//                .setAdapter(new BannerExampleAdapter(DataBean.getTestData()))
//                .setIndicator(new CircleIndicator(this));
//
//        //—————————————————————————如果你想偷懒，而又只是图片轮播————————————————————————
//        banner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {
//            @Override
//            public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
//                //图片加载自己实现
//                Glide.with(holder.itemView)
//                        .load(data.imageUrl)
//                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
//                        .into(holder.imageView);
//            }
//        })
//                .addBannerLifecycleObserver(this)//添加生命周期观察者
//                .setIndicator(new CircleIndicator(this));
//    }
}