package com.example.mydemo.singleton;

/**
 * @data on 2021/6/7 4:01 下午
 * @auther
 * @describe 《单例模式》
 */
public class SingletonE {

    /**
     * ----饿汉式----
     * 是否 Lazy 初始化：否
     * 是否多线程安全：是
     * 实现难度：易
     */
    private static SingletonE instance = new SingletonE();
    private SingletonE(){}
    public static SingletonE getInstance(){
        return instance;
    }
}
