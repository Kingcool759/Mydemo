package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case35);
        initView();
        layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new RecyclerGridAdapter(this, imgList,tvList));
        recycler.setItemAnimator(new DefaultItemAnimator());
    }

    private void initView() {
        recycler = findViewById(R.id.recycler);

        imgList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            String url1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601266292514&di=95c75c1bdc303eaca8cb525ee5d596fa&imgtype=0&src=http%3A%2F%2Fp.ssl.qhimg.com%2Fbdr%2F__85%2Fd%2F_open360%2Fcar0911%2F10.jpg";
            String url2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601266263658&di=ee89e964bc7596340e61e90f835c15e1&imgtype=0&src=http%3A%2F%2Fimg3.bitautoimg.com%2FVideo%2F2016%2F11%2F07%2F2016117152145523.jpg";
            String url3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601266292514&di=583cf250b05e57afcbaa5f87d3ef0fc7&imgtype=0&src=http%3A%2F%2Fimg1.gtimg.com%2Fauto%2Fpics%2Fhv1%2F39%2F154%2F1518%2F98747259.jpg";
            imgList.add(url1);
            imgList.add(url2);
            imgList.add(url3);
        }
        tvList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            tvList.add("#广告");
            tvList.add("#剧情");
            tvList.add("#运动");
            tvList.add("#创意");
        }
    }
}