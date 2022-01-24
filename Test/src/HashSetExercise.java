import java.util.HashSet;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-02
 * Time: 8:52
 */
@SuppressWarnings("all")
public class HashSetExercise {
    public static void main(String[] args) {
        /**
         * HashSet�ײ���HashMap
         * HashMap��ʵ�����������Ľ���� ����key��value
         * ����һ��table���� ÿ���±���һ��node���ĵ�����
         * putVal(hash(key), key, value, false, true)
         * HashSet
         *     Ҫ���������Ϊkey����ʱkeyͨ��hash�����ٽ���hashcode����ȡ�þ����㷨֮���ֵ�����ֵΪhashֵ
         *     value��Obiect[]ռλ û���õ�
         * ��putVal�����н������ݵ���Ӳ���
         *     ������һ��null��table������16������ռ䣬�����ݴﵽ0.75*size���ϣ�������Ϊ֮ǰ��������
         *     ͨ����ǰ���ݵ�hashֵ�Ը����ݽ��ж�λ����������������hashֵ��ͬʱ�����ʹ��equal�����Ե�ǰ���ݺ�
         *     ��ǰ��ŵ����ݽ��бȽϣ������ͬ���˳����������ͬ�����Ƚ���һ���������ݣ����������ͬ��Ȼ����
         *     �ӵ�����������һ����㡣
         */
        HashSet<Employee> employees = new HashSet<>();
        employees.add(new Employee("xaioming", 22));
        employees.add(new Employee("xaioming", 21));
        employees.add(new Employee("xiaijiang", 21));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * ��дequals��hashcode����
     * �����Hashset����Ӷ���ʱ��������Ƕ����hashֵ������֪��ÿ�������ڶ��в�ͬ���ڴ��ַ
     * ����ÿ������ܴ���ܲ���ͬ��������Ҫ��дequals��hashcode����
     * ��дhashcode�ö����е����Խ��бȽ϶����Ƕ���
     * ��дequalҲ�ǱȽ϶����е�����
     * @param o
     * @return
     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return age == employee.age && Objects.equals(name, employee.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
