package com.xxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-03
 * Time: 16:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static ResBean success(String message) {
        return new ResBean(200, message, null);
    }

    /**
     * 成功返回
     * @param message
     * @param obj
     * @return
     */
    public static ResBean success(String message, Object obj) {
        return new ResBean(200, message, obj);
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public static ResBean error(String message) {
        return new ResBean(500, message, null);
    }

    /**
     * 失败返回
     * @param message
     * @param obj
     * @return
     */
    public static ResBean error(String message, Object obj) {
        return new ResBean(500, message, obj);
    }
}
