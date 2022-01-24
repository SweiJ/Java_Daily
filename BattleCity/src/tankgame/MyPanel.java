package tankgame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 16:47
 */
@SuppressWarnings("all")
public class MyPanel extends JPanel {
    // �����Լ���̹��
    MyHero myHero = null;
    public MyPanel() {
        myHero = new MyHero(100, 100);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        Random random = new Random(100);
        int i = random.nextInt();
        // ̹�˷�װ
        paintTank(myHero.getX(), myHero.getY(), g, 0, 1);
    }

    /**
     *
     * @param x ̹�����Ͻ�x����
     * @param y ̹�����Ͻ�y����
     * @param g ����
     * @param direct ̹�˷����������ң�
     * @param type ̹������
     */
    public void paintTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0 :
                g.setColor(Color.CYAN);
                break;
            case 1 :
                g.setColor(Color.PINK);
                break;
        }
        switch (direct) {
            case 0 : // ����
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x+10, y+20, 20, 30, false);
                g.fill3DRect(x+30, y, 10,60, false);
                g.fillOval(x+10,y+20,20,20);
//                g.drawLine(x+15,y+20,x+15,y);
//                g.drawLine(x+25,y+20,x+25,y);
                g.drawLine(x+20,y+20,x+20,y);
                g.drawLine(x+15,y,x+25,y);
//                g.drawOval(x-20,y-10,80,80);
                break;
            default :
                System.out.println("null");
        }
    }
}
