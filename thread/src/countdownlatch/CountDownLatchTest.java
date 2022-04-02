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
        // ����10������
        CountDownLatch count = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "�����յ�");
                    // ÿ�����һ������ CountDownLatch�ڲ��������Լ�
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
        }
        // �ȴ�10������ȫ�����
        count.await();
        System.out.println("��������");
    }
}
