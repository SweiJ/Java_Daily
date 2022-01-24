import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-11
 * Time: 13:23
 */

@SuppressWarnings("all")
public class ThreadTest03 extends JFrame {

    MyThread02 myThread02 = new MyThread02();
    public static void main(String[] args) {
        ThreadTest03 threadTest03 = new ThreadTest03();
    }
    public ThreadTest03() {
        Thread thread1 = new Thread(myThread02);

        this.add(myThread02);
        this.setSize(400,300);
        this.addKeyListener(myThread02);
        this.setVisible(true);

        thread1.setName("t1");

        thread1.setDaemon(true);

        thread1.start();
        while(true) {
            if(myThread02.getFlag() == 1) {
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        }
    }
}
class MyThread02 extends JPanel implements Runnable, KeyListener {
    private int flag;
    @Override
    public void run() {
        while(true) {
            if(Thread.currentThread().getName().equals("t1")) {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            flag = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}