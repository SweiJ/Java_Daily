package com.swei.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-26
 * Time: 20:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res {
    private long code;
    private String message;
    private Object o;

    public static Res success(String message) {
        return new Res(200, message, null);
    }

    public static Res success(String message, Object o) {
        return new Res(200, message, o);
    }

    public static Res error(String message) {
        return new Res(500, message, null);
    }

    public static Res error(String message, Object o) {
        return new Res(500, message, o);
    }
}
