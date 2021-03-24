package com.example.mydemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @data on 3/18/21 11:14 AM
 * @auther  zhaojianwei
 * @describe  自定义View
 */
public class MyDiyView extends View {

    public MyDiyView(Context context) {
        super(context);
    }

    public MyDiyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDiyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyDiyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("MyDiyViewTest:==>","onMeasure()");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("MyDiyViewTest:==>","onLayout()");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("MyDiyViewTest:==>","onDraw()");
    }

}
