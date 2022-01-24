package com.swei.udpsocket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-23
 * Time: 8:45
 */
public class SocketUDPRecive {
    public static void main(String[] args) {
        System.out.println("B�����ˣ�");
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9999);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                byte[] b = new byte[1024];
                DatagramPacket dp = new DatagramPacket(b, b.length);
                // ���ն˽�������
                ds.receive(dp);
                // ������ת�����ֽ�����
                byte[] data = dp.getData();
                String s = new String(data, 0, dp.getLength());
                System.out.println("A: " + s);
                if("bye".equals(s)) {
                    System.out.println("B�����ˣ�");
                    break;
                }

                System.out.print("B: ");
                // ���շ���������
                String str = scanner.nextLine();
                byte[] bytes = str.getBytes();
                DatagramPacket dp2 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("SweiPC"), 8888);
                ds.send(dp2);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}
