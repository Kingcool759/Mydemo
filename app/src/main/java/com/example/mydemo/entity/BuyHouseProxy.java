package com.example.mydemo.entity;

/**
 * @data on 2020/10/30 4:31 PM
 * @auther armStrong
 * @describe 中介，做代理帮客户买房子（一条龙服务）
 */
public class BuyHouseProxy implements BuyHouse {

    public BuyHouse bHosue;

    public BuyHouseProxy(final BuyHouse buyhosue){
        this.bHosue = buyhosue;
    }

    @Override
    public void buyHosue() {
        System.out.println("买房前准备");
        bHosue.buyHosue();
        System.out.println("买房后装修");
    }
}
