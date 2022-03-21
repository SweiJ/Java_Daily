package com.swei.utils;

import com.swei.ui.BaseClass;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 20:30
 */
public class BusinessException extends RuntimeException {
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(BaseClass.getR(message));
    }
}
