package com.example.mydemo.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.databinding.ActivityCase3Binding;
import com.example.mydemo.entity.Student;

/**
 * @data on 2020/8/27 11:30 AM
 * @auther  armstrong
 * @describe DataBinding+ObservableField使用 （单向绑定刷新UI）
 */

@Route(path = ARouterPath.case3)
public class Case3 extends AppCompatActivity {
    private ActivityCase3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_case3);
        final Student student = new Student();
        student.stuName.set("李白");
        student.stuAge.set("22");
        binding.setStu(student);
        binding.btnChangeData.setOnClickListener((View v)->{
            student.stuName.set("夏侯惇");
            student.stuAge.set("29");
        });
    }
}