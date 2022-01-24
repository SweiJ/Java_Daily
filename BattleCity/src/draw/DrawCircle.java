package draw;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 16:06
 */
@SuppressWarnings("all")
public class DrawCircle extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        this.mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("123");
//        g.drawOval(10,10,100,100);
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Study.jpg"));
        g.drawImage(image,10,10,150,150, this);
    }
}
