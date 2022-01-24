package tankgame2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-11
 * Time: 17:08
 */
public class Bullet implements Runnable {
    public int x;
    public int y;
    public int direct;
    public int speed = 8;
    public boolean is_inBound = true;

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0 :
                    y -= speed;
                    break;
                case 1 :
                    y += speed;
                    break;
                case 2 :
                    x -= speed;
                    break;
                case 3 :
                    x += speed;
                    break;
                default:
                    System.out.println("´íÎó£¡");
                    break;
            }
            if(x >= 0 && x < 1000 && y > 0 && y < 750) {
                System.out.println(Thread.currentThread().getName() + " x= " + x + " y= " + y);
            }
            else {
                is_inBound = false;
                break;
            }
        }
    }
}
