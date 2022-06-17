package com.xxxx.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Description: 返回结果枚举
 * User: SweiPC
 * Date: 2022-06-15
 * Time: 10:27
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {

    // 通用异常
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),

    // 登录异常
    LOGIN_ERROR(500210,"用户名或密码不正确"),

    // 手机号校验
    MOBILE_ERROR(500211, "手机号码格式不正确"),

    // 参数校验
    BIND_ERROR(500212, "参数校验异常"),

    MOBILE_NOT_EXIST(500213, "手机号码不存在"),

    PASSWORD_UPDATE_FAIL(500214, "更新密码失败"),

    // 秒杀 5005xx
    EMPTY_STOCK(500500, "存库不足"),

    REPEATE_ERROR(500501, "该商品没人限购一件"),
    ;

    private final Integer code;
    private final String message;
}
