package com.example.mydemo.popupwindow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.example.mydemo.R;

/**
 * @data on 2020/9/14 9:18 AM
 * @auther
 * @describe
 */
public class TestPopupWindow extends PopupWindow {
    TestDataListener mTestDataListener;
    int type = 0;


    public TestPopupWindow(Context context) {
        super(context);
        View contentView = LayoutInflater.from(context).inflate(R.layout.popup_select_layout, null);
        //封装成CommonPopupWindow类
        setContentView(contentView);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });

        //初始化控件
        TextView takePhoto = (TextView)contentView.findViewById(R.id.take_photo);
        TextView picture = (TextView)contentView.findViewById(R.id.picture);
        TextView cancel = (TextView)contentView.findViewById(R.id.cancel);

        takePhoto.setOnClickListener((View)->{
            Log.i("TestPopupWindow: ","拍照");
            type = 0;
            if(mTestDataListener != null){
                mTestDataListener.getTestData(type);
            }
            dismiss();
        });

        picture.setOnClickListener((View)->{
            Log.i("TestPopupWindow: ","相册");
            type = 1;
            if(mTestDataListener != null){
                mTestDataListener.getTestData(type);
            }
            dismiss();
        });
        cancel.setOnClickListener((View)->{
            Log.i("TestPopupWindow: ","取消");
            type = 2;
            if(mTestDataListener != null){
                mTestDataListener.getTestData(type);
            }
            dismiss();
        });
    }
    //回调事件接口
    public interface TestDataListener {
        void getTestData(int type);
    }

    public void setTestClickaListener(TestDataListener testDataListener) {
        mTestDataListener = testDataListener;
    }
}
