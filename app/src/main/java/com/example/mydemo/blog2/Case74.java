package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.hjq.toast.ToastUtils;

@Route(path = ARouterPath.blog74)
public class Case74 extends AppCompatActivity {

    private TextView tvShow;

    //TextView复制内容到剪贴板
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case74);
        tvShow = findViewById(R.id.tvShow);
        cloneThing();
    }

    private void cloneThing(){
        findViewById(R.id.etClone).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData mClipData = ClipData.newPlainText("Name", tvShow.getText().toString());
                clipboardManager.setPrimaryClip(mClipData);
                ToastUtils.show("复制成功");
                return false;
            }
        });
    }
}