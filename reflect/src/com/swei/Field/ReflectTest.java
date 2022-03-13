package com.swei.Field;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 9:08
 */
public class ReflectTest {

    public static void main5(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("com.swei.Field.FieldTest");
        System.out.println(c.getName());
    }
    public static void main4(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("com.swei.Field.FieldTest");
        // 输出完整类路径
        System.out.println(c.getName());
        // 输出简单类路径
        System.out.println(c.getSimpleName());
        //
        System.out.println(c.getTypeName());

        Field[] fields = c.getFields();
        // 输出FieldTest类中public修饰的属性个数
        System.out.println(fields.length);
        // 输出该字段修饰符、类型、字段名称
        System.out.println(fields[0]);
        // 输出字段的名称
        System.out.println(fields[0].getName());

        Field[] fields1 = c.getDeclaredFields();
        // 输出该类中全部属性
        System.out.println(fields1.length);

        System.out.println("==========================");
        for (Field field : fields1) {
            // 输出字段前面的修饰符，返回的是int类型
            int i = field.getModifiers();
            String s = Modifier.toString(i);
            System.out.println(s);
            // 输出当前类中字段的修饰符和类型名称
//            System.out.println(field.getType());
            // 输出当前字段的类型名称
//            System.out.println(field.getType().getName());
            // 输出当前字段的类型简单名称
//            System.out.println(field.getType().getSimpleName());
            // 输出该字段名称
//            System.out.println(field.getName());
        }
    }
    public static void main3(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 资源绑定器，只能绑定xxx.properties文件，而且必须是类路径下
        ResourceBundle bundle = ResourceBundle.getBundle("classinfo");
        String path = bundle.getString("classpath");
        System.out.println(bundle.getString("classpath"));

        Class c = Class.forName(path);
        Object o = c.newInstance();
        System.out.println(o);
    }
    public static void main2(String[] args) throws IOException {
//        String path = Thread.currentThread().getContextClassLoader().getResource("classinfo.properties").getPath();
//        FileReader reader = new FileReader(path);

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("classinfo.properties");

        Properties pro = new Properties();
        pro.load(in);

        String classpath = pro.getProperty("classpath");
        System.out.println(classpath);
        in.close();
    }
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.swei.Field.Relect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> aClass1 = Class.forName("com.swei.Field.Relect");

        Class<Relect> aClass2 = Relect.class;

        Relect relect = new Relect();
        Class<? extends Relect> aClass3 = relect.getClass();

        System.out.println(aClass1.getName());
        System.out.println(aClass2.getName());
        System.out.println(aClass3.getName());

        /**
         * Thread.currentThread() 获取当前线程
         * getContextClassLoader() 当前线程的类加载器
         * getResource("com.swei.www.TestOne.java") 这时类加载器的方法，当前线程的类加载器从类的根目录下加载资源
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("TestOne.class").getPath();
        System.out.println(path);
    }
}
