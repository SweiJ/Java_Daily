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
        // ʵ����FieldTest�Ķ���o
        Object o = c.newInstance();

        // ��ȡ������name��Ա
        Field nameField = c.getDeclaredField("name");
        // ����ʵ����������name��Ա��ֵ
        nameField.set(o,"xiaojiang");
        System.out.println(nameField.get(o));

        Field ageField = c.getDeclaredField("age");
        // ���Ʒ�װ���������ã����ⲿҲ���Է���private���ε�����
        ageField.setAccessible(true);

        ageField.set(o,1000);
        System.out.println(ageField.get(o));
    }
}
