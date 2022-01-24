package com.swei.socketthread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-22
 * Time: 21:33
 */
public class SocketServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        int count = 0;
        try {
            ss = new ServerSocket(8888);
            while(true) {
                s = ss.accept();
                new SocketThreadTest(s).start();
                count++;
                System.out.println("��" + count + "���û����ʷ�����" + s.getInetAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
