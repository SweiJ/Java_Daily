package tankgame2;

import java.util.Random;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-11
 * Time: 19:55
 */
public class EmemyTank extends Tank implements Runnable {
    public Vector<Bullet> ememyBullet = new Vector<>();

    public EmemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while(true) {
            switch (getDirect()) {
                case 0 :
                    for (int i = 0; i < Math.random() * 30; i++) {
                        move_Up();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1 :
                    for (int i = 0; i < Math.random() * 30; i++) {
                        move_Down();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2 :
                    for (int i = 0; i < Math.random() * 30; i++) {
                        move_Left();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3 :
                    for (int i = 0; i < Math.random() * 30; i++) {
                        move_Right();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    System.out.println("´íÎó£¡");
                    break;
            }

            setDirect((int) (Math.random()*4));
            if(!isLive) {
                break;
            }
        }
    }
}
