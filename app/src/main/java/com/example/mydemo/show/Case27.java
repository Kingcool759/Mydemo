package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mydemo.R;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

public class Case27 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case27);
        TitleBar tb = findViewById(R.id.default_TitleBar);
        tb.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                //左边
                finish();
            }

            @Override
            public void onTitleClick(View v) {
                //中间
            }

            @Override
            public void onRightClick(View v) {
                //右边
            }
        });
    }
}