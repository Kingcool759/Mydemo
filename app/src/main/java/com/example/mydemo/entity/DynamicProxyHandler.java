package com.example.mydemo.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @data on 2020/10/30 4:55 PM
 * @auther armStrong
 * @describe 动态代理处理器类
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前准备");
        Object result = method.invoke(object, args);
        System.out.println("买房后装修");
        return result;
    }
}
