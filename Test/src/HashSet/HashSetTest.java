package HashSet;

import java.util.HashSet;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-02
 * Time: 16:03
 */
public class HashSetTest {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate("2021","12","01");
        MyDate myDate2 = new MyDate("2021","12","01");
        Employee employee = new Employee("小李", "2999", myDate1);
        Employee employee1 = new Employee("小李", "3000", myDate2);
        HashSet<Employee> hashSet = new HashSet<Employee>();
        hashSet.add(employee);
        hashSet.add(employee1);

        for (Employee employee2 : hashSet) {
            System.out.println(employee2);
        }
    }
}
class Employee {
    private String name;
    private String sal;
    private MyDate brithday;

    public Employee(String name, String sal, MyDate brithday) {
        this.name = name;
        this.sal = sal;
        this.brithday = brithday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(brithday, employee.brithday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brithday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal='" + sal + '\'' +
                ", brithday:" + brithday +
                '}';
    }
}
class MyDate {
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(year, myDate.year) && Objects.equals(month, myDate.month) && Objects.equals(day, myDate.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return year + '.' + month + '.' + day;
    }
}
