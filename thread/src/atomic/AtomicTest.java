package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-01
 * Time: 16:19
 */
public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                integer.getAndIncrement();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                integer.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(integer);
    }
}
