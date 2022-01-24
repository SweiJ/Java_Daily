import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-06
 * Time: 21:28
 */
@SuppressWarnings("all")
public class Test12 {
    public static void main(String[] args) {
        ArrayList<Employee1> arrayList = new ArrayList<>();
        arrayList.add(new Employee1("小包", 3000, new MyDate("12","3","2021")));
        arrayList.add(new Employee1("小红", 2001, new MyDate("12","2","2021")));
        arrayList.add(new Employee1("小包", 3000, new MyDate("12","1","2021")));
        arrayList.sort(new Comparator<Employee1>() {
            @Override
            public int compare(Employee1 o1, Employee1 o2) {
                int i = 0;
                if((i = new NameComparator().compare(o1, o2)) != 0) {
                    return i;
                }
                if((i = new SalComparator().compare(o1, o2)) != 0) {
                    return i;
                }
                return new BrithComparator().compare(o1, o2);
            }
        });
        for (Employee1 employee1 : arrayList) {
            System.out.println(employee1);
        }
    }
}
class NameComparator implements Comparator<Employee1> {
    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class SalComparator implements Comparator<Employee1> {
    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        return o1.getSal() - o2.getSal();
    }
}
class BrithComparator implements Comparator<Employee1> {
    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        int i = 0;
        if((i = o1.getBrithday().getYear().compareTo(o2.getBrithday().getYear())) != 0) {
            return i;
        }
        if((i = o1.getBrithday().getMonth().compareTo(o2.getBrithday().getMonth())) != 0) {
            return i;
        }
        return o1.getBrithday().getDay().compareTo(o2.getBrithday().getDay());
    }
}
class Employee1 {
    private String name;
    private int sal;
    private MyDate brithday;

    public Employee1(String name, int sal, MyDate brithday) {
        this.name = name;
        this.sal = sal;
        this.brithday = brithday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBrithday() {
        return brithday;
    }

    public void setBrithday(MyDate brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", brithday=" + brithday +
                '}';
    }
}
class MyDate {
    private String month;
    private String day;
    private String year;

    public MyDate(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }
}