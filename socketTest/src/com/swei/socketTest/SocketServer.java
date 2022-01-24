package com.swei.socketTest;

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
        Socket accept = null;
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        DataOutputStream dos = null;
        try {
            // 服务端使用ServerSocket套接字接收端口号
            ss = new ServerSocket(8888);
            accept = ss.accept();
            is = accept.getInputStream();
            ois = new ObjectInputStream(is);
            User user = (User) ois.readObject();
            Boolean flag = false;
            if("小姜".equals(user.getName()) && "12345".equals(user.getPwd())) {
                flag = true;
            }

            os = accept.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeBoolean(flag);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(os != null) {
                    os.close();
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
                if(ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(accept != null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ss != null) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
