package tankgame2;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 16:51
 */
@SuppressWarnings("all")
public class TankGame extends JFrame {

    //∂®“ÂMyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
//        Runtime runtime = Runtime.getRuntime();
//        System.out.println(runtime.availableProcessors());
        TankGame tankGame = new TankGame();
    }
    public TankGame() {
        mp = new MyPanel();
        this.add(mp);
        Thread t2 = new Thread(mp);
        t2.start();
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
