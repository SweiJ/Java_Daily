/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 8:46
 */
public class Test16 {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.start();
    }
}
class Thread01 extends Thread {
    @Override
    public void run() {
        while(true) {
            for (int i = 0; i < 100; i++) {
                System.out.println("eat food " + i);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "xx");
            }
        }
    }
}
