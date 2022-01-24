package extend;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-20
 * Time: 19:46
 */
public class InterfaceTest {

    public static void main1(String[] args) {
        Person[] person = new Person[3];
        person[0] = new Person("小明", 20, 168.2);
        person[1] = new Person("小红", 21, 178.4);
        person[2] = new Person("小李", 20, 199);

        NameComparator nameComparator = new NameComparator();
//        System.out.println(nameComparator.compare(person1, person2));

        Arrays.sort(person, nameComparator);
        System.out.println(Arrays.toString(person));

        AgeComparator ageComparator = new AgeComparator();
        Arrays.sort(person, ageComparator);
        System.out.println(Arrays.toString(person));

        RiseComparator riseComparator = new RiseComparator();
        Arrays.sort(person, riseComparator);
        System.out.println(Arrays.toString(person));
    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("小明", 20, 68);
        students[1] = new Student("小红", 21, 78);
        students[2] = new Student("小李", 20, 99);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
class Student implements Comparable<Student> {

    private String name;
    private int age;
    private float score;

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
class Person {
    private String name;
    private int age;
    private double rise;

    public Person(String name, int age, double rise) {
        this.name = name;
        this.age = age;
        this.rise = rise;
    }

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

    public double getRise() {
        return rise;
    }

    public void setRise(double rise) {
        this.rise = rise;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rise=" + rise +
                '}';
    }
}
class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
class RiseComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return (int)(o1.getRise() - o2.getRise());
    }
}