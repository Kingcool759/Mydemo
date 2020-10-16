package com.example.mydemo.entity;

/**
 * @data on 2020/10/16 2:59 PM
 * @auther armstrong
 * @describe 微信第三方登陆使用EventBus用到
 */
public class Event {
    private String code;
    private String codeName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Event(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }
}
