package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog57)
public class Case57 extends AppCompatActivity {
    //QQ号
    String qq = "30585877556";
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case57);
        initView();
        btn1.setOnClickListener((View)->{
            String url = "mqqwpa://im/chat?chat_type=wpa&uin=" + qq;
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
        btn2.setOnClickListener((View)->{
            //-   个人介绍界面
            String  url = "mqqapi://card/show_pslcard?src_type=internal&version=1&uin=" + qq
                    + "&card_type=person&source=qrcode";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
        btn3.setOnClickListener((View)->{
            //-   QQ公众号
            String url="mqq://im/chat?chat_type=crm&uin="+qq;
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
        btn4.setOnClickListener((View)->{
            //-   QQ群介绍界面
            String qunNum = "233209948";
            String  url = "mqqapi://card/show_pslcard?src_type=internal&version=1&uin=" + qunNum
                    + "&card_type=group&source=qrcode";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

    }

    private void initView() {
        btn1 = findViewById(R.id.btnGotoQQ1);
        btn2 = findViewById(R.id.btnGOtoQQ2);
        btn3 = findViewById(R.id.btnGOtoQQ3);
        btn4 = findViewById(R.id.btnGOtoQQ4);
    }
}
