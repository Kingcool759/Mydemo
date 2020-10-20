package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;
import com.example.mydemo.databinding.ActivityCase22Binding;
import com.example.mydemo.popupwindow.TestPopupWindow;
@Route(path = ARouterManager.Path.case22)

public class Case22 extends AppCompatActivity {
    private ActivityCase22Binding binding;
    TestPopupWindow popupWindow;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case22);
        showPopupWindow(binding.case22Layout);
    }
    private void showPopupWindow(View parent){
        binding.showPopupWindow.setOnClickListener((View)->{
            popupWindow = new TestPopupWindow(this);
            //定义PopupWindow的弹出位置
            popupWindow.showAtLocation(parent, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);//在activity的底部展示。
//            popupWindow.showAsDropDown(binding.showPopupWindow); //在某个控件下方弹出Popupwindow
            popupWindow.setTestClickaListener(new TestPopupWindow.TestDataListener() {
                @Override
                public void getTestData(int type) {
                    Log.d("test: ", String.valueOf(type)); //测试
                    switch (type){
                        case 0:  //拍照
                            Toast.makeText(getBaseContext(),"拍照",Toast.LENGTH_SHORT).show();
                            break;
                        case 1:  //相册
                            Toast.makeText(getBaseContext(),"相册",Toast.LENGTH_SHORT).show();
                            break;
                        case 2:  //取消
                            Toast.makeText(getBaseContext(),"取消",Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        });
    }

}