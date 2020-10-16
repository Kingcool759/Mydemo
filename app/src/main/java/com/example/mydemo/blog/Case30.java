package com.example.mydemo.blog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mydemo.R;

//activity横竖屏切换时的生命周期变化
public class Case30 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case30);


    }

    //重写该方法
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {       //横屏
            Toast.makeText(this, "横屏", Toast.LENGTH_SHORT).show();
        } else { //newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE  //竖屏
            Toast.makeText(this, "竖屏", Toast.LENGTH_SHORT).show();
        }
    }

    //重写一系列activity的生命周期方法，打印在控制台，看它们如何变化

    @Override
    protected void onStart() {
        super.onStart();
        Log.i( "armstrong","==>>onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i( "armstrong","==>>onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i( "armstrong","==>>onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i( "armstrong","==>>onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i( "armstrong","==>>onPause()");
    }
}