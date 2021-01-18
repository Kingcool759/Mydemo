package com.example.mydemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @data on 12/14/20 9:27 AM
 * @auther  armStrong
 * @describe 商品标签
 */
public class TagView extends androidx.appcompat.widget.AppCompatTextView {
    public TagView(Context context) {
        super(context);
    }

    public TagView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        //倾斜度45,上下左右居中
        canvas.rotate(45, getMeasuredWidth()/3, getMeasuredHeight()/3);
        super.onDraw(canvas);
    }
}
