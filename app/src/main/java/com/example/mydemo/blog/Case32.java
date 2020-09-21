package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mydemo.R;

public class Case32 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("case32","==>>onCreate: B");

        setContentView(R.layout.activity_case32);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("case32","==>>onStart: B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("case32","==>>onResume: B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("case32","==>>onPause: B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("case32","==>>onStop: B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("case32","==>>onDestroy: B");
    }
}
