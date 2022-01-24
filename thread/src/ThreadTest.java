/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-09
 * Time: 9:51
 */
public class ThreadTest {
    /**
     * 常见的线程调度模型
     * 抢占式调度模型：
     *      哪个线程的优先级比较高，抢到的CPU时间片的概率就高一些
     *      java采用的就是抢占式调度模型
     * 均分式调度模型：
     *      平均分配CPU时间片。每个线程占有的CPU时间片时间长度一样
     *      平均分配，一切平等
     * @param args
     */
    public static void main(String[] args) {
        // main方法， 这里的代码属于主线程 在主栈中运行
        // 新建一个分支线程对象
        T t = new T();
        // 不能使用t.run()方法来启动线程，run()不会新建一个新的线程

        // 启动线程 开启一个新的栈空间，只要新的栈空间开出来了，start()方法也就结束了
        // t.start()只是开启线程栈空间。会调用run()方法，此时run()会在分支线程这个栈中压栈
        // run()和main()属于同一个级别，都是在栈中最底部
        t.start();
    }
}
class T extends Thread {
    @Override
    public void run() {
        T1 t1 = new T1(10);
        System.out.println(t1.toString());
        System.out.println("被执行了！");
    }
}
class T1 {
    private int age;

    public T1(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "T1{" +
                "age=" + age +
                '}';
    }
}