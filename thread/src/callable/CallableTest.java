package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-02
 * Time: 9:20
 */
public class CallableTest {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        // 任务类
        FutureTask<Integer> task = new FutureTask<>(callable);

        Thread t = new Thread(task);

        t.start();

        // 当线程没有完成, get方法会阻塞
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
