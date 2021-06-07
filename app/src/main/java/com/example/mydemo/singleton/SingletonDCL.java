package com.example.mydemo.singleton;

/**
 * @data on 2021/6/7 4:07 下午
 * @auther
 * @describe 《单例模式》
 */
public class SingletonDCL {
    /**
     * <==="懒汉式"--双重校验锁--===>
     * JDK 版本：JDK1.5 起
     * 是否 Lazy 初始化：是
     * 是否多线程安全：是
     * 实现难度：较复杂
     */

    private static volatile SingletonDCL instance;
    private SingletonDCL(){}

    public static  SingletonDCL  getInstance() {
        if(null == instance){
            synchronized (SingletonDCL.class){
                if(null == instance){
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
    /**
     * 相关问题：
     1、为什么synchronized关键字要放在SingletonDCL getInstance()方法内？
     2、为什么要在synchronized修饰代码段内再次加校验？
     3、为什么要对SingletonDCL.class加锁，而不是局部变量？
     4、为什么要使用volatile关键字修饰instance变量？
     5、双重校验锁第一次进行判空原因？
     6、双重校验锁第二次进行判空原因？
     */

    /**
     - 1、为什么synchronized关键字要放在SingletonDCL getInstance()方法内？

     答：对比《单例-懒汉式》**线程安全**的写法，之前为了解决了线程安全问题，采用synchronized关键字放在getInstance之前

     ```
     public static synchronized SingletonL getInstance() {……}
     ```

     这样的是可以解决线程安全问题，但因为每次调用getInstance()方法都需要检查锁🔒，性能低。

     因此，需要在没有初始化实例（instance=null）之前，对未初始化的对象加锁校验；第二次调用getInstance获取单例的时候，如果对象已被实例化，不会再校验锁。性能优化了～

     -  2、为什么要在synchronized修饰代码段内再次加校验？

     答：由于synchronized加在了getInstance方法内，因此导致线程不安全了，若要使线程安全，需要在synchronized修饰的代码块内再次进行if(null == instance){}校验，保证线程安全。

     -  3、为什么要对SingletonDCL.class加锁，而不是局部变量？

     答：首先要明确的一个点，就是synchronized关键字可以修饰什么？变量、代码块段、方法、对象。都可以，因为A线程、B线程其实都是对这个单例类进行访问，因此需要锁的是这个类对象！

     -  4、为什么要使用volatile关键字修饰instance变量？

     答：首先明确一个点：不加volatile线程就不安全了吗？当然不是，无论加不加volatile关键字，此时线程都是安全的，并且性能也高？那为什么要加volatile呢？禁止指令重排序！不被volatile修饰前，代码的执行顺序可能会改变，但被修饰之后，指令重排序被禁止。

     - 5、双重校验锁第一次进行判空原因？

     答：如果不进行判空，每个线程都会去获取这个当前类的类锁，而其他线程都进入阻塞状态。单例模式中初始化单例的程序只会执行一次，大部分情况下会直接到return语句返回，如果都阻塞在获取锁的位置，会大大降低程序的运行速度。

     -  6、双重校验锁第二次进行判空原因？

     答：假设有两个线程A和B，都进行完第一次判空了，A和B都阻塞在synchronized (SingletonDCL.class){……}之前。

     */
}
