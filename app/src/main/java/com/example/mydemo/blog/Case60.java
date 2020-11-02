package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.BuyHouse;
import com.example.mydemo.entity.BuyHouseImpl;
import com.example.mydemo.entity.BuyHouseProxy;
import com.example.mydemo.entity.DynamicProxyHandler;

import java.lang.reflect.Proxy;

@Route(path = ARouterPath.blog60)
public class Case60 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case60);
        //调用实现静态代理
//        staticProxy();
        //调用实现动态代理jdk
        dynamicProxy();

        //CGLIB代理  //不写了
    }

    //静态代理
    private void staticProxy() {
        //自己买房
        BuyHouse buyHouse = new BuyHouseImpl();
        buyHouse.buyHosue();
        //代理帮助买房
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buyHosue();
    }

    //动态代理（JDK方式）
    //无需手动创建代理类对象，真正的代理对象由JDK再运行时为我们动态的来创建。
    private void dynamicProxy() {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        proxyBuyHouse.buyHosue();
    }
}
