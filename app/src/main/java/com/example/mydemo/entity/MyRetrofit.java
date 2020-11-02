package com.example.mydemo.entity;

import android.os.Build;

import java.util.List;

/**
 * @data on 2020/10/30 12:07 PM
 * @auther armStrong
 * @describe 含有建造者的类，用于模拟建造者模式（Retrofit中的常用模式）
 */
public class MyRetrofit {
    private String name;
    private int age;
    private List<Book> datas;

    public MyRetrofit(String name, int age, List<Book> datas) {
        this.name = name;
        this.age = age;
        this.datas = datas;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return datas;
    }

    //建造者模式具体实现代码
    public static final class Builder{
        private String name;
        private int age;
        private List<Book> datas;
        public Builder(){

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setList(List<Book> books) {
            this.datas = books;
            return this;
        }

        public MyRetrofit build(){
            return new MyRetrofit(this.name,this.age,this.datas);
        }
    }
}
