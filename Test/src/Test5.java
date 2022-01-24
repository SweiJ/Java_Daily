/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-30
 * Time: 20:46
 */
public class Test5 {
    public static void main(String[] args) {
        Staff1[] staff1 = new Staff1[5];
        staff1[0] = new Worker(12*3000);
        staff1[1] = new Waiter(12*3000);
        staff1[2] = new Peasant(12*3000);
        staff1[3] = new Teacher1(12*3000, 50);
        staff1[4] = new Scientist(12*3000, 30000);
        for (int i = 0; i < 5; i++) {
            System.out.println(staff1[i]);
        }
    }
}
class Staff1 {
    protected int baseSalary;
    protected int classFee;
    protected int yearEndBonus;
}
class Worker extends Staff1 {
    public Worker(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "baseSalary=" + baseSalary +
                '}';
    }
}
class Peasant extends Staff1 {
    public Peasant(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Peasant{" +
                "baseSalary=" + baseSalary +
                '}';
    }
}
class Teacher1 extends Staff1 {
    public Teacher1(int baseSalary, int classFee) {
        this.baseSalary = baseSalary;
        this.classFee = classFee;
    }

    @Override
    public String toString() {
        return "Teacher1{" +
                "baseSalary=" + baseSalary +
                ", classFee=" + classFee +
                '}';
    }
}
class Scientist extends Staff1 {
    public Scientist(int baseSalary, int yearEndBonus) {
        this.baseSalary = baseSalary;
        this.yearEndBonus = yearEndBonus;
    }

    @Override
    public String toString() {
        return "Scientist{" +
                "baseSalary=" + baseSalary +
                ", yearEndBonus=" + yearEndBonus +
                '}';
    }
}
class Waiter extends Staff1 {
    public Waiter(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "baseSalary=" + baseSalary +
                '}';
    }
}