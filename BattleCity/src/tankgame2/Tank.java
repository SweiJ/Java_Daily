package tankgame2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 16:45
 */
@SuppressWarnings("all")
public class Tank {
    private int x;
    private int y;
    private int direct;
    private int type;
    private int speed = 3;
    public boolean isLive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ÒÆ¶¯
    public void move_Up() {
        if(y > 0) {
            y -= speed;
        }
    }
    public void move_Down() {
        if(y + 60 < 750) {
            y += speed;
        }
    }
    public void move_Left() {
        if(x > 0) {
            x -= speed;
        }
    }
    public void move_Right() {
        if(x + 60 < 1000) {
            x += speed;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}