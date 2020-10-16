package com.example.mydemo.show;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mydemo.R;
import com.example.mydemo.entity.Fruit;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Case11 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case11);

        Fruit fruit = new Fruit("苹果香蕉火龙果！",R.drawable.meizi);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collsping_Toolbar);
        ImageView fruitImageView = (ImageView)findViewById(R.id.fruit_image_view);
        TextView fruitContentText = (TextView)findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruit.getName());
        Glide.with(this).load(fruit.getImageId()).into(fruitImageView); //高清图使用glide压缩显示
        String fruitContent = generatorFruitContent(fruit.getName());
        fruitContentText.setText(fruitContent);
    }
    private String generatorFruitContent(String fruitName){
        StringBuilder fruitContent = new StringBuilder();
        for (int i=0;i<500;i++){
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
