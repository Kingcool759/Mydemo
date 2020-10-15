package com.example.mydemo.entity;

/**
 * @data on 2020/10/15 1:43 PM
 * @auther armstrong
 * @describe EventBus实战->定义消息事件类
 */
public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
