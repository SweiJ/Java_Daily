package com.swei.utils;

import com.swei.bean.User;
import netscape.security.UserTarget;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 20:37
 */
public class UserIO {
    public static List<User> users = new ArrayList<>();
    public static final String USER_FILE1 = "user.txt";
    public static final String USER_FILE2 = "user.obj";

    // 写入用户列表
    public void writeUsers() {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(
                    new FileOutputStream(USER_FILE1));
            for (int i = 0; i < users.size(); i++) {
                stream.writeObject(users.get(i) + "\r\n");
            }
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new BusinessException("io.write.error");
        }
    }

    // 读取用户列表
    public void readUsers() {
        try {
            ObjectInputStream stream = new ObjectInputStream(
                    new FileInputStream(USER_FILE1));
            User userTemp;
            while((userTemp = (User) stream.readObject()) != null) {
                users.add(userTemp);
            }
            stream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new BusinessException("io.read.error");
        }
    }

    public void add(User user) {
        users.add(user);
    }

    public User userIsTrue(String name, String password) {
        for (int i = 0; i < users.size(); i++) {
            if(name.equals(users.get(i).getName()) &&
                    password.equals(users.get(i).getPassword())) {
                return users.get(i);
            }
        }
        return null;
    }
}
