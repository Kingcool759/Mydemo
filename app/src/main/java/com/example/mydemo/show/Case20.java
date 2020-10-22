package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
//lambda表达式

@Route(path = ARouterPath.case20)

public class Case20 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case20);

        Button btnShow = findViewById(R.id.btn_LambdaShow);
//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getBaseContext(),"hello,千夜零一!",Toast.LENGTH_SHORT).show();
//            }
//        });

        btnShow.setOnClickListener((View)->{
            Toast.makeText(getBaseContext(),"hello,Lambda!",Toast.LENGTH_SHORT).show();
        });
    }
}

