package tankgame2;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 16:46
 */
public class MyHero extends Tank {
    public Vector<Bullet> myHeroBullet = new Vector<>();
    public MyHero(int x, int y) {
        super(x, y);
    }
}
