package com.swei.annotation;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 20:39
 */
public class AnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        /**
         * 元注解：用来标注“注解类型”的“注解”，称为元注解
         * 常见的元注解有：
         *  1、Target
         *  2、Retention
         * 关于Target：用来标注“被注解的注解”可以出现在那些位置上
         *      @Target(ElementType.METHON) 表示“被注解的注解”只能出现在方法上
         * 关于Retention：用来标注“被注解的注解”最终保存在哪里
         *      @Retention(RetentionPolicy.SOURCE) 表示该注解只能保存在java的源文件中
         *      @Retention(RetentionPolicy.CLASS) 表示该注解被保存在class文件中
         *      @Retention(RetentionPolicy.RUNTIME) 表示该注解被保存在class文件中，并且可以被反射机制读取到
         */
        Class c = Class.forName("com.swei.annotation.AnnotationTest");
        Method m = c.getDeclaredMethod("fun");
        if(m.isAnnotationPresent(Id.class)) {
            Id i = m.getAnnotation(Id.class);
            System.out.println(i.value());
        }
        fun();
    }
    @Id(value="xiaojiang")
    public static void fun() {
        System.out.println();
    }
}
