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
        // �ź��� ��ʼ��������Դ4��
        Semaphore semaphore = new Semaphore(4);
        // ������Դp����
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
