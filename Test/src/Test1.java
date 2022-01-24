import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-27
 * Time: 20:47
 */
public class Test1 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("小明",21, "学生");
        people[1] = new Person("小红",19, "学生");
        people[2] = new Person("小李",25, "程序员");
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = i; j < people.length - i - 1; j++) {
                if(people[j].age > people[j + 1].age) {
                    Person tmp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }
}
class Person {
    public String name;
    public int age;
    public String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}