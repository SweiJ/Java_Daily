import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-12
 * Time: 17:33
 */
public class Test17 {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        new Thread(new Consumer(list)).start();
        new Thread(new Product(list)).start();
    }
}
class Consumer implements Runnable {
    List l1 = null;

    public Consumer(List l1) {
        this.l1 = l1;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (l1) {
                if(l1.size() > 10) {
                    try {
                        l1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object obj = new Object();
                l1.add(obj);
                System.out.println(Thread.currentThread().getName() + "-->" + obj);
                l1.notifyAll();
            }
        }
    }
}
class Product implements Runnable {
    List l1 = null;

    public Product(List l1) {
        this.l1 = l1;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (l1) {
                if(l1.size() == 0) {
                    try {
                        l1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < l1.size(); i++) {
                    Object obj = l1.remove(i);
                    System.out.println(Thread.currentThread().getName() + "-->" + obj);
                }
                l1.notifyAll();
            }
        }
    }
}
