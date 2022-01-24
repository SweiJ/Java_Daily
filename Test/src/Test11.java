import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-06
 * Time: 8:18
 */
public class Test11 {
    public static void main(String[] args) {
        Student student1 = new Student("xiaojiang", 21);
        Student student2 = new Student("xiaoming", 22);
        Student student3 = new Student("xiaohong", 20);
        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put("xiaojiang", student1);
        hashMap.put("xiaoming", student2);
        hashMap.put("xiaohong", student3);

        for (Map.Entry<String, Student> stringStudentEntry : hashMap.entrySet()) {
            System.out.println(stringStudentEntry);
        }
        System.out.println("==================");
        Iterator<Map.Entry<String, Student>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
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
