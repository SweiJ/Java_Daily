package com.swei.ui;

import com.swei.bean.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 13:52
 */
public class Welcome extends BaseClass {
    public void start() {
        System.out.println(getR("info.welcome"));
        System.out.println(getR("info.login.reg"));
        System.out.println(getR("info.select"));
        int num;
        while((num = input.nextInt()) != 0) {
            input.nextLine();
            switch (num) {
                case 1 :
                    User login = new Login().login();
                    getR("login.success");
                    System.out.println("欢迎: " + login.getName());
                    break;
                case 2 :
                    // 注册
                    new Register().register();
                    System.out.println("reg.success");
                    break;
                default:
                    System.out.println(getR("input.error"));
                    break;
            }
        }
    }
}
