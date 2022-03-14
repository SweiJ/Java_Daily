package com.swei.Field;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 9:08
 */
public class Reflect {
    static {
        System.out.println("静态代码块！");
    }

    private String user_name;
    private int age;

    public Reflect() {
        System.out.println("调用了无参构造方法!");
    }

    public Reflect(String user_name, int age) {
        this.user_name = user_name;
        this.age = age;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int fun(int a, String b) {
        System.out.println("Reflect.fun" + b);
        return a;
    }

    @Override
    public String toString() {
        return "Relect{" +
                "user_name='" + user_name + '\'' +
                ", age=" + age +
                '}';
    }
}
