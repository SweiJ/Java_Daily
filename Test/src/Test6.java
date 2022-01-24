/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-04
 * Time: 18:56
 */
public class Test6 {
    public static void main(String[] args) {
        fun1(new Il() {
            @Override
            public void func() {
                System.out.println("小车在跑.....");
            }
        });
        Car car = new Car();
        car.func();
    }
    public static void fun1(Il il) {
        il.func();
    }
}
interface Il {
    void func();
}
class Car implements  Il {

    @Override
    public void func() {
        System.out.println("小车再跑~~~~~");
    }
}
