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
         * HashSet底层是HashMap
         * HashMap其实是数组和链表的结合体 具有key和value
         * 存在一个table数组 每个下标存放一个node结点的单链表
         * putVal(hash(key), key, value, false, true)
         * HashSet
         *     要加入的数据为key，此时key通过hash方法再进行hashcode方法取得经过算法之后的值，这个值为hash值
         *     value由Obiect[]占位 没有用到
         * 在putVal方法中进行数据的添加操作
         *     首先在一个null的table中扩容16个数组空间，当数据达到0.75*size以上，则扩容为之前的两倍。
         *     通过当前数据的hash值对该数据进行定位操作，当两个数据hash值相同时，则会使用equal方法对当前数据和
         *     当前存放的数据进行比较，如果相同则退出，如果不相同，则会比较下一个结点的数据，如果都不相同，然后添
         *     加到该链表的最后一个结点。
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
     * 重写equals和hashcode方法
     * 如果在Hashset中添加对象时，传入的是对象的hash值，我们知道每个对象都在堆中不同的内存地址
     * 所以每个对象很大可能不相同，所以需要重写equals和hashcode方法
     * 重写hashcode让对象中的属性进行比较而不是对象
     * 重写equal也是比较对象中的属性
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
