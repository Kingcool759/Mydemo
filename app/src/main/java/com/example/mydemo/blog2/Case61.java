package com.example.mydemo.blog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydemo.R;
import com.example.mydemo.arouter.ARouterPath;
import com.example.mydemo.entity.User;

@Route(path = ARouterPath.blog61)
public class Case61 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case61);
        try {
            main();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void main() throws ClassNotFoundException {
        //1、第一种方式，Class.forName("全类名")
        Class clazz1 = Class.forName("com.example.mydemo.entity.User");
        System.out.println(clazz1);  //输出结果：I/System.out: class com.example.mydemo.entity.User
        //2、第二种方式，类名.class
        Class clazz2 = User.class;
        System.out.println(clazz2);  //输出结果：I/System.out: class com.example.mydemo.entity.User
        //3、第三种方式，已经具有对象，使用对象.getClass
        User user = new User();
        Class clazz3 = user.getClass();
        System.out.println(clazz3);  //输出结果：I/System.out: class com.example.mydemo.entity.User

        //比较三个对象的内存地址是否相同
        System.out.println(clazz1 == clazz2);  //输出结果：I/System.out: true
        System.out.println(clazz2 == clazz3);  //输出结果：I/System.out: true
        //结论：同一个字节码文件，在同一个程序运行的过程中，只会被加载一次，三种方式获取的Class对象都是同一个。
    }
}