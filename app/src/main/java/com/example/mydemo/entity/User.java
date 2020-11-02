package com.example.mydemo.entity;

/**
 * @data on 2020/11/2 9:50 AM
 * @auther armStrong
 * @describe 探究java中的反射机制-User类
 */
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //全参
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //无参
    public User() {
        super();
    }

    //方法
    private void eat(){
        System.out.println("吃东西！");
    }
}
