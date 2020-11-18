package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;

@Route(path = ARouterPath.blog65)
public class Case65 extends AppCompatActivity {
    private EditText etSearch;
    private ImageView ivClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case65);
        initView();
        doClean();
        doSearch();
    }

    private void initView() {
        etSearch = findViewById(R.id.search);
        ivClear = findViewById(R.id.ivClear);
    }

    //当用户输入框为空，不显示清除按钮；不空，则显示清除按钮并且实现点击清除输入框内容
    private void doClean() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")){
                    ivClear.setVisibility(View.GONE);
                }else {
                    ivClear.setVisibility(View.VISIBLE);
                    //点击清空内容
                    ivClear.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            etSearch.setText("");
                        }
                    });
                }
            }
        });
    }

    //点击软键盘搜索按钮执行搜索操作
    private void doSearch() {
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    Toast.makeText(getBaseContext(), "执行搜索操作", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}