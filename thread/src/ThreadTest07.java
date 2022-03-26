import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-26
 * Time: 15:29
 */
class Count {
    public int count;
    public void increase() {
        count++;
    }
}
public class ThreadTest07 {
//    public static Count count = new Count();
    public static volatile int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Thread t1 = new Thread(() -> {
            while(count == 0) {

            }
        });
        t1.start();
        System.out.println("请输入一个数:>");
        count = sc.nextInt();
        System.out.println("结束!");
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 50000; i++) {
//                count++;
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 50000; i++) {
//                count++;
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(count1);
    }
}
