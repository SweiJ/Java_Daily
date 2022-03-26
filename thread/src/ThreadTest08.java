/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-26
 * Time: 20:37
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "c");


        Thread t2 = new Thread(() -> {
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }, "b");

        Thread t1 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }, "a");

        t1.start();
        t2.start();
        t3.start();
    }
}
