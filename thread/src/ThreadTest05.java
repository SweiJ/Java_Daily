import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-22
 * Time: 20:04
 */

class ThreadTest1 extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadTest1.run");
    }
}
class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadTest2.run");
    }
}
public class ThreadTest05 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 01");
            }
        };
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 02");
            }
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread 03");
        });

        ThreadTest1 threadTest1 = new ThreadTest1();
        threadTest1.start();

        Thread thread = new Thread(new ThreadTest2());
        thread.start();

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static int sum = 0;
    public static int[] arr = new int[1000_0000];
    public static void main1(String[] args) throws InterruptedException {
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(100);
        }

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr.length; i+=2) {
                sum += arr[i];
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < arr.length; i+=2) {
                sum += arr[i];
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sum);
    }
}
