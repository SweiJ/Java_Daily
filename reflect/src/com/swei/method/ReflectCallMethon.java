package com.swei.method;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 17:54
 */
public class ReflectCallMethon {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class c = Class.forName("com.swei.method.ReflectTest");

        // 调用类的构造方法一
        Object o1 = c.newInstance();

        // 调用类的构造方法二
        Constructor constructor1 = c.getConstructor(String.class,int.class);
        Constructor constructor2 = c.getDeclaredConstructor(String.class,int.class);
        Constructor constructor3 = c.getConstructor();

        Object o2 = constructor2.newInstance("xiaojiang", 21);
        Object o3 = constructor3.newInstance();
        System.out.println(o3);

        Method method = c.getDeclaredMethod("fun3", Boolean.class);
        /**
         * 调用方法的四要素
         *     1、方法名
         *     2、返回值
         *     4、参数
         *     5、对象
         *  ret 返回值
         *  o 对象
         *  "xiaojiang",21 实参
         *  method 方法
         */
        Object ret = method.invoke(o1,true);
        System.out.println(ret);


    }
}
