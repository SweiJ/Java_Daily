package com.swei.udpsocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-23
 * Time: 8:44
 */
public class SocketUDPSend {
    public static void main(String[] args) {
        System.out.println("A上线了！");
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("A: ");
                // 发送方发送数据
                String str = scanner.nextLine();
                byte[] bytes = str.getBytes();
                /**
                 * 1、字节数组
                 * 2、数组的长度
                 * 3、接收方的IP
                 * 4、接收方的端口号
                 */
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("SweiPC"), 9999);
                ds.send(dp);
                if("bye".equals(str)) {
                    System.out.println("A下线了！");
                    break;
                }
                // 发送方接收数据
                byte[] b = new byte[1024];
                DatagramPacket dp2 = new DatagramPacket(b, b.length);
                // 接收数据
                ds.receive(dp2);
                byte[] data = dp2.getData();
                String s = new String(data, 0, dp2.getLength());
                System.out.println("B: " + s);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
}
