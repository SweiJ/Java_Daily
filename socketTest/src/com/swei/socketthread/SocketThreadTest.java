package com.swei.socketthread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-22
 * Time: 22:18
 */
public class SocketThreadTest extends Thread {
    Socket s = null;
    InputStream is = null;
    ObjectInputStream ois = null;
    OutputStream os = null;
    DataOutputStream dos = null;

    public SocketThreadTest(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            is = s.getInputStream();
            ois = new ObjectInputStream(is);
            User user = (User) ois.readObject();
            Boolean flag = false;
            if("Ð¡½ª".equals(user.getName()) && "12345".equals(user.getPwd())) {
                flag = true;
            }

            os = s.getOutputStream();
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
                if(s != null) {
                    s.close();
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
        }
    }
}
