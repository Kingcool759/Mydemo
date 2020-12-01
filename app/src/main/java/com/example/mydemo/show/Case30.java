package com.example.mydemo.show;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

//activity横竖屏切换时的生命周期变化
@Route(path = ARouterPath.case30)

public class Case30 extends AppCompatActivity {
    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";
    Integer mCurrentScore;
    Integer mCurrentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case30);
//        // 检查是否正在重新创建一个以前销毁的实例
//        if (savedInstanceState != null) {
//            // 从已保存状态恢复成员的值
//            mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
//            mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
//        } else {
//            // 可能初始化一个新实例的默认值的成员
//        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        // 调用父类交给系统处理，这样系统能保存视图层次结构状态
        super.onSaveInstanceState(savedInstanceState);
//        // 保存用户自定义的状态
//        savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
//        savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);
        Log.d("savedInstanceState: ", "savedInstanceState");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("savedInstanceState: ", "onSaveInstanceState");
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