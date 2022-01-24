/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-08
 * Time: 20:42
 */
public class Test14 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}
class Tiger implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("ÀÏ»¢à»à»½Ð..." + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count >= 10) {
                break;
            }
        }

    }
}
class ThreadProxy implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
        target.run();
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start() {
        start0();
    }
    private void start0() {
        run();
    }
}
