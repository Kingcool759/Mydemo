package com.example.mydemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mydemo.R;

/**
 * @data on 2020/11/9 3:32 PM
 * @auther armStrong
 * @describe 自定义实心圆
 */
public class MyCircle extends View {
    private Context context;
    private Paint paint = new Paint();;
    //圆心
    private int center_x;
    private int center_y;
    //半径
    private int r;

    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得圆心
        center_x = getMeasuredWidth() / 2;
        center_y = getMeasuredHeight() / 2;
        //取小的为半径
        r = Math.min(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        paint.setAntiAlias(true); //抗锯齿
        //Style.FILL就是实心的圆，Style.STROKE只画圆的边，Style.FILL_AND_STROKE有边有实心
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(context.getResources().getColor(R.color.black)); //画笔颜色
//        canvas.drawColor(R.color.white); //画布颜色
        canvas.drawCircle(center_x, center_y, r, paint);
        super.onDraw(canvas);
    }
}
