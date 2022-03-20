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
        Boolean exit = true;
        int num = input.nextInt();
        input.nextLine();
        while(exit) {
            switch (num) {
                case 1 :

                    exit = false;
                    break;
                case 2 :
                    exit = false;
                    // 注册
                    new Register().register();
                    System.out.println("reg.success");
                    break;
                case 0 :
                    exit = false;
                    break;
                default:
                    System.out.println(getR("input.error"));
                    break;
            }
        }
    }
}
