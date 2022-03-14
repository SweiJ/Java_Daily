package com.swei.Field;

import java.io.*;
import java.lang.reflect.*;
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

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.swei.Field.Reflect");
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);
        Reflect o = (Reflect) constructor.newInstance("zj", 22);

        Method method = aClass.getDeclaredMethod("fun", int.class, String.class);
        method.setAccessible(true);
        Object fun = method.invoke(o, 22, "zj");
        System.out.println(fun);
    }
    public static void main7(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.swei.Field.Reflect");
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);
        Reflect o = (Reflect) constructor.newInstance("zj", 22);

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.isAccessible());
            // 可以获取属性的名称
            System.out.println(declaredField.getName());
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(o));
        }
    }
    public static void main6(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 获取类时同时也加载了类的静态代码块
        Class<?> aClass = Class.forName("com.swei.Field.Reflect");

//        System.out.println(aClass.getName());
//        System.out.println(o.getClass());
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

        System.out.println(aClass.getTypeName());
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // 创建一个实例对象 默认调用无参构造
        Reflect o1 = (Reflect) aClass.newInstance();
        // 获取对象中的setAge方法
        Method fun = aClass.getMethod("fun", int.class, String.class);
        // 在实例化对象o1中执行fun方法 返回的是
        System.out.println(fun.invoke(o1, 20, "xiaojiang"));
        Object o = fun.invoke(o1, 20, "xiaojiang");

        System.out.println(o1);
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
    public static void main1(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        try {
            Class.forName("com.swei.Field.Reflect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> aClass1 = Class.forName("com.swei.Field.Reflect");

        Class<Reflect> aClass2 = Reflect.class;

        Reflect reflect = new Reflect();
        Class<? extends Reflect> aClass3 = reflect.getClass();

        System.out.println(aClass1);
        System.out.println(aClass2);
        System.out.println(aClass3);
        System.out.println(aClass1.equals(aClass2));
        System.out.println(aClass2.equals(aClass3));
        System.out.println(aClass1.equals(aClass3));

        ClassLoader classLoader = aClass1.getClassLoader();
        Class<?>[] declaredClasses = aClass1.getDeclaredClasses();

        // 通过构造方法创建对象
        Constructor<?> constructor = aClass1.getConstructor(String.class, int.class);
        Object o1 = constructor.newInstance("xiaojiang", 22);
        System.out.println(o1);

//        Relect o = (Relect) aClass1.newInstance();
//        System.out.println(o);

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
