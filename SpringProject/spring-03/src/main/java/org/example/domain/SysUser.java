package org.example.domain;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-09
 * Time: 16:14
 */
public class SysUser {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
