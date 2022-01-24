package com.swei.method;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 16:56
 */
@SuppressWarnings("all")
public class ReflectMethodAcquire {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        StringBuffer str = new StringBuffer();
        Class c = Class.forName("com.swei.method.ReflectTest");

        str.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + " {\n");

        Method[] m = c.getDeclaredMethods();
        for (Method method : m) {
            str.append("\t" + Modifier.toString(method.getModifiers()) + " ");
            str.append(method.getReturnType() + " ");
            str.append(method.getName() + "(");
            // 获取参数类型
            Class[] parameters = method.getParameterTypes();
            for (Class parameter : parameters) {
                str.append(parameter.getSimpleName() + " ");
//                Field[] field = parameter.getDeclaredFields();
            }
            str.append(") {\n\n\t}\n");
        }

        str.append("}");
        System.out.println(str);
//        System.out.println(c.getSimpleName());
//        Method[] m = c.getMethods();
        // 返回的是具体方法
//      Method m = c.getDeclaredField("fun1");
        // 返回所有方法
//        Method[] m = c.getDeclaredMethods();
//        for (Method method : m) {
//            System.out.print(Modifier.toString(method.getModifiers()) + " ");
//            System.out.print(method.getReturnType() + " ");
//            System.out.print(method.getName());
//            System.out.print("(");
//            Class[] parameters = method.getParameterTypes();
//            for (Class parameter : parameters) {
//                System.out.print(parameter.getSimpleName() + " ");
//                Field[] field = parameter.getDeclaredFields();
//
//            }
//            System.out.print(")");
//            System.out.println();
//        }
    }
}
