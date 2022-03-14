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
            // ���Ի�ȡ���Ե�����
            System.out.println(declaredField.getName());
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(o));
        }
    }
    public static void main6(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // ��ȡ��ʱͬʱҲ��������ľ�̬�����
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

        // ����һ��ʵ������ Ĭ�ϵ����޲ι���
        Reflect o1 = (Reflect) aClass.newInstance();
        // ��ȡ�����е�setAge����
        Method fun = aClass.getMethod("fun", int.class, String.class);
        // ��ʵ��������o1��ִ��fun���� ���ص���
        System.out.println(fun.invoke(o1, 20, "xiaojiang"));
        Object o = fun.invoke(o1, 20, "xiaojiang");

        System.out.println(o1);
    }
    public static void main4(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("com.swei.Field.FieldTest");
        // ���������·��
        System.out.println(c.getName());
        // �������·��
        System.out.println(c.getSimpleName());
        //
        System.out.println(c.getTypeName());

        Field[] fields = c.getFields();
        // ���FieldTest����public���ε����Ը���
        System.out.println(fields.length);
        // ������ֶ����η������͡��ֶ�����
        System.out.println(fields[0]);
        // ����ֶε�����
        System.out.println(fields[0].getName());

        Field[] fields1 = c.getDeclaredFields();
        // ���������ȫ������
        System.out.println(fields1.length);

        System.out.println("==========================");
        for (Field field : fields1) {
            // ����ֶ�ǰ������η������ص���int����
            int i = field.getModifiers();
            String s = Modifier.toString(i);
            System.out.println(s);
            // �����ǰ�����ֶε����η�����������
//            System.out.println(field.getType());
            // �����ǰ�ֶε���������
//            System.out.println(field.getType().getName());
            // �����ǰ�ֶε����ͼ�����
//            System.out.println(field.getType().getSimpleName());
            // ������ֶ�����
//            System.out.println(field.getName());
        }
    }
    public static void main3(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // ��Դ������ֻ�ܰ�xxx.properties�ļ������ұ�������·����
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

        // ͨ�����췽����������
        Constructor<?> constructor = aClass1.getConstructor(String.class, int.class);
        Object o1 = constructor.newInstance("xiaojiang", 22);
        System.out.println(o1);

//        Relect o = (Relect) aClass1.newInstance();
//        System.out.println(o);

        System.out.println(aClass1.getName());
        System.out.println(aClass2.getName());
        System.out.println(aClass3.getName());

        /**
         * Thread.currentThread() ��ȡ��ǰ�߳�
         * getContextClassLoader() ��ǰ�̵߳��������
         * getResource("com.swei.www.TestOne.java") ��ʱ��������ķ�������ǰ�̵߳������������ĸ�Ŀ¼�¼�����Դ
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("TestOne.class").getPath();
        System.out.println(path);
    }
}
