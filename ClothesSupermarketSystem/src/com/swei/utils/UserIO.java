package com.swei.utils;

import com.swei.bean.User;

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
    public static final String USER_FILE = "user.txt";

    // 写入用户列表
    public boolean writeUsers() {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(
                    new FileOutputStream(USER_FILE));
            stream.writeObject(users);
            stream.close();
        } catch (IOException e) {
            throw new BusinessException("io.write.error");
        }
        return true;
    }

    // 读取用户列表
    public boolean readusers() {
        try {
            ObjectInputStream stream = new ObjectInputStream(
                    new FileInputStream(USER_FILE));
            users = (List<User>) stream.readObject();
            stream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new BusinessException("io.read.error");
        }
        return true;
    }

    public void add(User user) {
        users.add(user);
    }
}
