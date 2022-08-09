package com.swei.music.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 21:26
 */
public class BCryptTest {
    public static void main(String[] args) {
        String password = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // 通过encode方法对密码进行加密
        String newPassword = bCryptPasswordEncoder.encode(password);
        System.out.println("加密密码为: " + newPassword);

        boolean same_password_result = bCryptPasswordEncoder.matches(password, newPassword);
        System.out.println("加密的密码和正确密码对比结果: " + same_password_result);

        boolean other_password_result = bCryptPasswordEncoder.matches("987654", newPassword);
        System.out.println("加密的密码和错误的密码对比结果: " + other_password_result);
    }
}
