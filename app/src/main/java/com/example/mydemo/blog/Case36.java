package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.databinding.ActivityCase36Binding;

@Route(path = ARouterPath.blog36)

public class Case36 extends AppCompatActivity {
    private ActivityCase36Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case36);

        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601265919949&di=c7c5e52a17014e19d0512a0175fe3b05&imgtype=0&src=http%3A%2F%2Fimg4.cache.netease.com%2Fphoto%2F0008%2F2012-08-22%2F89HAR42F294U0008.jpg";
        Glide.with(this).load(url).into(binding.glideIv);
    }
}