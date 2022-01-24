/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-10-24
 * Time: 9:03
 */

class Calculator {
    private double num1;
    private double num2;
    private char a;
    public Calculator(double num1) {
        System.out.println("calculator<double>");
    }
    public Calculator() {
        System.out.println("calculator<>");
    }
//    public double getNum1() {
//        switch (a) {
//            case '*':
//                return num1 * num2;
//            case '+' :
//                return num1 + num2;
//            case '-' :
//                return num1 - num2;
//            case '/' :
//                return num1 / num2;
//            default:
//                return 0;
//        }
//    }
//
//    public void setNum1(char a, double num1, double num2) {
//        this.num1 = num1;
//        this.num2 = num2;
//        this.a = a;
//    }

    public void getchangeNum() {
        System.out.println(num1);
        System.out.println(num2);
    }
    public void setChangeNum(double num1, double num2) {
        double temp = num1;
        num1 = num2;
        num2 = temp;
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", a=" + a +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator(100.2);

//        calculator1.setNum1('*', 10, 20);
//        System.out.println(calculator1.getNum1());
        calculator1.setChangeNum(10, 20);
        calculator1.getchangeNum();
    }
}
