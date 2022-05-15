package com.swei.summitexam.model;

import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-14
 * Time: 10:26
 */
@Data
public class UserParam {
    private String userName;
    private String oldpwd;
    private String newpwd;
    private String newpwd2;
}
