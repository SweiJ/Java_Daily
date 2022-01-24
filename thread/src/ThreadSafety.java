/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 16:35
 */
public class ThreadSafety {
    /**
     * 什么时候数据在多线程并发会存在的安全问题
     *  1、多线程并发
     *  2、有共享数据
     *  3、共享数据有修改的行为
     * 线程同步：实际上是线程不能并发，线程必须排队
     *  异步编程模型：线程1和线程2，各自执行各自的，谁也不影响谁（多线程并发）
     *  同步编程模型：线程1和线程2，在线程1执行的时候线程2不能执行（排队）
     * @param args
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
//        Bank b = new Bank("acc-01", 300000);
//        MyThread01 myThrea01  = new MyThread01(b);
//        Thread thread1 = new Thread(myThrea01, "t1");
//        Thread thread2 = new Thread(myThrea01, "t2");

//        Thread thread1 = new MyThread01(b);
//        Thread thread2 = new MyThread01(b);
//
//        Thread thread1 = new Thread(Bank, "t1");
//        Thread thread2 = new Thread(Bank, "t2");
//        thread1.setName("t1");
//        thread2.setName("t2");

        Thread thread1 = new Bank();
        Thread thread2 = new Bank();
        thread1.start();
        thread2.start();
    }
}
//class MyThread01 implements Runnable {
//    Bank b;
//    public MyThread01(Bank b) {
//        this.b = b;
//    }
//
//    @Override
//    public void run() {
//        synchronized (this) {
//            b.withdraw(20000);
//            System.out.println(Thread.currentThread().getName() + " " + b.getBalance());
//        }
//    }
//}
class MyThread01 extends Thread {
//    Bank b;
//    public MyThread01(Bank b) {
//        this.b = b;
//    }

//    @Override
//    public void run() {
//        synchronized (this) {
//            Bank.withdraw(20000);
//            System.out.println(Thread.currentThread().getName() + " " + Bank.getBalance());
//        }
//    }
}
class Bank extends Thread {
    private String countName;
    private static int balance = 200000;

//    public Bank(String countName, int balance) {
//        this.countName = countName;
//        this.balance = balance;
//    }

    public String getCountName() {
        return countName;
    }

    public void setCountName(String countName) {
        this.countName = countName;
    }

    public int getBalance() {
        return balance;
    }

//    public void setBalance(int balance) {
//        this.balance = balance;
//    }

    public static synchronized void withdraw(int num) {
        balance = balance - num;
    }

    @Override
    public void run() {
        withdraw(20000);
        System.out.println(Thread.currentThread().getName() + " " + getBalance());
    }
}