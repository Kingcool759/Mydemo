package com.example.mydemo.entity;

/**
 * @data on 2020/10/30 12:00 PM
 * @auther armStrong
 * @describe 书类，用于模拟建造者模式的实体类
 */
public class Book {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
