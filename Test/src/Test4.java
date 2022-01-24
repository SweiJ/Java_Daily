/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 20:36
 * @author SweiJ
 */
public class Test4 {
    public static void main(String[] args) {
        GeneralStaff generalStaff = new GeneralStaff("–°¿Ó", 200, 50);
        generalStaff.printSalary();
    }
}
class Staff {
    protected String name;
    protected double salary;
    protected int day;

    public Staff(String name, double salary, int day) {
        this.name = name;
        this.salary = salary;
        this.day = day;
    }

    protected void printSalary() {
        System.out.println("Staff.printSalary");
    }
}
class Manager extends Staff {
    public Manager(String name, double salary, int day) {
        super(name, salary, day);
    }

    @Override
    protected void printSalary() {
        System.out.println("Salary : " + 1000+this.salary*day*1.2);
    }
}
class GeneralStaff extends Staff {
    public GeneralStaff(String name, double salary, int day) {
        super(name, salary, day);
    }

    @Override
    protected void printSalary() {
        System.out.println("Salary : " + this.salary*day*1.0);
    }
}