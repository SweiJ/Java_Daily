/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-26
 * Time: 20:37
 */
public class ThreadTest08 {
    String str=new String("good");
    char[]ch={'a','b','c'};
    public static void main(String[] args) {
//        ThreadTest08 ex=new ThreadTest08();
//        ex.change(ex.str,ex.ch);
//        System.out.print(ex.str+" and ");
//        System.out.print(ex.ch);

        System.out.println(returnTest());
    }
    public void change(String str,char ch[]){
        //引用类型变量，传递的是地址，属于引用传递。
        str=new String("test ok");
        ch[0]='g';
    }
    public static boolean returnTest()
    {
        try
        {
            return true;
        }
        catch (Exception e)
        {
        }
        finally
        {
            return false;
        }
    }
    public static void main1(String[] args) {
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "c");


        Thread t2 = new Thread(() -> {
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }, "b");

        Thread t1 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }, "a");

        t1.start();
        t2.start();
        t3.start();
    }
}
