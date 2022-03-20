package com.swei.ui;

import com.swei.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 13:43
 */
public abstract class BaseClass {

    public static Scanner input = new Scanner(System.in);;
    private static User currentUser;
    private static ResourceBundle r = ResourceBundle.getBundle("com/swei/res/r_temp");

    public static String getR(String key) {
        return r.getString(key);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        BaseClass.currentUser = currentUser;
    }
}
