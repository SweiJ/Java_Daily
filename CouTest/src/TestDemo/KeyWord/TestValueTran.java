package TestDemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-01
 * Time: 19:02
 */
class Student {
    public final String name;
    public static final int age = 10;


    {
        name = "Ð¢¾´";
    }

//    static {
//        age = 12;
//    }
//    public Student(String name) {
//        this.name = name;
//    }
}
public class TestValueTran {
    public static void main(String[] args) {
        Student student = new Student();
//        Student.age = 10;
        System.out.println(student.name);
    }

}
