package com.swei.Field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 12:10
 */
public class ReflectFieldAcquire {

    public static void main(String[] args) throws ClassNotFoundException {

        Class c = Class.forName("java.lang.String");
        StringBuffer str = new StringBuffer();
        str.append(Modifier.toString(c.getModifiers()) + " " + "class" + " " + c.getSimpleName() + " {\n");

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            str.append("\t" + Modifier.toString(field.getModifiers()) + " ");
            str.append(field.getType().getSimpleName() + " ");
            str.append(field.getName() + ";\n");
        }

        str.append("}");
        System.out.println(str);
    }
}
