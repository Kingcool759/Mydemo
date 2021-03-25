package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog77)
public class Case77 extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case77);

        btn = findViewById(R.id.btnANR);
        btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(;;){

                }
            }
        }));
    }
}