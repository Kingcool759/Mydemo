package com.example.mydemo.singleton;

/**
 * @data on 2021/6/7 3:41 下午
 * @auther
 * @describe 《单例模式》
 */

public class SingletonL {
    private static SingletonL instance;
    private SingletonL(){ }

    /**
     * <==="懒汉式"===>
     * 是否 Lazy 初始化：是
     * 是否多线程安全：否
     * 实现难度：易
     */
//    public SingletonL getInstance(){
//        if (null == instance){
//            instance = new SingletonL();
//        }
//        return instance;
//    }

    /**
     * <==="懒汉式"-线程安全===>
     * 是否多线程安全：是
     * 实现难度：易
     * 缺点：线程安全了，但每次实例化需要检查锁，性能低。
     */
//    public static synchronized SingletonL getInstance() {
//        if (null == instance){
//            instance = new SingletonL();
//        }
//        return instance;
//    }
}
