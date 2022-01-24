/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-11
 * Time: 9:19
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread myThread1 = new MyThread1(o1, o2);
        Thread myThread2 = new MyThread2(o1, o2);

        myThread1.start();
        myThread2.start();
    }
}
class MyThread1 extends Thread {
    Object o1;
    Object o2;
    public MyThread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized(o1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {

            }
        }
    }
}
class MyThread2 extends Thread {
    Object o1;
    Object o2;
    public MyThread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized(o2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {

            }
        }
    }
}
