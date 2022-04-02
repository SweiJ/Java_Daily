package semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-02
 * Time: 9:41
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        // 信号量 初始化可用资源4个
        Semaphore semaphore = new Semaphore(4);
        // 申请资源p操作
        semaphore.acquire();
        System.out.println("success!");
        semaphore.acquire();
        System.out.println("success!");
        semaphore.acquire();
        System.out.println("success!");
        semaphore.acquire();
        System.out.println("success!");
        semaphore.acquire();
        System.out.println("success!");
    }
}
