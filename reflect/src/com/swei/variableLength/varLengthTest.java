package com.swei.variableLength;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 16:41
 */
public class varLengthTest {
    public static void main(String[] args) {
//        m1(1,2,3,4,5);
        m2("��", "��", "С", "��");
        m3("xiaojiang", 19,100,100,199);
    }
    // �ɱ䳤����ֻ����һ��������ֻ���ڷ������
    public static void m1(int... a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
    public static void m2(String... a) {
        for (String i : a) {
            System.out.print(i + " ");
        }
    }
    public static void m3(String str, int... a) {
        System.out.println(str);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
