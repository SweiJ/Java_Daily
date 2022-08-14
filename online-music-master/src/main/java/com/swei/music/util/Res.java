package com.swei.music.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:40
 */
@Data
@AllArgsConstructor
public class Res <T>{
    private int status;
    private String message;
    private T data;
}
