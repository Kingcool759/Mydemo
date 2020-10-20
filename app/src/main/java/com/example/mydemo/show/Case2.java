package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;
import com.example.mydemo.view.SelfDialog;
import com.hjq.toast.ToastUtils;

/**
 * @data on 2020/8/25 11:30 AM
 * @auther      ArmStrong
 * @describe  退出应用程序
 */

@Route(path = ARouterManager.Path.case2)
public class Case2 extends AppCompatActivity {
    private SelfDialog selfDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2);
        findViewById(R.id.end_app).setOnClickListener(View->{alert();});
    }
    private void alert(){
        selfDialog = new SelfDialog(this);
        selfDialog.setTitle("退出应用程序");
        selfDialog.setMessage("确定退出应用?");
        selfDialog.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                ToastUtils.show("确定"); //消息提示
                selfDialog.dismiss();
            }
        });
        selfDialog.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                ToastUtils.show("取消"); //消息提示
                selfDialog.dismiss();
            }
        });
        selfDialog.show();
    }
}