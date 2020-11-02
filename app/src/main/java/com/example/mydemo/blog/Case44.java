package com.example.mydemo.blog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.Generic;
import com.example.mydemo.entity.TestGenericImpl;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.blog44)

public class Case44 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case44);
//        error(); //基础测试:类型不相符会报错
//        compare(); //类型比较
//        useT1(); //使用泛型（传入实参）
//        useT2(); //使用泛型（不传实参）
//        useInterfaceT();//使用泛型接口
        useT3();
    }
    //泛型类
    private void error() {
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            Log.d("泛型测试","item = " + item);
            //报错：java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        }
    }
    private void compare(){
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            Log.d("泛型测试","类型相同");
            //输出结果：D/泛型测试: 类型相同
        }
    }

    private void useT1() {
        //Generic<T> g = new Generic<T>(xxx);
        //在传入实参的时候需要传入相应的类型
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Generic<String> genericString = new Generic<String>("key_vlaue");
        Log.d("泛型测试","key is " + genericInteger.getKey());
        Log.d("泛型测试","key is " + genericString.getKey());
        //输出结果：D/泛型测试: key is 123456
        //输出结果：D/泛型测试: key is key_vlaue
    }

    private void useT2() {
        //不用传实参，自动匹配
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        Log.d("泛型测试","key is " + generic.getKey());
        Log.d("泛型测试","key is " + generic1.getKey());
        Log.d("泛型测试","key is " + generic2.getKey());
        Log.d("泛型测试","key is " + generic3.getKey());
        //输出结果：D/泛型测试: key is 111111
        //输出结果：D/泛型测试: key is 4444
        //输出结果：D/泛型测试: key is 55.55
        //输出结果：D/泛型测试: key is false
    }

    //泛型接口
    private void useInterfaceT() {
        TestGenericImpl tgi = new TestGenericImpl();
        Log.d("泛型测试","key is "+tgi.next());
        //输出结果：D/泛型测试: key is Apple
    }

    //泛型通配符
    public void showKeyValue(Generic<Number> obj){
        Log.d("泛型测试","key value is " + obj.getKey());
    }
    public void showKeyValue1(Generic<?> obj){
        Log.d("泛型测试","key value is " + obj.getKey());
    }

    private void useT3(){
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
//        showKeyValue(gNumber);  //这句没问题
        // showKeyValue(gInteger);  //这句话编译中报错
        // showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
        // cannot be applied to Generic<java.lang.Number>

        //应该使用泛型通配符？如下写法，使用showKeyValue1方法。
        showKeyValue1(gNumber);
        showKeyValue1(gInteger);
        //输出结果：D/泛型测试: key value is 456
        //输出结果：D/泛型测试: key value is 123
    }
    //说明：范型方法相对上面几种更为复杂，也不太常用，以后用到再进行解析用法。
    //了解java中的泛型，必须熟悉上面集中常用的。
}
