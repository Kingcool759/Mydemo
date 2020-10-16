package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mydemo.R;

public class Case41 extends AppCompatActivity {
    private EditText etStr;
    private Button btnChange;
    private TextView tvStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case41);
        //初始化控件
        initView();
        btnChange.setOnClickListener((View)-> tvStr.setText(reverse(etStr.getText().toString().trim())));
    }
    private void initView(){
        etStr = findViewById(R.id.etString);
        btnChange = findViewById(R.id.btnChange);
        tvStr = findViewById(R.id.tvString);
    }
    //转化函数
    private String reverse(String src){
        return new StringBuffer(src).reverse().toString();
    }
}
