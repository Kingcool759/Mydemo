package com.example.mydemo.entity;

/**
 * @data on 2020/8/31 3:46 PM
 * @auther
 * @describe
 */
public class BaseResponse {
    public int error;
    public String msg;

    public int getError() {
        return error;
    }

    public void setError(int code) {
        this.error = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public boolean isSuccess() {
        if (error == 0) {
            return true;
        } else {
            return false;
        }
    }
}
