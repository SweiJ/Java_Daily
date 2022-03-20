/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 16:08
 */
public class ThreadTest04 {
    public static long num = 10_0000_0000;
    public static void serial() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
    }

    public static void parallel() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                i++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                i++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
    }
    public static void main(String[] args) throws InterruptedException {
        serial();
        parallel();
    }
}
