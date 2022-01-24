package com.swei.socketthread;

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
            socket = new Socket("SweiPC", 8888);
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(new User(name, pwd));

            is = socket.getInputStream();
           dis = new DataInputStream(is);
            if(dis.readBoolean()) {
                System.out.println("µÇÂ½³É¹¦£¡");
            } else {
                System.out.println("µÇÂ½Ê§°Ü£¡");
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
