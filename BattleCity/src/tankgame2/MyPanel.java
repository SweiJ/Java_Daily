package tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-07
 * Time: 16:47
 */
@SuppressWarnings("all")
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // �����Լ���̹��
    MyHero myHero = null;

    // ���˵�̹��
    Vector<EmemyTank> ememyTanks = new Vector<>();
    int enemyRankSize = 3;

    // ��ʼ�����
    public MyPanel() {
        // ����ҷ�̹�˺��ӵ�
        myHero = new MyHero(500, 500);

        // �������̹��
        for (int i = 0; i < enemyRankSize; i++) {
            EmemyTank ememyTank = new EmemyTank(100+i*100,0);
            ememyTanks.add(ememyTank);
            ememyTank.setDirect(1); // ��̹�˵ķ�������
            new Thread(ememyTank).start();
            // ÿ��̹�����һ���ӵ�
//            ememyTank.ememyBullet.add(new Bullet(ememyTank.getX() + 15, ememyTank.getY() + 40, ememyTank.getDirect()));
        }
        // ̹�˷����ӵ����ӵ������߳�
        emeyfire_bullet();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        myHero.setSpeed(10);
        // �ҷ�̹��ͼ
        if(myHero != null && myHero.isLive) {
            paintTank(myHero.getX(), myHero.getY(), g, myHero.getDirect(), 1);
        } else {

        }
        // �ҷ��ӵ�ͼ
        for (int i = 0; i < myHero.myHeroBullet.size(); i++) {
            Bullet myBullet = myHero.myHeroBullet.get(i);
            if(myBullet != null && myBullet.is_inBound) {
                g.fillOval(myBullet.x, myBullet.y, 10, 10);
            } else {
                myHero.myHeroBullet.remove(myBullet);
            }
        }

        // �з�̹��ͼ
        for (int i = 0; i < ememyTanks.size(); i++) {
            EmemyTank ememy = ememyTanks.get(i);
            if(ememy.isLive) {
                paintTank(ememy.getX(), ememy.getY(), g, ememy.getDirect(), 0);
                // �з��ӵ�ͼ
                for (int j = 0; j < ememy.ememyBullet.size(); j++) {
                    if(ememyTanks.get(i).ememyBullet.get(j).is_inBound && ememyTanks.get(i).ememyBullet.size() < 2) {
                        emeyfire_bullet();
                    }

                    Bullet ememyBullet = ememy.ememyBullet.get(j);
                    if (ememyBullet != null && ememyBullet.is_inBound) {
                        g.fillOval(ememyBullet.x, ememyBullet.y, 10, 10);
                    } else {
                        ememy.ememyBullet.remove(ememyBullet);
                    }
                }
            } else {
                ememyTanks.remove(i);
            }
        }
    }
    public void myfire_bullet() {
        if(myHero.myHeroBullet.size() > 5) {
            return;
        }
        Bullet myBullet = direct(myHero);

        myHero.myHeroBullet.add(myBullet);
        new Thread(myBullet).start();
    }
    public void emeyfire_bullet() {
        for (int i = 0; i < ememyTanks.size(); i++) {
            EmemyTank ememytank = ememyTanks.get(i);
            // ���ݷ���ȷ���ӵ�λ��
            Bullet ememybullet = direct(ememytank);

            // װ��
            ememytank.ememyBullet.add(ememybullet);
            for (int j = 0; j < ememytank.ememyBullet.size(); j++) {
                new Thread(ememytank.ememyBullet.get(j)).start();
            }
        }
    }
    public Bullet direct(Tank tank) {
        Bullet bullet = null;
        switch (tank.getDirect()) {
            case 0 :
                bullet = new Bullet(tank.getX() +15, tank.getY() + 10, tank.getDirect());
                break;
            case 1 :
                bullet = new Bullet(tank.getX() + 15, tank.getY() + 40, tank.getDirect());
                break;
            case 2 :
                bullet = new Bullet(tank.getX() + 10, tank.getY() +15, tank.getDirect());
                break;
            case 3 :
                bullet = new Bullet(tank.getX() + 40, tank.getY() + 15, tank.getDirect());
                break;
            default:
                System.out.println("����");
                break;
        }
        return bullet;
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
                g.fill3DRect(x, y, 10, 60, false); // ������
                g.fill3DRect(x+10, y+20, 20, 30, false); // ������
                g.fill3DRect(x+30, y, 10,60, false); // ������
                g.fillOval(x+10,y+20,20,20); // Բ
//                g.drawLine(x+15,y+20,x+15,y);
//                g.drawLine(x+25,y+20,x+25,y);
                g.drawLine(x+25,y+20,x+25,y-5); // �ܵ�
                g.drawLine(x+15,y+20,x+15,y-5);
//                g.drawOval(x-20,y-10,80,80);
                break;
            case 1 : // ����
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x+10, y+10, 20, 30, false);
                g.fill3DRect(x+30, y, 10,60, false);
                g.fillOval(x+10,y+20,20,20);
//                g.drawLine(x+15,y+20,x+15,y);
//                g.drawLine(x+25,y+20,x+25,y);
                g.drawLine(x+25,y+40,x+25,y+65); // �ܵ�
                g.drawLine(x+15,y+40,x+15,y+65);
//                g.drawOval(x-20,y-10,80,80);
                break;
            case 2 : // ����
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x+20, y+10, 30, 20, false);
                g.fill3DRect(x, y+30, 60,10, false);
                g.fillOval(x+20,y+10,20,20);
//                g.drawLine(x+15,y+20,x+15,y);
//                g.drawLine(x+25,y+20,x+25,y);
                g.drawLine(x-5,y+15,x+20,y+15);
                g.drawLine(x-5,y+25,x+20,y+25);
//                g.drawOval(x-20,y-10,80,80);
                break;
            case 3 : // ����
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x+10, y+10, 30, 20, false);
                g.fill3DRect(x, y+30, 60,10, false);
                g.fillOval(x+20,y+10,20,20);
//                g.drawLine(x+15,y+20,x+15,y);
//                g.drawLine(x+25,y+20,x+25,y);
                g.drawLine(x+40,y+15,x+65,y+15);
                g.drawLine(x+40,y+25,x+65,y+25);
//                g.drawOval(x-20,y-10,80,80);
                break;
            default :
                System.out.println("null");
        }
    }
    public static void hitTank(Bullet bullet, Tank tank) {
        switch (tank.getDirect()) {
            case 0 :
            case 1 :
                if(bullet.x > tank.getX() && bullet.x < tank.getX() + 40
                && bullet.y > tank.getY() && bullet.y < tank.getY() + 60) {
                    bullet.is_inBound = false;
                    tank.isLive = false;
                }
                break;
            case 2 :
            case 3 :
                if(bullet.x > tank.getX() && bullet.x < tank.getX() + 60
                && bullet.y > tank.getY() && bullet.y < tank.getY() + 40) {
                    bullet.is_inBound = false;
                    tank.isLive = false;
                }
                break;
        }
    }
    public void hitHreoTank () {
        for (int i = 0; i < ememyTanks.size(); i++) {
            EmemyTank ememyTank = ememyTanks.get(i);
            for (int j = 0; j < ememyTank.ememyBullet.size(); j++) {
                Bullet ememyBullet = ememyTank.ememyBullet.get(j);
                if(myHero.isLive && ememyBullet.is_inBound) {
                    hitTank(ememyBullet, myHero);
                }
            }
        }
    }
    public void hitEmemyTank() {
        for (int i = 0; i < myHero.myHeroBullet.size(); i++) {
            Bullet myBullet = myHero.myHeroBullet.get(i);
            for (int j = 0; j < ememyTanks.size(); j++) {
                EmemyTank ememyTank = ememyTanks.get(j);
                hitTank(myBullet, ememyTank);
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_UP) {
            myHero.setDirect(0);
            myHero.move_Up();
        }
        if(e.getKeyCode() == e.VK_DOWN) {
            myHero.setDirect(1);
            myHero.move_Down();
        }
        if(e.getKeyCode() == e.VK_RIGHT) {
            myHero.setDirect(3);
            myHero.move_Right();
        }
        if(e.getKeyCode() == e.VK_LEFT) {
            myHero.setDirect(2);
            myHero.move_Left();
        }

        if(e.getKeyCode() == e.VK_J) {
            myfire_bullet();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitHreoTank();
            hitEmemyTank();
            this.repaint();
        }
    }
}