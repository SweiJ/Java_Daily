/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-26
 * Time: 13:17
 */

public class ThreadTest06 {

    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }
    public static void main4(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread);
        });

        t1.start();
        System.out.println(Thread.currentThread());
    }
    public static void main3(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1.run");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        t1.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("main.run");
            Thread.sleep(200);
        }
    }
    public static void main2(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {
                    System.out.println("t1.run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("½áÊø!");
                        break;
                    }
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
    }
    public static boolean flag = false;

    public static void main1(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while(!flag) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1.run");
                }
            }
        };

        t1.start();
        Thread.sleep(5000);
        flag = true;
    }
}
