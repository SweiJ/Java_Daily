package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-02
 * Time: 9:44
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建10个任务
        CountDownLatch count = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "到达终点");
                    // 每次完成一个任务 CountDownLatch内部计数器自减
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
        }
        // 等待10个任务全部完成
        count.await();
        System.out.println("比赛结束");
    }
}
