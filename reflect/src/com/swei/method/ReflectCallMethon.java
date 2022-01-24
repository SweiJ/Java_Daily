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

        // ������Ĺ��췽��һ
        Object o1 = c.newInstance();

        // ������Ĺ��췽����
        Constructor constructor1 = c.getConstructor(String.class,int.class);
        Constructor constructor2 = c.getDeclaredConstructor(String.class,int.class);
        Constructor constructor3 = c.getConstructor();

        Object o2 = constructor2.newInstance("xiaojiang", 21);
        Object o3 = constructor3.newInstance();
        System.out.println(o3);

        Method method = c.getDeclaredMethod("fun3", Boolean.class);
        /**
         * ���÷�������Ҫ��
         *     1��������
         *     2������ֵ
         *     4������
         *     5������
         *  ret ����ֵ
         *  o ����
         *  "xiaojiang",21 ʵ��
         *  method ����
         */
        Object ret = method.invoke(o1,true);
        System.out.println(ret);


    }
}
