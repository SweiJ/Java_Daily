package org.example;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-09
 * Time: 11:13
 */
public class Student {
    private String name;
    private int age;

//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//        System.out.println(name + " " + age);
//    }

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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
