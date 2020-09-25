package com.example.mydemo.entity;

/**
 * @data on 2020/8/27 9:47 PM
 * @auther  ArmStrong
 * @describe
 */
public class Fruit {
    private String name;
    private int imageId;
    private int type;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public Fruit(String name, int imageId, int type) {
        this.name = name;
        this.imageId = imageId;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
