package com.swei.socketTest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-22
 * Time: 21:33
 */
public class SocketClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String pwd = scanner.next();

        Socket socket = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        InputStream is = null;
        DataInputStream dis = null;
        try {
            // 客户端使用socket套接字接收主机ip和端口号
            socket = new Socket("SweiPC", 8888);
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(new User(name, pwd));

            is = socket.getInputStream();
            dis = new DataInputStream(is);
            if(dis.readBoolean()) {
                System.out.println("登陆成功！");
            } else {
                System.out.println("登陆失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
