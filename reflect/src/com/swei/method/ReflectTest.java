package com.swei.method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-14
 * Time: 16:57
 */
public class ReflectTest {
    private int age;
    private String name;

    public ReflectTest() {

    }
    public ReflectTest(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int fun1(String name, int age) {
        name = "xiaojiang";
        age = 19;
        return age;
    }
    public Boolean fun3(Boolean bool) {
        return bool;
    }
    public void fun2() {
        System.out.println("xiaojiang");
    }
    @Override
    public String toString() {
        return "ReflectTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
