
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-10-24
 * Time: 22:14
 */
class Couse {
    String couseName;
    public void acKnow() {
        System.out.println("couse.acKnow");
    }
}

class Student {
    String name;
    double height;
    int age;
    Couse duration;

    public Student() {
        this.name = "小明";
        System.out.println(name);
    }

    public void eat() {
        System.out.println("eat<>");
    }

    public void study() {
        System.out.println("study<>");
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Student student = new Student();

        Couse couse = new Couse();
        student.duration = couse;
        couse.couseName = "Java程序设计";

        System.out.println(student.name + " " + student.height + " " + student.age + " " + student.duration);
        System.out.println(student.duration.couseName);
    }
}
