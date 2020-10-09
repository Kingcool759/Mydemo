package com.example.mydemo.entity;

import androidx.databinding.ObservableField;

/**
 * @data on 2020/8/27 1:43 PM
 * @auther armstrong
 * @describe  数据绑定示例
 */
public class Student {
    public final ObservableField<String> stuName = new ObservableField<>();
    public final ObservableField<String> stuAge = new ObservableField<>();

    public Student() {
    }
}
