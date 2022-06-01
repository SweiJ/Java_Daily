package com.swei.secsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-29
 * Time: 15:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static Res success(String message) {
        return new Res(200, message, null);
    }

    /**
     * 成功返回
     * @param message
     * @param obj
     * @return
     */
    public static Res success(String message, Object obj) {
        return new Res(200, message, obj);
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public static Res error(String message) {
        return new Res(500, message, null);
    }

    /**
     * 失败返回
     * @param message
     * @param obj
     * @return
     */
    public static Res error(String message, Object obj) {
        return new Res(500, message, obj);
    }
}