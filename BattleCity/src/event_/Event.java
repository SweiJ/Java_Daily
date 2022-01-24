package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 21:03
 */
public class Event extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Event event = new Event();

    }
    public Event() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    // 当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
