package com.swei.Field;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 15:59
 */
public class ReflectAcquireTest2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c = Class.forName("com.swei.Field.FieldTest");
        // 实例化FieldTest的对象o
        Object o = c.newInstance();

        // 获取该类中name成员
        Field nameField = c.getDeclaredField("name");
        // 设置实例化对象中name成员的值
        nameField.set(o,"xiaojiang");
        System.out.println(nameField.get(o));

        Field ageField = c.getDeclaredField("age");
        // 打破封装，这样设置，在外部也可以访问private修饰的属性
        ageField.setAccessible(true);

        ageField.set(o,1000);
        System.out.println(ageField.get(o));
    }
}
