package com.example.mydemo.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mydemo.R;

//求X的平方根
public class algorithm1 extends AppCompatActivity {
    private EditText etX;
    private Button btnAqrt;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm1);
        initView();
    }
    private void initView(){
        etX = findViewById(R.id.etX);
        btnAqrt = findViewById(R.id.btnAqrt);
        tvResult = findViewById(R.id.tvResult);
        btnAqrt.setOnClickListener((View)->{
            String str = sqrt(Integer.parseInt(etX.getText().toString().trim()))+"";
            tvResult.setText(str);
        });
    }
    private int sqrt(int x) {
        if (x < 0)  {
            throw new IllegalArgumentException();
        } else if (x <= 1) {
            return x;
        }

        int start = 1, end = x;
        // 直接对答案可能存在的区间进行二分 => 二分答案
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            }  else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end > x / end) {
            return start;
        }
        return end;
    }

}