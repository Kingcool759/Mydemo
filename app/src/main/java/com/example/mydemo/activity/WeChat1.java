package com.example.mydemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterManager;
import com.hjq.toast.ToastUtils;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

//调用第三方微信登陆
@Route(path = ARouterManager.Path.weChat1)
public class WeChat1 extends AppCompatActivity {
    private TextView tvGotoWeChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat1);
        initView();
    }
    private void initView(){
        tvGotoWeChat = findViewById(R.id.tvGotoWeChat);
        tvGotoWeChat.setOnClickListener((View)->{
            startWxLogin();
        });
    }
    //微信登陆
    private void startWxLogin(){
        //第三方微信登陆初始化
        String appID = "27579044cf1d285afd0df0d7e19904e1";
        IWXAPI api = WXAPIFactory.createWXAPI(this, appID, true);
        api.registerApp(appID);
        if (!api.isWXAppInstalled()) {
            ToastUtils.show("您还未安装微信");
        } else {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo"; //表示需要获取个人信息（登陆功能）。
//            req.state = "zhys_wxlogin"; //非必须，用于保持请求和回调的状态，授权请求后原样带回给第三方。
            api.sendReq(req);
        }
    }
}
