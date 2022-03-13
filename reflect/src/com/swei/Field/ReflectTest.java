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
         * Thread.currentThread() ��ȡ��ǰ�߳�
         * getContextClassLoader() ��ǰ�̵߳��������
         * getResource("com.swei.www.TestOne.java") ��ʱ��������ķ�������ǰ�̵߳������������ĸ�Ŀ¼�¼�����Դ
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("TestOne.class").getPath();
        System.out.println(path);
    }
}
