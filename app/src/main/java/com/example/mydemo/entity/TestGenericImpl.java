package com.example.mydemo.entity;

import java.util.Random;

/**
 * @data on 2020/11/2 12:12 PM
 * @auther  armStrong
 * @describe 泛型接口-实现类（当实现泛型接口的类，传入泛型实参时）
 */
public class TestGenericImpl implements TestGeneric<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
