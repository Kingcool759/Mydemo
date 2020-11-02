package com.example.mydemo.entity;

/**
 * @data on 2020/11/2 11:56 AM
 * @auther armStrong
 * @describe 泛型类
 */
public class Generic <T>{

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
