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
         * Ԫע�⣺������ע��ע�����͡��ġ�ע�⡱����ΪԪע��
         * ������Ԫע���У�
         *  1��Target
         *  2��Retention
         * ����Target��������ע����ע���ע�⡱���Գ�������Щλ����
         *      @Target(ElementType.METHON) ��ʾ����ע���ע�⡱ֻ�ܳ����ڷ�����
         * ����Retention��������ע����ע���ע�⡱���ձ���������
         *      @Retention(RetentionPolicy.SOURCE) ��ʾ��ע��ֻ�ܱ�����java��Դ�ļ���
         *      @Retention(RetentionPolicy.CLASS) ��ʾ��ע�ⱻ������class�ļ���
         *      @Retention(RetentionPolicy.RUNTIME) ��ʾ��ע�ⱻ������class�ļ��У����ҿ��Ա�������ƶ�ȡ��
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
