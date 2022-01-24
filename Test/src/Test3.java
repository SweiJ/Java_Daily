/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-29
 * Time: 17:42
 */
public class Test3 {
    public static void main(String[] args) {
        Teacher teacher = new Professor("¡ıΩÃ ⁄", 21, "ΩÃ ⁄");
        teacher.introduce();
    }
}
class Teacher {
    protected String name;
    protected int age;
    protected String post;
    protected double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("Lecturer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}');
    }
}
class Professor extends Teacher {

    public Professor(String name, int age, String post) {
        super(name, age, post, 1.3);
    }
}
class AssociateProfessor extends Teacher {

    public AssociateProfessor(String name, int age, String post) {
        super(name, age, post, 1.2);
    }
}
class Lecturer extends Teacher {

    public Lecturer(String name, int age, String post) {
        super(name, age, post, 1.1);
    }
}
