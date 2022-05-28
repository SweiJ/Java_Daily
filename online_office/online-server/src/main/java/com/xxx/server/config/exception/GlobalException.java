package com.xxx.server.config.exception;

import com.xxx.server.pojo.ResBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-08
 * Time: 17:12
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public ResBean mySqlException(SQLException e) {
        if(e instanceof SQLIntegrityConstraintViolationException) {
            return ResBean.error("该数据有关联数据, 操作失败!");
        }
        return ResBean.error("数据库异常, 操作失败!");
    }
}
