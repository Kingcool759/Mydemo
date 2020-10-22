package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog31)

public class Case31 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("case31","==>>onCreate: A");

        setContentView(R.layout.activity_case31);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener((View) -> {
            Intent intent = new Intent();
            intent.setClass(this, Case32.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("case31","==>>onStart: A");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("case31","==>>onResume: A");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("case31","==>>onPause: A");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("case31","==>>onStop: A");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("case31","==>>onDestroy: A");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("case31","==>>onRestart: A");
    }
}